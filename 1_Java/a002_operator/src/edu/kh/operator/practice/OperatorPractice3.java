package edu.kh.operator.practice;

import java.util.Scanner;


public class OperatorPractice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[실행화면");
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
	
		
		String result = num < 0 ? "음수입니다" : num == 0? "0입니다." : "양수입니다.";
		System.out.println(result);
		
		
		// String result = input ==0 ? " 0 " : (input > ? " 양수" : " 음수 ");
		
		
		
		
		
	}
	
	
}
