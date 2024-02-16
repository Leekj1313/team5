package it_community.dataBase.model.vo;

import java.util.Objects;

public class CommunityVO {
	
	// 대분류 : 공지게시판, 자유게시판, 정보게시판 
	private int ca_num; // 대분류 번호
	private String ca_title; // 대분류 제목
	private int ca_comu_num; // 커뮤니티 번호 
	
	public CommunityVO(int ca_num, String ca_title, int ca_comu_num) {
		this.ca_num = ca_num;  
		this.ca_title = ca_title;
		this.ca_comu_num = ca_comu_num;
	}
	
	// 중분류 : 스마트폰, 테블릿, 주변기기, pc, 기타 
	private int di_num; // 중분류 번호
	private String di_title; // 중분류 제목
	
	public CommunityVO(int di_num, String di_title) {
		this.di_num = di_num;
		this.di_title = di_title;
	}
		
	// 게시글 작성 시 필요항목 게시판 분류, 기기 분류, 아이디, 제목, 날짜, 내용 
	private int po_ca_num;
	private int po_di_num;
	private String po_me_id;
	private String po_title;
	private String po_date;
	private String po_content;
	
	public CommunityVO(int po_ca_num, int po_di_num, String po_me_id, String po_title, String po_date, String po_content) {
		
		this.po_ca_num = po_ca_num;
		this.po_di_num = po_di_num;
		this.po_me_id = po_me_id;
		this.po_title = po_title;
		this.po_date = po_date;
		this.po_content = po_content;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommunityVO other = (CommunityVO) obj;
		return ca_num == other.ca_num && di_num == other.di_num && Objects.equals(po_content, other.po_content)
				&& Objects.equals(po_date, other.po_date) && Objects.equals(po_me_id, other.po_me_id)
				&& Objects.equals(po_title, other.po_title);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ca_num, di_num, po_content, po_date, po_me_id, po_title);
	}
}