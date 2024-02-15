package kr.kh.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.community.model.vo.Category;
import kr.kh.community.model.vo.Post;
import kr.kh.community.model.vo.Type;

public interface CommunityDAO {

	List<Type> selectTypeList();
	
	List<Post> selectBoardListByDate(@Param("it_date")String date);

	
	public boolean insertPost(@Param ("post")Post post);


	List<Category> selectCategoryList(@Param("ca_num")int type);
	
	
	
	
	
}
