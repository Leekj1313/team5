package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import university.program;
import university.service.PrintServiceImp;
import university.service.Professor;
import university.service.ProfessorService;
import university.service.ProfessorServiceImp;
import university.service.Student;
import university.service.StudentService;
import university.service.StudentServiceImp;

public class UniversityProgram implements program {
	private Scanner scan = new Scanner(System.in);
	PrintServiceImp psi = new PrintServiceImp();
	
	ProfessorService pfs = new ProfessorServiceImp();
	List<Professor> professors = new ArrayList<Professor>();
	
	StudentService sds = new StudentServiceImp();
	List<Student> std = new ArrayList<Student>();
	
	
	@Override
	public void run() {
		int menu=0;
		do {
		psi.printMainmenu();
		menu = scan.nextInt();
		runMenu(menu);
		}while(menu != 4);
	}

	@Override
	public void printMenu() {
		
	}

	@Override
	public void runMenu(int menu) {
		
		switch (menu) {
		case 1: 
			//교수 정보
			proManager(); //메서드 호출 1번누름
			break;
		case 2: 
			//학생 정보
			stdManager(); //메서드 호출
			break;
		case 3: 
			//대학교 조회
			checkManager(); //메서드 호출
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + menu);
		}
	}

	//대학교 조회 매니저
	private void checkManager() {
		int menu = 0;
		do{
			psi.printMainmenu();
			menu = scan.nextInt();
			runPrint(menu);
			}while(menu != 4);
		
	}

	//강의조회
	
	private void runPrint(int menu) {
		switch(menu) {
		case 1:
			System.out.println( professors.toString());
			//등록된 교수 조회
			break;
		case 2:
			System.out.println(std.toString());
			break;
			//등록된 학생 조회
		case 3:
			//System.out.println(c);
			//개설된 강의 조회
			break;
		case 4:
			System.out.println("이전으로");
			//이전으로
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;
		
		}
		
	}

	

	
	
	//학생 정보 매니저 
	private void stdManager() {
		int menu=0;
		do {
			psi.printStudentMenu();;
			menu = scan.nextInt();
			runStudent(menu);
			}while(menu != 4);
		}
	private void runStudent(int menu) {
		switch(menu) {
		case 1:
			//학생 추가
			addStudent();
			break;
		case 2:
			//학생 수정
			setStudent();
			break;
		case 3:
			//학생 삭제
			removeStudent();
			break;
		case 4:
			System.out.println("이전으로");
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;	
		}
		
	}
	//학생 삭제 메서드
	private void removeStudent() {
		sds.removeStudent(std);
	}
	
	//학생 수정 메서드
	private void setStudent() {
		sds.setStudent(std);
	}
	
	//학생 추가 메서드
	private void addStudent() {
		sds.addStudent(std);
	}

	//교수 정보 매니저
	private void proManager() {
		int menu=0;
		do {
		psi.printProfessorMenu();
		menu = scan.nextInt();
		runProfessor(menu);
		}while(menu != 4);
	}

	private void runProfessor(int menu) {
		switch(menu) {
		case 1:
			//교수 추가
			addProfessor(); //메서드 호출
			break;
		case 2:
			//교수 수정
			setProfessor();//메서드 호출
			break;
		case 3:
			//교수 삭제
			removeprofessor();//메서드 호출
			break;
		case 4:
			System.out.println("이전으로");
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;	
		}
	}
	private void removeprofessor() {
		System.out.println("삭제");
		pfs.removeProfessor(professors);
	}

	private void setProfessor() {
		System.out.println("수정");
		pfs.setProfessor(professors);

	}

	private void addProfessor() {
		//교수 정보 추가 
		System.out.println(" 교수명 :");
		scan.nextLine();
		String nam = scan.nextLine();
		System.out.println(" 교수 번호 :");
		String num = scan.nextLine();
		System.out.println(" 교수 과목:");
		String sub = scan.nextLine();
		Professor pf = new Professor(nam, num, sub);
		pfs.addProfessor(professors, pf);
	}
}
