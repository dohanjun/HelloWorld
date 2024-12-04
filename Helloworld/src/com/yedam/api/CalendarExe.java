package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2024,1,1);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)+"요일");
		System.out.println(cal.getActualMaximum(Calendar.DATE)+ "막날");
		
//		createCalendar(6, 30);
	}

	
	// 1일의 요일이 무슨요일인지, 마지막날이 몇일인지 알면 달력생성가능
	
	static void createCalendar(int year, int month) {
		String[] days = {"Sum","Mon","Tue","Wed","Thr","Fri","Sat"};
		
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
