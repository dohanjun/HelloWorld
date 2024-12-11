package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	int startPage; // 현재페이지를 기준으로 현재페이지가 소속되어있는 첫번째 페이지 정보.
	int endPage; // 현재페이지를 기준으로 현재페이지가 소속되어있는 첫번째 페이지 정보.
	boolean prev, next; 
	int currentPage;
	
	public PageDTO(int page, int totalCnt) {
		this.currentPage = page; // 12페이지를 했을때
		this.endPage = (int) Math.ceil(page/10.0) * 10; //페이지르 12/10.0으로 소수점을 바꿔 올림을 해주는(MAth.ceil)을 써줌으로서 1.2의 올림을 해서 2로 만들어준 뒤 10을 곱하여  20페이지 가져옴
		this.startPage = this.endPage -9;
		
		
		
		// 실제 마지막페이지를 계산
		int realEnd = (int) Math.ceil(totalCnt / 10.0); // 87건을 10페이지로 나누면 => 9페이지가 나온다 (나머지 7건을 나타내기위해 마지막 페이지 추가)
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd ? true : false;
	}
	

}
