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
		System.out.println("��Ʈ�ѷ�-���� ����");
		String id = request.getParameter("quizid");
		System.out.println(id);
		QuizModel model = QuizModel.instance(); //��Ʈ�ѷ�����  > �������� > ����� ����. 
		ArrayList<QuizDto> list = (ArrayList<QuizDto>)model.selectQuizdetail(id); //����Ʈ��������� �޼��� ȣ�� > list�� ���� ����.
		request.setAttribute("data", list); //data�� List<QuizDto> list���� �ӽ÷� ����.
		return "Quiz_read.jsp"; //��Ʈ�ѷ��������� String�� ����.
	}
}