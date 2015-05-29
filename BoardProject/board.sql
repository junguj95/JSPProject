create user jspuserc identified by jsp1234;

create table board
(
	num			number			primary key,
	name		varchar2(10),
	title		varchar2(100),
	content		varchar2(1000),
	hits		number			default	0,
	wdate		date			default sysdate,
	attachment	varchar2(50)	
	
)

create sequence board_seq

insert into board
values(board_seq.nextval,'이름','제목','내용',0,default,'파일경로' )

select * from board
order by num desc

drop table board

select * from board order by num desc