package com.example.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.commons.Common;

public class OptionInforsDao2 {
    public ArrayList SelectWithSearch(String search) { // 리턴값은 ArrayList
        ArrayList optionInforList = new ArrayList<>(); //범위때문에 에러가 나서 try 위로 뽑아냄
        try {
            
            // 빈값이 들어오면 아무것도 안나오게금 
            if(search== null) 
                search = "";

            // DB에서 terminal로 데이터 가져오는 코드
            Common common = new Common();
            Statement statement = common.getStatement(); // Editor in Workbanch
            String query = "SELECT *\n" + //
                    "FROM option_infors\n" + //
                    "where OPTION_NAME like '"+search+"%';";
            ResultSet resultSet = statement.executeQuery(query); // query 실행

            HashMap optionInforRecord = new HashMap<>();
            while (resultSet.next()) {
                optionInforRecord = new HashMap<>();
                optionInforRecord.put("OPTION_INFOR_ID", resultSet.getString("OPTION_INFOR_ID"));
                optionInforRecord.put("OPTION_NAME", resultSet.getString("OPTION_NAME"));
                
                optionInforList.add(optionInforRecord); //해쉬맵에 담은거를 리스트에 담음, 뽑을때는 리스트를뽑으면서 해쉬맵으로 출력
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInforList; //리턴 데이턴타입은 리스트이기때문에 optionInforList
    }
}
