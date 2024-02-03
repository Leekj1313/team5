package university.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Student implements Serializable {

	private static final long serialVersionUID = 1207689536934801680L;
	
	public static boolean StudentInfo;
	
	private String stName;
	private int stNum;
	private String attend;
	
	@Override
	public String toString() {
		return "Student [stName=" + stName + ", stNum=" + stNum + ", attend=" + attend + "]";
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
		return Objects.equals(attend, other.attend) && Objects.equals(stName, other.stName) && stNum == other.stNum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(attend, stName, stNum);
	}
}