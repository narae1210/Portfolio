package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String command = request.getParameter("command");
			CommandInter inter = null;
			String viewName = "";

			try {
				if (command.equals("select")) { //�α��� ���� �ʿ��� ��Ʈ��
					System.out.println("��Ʈ�ѷ�����-select");
					inter = QuizImpl.instance(); 
					viewName = inter.showData(request, response); 
					viewName = viewName;
					request.getRequestDispatcher(viewName).forward(request, response); 
				
				} 
				else if (command.equals("select2")) { // �ε��� ���� ���� �� ��Ʈ�ѷ� �������� ��.
					System.out.println("��Ʈ�ѷ�����-select2");
					inter = QuizImpl2.instance(); // ���� ����(�� ���� > ���� > ��Ʈ�ѷ��������� ����)�� (data)�� inter�� ����.
					viewName = inter.showData(request, response); // ��ǰ���� ���� �� ������ jsp�� viewName�� ����. //viewName = Quiz2.jsp
					viewName = viewName;
					request.getRequestDispatcher(viewName).forward(request, response); 
				}
				
				else if (command.equals("selectdetail")) { //?command=?? url�� ���Ǵ� ����
					System.out.println("��Ʈ�ѷ�����-selectdetail");
					inter = QuizdetailImpl.instance(); // ���� ����(�� ���� > ���� > ��Ʈ�ѷ��������� ����)�� (data)�� inter�� ����.
					viewName = inter.showData(request, response); // ��ǰ���� ���� �� ������ jsp�� viewName�� ����. //viewName = Quiz_read.jsp
					viewName = viewName;
					request.getRequestDispatcher(viewName).forward(request, response); 
				}
				
				else if (command.equals("answerwritepro")) {
					System.out.println("��Ʈ�ѷ�����-answerWritePro");
					inter = AnswerWriteProImpl.instance(); // 
					viewName = inter.showData(request, response); // 
					viewName = viewName;
					request.getRequestDispatcher(viewName).forward(request, response); 
				}
				else if (command.equals("answerselect")) {
					System.out.println("��Ʈ�ѷ�����-answerselect");
					inter = QAnswer.instance(); // 
					viewName = inter.showData(request, response); // 
					viewName = viewName;
					request.getRequestDispatcher(viewName).forward(request, response); 
				}
				
			} catch (Exception e) {
				System.out.println("service err : " + e);
			}
		}
	}


