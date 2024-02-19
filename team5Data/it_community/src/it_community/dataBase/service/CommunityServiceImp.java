package it_community.dataBase.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale.Category;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import it_community.dataBase.dao.CommunityDAO;
import it_community.dataBase.model.vo.CommunityVO;

public class CommunityServiceImp implements CommunityService{
	
	private CommunityDAO communityDao;
	//상황에 따라서 여러 dao가 올 수 있다 
	private InputStream inputStream;
	
	private SqlSession session;
	
	public CommunityServiceImp() {
		//Dao를 연결 => communityDao와 연결
		String resource = "it_community/dataBase/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true); //자동으로 커밋을 할 지 선택한다
			communityDao = session.getMapper(CommunityDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Category> getCategoryList(String category) {
		// 대분류 선택 (공지게시판, 자유게시판, 정보게시판) 리스트에서 가져온다 => from category 테이블(SQL)
		if(category == null) {
			return null;
		}
		return communityDao.selectCategoryList(category);
	}
	
	@Override
	public List<Divice> getDiviceList(String divice) {
		// TODO Auto-generated method stub
		if(divice == null) {
			return null;
		}
		return communityDao.selectDiviceList(divice);
	}
	
	@Override
	public boolean addPost(CommunityVO post) {
		// 게시글 작성 시 필요항목 게시판 분류, 기기 분류, 아이디, 제목, 날짜, 내용 
		if(post == null
				|| post.getPo_ca_num() == null
				|| post.getPo_di_num() == null
				|| post.getPo_me_id() == null
				|| post.getPo_title() == null
				|| post.getPo_date() == null
				|| post.getPo_content() == null) {
			return false;			
		}
		boolean res = communityDao.addPost(post);
		if(res) {
			session.commit();
		}
		return res;
	}


}
