package controller;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.study.dto.QuizDto;
import model.QuizModel;

public class QuizImpl2 implements CommandInter{

	static QuizImpl2 impl = new QuizImpl2();
	public static QuizImpl2 instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("컨트롤러-임플2 실행");
		QuizModel model = QuizModel.instance(); //컨트롤러서블릿  > 퀴즈임플 > 퀴즈모델 실행. 
		ArrayList<QuizDto> list = (ArrayList<QuizDto>)model.selectQuiz(); //셀렉트상품 메서드 호출 > list값 리턴 받음.
		System.out.println(list.get(0).getQuizid());
		request.setAttribute("data", list); //data에 List<QuizDto> list값을 임시로 담음.
		
		return "Quiz2.jsp"; //컨트롤러서블릿으로 String값 리턴.
	}
}