package universityservice;

import java.util.List;
import java.util.Objects;
	
public class Student {
	
	List<Student>ssd;
	
	private String sname;
	private String snum;
	private String ssub;
	
	public Student(String sname, String snum, String ssub) {
		
		this.sname = sname;
		this.snum = snum;
		this.ssub = ssub;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(snum);
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
		return Objects.equals(snum, other.snum);
	
	}

	@Override
	public String toString() {
		return "Student [ 학생명 : " + sname + ", 학번 : " + snum + ", 학과 : " + ssub + "]";
	}
	
}
