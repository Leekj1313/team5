package university.vo;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Major implements Serializable {
	
	private static final long serialVersionUID = -3996290380420389209L;

	public static final boolean MajorInfo = false;
	
	private int majorNum;
	private String majorName;
	private int pfNum;
	private String pfName;
	
	@Override
	public String toString() {
		return "Major [majorNum=" + majorNum + ", majorName=" + majorName + ", pfNum=" + pfNum + ", pfName=" + pfName
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
		Major other = (Major) obj;
		return Objects.equals(majorName, other.majorName) && majorNum == other.majorNum
				&& Objects.equals(pfName, other.pfName) && pfNum == other.pfNum;
	}
	
}