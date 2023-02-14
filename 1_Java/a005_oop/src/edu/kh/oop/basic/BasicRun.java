package edu.kh.oop.basic;

public class BasicRun {


	public static void main(String[] args) {
		
		//Java에서의 Object == 클래스의 정의된 내용을 토대로 
		//					   new 연산자를 통해 메모리에 생성되는것
		
		//국민 객체를 생성
		Nation n1 = new Nation();
		
		//n1.pNo = "990123 -1234567";
		n1.setpNo("990123 -1234567(간접 접근 이용)");
		n1.name = "홍길동";
		n1.gender = '남';
		n1.address = "서울시 중구 남대문로 120";
		n1.phone = "010-1234-1234";
		n1.age = 25;
		
		
		//객체의 속성에 저장된 값 출력
		//System.out.println(n1.pNo);/
		System.out.println(n1.getpNo());
		System.out.println(n1.name);
		System.out.println(n1.gender);
		System.out.println(n1.address);
		System.out.println(n1.phone);
		System.out.println(n1.age);
		
		//객체의 기능 호출하기
		
		n1.Medicare();
		n1.speakkorean();
		
	}
	
	
	
}// 클래스 내에 객체의 속성, 기능을 묶어놓음
//캡슐화 첫 번째 특징 