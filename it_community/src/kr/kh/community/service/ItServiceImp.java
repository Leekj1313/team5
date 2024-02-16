package kr.kh.community.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.community.dao.CommunityDAO;
import kr.kh.community.model.vo.Category;
import kr.kh.community.model.vo.Community;
import kr.kh.community.model.vo.Post;
import kr.kh.community.model.vo.Type;
import kr.kh.community.pagination.Criteria;

public class ItServiceImp implements ItService {
	
	private CommunityDAO communityDao;
	
	public ItServiceImp() {
		String resource = "kr/kh/community/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			communityDao = session.getMapper(CommunityDAO.class);
			} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Post> getPostListByDate(String date) {
		//날짜가 없는 경우
		if(date == null) {
			return null;
		}
		return communityDao.selectBoardListByDate(date);
	}

	@Override
	public boolean insertPost(Post post) {
		if(post == null || post.getPo_id() == null) {
			return false;
		}
		if(!checkCategoryNum(post.getPo_title(),post.getPo_ca_num())){
			return false;
		}
		return communityDao.insertPost(post);
	}

	private boolean checkCategoryNum(String po_title, int po_ca_num) {
		//type과 일치하지 않은 카테고리 체크
		List<Category> categoryList = communityDao.selectCategoryList(po_title);
	
		return categoryList.contains(new Category (po_title));
	
		}

	

	@Override
	public List<Category> getCategoryList(int type) {
		return communityDao.selectCategoryList(type);
	}

	@Override
	public List<Community> getTypeList() {
		return communityDao.selectTypeList();
	}

	@Override
	public List<Post> getPostListByDate(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Post> getPostList(Post post) {
		//return communityDao.insertPost(post);
		return null;
		
	}


		
}
