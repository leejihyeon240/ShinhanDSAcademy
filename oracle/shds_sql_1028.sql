-- 13-15
CREATE VIEW vm_emp20 AS
    (
        SELECT
            empno,
            ename,
            job,
            deptno
        FROM
            emp
        WHERE
            deptno = 20
    );

SELECT
    MAX(empno) + 1
FROM
    emp;
    
-- 13-26
CREATE TABLE dept_sequence
    AS
        SELECT
            *
        FROM
            dept
        WHERE
            1 <> 1;

SELECT
    *
FROM
    dept;

-- 시퀀스 생성
CREATE SEQUENCE seq_dept_sequence_new2 INCREMENT BY 10 START WITH 10 MAXVALUE 90 MINVALUE 0 CACHE 2;

-- 시퀀스 조회
SELECT
    seq_dept_sequence.CURRVAL
FROM
    dual;

-- 시퀀스 사용한 insert
SELECT
    seq_dept_sequence.NEXTVAL
FROM
    dual;

INSERT INTO dept_sequence (
    deptno,
    dname,
    loc
) VALUES ( seq_dept_sequence.NEXTVAL,
           'DATABASE',
           'SEOUL' );

SELECT
    *
FROM
    dept_sequence;
    
-- 트리거(trigger)
-- dept_sequence 테이블에 데이터가 추가되면 '부서데이터 추가' 출력

set serveroutput on; -- 화면 출력 설정
BEGIN
    dbms_output.put_line('hello world');
END;

-- 트리거 생성
CREATE TRIGGER dept_trigger BEFORE
    INSERT -- 데이터가 insert 되기 전
     ON dept_sequence -- dept_sequence 테이블
BEGIN
    dbms_output.put_line('부서데이터 추가');
END;

INSERT INTO dept (
    dname,
    loc
) VALUES ( 'DATABASE',
           'SEOUL' );