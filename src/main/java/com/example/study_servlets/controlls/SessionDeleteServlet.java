package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(urlPatterns = "/session/DeleteServlet")
public class SessionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession httpSession = request.getSession();
            httpSession.invalidate(); // Server side

            Cookie[] cookies = request.getCookies(); // 클라이언트가 보내는정보
            String content = "<div>CookiesGetAndDeleteServlet</div>";
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("JSESSIONID")) { // 쿠키 삭제 - Client side
                    cookie.setMaxAge(0); // 0 삭제 , -1 무한대, 크기가 커지면 daily
                    response.addCookie(cookie); // 변경된 내용을 저장
                } else { // 출력
                    content = content + "<div>" + name + ", " + value + "</div>";
                }

            }
            PrintWriter printWriter = response.getWriter();
            String contents = "<div>Logout !</div>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
