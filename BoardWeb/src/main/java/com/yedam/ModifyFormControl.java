package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시글 번호 한건에 대한 조회결과 html/modifyForm.jsp출력.----------------------
		// 수정항복은 제목, 내용으로 제한.
		String bno = req.getParameter("board_no");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardDAO bdao = new BoardDAO();
		BoardVO borad = bdao.selectBoard(Integer.parseInt(bno));

		req.setAttribute("board", borad);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
//		System.out.println(list);
		req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);

	}

}
