package com.it.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBE connection
public class JDBCDemo2_connection {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false"; //default port shorten as jdbc:mysql:///db1, you can ban ssl use by set useSSL=false
        String password = "yan010902";
        String userName = "Yan";
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql1 = "update tb_user set money=2000 where id=1";
        String sql2 = "update tb_user set money=5000 where id=1";
        Statement state = conn.createStatement();
        // start transction
        try {
            conn.setAutoCommit(false);
            int i = 3/0;
            int count1 = state.executeUpdate(sql1); // affected rows
            System.out.println(count1);
            int count2 = state.executeUpdate(sql2); // affected rows
            System.out.println(count2);
            conn.commit();
        } catch (Exception e) {
            // rollback transction
            conn.rollback();
            throw new RuntimeException(e);
        }

        // commit transction
        state.close();
        conn.close();
    }
}
