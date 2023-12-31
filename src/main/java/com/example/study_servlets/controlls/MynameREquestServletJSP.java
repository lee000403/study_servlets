package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mynameREquestServletJSP")
public class MynameREquestServletJSP extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myname_request.jsp");
            requestDispatcher.forward(request, response); //경로를 바꿔서 param을던져줌
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
