package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daos.CarInforsDao;
import com.example.daos.FactorysDao;

@WebServlet(urlPatterns = "/SelectCar_Infors")
public class SelectCar_Infors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // html
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Bootstrap Template</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n"
                    + //
                    "    <link rel=\"stylesheet\" href=\"../css/commons.css\">\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <table class=\"table table-bordered table-hover\">\r\n" + //
                    "        <thead>\r\n" + //
                    "            <tr>\r\n" + //
                    "                <th>COMPANY_ID</th>\r\n" + //
                    "                <th>CAR_NAME</th>\r\n" + //
                    "            </tr>\r\n" + //
                    "        </thead>\r\n" + //
                    "        <tbody>\r\n";

            CarInforsDao carInforsDao = new CarInforsDao();
            ArrayList carList = new ArrayList();
            carList = carInforsDao.selectAll();
            for (int i = 0; i < carList.size(); i++) {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap) carList.get(i);
                contents = contents + " <tr>\r\n" + //
                        "                <td>" + hashMap.get("COMPANY_ID") + "</td>\r\n" + //
                        "                <td>" + hashMap.get("CAR_NAME") + "</td>\r\n" + //
                        "            </tr>\r\n";
            }

            // 클라이언트에 html 화면 제공
            response.setContentType("text/html;charset=UTF-8"); // 브라우저상에서 한글이 깨지지 않게게

            PrintWriter printWriter = response.getWriter(); // response.getWriter();네크워크에 응답하고 작성할꺼야 실어보내는거야
            printWriter.println(contents);
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
