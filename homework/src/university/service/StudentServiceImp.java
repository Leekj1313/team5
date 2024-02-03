package university.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import university.vo.Inclasses;
import university.vo.Professor;
import university.vo.Student;

public class StudentServiceImp implements StudentService {

	private PrintService printService = new PrintServiceImp();
	private Inclasses inclasses = new Inclasses();
	
	private List<Student> studentList = new ArrayList<>();
	
	private Scanner scan = new Scanner(System.in);
	
	private final int STU_EXIT = 6;
	/*학생 기능을 담당하는 서비스 클래스
	 * 1. 학생 정보 추가
	 * 학생이름 추가/ 이름	 	: 김모모
	 * 학생학번 추가/ 학번		: 20150302
	 * 재적/ 휴학여부 입력  	: 재학 
	 * 2. 학생정보 수정
	 * 수정할 학생 학번 선택
	 * 학생이름 추가/ 이름	 	: 김모모
	 * 학생학번 추가/ 학번		: 20150302
	 * 재적/ 휴학여부 입력  	: 휴학
	 * 3. 수강신청
	 * 수강할 전공코드 입력 	: 103(과학)
	 * 수강/ 재수강 여부		: 수강
	 * 학생이름 추가/ 이름	 	: 김모모
	 * 학생학번 추가/ 학번		: 20150302
	 * 4. 수강신청 수정
	 * 수정할 전공코드 입력 	: 101(수학)
	 * 수강/ 재수강 여부		: 재수강
	 * 학생이름 추가/ 이름	 	: 김모모
	 * 학생학번 추가/ 학번		: 20150302
	 * 5. 전공 학점 조회
	 * 조회할 전공 입력			: 101(수학)
	 * 조회할 학번 입력			: 20150302
	 * 6. 이전으로
	 */
	@Override
	public void runStudent() {
		int menu = 0;
		do {
			try {
					printStudentMenu(); 
					menu = scan.nextInt();
					runMenu(menu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴 입니다.");
			scan.nextLine();
		}
			}while(menu != STU_EXIT );
		}
	private void printStudentMenu() {
		printService.printStudentMenu();
	}
	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
					addStudent();
					break;
		case 2: 
					setStudent();
					break;
		case 3: 
					inclasses();
					break;
		case 4:
					//setInclasses();
					break;
		case 5:
					//searchStGrade();
					break;
		case 6 : 
					System.out.println("이전으로");
		default:
					throw new InputMismatchException();
		}
	}
	private void inclasses() {
		Inclasses.addClasses();
		
	}
	//학생 정보 수정
	private void setStudent() {
		System.out.print("수정할 학생 학번 선택: ");
		scan.nextLine();
		String beforeInfo = scan.nextLine();
		
		System.out.println("-------------수정-------------");
		
		System.out.print("수정 학생 이름 : ");
		String afterName = scan.nextLine();
		System.out.print("수장 학생 학번 : ");
		int afterNum = scan.nextInt();
		System.out.print("재학/휴학 여부 : ");
		String afterAtend = scan.nextLine();
		
		if(Student.StudentInfo) {
				System.out.println("학생 정보를 수정했습니다.");
		}else {
					System.out.println("학생 정보 수정에 실패했습니다.");
		}
	}
	//학생 정보 등록
	private void addStudent() {
			System.out.println("-------------실행-------------");
		List<Student> studentList = new ArrayList<Student>();
		
		char isContinue = 'n';
		do {
				System.out.print("학생 이름 추가 : ");
				String stName = scan.next();
				System.out.print("학생 학번 추가: ");
				int stNum = scan.nextInt();
				System.out.print("재학/ 휴학 여부: ");
				String  attend = scan.next();
				
				//studentList.add(new Student(stName, stNum, attend));
				System.out.print("학생 정보를 계속 추가하시겠습니까?(y/n): ");
				isContinue = scan.next().charAt(0);
				
		}while(isContinue == 'y');
		
		if(studentList == null || studentList.isEmpty()) {
				System.out.println("등록된 학생 정보가 없습니다.");
				return;
		}
		if(addStudent(studentList)) {
				System.out.println("학생 정보를 추가했습니다.");
		}else {
				System.out.println("중복된 학생 정보입니다.");
		}
	}
	private boolean addStudent(List<Student>studentList) {
		return true;
	}
}
