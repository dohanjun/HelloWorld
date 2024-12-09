package com.yedam.jdbc.student;

import java.util.ArrayList;

public class TextExe {
	public static void main(String[] args) {
		//검색조건.
		Search search = new Search();
		search.setName("동");
		search.setPhone("22");
		search.setEngScore(60);
		search.setOrderBy("std_name");
		
		
		
		StudentDAO sdao = new StudentDAO();
		ArrayList<Student> list = sdao.studentList(search);
		for (Student std : list) {
			System.out.println(std.showInfo());
		}
	}
}
