package edu.kh.operator.ex;

import java.nio.file.spi.FileSystemProvider;

public class OperatorEx2 {

	public static void main(String[] args) {
		
		// main method 자동 완성 : main -> ctrl + spacebar -> enter
		
		
				/* 증감 연산사 : ++,-- 
				 * -피연산자를 1씩 증가 또는 감소시키는 연산자
				 * 
				 * 전위 연산 :++a , --a 
				 * -다른 연산보다 먼저 a를 증가 또는 감소 시킴 (최우선)
				 * 
				 *  후위 연산 :aa++,a-- 
				 *  -다른 연산은 모두 수행한 후 a증가 또는 감소 시킴 (마지막)
				 *  
				 *  
				 */
				
				
				int num1 = 10;
				int num2 = 10;
				
				System.out.printf("[연산 전] num1 :%d / num2 : %d \n", num1, num2);
				System.out.printf("[연산 후] num1 :%d / num2 : %d \n", num1, num2);
				
				System.out.printf("-------------------------");
				//전위 연산
				int num3 = 5;
				
				System.out.println("++num3 : " + (++num3));
				System.out.println("--num3 + 10 : " + (--num3 + 10));
				
				//후위 연산
				
				int num4 = 1;
				System.out.println("num4-- : " + (num4--));
				//num 4-- : 1 -> num4 = 0
				System.out.println("연산 후 num4 : " + num4); //0
				
				System.out.println("num4++ -3 : " +(num4++ -3));
				System.out.println("연산 후 num4 : " +num4);
				
				
				System.out.println("------------------------");
				//비교 연산자 : == != > < >= <=
				//-복합 기호에서 등호(=)는 항상 오른쪽
				//-비교 연산의 결과는 항상 논리형(true/false)
				
				int num5 = 100;
				int num6 = 200;
				
				System.out.println( num5 == num6);
				System.out.println( num5 != num6);
				System.out.println( num5 > num6);
				System.out.println( num5 < num6);
				
				System.out.println(num5 >= num6 - num5 );
				
				System.out.println(num6 <= num5 + num5 + num5 );
			 
				
	
	}
	