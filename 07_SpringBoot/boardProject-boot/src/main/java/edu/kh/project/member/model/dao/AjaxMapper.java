package edu.kh.project.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {
	public String selectNickname(String email);

	public String selectMemberTel(String nickname);
	
	public int checkEmail(String email);
	
	public int checkNickname(String nickname);

	public Member selectMember(String email);
	
	public List<Member> selectMemberList(String input);
}
