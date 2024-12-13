package com.yedam.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * Vo : value Object
 * Lombok 사용 : 1. Lombok 다운로드 설치
 * 			    2. Lombok 라이브러리 다운로드
 * 				3. eclipse 재실행
 * 				4. 어노테이션.
 */
@Getter
@Setter
@ToString

//@Data
public class BoardVO {
	private int boardNo, viewCnt;
	private String title, content, writer, img;
	private Date creationDate, updateDate;
	
	
	
}
