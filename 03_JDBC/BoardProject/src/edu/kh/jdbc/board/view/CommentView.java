package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.board.model.service.CommentService;
import edu.kh.jdbc.common.Session;

public class CommentView {
	private Scanner sc = new Scanner(System.in);

	private CommentService commentService = new CommentService();

	/**
	 * 댓글 메뉴
	 * 
	 * @param boardNo(상세 조회 중인 게시글 번호)
	 */
	public void commentMenu(int boardNo) {

		int input = -1;

		try {
			System.out.println("\n=== 댓글 기능 ===\n");
			System.out.println("1) 댓글 등록");
			System.out.println("2) 댓글 수정");
			System.out.println("3) 댓글 삭제");

			System.out.println("0. 댓글 기능 종료");

			System.out.print("\n선택 : ");
			input = sc.nextInt();
			sc.nextLine();

			switch (input) {
            	case 1: insertComment(boardNo);  break; // 댓글 등록
				
			// !wq가 입력 될 때 까지 댓글 내용을 입력 받고
				// 내용 , 게시글 번호 ,로그인 회원 번호를 이용해 
				// 댓글 삽입 서비스 호출  
			
	            case 2: updateComment(boardNo); break; // 댓글 수정
			
				// 댓글 번호를 입력받아서 
				// 1) 해당 댓글이 현재 게시글의 댓글이며 
				//    로그인한 회원이 쓴 댓글이 맞는지 확인
				//  2-1 ) 1번 결과가 맞지 않으면 "작성한 댓글만 수정할 수 있습니다"
				//  2-2 ) !wq가 입력될 때까지 내용 입력 후 
				// 		  댓글 번호, 내용을 이용해 댓글을 수정하는 서비스 호출
			
			
				
//	            case 3: deleteComment(boardNo); break; // 댓글 삭제
				
				// 댓글 번호를 입력받아서 
				// 1) 해당 댓글이 현재 게시글의 댓글이며 
				//  2-1 ) 1번 결과가 맞지 않으면 "작성한 댓글만 삭제할 수 있습니다"
				//  2-2 ) 정말로 삭제하시겠습니까 ? (Y/N) : 출력후 
				// 		  Y 입력시 삭제 서비스 호출
				// 		  N 입력시 취소되었습니다
			case 0:
				return;
			default:
				System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
			}

		} catch (InputMismatchException e) {
			System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
			sc.nextLine();
		}

	}


	private void insertComment(int boardNo) {
		System.out.println("\n===== 댓글 등록 =====\n");
		System.out.print("댓글 입력 : ");
		
	StringBuffer sb = new StringBuffer();
		
		System.out.println("<!wq 입력 시 종료>");
		
		while(true) {
			String str = sc.nextLine();
			
			if(str.equals("!wq")) break;
			sb.append(str);
			sb.append("\n");
			
		}
		try {
			int result = commentService.insertCommnet(boardNo,sb.toString(),Session.loginMember.getMemberNo());
			
			if(result > 0) {
				System.out.println("\n===== 등록 되었습니다 =====\n");
				
			}else {
				System.out.println("\n===댓글 등록에 실패하였습니다 ===\n");
			}
				
			
		} catch (Exception e) {
			System.out.println("\n*** 댓글 등록 중 예외 발생  ***\n");
			e.printStackTrace();
		}
		
		
		
	}

	private void updateComment(int boardNo) {
		System.out.println("\n===== 댓글 수정 =====\n");
		System.out.print("수정할 댓글 번호를 입력하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		int check = 0;
		
		try {
			List<Comment> commentList = commentService.checkComment(boardNo);
			
			if(commentList.isEmpty()) {
				System.out.println("존재하는 댓글이 없습니다");
				return;
			}
			for(Comment c : commentList) {
				check++;
				
				
				if(check>0) {
					System.out.println("\n===== 게시글 수정 =====\n");
					System.out.print("수정할 제목 : ");
					String title = sc.nextLine();
					
					// StringBuffer (가변성)
					StringBuffer sb = new StringBuffer();
					
					
					System.out.println("<!wq 입력 시 종료>");
					// 특정 단어가 입력 될 때 까지 무한히 입력
					while(true) {
						String str = sc.nextLine();
						
						if(str.equals("!wq")) break;
						sb.append(str);
						sb.append("\n");
						
				int result = commentService.updateCommnet(boardNo,Session.loginMember.getMemberNo());
					
					
				}
				
				
			
			}
			
			
			
			
			
			
		
		
	
		
				
				
			
			
			
		
		
		
	}
}
