package university.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Classes implements Serializable {

	private static final long serialVersionUID = 5730653669337303524L;
	
		String className;
		String pfName;
		String classRoom;
		int maxClass;
		
		@Override
		public String toString() {
			return "Classes [className=" + className + ", pfName=" + pfName + ", classRoom=" + classRoom + ", maxClass="
					+ maxClass + "]";
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Classes other = (Classes) obj;
			return Objects.equals(className, other.className) && Objects.equals(classRoom, other.classRoom)
					&& maxClass == other.maxClass && Objects.equals(pfName, other.pfName);
		}
		@Override
		public int hashCode() {
			return Objects.hash(className, classRoom, maxClass, pfName);
		}
		
}
