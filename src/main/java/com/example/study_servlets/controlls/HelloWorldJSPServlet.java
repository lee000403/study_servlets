package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldJSPServlet")// 외부에서 값을 받을 수 있게끔 webServlet으로 역할을 인식하게금 맵핑 외부에서 접속할때는 class로 인지하는게 아는라 url방식으로 인식하게금 바뀜, 내부에서는 class로 인지함
//(접근시 사용할 URI)를 지정하면 됨
public class HelloWorldJSPServlet extends HttpServlet { // HttpServlet의 기능을 확장하기 위함 
//HttpServlet은 서블릿이 웹상에서 HTTP 프로토콜을 이용해 서비스를 처리하기 위해 반드시 상속받아야 하는 클래스입니다. 즉, 모든 서블릿 클래스의 상위 클래스는 HttpServlet이어야 함
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try { // 서블렛으로 클라이언트에게 응답할수 있는 코드
            String contents = "Yoju Lab !";

            request.setAttribute("contents", contents);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
