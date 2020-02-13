package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db_Dao {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/myweb?useSSL=false&useUnicode=true&characterEncoding=utf8"; // ?? �����ͺ��̽� �̸�, cmd���� use �����ͺ��̽��� �ϰ� ����

	private final String USER_NAME = "root";
	private final String PASSWORD = "1005";

	Connection conn = null;
	Statement state = null;

	public void Db_Dao() { // mysql���� �޼ҵ� , �� ���� ���� �Ǵϱ� �����ڿ� ���ÿ� �ʱ�ȭ
		try {
			Class.forName(JDBC_DRIVER); // mysql�� ����, �ܺο��� �������� �͵��� ��� ����ó��, �� ���� ���� ��
		} catch (Exception e) {
		}
	}

	public void DbConnect() { // db���� �޼ҵ�
		try {
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD); // db����, �۾����� open
		} catch (Exception e) {
		}
	}

	public void Close() { // �ݱ� ���� �޼ҵ�
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

	public void Insert(String n1, String n2, String n3, String n4, String n5, String n6, String n7, String n8,
			String n9) {
		try {
			Db_Dao();
			DbConnect();
			state = conn.createStatement();
			String input = String.format("Insert into Gs_Join values('%s','%s','%s','%s','%s','%s','%s','%s','%s')", n1,
					n2, n3, n4, n5, n6, n7, n8, n9);
			state.executeUpdate(input);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			Close();
		}
	}

	public int Jungbok(String s1) {
		int n = 0;
		try {
			Db_Dao();
			DbConnect();
			state = conn.createStatement(); // state ����
			String s = String.format("select id from Gs_Join where id = '%s';", s1); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(s);
			if (aa.next()) {
				n = 1;
			} else {
				n = 0;
			}

			aa.close();
		} catch (Exception e) {
		} finally {
			Close();
		}
		return n;
	}

	public String JungbokPw(String s1) {
		String s = null;
		String ss = null;
		try {
			Db_Dao();
			DbConnect();
			state = conn.createStatement(); // state ����
			s = String.format("select pw from Gs_Join where id = '%s';", s1); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(s);
			if(aa.next()) {
				ss = aa.getString("pw");
				
			}

		} catch (Exception e) {
		} finally {
			Close();
		}
		return ss;
	}

}
