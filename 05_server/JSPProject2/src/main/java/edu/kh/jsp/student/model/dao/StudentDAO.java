package edu.kh.jsp.student.model.dao;


import static edu.kh.jsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.dto.Student;

public class StudentDAO {
	
	// JDBC 객체 저장용 참조 변수 선언
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자로 객체가 생성될 때  
	// sql이 작성된 xml 파일을 읽어와 prop에 저장
	public StudentDAO() {
		
		try {
			
		String filePath = 
			StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
		prop = new Properties();
		prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Student> selectAll(Connection conn) throws Exception {
		
		// 1. 결과 저장용 변수 생성
		List<Student> stdList = new ArrayList<>();
		
		try {
			// 2. sql 작성
			String sql = prop.getProperty("selectAll");
			
			// 3. Statement 객체 사용
			
			stmt = conn.createStatement();
			
			// 4. sql 수행 후 결과 (resultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 5. List에 옮겨 담기
			
			while(rs.next()) {
				
			String studentNo = rs.getString("STUDENT_NO");
			String studentName= rs.getString("STUDENT_NAME");
			String studentAddress = rs.getString("STUDENT_ADDRESS");
			String departmentName = rs.getString("DEPARTMENT_NAME");
			
			Student student 
			= new Student(studentNo, studentName, studentAddress, departmentName);
				
			stdList.add(student);
			}
			
			
		} finally {
			close(rs);
			close(stmt);
			

		}
		
		
		
		return stdList;
	}
	
	
	

}
