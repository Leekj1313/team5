package kh.account.pagination;

@Data
public class Criteria {

	private int page;//현재 페이지
	private int petPageNum;//한 페이지에 최대 컨텐츠 개수
	private String search;//검색어. 검색 기능이 필요한 경우
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	public int getPagestart() {
		return (page - 1) * perPageNum;
	}
}
