package account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
private List<Profit> list;

// 수입, 지출 리스트를 관리하는 클래스
	private AccountManager(List<Profit>list) {
		if(list == null) {
			list = new ArrayList<Profit>();
		}
		this.list = list;
	}
	// 수입 추가 기능
	public boolean addProfit(String profit) {
		if(list == null) {
			return false;
		}
		int index = list.indexOf(new Profit(profit));
	}
	// 등록된 수입
	Profit selectedProfit = list.get(index);
	
	// 중복된 수입이 있으면 중복불가 출력
	// 등록된 수입을 가져옴
	List<Profit>list = getProfitList();// 수정이 필요하다 
}
