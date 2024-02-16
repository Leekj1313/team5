package it_community.dataBase.service;

import java.util.ArrayList;

import it_community.dataBase.model.vo.MemberVO;

public interface MemberService {

	boolean signUpMember(MemberVO member);

	ArrayList<MemberVO> getMemberList();

}
