package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {
		
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int sum =0;
		 for(int i=0 ; i<arr.length; i++ ) {
			 System.out.print(arr[i]+" ");
			
			 if(i % 2 == 0) {
				 sum += arr[i]; 
			 }
			}
		 System.out.println();
		
		 
		 System.out.println("짝수 번째 인덱스 합 : " +sum);
		 }
		
	public void practice2() {
		
		int[] arr = {9,8,7,6,5,4,3,2,1};
		int sum = 0;
		for (int i=0 ; i<arr.length; i++ ) {
			
			System.out.print(arr[i] + " ");
			if(i% 2 != 0) {
				sum += arr[i];
				
			}
		}
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
		
		
	}
		
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] num = new int[input];
		int[] arr = new int[input];
		for(int i = 0; i<num.length; i++) {
			 for(int x=0; x<arr.length; x++)
				{	
					arr[i] = i+1;
						
				} 
			
					System.out.print(arr[i] +" ");
				}
		
	}
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[4];
		 for(int i=0; i<num.length; i++) 
		 {
			 System.out.printf("입력 %d : ", i+1);
			  num[i] = sc.nextInt();
			  
	}
		 System.out.print("검색할 값 : ");
		  int input = sc.nextInt();
		 
		  int index = 0;
			 
			 
			 for(int i= 0; i<num.length; i++) {
				 if(input == num[i]) {
					 index = i+1;
					 
				 }
				 
			 }
			if(index < 0 ){
				System.out.println("존재하지 않습니다");
			}else{
			 
			 System.out.println("인덱스 : " + index);
			}
			 
		
}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("문자열 : ");
		String st = sc.next();
		System.out.print("문자 : ");
		char e = sc.next().charAt(0);
		System.out.printf("%s에 %c가 존재하는 위치(인덱스): ",st , e);
		for(int i = 0; i<st.length(); i++) {
			if(e == st.charAt(i)) {
				sum++;
				System.out.print(i+" ");
				
			}
			
		}
		System.out.println();
		System.out.printf("%c 의 갯수: %d",e , sum);
		
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		
		int[] num = new int[input];
		int sum = 0;
		 for(int i=0; i<num.length; i++) 
		 {
			 System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i+1);
			  num[i] = sc.nextInt();
			
			  sum += num[i];
			
	 }
		 for(int x=0; x<num.length; x++) {
			 System.out.print(num[x] +" ");
		 }
		 
		 System.out.println();
			
		 System.out.print("총합 : " + sum);
	}
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String id = sc.next();
		
		char[] ch = id.toCharArray();
		for(int i =0; i<ch.length; i++) {
			
			if(i <= 7) {
				System.out.print(ch[i]);
			}else {
				System.out.print("*");
			}
			
		}
		
			
			
	

		

	}


}


