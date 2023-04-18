package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/result")
public class TestController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 사용 x 값 세팅 x
		// 바로 JSP로 위임코드 작성
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/testResult.jsp");
		
		dispatcher.forward(req, resp);
		
	}
	

}
