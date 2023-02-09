package edu.kh.operator.practice;

import java.util.Scanner;


public class OperatorPractice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();
		System.out.print("사탕개수 : ");
		int input2 = sc.nextInt();
		
		System.out.println();
		
		System.out.printf("1인당 사탕 개수 : %d \n",  input2 / input1 );
		System.out.printf("남는 사탕 개수: %d \n", input2 % input1 );
		
		
		
		
		
		
		
		
		
	}
	
	
}
