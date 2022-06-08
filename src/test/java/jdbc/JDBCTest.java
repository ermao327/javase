package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:0519/choose" +
                    "?userSSL=false&" +
                    "useUnicode=true&characterEncoding=UTF8&" +
                    "serverTimezone=GMT%2B8";
            //jdbc:mysql://localhost:3306/choose?userSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT%2B8
            conn = DriverManager.getConnection(url, "root", "123123");
//            insert(conn);
            selectOne(conn);
            conn.setAutoCommit(false);//关闭自动提交 开启事务

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void selectOne(Connection conn) throws SQLException {
        System.out.println("输入id");
        final Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        String selectOne = "select * from student where id=?";
        PreparedStatement pstmt = conn.prepareStatement(selectOne);
        pstmt.setInt(1, a);
        final ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next()){
            final int id = resultSet.getInt("id");
            final String name = resultSet.getString("name");
            final Date birthday = resultSet.getDate("birthday");
            final String sex = resultSet.getString("sex");
            final int age = resultSet.getInt("age");
            final double height = resultSet.getDouble("height");
            final int tid = resultSet.getInt("tid");
            System.out.println(id+","+name+","+birthday+","+sex+","+age+","+height+","+tid);
        }
    }

    public static void selectAll(Connection conn) throws SQLException {
        String selectAll = "select * from student";
        PreparedStatement pstmt = conn.prepareStatement(selectAll);
        final ResultSet resultSet = pstmt.executeQuery();
        while(resultSet.next()){
            final int id = resultSet.getInt("id");
            final String name = resultSet.getString("name");
            final Date birthday = resultSet.getDate("birthday");
            final String sex = resultSet.getString("sex");
            final int age = resultSet.getInt("age");
            final double height = resultSet.getDouble("height");
            final int tid = resultSet.getInt("tid");
            System.out.println(id+","+name+","+birthday+","+sex+","+age+","+height+","+tid);
        }
    }

    public static void delete(Connection conn) throws SQLException {
        String delete = "delete from student where id=?";
        PreparedStatement pstmt = conn.prepareStatement(delete);
        pstmt.setObject(1, 15);
        pstmt.executeUpdate();
    }

    public static void update(Connection conn) throws SQLException {
        String update = "update student " +
                "set name=?,birthday=?,sex=?,age=?,height=?,tid=? " +
                "where id=?";
        PreparedStatement pstmt = conn.prepareStatement(update);
        pstmt.setString(1, "KKK");
        //不是java.util.Date 而是java.sql.Date
        pstmt.setDate(2, Date.valueOf("1990-12-12"));
        pstmt.setString(3, "f");
        pstmt.setInt(4, 20);
        pstmt.setDouble(5, 210.5);
        pstmt.setObject(6, null);
        pstmt.setObject(7, 15);
        pstmt.executeUpdate();
    }

    public  static  void insert(Connection conn) throws SQLException {
        //不安全，被sql注入
//            String insert ="insert  into student values (null ,'abc'," +
//                    "'2022-12-01','m',20,185.2,null )";
//            final Statement stmt = conn.createStatement();
//            final int result = stmt.executeUpdate(insert);

        //安全，预编译的
        String insert = "insert into student values (?,?,?,?,?,?,?)";
        final PreparedStatement pstmt = conn.prepareStatement(insert);
        pstmt.setObject(1, null);////不知道什么类型，可以直接写成setObject
        pstmt.setString(2, "abc");
        //不是java.util.Date 而是java.sql.Date
        pstmt.setDate(3, Date.valueOf("2000-11-23"));
        pstmt.setString(4, "m");
        pstmt.setInt(5, 20);
        pstmt.setDouble(6, 183.2);
        pstmt.setObject(7, null);
        pstmt.executeUpdate();
    }
}
