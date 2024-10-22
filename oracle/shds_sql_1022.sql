select * from emp;
/*
어디에서 
어떻게 
무엇을 
*/
//1번 
select * from emp where ename like '%S';
//2번 
select empno, ename, job,sal, deptno from emp where job = 'SALESMAN';
//3번 
select empno,ename,job,sal,deptno from emp where (deptno= 20 or deptno = 30) and sal> 2000;
select empno,ename,job,sal,deptno from emp where deptno in (20,30) and sal> 2000;
select  empno,ename,job,sal,deptno  from emp where deptno = 30 and sal >2000;

//4번 2000보다 작고 3000보다 크고 
select 
*
from emp 
where sal < 2000 or sal > 3000 ;

//5번 
select  
    ename, empno, sal, deptno 
from emp
where ename like '%E%' and deptno = 30 and sal not between 1000 and 2000; 

//6번 
select 
    *
from emp 
where comm is null and mgr is not null and job in('MAMNAGER','CLERK') and ename not like '_L%';

--- 함수

-- 6-1
select ename, upper(ename), lower(ename), initcap(ename) from emp;

-- Jones -> JONES like '%JON%'
select * from emp where upper(ename) like upper('%jon%');

-- 6-4
select ename, length(ename) from emp;

-- 6-5
select ename, length(ename) from emp where length(ename) >= 5;

-- 6-6
select length('한글'), lengthb('한글') from dual;
-- dual 더미
select * from dual;

-- 6-7
select job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 5), substr('안녕하세요', 1, 2) from emp;

-- 6-8
select job, substr(job, -length(job)), substr(job, -length(job), 2), substr(job, -3) from emp;

select substr('abcde', -3, 1) from dual;

-- 6-15
select concat(empno, ename), concat(empno, concat(':', ename)) from emp where ename = 'SCOTT';
