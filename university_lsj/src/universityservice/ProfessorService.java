package universityservice;

import java.util.List;

public interface ProfessorService {
	
	boolean addProfessor(List<Professor>apf, Professor pf);
	
	boolean removeProfessor(List<Professor>rpf);
	
	boolean setProfessor(List<Professor> spf);//리턴값 받으려고 참, 거짓
}