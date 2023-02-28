package edu.kh.collection.list.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.list.dto.Student;
import edu.kh.collection.list.service.StudentService;

public class StudentView {

	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	public void displayMenu(){
		int input =0;
		
		do {
			try {
				System.out.println("\n--- 학생 관리 프로그램---\n");
				System.out.println("1. 학생 정보 추가");
				System.out.println("2. 학생 전체 조회");
				System.out.println("3. 학생 정보 수정");
				System.out.println("4. 학생 정보 제거");
				System.out.println("5. 학생 이름 검색");
				System.out.println("6. 학생 주소 검색");
				System.out.println("7. 학년별 조회 ");
				System.out.println("8. 성별 조회 ");
				System.out.println("9. 성적 순서 조회 ");
				System.out.println("0. 프로그램 종료 ");
				System.out.println();
				
				System.out.print("메뉴 선택 >>");
				input  = sc.nextInt();
				sc.nextLine(); //  입력 버퍼에 남은 개행문자 제거
				
				System.out.println();
				
				switch(input) {
				case 1: addStudent(); break;
				case 2: selectAll(); break;
				case 3: updateStudent();break;
				case 4: removeStudent();break;
				case 5: selectName(); break;
				case 6: selectAddress(); break;
				case 7: selectGrade(); break;
				case 8: selectGender(); break;
				case 9: sortScore(); break;
				case 0: break;
				default : System.out.println("[프로그램 종료]"); break;
				}
				
			}catch(InputMismatchException e){
				System.out.println("[잘못된 형식의 입력입니다.]");	
				sc.nextLine(); //  입력버퍼에 잘못 입력된 내용 제거
				input = -1; // 반복문이 종료 되는 것을 방지  
			}
			System.out.println();
		}while (input != 0);
		
		
		
	}
	/** 학생 정보 추가
	 * 
	 */
	public void addStudent() {
		System.out.println("\n--- 학생 정보 추가---\n");
		
		Student std = inputStudent();
		
		if(service.addStudent(std)) {
			System.out.println("[학생 정보가 추가되었습니다]");
		}
		
		
	}
	
	/** 전체 학생 조회
	 * 
	 */
	private void selectAll() {
		System.out.println("\n--- 전체 학생 조회---\n");
		
		List<Student> list = service.selectAll();
		
		// 향상된 for문
		for( Student s : list) { 
			System.out.println(s.toString());
			
			// print 관련 메서드에서 
			// 참조변수를 출력하고자 매개변수로 전달하면
			// 자동으로 .toString()을 붙여서 호출(컴파일러)
			
		}
		
	}
	
	/** 학생 정보 수정
	 * 
	 */
	private void updateStudent() {
		System.out.println("\n--- 학생 정보 수정 ---\n");
	
		System.out.println("<수정할 정보를 입력하세요>");
	
		Student std = inputStudent();
		
		System.out.println("------------------------------");
		System.out.print("수정할 학생의 index : ");
		int index = sc.nextInt();
		
		Student s = service.updateStudent(index,std);
		// s == 수정되기 전 학생 정보가 반환됨
		
		System.out.println(s.getName() + "의 정보가 수정 되었습니다");
	}
	
	/** 학생 전체 정보를 입력 받아 Student 객체로 반환하는 메서드
	 * @return std:Student
 	 */
	private Student inputStudent() {
		System.out.print("이름 :" );
		String name = sc.nextLine();
		
		System.out.print("학년 :");
		int grade = sc.nextInt();
		System.out.print("반 :");
		int classRoom = sc.nextInt();
		System.out.print("번호 :");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("성별(M/F) : ");
		char gender = sc.next().toUpperCase().charAt(0);
		
		System.out.print("성적 :");
		int score = sc.nextInt();
		
		Student std = new Student(name, grade, classRoom, number, address, gender, score);
		
		
		return std;
		
	}
	
	private void removeStudent() {
		System.out.println("\n--- 학생 정보 제거 ---\n");
		System.out.print("삭제할 학생의 인덱스 입력 : ");
		int index = sc.nextInt();
		
		Student s =service.removeStudent(index);
		System.out.println(s.getName() + "학생 정보가 제거되었습니다");
		
	}
	
	private void selectName() {
		System.out.println("\n--- 학생 이름 검색 ---\n");
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		List<Student> list = service.selectName(name);
		
		// 만약 검색 결과가 없을 경우
		// list.size() : 리스트에 저장된 객체의 수
		// list.isEmpty() : 리스트에 저장된 객체가 없다면 true
 		
//		if(list.size() == 0) { // 저장된 객체의 수가 0개인 경우
	//		}
	
		if(list.isEmpty()) { // 저장된 객체의 수가 0개인 경우
		System.out.println("검색 결과가 없습니다.");
		
		} else {
		for(Student s : list ) System.out.println(s);
		}
		
		
		
	}
	
	private void selectAddress() {
		System.out.println("\n--- 학생 주소 검색 ---\n");
		
		System.out.print("주소에 포함된 단어 입력 : ");
		String input = sc.nextLine();
		
		List<Student> list = service.selectAddress(input);
		
		if(list.isEmpty()) {
			System.out.println("검색 결과가 없습니다");
		} else {
			for (Student s : list) {
				System.out.printf("%d 학년 %d반 %d번 %s / 주소 : %s \n",
						s.getGrade(), s.getClassRoon(), s.getNumber(), s.getName(),
						s.getAddress());
			}
		}
		
	}
	private void selectGrade() {
		System.out.println("\n--- 학년별 조회 ---\n");
		System.out.print("조회할 학년을 입력하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		List<Student> list  = service.selectGrade(num);
		
		if(list.isEmpty() ) {
			System.out.printf("%d학년 학생이 존재하지 않습니다 \n" , num);
		
		} else {System.out.printf("%d학년 조회결과 \n", num);
		for(Student s : list ) {
			System.out.printf("%d학년 %d반 %d번 %s \n" ,
					s.getGrade(), s.getClassRoon(), s.getNumber() ,s.getName());
			
		
			}
		}
	
		
		

	}
	
	/** 성별조회
	 * 
	 */
	private void selectGender() {
		System.out.println("\n--- 성별 조회 ---\n");

		while (true) {
			System.out.print("조회할 성별을 입력하세요 (M/F) : ");
			char sg = sc.nextLine().toUpperCase().charAt(0);

			if (sg == 'M' || sg == 'F') {
				List<Student> list = service.selectGender(sg);
				if (list.isEmpty()) {

					System.out.println("검색 결과가 없습니다");
				} else {
					char gender = sg == 'M' ? '남' : '여';
					System.out.printf(" [%c학생 목록] \n", gender);

					for (Student s : list) {
						System.out.printf("%d학년 %d반 %d번 %s(%c) \n", s.getGrade(), s.getClassRoon(), s.getNumber(),
								s.getName(), s.getGender());
					}

				}
				break;
				
			} else {
				System.out.println("M 또는 F만 입력 해주세요");

			}

		}

	}
	
	/**
	 *  성적순서 조회
	 */
	private void sortScore() {
		System.out.println("\n--- 성적 순서 조회 ---\n");
		
		// 
		List<Student> studentList = service.sortScore();
		
		for(Student s : studentList) {
			System.out.println(s);
		}
		
		
		
		
		
	}
	
	
}
