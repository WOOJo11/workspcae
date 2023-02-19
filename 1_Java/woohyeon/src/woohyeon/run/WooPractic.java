package woohyeon.run;

import java.util.Arrays;
import java.util.Scanner;

public class WooPractic {

	public void ex1() {
		 Scanner scn = new Scanner(System.in);
	     System.out.println("정수 : ");
	    int num = scn.nextInt();

	    int[] arr = new int[num];
	    int middleNumber = (num/2) + 1;
	    
	    while(true)
	    {
	        if((num % 2) != 0 && num >= 3)
	        {
	          for(int i = 0; i < num; i++)
	          {
	            if(i >= middleNumber)
	               arr[i] = arr[i-1]-1;
	            else
	               arr[i] = i+1;
	          }

	          break;
	        }
	        else
	        {
	           System.out.println("다시 입력하세요: ");
	           num = scn.nextInt();
	        } 
	    }

	    for(int i = 0; i < arr.length; i++)
	      System.out.print(arr[i]);
	}
	
	public void ex2() {
		Scanner scn = new Scanner(System.in);
		int arrLength = 10;
	    int[] arr = new int[arrLength];

	    for(int i = 0; i < arrLength; i++)
	    {
	      int randomNum = (int)((Math.random() * (10 - 1)) + 1);
	      arr[i] = (int)randomNum;
	    }

	    for(int i = 0; i < arr.length; i++)
	      System.out.print(arr[i] + " ");
	}
	 public void ex3() {
		 int arrLength = 10;
		    int[] arr = new int[arrLength];

		    for(int i = 0; i < arrLength; i++)
		    {
		      int randomNum = (int)((Math.random() * (10 - 1)) + 1);
		      arr[i] = (int)randomNum;
		    }

		    //전체 값
		    for(int i = 0; i < arr.length; i++)
		      System.out.print(arr[i] + " ");

		    //최대값
		    //Sorting algorithm - Bubble sort
		    int maxNum = arr[0];
		    int minNum = arr[0];
		    for(int i = 0; i < arr.length; i++)
		    {
		      if(maxNum < arr[i])
		        maxNum = arr[i];

		      if(minNum > arr[i])
		        minNum = arr[i];
		    }
		    System.out.println();
		    System.out.println("Min: " + minNum );
		    System.out.println("Max :" + maxNum);
	 }
	 
	 public void ex4() {
		
		 Scanner scn = new Scanner(System.in);
		 int[] arr = new int[10];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random() * 10 + 1);
				
				for (int j = 0; j < i; j++) {
					if (arr[j] == arr[i]) {
						i--;
						break;
					}
				}
			}

			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");

		    
	 }
	 
	 public void ex5() {
		 Scanner sc = new Scanner(System.in);
		 int lot [] = new int [6];
		 
		
			
			for (int i = 0; i < lot.length; i++) {
				lot[i] = (int)(Math.random() * 45 + 1);
				
				for (int x = 0; x < i; x++) {
					if (lot[x] == lot[i]) {
						i--;
						break;
					}
				}
			}
			
			Arrays.sort(lot);

			for (int i = 0; i < lot.length; i++)
				System.out.print(lot[i] + " ");
		}
	public void ex6() {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = scn.next();
		
		char[] arr = new char[str.length()];
		int count = 0;

		System.out.print("문자열에 있는 문자 : ");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
			
			boolean flag = true;
		
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i])
					flag = false;
			}
			
			if (flag) {
				if (i == 0)
					System.out.print(arr[i]);
				else
					System.out.print(", " + arr[i]);
	                
				count++;
			}
		}

		System.out.println("\n문자 개수 : " + count);
		
		
	}
	public void ex7() {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력 : ");
		String[] arr = new String[scn.nextInt()];
		scn.next();
		
		int index = 0;
		
		while (true) {
			for (int i = index; i < arr.length; i++) {
				System.out.print(i + 1 + "번째 문자열 : ");
				arr[i] = scn.next();
			}
			
			index = arr.length;

			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char plus = scn.next().charAt(0);

			if (plus == 'Y' || plus == 'y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				String[] arr2 = new String[arr.length + scn.nextInt()];
				scn.next();
				
				System.arraycopy(arr, 0, arr2, 0, arr.length);
				arr = arr2;
				
			} else if (plus == 'N' || plus == 'n') {
				System.out.println(Arrays.toString(arr));
				break;
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

		}
	}
	
	public void ex8() {
	
			String[][] arr = new String[3][3];
			
			for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[row].length; col++)
					System.out.print("(" + row + ", " + col + ")");
				System.out.println();
			}
	}
	 
	
	public void ex9() {
		int[][] arr = new int[4][4];
		int index = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j= 0; j<arr.length; j++) {
				arr[i][j] = index;
				index++;
			System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	public void ex10() {
		int[][] arr = new int[4][4];
		int index = 16;
		for(int i=0; i<arr.length; i++) {
			for(int j= 0; j<arr.length; j++) {
				arr[i][j] = index;
				index--;
			System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	
	public void ex11() {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[4][4];
		
		int rowFinal = arr.length - 1;
		int colFinal = arr[0].length - 1;
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if (row != rowFinal && col != colFinal) {
					arr[row][col] = (int)(Math.random() * 10 + 1);
					
					arr[row][colFinal] += arr[row][col];
					arr[rowFinal][col] += arr[row][col];
					arr[rowFinal][colFinal] += arr[row][col];
				}
				System.out.print(arr[row][col] +" ");
			}
			System.out.println();
		}
	}
	public void ex12() {
		Scanner sc = new Scanner(System.in);
		
		int rowNum;
		int colNum;
		int[][] arr;
		
		while (true) {
			System.out.print("행 크기 : ");
			rowNum = sc.nextInt();
			
			if (rowNum < 1 || rowNum > 10)
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			else {
				while (true) {
					System.out.print("열 크기 : ");
					colNum = sc.nextInt();
					
					if (colNum < 0 || colNum > 10)
						System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
					else {
						arr = new int[rowNum][colNum];
						
						for (int row = 0; row < arr.length; row++) {
							for (int col = 0; col < arr[row].length; col++) {
								arr[row][col] = (int)(Math.random() * 26 + 65);
								
								System.out.print((char)arr[row][col] + " ");
							}
							System.out.println();
						}
						
						break;
					}
				}
				
				break;
			}
		}
	}
	public void ex13() {
		Scanner sc = new Scanner(System.in);
		
		int rowNum;
		int colNum;
		char[][] arr;
		char ch = 'a';
		
		System.out.print("행 크기 : ");
		rowNum = sc.nextInt();
		
		arr = new char[rowNum][];
		
		for (int row = 0; row < arr.length; row++) {
			System.out.print(row + "열의 크기 : ");
			colNum = sc.nextInt();
			
			arr[row] = new char[colNum];
			
			for (int col = 0; col < arr[row].length; col++)
				arr[row][col] = ch++;
		}
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++)
				System.out.print(arr[row][col] + " ");
			
			System.out.println();
		}
	}
	
	public void ex14() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		int row = 0;
		int col = 0;

		System.out.println("== 1분단 ==");
		for (int i = 0; i < students.length; i++) {
			if (i < students.length / 2) {
				arr1[row][col] = students[i];
				
				System.out.print(arr1[row][col] + " ");
				col++;
				
				if (col == arr1[row].length) {
					row++;
					col = 0;
					System.out.println();
				}
				
			} else {
				arr2[row][col] = students[i];
				
				System.out.print(arr2[row][col] + " ");
				col++;
				
				if (col == arr2[row].length) {
					row++;
					col = 0;
					System.out.println();
				}
			}
			
			if (i == students.length / 2 - 1) {
				row = 0;
				col = 0;
				System.out.println("== 2분단 ==");
			}
		}
		
	}
	public void ex15() {
		Scanner sc = new Scanner(System.in);
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		int row = 0;
		int col = 0;

		System.out.println("== 1분단 ==");
		for (int i = 0; i < students.length; i++) {
			if (i < students.length / 2) {
				arr1[row][col] = students[i];
				
				System.out.print(arr1[row][col] + " ");
				col++;
				
				if (col == arr1[row].length) {
					row++;
					col = 0;
					System.out.println();
				}
				
			} else {
				arr2[row][col] = students[i];
				
				System.out.print(arr2[row][col] + " ");
				col++;
				
				if (col == arr2[row].length) {
					row++;
					col = 0;
					System.out.println();
				}
			}
			
			if (i == students.length / 2 - 1) {
				row = 0;
				col = 0;
				System.out.println("== 2분단 ==");
			}
		}
		
		System.out.println("============================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.next();
		
		int part = 0;
		int line = 0;
		String direct = "";
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				if (arr1[i][j].equals(name)) {
					part = 1;
					line = i + 1;
					direct = j == 0 ? "왼쪽" : "오른쪽";
					
				} else if (arr2[i][j].equals(name)) {
					part = 2;
					line = i + 1;
					direct = j == 0 ? "왼쪽" : "오른쪽";
				}
			}
		}
		
		if (part == 0)
			System.out.println("검색 결과가 없습니다.");
	        
		else {
			System.out.print("검색하신 " + name + " 학생은 ");
			System.out.println(part + "분단 " + line + "번째 줄 " + direct + "에 있습니다.");
		}
	}
	public void ex16() {
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String[6][6];

		System.out.print("행 인덱스 입력 : ");
		int rowNum = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int colNum = sc.nextInt();
		
		if (rowNum < 0 || rowNum > 4 || colNum < 0 || colNum > 4)
			System.out.println("잘못 입력하셨습니다");
				
		arr[rowNum][colNum] = "X";
			
		System.out.println("  0 1 2 3 4");
		for (int row = 0; row < arr.length - 1; row++) {
			System.out.print(row + " ");
			for (int col = 0; col < arr[col].length - 1; col++) {
				if (arr[row][col] == arr[rowNum][colNum])
					arr[row][col] = "X";
				else
					arr[row][col] = " ";
				System.out.print(arr[row][col] + " ");
			}
			
			System.out.println();
		}

	}
	public void ex17() {
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String[6][6];
		int rowNum;
		int colNum;
		
		while (true) {
			System.out.print("행 인덱스 입력 : ");
			rowNum = sc.nextInt();
			
			if (rowNum == 99) {
				System.out.println("프로그램 종료");
				break;
				
			} else {
				System.out.print("열 인덱스 입력 : ");
				colNum = sc.nextInt();
				
				if (rowNum < 0 || rowNum > 4 || colNum < 0 || colNum > 4)
					System.out.println("잘못 입력하셨습니다.");

				else {
					arr[rowNum][colNum] = "X";
					
					System.out.println("  0 1 2 3 4");
					for (int row = 0; row < arr.length - 1; row++) {
						System.out.print(row + " ");
						for (int col = 0; col < arr[col].length - 1; col++) {
							if (arr[row][col] == arr[rowNum][colNum])
								arr[row][col] = "X";
							else
								arr[row][col] = " ";
							System.out.print(arr[row][col] + " ");
						}
						
						System.out.println();
					}

				}
				
			}
					
		}
		
	}
	
	 
}
