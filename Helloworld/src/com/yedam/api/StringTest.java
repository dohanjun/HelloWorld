package com.yedam.api;

import java.util.Date;

public class StringTest {
	public static void main(String[] args) {
		test3();
	}

	static void test1() {
		// 현재 시간을 yyyy/MM/dd hh:mm:ss 로 출력.
		Date now = new Date();
		answer1(now);
	}

	static void answer1(Date today) {
		System.out.println((today.getYear()+1900) +  "/" + (today.getMonth()+1) + "/" + today.getDate() + " " + today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds());
		}

	static void test2() {
		// 주민번호를 받아서 성별을 구별하는 프로그램.
		String[] numbers = { "9501231234567", "950405 2345678", "980102-1345678" };
		for (int i = 0; i < numbers.length; i++) {
			char a = answer2(numbers[i]).charAt(6);
			if (a == '1' || a == '3') {
				System.out.println("번호 는 남자입니다.");				
			}
			else if(a == '2' || a == '4') {
				System.out.println("번호 는 여자입니다.");
			}else {
				System.out.println("다시입력하세요");
			}
		}
	}

	static String answer2(String ssn) {
		int length = ssn.length();
		if(length == 13) {
			 return ssn;
		}else {
			
			String firstNum = ssn.substring(0, 6);
			String lastNum = ssn.substring(7);
			String newSsn = firstNum + lastNum;
			return newSsn; 
		} 
	}

	static void test3() {
		// 파일의 이름과 확장자를 구하는 코드.
		String[] files = { "c:/temp/rose.jpg", "d:/download/new.txt", "temp/good.jpeg" };
		for (int i = 0; i < files.length; i++) {
			System.out.println("파일명 의 확장자는 jpg 입니다.");
//		answer3();
		}
	}

	static String answer3(String name) {
		int endPos = name.indexOf(",");
		int startPos = name.lastIndexOf("/");
		String ext = name.substring(startPos + 1, endPos);
		return ext;
	}
}
