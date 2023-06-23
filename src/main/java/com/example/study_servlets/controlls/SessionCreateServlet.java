package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그인일 경우 
// /session/CreateServlet?username=yojulab&password=1234
//@WebServlet(urlPatterns = "/session/CreateServlet")
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
            printWriter.println("<div>Create Session Servlets</div>"); // 네트워크에 println으로 출력 
            // login
            HttpSession httpSession = request.getSession(false); // 클라이언트의 상태값에 따라서 있으면 쓰고, 없으면 만들고 / 비교하고 넘겨주는 인스턴스화 
            if (httpSession != null) { // JSESSION 있음 (null이 아니면) -> 로그인이 되었다는 표시 
                String uernameSession = (String) httpSession.getAttribute("username"); 
                printWriter.println("<div>username : "+uernameSession+" </div>"); 

            } else { // JSESSION 없음 (null이면) -> 로그인 해야된다는 소리
                if ("yojulab".equals(username) && "1234".equals(password)) {
                    httpSession = request.getSession();
                    httpSession.setAttribute("username", username);
                    httpSession.setAttribute("password", password);
                    printWriter.println("<div>" + username + ", " + password + "</div>");
                } else {
                    printWriter.println("<div>Faild</div>");
                }
            }

            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
