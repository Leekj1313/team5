package kr.kh.community.service;

import java.util.List;

import kr.kh.community.model.vo.Category;
import kr.kh.community.model.vo.Post;
import kr.kh.community.model.vo.Type;

public interface ItService {


	List<Post> getPostListByDate(String date);

	boolean insertPost(Post post);

	List<Type> getTypeList();

	List<Category> getCategoryList(int type);


	
	
	
	
}
