package university.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import university.program.Program;
import university.service.ClassService;
import university.service.ClassServiceImp;
import university.service.FileService;
import university.service.FileServiceImp;
import university.service.MajorService;
import university.service.MajorServiceImp;
import university.service.PrintService;
import university.service.PrintServiceImp;
import university.service.ProfessorService;
import university.service.ProfessorServiceImp;
import university.service.StudentService;
import university.service.StudentServiceImp;
import university.vo.Professor;

public class UniversityProgram implements Program{
	
	private final int EXIT = 5;
	
	private PrintService printService = new PrintServiceImp();
	private ClassService classService = new ClassServiceImp();
	private MajorService majorService = new MajorServiceImp();
	private ProfessorService professorService = new ProfessorServiceImp();
	private StudentService studentService = new StudentServiceImp();
	
	private Scanner scan = new Scanner(System.in);
	
	private List<Professor> professorList = new ArrayList<Professor>();
	
	@Override
	public void run() {
		int menu = 0;
		//String fileName = "src";
		/*교수에 대한 저장 클래스
		 * 학생에 대한 저장 클래스
		 * 과목에 대한 저장 클래스
		 * 강의에 대한 저장 클래스
		 * 		수강 신청 시 = 과목에 대한 저장 클래스, 강의에 대한 저장 클래스를 
		 * 							불러온 뒤 선택하여 신청
		 * 
		 *  FileServise = 메인 기능에 대한 저장 
		 */
		
		do {
				try {
						printMenu();
						menu = scan.nextInt();
						runMenu(menu);
				}catch(InputMismatchException e) {
						System.out.println("잘못된 메뉴 입니다.");
						scan.nextLine();
						}
		}while(menu != EXIT);
		/*
		if(fileService.save(fileName, classes.getList())) {
			System.out.println("저장이 완료되었습니다.");
		}else {
			System.out.println("저장에 실패했습니다.");
		}*/
	}
	@Override
	public void printMenu() {
		printService.printMainmenu();
	}
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
					professorService.runProfessor();
					break;
		case 2:
					studentService.runStudent();
					break;
		case 3:
					majorService.runMajor();
					break;
		case 4:
					classService.runClass();
					break;
		case 5:
					System.out.println("프로그램을 종료합니다.");
					break;
		default:
					throw new InputMismatchException();
		}
	}
}
