package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.study.dto.QuizDto;

import model.QuizModel;

public class AnswerWriteProImpl implements CommandInter{

	static AnswerWriteProImpl impl = new AnswerWriteProImpl();
	public static AnswerWriteProImpl instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("컨트롤러-임플 실행");
		String id = request.getParameter("quizid");
		String ref = request.getParameter("re_ref");
		String seq = request.getParameter("re_seq");

		QuizModel model = QuizModel.instance(); //컨트롤러서블릿  > 퀴즈임플 > 퀴즈모델 실행. 
		model.asnwerWritePro(id, ref, seq); //셀렉트퀴즈디테일 메서드 호출 > list값 리턴 받음.
		return "QuizAnswer_write.jsp"; //*임시
	}
}