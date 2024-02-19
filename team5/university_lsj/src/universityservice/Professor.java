package universityservice;

import java.util.List;
import java.util.Objects;

public class Professor {
	
	//필드 변수 선언, 변수명을 다른데서 쓸 수 있음
	
	
	private String pName;
	private String pNum;
	private String major;
	
	public Professor(String pName, String pNum, String major) {
		
		this.pName = pName;
		this.pNum = pNum;
		this.major = major;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(pNum, other.pNum);
	}

	@Override
	public String toString() {
		return "Professor [ 교수명 : " + pName + ", 교수 번호 : " + pNum + ", 담당 과목 :  " + major + "]";
	}
	
	
}
