package edu.kh.project.myPage.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;

@SessionAttributes({"loginMember"})
// 1) model에 세팅된 값의 key와 {}작성된 값이 일치하면 session scope로 이동

// 2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게함
//    -> @SessionAttribute(key)로 사용



@RequestMapping("/myPage") //  / myPage로 시작하는 요청을 모두 받음
@Controller // 요청 / 응답 제어 클래스  +  Bean 등록 (IOC)
public class MyPageController {

	@Autowired // MyPageService의 자식 impl 의존성 주입 (DI)
	// 인터페이스이기에 객체 생성 불가능
	private MyPageService service;
	
	@GetMapping("/info")
	public String info() {
		
		// ViewResolver 설정 - > servlet-context.xml
		return "/myPage/myPage-info";
	}
	
	// 프로필 페이지 이동
	@GetMapping("/profile")
	public String profile() {
		
		return "myPage/myPage-profile";
	}
	
	// 비밀번호 변경 페이지
	@GetMapping("/changePw")
	public String changePw() {
		
		return "myPage/myPage-changePw";
	}
	
	// 탈퇴 페이지 이동
	
	@GetMapping("/secession")
	public String secession() {
		
		return "myPage/myPage-secession";
	}
	
	// 회원 정보 수정
	
	@PostMapping("/info")
	public String updateInfo(Member updateMember, String[] memberAddress
			,@SessionAttribute("loginMember") Member loginMember
			, RedirectAttributes ra) {
		
		// ---------- 매개 변수 설명 ----------
		// MEMBER updateMember : 수정할 닉네임, 전화번호가 담긴 커맨드 객체
		// String[] memberAddress : name="memberAddress"인 input 3개의 값(주소)
		
		// @SessionAttribute("loginMember") Member loginMember
		// : Session에서 얻어온 "loginMember"에 해당하는 객체를
		// 	매개변수 Member loginMember에 저장
		
		// ------------------------------------
		

		// 주소 하나로 합치기(a^^^b^^^c)
		String addr = String.join("^^^", memberAddress);
		updateMember.setMemberAddress(addr);
		
		// 로그인한 회원의 번호를 updateMember에 추가
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		// 회원 정보 수정 서비스 호출
		int result = service.updateInfo(updateMember);
		String message = null;
		
		if(result > 0) { // 성공
		
		message =  "회원정보 수정이 완료되었습니다";
		
		// Session 로그인된 회원 정보도 수정(동기화)
		
		loginMember.setMemberNickname(updateMember.getMemberNickname());
		loginMember.setMemberTel(updateMember.getMemberTel());
		loginMember.setMemberAddress(updateMember.getMemberAddress());
			
		}else { // 실패
			message = "회원정보 수정 실패";
			
		}
	
		ra.addFlashAttribute("message",message);
		
		return "redirect:info";
	}
	
	
	@PostMapping("changePw")
	public String changePw(String currentPw, String newPw
			, @SessionAttribute("loginMember") Member loginMember
			, RedirectAttributes ra ) {
		
	
		// 로그인한 회원의 번호 (어떤 회원의 정보인지 알아야함)
		int memberNo = loginMember.getMemberNo();
		
		// 비밀번호 변경 서비스 호출
		
		int result = service.changePw(currentPw,newPw,memberNo);
		String path = "redirect:";
		String message = "null";
		
		if(result >0) {
			message = "비밀번호 변경되었습니다.";
			path +="info";
		}else {
			message ="현재 비밀번호가 일치하지 않습니다";
			path +="changePw";
		}
		
		ra.addFlashAttribute("message",message);
		
		return path;
	}
	
	@PostMapping("secession")
	public String secession(String memberPw,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra,
			SessionStatus status,
			
			HttpServletResponse resp) {
		
		// String memberPw : 입력한 비밀번호
		// SessionStatus status : 세션 관리 객체
		// HttpServletResponse resp : 서버 -> 클라이언트 응답하는 방법 제공
		
		// 1. 로그인한 회원의 회원번호
		int memberNo = loginMember.getMemberNo();
		
		// 2. 회원 탈퇴 서비스 호출 
		// - 비밀번호가 일치하면 MEMBER_DEL_FL -> Y로 바꾸고 1반환
		// - 비밀번호가 일치하지 않으면 -> 0반환
		int result = service.secession(memberPw,memberNo);
		String path ="redirect:";
		String message = "null";
		
		// 3. 탈퇴 성공 시 
		if(result >0) {

			// message : 탈퇴 되었습니다
			message ="회원탈퇴가 완료되었습니다";
			
			// - 메인 페이지로 redirect 
			path +="/";

			
			// - 로그아웃
			status.setComplete();
			
			
			// + 쿠키 삭제
		
			Cookie cookie = new Cookie("saveId", "");
			// 같은 쿠키가 이미 존재하면 덮어쓰기 된다
			
			cookie.setMaxAge(0);
			cookie.setPath("/");
			resp.addCookie(cookie); // 요청 객체를 통해서 클라이언트에게 전달
									// -> 클라이언트 컴퓨터에 파일로 생성
		
			
		}
		
		// 4. 탈퇴 실패 시
		// - message : 현재 비밀번호가 일치하지 않습니다.
		// - 회원 탈퇴 페이지로 리다이렉트
		else {
			message = "현재 비밀번호가 일치하지 않습니다" ;
			path +="secession";
			
			
			
		}
		ra.addFlashAttribute("message",message);
		
		return path; 
	}
	 
	
	
	
	
}
