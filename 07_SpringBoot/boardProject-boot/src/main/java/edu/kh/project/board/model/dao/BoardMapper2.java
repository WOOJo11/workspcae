package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;

/**
 * @author user1
 *
 */
@Mapper
public interface BoardMapper2 {



	
	/** 게시글 삽입
	 * @param board
	 * @return
	 */
	public int boardInsert(Board board) ;


	/** 이미지 리스트(여러개) 삽입
	 * @param uploadList
	 * @return
	 */
	public int insertImageList(List<BoardImage> uploadList) ;


	/** 게시글 수정
	 * @param board
	 * @return result
	 */
	public int boardUpdate(Board board) ;


	/** 게시글 이미지 수정
	 * @param deleteMap
	 * @return
	 */
	public int imageDelete(Map<String, Object> deleteMap) ;


	/** 게시글 이미지 수정 업데이트관련
	 * @param img
	 * @return
	 */
	public int imageUpdate(BoardImage img);


	/** 게시글 수정 (1개)이미지 삽입 
	 * @param img
	 * @return
	 */
	public int imgInsert(BoardImage img);


	/** 게시글 삭제
	 * @param boardCode
	 * @param boardNo
	 * @return
	 */
	public int boardDelete(Board board);

	
	
}
