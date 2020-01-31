package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.study.dto.QuizDto;

import model.QuizModel;

public class QuizdetailImpl implements CommandInter{

	static QuizdetailImpl impl = new QuizdetailImpl();
	public static QuizdetailImpl instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("컨트롤러-임플 실행");
		String id = request.getParameter("quizid");
		System.out.println(id);
		QuizModel model = QuizModel.instance(); //컨트롤러서블릿  > 퀴즈임플 > 퀴즈모델 실행. 
		ArrayList<QuizDto> list = (ArrayList<QuizDto>)model.selectQuizdetail(id); //셀렉트퀴즈디테일 메서드 호출 > list값 리턴 받음.
		request.setAttribute("data", list); //data에 List<QuizDto> list값을 임시로 담음.
		return "Quiz_read.jsp"; //컨트롤러서블릿으로 String값 리턴.
	}
}