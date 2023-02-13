package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 :");
		int input = sc.nextInt();
		
		if(input <=0) {
			System.out.println("1이상의 숫자를 입력해주세요");
		}else {
			for(int i=1; i<=input; i++) {
				System.out.printf("%2d", i);
			}
			
			}
			
	}
		
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input <=0) {
			System.out.println("1이상의 숫자를 입력해주세요");
			
		}else { 
			for(int i=input; i>=1; i--) {
				System.out.printf("%2d" ,i);
			}
			
		
		}
		
		
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요");
		int num = sc.nextInt();
		
		int sum = 0;
		
		for(int i=1; i<=num; i++) {
			sum += i;
			System.out.print(i);
		// i == num == 마지막
			if(i != num) {
				System.out.print("+");
			}
		}
		
//		System.out.println(" = " + sum);
//	
//		for(int i=1; i<=num; i++) {
//			sum += i;
//			System.out.print(i + "+");
//		}
//		sum += num;
//		System.out.print(num + "=" + sum);
		
		
	}
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자 :");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 :");
		int num2 = sc.nextInt();
		
		if(num1 <=0 || num2 <=0) {
			System.out.print("1 이상의 숫자를 입력해주세요");
	
		}else {
			
			if(num1 < num2) {
				for(int i=num1; i<=num2; i++) {
					System.out.printf("%2d", i );
				}
				
			}else {
				
				for(int i=num2; i<=num1; i++) {
					System.out.printf("%2d", i );
				}
			}
			
			
		}
		
		
		
	}
	public void practice5() {
		 
		System.out.println("Your number: ");
	        Scanner sc = new Scanner(System.in);
	        int intX = sc.nextInt();
	     
	        for(int i = 1; i <= 9; i++)
	        {
	            if(i == 1)
	            {
	                //System.out.println("===== 4dan=====");
	                System.out.println("===== " + intX + " =====");
	            }
	            
	            int multipliedVal = intX * i;
	            System.out.println(intX + " * " + i + " = " + multipliedVal);
	        }
		
		
	}
	
	public void practice6() {
		System.out.println("Your number: ");
        Scanner sc = new Scanner(System.in);
        int intX = sc.nextInt();
    
        if(intX >= 2 && intX <= 9)
        {
          for(int i = intX; i <= 9; i++)
          {
            System.out.println("===== " + i + " =====");
            
            for(int a = 1; a <= 9; a++)
            {
              int multipliedVal = i * a;
              System.out.println(i + " * " + a + " = " + multipliedVal);
            }
          }
        }
        else
        {
            System.out.println("Only from 2 and 9");
        }
	}
	
	public void practice7() {
		  System.out.println("Your number: ");
	      Scanner sc = new Scanner(System.in);
	      int intX = sc.nextInt();

	      for(int i = 1; i <= intX; ++i)
	      {
	        for(int a = 1; a <= i; ++a)
	        {
	           System.out.print("*");

	           
	        }

	         System.out.println("");
	      }
	}
	
	public void practice8() {
		System.out.println("Your number: ");
	      Scanner scn = new Scanner(System.in);
	      int intX = sc.nextInt();

	      
	      for(int i = intX; i >= 1; i--)
	      {
	        
	        for(int a = 1; a <= i; a++)
	        {
	           System.out.print("*");
	        }

	         System.out.println("");
	      }
	}
	public void practice9() {
		 System.out.println("Your number: ");
	      Scanner sc = new Scanner(System.in);
	      int intX = sc.nextInt();

	    //Coloumn
	    for(int i = 1; i <= intX; i++)
	    {
	      //spacing
	      for(int a = 1; a <= intX-i; a++)
	      {
	        System.out.print(" ");
	      }

	      //Row
	      for(int b = 1; b <= i; b++)
	      {
	        System.out.print("*");
	      }

	      System.out.println("");
	    }
	}
	public void practice10() {
		 {
			    System.out.println("Your number: ");
			    Scanner sc = new Scanner(System.in);
			    int intX = sc.nextInt();

			    for(int row = 0; row < intX; row++)
			    {
			      for(int star = 0; star <= row; star++)
			        System.out.print("*");

			      System.out.println("");

			      if(row == (intX-1))
			      {
			        for(int b = row-1; b >= 0; b--)
			        {
			          for(int star = 0; star <= b; star++)
			            System.out.print("*");
			      
			          System.out.println("");
			        }
			      }
			    }
	}
	
		 
	
	
}
		
	
	
	
		
}
		
	
		

