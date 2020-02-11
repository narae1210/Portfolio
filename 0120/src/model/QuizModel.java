package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.SqlMapConfig;
import com.green.study.dto.QuizDto;

public class QuizModel {
	static QuizModel model = new QuizModel();
	public static QuizModel instance(){
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<QuizDto> selectQuiz(){ //List�� ArrayList�� ���. DTO ���¶�� �ǹ�.
		List<QuizDto> list = null;
		SqlSession sqlSession = factory.openSession(); //sqlSession�� ���̹�Ƽ������ DB�� ó���ϴ� ��ɾ���
		list = sqlSession.selectList("selectQuiz"); //mapper.xml�� ���� select id="selectQuiz" resultType="QuizDto" ������.
		sqlSession.close();
		return list; //�������ÿ� List<QuizDto> list ��ȯ.
	}	
	
	//�������� ���� �޼��� �߰�
	public List<QuizDto> selectQuizdetail(String id) {
		System.out.println("model��Ű��-�����");
		List<QuizDto> list = null;
		Integer i = Integer.parseInt(id);
		SqlSession sqlSession = factory.openSession(); //sqlSession�� ���̹�Ƽ������ DB�� ó���ϴ� ��ɾ���
		QuizDto call = new QuizDto(); //id�� name�� mapper.xml�� ������ ���ؼ��� ��ü(object=call)�� ����� QuizDto�� ȣ���ؾ� ��. 
		call.setQuizid(i); //��ü�� �̿��� QuizDto�� �ִ� quizid�� i(���� 38���� int�� ��ȯ) ���� ����.
		list = sqlSession.selectList("selectQuizdetail", call); //mapper.xml�� ���� select id="selectQuizdetail"������. 
		sqlSession.close();
		return list; //�������ÿ� List<QuizDto> list ��ȯ.
	}
	
	//�亯 �ۼ� �޼��� �߰�
/*	public void asnwerWriteForm(String id) {
	}*/
	
	//�亯 ���� �޼��� �߰�
	public String asnwerWritePro(String id, String ref, String seq) {
		System.out.println("model��Ű��-�亯 ó�� �޼���");
		//�к� ������ ���� ���̺� ���� ����
		QuizDto call = new QuizDto();
		Integer i = Integer.parseInt(id);
		Integer r = Integer.parseInt(ref);
		Integer q = Integer.parseInt(seq);
		SqlSession sqlSession = factory.openSession();
		call.setQuizid(i);
		//call.setRe_ref(r);
		//call.setRe_seq(q);
		sqlSession.insert("answerwritePro", call); //mapper.xml�� ���� select id="answerwritePro"������. �� �� QuizDto�� ���� ���� call (�Ű�����? ��ü?)�� ����. 
		
		sqlSession.commit();
		sqlSession.close();
		return null;
		
	}
}
	

