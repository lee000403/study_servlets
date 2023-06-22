package com.example.study_servlets.controlls;

<<<<<<< HEAD
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
>>>>>>> ce1dbb16bb746add5e250a0f87c9782f612f2085

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.commons.Common;

@WebServlet(urlPatterns = "/OptionInforsServlet")
public class OptionInforsServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest requset, HttpServletResponse response)
               throws ServletException, IOException { // response는 보내는것, request는 가져오는 것
          try {
               // DB에서 terminal로 데이터 가져오는 코드
               Common common = new Common();
               Statement statement = common.getStatement(); // Editor in Workbanch
               String query = "SELECT *\n" +
                         "FROM option_infors;";
               ResultSet resultSet = statement.executeQuery(query); // query 실행
             

               // 웹에 html 방식으로 띄어주는 것
               String contents = "<!DOCTYPE html>\r\n" + //
                         "<html lang=\"en\">\r\n" + //
                         "<head>\r\n" + //
                         "    <meta charset=\"UTF-8\">\r\n" + //
                         "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                         "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                         + //
                         "    <title>Document</title>\r\n" + //
                         "</head>\r\n" + //
                         "<body>\r\n" + //
                         "    <div class=\"container\">\r\n" + //
                         "        <table class=\"table table-bordered table-hover\">\r\n" + //
                         "            <thead>\r\n" + //
                         "                <tr>\r\n" + //
                         "                    <th>OPTION_INFOR_ID</th>\r\n" + //
                         "                    <th>OPTION_NAME</th>\r\n" + //
                         "                </tr>\r\n" + //
                         "            </thead>\r\n" + //
                         "            <tbody>\r\n";
               while (resultSet.next()) {
                    contents = contents + "                <tr>\r\n" + //
                              "                    <td>"+resultSet.getString("OPTION_INFOR_ID")+"</td>\r\n" + //
                              "                    <td>"+resultSet.getString("OPTION_NAME")+" </td>\r\n";  //;
               }
               contents = contents + " </tbody>\r\n" + //
                         "        </table>\r\n" + //
                         "    </div>\r\n" + //
                         "\r\n" + //
                         "</body>\r\n" + //
                         "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                         + //
                         "</html>";

               // getWriter 전에 charset 하기 (한글 깨지지 않게금)
               response.setContentType("text/html;charset=UTF-8");

               PrintWriter printWriter = response.getWriter(); // 네크워크에 보내줌
               printWriter.println(contents);
               printWriter.close();
          } catch (Exception e) {
               System.out.println(e.getMessage());
          }
     }
}
