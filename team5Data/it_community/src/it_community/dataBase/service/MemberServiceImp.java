package it_community.dataBase.service;

import it_community.dataBase.dao.MemberDAO;
import it_community.dataBase.model.vo.MemberVO;

import java.io.IOException;

import java.io.InputStream;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.compiler.ast.Member;
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
	public List<Member> getMemberListById(String me_id) {
		// ID를 기준으로 조회하여 수정한다 
		if(me_id == null) {
			return null;
		}
		return memberDao.selectMemberListById(me_id);
	}
	@Override
	public boolean updateMember(MemberVO updateMember) {
		// TODO Auto-generated method stub
		if(updateMember == null
				|| updateMember.getMe_id() == null
				|| updateMember.getMe_pw() == null
				|| updateMember.getMe_email() == null
				|| updateMember.getMe_name() == null
				|| updateMember.getMe_phone() == null) {
		return false;
		}
		boolean res = memberDao.updateMember(updateMember);
		if(res) {
			session.commit();
		}
		return res;
	}
	@Override
	public ArrayList<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return memberDao.selectMemberList();
	}
	@Override
	public boolean deleteMember(String me_id) {
		// TODO Auto-generated method stub
		return memberDao.deleteMember(me_id);
	}
}
