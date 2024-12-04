package com.yedam.api;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("년도를 입력하세요");
		int year = scn.nextInt();
		System.out.println("월을 입력하세요");
		int month = scn.nextInt();
		createCalendar(year, month);
	}

	
	// 1일의 요일이 무슨요일인지, 마지막날이 몇일인지 알면 달력생성가능
	
	static void createCalendar(int year, int month) {
		 Calendar cal = Calendar.getInstance();
		 cal.set(year,month,1);// 2024년 2월 1일
		 // cal.set(year, month, day)
		
		 int positionOfDay = cal.get(Calendar.DAY_OF_WEEK);
		 int lastDate = cal.getActualMaximum(Calendar.DATE);
					  //{  0     1     2     3    4     5     6}
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		
		//1일의 위치를 지정
		for (int i = 1 ; i < positionOfDay; i++) {
			System.out.printf("%4s", " ");
		}
		for (int d = 1; d <= lastDate; d++) {
			System.out.printf("%4s", d);
			if((d + positionOfDay -1)% 7 == 0) {
				System.out.println();
			}
		}
	}
}
