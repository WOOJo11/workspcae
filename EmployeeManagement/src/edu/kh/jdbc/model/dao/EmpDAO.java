package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;


public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public List<Emp> selectAll(Connection conn) throws SQLException {
		
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			// 2. Statement , ResultSet에 객체 대입
			
			// 1) SQL 작성
			String sql = "SELECT EMP_ID , EMP_NAME,DEPT_TITLE,JOB_NAME,SALARY,PHONE,EMAIL\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY JOB_CODE ASC";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
				while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				
				Emp st = new Emp(empId,empName,departmentTitle,jobName,salary,phone,email);
				
				empList.add(st);		
			}
			
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		
		
		return empList;
	}
	public List<Emp> selectRetire(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		// 2. Statement , ResultSet에 객체 대입
		
		try {
			// sql 작성을 해야해
			
			String sql = "SELECT EMP_ID,EMP_NAME,PHONE,EMAIL,ENT_DATE\r\n"
					+ "FROM EMPLOYEE e \r\n"
					+ "WHERE ENT_YN = 'Y'";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5);
				
				Emp em = new Emp(empId,empName,phone,email,entDate);
				
				empList.add(em);
			}
			
			
			
		} finally {
			close(rs);
			close(stmt); 
			
		}
		
		
		
		return empList;
	}
	public Emp selectOne(Connection conn, int input) throws SQLException {
		
		// 객체 저장용 변수 선언하자
		Emp em = null;
		
		try {
			String sql = "SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME,SALARY "
					+ ",PHONE,EMAIL,HIRE_DATE,ENT_YN\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "AND EMP_ID = " + input;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
	
		if(rs.next()) {
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			String departmentTitle = rs.getString(3);
			String jobName = rs.getString(4);
			int salary = rs.getInt(5);
			String phone = rs.getString(6);
			String email = rs.getString(7);
			Date hireDate = rs.getDate(8);
			String entYN = rs.getString(9);
			
			
			em = new Emp(empId, empName, email, phone, salary, entYN,
					departmentTitle, hireDate, jobName);
			
		}
		
			
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		
		
		
		return em;
	}
	public int addEmp(Connection conn, Emp em)throws SQLException  {
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,"
					+ "?,?,?,?,?,?,?,?,?,?,SYSDATE, NULL, 'N')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, em.getEmpName());
			pstmt.setString(2,em.getEmpNo());
			pstmt.setString(3,em.getEmail());
			pstmt.setString(4,em.getPhone());
			pstmt.setString(5,em.getDeptCode());
			pstmt.setString(6,em.getJobCode());
			pstmt.setString(7,em.getSalLevel());
			pstmt.setInt(8, em.getSalary());
			pstmt.setDouble(9, em.getBonus());
			pstmt.setInt(10, em.getManagerId());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int updateEmp(Connection conn, Emp em)throws SQLException {
		int result = 0;
		
		try {
			
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "	 PHONE = ?,\r\n"
					+ " 	SALARY = ?\r\n"
					+ "WHERE EMP_ID = ?";
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, em.getEmail());
			pstmt.setString(2, em.getPhone());
			pstmt.setInt(3, em.getSalary());
			pstmt.setInt(4, em.getEmpId());
	
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}
	public int deleteEmp(Connection conn, int input)throws SQLException {
		int result = 0;
		
		try {
			String sql = "DELETE FROM EMPLOYEE \r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		return result;
	}
	public int empRetire(Connection conn, int input)throws SQLException {
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE "
					+ "SET ENT_YN = 'Y', "
					+ "ENT_DATE = SYSDATE "
					+ "WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		
		}
		
		
		
		return result;
	}
	public List<Emp> recentHire(Connection conn) {
		
		List<Emp> empList = new ArrayList<>();
		
		
		try {
			String sql = ""
			
		} finally {
			
		}
		
		
		return null;
	}
}
