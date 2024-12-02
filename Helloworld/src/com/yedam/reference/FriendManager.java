package com.yedam.reference;

import java.util.Iterator;
import java.util.Scanner;

/*
 * 친구정보를 저장해주는 기능
 * 1.추가 2.목록 9.종료
 * 
 * C(create)R(read)U(update)D(delete)
 * 
 * 
 * 
 */
public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		String searchName = "";

		Friend[] storage = new Friend[10]; // 친구정보를 저장할 수 있는 공간이 10개 확보함.
//		storage[0] = new Friend();
//		storage[0].friendName = "도한준";
//		storage[0].friendPhone = "010-7535-3985";
//		storage[0].friendBirth = "1994-03-03";
//		
		while (run) {
			System.out.println("1.추가 2.목록 3.조회(숙제) 4수정 5삭제 9.종료");
			System.out.println("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가.
				System.out.println("친구이름을 입력하세요");
				String name = scn.nextLine();
				System.out.println("친구전화번호를 입력하세요");
				String phone = scn.nextLine();
				System.out.println("친구생일을 입력하세요");
				String birth = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
//					System.out.println(storage[i]);
					if (storage[i] == null) { // 배열의 비어있는 위치에 저장하기 위해 조건문을 선언함
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						break;
					}
				}
				break; // switch 종료
			case 2: // 목록.
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%4s %14s %12s \n", storage[i].friendName, storage[i].friendPhone,
								storage[i].friendBirth);
					}
				}
				break; // switch 종료.
			case 3: // 조회(숙제).
				while (run) {
					boolean sameName = false;
					System.out.println("이름을 적으세요");
					searchName = scn.nextLine();
					for (int i = 0; i < storage.length; i++) {
						if (storage[i].friendName.equals(searchName)) {
							System.out.println("이름은" + storage[i].friendName + "이며, 전화번호는 " + storage[i].friendPhone
									+ "이며, 생일은 " + storage[i].friendBirth + "입니다.");
							sameName = true;
							break;
						}

					}

				}
				break;
			case 4: // 정보수정
				System.out.println("수정할 이름을 검색하세요");
				searchName = scn.nextLine();
				System.out.println("이름을 수정하세요");
				String changeName = scn.nextLine();
				System.out.println("번호를 수정하세요");
				String searchPhone = scn.nextLine();
				System.out.println("생일을 수정하세요");
				birth = scn.nextLine();

				// 10개중에 null값이 있는지 확인해야됨
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // 이렇게 조건문을 한 이유는 null이 아닌 값중에서 비교하기 위해
						if (storage[i].friendName.equals(searchName)) {
							storage[i].friendName = changeName;
							storage[i].friendPhone = searchPhone;
							storage[i].friendBirth = birth;

							break;

						}
					}
				}
				break;

			case 5: // 삭제
				System.out.println("삭제 할 이름을 검색하세요");
				searchName = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // 이렇게 조건문을 한 이유는 null이 아닌 값중에서 비교하기 위해
						if (storage[i].friendName.equals(searchName)) {
							storage[i] = null;

							break;

						}
					}
				}
				break;

			case 6: //
			case 9: // 종료.
				run = false;
				break;// switch 종료
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}
		}
		System.out.println("프로그램 끝");

	}
}
