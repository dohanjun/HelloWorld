package com.yedam.board;

import java.util.Date;

/*
 * 1. 등록 2. 목록
 */
public class BoardExe {
	private Board[] storage; // 필드.

	public BoardExe() { // 초기화.
		storage = new Board[10];
		storage[0] = new Board(1, "자바는 재밌어", "열심히 합시다", "user01", new Date());
		storage[1] = new Board(2, "오늘은 화요일", "3일이나 남았네", "user02", new Date());
		storage[2] = new Board(3, "프로그래밍", "재미있네", "user03", new Date());
	}

	// 게시글 등록.
	public boolean insertBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = board;
				return true;
			}
		}
		return false;
	}

	// 목록.
	public Board[] boardList() {
		for (int j = 0; j < storage.length - 1; j++) {
			for (int i = 0; i < storage.length - 1; i++) {
				if (storage[i + 1] == null) {
					continue;
				}
				if (storage[i] == null || storage[i].getBoardNo() > storage[i + 1].getBoardNo()) {
					Board temp = null;
					temp = storage[i];
					storage[i] = storage[i + 1];
					storage[i + 1] = temp;
				}
			}

		}
		return storage;

	}

	public int getNestNo() {
		int cnt = 0;
//		Board result = null;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				int boardNo = storage[i].getBoardNo();
				if (cnt < boardNo) {

					cnt = boardNo;
				}
			}
		}
		return cnt + 1;
	}

	// 글 번호 가져오는 메소드.
	// null이 아닌 카운트에 +1 한 값을 반환.

	// 글삭제기능 => 매개값은 글번호, 반환값은 true/ false,deleteBoard

	public boolean deleteBoard(int delete) {

		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == delete) {

				storage[i] = null;
				return true;
			}
		}
		return false;
	}

	// 글 수정 기능 => 매개값은 글번호+내용+제목 , 반환값은 true/false, updateBoard()

	public boolean updateBoard(int change, String title, String content) {

		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == change) {
				storage[i].setTitle(title);
				storage[i].setContent(content);
				return true;
			}
		}
		return false;
	}

// 삭제,수정 권한이 있는지 체크 => 매개값은 글 번호, 작성자 , 반환값은 true/ false
// checkReponsibility()

	public boolean checkResponsibilityBoard(int Board, String writer) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				if (storage[i].getBoardNo() == Board && storage[i].getWriter().equals(writer)) {
					storage[i] = null;
					return true;
				}
			}
		}
		return false;
	}

}
