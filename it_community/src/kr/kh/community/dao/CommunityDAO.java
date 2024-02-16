package kr.kh.community.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.apache.ibatis.annotations.Param;

import kr.kh.community.model.vo.Community;
import kr.kh.community.model.vo.Post;
import kr.kh.community.model.vo.Type;

public interface CommunityDAO {

	List<Community> selectTypeList(); //community type을 고름
	
	
	List<Post> selectBoardListByDate(@Param("it_date")String date);
	
	
	public boolean insertPost(@Param ("post")Post post);
	

	List<Category> selectCategoryList (String po_title);


	


	
	
	
}
