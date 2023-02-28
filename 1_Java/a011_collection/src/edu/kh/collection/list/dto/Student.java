package edu.kh.collection.list.dto;

import java.util.Objects;


public class Student implements Comparable<Student>{

	private String name;
	private int grade;
	private int classRoon;
	private int number;
	private String address;
	private char gender;
	private int score;
	
	



	public Student(String name, int grade, int classRoon, int number, String address, char gender, int score) {
		super();
		this.name = name;
		this.grade = grade;
		this.classRoon = classRoon;
		this.number = number; 
		this.address = address;
		this.gender = gender;
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getClassRoon() {
		return classRoon;
	}


	public void setClassRoon(int classRoon) {
		this.classRoon = classRoon;
	}

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", classRoon=" + classRoon + ", number=" + number
				+ ", address=" + address + ", gender=" + gender + ", score=" + score + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(address, classRoon, gender, grade, name, number, score);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && classRoon == other.classRoon && gender == other.gender
				&& grade == other.grade && Objects.equals(name, other.name) && number == other.number
				&& score == other.score;
	}


	@Override
	public int compareTo(Student other) {
		
		// Student 객체로 이루러진 컬렉션을 정렬하라고 할 때
		// 별도의 다른 기준이 없다면 socre 순서로 정렬
		
		//compareto()메서드에서
		// 반환 되는 값이
		// 0이하  : 순서를 그대로 유지
		// 0초과 (양수) : 큰 값이 오른쪽으로 이동
		// 				-> 정확히는 현재 객체가 크면 현재 객체를 오른쪽으로 이동
		
		
		
		return this.score - other.score;
	}


	
	
	
	
	
	
	
	
	
	

	
}

