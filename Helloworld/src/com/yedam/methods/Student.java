package com.yedam.methods;
/*
 * 예담학생의 성적관리 Prog
 * 입력할 것은 학생번호, 학생이름, 영어점수, 수학정
 */

public class Student {

	private String studentNumber; // 속성 = 필드
	private String studentName;	
	private int englScore;
	private int mathScore;
	//생성자. => 인스턴스를 생성하면서 필드의 값을 초기화 해주는 기능.
	public Student(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
	public Student(String studentNumber, String studentName, int englScore, int mathScore) {
		
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.englScore = englScore;
		this.mathScore = mathScore;
	}
	//getter, setter. 메소드.
	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getEnglScore() {
		return englScore;
	}

	public void setEnglScore(int englScore) {
		this.englScore = englScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	
	//showInfo
	public String showInfo() {
		return "학번 : " + studentNumber + "이름 " + studentName + " 영어: " + englScore +" 수학: " + mathScore;
	}
	
	
}