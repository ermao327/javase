package ebookstore.util;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * 要求对象的属性名和表里的字段名一致
 */
public class JDBCUtil {

    private String driver;
    private String url;
    private String username;
    private String password;

    public JDBCUtil()  {
        try {
            final Properties properties = new Properties();
            properties.load(new FileReader("db.properties"));
            this.driver = properties.getProperty("driver");
            this.url = properties.getProperty("url");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("配置文件加载失败");
        }
    }

    private Connection conn() throws ClassNotFoundException, SQLException {
        Class.forName(this.driver);
        return DriverManager.getConnection(this.url, this.username, this.password);
    }

    private JDBCType javaToSql(Class javaType) throws SQLException {
        if(javaType.equals(int.class) || javaType.equals(Integer.class))
            return JDBCType.INTEGER;
        if(javaType.equals(long.class) || javaType.equals(Long.class))
            return JDBCType.BIGINT;
        if(javaType.equals(short.class) || javaType.equals(Short.class))
            return JDBCType.SMALLINT;
        if(javaType.equals(double.class) || javaType.equals(Double.class)
                || javaType.equals(float.class)  || javaType.equals(Float.class))
            return JDBCType.DECIMAL;
        if(javaType.equals(String.class))
            return JDBCType.VARCHAR;
        if(javaType.equals(Date.class) ||
                javaType.equals(java.util.Date.class) || javaType.equals(java.time.LocalDate.class))
            return JDBCType.DATE;
        throw  new SQLException("暂不支持该类型:"+javaType);
    }


    /**
     * 负责增删改数据库
     */
    public void update(String sql,Object... args) throws SQLException, ClassNotFoundException {
        try(final Connection conn = conn()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                System.out.println("args="+args[i]);
                if(null == args[i]){
                    pstmt.setObject(i + 1, null);
                }else {
                    pstmt.setObject(i + 1, args[i], javaToSql(args[i].getClass()));
                }
            }
            pstmt.executeUpdate();
        }
    }

    public <T> List<T> queryMany(String sql,Class<T> clazz,Object ...args) throws Exception {
        try(final Connection conn = conn()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                if (null == args[i]) {
                    pstmt.setObject(i + 1, null);
                } else {
                    pstmt.setObject(i + 1, args[i], javaToSql(args[i].getClass()));
                }
            }
            final ResultSet rs = pstmt.executeQuery();
            List<T> list = new ArrayList<>();
            final Constructor<T> constructor = clazz.getConstructor();
            final Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                final T t = constructor.newInstance();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Class fieldType = field.getType();
                    final Object value = rs.getObject(fieldName,
                            fieldType.equals(java.util.Date.class) ? Date.class : fieldType);
                    String setterMethodName = "set" + fieldName.substring(0, 1).toUpperCase() +
                            fieldName.substring(1);
                    Method setterMethod = clazz.getMethod(setterMethodName, fieldType);
                    setterMethod.invoke(t, value);
                }
                list.add(t);
            }
            return list;
        }
    }

    public <T> T queryOne(String sql,Class<T> clazz,Object ...args) throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try(final Connection conn = conn()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                if(null == args[i]){
                    pstmt.setObject(i + 1, null);
                }else {
                    pstmt.setObject(i + 1, args[i], javaToSql(args[i].getClass()));
                }
            }
            final ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                final Constructor<T> constructor = clazz.getConstructor();
                final T t = constructor.newInstance();
                final Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    Class fieldType = field.getType();
                    final Object value = rs.getObject(fieldName,
                            fieldType.equals(java.util.Date.class) ? Date.class : fieldType);
                    String setterMethodName = "set"+fieldName.substring(0, 1).toUpperCase()+
                            fieldName.substring(1);
                    Method setterMethod = clazz.getMethod(setterMethodName, fieldType);
                    setterMethod.invoke(t, value);
                }
                return t;
            }
                return null;
        }
    }





}
