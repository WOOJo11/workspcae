package edu.kh.jdbc.mian.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MainDAO {

	// 필드
	// JDBC 객체 참조 변수
	
	private Statement stmt; // SQL 수행, 결과 반환
	private PreparedStatement pstmt; // placeholder를 포함한 SQL세팅/ 수행
	private ResultSet rs; // SELECT 수행결과 저장
	
	private Properties prop;
	// -- Map<String ,String> 형태
	// -- 스트링으로 고정되어있음
	// -- XML 파일 입/출력 메서드를 제공한다 
	
	
	public MainDAO() { // 기본 생성자 없으면 자바에서 자동 생성
		// DAO 객체가 생성될 때 XML 파일을 읽어와 Properties 객체에 저장
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("main-sql.xml"));
			// -> properties 객체에 
			// key:value 형식으로 xml내용이 저장됨
			// -> prop.getProperty("key") 호출
			// -> value 반환 == SQL
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/** 아이디, 비밀번호 일치 회원 조회 
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws Exception{
		// 1. 결과 저장용 변수선언 /  객체생성 
		Member member = null;
		
		try {
			 // 2. SQL 작성 후 수행 
			String sql = prop.getProperty("login");
			// preparedStatement 객체를 생성하고 SQL을 담아둠 
			pstmt = conn.prepareStatement(sql);
			
			// placeholder에 알맞은 값 대임
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			// 3. 조회 결과를 1행씩 접근해서 얻어오기
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				// 입력 받은 아이디 == 조회한 아이디 
				// 따로 얻어올 필요가 없다 
				String memberName = rs.getNString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				String enrollDate = rs.getString("ENROLL_DT");
				
				// Member 객체 생성 후 값 세팅
				
				member = new Member();
				
				member.setMemberNo(memberNo);
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				member.setEnrollDate(enrollDate);
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
			
			
		}
		
		
		return member;
	}

	/** 아이디 중복처리 
	 * @param conn
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public int idDuplicationCheck(Connection conn, String memberId)throws Exception {
		
		int result = 0;
		
		
		try {
			String sql = prop.getProperty("idDuplicationCheck");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);

			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return result;
	}

	public int signUp(Connection conn, Member member) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}
	
	
}
