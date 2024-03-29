package edu.kh.jdbc.model.service;


import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.dao.EmployeeDAO;
import edu.kh.jdbc.model.dto.Employee;

// Model : 데이터 논리구조 제어 (트랜잭션 제어)
//		   데이터 가공 처리
// 		   DAO 수행 결과를 View 또는 Controller로 반환

//      -> 프로그램(앱)에 포함되어야할 데이터에 대한 정의



// Service : 비즈니스 로직 
// - 요청에 따른 필요 데이터를 반환
// + 트랜잭션 제어처리 (Commit ,  rollback) 


public class EmployeeService {

	// dao에 여러가지 SQl을 수행하기 위한 메서드를 각각 작성하여 호출
	private EmployeeDAO dao = new EmployeeDAO(); 
	

	
	
	
	/** 전체 사원 정보 반환 서비스
	 * @return empList
	 */
	public List<Employee> selectAll() throws SQLException{

		// DB에서 필요한 데이터를 조회하기 위해
		// DAO 메서드를 호출 
		
		// 1. 커넥션 생성
		// -> Service가 트랜잭션 제어 처리를 위해서는
		// Connection 객체가 Service에 존재해야함
		// --> 만약 DAO에서 Connection을 만들고 반환하면
		// 		Service 쪽에서 Connection을 사용할 수 없게된다
		
		// --> 커넥션이 서비스에 있다
		// --> 다 쓰고 닫아주는 close() 구문이 필요하다
		// --> 서비스에 conn.close()를 작성해야 한다.
		
		Connection conn = getConnection(); 
		
		// 2. DAO의 메서드를 호출하여
		//    필요한 결과를 DB에서 조회해서 반환 받기
		List<Employee> empList = dao.selectAll(conn);
		
		// ** DML 구문인 경우 해당 위치에 commit / rollback 구문 작성 ** 
		
		
		// 3. Connection 반환
		close(conn); // JDBCTemplate 작성된 메서드 호출
		
		// 4. 결과 반환
		
		
		return empList;
	}





	/** 사원 한명 정보 반환
	 * @param input
	 * @return
	 */
	public Employee selectOne(int input) throws SQLException {
		
		// 1. connection 생성
		Connection conn = getConnection();
		
		// 2. DAO메서드를 호출
		Employee emp = dao.selectOne(conn,input);
		
		// 3. 커넥션 반환
		close(conn);
		
		
		return emp;
		
	}





	/** 입력된 글자가 이름에 포함되는 사원 조회 서비스
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> selectName(String input)throws SQLException {
		Connection conn = getConnection(); 
		
		List<Employee> empList = dao.selectName(conn,input);
		
		
		close(conn);
		
		return empList;
	}





	/** 급여 입력 범위 내 사원 정보 조회
	 * @param input1
	 * @param input2
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> selectSalary(int input1, int input2) throws SQLException {
		
		Connection conn = getConnection();
		
		List<Employee> empList = dao.selectSalary(conn,input1,input2);
		
		close(conn);
		return empList;
	}





	public int insertEmployee(Employee emp)throws SQLException {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		// 2. DAO 메서드 호출후 결과 반환 받기
		int result = dao.insertEmployee(conn,emp);
		
		// DAO 에서 DML (INSERT) 수행
		// 바로 저장이 아닌 트랜잭션에 임시 저장
		// 수행 결과에 따라 commit을 할것인지 rollback을 할것인지 지정
		
		// 3. 트랜잭션 제어처리
		if(result > 0) // 삽입 성공 시
		commit(conn);
		else rollback(conn); //  삽입 실패시
			
		// 4. 커넥션 반환
		close(conn);
		// 5. 결과 반환
		return result;
	}





	public int updateEmployee(Employee emp) throws SQLException{
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO메서드 호출 후 결과 반환 받기
		int result = dao.updateEmployee(conn,emp);
		
		// 3. 트랜잭션 제어처리
		if(result >0 )// 삽입 성공시
			commit(conn);
		else rollback(conn); // 삽입 실패시
		
		// 4. 커넥션 반환
		close(conn);
		
		return result;
	}





	public int retireEmployee(int input) throws SQLException{
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2.  DAO메서드 호출 후 결과 반환 받기
		int result = dao.retireEmployee(conn,input);
		
		// 3. 트랜잭션 제어처리
				if(result >0 )// 삽입 성공시
					commit(conn);
				else rollback(conn); // 삽입 실패시
				
				// 4. 커넥션 반환
				close(conn);
		
		return result;
	}





	




	
	
	
	
	
	
	
	
	
	
}
