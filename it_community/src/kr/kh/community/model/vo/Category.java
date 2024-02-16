package kr.kh.community.model.vo;

import java.util.Objects;

import lombok.Data;

@Data
public class Category {
	int ca_num; //카테고리
	String ca_title; //제목
	int ca_comu_num; // //커뮤니티
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return ca_num == other.ca_num;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ca_num);
	}
	
	@Override
	public String toString() {
		return "Category [ca_num=" + ca_num + ", ca_title=" + ca_title + ", ca_comu_num=" + ca_comu_num + "]";
	}
	public Category(int ca_num, String ca_title, int ca_comu_num) {
		super();
		this.ca_num = ca_num;
		this.ca_title = ca_title;
		this.ca_comu_num = ca_comu_num;
	}
	
	

}
