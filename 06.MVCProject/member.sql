create user jspuserc identified by jsp1234;

-- SQL
-- 1) 데이터 정의 언어(DDL) : create(테이블만들때), alter(스키마수정할때), drop(데이터,스키마 다 지움)
-- 2) 데이터 조작 언어(DML) : insert(행이하나씩추가), update(행내에서데이터변화), delete(행을삭제하는것), select(검색해오는것)
-- 3) 데이터 제어 언어(DCL) : grant(권한을 주는것), revoke(줬던 권한을 다시 빼았음)

-- 테이블 생성
create table member
(
	id			varchar2(15)	primary key,
	password	varchar2(10),
	name		varchar2(20),
	gender		char(1),
	age			number,
	addr		varchar2(100),
	regdate		date			default sysdate
)

select * from member
where id='test'

insert into member
values('test1', '1234', '의진공주', 22, '1', '서울시', '2015-04-17')

drop table member

update member
set addr = '응암동'
