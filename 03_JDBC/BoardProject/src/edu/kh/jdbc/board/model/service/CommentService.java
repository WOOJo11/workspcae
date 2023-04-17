package edu.kh.jdbc.board.model.service;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.common.Session;

public class CommentService {

	private CommentDAO commentDao = new CommentDAO(); 
	
	
	
	public int insertCommnet(int boardNo, String content, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int comment = commentDao.nextComment(conn);
		
		int result  = commentDao.insertCommnet(conn,boardNo, content, memberNo,comment);
		
		if (result >0) commit(conn);
		else rollback(conn);
		
		return result;
	}



	public List<Comment> checkComment(int num) throws Exception{
		Connection conn = getConnection();
		
		List<Comment> commentList = commentDao.checkComment(conn,num);
		
		close(conn);
		return commentList;
	}



	public int updateCommnet(int boardNo, int memberNo)throws Exception {
		Connection conn = getConnection();
		
		int result = CommentDao.updateComment(conn,);
		return result;
	}






	





}
