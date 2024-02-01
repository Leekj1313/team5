package universityservice;

import java.util.List;
import java.util.Scanner;

public class ProfessorServiceImp implements ProfessorService {
private Scanner scan = new Scanner(System.in);

	@Override
	public boolean addProfessor(List<Professor>apf, Professor pf) {
		
		apf.add(pf);//저장
		System.out.println("저장이 완료됐습니다.");
		return true;
		
		}
	@Override
	public boolean setProfessor(List<Professor> spf) {
		//교수 정보 수정
		//배열에 들어있는지 확인 없으면 false 있으면 수정 실행
		if(spf == null || spf.isEmpty()) {
			System.out.println("수정 가능한 교수가 없습니다.");
			return false; // false 값을 받으면 실행 X 
		}
		System.out.println("수정할 교수명 :");
		String oldPnam = scan.nextLine();
		System.out.println("수정할 교수번호 :");
		String oldNum = scan.nextLine();
		System.out.println("수정할 교수과목 :");
		String oldSub = scan.nextLine();
		//생성자 생성
		Professor oldPf = new Professor(oldPnam, oldNum, oldSub);
		//인덱스값 찾기
		int index = spf.indexOf(oldPf); //찾아오는 것 
		if(index != -1) {
			String newNam, newNum, newSub;
			System.out.println("===============");
			System.out.println("새로운 교수명 :");
			newNam = scan.nextLine();
			System.out.println("새로운 교수번호 :");
			newNum = scan.nextLine();
			System.out.println("새로운 교수과목 :");
			newSub = scan.nextLine();
			Professor NewPf = new Professor(newNam, newNum, newSub);
			spf.remove(index);
			spf.add(NewPf);
			System.out.println("수정이 완료됐습니다.");
			return true;
		}else {
		System.out.println("수정에 실패했습니다.");
		
			return false;
		}
	}

	@Override
	public boolean removeProfessor(List<Professor>rpf) {
		if(rpf == null || rpf.isEmpty()) {
			System.out.println("삭제 가능한 정보가 없습니다.");
			return false;
		}	
		//교수 정보 삭제
		System.out.println(" 삭제할 교수명 :");
		String rNam = scan.nextLine();
		System.out.println(" 삭제할 교수 번호 :");
		String rNum = scan.nextLine();
		System.out.println(" 삭제할 교수 과목:");
		String rSub = scan.nextLine();
		Professor pf = new Professor(rNam, rNum, rSub);
		if(rpf.contains(pf)) {
			rpf.remove(pf);
			System.out.println("강의가 삭제 되었습니다.");
			return true;
		}else {
			System.out.println("삭제에 실패 했습니다.");
			return false;
		}
	}
}
	
			


