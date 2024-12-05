package com.yedam.jdbc.student;
/*
 * tbl_student의 칼럼을 필드로 선언.
 */
public class Student {
	private int engScore, mathScore;
	private String stdNo, stdName, stdPhone, creationData;
	
	
	
	
	public String getCreationData() {
		return creationData;
	}
	public void setCreationData(String creationData) {
		this.creationData = creationData;
	}
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	
	
	
	public String showInfo() {
		return " " + stdNo + " " + stdName + " " + stdPhone + " " + engScore + " " + mathScore;
	}

}
