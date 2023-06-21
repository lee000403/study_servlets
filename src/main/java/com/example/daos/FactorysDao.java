package com.example.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.Commons;

public class FactorysDao {
    public ArrayList selectAll() {
        ArrayList arraylist = new ArrayList();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();

            String query = " SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); // 결과값 리턴 , selct만 resulset으로 받음(select 테이블 형식으로 나오니깐)
            HashMap<String, String> hashMap = new HashMap<String, String>();
            // 컨텐츠 증가
        
            while (resultSet.next()) {
                hashMap = new HashMap();
                hashMap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                hashMap.put("COMPANY", resultSet.getString("COMPANY"));
                arraylist.add(hashMap);
            }
        } catch (Exception e) {

        }
        return arraylist;
    }
}
