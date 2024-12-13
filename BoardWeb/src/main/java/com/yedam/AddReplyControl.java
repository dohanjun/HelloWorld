package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter(bon, replyer, reply)
		String bno = req.getParameter("bno");
		String replyer = req.getParameter("replyer");
		String reply = req.getParameter("reply");		
				

		ReplyVO rvo = new ReplyVO();
		
		ReplyVO rv = new ReplyVO();
		resp.setContentType("text/json;charset=utf-8");
		
		rv.setBoardNo(Integer.parseInt(bno));
		rv.setReply(replyer);
		rv.setReplyer(reply);
		ReplyDAO rdao = new ReplyDAO();
		
		Gson gson = new GsonBuilder().create();
		String json = "";
		Map<String,Object> resultMap = new HashMap<>();
		
		
		if (rdao.insertReply(rv)) {
			resultMap.put("retCode", "OK");
			resultMap.put("retVal", rv);
			
			
			json = gson.toJson(resultMap);
			resp.getWriter().print(json);
		}else {
			System.out.println("실패");
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}

	}
		
//		
	}


