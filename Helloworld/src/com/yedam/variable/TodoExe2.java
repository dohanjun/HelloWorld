package com.yedam.variable;

import java.util.Scanner;

public class TodoExe2 {
	public static void main(String[] args) {
		String name = "김길동";

		Scanner scn = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String inputValue = scn.nextLine(); // 사용자의 입력값을 반환
		
		if(name.equals(inputValue)) {
			System.out.println("같습니다.");
		}else {
			System.out.println("다릅니다.");
		}
		
		
//		if(name == inputValue)// 이건 안됨	
		
		System.out.println("입력한 값은 " + inputValue); // 입력한 값이 같으면 같은이름입니다. 다른이름이면 다른이름입니다.
		
		System.out.println("end of prog");
	}
}
