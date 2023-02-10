package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForRun {

	public static void main(String[] args) {
		
		
		ForEx fx = new ForEx();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("실행할 예제 번호를 입력");
		int number = sc.nextInt();
		
		switch(number) {
		case 1 : fx.ex1(); break;
		case 2 : fx.ex2(); break;
		case 3 : fx.ex3(); break;
		case 4 : fx.ex4(); break;
		case 5 : fx.ex5(); break;
		case 6 : fx.ex6(); break;
		case 7 : fx.ex7(); break; // 응용
		case 8 : fx.ex8(); break; // 응용
		case 9 : fx.ex9(); break; // 응용
		case 10 : fx.ex10(); break; // 응용
		case 11 : fx.ex11(); break; // 응용
		case 12 : fx.ex12(); break; // 응용
		case 13 : fx.ex13(); break; // 응용
		case 14 : fx.ex14(); break; // 응용
		case 15 : fx.ex15(); break; // 중첩반복분
		case 16 : fx.ex16(); break; // 중첩반복분
		case 17 : fx.ex17(); break; // 중첩반복분 응용
		case 18 : fx.ex18(); break; // 중첩반복분 응용
		case 19 : fx.ex19(); break; // 중첩반복분 응용
		case 20 : fx.ex20(); break; // 중첩반복분 응용
		case 21 : fx.ex21(); break; // 중첩반복분 응용
		case 22 : fx.ex22(); break; // 중첩반복분 응용
		
		default : System.out.println("존재하지 않는 예시 번호 입니다");
		
		}
		
		
		
	
	}
}
