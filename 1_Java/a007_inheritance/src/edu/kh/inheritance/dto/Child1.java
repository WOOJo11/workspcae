package edu.kh.inheritance.dto;

public class Child1 extends Parent{

	
	private String car;
	
	public Child1() {
		System.out.println("Child1() 기본 생성자");
	}
	
	public Child1(String car) {
		this.car = car;
		System.out.println("Child1(String) 매개변수 생성자");
	}
	
	public String getCar() {
		return car;
		}
	public void setCar(String car) {
		this.car = car;
		
	}
	public String toString() {
		
		// 자신의 (같은 클래스) 메서드 호출 시 이름만 부르면 된다.
		// + 상속 특징(부모 필드 / 메서드를 상속 받아 자식 것 처럼 사용한다.
//		System.out.println(getCar());
//		System.out.println(getMoney());
		
		return car;
	}
	
	
	
}
