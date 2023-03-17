package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample2 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1단계 : JDBC 객체 참조 변수 선언
		
		Connection conn = null; 
		// DB 연결 정보를 담은 객체 이 정보를 이용해 Java와 DB 연결 통로 생성
		
		Statement stmt = null;
		// Connection을 이용해서 SQL을 DB에 전달하여 수행 후 결과를 반환 받는 객체
		
		ResultSet rs = null; 
		// SELCET 수행 결과를 저장하는 객체 -> 커서로 1행씩 접근
		
		
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB연결에 필요한 JDBC 드라이버를 메모리 로드(객체로 생성)
			// -> DriverManager가 Connection 생성시 자동으로 생성
				
			//  Connection 생성 시 필요한 값을 미리 변수에 대입
				
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_jwh";
			String pw = "oracle_jwh123A";	
			
			// Connection 생성
			
			conn = DriverManager.getConnection(type+ip+port+dbName,user,pw );
			
			// 2단계 : 참조 변수에 알맞은 객체 대입
			
			// 3단계 : SQL 수행 결과로 받은 ResultSet을
			// 첫 번째 행부터 1행씩 접근하여 컬럼 값을 얻어와 출력
			
			// Statement (통로를 이동하는 객체) 생성
			
			stmt = conn.createStatement();
			
			
			System.out.print("급여 기준 입력 : ");
			int input = sc.nextInt();
			
			// SQL 작성 
			// 급여를 300만 이상 받는 사원의 이름 급여
			String sql = "SELECT EMP_NAME,SALARY,JOB_CODE, HIRE_DATE "
					+ "FROM EMPLOYEE WHERE SALARY >=" +input 
					+ " ORDER BY SALARY DESC";
			
			// Statement 객체를 이용해 
			// SQL(select)수행 후 결과 (resultset) 반환 받기
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String jobCode = rs.getString("JOB_CODE");
				Date hireDate = rs.getDate("HIRE_DATE");
				
				System.out.printf("이름 : %s / 급여 : %d  / 직급코드 : %S / 입사일 : %s \n",
								  empName,salary,jobCode,hireDate.toString());
				
			}
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4단계 : 사용한 JDBC 객체 자원 반환
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// 4단계 : 사용한 JDBC객체 자원 반환 순서는 역순
			
		}
		
		
		
		
		
	}
	
}
