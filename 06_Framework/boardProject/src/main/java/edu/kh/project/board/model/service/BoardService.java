package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;




public interface BoardService {

	List<Map<String, Object>> selectBoardTypeList();

	Map<String, Object> selectBoardList(int boardCode, int cp);

	Board selectBoard(Map<String, Object> map);

	/** 좋아요 여부확인
	 * @param map
	 * @return
	 */
	int boardLikeCheck(Map<String, Object> map);

	/**	좋아요 처리서비스
	 * @param paramMap
	 * @return
	 */
	int like(Map<String, Integer> paramMap);

	
	
	/** 조회수 증가 서비스
	 * @param boardNo
	 * @return
	 */
	int updateReadCount(int boardNo);

	
	




	
}
