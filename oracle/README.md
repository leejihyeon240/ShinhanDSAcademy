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

DDL (Definition) <br>
- create : 생성 <br>
- alter : 변경 <br>
- truncate : 테이블의 데이터 삭제(초기화) <br>
- drop : 삭제 <br>

index <br>
- 검색속도를 향상시키기 위해 사용하는 객체 <br>
- 데이터를 특정 기준(컬럼)으로 정렬해서 별도의 테이블 생성 <br>
- b-tree알고리즘 사용 <br>

프로젝트 진행 <br>
-  주제 선정 <br>

-  기획(회의) --> 회의록(노션 or 구글독스) <br>
= 기능정의 (기능 정의서) <br>
= 화면설계 (와이어프레임, 스토리보드) --> 피그마, ppt... <br>

- 설계 <br>
= 데이터 설계 --> ERD <br>
= 클래스 설계 (프로그램 명세서, 클래스 다이어그램) <br>

- 개발(구현) <br>
- 테스트 <br>
- 배포 <br>
- 포트폴리오 문서화 <br>

Entity - 개체 <br>
Attribute - 속성 <br>

속성의 종류 <br>
- 분해 여부에 따라 <br>
단일 속성 : 단일값 <br>
복합 속성 : 여러 의미가 합쳐진 것(주소) - 분해 가능 <br>
다중값 속성 : 여러값(범주)을 가질 수 있는 것(취미) --> 엔터티 분리(정규화) <br>

- 특성에 따라 <br>
기본 속성 : 원래 속성 <br>
설계 속성 : 모델링 과정에서 추가(번호, 코드...) <br>
파생 속성 : 다른 속성이랑 합쳐진 것에 의해서 만들어진 것(합계, 평균...) <br>

논리모델링 <br>
관계(relationship) <br>
1:1 (일대일) - 직원 : 부서 <br>
1:N (일대다) - 게시글 : 댓글 <br>
M:M (다대다) - 주문 : 상품 <br>

식별관계 : FK <br>
비식별관계 : 일반 속성 <br>


