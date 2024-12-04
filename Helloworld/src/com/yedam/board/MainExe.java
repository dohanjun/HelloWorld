package com.yedam.board;

import java.util.Date;
import java.util.Scanner;

/*
 * 
 */
public class MainExe {
	
	
	static Scanner scn = new Scanner(System.in);
	static BoardExe bexe = new BoardExe();
	
	public static void main(String[] args) {
		boolean run = true;

		MemberExe mexe = new MemberExe(); // 인스턴스생성.

		while (run) {
			System.out.println("1.회원등록 2.목록 3.게시판 9.종료");
			System.out.println("선택>>>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: 
				System.out.println("회원아이디를 입력하세요.");
				String id = scn.nextLine();
				System.out.println("비밀번호를 입력하세요.");
				String pw = scn.nextLine();
				System.out.println("회원이름을 입력하세요.");
				String name = scn.nextLine();
				System.out.println("회원연락처를 입력하세요.");
				String phone = scn.nextLine();
				
				boolean result = MemberExe.addMember(new Member(id, pw, name, phone, new Date() ));
				if (result) {
					System.out.println("정상적으로 등록되었습니다.");
				} else {
					System.out.println("등록이 처리되지 않았습니다.");
				}
				break;

			
			case 2: 
				Member[] list = mexe.memberList();
				for(Member member : list) {
					if(member != null) {
						System.out.println(member.showInfo());
					}
				}
				break;
			
			case 3: 
				System.out.println("회원아이디를 입력하세요.");
				id = scn.nextLine();
				System.out.println("비밀번호를 입력하세요.");
				pw = scn.nextLine();
				if (mexe.login(id, pw)) {
					
					boardMethod(id); // 로그인한 사용자 아이디를 활용.
				}else {
					System.out.println("id와 pw를 확인하세요");
				}
				break;
			case 4:
				
				
			case 9: 
				run = false;
			
			default:
			}
		} // end of while.

		System.out.println("프로그램 시마이");
	}// end of main.
	
	//게시판관련
	public static void boardMethod(String id) {
		// 1.추가 2.목록 3.수정 4.삭제 9.상위메뉴이동
		boolean run = true;
		
		
		
		
		
		
		while (run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 9.상위메뉴이동");
			System.out.println("선택>>>");
			int menu = Integer.parseInt(scn.nextLine());
			
			
			
			switch (menu) {
			case 1:// 추가
//				System.out.println("글번호 입력");
				int bno = bexe.getNestNo();
				System.out.println("글제목 입력");
				String title =scn.nextLine();
				System.out.println("글내용 입력");
				String content = scn.nextLine();
//				System.out.println("작성자 입력");
				String writer = id;
//				System.out.println("작성일시 입력");
//				String wdate = scn.nextLine();
				Date ddd =new Date();
				
				
				
				
				Board board = new Board(bno, title, content, writer, ddd);
					if(bexe.insertBoard(board)) {
						System.out.println("게시글 등록 완료");
					}else {
						System.out.println("게시글 등록 실패");
					}
					break;
				
			case 2:
				Board[] list = bexe.boardList();
				for(Board brd : list) {
					if(brd != null) {
						
						System.out.println(brd.showInfo());
					}
				}
				break;
			case 3: // 수정(제목,내용) => bno, title, content : Board타입.
				System.out.println("번호를 입력하세요.");
				int change = Integer.parseInt(scn.nextLine());
				if(!bexe.checkResponsibilityBoard(change,id)) {
					System.out.println("해당글의 권한을 확인하세요");
					break;}
				System.out.println("제목을 입력하세요.");
				title = scn.nextLine();
				System.out.println("내용을 입력하세요.");
				content = scn.nextLine();
				if(bexe.updateBoard(change,title,content)) {
					System.out.println("수정이 완료되었습니다.");
				}else {
					System.out.println("수정이 취소되었습니다.");
				}break;
					
				
			case 4:
				System.out.println("번호를 입력하세요.");
				int delete  = Integer.parseInt(scn.nextLine());
				if(!bexe.checkResponsibilityBoard(delete,id)) {
					System.out.println("해당글의 권한을 확인하세요");
					break;
				}
			
				
				if(bexe.deleteBoard(delete)) {
					System.out.println("정상적으로 삭제되었습니다");
				}else {
					System.out.println("값을 다시입력하세요");
				}
					
				break;
			case 9:
				return;
			}
		}
	}
	
	
}// end of class
