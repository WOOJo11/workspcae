package edu.kh.operator.practice;

import java.util.Scanner;


public class OperatorPractice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("두 정수를 입력받아 산술 연산 결과 출력하기");
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();
		System.out.print("사탕개 : ");
		int input2 = sc.nextInt();
		
		System.out.printf("1인당 사탕 개수 : %d \n",  input2 / input1 );
		System.out.printf("남는 사탕 개수: %d \n", input2 % input1 );
		
		
		
		
		
		
		
		
		
	}
	
	
}
