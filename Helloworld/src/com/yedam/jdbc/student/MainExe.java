package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {
	static Scanner scn = new Scanner(System.in);

	// db처리기능.
	static StudentDAO dao = new StudentDAO();

	public static void main(String[] args) {
		boolean run = true;

		// 로그인 기능.
		while(run) {
		System.out.println("아이디 입력");
		String id = scn.nextLine();
		System.out.println("비밀번호 입력");
		String pw = scn.nextLine();
	
		if (dao.login(id,pw)) {
			System.out.println("정상 등록");
			break;
		} else {
			System.out.println("등록 실패");
		
		}
		
		}

		while (run) {
			System.out.println("1.목록 2.등록 3.점수등록 4.상세보기 5.삭제 9.종료");
			System.out.println("선택>>>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {

			case 1:
				list();

				break;

			case 2:// 등록.
				System.out.println("학생번호입력=======");
				String no = scn.nextLine();
				System.out.println("학생이름입력=======");
				String name = scn.nextLine();
				System.out.println("연락처입력========");
				String phone = scn.nextLine();
				Student std = new Student();
				std.setStdNo(no);
				std.setStdName(name);
				std.setStdPhone(phone);

				if (dao.insertStudent(std)) {
					System.out.println("정상 등록");
				} else {
					System.out.println("등록 실패");
				}
				break;
			case 3:
				System.out.println("학생번호 입력>");
				no = scn.nextLine();
				System.out.println("영어점수 입력>");
				int es = Integer.parseInt(scn.nextLine());
				System.out.println("수학점수 입력>");
				int ms = Integer.parseInt(scn.nextLine());

				std = new Student();
				std.setStdNo(no);
				std.setEngScore(es);
				std.setMathScore(ms);

				if (dao.updateStudent(std)) {
					System.out.println("정보수정");
				} else {
					System.out.println("정보수정실패");
				}
				break;
			case 4:
				System.out.println("학생번호 입력>");
				no = scn.nextLine();

				std = dao.selectStudent(no);
				if (std == null) {
					System.out.println("조회된 결과 없습니다.");
					break;
				}
				System.out.println(std.showDetail());
				break;
			case 5:
				System.out.println("삭제할 학번");
				no = scn.nextLine();
				Student dstd = new Student();
				dstd.setStdNo(no);
				
				if (dao.deleteStudent(dstd)) {
					System.out.println("정보수정");
				} else {
					System.out.println("정보수정실패");
				}
				break;
			case 9:// 종료
				run = false;
			default:
				break;
			}

		}
		System.out.println("end of prog");
	}

	public static void list() {
		Search search = new Search();

		System.out.println("1. 학생이름 2. 연락처 3. 영어점수");
		System.out.print("선택>>>");
		int menu = Integer.parseInt(scn.nextLine());
		switch (menu) {
		case 1:
			System.out.print("검색할 이름을 입력해주세요");
			String name = scn.nextLine();
			search.setName(name);

			break;
		case 2:
			System.out.print("검색할 연락처를 입력해주세요");
			String phone = scn.nextLine();
			search.setPhone(phone);
			break;
		case 3:
			System.out.print("검색할 영어점수를 입력해주세요");
			int escore = Integer.parseInt(scn.nextLine());
			search.setEngScore(escore);
			break;
		}
		System.out.println("1. 학생번호정렬 2. 학생이름정렬 3. 전화번호정렬");
		System.out.print("선택>>>");
		int orderBy = Integer.parseInt(scn.nextLine());
		// 정렬조건 추가.
		switch (orderBy) {
		case 1:
			search.setOrderBy("std_no");
			break;
		case 2:
			search.setOrderBy("std_name");
			break;
		case 3:
			search.setPhone("std_phone");
			break;
		}

		ArrayList<Student> list = dao.studentList(search);
		for (Student stud : list) { // 학생번호, 이름, 연락처
			System.out.println(stud.showInfo());
		}
	}// end of list().

}
