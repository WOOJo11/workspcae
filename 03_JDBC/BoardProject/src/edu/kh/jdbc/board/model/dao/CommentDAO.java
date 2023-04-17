package edu.kh.jdbc.board.model.dao;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;


public class CommentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 댓글 목록 조회 SQL수행
	 * @return CommentList
	 * @throws Exception
	 */
	public List<Comment> selecCommentList(Connection conn,int input) throws Exception{
		
		// 결과 저장용 객체
		List<Comment> commentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectCommentList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Comment c = new Comment();
				
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				
				commentList.add(c);
			}
				
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return commentList;
	}

	public int insertCommnet(Connection conn, int boardNo, String content, int memberNo, int comment) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, comment);
			pstmt.setString(2, content);
			pstmt.setInt(3, memberNo);
			pstmt.setInt(4, boardNo);
			
			result  = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int nextComment(Connection conn) throws Exception{
		int comment = 0;
		
		try {  
			String sql = prop.getProperty("nextCommentNo");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // 단일행으로 조회 
			
			if(rs.next()) {
				comment =  rs.getInt(1);
				
				
			}
			
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return comment;
	}

	public List<Comment> checkComment(Connection conn, int num)throws Exception {
		List<Comment> commentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("checkComment");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,num );
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int commnetNo = rs.getInt(1);
				int memberNo =rs.getInt(2);
				int boardNo = rs.getInt(3);
				
				Comment comment = new Comment();
				
				comment.setBoardNo(commnetNo);
				comment.setBoardNo(memberNo);
				comment.setBoardNo(boardNo);
				
				commentList.add(comment);
				
				
			}
				
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return commentList;
	}

	

	

	
	
	
}
