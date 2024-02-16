package it_community.dataBase.service;

import it_community.dataBase.dao.MemberDAO;
import it_community.dataBase.model.vo.MemberVO;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;

import javax.script.AbstractScriptEngine;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MemberServiceImp implements MemberService{
	
	private MemberDAO memberDao;
	
	private InputStream inputStream;
	
	private SqlSession session;
	
	public MemberServiceImp() {
		//Dao를 연결 => memberDAO와 연결 중 
		String resource = "it_community/dataBase/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean signUpMember(MemberVO member) {
		// 회원가입 시 필요정보 아이디. 패스워드, 이메일, 이름, 전화번호, 권한, 상태
		if(member == null 
				|| member.getMe_id() == null
				|| member.getMe_pw() == null
				|| member.getMe_email() == null
				|| member.getMe_name() == null
				|| member.getMe_phone() == null
				|| member.getMe_access() == null
				|| member.getMe_active() == null) {
			return false;
		}
		boolean res = memberDao.signUpMember(member);
		if(res) {
			session.commit();
		}
		return res;
	}
	
	@Override
	public ArrayList<MemberVO> getMemberList() {
		// memberDao에서 저장된 회원정보 불러오기
		return memberDao.selectMemberList();
	}
}