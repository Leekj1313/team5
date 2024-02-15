package kr.kh.community.main;

import java.util.Scanner;

import kr.kh.community.controller.ItController;

public class Main {
	
	static ItController itController;
	
	public static void main(String [] args) {
		int menu;
		Scanner scan = new Scanner(System.in);
		itController = new ItController(scan);
		
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
			}while(menu != 2);
			}
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 게시글 관리");
		System.out.println("2. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			itController.run();
			break;
		case 2:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

}
