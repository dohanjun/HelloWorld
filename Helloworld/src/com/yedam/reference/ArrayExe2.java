package com.yedam.reference;
/*
 * 배열 활용 연습.
 * 작성자: 이창호
 * 작성일시: 2024.11.29
 * 
 */

import java.util.Scanner;

public class ArrayExe2 {
	public static void main(String[] args) {
		// 변수초기화.
		boolean run = true;
		int balance = 0;
		int maxBalance = 100000;
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료   ");
			System.out.println("--------------------------");
			System.out.println("선택>>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				System.out.print("예금액>");
				int inBalance = Integer.parseInt(scn.nextLine());
				if(balance + inBalance <= maxBalance) {
					balance += inBalance;					
				}else {
					System.out.println("금액초과");
				}
				break;
				
			case 2:
				System.out.print("출금액>");
				inBalance = Integer.parseInt(scn.nextLine());
				if(balance - inBalance>0) {					
					balance -= inBalance;
				}else {
					System.out.println("잔고부족");
				}
				break;
				
			case 3:
				System.out.print("잔고>" + balance);
				break;
			case 4:
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

}
