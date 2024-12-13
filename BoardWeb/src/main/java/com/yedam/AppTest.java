package com.yedam;

import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AppTest {

	public static void main(String[] args) {
		
		ReplyVO rv = new ReplyVO();
		rv.setBoardNo(2442);
		rv.setReply("댓글테스트1234");
		rv.setReplyer("user99");
		
		ReplyDAO rdao = new ReplyDAO();
		if (rdao.insertReply(rv)) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}

	}

}
