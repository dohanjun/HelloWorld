package com.yedam.jdbc.student;
/*
 * 이름, 연락처, 영어점수, 수학점수, 정렬조건
 */
public class Search {
	//private = 필드
	private String stdNo;
	private String name;
	private String phone;
	private int engScore;
	private int mathScore;
	private String orderBy = "std_no";
	
	
	
	
	// getter, setter 생성
	
	
	public String getName() {
		return name;
	}
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
	
}
