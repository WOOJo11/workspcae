package edu.kh.inheritance.dto;

public class Parent {
	
	
		private int money = 10;
		private String lastName = "박";
	
		//기본 생성자
		public Parent() {
			System.out.println("Parent()기본 생성자");
		}
		
		
		public Parent(int money, String lastName) {
			
			this.money = money;
			this.lastName = lastName;
			System.out.println("Parent(int , Sting) 매개 변수 생성자");
			
		}
		
		
		public int getMoney() {
			return money;
		}
	public void setmoeny(int money) {
		this.money = money;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toStoring() {
		return money + " / " + lastName;
	}
	
	
	

}



