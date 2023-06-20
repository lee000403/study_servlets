package com.example.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlet")// 외부에서 값을 받을 수 있게끔 webServlet으로 역할을 인식하게금 맵핑 외부에서 접속할때는 class로 인지하는게 아는라 url방식으로 인식하게금 바뀜, 내부에서는 class로 인지함
//(접근시 사용할 URI)를 지정하면 됨
public class HelloWorldServlet extends HttpServlet { // HttpServlet의 기능을 확장하기 위함 
//HttpServlet은 서블릿이 웹상에서 HTTP 프로토콜을 이용해 서비스를 처리하기 위해 반드시 상속받아야 하는 클래스입니다. 즉, 모든 서블릿 클래스의 상위 클래스는 HttpServlet이어야 함
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloWorldServlet - doGet()");
        try { // 서블렛으로 클라이언트에게 응답할수 있는 코드
            String firstName = "OH";
            String secondName = "GABAE !" ;
            PrintWriter printWriter = response.getWriter();//response.getWriter();네크워크에 응답하고 작성할꺼야 실어보내는거야 
            //String contents = "GABAE OH !";
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Hello World !</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div> first Name : "+firstName+ " </div>\r\n" + //
                    "    <div> second Name : "+secondName+" </div>\r\n" + //
                    "</body>\r\n" + //
                    "</html>";
            printWriter.println(contents);
            printWriter.close(); //네크워크에 실어보냈고 CLOSED
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");
    }
}
