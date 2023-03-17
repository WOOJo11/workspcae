package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectJobNameDAO;

import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급명 입력 : ");
		String input = sc.nextLine();
		
		SelectJobNameDAO dao = new SelectJobNameDAO();
		
		List<Employee2> empList = dao.select(input);
		if(empList.isEmpty()) { 
			
			System.out.println("일치하는 부서가 없습니다");
}



		for(Employee2 emp : empList) {
			System.out.printf("부서 : %s / 직급 : %s  / 이름 : %s / 이메일 : %s \n",
			emp.getDeptTitle(),
			emp.getJobName(),
			emp.getEmpName(),
			emp.getEmail());
				
}

		
		
	}
	
	
	
}
