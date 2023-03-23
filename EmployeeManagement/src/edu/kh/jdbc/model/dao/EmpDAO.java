package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;


public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/** 재직 중인 사원 조회 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException {
		
		// 결과 저장용 객체 선언
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
	/** 퇴사한 직원 전체 조회 다오
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
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
	/** 사번으로 정보 조회
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
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
	/** 사번으로 사원 정보 수정
	 * @param conn
	 * @param em
	 * @return
	 * @throws SQLException
	 */
	public int updateEmp(Connection conn, Emp em)throws SQLException {
		int result = 0;
		
		try {
			
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "	 PHONE = ?,\r\n"
					+ " 	SALARY = ?,\r\n"
					+ "BONUS = ? "
					+ "WHERE EMP_ID = ?";
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, em.getEmail());
			pstmt.setString(2, em.getPhone());
			pstmt.setInt(3, em.getSalary());
			pstmt.setDouble(4, em.getBonus());
			pstmt.setInt(5, em.getEmpId());
	
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
	/** 퇴사 처리 
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
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
	public List<Emp> recentHire(Connection conn)throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		
		
		try {
			String sql = "SELECT * FROM \r\n"
					+ "(SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE\r\n"
					+ "FROM EMPLOYEE e \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "ORDER BY HIRE_DATE DESC)\r\n"
					+ "WHERE ROWNUM <=5";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				Date hireDate = rs.getDate(4);
				
				Emp em = new Emp(empId,empName,departmentTitle,hireDate);
				
				empList.add(em);
			
				
			}
			
			
			
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		
		
		return empList;
	}
	/** 퇴사처리 업그레이드 추가 구문 존재여부 확인
	 * @param conn
	 * @param input
	 * @return
	 */
	public int checkEmployee(Connection conn, int input)throws SQLException{
		int check = 0;
		try {
			String sql = "SELECT CASE \r\n"
					+ "WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0 THEN 0 \r\n"
					+ "WHEN (SELECT COUNT(*) FROM EMPLOYEE\r\n"
					+ "WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1 THEN 1\r\n"
					+ "ELSE 2\r\n"
					+ "END \"CHECK\"\r\n"
					+ "FROM DUAL";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt("CHECK");
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return check;
	}
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException{
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		
		try { 
			// 2. SQL 작성 후 수행 
			
			
			String sql = "SELECT DEPT_CODE,NVL(DEPT_TITLE, '부서없음')DEPT_TITLE,\r\n"
					+ "COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균\r\n"
					+ "FROM EMPLOYEE  \r\n"
					+ "LEFT JOIN DEPARTMENT d ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_CODE,DEPT_TITLE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptTitle = rs.getString ("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<String, Object> map = new LinkedHashMap<>();
												// 입력 순서가 유지되는 맵
				map.put("deptTitle",deptTitle);
				map.put("count",count);
				map.put("avg",avg);
				
				mapList.add(map);
			}
			
		} finally {
			
			close(rs);
			close(stmt);
		}
		
		
		
		return mapList;
	}
}
