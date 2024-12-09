package com.yedam.jdbc.student;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * tbl_student의 칼럼을 필드로 선언.
 */
public class Student {
	private int engScore, mathScore;
	private String stdNo, stdName, stdPhone, creationData, stdId, stdPw;
	private Date creationDate;
	
	
	
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdPw() {
		return stdPw;
	}
	public void setStdPw(String stdPw) {
		this.stdPw = stdPw;
	}
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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String cdate = sdf.format(creationDate);
		
		return " " + stdNo + " " + stdName + " " + 
	stdPhone + " " + engScore + " " + mathScore + " " + cdate;
	}
	public String showDetail() {
		String result = "----------------------------\n";
		result += "학생번호: " + stdNo + "   이름: " + stdName + "\n";
		result += "연락처: " + stdPhone + "\n";
		result += "영어점수: " + engScore + "       수학점수: " + mathScore + "\n";
		result += "----------------------------\n";
		return result;
	}
}
