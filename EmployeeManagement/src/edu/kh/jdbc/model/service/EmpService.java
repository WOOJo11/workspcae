package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;


public class EmpService {

	private EmpDAO dao = new EmpDAO();

	public List<Emp> selectAll() throws SQLException{
		// 1. 커넥션 생성
		Connection conn = getConnection(); 
		// 2. DAO의 메서드를 호출하여
				
		List<Emp> empList = dao.selectAll(conn);
		
		close(conn);
		return empList;
		
		
	}

	public List<Emp> selectRetire() throws SQLException {
		// 1. 커넥션을 생성
		Connection conn = getConnection();
		
		// 2 DAO의 메서드를 호출해서 저장할 공간 
		
		List<Emp> empList = dao.selectRetire(conn);
		
		close(conn);
		
		return empList;
	}

	public Emp selectOne(int input)throws SQLException {
	// 1. 커넥션을 생성해줌
		Connection conn = getConnection();
		
		// 2 Dao의 메서드 호출
		Emp em = dao.selectOne(conn,input);
		
		close(conn);
	
		return em;
	}

	public int addEmp(Emp em)  throws SQLException {
		Connection conn = getConnection();
		
		int result = dao.addEmp(conn,em);
		if(result > 0) 
			commit(conn);
			else rollback(conn);
		
		close(conn);
		return result ;
	}

	public int updateEmp(Emp em) throws SQLException{
		Connection conn = getConnection();
		
		int result = dao.updateEmp(conn,em);
		if(result>0)commit(conn);
		else rollback(conn);
		return result;
	}

	public int delete(int input) throws SQLException{
		Connection conn = getConnection();
		
		int result = dao.deleteEmp(conn,input);
		if(result>0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	public int empRetire(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.empRetire(conn,input);
		
		if(result>0)commit(conn);
		else rollback(conn);
		
		return result;
	}

	public List<Emp> recentHire() {
		
		Connection conn = getConnection();
		List<Emp> empList = dao.recentHire(conn);
		
		return null;
	}
	
	
	
}
