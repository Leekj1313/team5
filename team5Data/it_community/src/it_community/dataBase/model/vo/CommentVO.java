package it_community.dataBase.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	
	private int co_po_num;
	private String co_me_id;
	private String co_content;
	private String co_date;

	public CommentVO(int co_po_num, String co_me_id, String co_content, String co_date) {
		// TODO Auto-generated constructor stub
		this.co_po_num = co_po_num;
		this.co_me_id = co_me_id;
		this.co_content = co_content;
		this.co_date = co_date;
	}

}
