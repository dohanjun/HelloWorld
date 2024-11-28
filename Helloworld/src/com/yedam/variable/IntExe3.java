package com.yedam.variable;

public class IntExe3 {
	public static void main(String[] args) {
		boolean b1 = true;
		b1 = 10 > 20;
		
		char c1 = 0; // ascii 코드값을 숫자 각각에다 매핑해놓음
		c1 = 65;
		for(int i =1;i<=26;i++) {
		System.out.println(c1++);
		
		}
		char c2 = '뷃'; // "Hello" 비교.
		System.out.println((int) c2);
		
		int n1 = 1;
		int n2 = 2;
		double result4 = n1 * 1.0 / n2; //n1이 int타입이었는데 double타입으로 자동형변환 (promotion). 0.5인데 처리된 값은 0
		System.out.println(result4);
		// 가장 작은값부터 나열하면 byte < short < int < long < float < double
	}	
}
