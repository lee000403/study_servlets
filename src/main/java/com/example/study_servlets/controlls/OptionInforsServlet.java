package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.commons.Common;
import com.example.daos.OptionInforsDao2;

@WebServlet(urlPatterns = "/OptionInforsServlet")
public class OptionInforsServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException { // response는 보내는것, request는 가져오는 것
          try {
               String search = request.getParameter("search"); // 검색어를 받는 것

               String temp = "    <div class=\"container\">\r\n" + //
                         "        <form action=\"/OptionInforsServlet\">\r\n" + //
                         "            <label for=\"\">\uAC80\uC0C9</label>\r\n" + //
                         "            <input type=\"text\" name=\"search\">\r\n" + //
                         "            <button>\uAC80\uC0C9 \uD558\uAE30</button>\r\n" + //
                         "        </form>\r\n" + //
                         "    </div>";
               // DB에서 terminal로 데이터 가져오는 코드
               Common common = new Common();
               Statement statement = common.getStatement(); // Editor in Workbanch
               String query = "SELECT *\n" +
                         "FROM option_infors;";
               ResultSet resultSet = statement.executeQuery(query); // query 실행
               // 웹에 html 방식으로 띄어주는 것
               String contents = "<!DOCTYPE html>\r\n" + //
                         "<html lang=\"en\">\r\n" + //
                         "\r\n" + //
                         "<head>\r\n" + //
                         "    <meta charset=\"UTF-8\">\r\n" + //
                         "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                         "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n" + //
                         "    <title>Document</title>\r\n" + //
                         "</head>\r\n" + //
                         "\r\n" + //
                         "<body>\r\n" + //
                         "    <div class=\"container\">\r\n" + //
                         "        <form action=\"/OptionInforsServlet\">\r\n" + //
                         "            <label for=\"\">\uAC80\uC0C9</label>\r\n" + //
                         "            <input type=\"text\" name=\"search\" value=\'"+search+"\'>\r\n" + //
                         "            <button>\uAC80\uC0C9 \uD558\uAE30</button>\r\n" + //
                         "        </form>\r\n" + //
                         "    </div>\r\n" + //
                         "    <div class=\"container\">\r\n" + //
                         "        <table class=\"table table-bordered table-hover\">\r\n" + //
                         "            <thead>\r\n" + //
                         "                <tr>\r\n" + //
                         "                    <th>OPTION_INFOR_ID</th>\r\n" + //
                         "                    <th>OPTION_NAME</th>\r\n" + //
                         "                    <th>Delete</th>\r\n" + //
                         "                </tr>\r\n" + //
                         "            </thead>\r\n" + //
                         "            <tbody>";
               OptionInforsDao2 optionInforsDao2 = new OptionInforsDao2();
               ArrayList optionInforList = new ArrayList<>();
               optionInforList = optionInforsDao2.SelectWithSearch(search);

               // for문을 돌면서 값을 받아냄
               for (int i = 0; i < optionInforList.size(); i++) {
                    HashMap optionInforRecord = new HashMap<>();
                    optionInforRecord = (HashMap) optionInforList.get(i);

                    contents = contents + "                <tr>\r\n" + //
                              "                    <td>"+optionInforRecord.get("OPTION_INFOR_ID")+"</td>\r\n" + //
                              "                    <td>"+optionInforRecord.get("OPTION_NAME")+" </td>\r\n" +
                              "                </tr>\r\n";  //;
               }
               contents = contents + "            </tbody>\r\n" + //
                         "        </table>\r\n" + //
                         "    </div>\r\n" + //
                         "</body>\r\n" + //
                         "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n" + //
                         "\r\n" + //
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
