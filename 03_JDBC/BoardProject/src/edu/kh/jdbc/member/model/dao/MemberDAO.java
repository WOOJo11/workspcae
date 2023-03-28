package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {

	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// xml에 작성된 SQL을 읽어와 저장할 객체 참조 변수
	private Properties prop;
	
	public MemberDAO() { // 기본 생성자로 객체 생성시 XML 읽어오기
		try {
			
		 prop = new Properties();
		 prop.loadFromXML(new FileInputStream("member-sql.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Member> selectMemberList(Connection conn) throws Exception{
		List<Member> memberList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectMemberList");
			
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getNString("MEMBER_NM");
				String memberGender = rs.getString("성별");
				
				
				Member member = new Member();
				
				
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				
				memberList.add(member);
			}
				
			
			
		} finally {
			close(rs);
			close(stmt);
			
		} 
			
		
		return memberList;
		
	}

	public int updateMember(Connection conn, String memberName, String memberGender, int memberNo)
	throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender);
			pstmt.setInt(3, memberNo );
			
			
			result = pstmt.executeUpdate();
			
		} finally { 
			close(pstmt);
		
		}
		
		
		
		return result;
	}

	public int updatePassword(Connection conn, String nowPw, String newPw, int memberNo)
	throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePassword");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,newPw );
			pstmt.setString(2, nowPw );
			pstmt.setInt(3, memberNo );
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int unregisterMember(Connection conn, String pw, int memberNo)throws Exception {
		int result = 0;
		
		try { 
			String sql = prop.getProperty("unregisterMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo );
			pstmt.setString(2, pw);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
}
