package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원정보 수정 
	 * @param updateMember
	 * @return
	 */
	int updateInfo(Member updateMember);

	
	
	/** 비밀번호 변경 서비스
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result 
	 */
	int changePw(String currentPw, String newPw, int memberNo);



	/** 회원 탈퇴 서비스
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 */
	int secession(String memberPw, int memberNo);
	
	
	

}
