package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.FullCalendarControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.chartDataContyol;
/*
 * url pattern에서 ~~~~???.do => FrontControl을 실행.
 * 
 */
public class FrontControl extends HttpServlet{
	Map<String,Control> map;
	
	
	
	public FrontControl() {
		map = new HashMap<>();
		
		
		
		
	}
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());//목록
		map.put("/board.do", new BoardControl());//상세
		// 게시글 등록화면.
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/board.do", new BoardControl());
		// 게시글 수정
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		//로그인화면
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		
		map.put("/replyList.do", new ReplyListControl()); // 댓글목록
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓글삭제
		map.put("/addReply.do", new AddReplyControl()); // 댓글등록
		map.put("/getCount.do", new GetReplyCountControl());
		
		//구글차트
		map.put("/chart.do", new ChartControl());
		map.put("/chartData.do", new chartDataContyol());
		
		//fullcalendat
		map.put("/full.do", new FullCalendarControl());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http://localhost:80/BoardWeb/hello.do        url= http:// 전체      uri= 호스트부분 뺴고 나머지부분
	String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path); // "hello.do" 공통부분을 제외한 나머지 부분.
		
		
		//요청 url과 실행할 컨트롤을 매칭시켜놓음
		Control control = map.get(path);
		control.exec(req, resp);
	}
	
}
