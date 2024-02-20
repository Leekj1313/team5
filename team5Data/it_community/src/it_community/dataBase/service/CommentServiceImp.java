package it_community.dataBase.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import it_community.dataBase.dao.CommentDAO;
import it_community.dataBase.model.vo.CommentVO;


public class CommentServiceImp implements CommentService{
	
	private CommentDAO commentDao;
	
	private InputStream inputStream;
	
	private SqlSession session;

	public CommentServiceImp() {
		//Dao를 연결 => commentDAO와 연결 중 
		String resource = "it_community/dataBase/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			commentDao = session.getMapper(CommentDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
	@Override
	public boolean writeComment(CommentVO comment) {
		// TODO Auto-generated method stub
		if(comment == null
				|| comment.getCo_po_num() == 0
				|| comment.getCo_me_id() == null
				|| comment.getCo_content() == null
				|| comment.getCo_date() == null) {
			return false;
		}
		boolean res = commentDao.writeComment(comment);
		if(res) {
			session.commit();
		}
		return res;
	}

}
