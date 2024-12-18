package com.yedam.jdbc.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * DAO : Data Access Object.
 * 입력, 수정, 삭제, 조회(목록, 단건)
 */
public class StudentDAO extends DAO {

	
	//login() => 반환:boolean, 매개값: id, password
	public boolean login(String asid, String pw) {
		getConn();
		String sql = "select * from tbl_member where member_id = ? and password = ?";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1,asid);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;

	}
	
	public boolean deleteStudent(Student dstd) {
		getConn();
		String sql = "delete tbl_student \r\n"
				+ "where std_no like '%001%';";
		try {
			psmt = conn.prepareStatement(sql);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}return false;
	}
	
	// 등록. 반환:boolean, 매개:Student, 메소드: updateStudent
	public boolean updateStudent (Student std) {
		getConn();
		String sql = "update tbl_student\r\n"
				+ "set eng_score = ? "
				+ "    ,math_score = ? "
				+ "where std_no =  ? ";
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, std.getEngScore());
			psmt.setInt(2, std.getMathScore());
			psmt.setString(3, std.getStdNo());
			
			int r = psmt.executeUpdate();


			if(r>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}return false;
		}

	public Student selectStudent(String stdNo) {
		getConn();
		String sql = "select * from tbl_studen where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student std = new Student();
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				std.setStdPhone(rs.getString("std_Phone"));
				std.setEngScore(rs.getInt("eng_score"));
				std.setMathScore(rs.getInt("math_score"));
			
			return std;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return null;
	}
	
	
	
	// 등록. 반환:boolean, 매개:Student, 메소드: insertStudent
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student (std_no, std_name, std_phone )" + "Values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getStdPhone());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	// 학생목록.
	public ArrayList<Student> studentList(Search search) {
		getConn();
		// 조회결과를 반환
		ArrayList<Student> studList = new ArrayList<Student>();

		String sql = "select std_no,"
				+ " std_name,"
				+ " eng_score,"
				+ " math_score,"
				+ " std_phone,"
//				+ " to_char(creation_date, 'yyyy-mm-dd hh24:mi:ss') creation_date"//
				+ " creation_date"
				+ "   from tbl_student "
				+ "   where std_name like '%'||?||'%' and std_phone like '%'||?||'%'"
				+ "   and eng_score >= ? ";//
//				+ "   order by = ? ";
		if(search.getOrderBy().equals("std_no")) {
			sql += "order by std_no";
		}else if (search.getOrderBy().equals("std_name")) {
			sql += " order by std_name";
		}
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, search.getName());
			psmt.setString(2, search.getPhone());
			psmt.setInt(3, search.getEngScore());
			rs = psmt.executeQuery();

			while (rs.next()) {
				Student stud = new Student();
				stud.setStdNo(rs.getString("std_no"));
				stud.setStdName(rs.getString("std_name"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setMathScore(rs.getInt("math_score"));
				stud.setStdPhone(rs.getString("std_phone"));
				stud.setCreationDate(rs.getDate("creation_date"));
				studList.add(stud);

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			disConnect();
		}
		return studList;
	}
}