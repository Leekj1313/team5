package university.controller;

import university.program.Program;
import university.service.ClassService;
import university.service.ClassServiceImp;
import university.service.MajorService;
import university.service.MajorServiceImp;
import university.service.PrintService;
import university.service.PrintServiceImp;
import university.service.ProfessorService;
import university.service.ProfessorServiceImp;
import university.service.StudentService;
import university.service.StudentServiceImp;

public class UniversityProgram implements Program{
	
	private PrintService printService = new PrintServiceImp();
	private ClassService classService = new ClassServiceImp();
	private MajorService majorService = new MajorServiceImp();
	private ProfessorService professorService = new ProfessorServiceImp();
	private StudentService studentService = new StudentServiceImp();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub
		
	}

}
