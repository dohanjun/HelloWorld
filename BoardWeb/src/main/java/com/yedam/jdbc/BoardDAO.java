package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO{
	
	// 상세조회.
	public BoardVO selectBoard(int boardNo) {
		getConn();
		String sql = "select * from tbl_board where board_no = ? ";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO bVo = new BoardVO();

				
				bVo.setBoardNo(rs.getInt("board_no"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setViewCnt(rs.getInt("view_cnt"));
				bVo.setCreationDate(rs.getDate("creation_date"));
				bVo.setUpdateDate(rs.getDate("update_date"));

				return bVo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;

	}
	

	// BoardVO 파라미터 => 등록.
	public boolean insertBoard(BoardVO board) {
		getConn();
		String sql = "insert into tbl_board" + "(board_no, title, content, writer)"
				+ "values(board_seq.nextval, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	// 목록.
	public List<BoardVO> boardList(){
		getConn();
		String sql = "select * from tbl_board order by board_no";
		List<BoardVO> result = new ArrayList<>();
		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setCreationDate(rs.getDate("creation_date"));
				brd.setUpdateDate(rs.getDate("update_date"));
				
				result.add(brd);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
}
