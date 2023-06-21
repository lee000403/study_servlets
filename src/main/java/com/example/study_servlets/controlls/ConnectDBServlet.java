package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.commons.Common;
import com.example.study_servlets.Commons;

@WebServlet(urlPatterns = "/ConnectDBServlet")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 클라이언트에 html화면 제공
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Bootstrap Template</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"../css/commons.css\">\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <table class=\"table table-bordered table-hover\">\r\n" + //
                    "        <thead>\r\n" + //
                    "            <tr>\r\n" + //
                    "                <th>COMPANY_ID</th>\r\n" + //
                    "                <th>COMPANY</th>\r\n" + //
                    "            </tr>\r\n" + //
                    "        </thead>\r\n" + //
                    "        <tbody>\r\n";

            // - query Edit
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); 

            String query = " SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); // 결과값 리턴 , selct만 resulset으로 받음(select 테이블 형식으로 나오니깐)

            //컨텐츠 증가
            while (resultSet.next()) {
                contents = contents + " <tr>\r\n" + //
                        "                <td>" + resultSet.getString("COMPANY_ID") + "</td>\r\n" + //
                        "                <td>" + resultSet.getString("COMPANY") + "</td>\r\n" + //
                        "            </tr>\r\n";
                    
            }
            // 클라이언트에 html 화면 제공
            response.setContentType("text/html;charset=UTF-8"); //브라우저상에서 한글이 깨지지 않게게 
            
            PrintWriter printWriter = response.getWriter(); // response.getWriter();네크워크에 응답하고 작성할꺼야 실어보내는거야
            printWriter.println(contents);
            printWriter.close();

            // SELECT COUNT(*) AS CNT FROM factorys;
            resultSet = statement.executeQuery(query);
            int totalCount = 0;
            while (resultSet.next()) { // next: 뭉치를 던져줌
                System.out.println(resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            }
            contents = contents +                     "        </tbody>\r\n" + //
                    "    </table>\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js\"></script>\r\n" + //
                    "\r\n" + //
                    "</html>";


            /*
             * - 값이 테이블로 나오지 않음
             * INSERT INTO factorys
             * (COMPANY_ID, COMPANY)
             * VALUE
             * ('CAR-01', 'AUDI');
             */

            // 변수화 시키는게 좋음
            // String companyId = "CAR-01";
            // String company = "AUDI";
            // query = "INSERT INTO factorys " + // 중복 에러 발생으로 IGNORE 사용
            // "(COMPANY_ID, COMPANY) " +
            // "VALUE " +
            // "('"+companyId+"', '"+company+"') " ;//''를 꼭 넣어줘야 함

            // int count = statement.executeUpdate(query); //결과값이 없기때문에 resultset으로 넘길필요 없어
            // update를 사용, workbench에서 update된거 확인

            // data 수정
            /*
             * UPDATE factorys
             * SET COMPANY = '패러리'
             * WHERE COMPANY_ID = 'CAR-01';
             */
            String companyId = "";
            String company = "패러리";
            query = "UPDATE factorys " +
                    "SET COMPANY = '" + company + "' " +
                    "WHERE COMPANY_ID = '" + companyId + "' ";

            int count = statement.executeUpdate(query);

            // 삭제
            /*
             * DELETE FROM factorys
             * WHERE COMPANY_ID = 'CAR-01';
             */

            query = "DELETE FROM factorys " +
                    "WHERE COMPANY_ID = '" + companyId + "' ";

            count = statement.executeUpdate(query);

            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
