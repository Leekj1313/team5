package it_community.dataBase.main;

import java.util.Scanner;

import it_community.dataBase.controller.CommunityController;
import it_community.dataBase.controller.MemberController;

public class main {

	private static MemberController communityController;
	
	public static void main(String[] args) {
		
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		communityController = new MemberController(scan);
		
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 2);
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
				CommunityController.run();
				break;
		case 2: 
				System.out.println("이용을 종료합니다.");
				break;
		default:
				System.out.println("잘못된 메뉴 입니다.");
					
		}
		
	}
	private static void printMenu() {
		System.out.println("-------IT 정보 공유 커뮤니티-------");
		System.out.println("1. 커뮤니티 이용 시작");
		System.out.println("2. 커뮤니티 이용 종료");
		System.out.println("메뉴 선택 : ");
	
	}
}
