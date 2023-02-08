package edu.kh.operator.ex;

import java.util.Scanner;


public class OperotorEx5 {

		public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in); // 스캐너 생성
			
			System.out.println("[홀짝 검사기]");
			
		    System.out.print("정수 하나를 입력해주세요 : ");
			
		    int input = sc.nextInt(); // 정수 입력받기
		    
		    //삼항 연산자 
		    //조건식 ? true인 경우 : false인 경우
		    //Math.abs(숫자) -> 절대값
		    //나무를 보지 말고 숲을 봐라
		    
		    String result = Math.abs(input) % 2 == 1 ? "홀수 입니다." 
		    			  	: input == 0 ? "0입니다." : "짝수 입니다.";
		    
		    System.out.println(result);
		    
		   
		    
		 
		    
		    
		    
		    
			
			
			
			
			
			
		}
	
	
	
	
	
}
