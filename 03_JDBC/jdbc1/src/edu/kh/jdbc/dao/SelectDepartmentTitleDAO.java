package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Emloyee1;

// DAO ( Data Access Object) : 데이터에 접근하기 위한 객체
// == DM와 연결 역할 객체

public class SelectDepartmentTitleDAO {

	public List<Emloyee1> select (String departmentTitle){
		
		// 조회 결과를 저장하고 반환할 때 사용할 list생성
		List<Emloyee1> empList = new ArrayList<>();
		
		// 1단계 : JDBC 객체 참조 변수 선언
		
		Connection conn = null; // DB 연결 정보 저장 Statement 통로
		Statement stmt = null; // SQL 수행, 결과 반환
		ResultSet rs = null; // SELECT 수행 결과 저장용 객체
		
		// 2단계 : 참조 변수에 알맞은 값 대입
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 메모리에 드라이버 객체 로드
			
			// DB 연결 정보
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_jwh";
			String pw = "oracle_jwh123A";	
		
			// DriverManager를 이용해 Connection 생성하여 얻어오기
			conn = DriverManager.getConnection(type+ip+port+dbName,user,pw ); //url
		
			String condition = null;
			if (departmentTitle.toLowerCase().equals("null")) {
				condition = "WHERE DEPT_TITLE IS NULL";
				
			}else {
				condition = "WHERE DEPT_TITLE = '" + departmentTitle + "'";
			}
					
			
			String sql = "SELECT EMP_ID,EMP_NAME,SALARY,DEPT_TITLE "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ condition
					//+ "WHERE DEPT_TITLE = '" + departmentTitle + "'"
					+ " ORDER BY EMP_ID";
			
			stmt = conn.createStatement(); // Statement 객체 생성
			
			
			rs = stmt.executeQuery(sql);rs = stmt.executeQuery(sql);
			// SELECT 수행 후 결과 반환 받기 위에 내용	
			while(rs.next()) {
				
				//String empId = rs.getString("EMP_ID");
				String empId = rs.getString(1);
				//String empName = rs.getString("EMP_NAME");
				String empName = rs.getString(2);
//				int salary = rs.getInt("SALARY");
				int salary = rs.getInt(3);
				String title = rs.getString(4);
				
				// 조회된 컬럼 값을 Employee 객체에 저장 
				Emloyee1 emp = new Emloyee1(empId,empName,salary,title);
				
				// 컬럼 값이 저장된 객체를 empList에 추가 하겠다
				empList.add(emp);
				
				
		
				
				
				
			}
			
			
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close(); 
				if(conn != null) conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return empList; // 조회 결과가 담긴 empList 반환
		
		
		
	}
	
	
	
	
	
	
	
	
}
