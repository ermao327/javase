package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO 数据访问对象
 */
public class StudentDao {

    public void addOne(Student student){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:0519/choose" +
                    "?userSSL=false&useUnicode=true&characterEncoding=UTF8" +
                    "&serverTimezone=GMT%2B8";
            conn = DriverManager.getConnection(url,"root","123123");
            String insert = "insert into student values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setObject(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setDate(3, new Date(student.getBirthday().getTime()));
            pstmt.setString(4, student.getSex());
            pstmt.setInt(5, student.getAge());
            pstmt.setDouble(6, student.getHeight());
            pstmt.setObject(7, student.getTid());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(null != conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<Student> queryAll(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:0519/choose" +
                    "?userSSL=false&useUnicode=true&characterEncoding=UTF8" +
                    "&serverTimezone=GMT%2B8";
            conn = DriverManager.getConnection(url,"root","123123");
            String selectAll = "select * from student";
            PreparedStatement pstmt = conn.prepareStatement(selectAll);
            final ResultSet resultSet = pstmt.executeQuery();
            List<Student> list = new ArrayList<>();
            while(resultSet.next()){
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                final Date birthday = resultSet.getDate("birthday");
                final String sex = resultSet.getString("sex");
                final int age = resultSet.getInt("age");
                final double height = resultSet.getDouble("height");
                final int tid = resultSet.getInt("tid");
                list.add(new Student(id, name, birthday, sex, age, height, tid));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            if(null != conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Student student = new Student(null, "uuu", new java.util.Date(), "m", 0, 1.0, 10);
        StudentDao studentDao = new StudentDao();
//        studentDao.addOne(student);
        final List<Student> students = studentDao.queryAll();
        System.out.println(students);
    }
}
