package com.example.study_servlets.controlls;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.commons.Common;

@WebServlet(urlPatterns = "/CarInforsServlet")
public class CarInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Common common = new Common();
            String uuid = common.Commons();
            String url = "jdbc:mysql://192.168.0.166:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM db_cars.car_infors;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + ", " + resultSet.getString("YEAR") + ", "
                        + resultSet.getString("CAR_INFOR_ID") + ", " + resultSet.getString("COMPANY_ID"));
            }

            query = "insert into car_infors\n" + //
                    "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
                    "values\n" + //
                    "('아반떼', '2021', '" + uuid + "', 'C001')";
            int count = statement.executeUpdate(query);

            System.out.println("------------------- 적용 후 ------------------");

            query = "SELECT * FROM db_cars.car_infors;";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + ", " + resultSet.getString("YEAR") + ", "
                        + resultSet.getString("CAR_INFOR_ID") + ", " + resultSet.getString("COMPANY_ID"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
