package edu.kh.project.myPage.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface AjaxService {

	/** 이메일로 닉네임 조회
	 * @param email
	 * @return
	 */
	String selectNickname(String email);

	/** 닉네임으로 전화번호 조회
	 * @param nickname
	 * @return
	 */
	String selectMemberTel(String nickname);


	/** 이메일 중복검사
	 * @param email
	 * @return
	 * count
	 */ 
	
	int checkEmail(String email);
	

	/** 닉네임 중복검사
	 * @param nickname
	 * @return
	 * count
	 */
	int checkNickname(String nickname);

	
	
	/** 입력한 이메일로 일치하는 회원 정보 모두 조회
	 * @param email
	 * @return
	 */
	Member selectMember(String email);

	/** 이메일이 일부라도 일치하는 모든회원 조회
	 * @param input
	 * @return
	 */
	List<Member> selectMemberList(String input);

}
