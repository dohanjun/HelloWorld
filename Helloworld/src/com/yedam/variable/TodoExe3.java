package com.yedam.variable;

import java.util.Scanner;

public class TodoExe3 {
	public static void main(String[] args) {
		String[] names = {"박창석","홍영민","김익수","이화영"};
		
		Scanner scn = new Scanner(System.in);
		System.out.println("친구이름을 입력하세요>>>>");
		String searchString = scn.nextLine();
		boolean asd = false; // 참과 거짓을 나타낼때 쓰는 자료형(type)
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals(searchString)) {
			 asd = true;
			}
		}
		if(asd) {
			System.out.printf("입력한 이름%2s이 존재합니다 나이는 %2d\n", searchString, 10);
			
		}else {
			
			System.out.print("입력한 이름 " + searchString +" 이 없습니다");
		}
		System.out.printf("end of prog");
		
		//"입력한 이름이 존재합니다", "입력한 이름이 없습니다"
		// end of prog
	}
}
