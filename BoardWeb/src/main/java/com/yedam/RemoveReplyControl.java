package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 댓글번호 삭제
		String rno = req.getParameter("rno");
		
		ReplyDAO rdao = new ReplyDAO();
		if (rdao.deleteReply(Integer.parseInt(rno))) {
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}

	}

}