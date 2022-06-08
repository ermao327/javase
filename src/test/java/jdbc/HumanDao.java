package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HumanDao {
    public static void main(String[] args) {
        final HumanDao humanDao = new HumanDao();
        final List<Human> humans = humanDao.queryAll();
        System.out.println(humans);
    }

    public List<Human> queryAll(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:0519/choose" +
                    "?userSSL=false&useUnicode=true&characterEncoding=UTF8" +
                    "&serverTimezone=GMT%2B8";
            conn = DriverManager.getConnection(url,"root","123123");
            String selectAll = "select * from Humaninfo";
            PreparedStatement pstmt = conn.prepareStatement(selectAll);
            final ResultSet resultSet = pstmt.executeQuery();
            List<Human> list = new ArrayList<>();
            while(resultSet.next()){
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                final String sex = resultSet.getString("sex");
                list.add(new Human(id, name, sex));
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
}
