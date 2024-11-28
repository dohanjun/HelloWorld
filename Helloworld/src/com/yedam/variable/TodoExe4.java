package com.yedam.variable;

import java.util.Scanner;

public class TodoExe4 {

	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		System.out.println("몇단까지 출력하겠습니까?>>");
		int dan = scn.nextInt();
		
		

		
//		for(int j=0; j<=9; j++) {
////			System.out.printf("현재 %d 단입니다. \t", j);
//		for(int i = 2; i<=dan; i++) {
//			if(j==0) {
//				System.out.printf("[%5d]       ", i);
//			}else {
//				
//				System.out.printf("%d * %d = %2d \t", i, j, j * i);
//			}
//			System.out.println();
//		}
//		System.out.println("end of prog.");
//	}
		for(int i = 5; i >= 1; i--) {
			
			for (int j = 1; j<=i;j++) {
//				if(i >= j) {
					System.out.printf("*");					
//				}
			}
			System.out.println();
		}
		
		System.out.println("end of prog");
}
}

