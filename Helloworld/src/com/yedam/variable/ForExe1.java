package com.yedam.variable;

public class ForExe1 {
	public static void main(String[] args) {
	//break: 반복 종료
	//continue: 이래부분 실행X 다음순번으로 넘어감
		for(int i = 1; i <=10; i++) {
			
			
			if(i == 7) {
				break;
			}
			if(i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}
		
		System.out.println("end of prog");
 	}
}
