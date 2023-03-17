package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {

	public List<Employee2> select(String input) {
	
		List<Employee2> empList = new ArrayList<>();
		
		
		
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null; 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_jwh";
			String pw = "oracle_jwh123A";	
		
			// DriverManager를 이용해 Connection 생성하여 얻어오기
			conn = DriverManager.getConnection(type+ip+port+dbName,user,pw );
			
			
			
			
			String sql = "SELECT NVL(DEPT_TITLE,'부서없음'),JOB_NAME,EMP_NAME,EMAIL "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "JOIN JOB USING (JOB_CODE) "
					+ "WHERE JOB_NAME = '" + input + "' " 
					+ "ORDER BY EMP_NAME ";
					
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);rs = stmt.executeQuery(sql);
		
while(rs.next()) {
				
				String deptTitle = rs.getString(1);
			
				String jobName = rs.getString("JOB_NAME");
				
				String empName = rs.getString("EMP_NAME");
				
				String email = rs.getString("EMAIL");
				
				// 조회된 컬럼 값을 Employee 객체에 저장 
				Employee2 emp = new Employee2 (deptTitle,jobName,empName,email);
				
				// 컬럼 값이 저장된 객체를 empList에 추가 하겠다
				empList.add(emp);
				
				
				
				
			}
				
			
		
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return empList;
	}
}
