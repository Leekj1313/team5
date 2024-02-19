package it_community.dataBase.model.vo;

import lombok.Data;

@Data
public class ReportVO {
	// 신고종류 : 욕설, 허위사실유포, 광고, 음란, 커뮤니티에 맞지 않음, 기타
	private String rt_type;
	
}
