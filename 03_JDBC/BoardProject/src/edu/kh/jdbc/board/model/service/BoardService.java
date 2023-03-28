package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dto.Board;

// 데이터 가공 , 트랜잭션 처리
public class BoardService {

	private BoardDAO dao = new BoardDAO();

	public List<Board> selectAllBoard() throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectAllBoard(conn);
		
		close(conn);
		
		return boardList;
	}

	public Board selectBoard(int input, int memberNo) throws Exception {
		
		// 1) 커넥션 생성
		Connection conn = getConnection();
		// 2) 게시글 상세 조회 DAO메서드 호출
		Board board = dao.selectBoard(conn,input);
		// 3) 게시글이 조회된 경우
		if(board != null) {
			// 4) 조회수 증가
			// 단, 게시글 작성자와 로그인한 회원이 다를 경우 증가 
			if(board.getMemberNo()!= memberNo) {
				// 조회한 게시글 회원 != 로그인한 회원번호 
				
				// 5) 조회 수 증가 DAO 메서드 호출 (UPDATE)
				int result = dao.updateReadCount(conn,input);
				
				// 6) 트랜잭션 제어처리 + 데이터 동기화 처리
				if(result > 0) {
					commit(conn);
					// 조회된 board의 조회수0
					// Db는 1
					
					
					board.setReadCount(board.getReadCount()+1);
					
				}else { 
					rollback(conn);
				}
				
			}
		}
		
		// 7)커넥션 반환
		close(conn);
		// 8)결과 반환
		return board;
	}

	public int updateBoard(String title, String content, int boardNo) throws Exception {
		Connection conn = getConnection();
		
		int result  = dao.updateBoard(conn,title,content,boardNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	/** 게시글 삭제
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn,boardNo);
		
		if (result >0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int insertBoard(String title, String content, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int boardNo = dao.nextBoardNo(conn);
		
		int result = dao.insertBoard(conn,title,content,memberNo,boardNo);
		
		if(result >0 ) {
			commit(conn);
			result = boardNo;
		}else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
}
