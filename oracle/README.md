DBMS에 접속하기 위해 필요한 정보 <br>
- 호스트(아이피, 도메인) <br>
- 포트번호 <br>
- 아이디 <br>
- 비밀번호 <br>
- SID(Service ID) / DB(스키마)명 <br>

Data - 자료 <br>
Base - 기반 <br>
DataBase(DB) - 자료 모아 놓은 것 <br>
DBMS <br>

DIKW 피라미드 <br>

구조 - 순서, 계층 <br>

SQL - Structured Qurey Language <br>

2차원(2D) 데이터 <br>
차원 : Dimension <br>

1차원 배열 : {1, 2, 3, 4, 5} <br>
2차원 배열 : { {1,2,3} , {4, 5, 6} {7,8,9} } <br>

RDBMS : Relation DB (관계형 데이터베이스) <br>

설계(모델링) <br>

논리적 모델링 <br>
개체(Entity) <br>               
속성(Attribute) <br>     
관계(Relationship) <br> 

물리적 모델링 <br>
테이블(table) <br>
컬럼(colum) <br>
키(PK, FK) <br>

DQL(Query) : 질의 <br>
DML(Manipulation) : 운용 <br>
DDL(Definition) : 정의 <br>
DCL(conrtrol) : 제어 <br>

TCL(Transaction Control) <br>
트랜잭션 : 하나의 논리적 작업 단위 <br>

행 : row, 로우, 레코드, 튜플 <br>
열 : colum, 컬럼, 속성, 특성, 특징, 피쳐 <br>

Oracle SQL <br>
- 대소문자 구분 없음 <br>
- 띄어쓰기, 줄바꿈 제한 없음 <br>
- 하나의 실행문 끝에 ; (종료의 의미) <br>

not : 반대 <br>
is null : null인지? <br>
union all : 합친다 <br>
like : 문자 찾기 % : 0자 이상 - 검색할 때 '%변수명%' -> 변수명이 들어있는 값 검색 <br>
* 조건식은 행마다 연산 <br>

function <br>
y = f(x) <br>

![image](https://github.com/user-attachments/assets/7e53e6d5-4684-4a2e-995f-5708d374109a)

select 작성 전 고민 <br>
- 어디서 가져올지 <br>
- 어떻게 가져올지 <br>
- 어떤 값을 출력할지 <br>

select 구조 <br>
SELECT 컬럼명 [as 별칭]... <br>

도구 > 환경설정 > 'NLS' 검색 <br>
날짜 형식 -> YYYY- MM- DD <br>
