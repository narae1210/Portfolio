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
		System.out.println("��Ʈ�ѷ�-���� ����");
		String id = request.getParameter("quizid");
		System.out.println(id);
		QuizModel model = QuizModel.instance(); //��Ʈ�ѷ�����  > �������� > ����� ����. 
		// model.asnwerWriteForm(id); //hidden
		return "QuizAnswer_write.jsp"; //��Ʈ�ѷ��������� String�� ����.
	}
}