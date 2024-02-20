package it_community.dataBase.dao;

import org.apache.ibatis.annotations.Param;

import it_community.dataBase.model.vo.CommentVO;

public interface CommentDAO {

	boolean writeComment(@Param("comment")CommentVO comment);
}
