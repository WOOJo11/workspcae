package edu.kh.operator.practice;

import java.util.Scanner;


public class OperatorPractice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String inputName = sc.next(); //String 단어
		
		System.out.print("학년 : ");
		int inputGrade = sc.nextInt();// 숫자
		
		System.out.print("반 : ");
		int inputClass = sc.nextInt();
		
		System.out.print("번호 : ");
		int inputNuber = sc.nextInt();
		
		System.out.print("성별 : ");
		String inputname = sc.next();
		
		System.out.print("성적 :");
		Double inputresult = sc.nextDouble();
		
		System.out.printf("%s님은 %d학년, %d반, %d번호, %s남학생, 성적은 %.2f 입니다.", 
				inputName, inputGrade, inputClass, inputNuber, inputname, inputresult);
		

				
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
