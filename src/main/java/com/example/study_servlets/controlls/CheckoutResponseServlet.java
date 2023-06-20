package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CheckoutResponseServlet")
public class CheckoutResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String firstName = request.getParameter("firstname");
            String secondName = request.getParameter("secondname");
            String userName = request.getParameter("username");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String address2 = request.getParameter("address2");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            PrintWriter printWriter = response.getWriter();

            String contents_poll = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"kor\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "<div>\r\n" +
                            "    <div>First Name: " + firstName + "</div>\r\n" +
                            "    <div>Second Name: " + secondName + "</div>\r\n" +
                            "    <div>User Name: " + userName + "</div>\r\n" +
                            "    <div>Email: " + email + "</div>\r\n" +
                            "    <div>Address: " + address + "</div>\r\n" +
                            "    <div>Address2: " + address2 + "</div>\r\n" +
                            "    <div>Country: " + country + "</div>\r\n" +
                            "    <div>State: " + state + "</div>\r\n" +
                            "    <div>Zip: " + zip + "</div>\r\n" +
                            "</div>\r\n" +
                    "</body>\r\n" + //
                    "</html>";
            printWriter.println(contents_poll);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
