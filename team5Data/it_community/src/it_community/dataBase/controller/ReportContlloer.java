package it_community.dataBase.controller;

import java.util.Scanner;

import it_community.dataBase.model.vo.ReportVO;
import it_community.dataBase.service.ReportService;
import it_community.dataBase.service.ReportServiceImp;

public class ReportContlloer {

	private static Scanner scan;
	
	public static ReportService reportService;
	
	public ReportContlloer(Scanner scan) {
		
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		
		reportService = new ReportServiceImp();
	}
	
	public static void run() {
		int menu;
		do {
			printReportMenu();
			menu = scan.nextInt();
			runReportMenu(menu);
		}while(menu != 5);
	}
	
	private static void printReportMenu() {
		// TODO Auto-generated method stub
		System.out.println("-----------신고 메뉴-----------");
		System.out.println("1. 신고 작성 ");
		System.out.println("2. 신고 수정");
		System.out.println("3. 신고 철회");
		System.out.println("4. 신고 조회");
		System.out.println("5. 이전 메뉴");
		System.out.println("----------------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runReportMenu(int menu) {
		// 신고 작성
		switch (menu) {
		case 1: 
				writeReport();
			break;
		case 2: 
				updateReport();
			break;
		case 3: 
				deletReport();
			break;
		case 4: 
				printReport();
			break;
		case 5: 
				System.out.println("이전 메뉴");
			break;
		default:
			System.out.println("잘못된 메뉴 입니다.");
		}
	}

	private static void writeReport() {
		// TODO Auto-generated method stub
		System.out.println("신고 아이디 : ");
		String rep_me_id = scan.next();
		
		System.out.println("신고 유형(게시글/댓글) : ");
		String rep_rt_type = scan.next();
		
		System.out.println("신고 내용 : ");
		String rep_content = scan.next();
		
		ReportVO report = new ReportVO(rep_me_id, rep_rt_type, rep_content);
		
		if(reportService.writeReport(report)) {
			System.out.println("신고 작성 완료!");
		}else {
			System.out.println("신고 작성 실패!");
		}
	}

	private static void updateReport() {
		// TODO Auto-generated method stub
		
	}

	private static void deletReport() {
		// TODO Auto-generated method stub
		
	}

	private static void printReport() {
		// TODO Auto-generated method stub
		
	}
}
