package kr.kh.community.model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post {
	int po_num; 
	int po_ca_num; 
	int po_di_num;
	Date po_date;  
	String po_id;
	String po_title;
	String po_content;
	
	public Post (int categoryNum, int diviceNum, String date,String id, String title, String content) throws ParseException {
		po_ca_num = categoryNum;
		po_di_num = diviceNum;
		po_content = content;
		po_title =title;
		po_id = id;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		po_date = format.parse(date);
		
	}
	
	public String getIt_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(po_date);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return po_num == other.po_num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(po_num);
	}

	@Override
	public String toString() {
		return "Post [po_num=" + po_num + ", po_ca_num=" + po_ca_num + ", po_date=" + po_date + ", po_content="
				+ po_content + "]";
	}
	
	
}
