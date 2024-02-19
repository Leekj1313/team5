package it_community.dataBase.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.javassist.compiler.ast.Member;

import it_community.dataBase.model.vo.MemberVO;
import it_community.dataBase.service.MemberService;
import it_community.dataBase.service.MemberServiceImp;

public class MemberController {
	
	private static String me_id = null;
	private static Scanner scan;
	private static MemberService memberService;

	public MemberController(Scanner scan) {
	
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		
		memberService = new MemberServiceImp();
	}
	
	public static void run() {
		// 1. 커뮤니티 이용 시작 => 커뮤니티를 이용하기 위한 회원가입 
		int menu;
		do {
			printMemberMenu();//회원가입 메뉴 => 커뮤니티 메뉴로 변경할 지 생각 중
			menu = scan.nextInt();
			runMemberMenu(menu);
		}while(menu != 6);
	}
	
	private static void printMemberMenu() {
		// 회원의 가입 정보 조회는 통합으로 할 지 개인으로 할 지 생각 중 
		System.out.println("---------회원가입 메뉴---------");
		System.out.println("1. 회원 가입");
		System.out.println("2. 정보 수정");
		System.out.println("3. 회원 탈퇴");
		System.out.println("4. 정보 조회");
		System.out.println("5. 로그인");
		System.out.println("6. 이전 메뉴");
		System.out.println("----------------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runMemberMenu(int menu) {
		// TODO Auto-generated method stub
		switch(menu) {
		case 1:
				signUpMember();//회원가입
			break;
		case 2:
				updateMember();//회원수정
			break;
		case 3:
				deleteMember();//회원삭제
			break;
		case 4:
				printMember();//회원조회
			break;
		case 5:
				login();//로그인 
			break;
		case 6:
				System.out.println("이전 메뉴");
			break;
		default:
				System.out.println("잘못된 메뉴 입니다.");
		}
	}


	private static void signUpMember() {
		// 회원가입 시 필요정보 아이디. 패스워드, 이메일, 이름, 전화번호, 권한, 상태
		System.out.println("아이디 : ");
		String me_id = scan.next();
		
		System.out.println("패스워드 : ");
		String me_pw = scan.next();
		
		System.out.println("이메일 : ");
		String me_email = scan.next();
		
		System.out.println("이름 : ");
		String me_name = scan.next();
		
		System.out.println("전화번호(010-1234-4567) : ");
		String me_phone = scan.next();
		
		System.out.println("권한 : ");
		String me_access = scan.next();
		
		System.out.println("상태 : ");
		String me_active = scan.next();
		
		MemberVO member = new MemberVO(me_id, me_pw, me_email, me_name, me_phone, me_access, me_active);
		// 회원가입 정보를 맴버서비스 클래스에 넘겨주어 실행한다
		if(memberService.signUpMember(member)) {
			System.out.println("회원가입 완료!");
		}else {
			System.out.println("회원가입 실패!");
		}
	}
	
	private static void updateMember() {
		// 회원의 아이디를 입력하여 수정진행 
		System.out.println("---------회원정보 수정---------");
		System.out.println("아이디 입력 : ");
		// memberList 에서 회원의 정보를 불러와 수정작업 진행
		List<Member>memberList = memberService.getMemberListById(me_id);
		// 향상된 for문을 이용하여
		if(memberList == null || memberList.size() == 0) {
			System.out.println("수정할 회원의 정보가 없습니다.");
			return;
		}
		// 수정 가능한 회원의 정보를 출력
		for(Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("이전 아이디를 입력하세요. : ");
		scan.nextLine();
		String beforeMe_id = scan.nextLine();
		// 입력한 아이디가 틀렸을 경우
		if(!memberList.contains(new Member(me_id))) {
			System.out.println("잘못된 아이디 입니다.");
			return;}
		
		System.out.println("이후 아이디를 입력하세요. : ");
		String afterMe_id = scan.nextLine();
		
		System.out.println("이전 패스워드를 입력하세요. : ");
		scan.nextLine();
		String beforeMe_pw = scan.nextLine();
		
		System.out.println("이후 패스워드를 입력하세요. : ");
		String afterMe_pw = scan.nextLine();
		
		System.out.println("이전 이메일를 입력하세요. : ");
		scan.nextLine();
		String beforeMe_email = scan.nextLine();
		
		System.out.println("이후 이메일를 입력하세요. : ");
		String afterMe_email = scan.nextLine();
		
		System.out.println("이전 이름을 입력하세요. : ");
		scan.nextLine();
		String beforeMe_name = scan.nextLine();
		
		System.out.println("이후 이름을 입력하세요. : ");
		String afterMe_name = scan.nextLine();
		
		System.out.println("이전 전화번호를 입력하세요.(010-1234-4567) : ");
		scan.nextLine();
		String beforeMe_phone = scan.nextLine();
		
		System.out.println("이후 전화번호를 입력하세요.(010-1234-4567) : ");
		String afterMe_phone = scan.nextLine();
		
		
		
		/*
		if(memberList.updateMember(beforeMe_id, afterMe_id, beforeMe_pw, afterMe_pw, beforeMe_email, afterMe_email,
								   beforeMe_name, afterMe_name, beforeMe_phone, afterMe_phone)) {
			System.out.println("회원의 정보를 수정했습니다.");
		}else {
			System.out.println("회원 정보 수정에 실패하였습니다.");
		}*/
	}
		
	private static void deleteMember() {
		// TODO Auto-generated method stub
		
	}
	
	private static void printMember() {
	
	}
	
	private static void login() {
		// TODO Auto-generated method stub
		System.out.println("---------로그인 페이지---------");
		System.out.println("아이디 입력 : ");
		System.out.println("페스워드 입력 : ");
		System.out.println("----------------------------");
		// 로그인을 한 뒤에 메뉴 실행으로 넘어가야 한다 
	}

}
