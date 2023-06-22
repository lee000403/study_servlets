package com.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.Commons;

public class CarInforsDao {
    public ArrayList selectAll(){
        ArrayList arrayList = new ArrayList();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String url = "jdbc:mysql://192.168.0.166:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            statement = connection.createStatement();

            String query = "SELECT * FROM db_cars.car_infors;";
            ResultSet resultSet = statement.executeQuery(query);
            HashMap hashMap = new HashMap();

            while (resultSet.next()) {
                hashMap = new HashMap();
                hashMap.put("CAR_NAME", resultSet.getString("CAR_NAME"));
                hashMap.put("YEAR", resultSet.getString("YEAR"));
                hashMap.put("CAR_INFOR_ID", resultSet.getString("CAR_INFOR_ID"));
                hashMap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                arrayList.add(hashMap);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
