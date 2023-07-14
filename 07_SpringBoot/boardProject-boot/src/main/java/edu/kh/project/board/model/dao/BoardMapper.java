package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;

@Mapper
public interface BoardMapper {

	List<Map<String, Object>> selectBoardTypeList();

	

	/** 특정 게시판의 삭제되지 않은 게시글 수 조회
	 * @param boardCode
	 * @return listCount
	 */
	public int getListCount(int boardCode);
		
	
	



	/** 특정 게시판에서 현재 페이지에 해당하는 게시글 목록 조회
	 * @param pagination
	 * @param boardCode
	 * @return
	 */
	public List<Board> selectBoardList(int boardCode,RowBounds rowBounds);
		
		// RowBounds 객체 
		// - 마이바티스에서 페이징처리를 위해 제공하는 객체
		// - offset 만큼 건너 뛰고
		// 그 다음 지정된 행 개수(limit)만큼 조회


		
		// 3) selectList("namespace.id",파라미터,Rowbounds)
	



	public Board selectBoard(Map<String, Object> map);



	public int boardLikeCheck(Map<String, Object> map);


	public int insertBoardLike(Map<String, Integer> paramMap);



	public int deleteBoardLike(Map<String, Integer> paramMap);



	public int countBoardLike(Integer boardNo);



	public int updateReadCount(int boardNo);
	
	 /** 게시글 수 조회(검색)
	    * @param paramMap
	    * @return listCount
	    */
	   public int getSearchListCount(Map<String, Object> paramMap);

	/** 게시글 목록 조회(검색)
	    * @param pagination
	    * @param paramMap
	    * @return boardList
	    */
	   public List<Board> selectSearchBoardList(Map<String, Object> paramMap, RowBounds rowBounds);
	
	
	
	
	/** 헤더 검색
	 * @param query
	 * @return list
	 */
	public List<Map<String, Object>> headerSearch(String query);



	/** 이미지 파일 목록 조회
	 * @return
	 */
	public List<String> selectImageListAll();	
	
}
