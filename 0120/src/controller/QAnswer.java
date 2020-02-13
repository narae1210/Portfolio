package controller;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.study.dto.QuizAnswerDto;
import com.green.study.dto.QuizDto;
import model.QuizModel;

public class QAnswer implements CommandInter{

	static QAnswer impl = new QAnswer();
	public static QAnswer instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("컨트롤러-큐앤서 실행");
		String name = request.getParameter("id");
		QuizModel model = QuizModel.instance(); //컨트롤러서블릿  > 퀴즈임플 > 퀴즈모델 실행. 
		ArrayList<QuizAnswerDto> list = (ArrayList<QuizAnswerDto>)model.QAnswerList(name); //셀렉트상품 메서드 호출 > list값 리턴 받음.
		request.setAttribute("data", list); //data에 List<QuizDto> list값을 임시로 담음.
		
		return "MyAnswer_List.jsp"; //컨트롤러서블릿으로 String값 리턴.
	}
}