package com.it.jdbc_practice;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.it.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class brand_test {
    public static void main(String[] args) throws Exception{
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc_demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        String sql = "select * from tb_brand";
        PreparedStatement prep = conn.prepareStatement(sql);
        ResultSet result =  prep.executeQuery();
        List<Brand> list = new ArrayList<>();
        Brand brand = null;
        while(result.next()){
            int id = result.getInt("id");
            String brandName = result.getString("brand_name");
            String company_name = result.getString("company_name");
            int ordered = result.getInt("ordered");
            int status = result.getInt("status");
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(company_name);
            brand.setOrdered(ordered);
            brand.setStatus(status);
            list.add(brand);
        }
        System.out.println(list);
        result.close();
        prep.close();
        conn.close();
    }
}
