package university.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Professor implements Serializable {
	
	private static final long serialVersionUID = -2678245990359023939L;

	public static boolean professorList;
	
	private String Professor;
	private String PfName;
	private String PfNum;
	private String major;
	private int majorCode;

	@Override
	public String toString() {
		return "Professor [PfName=" + PfName + ", PfNum=" + PfNum + ", major=" + major + ", majorCode=" + majorCode
				+ "]";
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
		return Objects.equals(PfName, other.PfName) && PfNum == other.PfNum && Objects.equals(major, other.major)
				&& majorCode == other.majorCode;
	}
	@Override
	public int hashCode() {
		return Objects.hash(PfName, PfNum, major, majorCode);
	}
	/*
	private List<Professor>list;
	
	public ProfessorInfo(List<Professor>list) {
		if(list == null) {
			list = new ArrayList<Professor>();
		}
		this.list = list;
	}
	public boolean addProfessor(String professor, List<Professor> newProfessorList) {
		
	}
	*/
}
