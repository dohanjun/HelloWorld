package com.yedam.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * hashCode() 메소드의 오버라이딩.
 */
public class SetExe {
	public static void main(String[] args) {
		
		//Map 컬랙션. 키와 값이 쌍으로 저장.
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김길동");
		map.put(300, "고길동");
		map.put(400, "박길동");
		
		String result = map.get(100); // 키값을 넣어주면 키와 동일한 값을 반환해줌.
		System.out.println(result);
		
		
		Set<Integer> kset = map.keySet(); // 키에해당되는 set컬랙션을 반환함.
		for(Integer key : kset) {
			System.out.printf("key %d, value: %s\n", key, map.get(key));
		}
		
		
		
		System.out.println("end of prog.");
	}
	public void Set() {
		
		//set => 중복된 값은 저장하지 않음.
		
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student(1001, "홍길동", 90));
		students.add(new Student(1002, "김길동", 70));
		students.add(new Student(1003, "고길동", 60));
		students.add(new Student(1004, "박길동", 50));
		students.add(new Student(1001, "홍길동", 90));
		
		for(Student std : students) {
			System.out.println(std);
		}
		
		
		
		
		HashSet<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		set.add("Hello");
		
		//HashSet은 중복된값을 저장하지 않는다.
		
		for (String str : set) {
			System.out.println(str);
		}
		
	}
	
	public void student() {
		//Student 객체.
				ArrayList<Student> student = new ArrayList<Student>();
				
				student.add(new Student(1001, "홍길동", 90));
				student.add(new Student(1002, "김길동", 70));
				student.add(new Student(1003, "고길동", 60));
				student.add(new Student(1004, "박길동", 50));
				student.add(new Student(1001, "홍길동", 90));
				
				for(Student std : student) {
					if(std.getScore() > 50) {
						
						System.out.println(std);
					}
				}
				
				
				ArrayList<String>strList = new ArrayList<String>();
				strList.add("Hello");
				strList.add("World");
				strList.add(0, "Nice");
				
				
				strList.remove(1);
				
				
				//조회
				for (int i = 0; i < strList.size(); i++) {
					System.out.println(strList.get(i));
				}

	}
	public void list() {
		//collection -> List(인덱스를 활용해서 값을 저장), Set(집합), Map(키, 값)
		
				ArrayList<String> list = new ArrayList<String>();
				list.add("apple"); // [0]
				list.add("orange"); //[1]
//				list.add(10); // [2]
				String v1 = list.get(0); // Object = String
//				int v2 = (Integer) list.get(2);
				
				for (int i = 0; i < list.size(); i++) {
					String result = list.get(i);
				}
	}
}
