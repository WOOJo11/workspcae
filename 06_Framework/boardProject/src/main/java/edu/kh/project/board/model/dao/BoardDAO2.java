package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;

/**
 * @author user1
 *
 */
@Repository
public class BoardDAO2 {

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 게시글 삽입
	 * @param board
	 * @return
	 */
	public int boardInsert(Board board) {
		int result = sqlSession.insert("boardMapper.boardInsert",board);	
		// -> sql 수행 후 매개변수 board 객체에는 boardNo가 존재 O/X
		
		// 삽입 성공 시 
		if(result >0 ) result = board.getBoardNo();
		
		
		return result;
	}


	/** 이미지 리스트(여러개) 삽입
	 * @param uploadList
	 * @return
	 */
	public int insertImageList(List<BoardImage> uploadList) {
		
		int result = sqlSession.insert("boardMapper.insertImageList",uploadList);
		
		return result;
	}


	/** 게시글 수정
	 * @param board
	 * @return result
	 */
	public int boardUpdate(Board board) {
		
		return sqlSession.update("boardMapper.boardUpdate",board);
	}


	/** 게시글 이미지 수정
	 * @param deleteMap
	 * @return
	 */
	public int imageDelete(Map<String, Object> deleteMap) {
		
		return sqlSession.delete("boardMapper.imageDelete",deleteMap);
	}


	/** 게시글 이미지 수정 업데이트관련
	 * @param img
	 * @return
	 */
	public int imageUpdate(BoardImage img) {
		
		return sqlSession.update("boardMapper.imageUpdate",img);
	}


	/** 게시글 수정 (1개)이미지 삽입 
	 * @param img
	 * @return
	 */
	public int imgInsert(BoardImage img) {
		
		return sqlSession.insert("boardMapper.imgInsert",img);
	}


	/** 게시글 삭제
	 * @param boardCode
	 * @param boardNo
	 * @return
	 */
	public int boardDelete(Board board) {
	
		return sqlSession.update("boardMapper.boardDelete",board);
	}


	
	
}
