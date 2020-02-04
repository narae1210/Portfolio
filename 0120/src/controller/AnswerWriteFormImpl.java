package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.study.dto.QuizDto;

import model.QuizModel;

public class AnswerWriteFormImpl implements CommandInter{

	static AnswerWriteFormImpl impl = new AnswerWriteFormImpl();
	public static AnswerWriteFormImpl instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("컨트롤러-임플 실행");
		String id = request.getParameter("quizid");
		System.out.println(id);
		QuizModel model = QuizModel.instance(); //컨트롤러서블릿  > 퀴즈임플 > 퀴즈모델 실행. 
		// model.asnwerWriteForm(id); //hidden
		return "QuizAnswer_write.jsp"; //컨트롤러서블릿으로 String값 리턴.
	}
}