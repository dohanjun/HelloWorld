package com.yedam;

import java.io.IOException;
import java.util.List;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시글 번호 한건에 대한 조회결과 html/modifyForm.jsp출력.----------------------
		// 수정항복은 제목, 내용으로 제한.
		String bno = req.getParameter("board_no");

		BoardDAO bdao = new BoardDAO();
		BoardVO borad = bdao.selectBoard(Integer.parseInt(bno));

		req.setAttribute("board", borad);
//		System.out.println(list);
		req.getRequestDispatcher("html/modifyForm.jsp").forward(req, resp);

	}

}
