package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Employee;

// DAO (Date Access Object ) : DB 접근용 객체

// JDBC 구문이 여러 번 작성될 예정
// -> JDBC 객체 참조 변수가 계속 작성될 예정
//  -> 필드로 작성하여 재사용 
public class EmployeeDAO {
	private Statement stmt;
	private ResultSet rs;
	
	
	/** 전체 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException{
		
		// 1. 결과 저장을 위한 변수 / 객체 준비
		
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement , ResultSet에 객체 대입
			
			// 1) SQL 작성
			
			String sql = "SELECT EMP_ID,EMP_NAME, "
					+ "NVL(DEPT_TITLE,'없음')DEPT_TITLE, JOB_NAME, NVL(PHONE,'없음')PHONE "
					+ "FROM EMPLOYEE "
					+ 	"NATURAL JOIN JOB "
					+ 	"LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ 	"ORDER BY JOB_CODE";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
while(rs.next()) {
				
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String departmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				Employee emp = new Employee (Integer.parseInt(empId),empName,
						departmentName,jobName,phone);
						
				empList.add(emp);
				
				
			}
			
			
			
		}finally {
			
			// catch 문이 없어..대신  throws 구문으로 예외처리 
			
			// 4. JDBC 객체 자원 반환 (단, conn빼고)
			close(stmt);
			close(rs);
			
		}
		
		// 5. 결과 반환
		
		return empList;
	}


	/** 사원 한명을 조회하는 SQL수행 후 결과 반환하는 메서드
	 * @param conn
	 * @param input
	 * @return
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException {
		
		// 1. 결과 저장을 위한 변수 / 객체 준비
		
		Employee emp = null;
		// -> 조회 결과가 있을경우에 객체 생성
		
		try {
			// 2. SQL 작성 후 수행 구문
			
			String sql = "SELECT EMP_ID,EMP_NAME, "
					+ "NVL(DEPT_TITLE,'없음')DEPT_TITLE, JOB_NAME, NVL(PHONE,'없음')PHONE "
					+ "FROM EMPLOYEE "
					+ 	"NATURAL JOIN JOB "
					+ 	"LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ 	"WHERE EMP_ID = "+ input;
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);		
			
			// 3. 조회 결과 반환
			// 있으면 Employee 객체 생성 후 emp에 대입
			
			if (rs.next()) {
				int empId = rs.getInt(1);
				// DB에서 값을 얻어올 때
				// "숫자" (문자열로된 숫자) 형태일 경우
				// getInt()를 작성하면 자동으로 int 형변환 진행
			
				
				
				String empName = rs.getString(2);
				String departmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				emp= new Employee (empId,empName,
						departmentName,jobName,phone);
				
				
			} 
			
			// if(조건식){true 이면 수행} --> 1번 수행
			
			// while(조건식){true 이면 수행} + 반복
			// -- > 1행만 조회 되면 1행 수행
			// -- > 불필요한 검사를 진행할 수 있다
			// -- > 1행 조회에서는 if문을 권장
			
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return emp;
	}


	/** 입력된 글자가 이름에 포함되는 사원 조회  SQL
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> selectName(Connection conn, String input) throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID,EMP_NAME, "
				+ "NVL(DEPT_TITLE,'없음')DEPT_TITLE, JOB_NAME, NVL(PHONE,'없음')PHONE "
				+ "FROM EMPLOYEE "
				+ 	"NATURAL JOIN JOB "
				+ 	"LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
				+ 	"WHERE EMP_NAME LIKE '%"+ input+"%'";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);		
			while (rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				Employee emp = new Employee (empId,empName,
						departmentName,jobName,phone);
						
				empList.add(emp);
				
				
			} 
			
			
			
		} finally {
			close(rs);
			close(stmt);
			
			
			
		}
		
		return empList;
	}


	public List<Employee> selectSalary(Connection conn, int input1, int input2)throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		try {String sql = "SELECT EMP_ID,EMP_NAME, "
				+ "NVL(DEPT_TITLE,'없음')DEPT_TITLE, JOB_NAME, NVL(PHONE,'없음')PHONE "
				+ "FROM EMPLOYEE "
				+ 	"NATURAL JOIN JOB "
				+ 	"LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
				+ 	"WHERE SALARY BETWEEN " + input1 +" AND "+input2;
			
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			String departmentName = rs.getString(3);
			String jobName = rs.getString(4);
			String phone = rs.getString(5);
			
			Employee emp = new Employee (empId,empName,
					departmentName,jobName,phone);
					
			empList.add(emp);
		
		} 
		
		}finally { 
			close(rs);
			close(stmt);
			
			
			
		}
		return empList;
	}


	
	
}
