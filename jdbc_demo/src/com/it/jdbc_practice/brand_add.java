package com.it.jdbc_practice;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class brand_add {
    public static void main(String[] args) throws Exception {
        String brandName = "Meta";
        String companyName = "Facebook";
        int ordered = 0;
        int status = 0;
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        String sql = "insert into tb_brand (brand_name, company_name, ordered, status) values(?, ?, ?, ?)";
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1, brandName);
        prep.setString(2, companyName);
        prep.setInt(3, ordered);
        prep.setInt(4, status);
        int count = prep.executeUpdate();
        System.out.println(count>0);
        prep.close();
        conn.close();
    }
}
