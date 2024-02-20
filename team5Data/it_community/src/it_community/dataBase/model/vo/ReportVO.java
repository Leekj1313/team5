package it_community.dataBase.model.vo;

import lombok.Data;

@Data
public class ReportVO {
	
	// 신고종류 : 욕설, 허위사실유포, 광고, 음란, 커뮤니티에 맞지 않음, 기타
	private String rep_me_id;
	private String rep_rt_type;
	private String rep_content;
	
	public ReportVO(String rep_me_id, String rep_rt_type, String rep_content) {
		// TODO Auto-generated constructor stub
		this.rep_me_id = rep_me_id;
		this.rep_rt_type = rep_rt_type;
		this.rep_content = rep_content;
	}
	
}
