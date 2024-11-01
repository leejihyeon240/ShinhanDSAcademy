create table dept (
  deptno   integer(2) primary key, 
  dname    varchar(14),
  loc      varchar(20));

insert into dept values (10,'대표이사','서울');
insert into dept values (20,'기획부','서울');
insert into dept values (30,'기술부','서울');
insert into dept values (40,'영업부','서울');
insert into dept values (50,'운용팀','제주');


create table emp ( 
  empno     integer(4) primary key, 
  ename     varchar(10), 
  job       varchar(9), 
  mgr       integer(4), 
  birthday  date,
  hiredate  date, 
  salary    integer(7),
  bonus     integer(7), 
  deptno    integer(2));

insert into emp values (1000,'서민구','대표',NULL,'1978-04-16','2010-01-01',1800,500,10);
insert into emp values (1002,'류현진','이사',1000,'1980-11-10','2013-01-03',1000,300,30);
insert into emp values (2001,'손흥민','차장',1000,'1982-01-12','2012-01-01',900,200,20);
insert into emp values (2002,'오승환','차장',1000,'1984-02-19','2014-10-01',900,200,40);
insert into emp values (2003,'선동렬','주임',2001,'1983-03-14','2012-10-01',700,100,20);
insert into emp values (2004,'최동원','사원',2002,'1990-04-20','2012-10-01',600,150,40);
insert into emp values (2005,'박세리','사원',2001,'1991-05-21','2014-09-01',500,150,20);
insert into emp values (2006,'양준혁','사원',1000,'1990-06-30','2014-10-01',600,150,50);
insert into emp values (2007,'장종훈','사원',2002,'1989-07-11','2015-11-01',550,NULL,40);
insert into emp values (2008,'이종법','과장',1002,'1980-08-23','2016-01-03',650,200,30);
insert into emp values (2009,'송진우','과장',1002,'1982-09-08','2016-01-03',650,200,30);
insert into emp values (2010,'이순철','사원',1002,'1980-10-06','2016-06-01',600,NULL,30);
insert into emp values (2011,'장채근','사원',1002,'1982-11-22','2016-06-01',500,NULL,30);
insert into emp values (2012,'류중일','사원',2002,'1992-12-16','2014-10-01',550,150,40);


create table major
( code integer(3) primary key , 
  name varchar(20) not null,
  part integer(3),
  build  varchar(14));

insert into major
values (101,'컴퓨터공학과',100,'정보관');

insert into major
values (102,'멀티미디어공학과',100,'멀티미디어관');

insert into major
values (103,'소프트웨어공학과',100,'소프트웨어관');

insert into major
values (201,'전자공학과',200,'전자제어관');

insert into major
values (202,'기계공학과',200,'기계실험관');

insert into major
values (301,'문헌정보학과',300,'인문관');

insert into major
values (100,'컴퓨터정보학부',10,null);

insert into major
values (200,'전기전자학부',10,null);

insert into major
values (300,'인문사회학부',20,null);

insert into major
values (10,'공과대학',null,null);

insert into major
values (20,'인문대학',null,null);

commit;

create table professor
(no integer(4) primary key,
 name  varchar(10) not null, 
 id  varchar(15) not null,
 position varchar (10) not null,
 salary integer(3) not null,
 hiredate  date not null,
 bonus integer(4) ,
 deptno  integer(3),
 email  varchar(50),
 url  varchar(50));

insert into professor
values(1001,'서민구','kyt','정교수',550,str_to_date('2011-10-01','%Y-%m-%d'),200,101,'kyt@abc.net','http://www.kytpage.net');

insert into professor
values(1002,'유재석','kkb','정교수',450,str_to_date('2014-01-01','%Y-%m-%d'),100,102,'kkb@abc.net','http://www.kkbpage.net');

insert into professor
values(1003,'박명수','lyt','정교수',400,str_to_date('2014-01-01','%Y-%m-%d'),100,103,'lyt@abc.net','http://www.lytpage.net');

insert into professor
values(1004,'강호동','lby','조교수',350,str_to_date('2016-10-01','%Y-%m-%d'),100,101,'lby@abc.net','http://www.lbypage.net');

insert into professor
values(1005,'이수근','chs','조교수',300,str_to_date('2017-03-01','%Y-%m-%d'),100,102,'chs@abc.net','http://www.chspage.net');

insert into professor
values(1006,'김대희','ssh','조교수',350,str_to_date('2015-03-01','%Y-%m-%d'),100,103,'ssh@abc.net','http://www.sshpage.net');

insert into professor
values(1007,'유민상','lsm','조교수',400,str_to_date('2015-03-01','%Y-%m-%d'),100,201,'lsm@abc.net','http://www.lsmpage.net');
 
insert into professor
values(1008,'문세윤','cmy','조교수',430,str_to_date('2015-03-01','%Y-%m-%d'),100,202,'cmy@abc.net','http://www.cmypage.net');


insert into professor
values(1009,'김준현','pis','조교수',512,str_to_date('2015-03-01','%Y-%m-%d'),100,101,'pis@abc.net','http://www.pispage.net');


insert into professor
values(5010,'김준호','kon','시간강사',280,str_to_date('2015-03-01','%Y-%m-%d'),NULL,102,'kon@abc.net','http://www.konpage.net');


insert into professor
values(5011,'김병만','khj','시간강사',355,str_to_date('2015-03-01','%Y-%m-%d'),NULL,103,'khj@abc.net','http://www.khjpage.net');


insert into professor
values(5013,'유세윤','lmj','시간강사',200,str_to_date('2015-03-01','%Y-%m-%d'),NULL,301,'lmj@abc.net','http://www.lmjpage.net');

insert into professor
values(5014,'정형돈','ljm','시간강사',250,str_to_date('2015-03-01','%Y-%m-%d'),NULL,201,'ljm@abc.net','http://www.ljmpage.net');

insert into professor
values(5015,'노홍철','pss','시간강사',150,str_to_date('2015-03-01','%Y-%m-%d'),NULL,202,'pss@abc.net','http://www.psspage.net');


create table student
( studno integer(4) primary key,
  name   varchar(10) not null,
  id varchar(20) not null unique,
  grade integer check(grade between 1 and 6),
  jumin char(13) not null,
  birthday  date,
  tel varchar(15),
  height  integer(4),
  weight  integer(3),
  major1 integer(3),
  major2 integer(3),
  profno  integer(4));


insert into student values (
980111,'강진','kangjin2702',1,'9802231234567',str_to_date('1998-02-23','%Y-%m-%d'),'055)333-1234',183,71,101,null,null);

insert into student values (
980212,'곽종인','kwakjong',1,'9808021234567',str_to_date('1998-08-02','%Y-%m-%d'),'051)426-2345',178,65,102,null,null);

insert into student values (
980313,'박동인','kimdongin',1,'9810021234567',str_to_date('1998-10-02','%Y-%m-%d'),'053)566-3456',173,75,103,null,null);

insert into student values (
981113,'최정현','kimjunghyun',1,'9902082234567',str_to_date('1998-02-08','%Y-%m-%d'),'02)6122-4567',170,80,201,null,null);

insert into student values (
981213,'장영','kimyoung',1,'9812081234567',str_to_date('1998-12-08','%Y-%m-%d'),'031)122-5678',183,95,202,null,null);

insert into student values (
970111,'진영훈','kimyounghun',2,'9705231234567',str_to_date('1997-05-23','%Y-%m-%d'),'02)1220-6789',173,65,101,null,1001);

insert into student values (
970212,'이용','kimyong',2,'9712131234567',str_to_date('1997-12-13','%Y-%m-%d'),'055)222-6789',175,67,102,null,1002);

insert into student values (
970313,'김종연','kimyongyoun',2,'9711031234567',str_to_date('1997-11-03','%Y-%m-%d'),'051)356-9876',175,67,103,null,1003);

insert into student values (
971115,'하진석','hajinsuk',2,'9711031234567',str_to_date('1997-11-03','%Y-%m-%d'),'02)2212-6547',170,67,201,null,1007);

insert into student values (
971211,'유진성','youjinsung',2,'9703031234567',str_to_date('1997-03-03','%Y-%m-%d'),'031)567-5475',170,67,202,null,1008);

insert into student values (
960111,'이충연','leechungyun',3,'9603031234567',str_to_date('1996-03-03','%Y-%m-%d'),'032)3256-5445',169,67,101,301,1009);

insert into student values (
960212,'김태훈','kimtaehoon',3,'9603301234567',str_to_date('1996-03-30','%Y-%m-%d'),'02)5487-2345',189,63,102,null,1005);

insert into student values (
960315,'이철이','leechulri',3,'9612301234567',str_to_date('1996-12-30','%Y-%m-%d'),'02)2547-2345',180,67,103,null,1006);

insert into student values (
961115,'이여은','leeyueun',3,'9602252234567',str_to_date('1996-02-25','%Y-%m-%d'),'032)548-1445',159,48,201,103,1007);

insert into student values (
961215,'박재원','parkjewon',3,'9610271234567',str_to_date('1996-10-27','%Y-%m-%d'),'032)2582-9345',169,58,202,null,1008);

insert into student values (
950115,'이준희','leejunhee',4,'9410202234567',str_to_date('1994-10-20','%Y-%m-%d'),'02)2254-2645',163,59,101,null,1001);

insert into student values (
950211,'김희도','kimheedo',4,'9501201234567',str_to_date('1995-01-20','%Y-%m-%d'),'053)622-2459',173,69,102,null,1002);

insert into student values (
950315,'박동익','parkdongik',4,'9505211234567',str_to_date('1995-05-21','%Y-%m-%d'),'02)2152-2453',183,79,103,301,1003);

insert into student values (
951115,'장성태','jangsungtae',4,'9507211234567',str_to_date('1995-07-21','%Y-%m-%d'),'055)629-2475',178,73,201,301,1007);

insert into student values (
951215,'하정환','hajunghwan',4,'9508271234567',str_to_date('1995-08-27','%Y-%m-%d'),'02)6122-2554',176,71,202,101,1008);

commit;


create table pointitem 
( no  integer(3) ,
  name varchar(15) ,
  spoint  integer(8) ,
  epoint  integer(8) );

insert into pointitem values(1,'데이터케이블',100,1000);
insert into pointitem values(2,'가정용충전기',1001,2000);
insert into pointitem values(3,'이어폰',2001,3000);
insert into pointitem values(4,'프린트잉크',3001,4000);
insert into pointitem values(5,'무선마우스',4001,5000);
insert into pointitem values(6,'무선키보드',5001,6000);
insert into pointitem values(7,'외장충전기',6001,7000);
insert into pointitem values(8,'외장하드',7001,8000);
insert into pointitem values(9,'프린트',8001,9000);
insert into pointitem values(10,'모니터',9001,10000);
commit ;


create table guest 
(no  integer(8) primary key,
 name varchar(12) ,
 point integer) ;

insert into guest values (20170001,'강동균',980);
insert into guest values (20170002,'성건민',730);
insert into guest values (20170003,'이용주',320);
insert into guest values (20170004,'김수영',6500);
insert into guest values (20170005,'남소희',1800);
insert into guest values (20170006,'김윤영',1530);
insert into guest values (20170007,'신은지',273);
insert into guest values (20170008,'오민수',3150);
insert into guest values (20170009,'박준희',5420);
insert into guest values (20170010,'임현식',2650);
insert into guest values (20170011,'최규민',1100);
insert into guest values (20170012,'박정현',9900);
insert into guest values (20170013,'안훈',4700);
insert into guest values (20170014,'김병민',2900);
insert into guest values (20170015,'노인우',4200);
insert into guest values (20170016,'이나진',5980);
insert into guest values (20170017,'박수진',6250);
insert into guest values (20170018,'송민지',6700);
insert into guest values (20170019,'주영인',7700);
insert into guest values (20170020,'허용진',7300);
commit ;

create table scorebase
(grade char(3) ,
 min_point  integer ,
 max_point  integer );

insert into scorebase values ('a+',96,100);
insert into scorebase values ('a0',90,95);
insert into scorebase values ('b+',86,89);
insert into scorebase values ('b0',80,85);
insert into scorebase values ('c+',76,79);
insert into scorebase values ('c0',70,75);
insert into scorebase values ('d',0,69);

commit;

create table p_grade
( position  varchar(10) ,
  s_age integer,
  e_age int ,
  s_year int ,
  e_year int ,
  s_pay  int ,
  e_pay  int );

insert into p_grade values ('주임',0,24,1,2,12000000,29990000);
insert into p_grade values ('대리',25,28,3,5,30000000,45000000);
insert into p_grade values ('과장',29,32,6,8,45010000,51000000);
insert into p_grade values ('차장',33,36,9,10,51010000,60000000);
insert into p_grade values ('부장',37,40,11,13,60010000,75000000);
insert into p_grade values ('이사',41,55,14,99,75010000,100000000);

commit ;


create table score (
  studno integer(4) primary key,
  kor int,
  math int,
  eng int
);

insert into score values (980111,65,75,76);
insert into score values (980212,75,65,87);
insert into score values (980313,85,95,78);
insert into score values (981113,65,75,87);
insert into score values (981213,95,95,97);
insert into score values (970111,66,55,70);
insert into score values (970212,75,100,90);
insert into score values (970313,80,55,80);
insert into score values (971115,58,56,88);
insert into score values (971211,67,87,86);
insert into score values (960111,70,65,75);
insert into score values (960212,90,85,84);
insert into score values (960315,87,95,82);
insert into score values (961115,78,69,65);
insert into score values (961215,88,59,58);
insert into score values (950115,99,89,88);
insert into score values (950211,76,68,90);
insert into score values (950315,75,87,70);
insert into score values (951115,80,78,97);
insert into score values (951215,76,85,100);
commit;

-- 페이징 처리
-- 1페이지
SELECT * FROM student ORDER BY studno LIMIT 10, 10;

-- 시작인덱스(0부터), 개수
SELECT * FROM student LIMIT 5; -- 처음부터 5개

-- 현재 날짜
SELECT NOW(), SYSDATE(), CURDATE();

-- 날짜차이 일수
SELECT DATEDIFF(NOW(),'2024-09-25');

-- 이전 / 이후 날짜
SELECT DATE_ADD(NOW(),INTERVAL 100 DAY);
SELECT DATE_sub(NOW(),INTERVAL 1 month);
SELECT DATE_ADD(NOW(),INTERVAL -100 DAY);

-- 날짜 포매팅
SELECT DATE_FORMAT(NOW(), '%Y-%m-%d');

-- null 처리
SELECT salary*12+ifnull(bonus, 0) FROM emp;

-- 조건
-- grade가 1이면 신입생, 그렇지 않으면 재학생
SELECT grade, if(grade=1, '신입생', '재학생') FROM student;

SELECT grade, if(grade=1, '신입생',
						if(grade=2, '2학년',
							if(grade=3, '3학년', '4학년')
						)
					)FROM student;
					
-- concat
SELECT CONCAT(ename, ':', job) FROM emp;
-- || 안 됨

-- 인라인뷰 alias 필수
SELECT * FROM (SELECT * FROM emp) AS a;

SELECT s. NAME
FROM student s JOIN professor p
ON s.profno = p.no;

--시퀀스
-- 대신 AI(Auto Increment)
-- test 테이블에 no(int, ai), name(varchar)
-- insert 할 때 저장 안 함
INSERT INTO test (NAME) VALUES('홍길동');
SELECT * FROM test;

INSERT INTO test (NO, NAME) VALUES(5, '홍길동');

SELECT * FROM student WHERE Id LIKE '%kIm%';

