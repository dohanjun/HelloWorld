package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe3_1 {

	public static void main(String[] args) {
		String[] names = { "홍길동", "김민수", "최두식" };
		int[] scores = { 80, 90, 70 };

		boolean run = true;
//		boolean sameName = false;
		Scanner scn = new Scanner(System.in);
		String searchName = "";

		while (run) {
		searchName = scn.nextLine();
		if (searchName.equals("quit")) {
			run = false;
		}else {
			boolean isExists = false;
			int idx = -1;
			for (int i = 0; i < names.length; i++) {
				isExists = names[i].equals(searchName);
				if(isExists) {
					idx = i;
					break;
				}
			}
			if(isExists) {
				System.out.println(names[idx] + scores[idx]);
			} else {
				System.out.println("찾는 이름 없음");
			}
		}
		
		
		
		}
}
}