package university.vo;

import java.util.Scanner;

public class Score {

	private static Scanner scan = new Scanner(System.in);
	
	public static void markingStudent() {
	
		char isContinue = 'n';
		do {
				System.out.print("평가 학생 이름 : ");
				String stName = scan.next();
				System.out.print("평가 학생 학번 : ");
				int stNum = scan.nextInt();
				System.out.print("평가 학생 점수 : ");
				int stScore = scan.nextInt();
				System.out.print("평가 학생 학점 : ");
				String stGrade = scan.next();
				
				System.out.print("학생 성적을 계속 추가하시겠습니까?(y/n): ");
				isContinue = scan.next().charAt(0);
			
		}while(isContinue == 'y');
		
		//if(studentList == null || studentList.isEmpty()) {
			System.out.println("학생 점수가 없습니다.");
			return;
		}
	public static void setMarkingStudent() {

		System.out.print("수정 학생 이름 : ");
		String stName = scan.next();
		System.out.print("수정 학생 학번 : ");
		int stNum = scan.nextInt();
		System.out.print("평가 수정 학생 점수 : ");
		int stScore = scan.nextInt();
		System.out.print("평가 수정 학생 학점 : ");
		String stGrade = scan.next();
	
		if(Student.StudentInfo) {
			System.out.println("학점 정보를 수정했습니다.");
		}else {
			System.out.println("학점 정보 수정에 실패했습니다.");
		}
	}
}