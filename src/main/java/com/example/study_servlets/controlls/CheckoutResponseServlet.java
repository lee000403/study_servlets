package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/checkoutResponseServlet")
public class CheckoutResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("Last_name");
            String userName = request.getParameter("user_name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String address2 = request.getParameter("address2");

            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div>first name : "+firstName+"</div>\r\n" + //
                    "    <div> lsat name : "+lastName+"</div>\r\n" + //
                    "    <div> user name : "+userName+"</div>\r\n" + //
                    "    <div> email : "+email+"</div>\r\n" + //
                    "    <div> address : "+address+"</div>\r\n" + //
                    "    <div> address 2 : "+address2+"</div>\r\n" + //
                    "</body>\r\n" + //
                    "</html>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("done");
    }
}
