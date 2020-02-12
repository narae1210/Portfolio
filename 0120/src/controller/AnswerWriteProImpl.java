package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QuizModel;
public class AnswerWriteProImpl implements CommandInter{

	static AnswerWriteProImpl impl = new AnswerWriteProImpl();
	public static AnswerWriteProImpl instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("컨트롤러-임플 실행");

		String ref = request.getParameter("qid");
		String language = request.getParameter("uselang");
		String contents = request.getParameter("contents");
		String name = request.getParameter("memberid");
		QuizModel model = QuizModel.instance(); //컨트롤러서블릿  > 퀴즈임플 > 퀴즈모델 실행. 
		model.asnwerWritePro(ref, language, contents, name); //답변 제출 메서드 호출 > 리턴?
		
		return "MyAnswer_List.jsp"; //*임시
	}
}