package com.yedam.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * db connect, db close.
 * DAP 상속.
 */
public class DAO {
	// 뭐리실행을 위한 필드 선언.
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;

	// 연결해제.


	public Connection getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj");
		} catch (Exception e) {
			// 예외발생시 실행할 명령.
			System.out.println("드라이버 로드 중 에러가 발생.");
			e.printStackTrace();
		}
		return conn;
	}

	public void disConnect() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();

			}
			if (rs != null) {

				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
