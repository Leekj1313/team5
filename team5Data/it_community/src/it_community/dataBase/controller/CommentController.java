package it_community.dataBase.controller;

import java.util.Scanner;

import org.apache.ibatis.javassist.compiler.CodeGen;

import it_community.dataBase.model.vo.CommentVO;
import it_community.dataBase.service.CommentService;
import it_community.dataBase.service.CommentServiceImp;

public class CommentController {
	
	private static Scanner scan;
	
	private static CommentService commentService;
	
	public CommentController(Scanner scan) {
		
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		
		commentService = new CommentServiceImp();
	}
	
	public static void run() {
		int menu;
		do {
			printCommentMenu();
			menu = scan.nextInt();
			runCommentMenu(menu);
		}while(menu != 5);
	}

	private static void printCommentMenu() {
		// TODO Auto-generated method stub
		System.out.println("-----------댓글 메뉴-----------");
		System.out.println("1. 댓글 작성 ");
		System.out.println("2. 댓글 수정");
		System.out.println("3. 댓글 삭제");
		System.out.println("4. 댓글 조회");
		System.out.println("5. 이전 메뉴");
		System.out.println("----------------------------");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private static void runCommentMenu(int menu) {
		// TODO Auto-generated method stub
		switch(menu) {
		case 1:
				writeComment();
			break;
		case 2:
				updateComment();
			break;
		case 3:
				deleteComment();
			break;
		case 4:
				printComment();
			break;
		case 5:
				System.out.println("이전 메뉴");
			break;
		default :
				System.out.println("잘못된 메뉴 입니다.");
		}
		
	}

	private static void writeComment() {
		// 댓글 작성 
		System.out.println("게시글 번호 입력 : ");
		int co_po_num = scan.nextInt();
		
		System.out.println("작성자 입력 : ");
		String co_me_id = scan.next();
		
		System.out.println("내용 입력 : ");
		String co_content = scan.next();
		
		System.out.println("날짜 입력 : ");
		String co_date = scan.next();
		
		CommentVO comment = new CommentVO(co_po_num, co_me_id, co_content, co_date);
		
		if(commentService.writeComment(comment)) {
			System.out.println("댓글 작성 완료!");
		}else {
			System.out.println("댓글 작성 실패!");
		}
	}

	private static void updateComment() {
		// TODO Auto-generated method stub
		
	}

	private static void deleteComment() {
		// TODO Auto-generated method stub
		
	}

	private static void printComment() {
		// TODO Auto-generated method stub
		
	}
	
	
}
