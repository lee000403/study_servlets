package com.example.study_servlets.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.Commons;

@WebServlet(urlPatterns ="/CarInforsServlet")
public class CarInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.166:3306/db_cars"; // 마지막은 db이름으로 "db_cars"
            // localhost도 가능하나 IP주소를 넣는게 보다 좋음

            // jdbc : java DB connetion , 'https://www.naver.com/'의 구조와 유사 / 원격으로 db_cars에 연결하는 구조를 나열

            String user = "yojulab";
            String password = "!yojulab*";

            //DB 연결
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // - query Edit
            Statement statement = connection.createStatement();

            Commons commons = new Commons();
            String statPK = commons.generateUUID();

            String query = " SELECT * FROM db_cars.car_infors;"; 
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){ 
                System.out.println(resultSet.getString("CAR_NAME")+","+resultSet.getString("YEAR")+","+resultSet.getString("CAR_INFOR_ID")+","+resultSet.getString("COMPANY_ID"));
            }

            query = " insert into car_infors\n" + //
                    "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
                    "values\n" + //
                    "('coding', '1997', '"+statPK+"', 'C005');"; 
            int count = statement.executeUpdate(query); 
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM db_cars.car_infors");
             while(resultSet2.next()){ 
                System.out.println(resultSet2.getString("CAR_NAME")+","+resultSet2.getString("YEAR")+","+resultSet2.getString("CAR_INFOR_ID")+","+resultSet2.getString("COMPANY_ID"));
            }
       
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
