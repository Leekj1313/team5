package kr.kh.community.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import kr.kh.community.model.vo.Category;
import kr.kh.community.model.vo.Post;
import kr.kh.community.model.vo.Type;
import kr.kh.community.service.ItService;
import kr.kh.community.service.ItServiceImp;

public class ItController {
	
	private Scanner scan;
	private ItService itService;
	
	public ItController(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		itService = new ItServiceImp();
	}

	public void run() {
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
			}while(menu != 5);
	}

	private void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 게시글 입력");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 이전");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			//update();
			break;
		case 3:
			//delete();
			break;
		case 4:
			view();
			break;
		case 5:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}


	private Post inputPost() throws ParseException{
		// 게시글 종류 선택
		List<Type> typeList = itService.getTypeList();
		
		for(int i=0; i<typeList.size();i++) {
			System.out.println(typeList.get(i).getTy_name());
			if(i != typeList.size() -1 ) {
				System.out.println("/");
			}
		}
		System.out.println("중 하나를 입력하세요.");
		int type = scan.nextInt();
		
		
		//카테고리 선택
		List<Category> categoryList = itService.getCategoryList(type);
		for(Category category : categoryList) {
			System.out.println(category);
		}
		//대분류 1:공지게시판, 2:자유게시판, 3:정보게시판
		System.out.print("대분류를 선택하세요 : ");
		int categoryNum = scan.nextInt();
		//중분류 1:스마트폰, 2: 태블릿, 3. 카메라, 4:PC, 5:기타
		System.out.print("중분류를 선택하세요 : ");
		int diviceNum = scan.nextInt();
		//날짜
		System.out.print("날짜를 입력하세요 : ");
		String date = scan.next();
		
		//회원 아이디
		System.out.print("회원 아이디를 입력하세요 : ");
		String id = scan.next();
		//게시글 제목
		System.out.print("게시글 제목을 입력하세요 : ");
		String title = scan.next();
		//게시글 내용
		System.out.print("내용을 입력하세요 : ");
		String content = scan.nextLine();
		
		return new Post(categoryNum, diviceNum, date, id, title, content);
	
		}
	//추가메서드
	private void insert() {
		try {
			Post post = inputPost();
			System.out.println(post);
			if(itService.insertPost(post)) {
				System.out.println("내역을 추가했습니다.");
			}else {
				System.out.println("내역을 추가하지 못했습니다.");
			}
			
			
		}catch(ParseException e) {
			System.out.println("날짜 형식이 잘못됐습니다.");
		}
		
	}

	//조회메서드
	private void view() {
		System.out.print("날짜를 입력하세요.(yyyy-MM-dd 또는 yyyy-MM 또는 yyyy) : ");
		String date = scan.next();
		List<Post> postList = itService.getPostListByDate(date);

		if(postList == null || postList.size() == 0) {
			System.out.println("조회할 내역이 없습니다.");
			return;
		}
		for(Post tmp : postList) {
			System.out.println(tmp);
		}
	}
	/*
	//삭제메서드
	private void delete() {
		System.out.print("날짜를 입력하세요.(yyyy-MM-dd) : ");
		String date = scan.next();
		List<Board> itemList = itService.getItemListByDate(date);
		
		if(boardList == null || itemList.size() == 0) {
			System.out.println("삭제할 내역이 없습니다.");
			return;
		}
		//삭제할 내역이 있으면 삭제 가능한 내역을 출력
		for(Item item : itemList) {
			System.out.println(item);
		}
		System.out.print("내역 번호를 선택하세요 : ");
		int it_num = scan.nextInt();
		//입력한 내역 번호가 잘못된 값인지 확인
		if(!itemList.contains(new Item(it_num))) {
			System.out.println("잘못된 내역 번호입니다.");
			return;
		}
		if(accountService.deleteItem(it_num)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
	}
	//수정메서드
	private void update() {
		System.out.print("날짜를 입력하세요.(yyyy-MM-dd) : ");
		String date = scan.next();
		List<Board> boardList = itService.getItemListByDate(date);
		
		if(boardList == null || boardList.size() == 0) {
			System.out.println("수정할 내역이 없습니다.");
			return;
		}
		//수정할 내역이 있으면 수정 가능한 내역을 출력
		for(Board board : boardList) {
			System.out.println(board);
		}
		System.out.print("내역 번호를 선택하세요 : ");
		int it_num = scan.nextInt();
		//입력한 내역 번호가 잘못된 값인지 확인
		if(!boardList.contains(new Board(bo_num))) {
			System.out.println("잘못된 내역 번호입니다.");
			return;
		}
		try {
			Board board = inputBoard();
			board.setIt_num(bo_num);
			if(itService.updateItem(board)) {
				System.out.println("내역 수정이 완료되었습니다.");
			}else {
				System.out.println("내역을 수정하지 못했습니다.");
			}
		} catch (ParseException e) {
			System.out.println("날짜를 잘못 입력하여 내역을 수정하지 못했습니다.");
			return;
		}
	}

	private Board inputItem() throws ParseException {
		//카테고리 입력
		List<Type> typeList = accountService.getTypeList();
		
		for(int i = 0; i < typeList.size(); i++) {
			System.out.print(typeList.get(i).getTy_name());
			if(i != typeList.size() - 1) {
				System.out.print("/");
			}
		}
		System.out.print(" 중 하나를 입력 하세요:");
		String type = scan.next();
		
		//카테고리 선택
		List<Category> categoryList = accountService.getCategoryList(type);
		for(Category category : categoryList) {
			System.out.println(category);
		}
		System.out.print("분류를 선택하세요 : ");
		int categoryNum = scan.nextInt();
		//날짜
		System.out.print("날짜를 입력하세요(yyyy-MM-dd) : ");
		String date = scan.next();
		
		//금액
		System.out.print("금액을 입력하세요 : ");
		int money = scan.nextInt();

		//내용
		scan.nextLine();
		System.out.print("내용을 입력하세요 : ");
		String content = scan.nextLine();
		
		return new Item(categoryNum, date, money, content, type);
	}

	}
}*/
}
