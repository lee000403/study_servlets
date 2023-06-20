package com.example.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlet")
public class HelloWorldServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloWorldServlet - doGet()");
        try {
            String firstName = "Lee";
            String secondName = "donghwan";
            PrintWriter printWriter = response.getWriter(); // 정보를 response 가 담고 있다. getWriter() 적는다는것. 
            // String contents = "leedonghwan";
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Hello Wrold!</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div>\r\n" + //
                    "        first name : "+firstName+"\r\n" + //
                    "    </div>\r\n" + //
                    "    <div>\r\n" + //
                    "        second name : "+secondName+"\r\n" + //
                    "    </div>\r\n" + //
                    "</body>\r\n" + //
                    "</html>";
            printWriter.println(contents); // 위에 세 라인이 클라이언트에게 응답이 가능하게 해줄 수 있는 부분
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");
    }
}
