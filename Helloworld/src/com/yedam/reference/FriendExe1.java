package com.yedam.reference;

import java.util.Scanner;

/*
 * 새로운 형태의 데이터 타입.
 * 이름, 연락처, 생년월일
 */
public class FriendExe1 {

	public static void main(String[] args) {
		String name = new String("홍길동");
		int age = 20;

		Friend f1 = new Friend();
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1111";
		f1.friendBirth = "1999-04-05";

		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-2222";
		f2.friendBirth = "2000-03-04";

		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-3333";
		f3.friendBirth = "2000-05-06";

		Friend[] myFriends = { f1, f2, f3 };

//		
//		System.out.println(myFriends[0].friendName);
//		System.out.println(myFriends[1].friendPhone);
//		System.out.println(myFriends[2].friendBirth);

		boolean run = true;
		
		Scanner scn = new Scanner(System.in);
		String searchName = "";

		while (run) {
			boolean sameName = false;
			System.out.println("이름을 입력하세요");

			searchName = scn.nextLine();

			for (int i = 0; i < myFriends.length; i++) {
				if (myFriends[i].friendName.equals(searchName)) {
					System.out.println("이름은" + myFriends[i].friendName + "이며, 전화번호는 " + myFriends[i].friendPhone + "이며, 생일은 " + myFriends[i].friendBirth + "입니다.");
					sameName = true;
					break;
				}
			}
			if (searchName.equals("quit")) {
				System.out.println("프로그램 종료");
				run = false;
			} if (!sameName) {
				System.out.println("찾는 이름이 없습니다.");
			}

		}
		System.out.println("프로그램 종료");
	}
}
