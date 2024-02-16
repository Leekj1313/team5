package kr.kh.community.service;

import java.util.ArrayList;
import java.util.List;

import kr.kh.community.model.vo.Category;
import kr.kh.community.model.vo.Community;
import kr.kh.community.model.vo.Post;
import kr.kh.community.model.vo.Type;
import kr.kh.community.pagination.Criteria;

public interface ItService {


	
	
	//List<Post> getPostListByDate(Criteria cri);

	//boolean insertPost(Post post);

	List<Community> getTypeList();

	List<Category> getCategoryList(int type);
	
	List<Post> getPostListByDate(String date);

	boolean insertPost(Post post);
	
	//ArrayList<Post> getPostList(Post post);


	
	
	
	
}
