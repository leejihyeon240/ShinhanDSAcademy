-- 문제 --

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