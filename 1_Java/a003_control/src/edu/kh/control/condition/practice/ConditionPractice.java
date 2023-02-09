package edu.kh.control.condition.practice;

import java.util.Scanner;

//실습문제 작성 클래스
public class ConditionPractice {
	
	
//예시문제1번
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int a = sc.nextInt();
		
		if(a <= 0) {
			System.out.println("양수만 입력해주세요");
			
		}else if(Math.abs(a) % 2 == 1) {
			System.out.println("홀수 입니다");
			
		}else {
			System.out.println("짝수 입니다.");
		}
		
		
		
		
	}
	
	
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 :");
		int k = sc.nextInt();
		System.out.print("영어 :");
		int e = sc.nextInt();
		System.out.print("수학 :");
		int m = sc.nextInt();
		int sum = k + e + m;
		double avg = sum / 3.0;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		String result = (k >= 40 && e >= 40 && m >= 40 && avg>=60)? "합격" : "불합격입니다";
		System.out.println(result);
		
		
		
		
		
	}
	
	
	
	public void practice3() {
		
	}
	
	
	
	public void practice4() {
		
	}
	
	
	
	public void practice5() {
		
	}
	
	
	

}
