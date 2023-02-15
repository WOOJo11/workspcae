package edu.kh.oop.field.dto;



// DTO (Data Transfer Object) : 데이터를 옮기는 객체

public class Student {
	
	//필드( == 멤버변수) : 객체의 속성
	
	// 필드종류 1 : instance 변수
	//instance가 생성될때 마다 해당 instance에 포함된 변수
	public String name;
	public int grade;
	
	// 필드 종류 2 : 클래스 변수
	public static String schoolName = "KH초등학교";
	
	public void study() {
		System.out.println("매우 매우 열심히 공부합니다");
	}
	
	

}
