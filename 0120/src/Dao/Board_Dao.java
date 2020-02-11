package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.green.study.dto.Board_Dto;

public class Board_Dao {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/myweb?useSSL=false&useUnicode=true&characterEncoding=utf8"; // ?? 데이터베이스 이름, cmd에서 use 데이터베이스명 하고 같음

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
	
	/* 게시글 삭제 메서드 기능 */
	public int Delete(String n4, String pn3) {
		int num2 = 0;
		try {
			Db_Dao();
			DbConnect();
			System.out.println("게시글삭제 메소드실행");
			state = conn.createStatement();
			String update = String.format("delete from qnaboard where memberid='%s' and qid=%s;", n4, pn3);
			num2 = state.executeUpdate(update);
			if( num2 > 0)
				System.out.println("테이블삭제완료");
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			Close();
		}
		return(num2);
	}
	
	/* 게시글 수정 메서드 기능 */
	public int Update(String n1, String n2, String n3, String pn2) {
		int num = 0;
		try {
			Db_Dao();
			DbConnect();
			System.out.println("게시글수정 메소드실행");
			System.out.println(pn2);
			state = conn.createStatement();
			String update = String.format("Update qnaboard set title='%s', contents='%s' where memberid='%s' and qid='%s';", n1, n2, n3, pn2);
			// System.out.println(num); 0이 출력되면 정상
			num = state.executeUpdate(update);
			// System.out.println(num); 1이 출력되면 정상
			if(num > 0)
				System.out.println("테이블수정완료"); 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			Close();
		}
		return(num);
	}
	
	/* 게시글 셀렉트 메서드를 기능 개발하기 바람 */
	public ArrayList<Board_Dto> BoardSelect(String pn)
	{
		System.out.println(pn);
		ArrayList<Board_Dto> pcont = new ArrayList<Board_Dto>(); 
		
		try {
			Db_Dao();
			DbConnect();
			System.out.println("게시글출력 메소드실행");
			System.out.println(pn);
			state = conn.createStatement();
			String s = String.format("select * from qnaboard where qid=%s;", pn);
			ResultSet aa = state.executeQuery(s);
			
			if (aa.next()) {
				Board_Dto post = new Board_Dto();
				post.setTitle(aa.getString("title"));
				post.setContents(aa.getString("contents"));
				post.setCategory(aa.getString("category"));
				post.setMemberid(aa.getString("memberid"));
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
	

	
	
	/* 전체 출력: 셀렉트 메서드를 기능 개발하기 바람 */
	public ArrayList<Board_Dto> Select()
	{
		ArrayList<Board_Dto> bdt = new ArrayList<Board_Dto>(); 
			try {
				Db_Dao();
				DbConnect();
				System.out.println("전체출력 메소드실행");
				state = conn.createStatement();
				String s = String.format("select * from qnaboard order by qid desc;"); 
				ResultSet aa = state.executeQuery(s);
				
				while (aa.next()) {
					Board_Dto post = new Board_Dto();
					post.setQid(aa.getInt("qid"));
					post.setTitle(aa.getString("title"));
					post.setContents(aa.getString("contents"));
					post.setMemberid(aa.getString("memberid"));
					post.setDate(aa.getString("date"));
					post.setCategory(aa.getString("category"));
					//post.setAnswer(aa.getString("answer"));
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
			System.out.println("Insert메소드 실행");
			Db_Dao();
			DbConnect();
			Statement state ;
			state=conn.createStatement();
			System.out.println("테이블입력시도");

			String input = String.format("Insert into qnaboard (title, category, contents, memberid, date) values ('%s','%s','%s','%s', now());", n1, n2, n3, n4);
			
			int num = state.executeUpdate(input);
			if( num == 1)
				System.out.println("테이블입력완료"); 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			Close();
		}
	}
}
	
	