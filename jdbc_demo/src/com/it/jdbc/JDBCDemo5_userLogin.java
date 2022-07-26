package com.it.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBE introduction
public class JDBCDemo5_userLogin {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db1";
        String password = "yan010902";
        String userName = "Yan";
        Connection conn = DriverManager.getConnection(url, userName, password);
        String name = "";
        String pwd = "";
        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery(sql);
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登陆失败");
        }
//        state.close();
//        conn.close();
    }
}
