package university.service;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Flow.Processor;
import university.vo.Professor;
import university.vo.Score;

public class ProfessorServiceImp implements ProfessorService {

	private PrintService printService = new PrintServiceImp();
	private MajorService majorService = new MajorServiceImp();
	
	private List<Professor> professorList = new ArrayList<>();
	
	private Scanner scan = new Scanner(System.in);
	
	private final int PFS_EXIT = 6;	
	/* 교수 기능을 담당하는 서비스 클래스
	 * 1. 교수정보 추가
	 * 교수이름 추가/ 이름	 	: 김무무
	 * 교수교번 추가/ 교번		: 20150302
	 * 교수전공 추가/ 전공 	: (101 : 수학)
	 * 2. 교수정보 수정
	 * 수정할 교수 교번 선택
	 * 교수이름 추가/ 이름	 	: 이무무
	 * 교수교번 추가/ 교번		: 20150305
	 * 교수전공 추가/ 전공 	: (103 : 과학)
	 * 3. 학생 점수 입력
	 * 강의 정보를 강의 서비스 클래스에서 불러오기
	 * 강의 선택 : 103 : 과학
	 * 학생 정보를 학셍 서비스 클래스에서 불러오기
	 * 학생 선택 : 20200030
	 * 강의 점수 추가
	 * 강의 학점 추가
	 * 시험 패스 or 재수강
	 * 4. 학생 점수 수정
	 * 강의 선택
	 * 수정할 학생 선택 : 20200030
	 * 수정할 점수 입력
	 * 수정할 학점 입력
	 * 수정할 시험 패스 or 재수강
	 * 5. 강의 조회
	 * 강의 선택 : 103 : 과학
	 * 수강 학생 : 과목 서비스에서 불러오기
	 * 전체 수강 학생 점수 출력
	 * 전체 수강 학생 점수 평균 출력
	 * 전체 수강 학생 학점 평균 출력
	 * 6. 이전메뉴로 돌아가기
	 * 	- 
	 */
	@Override
	public void runProfessor() {
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
			}while(menu != PFS_EXIT );
		}
	
	private void printMenu() {
		printService.printProfessorMenu();
	}
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			 		addProfessor();
					break;
		case 2: 
					setProfessor();
					break;
		case 3: 
					studentScore();
					break;
		case 4:
					setStudentScore();
					break;
		case 5: 
					searchClass();
		case 6:
					System.out.println("이전으로");
					break;
		default:
					throw new InputMismatchException();
		}
	}
	private void searchClass() {
		// 수강학생 정보 조회 출력 = 학생의 총점과 학점 
		
	}
	private void setStudentScore() {
		Score.setMarkingStudent();
	}
	private void studentScore() {
		Score.markingStudent();	
	}
	//교수 정보 수정
	private void setProfessor() {
		System.out.print("수정할 교수 정보: ");
		scan.nextLine();
		String beforeInfo = scan.nextLine();
		
		System.out.println("-------------수정-------------");
		
		System.out.print("수정 교수 이름 : ");
		String afterName = scan.nextLine();
		System.out.print("수정 교수 교번 : ");
		int afterNum = scan.nextInt();
		System.out.print("수정 전공 입력 : ");
		String major = scan.next();
		System.out.print("수정 전공 코드 : ");
		int majorCode = scan.nextInt();
		
		System.out.print("수정한 교수 정보: ");
		String afterInfo = scan.nextLine();
		
		if(Professor.professorList) {
				System.out.println("교수 정보를 수정했습니다.");
		}else {
					System.out.println("교수 정보 수정에 실패했습니다.");
		}
	}
	//교수 정보 등록
	private void addProfessor() {
		System.out.println("-------------실행-------------");
		
		String info = scan.nextLine();
		List<Professor> professorList = new ArrayList<Professor>();
		char isContinue = 'n';
		do {
				System.out.print("교수 이름 추가 : ");
				String pfName = scan.next();
				System.out.print("교수 교번 추가 : ");
				String pfNum = scan.next();
				System.out.print("등록 전공 입력 : ");
				String major = scan.next();
				System.out.print("등록 전공 코드 : ");
				int majorCode = scan.nextInt();
				
				//professorList.add(new Professor(pfName, pfNum, major, majorCode));
				System.out.print("교수 정보를 계속 추가하시겠습니까?(y/n): ");
				isContinue = scan.next().charAt(0);
				
		}while(isContinue == 'y');
		
		if(professorList == null || professorList.isEmpty()) {
			System.out.println("교수 정보가 없습니다.");
			return;
		}
		if(addProfessor(professorList)) {
			System.out.println("교수 정보를 추가하였습니다.");
		}else {
			System.out.println("교수 정보가 중복되었습니다.");
		}
	}
	private boolean addProfessor(List<Professor> professorList) {
		   return true;
	}
}
