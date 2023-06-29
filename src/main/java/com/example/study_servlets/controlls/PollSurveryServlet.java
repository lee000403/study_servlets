package com.example.study_servlets.controlls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveryServlet")
public class PollSurveryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // String contents = "Yoju Lab !";
            String contents = request.getParameter("company");
            
            // 메서드 호출 -> 메서드는 리턴을 무조건함 변수를
            PollsDao pollsDao = new PollsDao();
            ArrayList surveyList = pollsDao.SelectWithSearch(contents); 
            ArrayList arrayList = new ArrayList<>();
            // 메서드는 무조건 리턴을 함 그래서 데이터 타입이ArrayList이고 해당 페이지에서 사용할 변수명 surveyList
            
            // 리스트를 풀어헤치는 코드 
            for(int i=0; i<surveyList.size(); i++){
                HashMap survey = (HashMap) surveyList.get(i);
                String question = (String) survey.get("QUESTIONS");
                String choice = (String) survey.get("CHOICE");
                if(i%3 == 0){
                    System.out.println(question);
                    System.out.println(choice);
                } else {
                    System.out.println(choice);
                }
                
                
            }
            request.setAttribute("contents", contents);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/surveys/survey.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
