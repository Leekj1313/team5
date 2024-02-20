package it_community.dataBase.controller;

import java.util.Scanner;

import it_community.dataBase.model.vo.CommunityVO;
import it_community.dataBase.service.CommunityService;
import it_community.dataBase.service.CommunityServiceImp;

public class CommunityController {

	private static Scanner scan;
	
	private static CommunityService communityService;
	// 멤버변수를 추가 => 서비스에서 작업을 진행시켜준다
	
	public CommunityController(Scanner scan) {
		
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		// 매게변수를 이용하여 scanner 의 남발을 막아준다, 객체를 초기화 시켜준다
		communityService = new CommunityServiceImp();
		//생성자에서 객체들을 추가해 준다
	}
	
	public static void run() {
		int menu;
		do {
			printCommunityMenu();
			menu = scan.nextInt();
			runCommunityMenu(menu);
		}while(menu != 5);
	}

	private static void printCommunityMenu() {
		System.out.println("-------커뮤니티 이용메뉴------");
		System.out.println("1. 회원가입을 시작합니다");
		System.out.println("2. 커뮤니티를 시작합니다");
		System.out.println("3. 댓글 관리를 시작합니다");
		System.out.println("4. 커뮤니티 관리를 시작합니다");
		//System.out.println("5. 관리자 메뉴 입니다");
		System.out.println("5. 이용을 끝냅니다");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private static void runCommunityMenu(int menu) {
		// TODO Auto-generated method stub
		switch(menu) {
		case 1: 
				memberController();
			break;
		case 2: 
				writePost();
			break;
		case 3: 
				CommentController();
			break;
		case 4: 
				ReportContlloer();
			break;
		/*	
		case 5: 
				회원의 관리, 게시글 관리, 신고의 결과를 입력
				 Result();
 			break;
		*/
		case 5: 
				System.out.println("이용을 종료합니다.");
			break;
			
		default:
			System.out.println("잘못된 메뉴 입니다.");
		}
	}
	
	private static void memberController() {
		// 회원 관련 기능 관리를 진행합니다 
		memberController();
		
	}

	private static void CommentController() {
		// TODO Auto-generated method stub
		CommentController();
		
	}
	
	private static void ReportContlloer() {
		// TODO Auto-generated method stub
		ReportContlloer();
	}
	
	private static void writePost() {
		int menu;
		do {
			printPostMenu();
			menu = scan.nextInt();
			runPostMenu(menu);
		}while(menu != 5);
	}
	
	private static void printPostMenu() {
		System.out.println("---------커뮤니티 메뉴---------");
		System.out.println("0. 게시판 관리");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 이전 메뉴");
		System.out.println("----------------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runPostMenu(int menu) {

		switch(menu) {
		case 1: 
				addPost();
			break;
		case 2: 
				setPost();
			break;
		case 3: 
				deletePost();
			break;
		case 4: 
				printPost();
			break;
		case 5: 
				System.out.println("이전 메뉴");
			break;
		default:
				System.out.println("잘못된 메뉴 입니다.");
		}
	}

	private static void addPost() {
		// 게시글 작성 시 필요항목 게시판 분류, 기기 분류, 아이디, 제목, 날짜, 내용 

		System.out.println("커뮤니티 선택 : "); 
		int po_ca_num = scan.nextInt();
		
		System.out.println("디바이스 선택 : ");
		int po_di_num = scan.nextInt();
		
		System.out.println("작성자 아이디 : ");
		String po_me_id = scan.next();
		
		System.out.println("제목 입력 : ");
		String po_title = scan.next();
		
		System.out.println("작성일 입력(yyyy-mm-dd) : ");
		String po_date = scan.next();
		
		scan.nextLine();//엔터처리
		System.out.println("내용 입력 : ");
		String po_content = scan.nextLine();
		
		CommunityVO post = new CommunityVO(po_ca_num, po_di_num, po_me_id, po_title, po_date, po_content);
		// 게시글 정보를 커뮤니티 클래스에 넘겨주어 실행한다 
		if(communityService.addPost(post)) {
			System.out.println("게시글 작성 완료!");
		}else {
			System.out.println("게시글 작성 실패!");
		}	
	}
	
	private static void setPost() {
		// TODO Auto-generated method stub
		System.out.println("제목을 입력하세요 : ");
		
	}

	private static void deletePost() {
		// TODO Auto-generated method stub
		
	}

	private static void printPost() {
		// TODO Auto-generated method stub
		
	}

		
}
	
