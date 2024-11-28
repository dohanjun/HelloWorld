package com.yedam.variable;
// 자파파일을 만들면 [name].java로 만들어지는데 class (name) 과 같아야 됨. 
public class IntExe1 {
	public static void main(String[] args) {
		int myAge = 20;
		int yourAge = 23;
		
		int ageSum = myAge + yourAge; // int + int = int
		System.out.println("agesum의 값: " + ageSum);
		
		// 자바스크립트 배열은 []이지만 자바 배열은 {}이다
		int[] intAry = {10, 20, 30};
		int sum = intAry[0] + intAry[1] + intAry[2];
		System.out.println("intAry의 합: " + sum);
		
	}
}
