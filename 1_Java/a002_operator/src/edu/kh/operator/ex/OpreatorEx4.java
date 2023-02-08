package edu.kh.operator.ex;

public class OpreatorEx4 {

	public static void main(String[] args) {
		// 논리 연산자 : &&(AND), ||(OR)
		
		// %%(AND) 연산자 :  둘 다 true면 true 나머진 false
		// 영어 AND 의 느낌 그대로
		//  정수가 100 이상 이면서 짝수인가?
		int num1 = 100;
		boolean result1 = num1 >= 100 && num1 % 2 == 0;
		// 100 이상? 짝수 ?
		System.out.println("100 이상이면서 짝수?" + result1 );
		

		//  정수가 50 이하이고 3의 배수인가?
		int num2 = 42;
		boolean result2 = num2 <= 50 && num2 % 3 == 0;
		System.out.println("50이하이고 3의 배수?" +result2); // ture
				
	    //  정수가 1부터 100 사이의 숫자인가?
		int num3 = 50;
		boolean result3 = num3 >= 1 && num3 <=100;
		System.out.println("1부터 100 사이?" + result3); // true
		
		
		// ||(OR) 연산자 : 둘 다 false면 false, 나머진 true
		// 영어 OR의 느낌 그대로 또는 ~이거나 둘 중의 하나
		
		// 정수가 10을 초과하거나 홀수인가?
		int num4 =20;
		boolean result4 = num4 > 10 || num4 % 2 == 1;
		System.out.println("10을 초과하거나 홀수?" + result4); //true
		
		// Mix 응용문제 
		// 정수는 0부터 50 사이 숫자 또는 음수인가?
		// 지문은 50 이하인가? 지문 해석도 중요함 더 간단한 코드가 짜여짐
		int num5 = 3;
		boolean result5 = num5 >=0 && num5 <=50 || num5 <= 0;
		System.out.println("0부터 50 사이 숫자 또는 음수?" + result5); // true
		
		// 논리 부정 연산자 : ! (NOT)
		// - 논리 값을 반대로 바꾸는 연산자 NOT의 느낌 
		
		// 11은 짝수가 아니다 
		System.out.println("11은 짝수가 아니다:" + !(11 % 2 ==0)); 
		
		System.out.println( true || false && !false); //true
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
