package com.it.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//JDBE introduction
public class JDBCDemo3_statement {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false"; //default port shorten as jdbc:mysql:///db1, you can ban ssl use by set useSSL=false
        String password = "yan010902";
        String userName = "Yan";
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql = "update tb_user set money=2000 where id=1";
        Statement state = conn.createStatement();
        int count = state.executeUpdate(sql); // affected rows
        System.out.println(count);
        state.close();
        conn.close();
    }
}
