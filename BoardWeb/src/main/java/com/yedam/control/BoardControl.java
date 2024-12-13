package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
			
			//multipart요청.
			String savePath = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5;
			MultipartRequest mr = new MultipartRequest(
					            req  //필요한 매개값(req)은 요청정보이다
					            ,savePath // 저장경로
					            ,maxSize // 업로드가능한 최대사이즈
					            ,"utf-8" // 인코딩방식.
					            , new DefaultFileRenamePolicy()       //리네임정책(같은파일이 있으면 새로운 다른이름으로 저장시켜줌)
					);
			
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			String writer = mr.getParameter("writer");
			String img = mr.getFilesystemName("img");
			
			
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			board.setImg(img);
			if(bdao.insertBoard(board)) {
				
				resp.sendRedirect("boardList.do");//페이지 재지정
			}else {
				//등록화면으로 이동
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);
			}
		}
	}

}
