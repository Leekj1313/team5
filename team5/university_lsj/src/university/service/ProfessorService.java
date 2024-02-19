package university.service;

import java.util.List;

public interface ProfessorService {
	
	boolean addProfessor(List<Professor>apf, Professor pf);
	
	boolean removeProfessor(List<Professor>rpf);
	
	boolean setProfessor(List<Professor> spf);//리턴값 받으려고 참, 거짓
	

	boolean searchProfessor(List<Professor>sd);
	
	boolean searchStudent(List<Professor>sd);
	
	boolean searchClass(List<Student>rsd);
	
	//리턴값 받으려고
}