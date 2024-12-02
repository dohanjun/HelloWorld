package com.yedam.student;

import java.util.Scanner;

public class StudentManager {
	public static void main(String[] args) {

		boolean run = true;

		Scanner scn = new Scanner(System.in);
		String searchName = "";

		Student[] storage = new Student[10];

		while (run) {
			System.out.println("1.추가 2.목록 3수정 4삭제 5상세조회(합계,평균) 6.합계점수기준 9.종료");
			System.out.println("선택>>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("수험생번호를 입력하세요");
				String number = scn.nextLine();
				System.out.println("수험생이름을 입력하세요");
				String name = scn.nextLine();
				System.out.println("영어점수를 입력하세요");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.println("수학점수를 입력하세요");
				int mscore = Integer.parseInt(scn.nextLine());
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) {
						storage[i] = new Student(number, name, escore, mscore); // 33~36열 쓴거랑 똑같음
//						storage[i].studentNumber = number;
//						storage[i].studentName = name;
//						storage[i].englScore = escore;
//						storage[i].mathScore = mscore;
						break;
					}
				}
				break;

			case 2:
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%4s %4s %5s %5s \n", storage[i].studentNumber, storage[i].studentName,
								storage[i].englScore, storage[i].mathScore);
					}
				}
				break;

			case 3:
				System.out.println("수정할 수험생이름을 검색하세요");
				searchName = scn.nextLine();
				System.out.println("수험생의 영어점수를 수정하세요");
				int changeescore = Integer.parseInt(scn.nextLine());
				System.out.println("수험생의 수학점수를 수정하세요");
				int changemscore = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].studentName.equals(searchName)) {
							storage[i].englScore = changeescore;
							storage[i].mathScore = changemscore;

							break;
						}
					}
				}

				break;

			case 4:
				System.out.println("삭제 할 학생이름을 검색하세요");
				searchName = scn.nextLine();

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].studentName.equals(searchName)) {
							storage[i] = null;

							break;
						}
					}
				}
				break;

			case 5:

				System.out.println("수험생의 이름을 입력하세요");
				searchName = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].studentName.equals(searchName)) {

							double a = storage[i].englScore;
							double b = storage[i].mathScore;

							int scoreSum = storage[i].englScore + storage[i].mathScore;
							double average = (a + b) / 2;

							System.out.println("수험생의 점수의 총합은" + scoreSum + "입니다");
							System.out.println("수험생의 점수의평균은" + average + "입니다");

							break;
						}
					}
				}
				break;

			case 6:
				for (int j = 0; j < storage.length - 1; j++) {
					if (storage[j] == null) {
						break;
					}
					for (int i = 0; i < storage.length - 1; i++) {
						if (storage[i + 1] == null) {
							break;
						}
						if (storage[i].englScore + storage[i].mathScore > storage[i + 1].englScore
								+ storage[i + 1].mathScore) {
							Student temp = storage[i];
							storage[i] = storage[i + 1];
							storage[i + 1] = temp;

						}

					}
				}
				break;

			case 9:
				run = false;
				break;

			default:
				System.out.println("메뉴를 다시 선택하세요");

			}

		}
	}

}