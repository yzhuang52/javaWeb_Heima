package com.it.jdbc;
import com.it.pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//JDBE introduction
public class JDBCDemo4_querySet {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///db1?useSSL=false"; //default port shorten as jdbc:mysql:///db1, you can ban ssl use by set useSSL=false
        String password = "yan010902";
        String userName = "Yan";
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql = "select * from tb_user";
        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery(sql); // affected rows
        List<Account> list = new ArrayList<>();
        while (res.next()){
            Account account = new Account();
            int id = res.getInt(1);
            String name = res.getString(2);
            int money = res.getInt(3);
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            list.add(account);
        }
        System.out.println(list);
        res.close();
        state.close();
        conn.close();
    }
}
