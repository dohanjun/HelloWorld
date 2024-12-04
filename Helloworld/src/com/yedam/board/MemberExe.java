package com.yedam.board;

import java.util.Date;

/*
 *  회원가입, 회원정보수정, 목록
 */
public class MemberExe {
	
	// 인스턴스를 생성해서 실행하는 방법과 
	// 정적(static)필드,정적메소드를 사용하여 실행하는 방법
	
	private static Member[] storage; // 필드.

	// 생성자.
	public MemberExe() {
		storage = new Member[10];
		storage[0] = new Member("user01","1111","홍길동","010-1111-1111",new Date());
		storage[1] = new Member("user02","2222","김길동","010-2222-2222",new Date());
		storage[2] = new Member("user03","3333","고길동","010-3333-3333",new Date());
		

	}

	// 메소드.
	public static boolean addMember(Member member) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = member;
				return true; // 등록 ok.
			}
		}
		return false; // 등록 fail.
	}

	public Member[] memberList() {
		return storage;
	}

	// 3.아이디 & 비밀번호가 존재여부 반환
	public boolean login(String id, String pw) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {

				if (storage[i].getMemberId().equals(id) && 
						storage[i].getPassword().equals(pw)) {
					return true;
				}
			}
		}
		return false;
	} // end of login().

}
