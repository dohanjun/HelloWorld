package com.yedam.classes;

import com.yedam.student.Student;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal1 = new Calculator(); // 인스턴스 생성.
		int sum = cal1.sum(10,20);
		
		System.out.println("합계: " + cal1.sum(10, 20));
		System.out.println("합계: " + cal1.sum(10.3, 21.7));
		System.out.println("큰값은 :" + cal1.max(10,  20.2));// max값은 단순비교만 할 수 있다.
		cal1.printStar(3);
		
		int[] intAry = {3, 6, 9, 12};
		sum = cal1.sumAry(intAry);
		System.out.println(sum);
		
		double result = cal1.averageAry(intAry);
		System.out.println("intAry의 평균: " + result);
		
		Student s1 = new Student("S001", "홍길동", 83, 78);
		Student s2 = new Student("S002", "김길동", 86, 58);
		Student s3 = new Student("S003", "최길동", 81, 92);
		
		Student[] stdAry = {s1, s2, s3};
		Student std = cal1.getMaxScore(stdAry);
		System.out.println("최고 영어점수는 " +std.englScore + ", 이름은" + std.studentName);
	}
	
}
