package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.commons.Common;
import com.example.daos.OptionInforsDao2;

@WebServlet(urlPatterns = "/OptionInforsJSPServlet")
public class OptionInforsJSPServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException { // response는 보내는것, request는 가져오는 것
          try {
               String search = request.getParameter("search"); // 검색어를 받는 것

               OptionInforsDao2 optionInforsDao2 = new OptionInforsDao2();
               ArrayList optionInforList = new ArrayList<>();
               optionInforList = optionInforsDao2.SelectWithSearch(search);

               //JSP로 넘겨줌
               request.setAttribute("search", search);
               request.setAttribute("optionInforList", optionInforList);

               // getWriter 전에 charset 하기 (한글 깨지지 않게끔)
               response.setContentType("text/html;charset=UTF-8");

               // 다음 파일 호출
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cars/option_infors.jsp");
               requestDispatcher.forward(request, response);


          } catch (Exception e) {
               System.out.println(e.getMessage());
          }
     }
}
