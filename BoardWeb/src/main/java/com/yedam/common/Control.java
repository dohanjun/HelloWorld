package com.yedam.common;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 인터페이스는 구현클래스를 통해 실제 기능이 정의.
 * 하는 역할은 규칙만 제시한다.
 */
public interface Control {
	// 메소드의 선언만 있는 메소드를 추상메소드라 한다.
	public void exec(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException;
}
