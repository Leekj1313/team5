package it_community.dataBase.model.vo;

import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	// 회원가입 시 필요정보 아이디. 패스워드, 이메일, 이름, 전화번호, 권한, 상태
	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_name;
	private String me_phone;
	private String me_access;
	private String me_active;
	
	public MemberVO(String me_id, String me_pw, String me_email, String me_name, String me_phone,String me_access,String me_active) {
		
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_email = me_email;
		this.me_name = me_name;
		this.me_phone = me_phone;
		this.me_access = me_access;
		this.me_active = me_active;
	}

	@Override
	public String toString() {
		return "[" + me_id + "|" + me_pw + "|" + me_email + "|" 
				+ me_name + "|" + me_phone + "|" + me_access + "|" + me_active + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(me_id, other.me_id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(me_id);
	}
	
	
}
