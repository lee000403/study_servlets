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
            // 메서드는 무조건 리턴을 함 그래서 데이터 타입이ArrayList이고 해당 페이지에서 사용할 변수명 surveyList
            String compare = "";

            // 리스트를 풀어헤치는 코드 
            for(int i=0; i<surveyList.size(); i++){
                HashMap survey = (HashMap) surveyList.get(i);
                String question = (String) survey.get("QUESTIONS");
                String questionId = (String) survey.get("QUESTIONS_ID");
                String choice = (String) survey.get("CHOICE");
                if(!compare.equals(questionId)){ //같지 않으면
                    System.out.println(question);
                    System.out.println(choice);
                    compare = questionId;
                }else { //같으면 답항만 출력
                    System.out.println(choice);
                }
            }

            //과제
            // for(int i=0; i<surveyList.size(); i=i+3){
            //     HashMap survey = (HashMap) surveyList.get(i);
            //     String question = (String) survey.get("QUESTIONS");
            //     System.out.println(question);
            //     for(int a= 0; a<10; a=a+6){
            //         String choice = (String) survey.get("CHOICE");
            //         System.out.println(choice);
            //     }
            // }
            


            request.setAttribute("contents", contents);
            request.setAttribute("surveyList", surveyList);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/surveys/survey.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
