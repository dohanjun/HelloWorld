package com.yedam.reference;

public class TodoExe1 {

	public static void main(String[] args) {
		// 정수를 담는 배열 크기는 5개 짜리로 선언
		// Math.random()을 활용해서 50 ~ 100 사이의 점수를 저장.
		int [] intAry = new int[5];
		for( int i = 0; i < intAry.length; i++) {
			int a = (int)(Math.random()*5)+50;
			// 2번째 값
			boolean exists = false; // 
			for(int j=0;j <= i-1; j++) {
				if(intAry[j] == a) {
					exists = true;// 똑같은 값이 존재.
				}
			}
			//같은 값이 존재한다면 i의 값은 증가하지않는다
			if(exists) {
				continue;
			}
			intAry[i] = a;
			i++;
	
		}
		for(int i : intAry) {
			System.out.println(intAry[i]);
		}
	}

}
