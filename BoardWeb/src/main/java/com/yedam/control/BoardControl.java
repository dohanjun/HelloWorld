package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control{
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// GET방식: 조회 POST방식: 등록.
		BoardDAO bdao = new BoardDAO();
		if (req.getMethod().equals("GET")) {
			// ㅠㅏ라미터(board_no) + page + searchCondition + keyword
		String boardNo = req.getParameter("board_no");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(boardNo));
		
		req.setAttribute("board", bvo);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
		req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);
		} else if(req.getMethod().equals("POST")) {
		
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			if(bdao.insertBoard(board)) {
				
				resp.sendRedirect("boardList.do");//페이지 재지정
			}else {
				//등록화면으로 이동
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);
			}
		}
	}

}
