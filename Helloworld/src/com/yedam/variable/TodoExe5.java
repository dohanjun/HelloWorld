package com.yedam.variable;

public class TodoExe5 {

	public static void main(String[] args) {
		// 1에서 100까지의 정수 중 3의 배수의 합을 구하고 출력
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if(i%3==0) {
				sum +=i;
			}
		}
		System.out.println(sum);
		
		
		
		//
		
		for(int i=1; i <= 5; i++) {
			for(int j =5; j>=1; j--)
				if(i>=j) {
					
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			
			System.out.println();
		}
//		System.out.println("end of prog");
	}
}
