package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/checkoutFormServlet")
public class CheckoutFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        try {
            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <h1> Billing adress</h1>\r\n" + //
                    "    <form action=\"/checkoutResponseServlet\" method=\"get\">\r\n" + //
                    "        <tr>\r\n" + //
                    "            <td>\r\n" + //
                    "                first name : <input type=\"text\" name=\"first_name\">\r\n" + //
                    "            </td>\r\n" + //
                    "        </tr>\r\n" + //
                    "        <tr>\r\n" + //
                    "            <td>\r\n" + //
                    "                Last name : <input type=\"text\" name=\"Last_name\"></div>\r\n" + //
                    "            </td>\r\n" + //
                    "        </tr>\r\n" + //
                    "\r\n" + //
                    "        <div> Username</div>\r\n" + //
                    "        <div> <input type=\"text\" placeholder=\"Username\" name=\"Last_name\"></div>\r\n" + //
                    "        <tr>\r\n" + //
                    "            <td>\r\n" + //
                    "                Email (Optional)\r\n" + //
                    "            </td>\r\n" + //
                    "            <div>\r\n" + //
                    "                <td>\r\n" + //
                    "                    <input type=\"email\" placeholder=\"you@example.com\"  name=\"you@example.com\" id=\"\"> \r\n" + //
                    "                </td>\r\n" + //
                    "            </div>\r\n" + //
                    "        </tr>\r\n" + //
                    "        <tr>\r\n" + //
                    "            <td>\r\n" + //
                    "                <div>Address</div>\r\n" + //
                    "                <div>\r\n" + //
                    "                    <input type=\"address\" placeholder=\"1234 Main St\" name=\"address\" id=\"\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </td>\r\n" + //
                    "        </tr>\r\n" + //
                    "        <tr>\r\n" + //
                    "            <td>\r\n" + //
                    "                <div>Address 2</div>\r\n" + //
                    "                <div>\r\n" + //
                    "                    <input type=\"address\" placeholder=\"Apartment or suit\" name=\"address\" id=\"\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </td>\r\n" + //
                    "        </tr>\r\n" + //
                    "        <tr>\r\n" + //
                    "            <td>\r\n" + //
                    "                Country\r\n" + //
                    "            </td>\r\n" + //
                    "        </tr>\r\n" + //
                    "        <div>\r\n" + //
                    "            <button type=\"submit\">\uBCF4\uB0B4\uAE30</button>\r\n" + //
                    "        </div>\r\n" + //
                    "    </form>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "\r\n" + //
                    "</html>"; //http 넣는 곳
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
