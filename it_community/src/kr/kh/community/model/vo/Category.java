package kr.kh.community.model.vo;

import java.util.Objects;

import lombok.Data;

@Data
public class Category {
	private int ca_num;
	private String ca_ty_name;
	private String ca_name;
	
	@Override
	public String toString() {
		return "Category [ca_num=" + ca_num + ", ca_ty_name=" + ca_ty_name + ", ca_name=" + ca_name + "]";
	}
	
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
	

}
