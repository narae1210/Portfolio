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
		System.out.println("��Ʈ�ѷ�-���� ����");
		String id = request.getParameter("quizid");
		String ref = request.getParameter("re_ref");
		String seq = request.getParameter("re_seq");

		QuizModel model = QuizModel.instance(); //��Ʈ�ѷ�����  > �������� > ����� ����. 
		model.asnwerWritePro(id, ref, seq); //����Ʈ��������� �޼��� ȣ�� > list�� ���� ����.
		return "QuizAnswer_write.jsp"; //*�ӽ�
	}
}