package com.example.daos;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.commons.Common;

public class CarInforsDao {
    public ArrayList select_Car() {
        ArrayList arrayList = new ArrayList();
        try {
            Common common = new Common();
            Statement statement = common.getStatement();

            String query = "SELECT * FROM db_cars.car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            HashMap hashMap = new HashMap();
            while(resultSet.next()) {
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
