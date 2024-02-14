package it_community.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import it_community.dao.CommunityDAO;

public class ServiceImp implements Service {
	
	private CommunityDAO itDao;
	
	public ServiceImp() {
		String resource = "it_community/src/it_community/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			itDao = session.getMapper(CommunityDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
	
	
}
