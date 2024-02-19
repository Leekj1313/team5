package it_community.dataBase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.compiler.ast.Member;

import it_community.dataBase.model.vo.MemberVO;


public interface MemberDAO {
	
	// 회원의 회원가입 정보를 저장한다
	boolean signUpMember(@Param("member")MemberVO member);
	
	// 회원의 정보를 수정하기 위한 member의 me_id룰 조회한다
	List<Member> selectMemberListById(@Param("me_id")String me_id);

}
