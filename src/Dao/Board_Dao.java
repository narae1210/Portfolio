package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.green.study.dto.Board_Dto;

public class Board_Dao {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/myweb?useSSL=false&useUnicode=true&characterEncoding=utf8"; // ?? �����ͺ��̽� �̸�, cmd���� use �����ͺ��̽��� �ϰ� ����

	private final String USER_NAME = "root";
	private final String PASSWORD = "1005";

	Connection conn = null;
	Statement state = null;
	
	public void Db_Dao() { 
		try {
			Class.forName(JDBC_DRIVER); 
			} catch (Exception e) {
		}
	}

	public void DbConnect() { 
		try {
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);
		} catch (Exception e) {
		}
	}

	public void Close() { 
		if (state != null) {
			try {
				state.close();
			} catch (Exception e) {
			}

			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {

				}
		}
	}
	
	/* �Խñ� ���� �޼��� ��� */
	public int Delete(String n4, String pn3) {
		int num2 = 0;
		try {
			Db_Dao();
			DbConnect();
			System.out.println("�Խñۻ��� �޼ҵ����");
			state = conn.createStatement();
			String update = String.format("delete from qna_board where name='%s' and postid=%s;", n4, pn3);
			num2 = state.executeUpdate(update);
			if( num2 > 0)
				System.out.println("���̺�����Ϸ�");
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			Close();
		}
		return(num2);
	}
	
	/* �Խñ� ���� �޼��� ��� */
	public int Update(String n1, String n2, String n3, String pn2) {
		int num = 0;
		try {
			Db_Dao();
			DbConnect();
			System.out.println("�Խñۼ��� �޼ҵ����");
			System.out.println(n1);
			state = conn.createStatement();
			String update = String.format("Update qna_board set posttitle='%s', postcontents='%s' where name='%s' and postid=%s;", n1, n2, n3,  pn2);

			num = state.executeUpdate(update);
			if( num > 0)
				System.out.println("���̺�����Ϸ�"); 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			Close();
		}
		return(num);
	}
	
	/* �Խñ� ����Ʈ �޼��带 ��� �����ϱ� �ٶ� */
	public ArrayList<Board_Dto> BoardSelect(String pn)
	{
		System.out.println(pn);
		ArrayList<Board_Dto> pcont = new ArrayList<Board_Dto>(); 
		
		try {
			Db_Dao();
			DbConnect();
			System.out.println("�Խñ���� �޼ҵ����");
			state = conn.createStatement();
			String s = String.format("select * from qna_board where postid=%s;", pn);
			ResultSet aa = state.executeQuery(s);
			
			if (aa.next()) {
				Board_Dto post = new Board_Dto();
				post.setPosttitle(aa.getString("posttitle"));
				post.setPostcontents(aa.getString("postcontents"));
				post.setPostcategory(aa.getString("postcategory"));
				post.setName(aa.getString("name"));
				pcont.add(post);
				}
		}
		catch (Exception e) {
		System.out.println(e);
	} finally {
		Close();
	}
	return(pcont);
	}
	

	
	
	/* ��ü ���: ����Ʈ �޼��带 ��� �����ϱ� �ٶ� */
	public ArrayList<Board_Dto> Select()
	{
		ArrayList<Board_Dto> bdt = new ArrayList<Board_Dto>(); 
			try {
				Db_Dao();
				DbConnect();
				System.out.println("��ü��� �޼ҵ����");
				state = conn.createStatement();
				String s = String.format("select * from qna_board order by postid desc;"); 
				ResultSet aa = state.executeQuery(s);
				
				while (aa.next()) {
					Board_Dto post = new Board_Dto();
					post.setPostid(aa.getInt("postid"));
					post.setPosttitle(aa.getString("posttitle"));
					post.setPostcontents(aa.getString("postcontents"));
					post.setName(aa.getString("name"));
					post.setDate(aa.getString("date"));
					post.setPostcategory(aa.getString("postcategory"));
					post.setAnswer(aa.getString("answer"));
					bdt.add(post);
					}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				Close();
			}
			return(bdt);
	}
	
	
	public void Insert(String n1, String n2, String n3, String n4) {
		try {
			System.out.println("Insert�޼ҵ� ����");
			Db_Dao();
			DbConnect();
			Statement state ;
			state=conn.createStatement();
			System.out.println("���̺��Է½õ�");

			String input = String.format("Insert into qna_board (posttitle, postcategory, postcontents, name, date, answer) values ('%s','%s','%s','%s', now(),'�̴亯');", n1, n2, n3, n4);
			
			int num = state.executeUpdate(input);
			if( num == 1)
				System.out.println("���̺��Է¿Ϸ�"); 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			Close();
		}
	}
}
	
	