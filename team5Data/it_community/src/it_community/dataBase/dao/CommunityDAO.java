package it_community.dataBase.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import it_community.dataBase.model.vo.CommunityVO;

public interface CommunityDAO{

	boolean addPost(@Param("post")CommunityVO post);

	ArrayList<CommunityVO> selectPostList();




}
