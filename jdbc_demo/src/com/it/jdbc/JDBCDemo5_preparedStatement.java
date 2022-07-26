package com.it.jdbc;
import java.sql.*;

//JDBE introduction
public class JDBCDemo5_preparedStatement {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db1";
        String password = "yan010902";
        String userName = "Yan";
        Connection conn = DriverManager.getConnection(url, userName, password);
        String name = "jack";
        String pwd = "1111";
        String sql = "select * from user_login where name = ? and password = ?";
        PreparedStatement preState = conn.prepareStatement(sql);
        preState.setString(1, name);
        preState.setString(2, pwd);
        ResultSet rs = preState.executeQuery();
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登陆失败");
        }
        preState.close();
        conn.close();
    }
}
