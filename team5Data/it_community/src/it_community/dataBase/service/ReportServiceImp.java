package it_community.dataBase.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import it_community.dataBase.dao.ReportDAO;
import it_community.dataBase.model.vo.ReportVO;

public class ReportServiceImp implements ReportService{
	
	private ReportDAO reportDao;
	//상황에 따라서 여러 dao가 올 수 있다 
	private InputStream inputStream;
	
	private SqlSession session;
	
	public ReportServiceImp() {
		//Dao를 연결 => communityDao와 연결
		String resource = "it_community/dataBase/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true); //자동으로 커밋을 할 지 선택한다
			reportDao = session.getMapper(ReportDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean writeReport(ReportVO report) {
		if(report == null 
				|| report.getRep_me_id() == null
				|| report.getRep_rt_type() == null
				|| report.getRep_content() == null) {
			return false;
		}
		boolean res = reportDao.writeReport(report);
		if(res) {
			session.commit();
		}
		return res;
	}

}
