package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String command = request.getParameter("command");
			CommandInter inter = null;
			String viewName = "";

			try {
				if (command.equals("select")) { // 인덱스 파일 실행 후 컨트롤러 서블릿으로 옴.
					System.out.println("컨트롤러서블릿-select");
					inter = QuizImpl.instance(); // 임플 실행(모델 실행 > 임플 > 컨트롤러서블릿으로 리턴)한 (data)를 inter가 받음.
					viewName = inter.showData(request, response); // 상품임플 실행 후 리턴한 jsp를 viewName이 받음. //viewName = Quiz.jsp
					viewName = viewName;
					request.getRequestDispatcher(viewName).forward(request, response); 
				
				} 
				if (command.equals("selectdetail")) {
					System.out.println("컨트롤러서블릿-selectdetail");
					inter = QuizdetailImpl.instance(); // 임플 실행(모델 실행 > 임플 > 컨트롤러서블릿으로 리턴)한 (data)를 inter가 받음.
					viewName = inter.showData(request, response); // 상품임플 실행 후 리턴한 jsp를 viewName이 받음. //viewName = Quiz_read.jsp
					viewName = viewName;
					request.getRequestDispatcher(viewName).forward(request, response); 
				}
			} catch (Exception e) {
				System.out.println("service err : " + e);
			}
		}
	}


