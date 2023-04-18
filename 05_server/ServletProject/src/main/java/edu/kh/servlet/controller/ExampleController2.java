package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* - 어노테이션(Annotation) : 컴파일러가 읽는 주석(설명)
 * 
 * @WebServlet 어노테이션
 * -> 해당 클래스를 Servlet으로 등록하고 
 * 		매핑할 주소를 연결하라고 지시하는 어노테이션
 * 		-> 서버 실행 시 자동으로 web.xml에 <servlet><servlet-mapping> 태그를 작성하는 효과
 * 
 * */
@WebServlet("/example2.do")

public class ExampleController2 extends HttpServlet  {

	
	// doGet() 메서드
	// -> GET방식 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 요청 시 전달된 input 태그의 값(== parameter)
		
		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		
		
		/* name 속성 값이 같인 파라미터가 여러 개인 경우
		 * String[]로 한 번에 반환 받는 getParameterVaules("name") 사용*/
		
		String[] optionArr = req.getParameterValues("opt");
		
		// 파라미터 확인
		System.out.println("주문 내용 확인");
		
		
		//----------------------------------------------------------------------
		
		// 응답 코드 작성
		
		// 응답 데이터 형식, 문자 인코딩 지정
		resp.setContentType("text/html; charset=UTF-8");
		
		// 응답용 스트림 (서버 -> 클라이언트 ) 얻어오기
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head><title> "+orderer+"주문 결과</title></head>");
		

		
		out.println("<body>");
		
			out.println("<h3> 주문자명 : " + orderer +"</h3>");
			
			out.println("<h3>주문한 커피 : ");
			
			if(type.equals("Iced")) out.println("차가운");
			else out.println("따뜻한");
			
			out.println(coffee);
			out.println("</h3>");
			
			// 옵션이 선택된 경우 출력
			// -> getParameter(), getParameterValue() 수행 시
			// 	  전달된 값 중 name이 일치하는 값이 없으면
			// 	  null 반환 
			if(optionArr != null) {
				out.println("<ul>");

				for(String opt : optionArr) {
					out.println("<ul>"+opt+"</ul>");
				}
				
				out.println("</ul>");
			}
		
		
		out.println("</body>");
		
		
		
		out.println("</html>");
	
		
		
	}
	
	
	
}
