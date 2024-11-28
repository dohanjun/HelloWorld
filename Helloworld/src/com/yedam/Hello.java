package com.yedam;

//자바는 대소문자 구분을 한다 (A 와 a 는 서로 다름)
// 자바는 객체지향언어이다 ( Object Oriented Language)
public class Hello {
	
	// 메소드를 여러개 선언함. start(), main();
	
	public static void start() {
		System.out.println("시작합니다");
	}
	
	// 메인 메소드. 함수(function)
	public static void main(String[] args) {         // class를 만들면 main을 무조건 찾음
		// 콘솔에 Hello, World 출력.
		System.out.println("Hello, World");
		start();
		
		// 변수선언 let result = "Hello";
		OperationExe exe = new OperationExe();
		exe.sum(10, 20);
		
		// Hello.java를 컴파일하면 Hello.class(실행파일)
		// HelloWorld 프로젝트 -HelloWorld repository

	}
} // end
