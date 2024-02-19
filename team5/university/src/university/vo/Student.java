package university.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//학생 정보를 나타내는 클래스
//필요한 멤버들을 추가하세요.
public class Student implements Serializable {

	private static final long serialVersionUID = 1207689536934801680L;
	
	private String student;
	private List<Student> List;//수정필요
	
	public static boolean StudentInfo;

	@Override
	public int hashCode() {
		return Objects.hash(student);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(student, other.student);
	}
	public void printStudent() {
		System.out.println("이름 : " + student);
		if(studentList == null || studentList.size() == 0) {
			System.out.println("등록된 학생 정보가 없습니다.");
			return;
		}
		for(int i = 0; i <studentList.size(); i++) {//1. 20150040-이무개-건축개론
			System.out.println(i+1+". " + studentList.get(i));
		}
	}
	/*
	public boolean addMajor(String major) {
		if(majorList == null) {
			return false;
		}
		if(majorList.contains(new Major(major))) {
			return false;
		}
		majorList.add(new Major(major));//전공 과목만 추가할 것인지, 교양과목은?, 과목코드는? => 고려해야 할 사항
		return true;
	}
	*/
	public boolean setStudent(int pos, int num, String name, String major) {
		if(studentList == null) {
			return false;
		}
		if(pos < 0 || pos >= studentList.size()) {
			return false;
		}
		if(studentList.contains(new Major(major))) {
			return false;
		}
		studentList.set(pos, new Student(num, name, major));
			return true;
	}
	public boolean removeStudent(int pos) {
		
	}

}
