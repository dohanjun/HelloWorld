package com.yedam.variable;

public class TodoExe1 {
	public static void main(String[] args) {
		// Math.random() : 0~1 사이의 임의의 실수를 만듬
		//1 ~ 100 까지의 임의의 수를 3번
		
		int sum = 0;
		
		for(int i = 0; i<3; i++) {
//			Math.random(num)*3;
			int num = (int)(Math.random()*100);
			System.out.println(num);
			sum += (int)num;
		}
		System.out.println(sum);
		
	}
}
