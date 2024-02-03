package university.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import university.vo.Major;

public class ClassServiceImp implements ClassService {

	private final int CLS_EXIT = 4;
	
	private PrintService printService = new PrintServiceImp();
	private Scanner scan = new Scanner(System.in);

	@Override
	public void runClass() {
		/* 강의 관리를 담당하는 서비스 클래스
		 * 1. 전공 강의 신설 추가
		 * 신설 전공 이름 : 건축개론
		 * 전공 담당 교수 : 김무무
		 * 신설 전공 교실 : 209호
		 * 신청 가능 인수 : 30명
		 * 2. 전공 강의 신설 수정
		 * 신설 전공 이름 : 건축개론
		 * 전공 담당 교수 : 이무무
		 * 신설 전공 교실 : 202호
		 * 신청 가능 인수 : 25명
		 * 3. 전공 강의 신설 조회
		 * 신설된 전체전공 강의
		 *  
		 */
		int menu = 0;
		do {
			try {
					printMenu();
					menu = scan.nextInt();
					runMenu(menu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴 입니다.");
			scan.nextLine();
		}
			}while(menu != CLS_EXIT );
		}
	private void printMenu() {
		printService.printClassMenu();
	}
	private void runMenu(int menu) {
		switch(menu) {
		
		case 1: 
					addClasses();
					break;
		case 2: 
					//setClasses();
					break;
		case 3: 
					//printClasses();
					break;
		case 4: 
					System.out.println("이전으로 돌아갑니다.");
					break;
		default:
					throw new InputMismatchException();				
		}
		
	}
	private void addClasses() {
		System.out.println("-------------실행-------------");
		List<Class>classesList = new ArrayList<Class>();
			
		char isContinue = 'n';
		do {
				System.out.print("신설 전공 입력 : ");
				String className = scan.next();
				System.out.print("강의 담당 교수 :");
				String pfName = scan.next();
				System.out.print("전공 강의 교실 : ");
				String classRoom = scan.next();
				System.out.print("신청 가능 인수 : ");
				int maxClass = scan.nextInt();
				
				//classesList.add(new Classes(className, pfName, classRoom, maxClass));
				System.out.print("강의를 계속 추가하시겠습니까?(y/n): ");
				isContinue = scan.next().charAt(0);
				
		}while(isContinue == 'y');
		
		if(classesList == null || classesList.isEmpty()) {
			System.out.println("등록된 강의가 없습니다.");
		}else {
			System.out.println("중복된 강의입니다.");
		}
	}
	private boolean addClass(List<Class>classList) {
		return true;
	}
}

