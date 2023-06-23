package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /session/CreateServlet?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/CreateServlet")
public class SessionCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get params from query
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // display
            PrintWriter printWriter = response.getWriter(); 
            printWriter.println("<div>Create Session Servlets</div>"); //네트워크에 println으로 출력
            // login
            if ("yojulab".equals(username) && "1234".equals(password)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
                printWriter.println("<div>" + username + ", " + password + "</div>");
            } else {
                printWriter.println("<div>Faild</div>");
            }
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
