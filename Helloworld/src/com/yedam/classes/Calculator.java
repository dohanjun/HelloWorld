package com.yedam.classes;

import com.yedam.student.Student;

public class Calculator {

	// 기본생성자. public calculator() {}
	// 반환값 + 메소드이름 + 매개변수(...)
	int sum(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}

	// 메소드가 중복적용된다는 것을 오버로딩이라 한다
	// 단 메소드의 매개값을 받는 타입은 달라야된다.
	double sum(double n1, double n2) {
		return n1 + n2;
	}

	double max(double n1, double n2) {
		if (n1 >= n2) {
			return n1;
		}
		return n2;
	}

	double max(int[] list) {
		int result = 0;
		for (int i = 0; i < list.length; i++) {
			if (result < list[i]) {
				result = list[i];
			}
		}
		return result;
	}

	void printStar(int times) {
		for (int i = 1; i <= times; i++) {
			System.out.println("★");
		}
		System.out.println();
	}

	int sumAry(int[] result) {
		int sum = 0;
		for (int i = 0; i < result.length; i++) {

			sum += result[i];
		}
		return sum;
	}

	double averageAry(int[] list) {
		return sumAry(list) * 1.0 / list.length;

	}
	
	// 매개값으로 Student[]를 활용해서 영어점수가 가장 높은 값을 변환.
	
		Student getMaxScore(Student[] stdAry) {
			int max = 0;
			Student result = null;
			for (int i = 0; i < stdAry.length; i++) {
				if(max < stdAry[i].englScore) {
					max = stdAry[i].englScore;
					result = stdAry[i];
				}
			}
			return result;
		}
	
	
	

}
