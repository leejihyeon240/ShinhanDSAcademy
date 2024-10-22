DBMS에 접속하기 위해 필요한 정보
- 호스트(아이피, 도메인)
- 포트번호
- 아이디
- 비밀번호
- SID(Service ID) / DB(스키마)명

Data - 자료
Base - 기반
DataBase(DB) - 자료 모아 놓은 것
DBMS

DIKW 피라미드

구조 - 순서, 계층

SQL - Structured Qurey Language

2차원(2D) 데이터
차원 : Dimension

1차원 배열 : {1, 2, 3, 4, 5}
2차원 배열 : { {1,2,3} , {4, 5, 6} {7,8,9} }

RDBMS : Relation DB (관계형 데이터베이스)

설계(모델링)

논리적 모델링 -------- 물리적 모델링
개체(Entity)                  테이블(table)
속성(Attribute)             컬럼(colum)
관계(Relationship)        키(PK, FK)

DQL(Query) : 질의
DML(Manipulation) : 운용
DDL(Definition) : 정의
DCL(conrtrol) : 제어

TCL(Transaction Control)
트랜잭션 : 하나의 논리적 작업 단위

행 : row, 로우, 레코드, 튜플
열 : colum, 컬럼, 속성, 특성, 특징, 피쳐

Oracle SQL
- 대소문자 구분 없음
- 띄어쓰기, 줄바꿈 제한 없음
- 하나의 실행문 끝에 ; (종료의 의미)

not : 반대
is null : null인지?
union all : 합친다
like : 문자 찾기 % : 0자 이상 - 검색할 때 '%변수명%' -> 변수명이 들어있는 값 검색
* 조건식은 행마다 연산

function
y = f(x)
