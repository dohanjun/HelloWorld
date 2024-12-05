package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scn =new Scanner(System.in);
		
		//db처리기능.
		StudentDAO dao = new StudentDAO();
		
		
		
		
		
		while(run) {
			System.out.println("1.목록 2.등록 3.점수등록 9.종료");
			System.out.println("선택>>>");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			
			case 1:
				ArrayList<Student> list = dao.studentList();
				for(Student stud : list) { // 학생번호, 이름, 연락처
					System.out.println(stud.showInfo()); 
				}
				break;
			
			case 2://등록. 
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
				
				
				
				if(dao.insertStudent(std)) {
					System.out.println("정상 등록");
				}else {
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
				
				
				if(dao.updateStudent(std)) {
					System.out.println("정보수정");
				}else {
					System.out.println("정보수정실패");
				}
				break;
			case 4:
				System.out.println("학생번호 입력>");
				no = scn.nextLine();
				
				std = dao.selectStudent(no);
				if(std == null) {
					System.out.println("조회된 결과 없습니다.");
					break;
				}
				System.out.println(std.showDetail());
				
			case 9://종료
				run = false;
			default:
				break;
			}
			
			
			
		}
		System.out.println("end of prog");
	}

}
