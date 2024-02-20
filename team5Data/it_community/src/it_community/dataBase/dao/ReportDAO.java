package it_community.dataBase.dao;

import org.apache.ibatis.annotations.Param;

import it_community.dataBase.model.vo.ReportVO;

public interface ReportDAO {

	boolean writeReport(@Param("report")ReportVO report);

}
