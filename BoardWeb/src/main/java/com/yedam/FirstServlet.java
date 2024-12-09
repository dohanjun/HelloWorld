package com.yedam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/First")  // http://localhost/BoardWeb/first
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 요청");
		// TODO Auto-generated method stub
		// 컨텐트타입에 대한 지정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();// 출력스트림(자바에서는 데이터의 이동 스트림(데이터의 흐름))
		String boardNo = request.getParameter("board_no");
		// BoardDAO
		BoardDAO bdao = new BoardDAO();
		BoardVO board = null;
		try {
			board = bdao.selectBoard(Integer.parseInt(boardNo));
		}catch(Exception e) {
			out.print("게시글번호를 입력하세요");
			return;
		}
		out.print("<h3>상세페이지</h3>");
		
		
		if(board == null) {
			out.print("<p>조회된 값이 없습니다.</p>");
		}else {
		
		String html = "<table border='1'>";
		html += "         <tr>";
		html += "         <th>글번호</th><td>" + board.getBoardNo() + "</td>";
		html += "         <th>wpahr</th><td>" + board.getTitle() + "</td>";
		html += "         </tr>";
		html += "         <tr>";
		html += "         <th>글내용</th><td colspan='3'>" +  board.getContent() + "</td>";
		html += "         </tr>";
		html += "         </table>";
		out.print(html);
		}
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost 요청");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();// 출력스트림(자바에서는 데이터의 이동 스트림(데이터의 흐름))
//		out.print("Hello,World");
//		out.print("<h3>안녕하세요</h3>");
//		
//		out.print("<a href='index.html'>인덱스페이지</a>");
//		out.print("<a href='html/intro.html'>인트로 페이지</a>");
		
		
		//first?title=테스트&content=테스트내용&writer=도한준
		//http://localhost/BoardWeb/First?title=test1&content=test2&writer=test3
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardDAO bdao = new BoardDAO();
//		if(bdao.insertBoard(board)) {
//			out.print("<p>등록됨</p>");
//			out.print("<a href='second'>목록이동</a>");
//		}else {
//			out.print("<p>등록안됨</p>");
//		}
	}

}
