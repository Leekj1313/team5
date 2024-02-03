package university.service;

public class PrintServiceImp implements PrintService{

	@Override
	public void printMainmenu() {
		System.out.println("----------메인메뉴----------");
		System.out.println("1. 교수 정보 관리");
		System.out.println("2. 학생 정보 관리");
		System.out.println("3. 과목 정보 관리");
		System.out.println("4. 강의 정보 관리");
		System.out.println("5. 프로그램 종료");
		System.out.println("-------------------------------");
		System.out.print("메뉴 선택: ");
	}
	@Override
	public void printProfessorMenu() {
		System.out.println("----------교수메뉴----------");
		System.out.println("1. 교수 정보 추가");
		System.out.println("2. 교수 정보 수정");
		System.out.println("3. 학생 학점 입력");
		System.out.println("4. 학생 학점 수정");
		System.out.println("5. 전공 학점 조회");
		System.out.println("6. 이전으로");
		System.out.println("-------------------------------");
		System.out.print("메뉴 선택: ");
	}
	@Override
	public void printStudentMenu() {
		System.out.println("----------학생메뉴----------");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 정보 수정");
		System.out.println("3. 수강 신청");
		System.out.println("4. 수강 신청 수정");
		System.out.println("5. 전공 학점 조회");
		System.out.println("6. 이전으로");
		System.out.println("-------------------------------");
		System.out.print("메뉴 선택: ");
	}
	@Override
	public void printMajorMenu() {
		System.out.println("----------전공메뉴----------");
		System.out.println("1. 전공 과목 추가");
		System.out.println("2. 전공 과목 수정");
		System.out.println("3. 전공 과목 조회");
		System.out.println("4. 이전으로");
		System.out.println("-------------------------------");
		System.out.print("메뉴 선택: ");
	}
	@Override
	public void printClassMenu() {
		System.out.println("----------강의메뉴----------");
		System.out.println("1. 전공 강의 신설 추가");
		System.out.println("2. 전공 강의 신설 수정");
		System.out.println("3. 전공 강의 신설 조회");
		System.out.println("4. 이전으로");
		System.out.println("-------------------------------");
		System.out.print("메뉴 선택: ");		
	}
	@Override
	public void searchMajor() {
		System.out.println("----------조회메뉴----------");
		System.out.println("1. 전공 전체 조회");
		System.out.println("2. 전공 검색 조회");
		System.out.println("3. 이전으로");
		System.out.println("-------------------------------");
		System.out.print("메뉴 선택: ");
	}

}
