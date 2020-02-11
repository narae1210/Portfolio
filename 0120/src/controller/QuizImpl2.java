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
		System.out.println("��Ʈ�ѷ�-���� ����");
		QuizModel model = QuizModel.instance(); //��Ʈ�ѷ�����  > �������� > ����� ����. 
		ArrayList<QuizDto> list = (ArrayList<QuizDto>)model.selectQuiz(); //����Ʈ��ǰ �޼��� ȣ�� > list�� ���� ����.
		System.out.println(list.get(0).getQuizid());
		request.setAttribute("data", list); //data�� List<SangpumDto> list���� �ӽ÷� ����.
		
		return "Quiz2.jsp"; //��Ʈ�ѷ��������� String�� ����.
	}
}