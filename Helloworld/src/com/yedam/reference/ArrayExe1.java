package com.yedam.reference;

public class ArrayExe1 {

	public static void main(String[] args) {
		int [] intAry = new int[5];
		// 위치 => 인덱스를 활용해서 위치에 있는 값을 불러옴(인덱스는 0부터시작)
		intAry[0] = 10; //
		intAry[1] = 20;
		intAry[2] = 30;
		intAry[3] = 40;
	
				
		
//		System.out.println(intAry.length);   //intAry의 배열갯수
		
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
		}
		
		//배열의 크기를 초과하여 값을 지정하거나 불러오려고하면 에러가뜬다
		
		intAry[4] = 50;
		
		double[] dblAry = {2.5, 1.2, 4, 5.6, 8}; // 초기값을 지정해서 선언할수있음.
		dblAry[1] = 9.9;
		
		dblAry = new double[] {2.3, 6.7}; // 변수를 선언한 후 새로운 값을 넣으려면 new double을 써야됨
		
		for (int i = 0; i < dblAry.length; i++) {
			System.out.println(dblAry[i]);
		}
		
		// 문자열 배열.
		String[] strAry = {"홍길동", "김민섭", "박창규"};
		// enhanced for.
		for(String str : strAry) {
			System.out.println(str);
		}
	}

}
