package teamproject.start;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameStart {

	Scanner sc = new Scanner(System.in);
	public void displayView() {
		int input = 0;
		
		do {
			try {
				System.out.println("KH PLACE");
				System.out.println("1. 게임 시작");
				System.out.println("2. 만든 사람");
				System.out.println("3. 게임 종료");
				System.out.println();
				
				System.out.print("입력>>>>");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1: ex1();break;
				case 2: ex2();break;
				case 3: System.out.println("게임 종료"); break;
				default : System.out.println("잘못된 입력 방식입니다"); break;
				}
				
				
				
				
			}catch(Exception e) {
				System.out.println("[잘못된 형식의 입력입니다.]");	
			sc.nextLine(); // 
			input = -1; // 
			}
			System.out.println();
		}while (input != 0 );
		
	}
	
	
	/** 1. 게임 시작을 눌렀을 때 시작되는 화면
	 * 
	 */
	public void ex1() {
		System.out.println("축하드립니다!\n"
				+ "당신은 꿈에 그리던 카페 사장이 되었습니다. \n카페 이름을 정해주세요.");
		System.out.println();
		System.out.print("카페 이름 :"); 
		String name = sc.nextLine();
		System.out.print("사장 이름 :"); 
		String ceo = sc.nextLine();
		
		
	}
	
	
	/** 2 )만든 사람을 눌렀을때 
	 * 
	 */
	public void ex2() {
		
		System.out.println("만든이 : Team Choi & Jang");
		
		
		
	}
	
	
	
}
