package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		map.put("/modifyboard.do", new ModifyBoardControl());
		//로그인화면
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		//로그아웃
		map.put("/logout.do", new LogoutControl());
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
