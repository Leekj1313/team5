package it_community.dataBase.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.apache.ibatis.annotations.Param;

import it_community.dataBase.model.vo.CommunityVO;

public interface CommunityDAO<Category,Divice> {
	
	
	List<Category> selectCategoryList(@Param("Ca_title")String category);
	
	List<Divice> selectDiviceList(@Param("di_title")String divice);

	boolean addPost(@Param("post")CommunityVO post);

	ArrayList<CommunityVO> selectPostList();




}
