package it_community.dataBase.service;

import java.util.List;
import java.util.Locale.Category;

import it_community.dataBase.model.vo.CommunityVO;

public interface CommunityService {
	
	boolean addPost(CommunityVO post);

	List<Category> getCategoryList(String category);

	List<Divice> getDiviceList(String divice);



}
