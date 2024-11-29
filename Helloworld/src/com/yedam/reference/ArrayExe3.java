package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe3 {
	public static void main(String[] args) {
		//배열의 인덱스를 활용해서 같은 순번에 있는 값들은 동일한 사람의 값으로 인식
		String[] names = {"홍길동", "김민수", "최두식"};
		int[] scores = {80, 90, 70};
//		for(int i = 0; i <names.length; i++) {			
//			System.out.println(names[i] + "의 점수는" + scores[i] + "입니다.");
			
		// quit 입력을 하면 프로그램을 종료함.
		boolean run = true;
		boolean sameName = false;
		Scanner scn = new Scanner(System.in);
		String searchName = "";
		
				
		
		
		while(run) {
			System.out.println("이름>>> ");
			
			searchName = scn.nextLine();
			
			
			
			
			
			for (int i = 0; i < names.length; i++) {
				if(names[i].equals(searchName)) {
					System.out.println(scores[i] + names[i]);
				}
			}
			for (int i = 0; i < names.length; i++) {
				if(names[i].equals(searchName)) {
					sameName = true;
					break;
				}
			}
			if(searchName.equals("quit")) {
				System.out.println("프로그램 종료");
				run = false;
			}
			else if(!sameName) {
				System.out.println("찾는 이름이 없습니다.");
			}
			// names 배열에서 사용자가 입력한 이름.
			
		
		}
//		System.out.println("프로그램 종료");
		}
	}


