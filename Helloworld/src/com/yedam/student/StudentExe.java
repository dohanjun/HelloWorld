package com.yedam.student;

public class StudentExe {

	public static void main(String[] args) {
		Student s1 = new Student("001");
		System.out.println(s1.studentNumber+ ", " + s1.studentName);
		
		
		Student s2 = new Student("002", "최길동");
		System.out.println(s2.studentNumber+ ", " + s2.studentName);
		
		
		
		Student s3 = new Student("003", "김길동", 40, 95);
		System.out.println(s3.studentNumber+ ", " + s3.studentName+ ", " +s3.englScore+ ", " + s3.mathScore);
		System.out.println(s3.sumScore()+", " + s3.averageScore());
		
		int num = 10;
		
		
	}

}
