package com.yedam.inheritance;
/*
 * Parent : 부모클래스
 */
public class Parent extends Object {
	String filed1; //필드

	public Parent() {
		
	}
	
	//생성자
	// 개발자가 생성자에 대한 정의를 하지않으면 컴파일러가 스스로 기본생성자를 만들어줌.
	//개발자가 생성자를 정의를 하면 기본생성자는 없음.
	public Parent(String filed1) {
		super(); // super는 부모를 가리킴.
		this.filed1 = filed1;
	}

	void method1() {
		System.out.println("method1 호출");
	}

	@Override
	public String toString() {
		return "Parent의 값은" + filed1;
		
	}
}


