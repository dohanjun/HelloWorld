package com.yedam.board;
/*
 * 회원아이디, 비밀번호, 이름, 연락처
 */

public class Member {
	private String memberId;
	private String password;
	private String memberName;
	private String phoneNumber;
	
	//생성자
	public Member(String memberId, String password, String memberName, String phoneNumber) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
	}
	
	// 메소드.
	public String showInfo() {
		return "아이디는" + memberId + "이고, 이름은  " + memberName + "이고, 연락처는  " + phoneNumber + " 입니다."; 
	}
	
	//get 메소드
	public String getMemberId() {
		return memberId;
	}
	public String getPassword() {
		return password;
	}
}
