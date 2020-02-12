package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.SqlMapConfig;

import com.green.study.dto.QuizAnswerDto;
import com.green.study.dto.QuizDto;





public class QuizModel {
	static QuizModel model = new QuizModel();
	public static QuizModel instance(){
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<QuizDto> selectQuiz(){ //List�� ArrayList�� ���. DTO ���¶�� �ǹ�.
		List<QuizDto> list = null;
		System.out.println("�����");
		SqlSession sqlSession = factory.openSession(); //sqlSession�� ���̹�Ƽ������ DB�� ó���ϴ� ��ɾ���
		list = sqlSession.selectList("selectQuiz"); //mapper.xml�� ���� select id="selectQuiz" resultType="QuizDto" ������.
		System.out.println("SQL �õ� > ����Ʈ�� ��ȯ");
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
	//���� ���� ���ϱ�.
/*	public int selectAnswerCount(int num) {

		Connection con;
		int AnswerCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			System.out.println("DAO.selectListCount: getConnection");
			pstmt=con.prepareStatement("select count(*) from quizanswer where ref='num';");
			rs = pstmt.executeQuery();
			if(rs.next()){
				AnswerCount=rs.getInt(1);
			}
		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}
		return AnswerCount;
	}
*/
	//�亯 ���� �޼��� �߰�
	public String asnwerWritePro(String ref, String language, String contents, String name) {
		System.out.println("model��Ű��-�亯 ó�� �޼���");
		//�к� ������ ���� ���̺� ���� ����
		QuizAnswerDto qanswerdto = new QuizAnswerDto(); //qanswerdto ����Ʈ ���� ������
		Integer r = Integer.parseInt(ref);
		SqlSession sqlSession = factory.openSession();
		qanswerdto.setRef(r);
		qanswerdto.setLanguage(language);
		qanswerdto.setContents(contents);
		qanswerdto.setName(name);
		sqlSession.insert("answerwritePro", qanswerdto); //mapper.xml�� ���� select id="answerwritePro"������. �� �� QuizDto�� ���� ���� call (�Ű�����? ��ü?)�� ����. 
		
		sqlSession.commit();
		sqlSession.close();
		return null;
		
	}
	//�亯 ��� �޼��� �߰�
	public List<QuizAnswerDto> QAnswerList(String name){
		List<QuizAnswerDto> list = null;
		System.out.println("�亯���");
		QuizAnswerDto qanswerdto = new QuizAnswerDto();
		qanswerdto.setName(name);
		SqlSession sqlSession = factory.openSession(); //sqlSession�� ���̹�Ƽ������ DB�� ó���ϴ� ��ɾ���
		list = sqlSession.selectList("answerlist", qanswerdto); //mapper.xml�� ���� select id="answerlist" resultType="QuizAnswerDto" ������.
		sqlSession.close();
		return list;
		
	}
}
