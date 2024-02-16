package it_community.dataBase.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import it_community.dataBase.model.vo.MemberVO;


public interface MemberDAO {

	boolean signUpMember(@Param("member")MemberVO member);

	ArrayList<MemberVO> selectMemberList();

}
