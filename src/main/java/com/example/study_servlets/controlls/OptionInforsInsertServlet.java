package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daos.OptionInforsDao2;

@WebServlet(urlPatterns = "/OptionInforsInsertServlet")
public class OptionInforsInsertServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uniqiue_id = request.getParameter("name");

            OptionInforsDao2 optionInforsDao2 = new OptionInforsDao2();
            int count = optionInforsDao2.InserWithUniqueID(uniqiue_id);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter(); // 네크워크에 보내줌
            String contents = "Delete count : " + count;
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
