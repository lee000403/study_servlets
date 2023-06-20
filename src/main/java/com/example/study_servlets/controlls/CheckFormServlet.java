package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Mynamepol")
public class CheckFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        PrintWriter printWriter = response.getWriter();
        String contents_poll = "<!DOCTYPE html>\r\n" + //
                "<html lang=\"kor\">\r\n" + //
                "<head>\r\n" + //
                "    <meta charset=\"UTF-8\">\r\n" + //
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                "    <title>Check Out Form</title>\r\n" + //
                "</head>\r\n" + //
                "<body>\r\n" + //
                "    <div>\r\n" + //
                "        <h2>Billing address</h2>\r\n" + //
                "    </div>\r\n" + //
                "    <form action=\"/CheckoutFormServlet\" method=\"get\">\r\n" + //
                "        <div>\r\n" + //
                "            <table border=\"0\">\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>First Name</td>\r\n" + //
                "                    <td>Last Name</td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td >\r\n" + //
                "                        <input type=\"text\" name = \"firstname\">\r\n" + //
                "                    </td>\r\n" + //
                "                    <td >\r\n" + //
                "                        <input type=\"text\" name = \"secondname\">\r\n" + //
                "                    </td>\r\n" + //
                "                </tr>\r\n" + //
                "            </table>\r\n" + //
                "        </div>\r\n" + //
                "        <div>\r\n" + //
                "            <table border=\"0\">\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>UserName</td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td >\r\n" + //
                "                        <input type=\"button\" value=\"@\">\r\n" + //
                "                        <input type=\"text\" name = \"username\" placeholder=\"UserName\">\r\n" + //
                "                    </td>\r\n" + //
                "                </tr>\r\n" + //
                "            </table>\r\n" + //
                "        </div>\r\n" + //
                "        <div>\r\n" + //
                "            <table border=\"0\" class=\"width_one\">\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>Email(Optional)</td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>\r\n" + //
                "                        <input type=\"email\" name = \"email\" placeholder=\"you@example.com\">\r\n" + //
                "                    </td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>Adress</td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td colspan=\"12\">\r\n" + //
                "                        <input type=\"text\" name = \"address\" placeholder=\"1234 Main St\">\r\n" + //
                "                    </td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>Address 2 (Optional)</td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>\r\n" + //
                "                        <input type=\"text\" name = \"address2\" placeholder=\"Apartment or suite\">\r\n"
                + //
                "                    </td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>Country</td>\r\n" + //
                "                    <td>State</td>\r\n" + //
                "                    <td>Zip</td>\r\n" + //
                "                </tr>\r\n" + //
                "                <tr>\r\n" + //
                "                    <td>\r\n" + //
                "                        <select name=\"country\" id=\"country\">\r\n" + //
                "                            <option value=\"CHOOSE\">choose</option>\r\n" + //
                "                            <option value=\"KOREA\">KOREA</option>\r\n" + //
                "                            <option value=\"USA\">USA</option>\r\n" + //
                "                            <option value=\"CHINA\">CHINA</option>\r\n" + //
                "                        </select>\r\n" + //
                "                    </td>\r\n" + //
                "                    <td>\r\n" + //
                "                        <select name=\"state\" id=\"state\">\r\n" + //
                "                            <option value=\"CHOOSE2\">CHOOSE2</option>\r\n" + //
                "                            <option value=\"SEOUL\">SEOUL</option>\r\n" + //
                "                            <option value=\"BUSAN\">BUSAN</option>\r\n" + //
                "                            <option value=\"JEJUDO\">JEJU</option>\r\n" + //
                "                        </select>\r\n" + //
                "                    </td>\r\n" + //
                "                    <td>\r\n" + //
                "                        <input type=\"text\" name=\"zip\">\r\n" + //
                "                    </td>\r\n" + //
                "                </tr>\r\n" + //
                "            </table>\r\n" + //
                "        </div>\r\n" + //
                "        <div>\r\n" + //
                "            <button type=\"submit\">\uBCF4\uB0B4\uAE30</button>\r\n" + //
                "        </div>\r\n" + //
                "    </form>\r\n" + //
                "</body>\r\n" + //
                "</html>";
        printWriter.println(contents_poll);
        printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
