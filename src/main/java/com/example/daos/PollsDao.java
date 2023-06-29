package com.example.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.commons.Common;
import com.example.study_servlets.Commons;

public class PollsDao {
    public int Insert(HashMap<String, Object> map){
        int count = 0;
        try {
            Common common = new Common();
            Statement statement = common.getStatement(); // Editor in Workbanch
            String query = "INSERT INTO statistics\n" + //
                    "(STATISTICS_ID, RESPONDENTS_ID, QUESTIONS_ID, CHOICE_ID)\n" + //
                    "values\n" ;
            //print map
            int loop = 1;
            String userId = "R1"; //from session
            for(String key : map.keySet()){ //key들의 집합만 가져올 수 있음. for each를 돌면서 key를 던져줌
                String uuid = common.Commons();
                if(loop > 1){ // 2번째부터 쉼표를 추가하는  
                    query = query +", "; 
                }  
                query = query + "('"+uuid+"', '"+userId+"', '"+key+"', '"+map.get(key)+"')\n" ;
                System.out.print( key+", "+map.get(key));  //key의 value = map.get(key)
                loop = loop + 1 ;
            } 
            query = query + ";";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search) {
        ArrayList InforList = new ArrayList<>();
        try {
            Common common = new Common();
            Statement statement = common.getStatement(); // Editor in Workbanch
            String query = "SELECT T_QC.QUESTIONS_ID, T_QC.CHOICE_ID, T_Q.QUESTIONS, T_C.CHOICE\n" + //
                    "FROM question_choice AS T_QC\n" + //
                    "\tINNER JOIN questions AS T_Q\n" + //
                    "    ON T_QC.QUESTIONS_ID = T_Q.QUESTIONS_ID\n" + //
                    "    INNER JOIN choice AS T_C\n" + //
                    "    ON T_QC.CHOICE_ID = T_C.CHOICE_ID\n" + //
                    "ORDER BY T_QC.QUESTIONS_ID, T_QC.CHOICE_ID\n" + //
                    ";";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap InforRecord = new HashMap<>();
            //DB에서 갖고 온 값들
            while (resultSet.next()) {
                InforRecord = new HashMap<>();
                InforRecord.put("QUESTIONS_ID", resultSet.getString("QUESTIONS_ID"));
                InforRecord.put("CHOICE_ID", resultSet.getString("CHOICE_ID"));
                InforRecord.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                InforRecord.put("CHOICE", resultSet.getString("CHOICE"));

                InforList.add(InforRecord);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return InforList;
    }
}
