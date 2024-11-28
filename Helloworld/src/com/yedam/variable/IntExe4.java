package com.yedam.variable;

public class IntExe4 {
	public static void main(String[] args) {
		String msg = "Hello, World"; // 문자열이라 숫자가 들어가면 에러남      // msg 주소값에 가보면 Hello, World라는 값이 담김
		int age = 10; // age 주소값에 가보면 10이라고하는 값이 실제로 담김
		
		int myAge = age;
		System.out.println(myAge == age);
		
		myAge = 20;

		
		
		System.out.println("age=>"+age+", myAge=>"+myAge);
		System.out.println(msg.equals("Hello, World")); // 문자값을 비교할 떄에는 equals를 써라
		System.out.println(msg == "Hello, World");
	}
}
