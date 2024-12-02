package com.yedam.student;
/*
 * 예담학생의 성적관리 Prog
 * 입력할 것은 학생번호, 학생이름, 영어점수, 수학정
 */

public class Student {

	public String studentNumber; // 속성 = 필드
	public String studentName;	
	public int englScore;
	public int mathScore;
	
	
	// 컴파일러가 기본 생성자를 만들어준다.
	
	public Student() {}
	
	
	public Student(String studentNumber,String studentName ) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
	}
	
	public Student(String studentNumber,String studentName, int englScore, int mathScore ) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.englScore = englScore;
		this.mathScore = mathScore;
	}
	
	
	
	
	
	public Student(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
	//메소드.
	public void smile() {
		System.out.println("학생이 웃습니다.");
		
	}
	public void introduce() {
		System.out.println("이름은 " + studentName + "이고, 학번은" + studentNumber);
		
	}
	
	
	public int sumScore() {
		return englScore + mathScore;
	}
	
	
	public double averageScore() {
		return (englScore + mathScore) / 2.0;
	}
}
