package edu.kh.polymorphism.ex2.dto;

import java.util.Scanner;

public class WOOCalculator implements Calculator , KH {

	@Override
	public int plus(int a, int b) {
		
		
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		
		return a-b;
	}

	@Override
	public int multiple(int a, int b) {
		
		return a*b;
	}

	@Override
	public int divide(int a, int b) {
		return a/b;
	}

	@Override
	public double divide2(int a, int b) {
		return (double)a/b;
	}

	@Override
	public double areaOfCircle(double r) {
		return PI *r *r; // 상속 받은 PI를 자식이 자기 것처럼 사용
	}

	@Override
	public int square(int a, int x) {
		return (int)Math.pow(a, x);
	}

	@Override
	public void lesson() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
