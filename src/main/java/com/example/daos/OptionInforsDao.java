package com.example.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.commons.Common;

public class OptionInforsDao {
    public ArrayList selectAll() {
        ArrayList arrayList = new ArrayList<>();
        try {
            Common common = new Common();
            Statement statement = common.getStatement();

            String query = "SELECT * FROM option_infors";
            ResultSet resultSet = statement.executeQuery(query);
            HashMap optionHashMap = new HashMap<>();

            while (resultSet.next()) {
                optionHashMap = new HashMap<>();
                optionHashMap.put("OPTION_INFOR_ID", resultSet.getString("OPTION_INFOR_ID01"));
                optionHashMap.put("OPTION_NAME", resultSet.getString("OPTION_NAME"));
                arrayList.add(optionHashMap);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
