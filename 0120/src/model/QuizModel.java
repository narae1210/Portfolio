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

	public List<QuizDto> selectQuiz(){ //List는 ArrayList와 비슷. DTO 형태라는 의미.
		List<QuizDto> list = null;
		System.out.println("퀴즈모델");
		SqlSession sqlSession = factory.openSession(); //sqlSession은 마이바티스에서 DB를 처리하는 명령어임
		list = sqlSession.selectList("selectQuiz"); //mapper.xml에 가서 select id="selectQuiz" resultType="QuizDto" 실행함.
		System.out.println("SQL 시도 > 리스트값 반환");
		sqlSession.close();
		return list; //퀴즈임플에 List<QuizDto> list 반환.
	}	
	
	//상세페이지 보는 메서드 추가
	public List<QuizDto> selectQuizdetail(String id) {
		System.out.println("model패키지-퀴즈모델");
		List<QuizDto> list = null;
		Integer i = Integer.parseInt(id);
		SqlSession sqlSession = factory.openSession(); //sqlSession은 마이바티스에서 DB를 처리하는 명령어임
		QuizDto call = new QuizDto(); //id와 name을 mapper.xml로 보내기 위해서는 객체(object=call)를 만들어 QuizDto를 호출해야 함. 
		call.setQuizid(i); //객체를 이용해 QuizDto에 있는 quizid에 i(라인 38에서 int로 변환) 값을 넣음.
		list = sqlSession.selectList("selectQuizdetail", call); //mapper.xml에 가서 select id="selectQuizdetail"실행함. 
		sqlSession.close();
		return list; //퀴즈임플에 List<QuizDto> list 반환.
	}
	//글의 개수 구하기.
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
	//답변 제출 메서드 추가
	public String asnwerWritePro(String ref, String language, String contents, String name) {
		System.out.println("model패키지-답변 처리 메서드");
		//압변 내용은 별도 테이블에 따로 저장
		QuizAnswerDto qanswerdto = new QuizAnswerDto(); //qanswerdto 임포트 내용 재정의
		Integer r = Integer.parseInt(ref);
		SqlSession sqlSession = factory.openSession();
		qanswerdto.setRef(r);
		qanswerdto.setLanguage(language);
		qanswerdto.setContents(contents);
		qanswerdto.setName(name);
		sqlSession.insert("answerwritePro", qanswerdto); //mapper.xml에 가서 select id="answerwritePro"실행함. 이 때 QuizDto에 값을 넣은 call (매개변수? 객체?)도 보냄. 
		
		sqlSession.commit();
		sqlSession.close();
		return null;
		
	}
	//답변 목록 메서드 추가
	public List<QuizAnswerDto> QAnswerList(String name){
		List<QuizAnswerDto> list = null;
		System.out.println("답변목록");
		QuizAnswerDto qanswerdto = new QuizAnswerDto();
		qanswerdto.setName(name);
		SqlSession sqlSession = factory.openSession(); //sqlSession은 마이바티스에서 DB를 처리하는 명령어임
		list = sqlSession.selectList("answerlist", qanswerdto); //mapper.xml에 가서 select id="answerlist" resultType="QuizAnswerDto" 실행함.
		sqlSession.close();
		return list;
		
	}
}
