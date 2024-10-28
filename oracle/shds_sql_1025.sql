/*
조인(join)
- 여러개의 테이블과 테이블을 연결해서 조회하는 기법

조인의 종류
- 크로스 조인(cross join) : 가능한 모든 조합 행
- 등가 조인(equi join) : 조건이 일치하는 결과
- 비등가 조인(non equi join) : 등가 조인이 아닌 것
- 자체 조인(self join) : 자기 테이블끼리 조인ㅣㅇ
- 외부 조인(outer join) : 양쪽 테이블의 일치하지 않는 
*/

-- cross join
SELECT
    *
FROM
    emp,
    dept; -- emp:14개, dept:4개 = 14*4 = 56개

-- equi join
SELECT
    *
FROM
    emp,
    dept
WHERE
    emp.deptno = dept.deptno; -- emp테이블의 FK(deptno), dept 테이블의 PK(deptno)

-- non-equi join
SELECT
    *
FROM
    emp,
    salgrade
WHERE
    sal BETWEEN losal AND hisal;

-- self join
-- 직원명, 상사명
SELECT
    e1.ename,
    e2.ename
FROM
    emp e1,
    emp e2 -- e1 직원 테이블, e2 상사 테이블
WHERE
    e1.mgr = e2.mgr; -- e1테이블의 FK(mgr), e2테이블의 PF(empno)4

-- oracle -> ansi
-- , -> join where -> on
SELECT
    *
FROM
         emp e
    JOIN dept d ON e.deptno = d.deptno;

-- ansi outer join
SELECT
    *
FROM
    emp  e
    RIGHT JOIN dept d ON e.deptno = d.deptno;

 -- inner/outer 생략 가능

-- oracle 방식과 ansi 방식 차이점
-- 여러 테이블을 조인하는 경우
-- oracle : a,b,c => from a,,b,c where a.x=b.x and b.x=c.x and c.x=a.x
-- ansi : a,c,c => from a join b on a.x

-- 조인할 때 조건의 개수 : 테이블 개수 -1

-- 서브쿼리(sub-query)
-- 쿼리 안에 쿼리(selcet 문 앞에 select문) => 중첩

SELECT
    *
FROM
    emp
WHERE
    sal > 2975;

-- subquery (select절 : 스칼라 서브쿼리)
-- 직원명, 상사명
SELECT
    ename,
    (
        SELECT
            ename
        FROM
            emp
        WHERE
            empno = e.mgr
    )
FROM
    emp e;

-- 직원명, 부서명
SELECT
    ename,
    (
        SELECT
            dname
        FROM
            dept
        WHERE
            deptno = e.deptno
    )
FROM
    emp e;
    
-- 서브쿼리 실행 횟수 = 1+n

-- 페이징 처리
-- 직원명으로 정렬해서 2페이지 조회(페이지당 개수 5개)
-- 2페이지 ? ~ ? / 6~ 10
-- 시작값 : (요청한 페이지-1) * 페이지당 개수 + 1
-- 종료값 : 요청한 페이지 * 페이지당 개수
SELECT
    *
FROM
    (
        SELECT
            ROWNUM rn,
            ename
        FROM
            (
                SELECT
                    ename
                FROM
                    emp
                ORDER BY
                    ename
            ) a
    ) b
WHERE
    b.rn BETWEEN 1 AND 5;

-- 10-1
CREATE TABLE dept_temp
    AS
        SELECT
            *
        FROM
            dept;

-- 10-3
INSERT INTO dept_temp (
    deptno,
    dname,
    loc
) VALUES ( 50,
           'DATABASE',
           'SEOUL' );

SELECT
    *
FROM
    dept_temp;

INSERT INTO dept_temp (
    deptno,
    dname,
    loc
) VALUES ( 600,
           'DATABASE',
           '' );

-- 10-4
INSERT INTO dept_temp VALUES ( 60,
                               'NETWORK',
                               'BUSAN' );

SELECT
    *
FROM
    dept_temp;

-- 10-5
INSERT INTO dept_temp (
    deptno,
    dname
) VALUES ( 70,
           'WEB' );

SELECT
    *
FROM
    dept_temp;

-- 10-6
INSERT INTO dept_temp (
    deptno,
    dname,
    loc
) VALUES ( 80,
           'MOBILE',
           '' );

SELECT
    *
FROM
    dept_temp;

-- 10-8
CREATE TABLE emp_temp
    AS
        SELECT
            *
        FROM
            emp
        WHERE
            1 <> 1;

-- 10-9
INSERT INTO emp_temp (
    empno,
    ename,
    job,
    mgr,
    hiredate,
    sal,
    comm,
    deptno
) VALUES ( 999,
           '홍길동',
           'PRESIDENT',
           NULL,
           '2001/01/01',
           5000,
           1000,
           10 );

INSERT INTO emp_temp (
    empno,
    ename,
    job,
    mgr,
    hiredate,
    sal,
    comm,
    deptno
) VALUES ( 1111,
           '성춘향',
           'MANAGER',
           999,
           '2001/01/01',
           5000,
           1000,
           10 );

SELECT
    *
FROM
    emp_temp;

SELECT
    to_char(hiredate, 'YYYY-MM-DD HH:mi:ss')
FROM
    emp;

CREATE TABLE dept_temp2
    AS
        SELECT
            *
        FROM
            dept;

SELECT
    *
FROM
    dept_temp2;

UPDATE dept_temp2
SET
    loc = 'SEOUL';

SELECT
    *
FROM
    dept_temp2;

UPDATE dept_temp2
SET
    dname = 'DATABASE',
    loc = 'SEOUL'
WHERE
    deptno = 40;

SELECT
    *
FROM
    dept_temp2;

-- 10-19
UPDATE dept_temp2
SET
    ( dname,
      loc ) = (
        SELECT
            dname,
            loc
        FROM
            dept
        WHERE
            deptno = 40
    )
WHERE
    deptno = 40;

SELECT
    *
FROM
    dept_temp2;

-- 10-20
UPDATE dept_temp2
SET
    dname = (
        SELECT
            dname
        FROM
            dept
        WHERE
            deptno = 40
    ),
    loc = (
        SELECT
            loc
        FROM
            dept
        WHERE
            deptno = 40
    )
WHERE
    deptno = 40;

SELECT
    *
FROM
    dept_temp2;
    
-- 10-23
delete from emp_temp2 where job='MANAGER';
select * from emp_temp2;

create table dept_tcl as select * from dept;
select * from dept_tcl;

delete from dept_tcl where deptno=40;
select * from dept_tcl;

rollback;

delete from dept_tcl where deptno=40;
select * from dept_tcl;

commit;


delete from dept_tcl;
commit;


delete from dept_tcl where deptno=20;
update dept_tcl set loc='SEOUL' where deptno=30;

commit;

update dept_tcl set loc='SEOUL' where deptno=30;
select * from dept_tcl;

commit;

CREATE TABLE "TESTUSER"."EMP_DDL" 
   (	"EMPNO" NUMBER(4,0), 
	"ENAME" VARCHAR2(10), 
	"JOB" VARCHAR2(9), 
	"MGR" NUMBER(4,0), 
	"HIREDATE" DATE, 
	"SAL" NUMBER(7,2), 
	"COMM" NUMBER(7,2), 
	"DEPTNO" NUMBER(2,0)
);


create table emp_alter as select * from emp;
select * from emp_alter;

alter table emp_alter add hp varchar2(20);
alter table emp_alter rename column hp to tel;

select * from dictionary;
select * from user_tables;

-- 인덱스
-- 13-8
select * from user_indexes;

-- 13-10
-- 생성 : create index 인덱스명 on 테이블명(컬럼명);
create index idx_emp_sal on emp(sal);

-- 실행계획
explain plan for select * from emp where ename = 'JONES';
select * from table(dbms_xplan.display);

-- emp테이블의 ename컬럼에 인덱스 적용
create index idx_emp_ename on emp(ename);


select * from emp where empno = 7499;
