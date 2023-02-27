package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService {

	
	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentService() {
		
		
		studentList.add(new Student("홍길동", 3, 5, 17, "서울시 중구", 'M', 75));
		studentList.add(new Student("김삼순", 2, 3, 10, "서울시 서대문구", 'F', 85));
		studentList.add(new Student("박철수", 5, 3, 27, "서울시 성북구 ", 'M', 65));
		studentList.add(new Student("이제인", 1, 1, 3, "서울시 강남구", 'F', 71));
		studentList.add(new Student("유재석", 4, 6, 20, "서울시 노원구 ", 'M', 95));
		
		
		
	}
	
	public boolean addStudent(Student std) {
		return studentList.add(std);
		
	}
	
	
	/** 학생 전체 조회 서비스
	 * @return studentList
	 */
	public List<Student> selectAll() {
				
		return studentList;
	}

	/** 학생 정보 수정 서비스
	 * @param index
	 * @param std
	 * @return s : Student (수정되기 전 학생 정보)
	 */
	public Student updateStudent(int index, Student std) {
		
		// e2 set(int index, E e) : 1) index에 위치하는 요소를 e로 변경
		// 							2) 기존에 있던 요소 e2를 반환
		
				return studentList.set(index, std);
	}

	/** 학생 정보 수정 서비스
	 * @param index
	 * @return s: Student(제거된 학생 정보)
	 */
	public Student removeStudent(int index) {
		
		// E remove (int index) : index번째 요소를 List 에서 제거하여 반환
		// boolean remove(E e) : List에서 E와 일치하는 요소를 찾아서 
		//						 있으면 제거하고 true 
		// 						 없으면 false 반환
		
		
		return studentList.remove(index);
	}

	public Student findStudent(String nextLine) {
		
		return null;
	}

	public Student findStudent(String nextLine) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}
