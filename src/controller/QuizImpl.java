package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.study.dto.QuizDto;

import model.QuizModel;

public class QuizImpl implements CommandInter{

	static QuizImpl impl = new QuizImpl();
	public static QuizImpl instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("��Ʈ�ѷ�-���� ����");
		QuizModel model = QuizModel.instance(); //��Ʈ�ѷ�����  > �������� > ����� ����. 
		ArrayList<QuizDto> list = (ArrayList<QuizDto>)model.selectQuiz(); //����Ʈ��ǰ �޼��� ȣ�� > list�� ���� ����.
		System.out.println(list.get(0).getQuizid());
		request.setAttribute("data", list); //data�� List<SangpumDto> list���� �ӽ÷� ����.
		return "Quiz.jsp"; //��Ʈ�ѷ��������� String�� ����.
	}
}