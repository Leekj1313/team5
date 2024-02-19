package universityservice;

import java.util.List;
import java.util.Scanner;

public class StudentServiceImp implements StudentService {
	
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public boolean addStudent(List<Student>asd) {
		//교수 정보 추가 
				System.out.println(" 학생명 :");
				scan.nextLine();
				String sNam = scan.nextLine();
				System.out.println(" 학생 번호 :");
				String sNum = scan.nextLine();
				System.out.println(" 학생 과목:");
				String sub = scan.nextLine();
				Professor pf = new Professor(nam, num, sub); //생성자 바꾸기
				pfs.addProfessor(professors, pf); //바꾸기
		return true;
		
	}

	@Override
	public boolean setStudent(List<Student>ssd) {
		// 학생 수정
		if (ssd == null || ssd.isEmpty()) {
			System.out.println("수정할 학생 정보가 없습니다.");
			return false;
		}
			System.out.println("수정할 학생명 :");
			String oldnam = scan.nextLine();
			System.out.println("수정할 학생번호 :");
			String oldNum = scan.nextLine();
			System.out.println("수정할 학생과목 :");
			String oldSub = scan.nextLine();
			
			Student oldSt = new Student (oldnam, oldNum, oldSub);
			
			int index = ssd.indexOf(oldSt);
			if(index != -1) {
				System.out.println("수정할 학생명 :");
				String newNam = scan.nextLine();
				System.out.println("수정할 학생번호 :");
				String newNum = scan.nextLine();
				System.out.println("수정할 학생과목 :");
				String newSub = scan.nextLine();
				
				Student NewSt = new Student (newNam, newNum, newSub);
				ssd.remove(index);
				ssd.add(NewSt);
				System.out.println("수정이 완료됐습니다.");
				return true;
			}else{
				System.out.println("수정에 실패했습니다");
				return false;
			}
		
		
				
}

	@Override
	public boolean removeStudent(List<Student>rsd) {
		return false;
		if(rsd == null || rsd.isEmpty()) {
			System.out.println("삭제 가능한 정보가 없습니다.");
			return false;
		}	
		//교수 정보 삭제
		System.out.println(" 삭제할 교수명 :");
		String sNam = scan.nextLine();
		System.out.println(" 삭제할 교수 번호 :");
		String sNum = scan.nextLine();
		System.out.println(" 삭제할 교수 과목:");
		String sSub = scan.nextLine();
		Professor pf = new Professor(rNam, rNum, rSub); //생성자 바꾸기
		if(rsd.contains(pf)){     //바꾸기 
			rsd.remove(pf);       //바꾸기
			System.out.println("강의가 삭제 되었습니다.");
			return true;
		}else {
			System.out.println("삭제에 실패 했습니다.");
			return false;
		}
	}

}
