package it_community.dataBase.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.compiler.ast.Member;

import it_community.dataBase.model.vo.MemberVO;

public interface MemberService {

	// 회원가입을 실행시켜주는 코드
	boolean signUpMember(MemberVO member);
	
	// 회원의 정보를 수정하기 위해 Id를 조회하는 코드 
	List<Member> getMemberListById(@Param("me_id")String me_id);

	boolean updateMember(MemberVO updateMember);

	ArrayList<MemberVO> getMemberList();

	boolean deleteMember(String me_id);


}
