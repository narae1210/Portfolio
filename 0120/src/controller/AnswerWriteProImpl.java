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

		System.out.println("��Ʈ�ѷ�-���� ����");

		String ref = request.getParameter("qid");
		String language = request.getParameter("uselang");
		String contents = request.getParameter("contents");
		String name = request.getParameter("memberid");
		QuizModel model = QuizModel.instance(); //��Ʈ�ѷ�����  > �������� > ����� ����. 
		model.asnwerWritePro(ref, language, contents, name); //�亯 ���� �޼��� ȣ�� > ����?
		
		return "MyAnswer_List.jsp"; //*�ӽ�
	}
}