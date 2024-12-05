package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcExe2 {
	public static void main(String[] args) {
		Employee emp = new Employee();
		
		emp.setLastName("do");
		emp.setFirstName("hanjun");
		emp.setEmail("do@email");
		emp.setPhoneNumber("010.1234-5678");
		emp.setHireDate("2024-03-03");
		emp.setJobId("IT_PROG");
		emp.setSalary(42000);
		insert(emp);
//		update(211, "do","010.1234.4321", 3200 );
//		delete(211);
		select();
		System.out.println("end of prog.");

//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이브 로드.
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			// sql을 작성하고 가져오는 객체 statement
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from employees order by employee_id desc");
//
//			while (rs.next()) {
//				System.out.println(
//						rs.getInt("employee_id") + "," + rs.getString("first_name") + "," + rs.getString("email"));
//			}
//			conn.close();
//			System.out.println("==end of prog.==");
//		} catch (Exception e) {
//			// 예외발생시 실행할 명령.
//			System.out.println("드라이버 로드 중 에러가 발생.");
//		}
//		System.out.println("end of prog.");
	}

	// 조회하는 기능

	public static Connection getConn() {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			// 예외발생시 실행할 명령.
			System.out.println("드라이버 로드 중 에러가 발생.");
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	//수정기능.
	public static void update(int empId, String fname, String pno, int sal) {
		Connection conn = getConn();
		String query = "update employees "
				+ "        set first_name = '"+fname+"'"
				+ "           , phone_number = '"+pno+"'"
				+ "           , salary = "+sal+""
				+ "      where employee_id = "+empId+"";
		try {
			Statement stmt =conn.createStatement();
			                                           // 테이블에 반드시 들어가야되는 필수 칼럼
			int r = stmt.executeUpdate(query); // 데이터가 변경되는 것만 executeUpdate를 쓴다
			System.out.println(r + "건 처리됨.");
			conn.close();
		} catch (Exception e) {
			

			e.printStackTrace();
		}
	}
	
	//삭제기능.
	public static void delete(int empId) {
		Connection conn = getConn();
		String query = "delete employees where employee_id = "+empId+"";
		try {
			Statement stmt =conn.createStatement();
			                                           // 테이블에 반드시 들어가야되는 필수 칼럼
			int r = stmt.executeUpdate(query); // 데이터가 변경되는 것만 executeUpdate를 쓴다
			System.out.println(r + "건 처리됨.");
			conn.close();
		} catch (Exception e) {
			

			e.printStackTrace();
		}
	}
	
	//입력기능.
	public static void insert(Employee emp) {
		Connection conn = getConn();
		String query = "insert into employees (employee_id, last_name,first_name, email,phone_number, hire_date, job_id, salary)"
				+ "values(employees_seq.nextval,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1,emp.getLastName());
			stmt.setString(2,emp.getFirstName());
			stmt.setString(3,emp.getEmail());
			stmt.setString(4,emp.getPhoneNumber());
			stmt.setString(5,emp.getHireDate());
			stmt.setString(6,emp.getJobId());// 테이블에 반드시 들어가야되는 필수 칼럼
			stmt.setInt(7,emp.getSalary());
			int r = stmt.executeUpdate();
			System.out.println(r + "건 처리됨.");
			conn.close();
		} catch (SQLException e) {
			// 예외발생시 실행할 명령.

			e.printStackTrace();
		}
	}
	

	public static void select() {
		Connection conn = getConn();

		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees where employee_id > 200 order by employee_id desc");

			while (rs.next()) {
				System.out.println(
						rs.getInt("employee_id") + "," 
				+ rs.getString("last_name") + "," 
				+ rs.getString("first_name") + "," 
				+ rs.getString("email") + "," 
				+ rs.getString("phone_number") + "," 
				+ rs.getString("hire_date") + "," 
				+ rs.getString("job_id") + "," 
				+ rs.getInt("salary"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
