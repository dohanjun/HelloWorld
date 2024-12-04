package com.yedam.inheritance;

public class MainExe {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.filed1 = "부모필드";
		p1.method1(); 
		System.out.println(p1.toString());
		
//		p1.method2();// 자식클래스의 멤버는 사용불가
		
		
		
		Child c1 = new Child(); // Parent 클래스의 자식요소인
		c1.filed1 = "자식필드";
		c1.method1();
		c1.filed2 = "자식필드2";
		c1.method2();
		System.out.println(c1.toString());
	}

}
