### DB 연결
1. 클래스(드라이버) 로드
2. DB에 접속(host, id, pw, sid)
3. SQL 실행할 객체(statement) 생성
4. SQL(문자열) 실행
5. 실행결과 처리
6. 자원해제(close) 

### PreparedStatement
- 객체(PreparedStatemt)생성하는 메서드에 매개변수로 SQL을 넣어줌 (준비)
예) insert into 테이블명.... values(?,?,?)
- ?자리에 값을 세팅
- 실행

### 특징
- SQL Injection 공격 방어
- 문자열 처리 수월
- 속도 빠름

아이디, 비밀번호 로그인시
변수 : id, pwd

Statement 방식
String sql = "select * from member where id='"+id+"' and pwd='"+pwd+"'";
executeQuery(sql)

test / 1234
select * from member where id='test' and pwd = '1234';

id = admin' -- pwd=zdxvzsdf

select * from member where id='admin' --' and pwd = 'asdfasdf';

=> SQL Injection 공격
