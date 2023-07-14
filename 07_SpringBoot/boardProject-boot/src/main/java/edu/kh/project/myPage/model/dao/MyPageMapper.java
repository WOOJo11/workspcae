package edu.kh.project.myPage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Mapper// 저장소(DB)와 관련된 클래스 + Bean 등록
public interface MyPageMapper {
	
	// 등록된 Bean 중 타입이 SqlSessionTemplate으로 일치하는 Bean을 주입(DI)
	// -> root-context.xml <bean> 작성됨 

	/** 회원 정보 수정 DAO
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember);

	
	
	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return
	 */
	public String selectEncPw(int memberNo);



	public int changePw(Member member);
		// Mybatis에서 SQL수행 시 
		// 전달할 수 있는 파라미터는 딱 하나
		// ->여러 파라미터를 전달해야 하는 경우
		// Map 또는 DTO로 묶어서 전달
		

		
	






	/** 회원 탈퇴 DAO
	 * @param memberNo
	 * @return
	 */
	public int secession(int memberNo);
		
		// sqlSessionTemplate : 마이바티스 + DBCP + close 자동 +트랜잭션
	




	public int updateProfileImage(Member loginMember);
	

	
	
	
	
}
