package edu.kh.operator.practice;

import java.util.Scanner;


public class OperatorPractice4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어:");
		int korean = sc.nextInt();
		System.out.print("영어:");
		int english = sc.nextInt();
		System.out.print("수학:");
		int math = sc.nextInt();
		int sum = korean + english + math;
		double avg = sum / 3.0; //double ->실수를 만들어주기위함 자동 형변환
		//값처리 방식
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		String result = (korean >= 40 && english >= 40 && math >= 40 && avg>=60)? "합격" : "불합격";
		System.out.println(result);
		
		
		
		
		
		
		
		
		
	}
	
	
}
