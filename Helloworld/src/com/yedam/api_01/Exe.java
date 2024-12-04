package com.yedam.api_01;

public class Exe {

	public static void main(String[] args) {

		
		String str ="안녕하세요";
		
		
		
		
		
		
		
	}
	public void sex() {
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다");
			break;
		}

	}
	public void strVar() {
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		}
		else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		}
		else {
			System.out.println("다른 문자열을 가짐");
		}
	}

}
