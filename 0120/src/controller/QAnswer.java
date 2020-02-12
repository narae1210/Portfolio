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
		System.out.println("��Ʈ�ѷ�-ť�ؼ� ����");
		String name = request.getParameter("id");
		QuizModel model = QuizModel.instance(); //��Ʈ�ѷ�����  > �������� > ����� ����. 
		ArrayList<QuizAnswerDto> list = (ArrayList<QuizAnswerDto>)model.QAnswerList(name); //����Ʈ��ǰ �޼��� ȣ�� > list�� ���� ����.
		request.setAttribute("data", list); //data�� List<QuizDto> list���� �ӽ÷� ����.
		
		return "MyAnswer_List.jsp"; //��Ʈ�ѷ��������� String�� ����.
	}
}