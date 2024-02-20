use elec_community;

# 커뮤니티 추가 
insert into `community` (comu_name) values("전자기기 정보 공유 사이트");
select * from community;

# 회원 상태를 추가하는 쿼리(활동 회원, 휴면 회원, 정지 회원, 탈퇴 회원)
insert into `active` values ("활동 회원"), ("휴면 회원"), ("정지 회원"), ("탈퇴 회원"),("관리자");
select * from active;

# 관리자가 커뮤니티를 등록(공지게시판, 자유게시판, 정보게시판,이벤트)
insert into `category` (ca_title, ca_comu_num) values ("공지게시판", 1),("자유게시판", 1),("정보게시판", 1),("이벤트", 1);
select * from category;

 # 관리자가 디바이스 분류를 추가 
insert into `divice` (di_title) values("스마트폰"),("태블릿"),("주변기기"),("카메라"),("PC"),("기타");
select * from divice;


