package university.service;

import java.util.List;

public interface SubjectService {

	boolean addSubject(List<Subject>asb, Professor pf);
	
	boolean removeSubject(List<Professor>rpf);
	
	boolean setSubject(List<Professor> spf);//리턴값 받으려고 참, 거짓
}
