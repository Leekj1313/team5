package university.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import university.vo.Major;
import university.vo.Professor;

public class MajorServiceImp implements MajorService {

	private PrintService printService = new PrintServiceImp();
	private Major major = new Major();
	
	private Scanner scan = new Scanner(System.in);

	private final int STU_EXIT = 4;
	private final int SEARCH_EXIT = 3;
	/*과목 정보를 담당하는 서비스 클래스
	 * 1. 전공 과목 추가 
	 * 전공 코드 입력 : 101
	 * 전공 이름 입력 : 국어
	 * 담당 교수 교번 : 20150303
	 * 담당 교수 이름 : 김무무
	 * 2. 전공 과목 수정
	 * 수정 전공 코드 입력 : 102
	 * 수정 전공 이름 입력 : 과학
	 * 수정 담당 교수 교번 : 20150303 
	 * 수정 담당 교수 이름 : 김무무
	 * 3. 전공 과목 조회
	 * 4. 이전으로
	 */
	@Override
	public void runMajor() {
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
			}while(menu != STU_EXIT );
		}
	
	private void printMenu() {
		printService.printMajorMenu();
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
					addMajor();
					break;
		case 2:
					setMajor();
					break;
		case 3:
					searchMajor();
					break;
		case 4:
					System.out.println("이전으로");
					break;
		default:
					throw new InputMismatchException();
		}
	}
	private void searchMajor() {
		int menu;
		do {
				printService.searchMajor();
				menu = scan.nextInt();
				runPrintMenu(menu);
		}while(menu != SEARCH_EXIT);
	}
	private void runPrintMenu(int menu) {
		switch(menu) {
		case 1:
					searchAll();
					break;
		case 2: 
					searchPoint();
					break;
		case 3: 
					System.out.println("이전으로");
					break;
		default:
					throw new InputMismatchException();
		}
		
	}

	private void searchPoint() {
		
	}

	private void searchAll() {
		
	}
	//전공 정보 수정
	private void setMajor() {
		System.out.print("수정할 전공 정보(코드) : ");
		scan.nextLine();
		String beforeInfo = scan.nextLine();
		System.out.print("변경할 전공 정보 : ");
		String afterInfo = scan.nextLine();
		if(Major.MajorInfo) {
			System.out.println("전공 정보를 수정했습니다.");
		}else {
			System.out.println("전공 정보 수정에 실패했습니다.");
		}	
	}
	//전공 정보 추가
	private void addMajor() {
		System.out.println("-------------실행-------------");
		List<Major>majorList = new ArrayList<Major>();
		
		char isContinue = 'n';
		do {
				System.out.print("전공 코드 입력 : ");
				int majorCode = scan.nextInt();
				System.out.print("전공 이름 입력 : ");
				String majorName = scan.next();
				System.out.print("담당 교수 교번 : ");
				int pfNum = scan.nextInt();
				System.out.print("담당 교수 이름 : ");
				String pfName = scan.next();
				
				//majorList.add(new Major(majorCode, majorName, pfNum, pfName));
				System.out.print("전공 정보를 계속 추가하시겠습니까?(y/n): ");
				isContinue = scan.next().charAt(0);
				
		}while(isContinue == 'y');
		
		if(majorList == null || majorList.isEmpty()) {
			System.out.println("등록된 전공 정보가 없습니다.");
		}else {
			System.out.println("중복된 전공 정보입니다.");
		}
	}
	private boolean addMajor(List<Major>majorList) {
		return true;
	}
}
