package com.yedam.variable;

public class IntExe2 {
	public static void main(String[] args) {
		// 정수형타입 => byte(1바이트), short(2바이트), int(4바이트), long(8바이트), char(2바이트)
		// 1비트 * 8 => 1바이트.
		
		byte b1 = 100;
		byte b2 = 100;
		
		int result =(int) b1 + (int) b2; // 형태를 변환함 (casting)
		
		byte result2 = (byte) (b1 + b2);
		System.out.println(result2);
		
		for(int i=0; i < 100; i++) {
			System.out.println(++b1);
		}
		
//		long l1 = 100000000000L;
//		
//		// 실수형타입 => float(4바이트), double(8바이트)
//		
//		double d1 = 0.1;
//		double d2 = 0.2;
//		double result3 = d1 + d2;
//		result3 = 0.2345162;
//		System.out.println(Math.floor(result3 * 100 ) / 100);
//		
//		double[] doubleAry = {10, 23.4, 11.7, 34.5};
//		
//		double sum = doubleAry[0] + doubleAry[1] + doubleAry[2] + doubleAry[3];
//		
//		System.out.println(sum);
//	}
}
}