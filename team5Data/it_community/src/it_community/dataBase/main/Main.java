package it_community.dataBase.main;

import java.util.Scanner;

import it_community.dataBase.controller.CommunityController;
import it_community.dataBase.controller.MemberController;

public class Main {

	private static CommunityController communityController;
	
	private static MemberController memberController;
	
	public static void main(String[] args) {
		
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		communityController = new CommunityController(scan); //scanner를 입력 받아서 실행
															 //로그인도 같은 방식으로 이용할 수 있을까
		memberController = new MemberController(scan);
		
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 2);
	}

	private static void printMenu() {
		System.out.println("-------IT기기 정보 공유 커뮤니티-------");
		System.out.println("1. 커뮤니티 이용 시작");
		System.out.println("2. 커뮤니티 이용 종료");
		System.out.println("메뉴 선택 : ");
		
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :// 전체적인 게시판의 기능들을 실행 관리 및 실행한다 
				CommunityController.run();
				break;
		case 2: 
				System.out.println("이용을 종료합니다.");
				break;
		default:
				System.out.println("잘못된 메뉴 입니다.");
					
		}
		
	}
}
