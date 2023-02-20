package edu.kh.objectarray.dto;

public class Student {

	
	//필드(캡슐화 원칙)
	
	private int grade; //학년
	private int classRoom; //반
	private int number; //번호
	private String name; //이름
	
	private int kor; //국어점수
	private int eng; //영어점수
	private int math; //수학점수
	
	
	//생성자
	
	public Student() {}
	public Student(int grade,int classRoom, int number, String name) {

		//this 참조변수
		this.grade = grade;
		this.classRoom = classRoom;;
		this.number = number;
		this.name = name;
	}
	
	//getter / setter
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
		
	}
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor(int kor) {
		return kor;
	}
	
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng(int eng) {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath(int math) {
		return math;
	}
	public void setMath(int math) {
		this.math= math;
	}
	
	// 객체의 필드 값을 하나의 문자열 형태로 반환하는 메서드
	public String toString() {
		return String.format("%d학년 %d반 %d번 %s,[%d,%d,%d]"
				,grade,classRoom,number,name,kor,eng,math);
	}
	
	
	
	
	
	
	
}
