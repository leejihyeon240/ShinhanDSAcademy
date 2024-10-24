SELECT
    *
FROM
    emp,
    dept;

SELECT
    ename,
    dept.dname,
    dept.deptno
FROM
    emp,
    dept
WHERE
    emp.deptno = dept.deptno;

-- 8-3
SELECT
    *
FROM
    emp  e,
    dept d
WHERE
    e.deptno = d.deptno
ORDER BY
    empno;
    
-- 8-6
SELECT
    e.empno,
    e.ename,
    e.sal,
    d.deptno,
    d.dname,
    d.loc
FROM
    emp  e,
    dept d
WHERE
        e.deptno = d.deptno
    AND sal >= 3000;

-- ANSI
-- , --> JOIN, where --> ON
SELECT
    *
FROM
         emp e
    JOIN dept d ON e.deptno = d.deptno
ORDER BY
    empno;
    
-- 8-7
SELECT
    *
FROM
    emp      e,
    salgrade s
WHERE
    e.sal BETWEEN s.losal AND s.hisal;
    
-- 직원명, 상사명 출력
-- 왼쪽(직원 테이블), 오른쪽(상사테이블)
SELECT
    e1.ename,
    e2.ename
FROM
    emp e1,
    emp e2
WHERE
    e1.mgr = e2.empno;
    
/*
등가조인 --> 내부조인 (inner join)
*/

-- 부서별 직원수
SELECT
    d.dname,
    (
        SELECT
            COUNT(*)
        FROM
            emp
        WHERE
            emp.deptno = d.deptno
    ) cnt
FROM
    emp  e,
    dept d
WHERE
    e.deptno (+) = d.deptno
GROUP BY
    d.deptno,
    d.dname;

SELECT
    d.dname,
    (
        SELECT
            COUNT(*)
        FROM
            emp
        WHERE
            emp.deptno = d.deptno
    ) cnt
FROM
    dept d
    LEFT JOIN emp  e ON e.deptno = d.deptno
GROUP BY
    d.deptno,
    d.dname;
    
-- 8장
-- Q1
SELECT
    d.deptno,
    d.dname,
    e.empno,
    e.sal
FROM
    dept d,
    emp  e
WHERE
        d.deptno = e.deptno
    AND e.sal > 2000
ORDER BY
    d.deptno;

SELECT
    d.deptno,
    d.dname,
    e.empno,
    e.sal
FROM
         dept d
    JOIN emp e ON d.deptno = e.deptno
                  AND e.sal > 2000
ORDER BY
    d.deptno;
    
-- Q2
SELECT
    d.deptno,
    d.dname,
    trunc(avg(sal)) avg_sal,
    MAX(sal)        max_sal,
    MIN(sal)        min_sal,
    COUNT(*)        cnt
FROM
    dept d,
    emp  e
WHERE
    d.deptno = e.deptno
GROUP BY
    d.deptno,
    d.dname;

SELECT
    d.deptno,
    d.dname,
    trunc(avg(sal)) avg_sal,
    MAX(sal)        max_sal,
    MIN(sal)        min_sal,
    COUNT(*)        cnt
FROM
         dept d
    JOIN emp e ON d.deptno = e.deptno
GROUP BY
    d.deptno,
    d.dname;
    
-- Q3
SELECT
    d.deptno,
    d.dname,
    e.empno,
    e.ename,
    e.job,
    e.sal
FROM
    dept d,
    emp  e
WHERE
    d.deptno = e.deptno (+)
ORDER BY
    d.deptno,
    e.ename;

SELECT
    d.deptno,
    d.dname,
    e.empno,
    e.ename,
    e.job,
    e.sal
FROM
    dept d
    LEFT JOIN emp  e ON d.deptno = e.deptno (+)
ORDER BY
    d.deptno,
    e.ename;
    
-- Q4
SELECT
    d.deptno,
    d.dname,
    e1.empno,
    e1.ename,
    e1.mgr,
    e1.sal,
    e1.deptno,
    s.losal,
    s.hisal,
    s.grade,
    e2.empno mgr_empno,
    e2.ename mgr_ename
FROM
    dept     d,
    emp      e1,
    salgrade s,
    emp      e2
WHERE
        d.deptno = e1.deptno (+)
    AND e1.sal BETWEEN s.losal AND s.hisal
    AND e1.mgr = e2.empno (+)
ORDER BY
    d.deptno,
    e1.empno;
    
-- 서브쿼리 : 괄호() 안에 작성
-- 9-1
SELECT
    sal
FROM
    emp
WHERE
    ename = 'JONES';

SELECT
    *
FROM
    emp
WHERE
    sal > (
        SELECT
            sal
        FROM
            emp
        WHERE
            ename = 'JONES'
    );

SELECT
    *
FROM
    emp
WHERE
    sal IN (
        SELECT
            sal
        FROM
            emp
        WHERE
            ename = 'JONES'
    );

-- 9-4
SELECT
    *
FROM
    emp
WHERE
    hiredate < (
        SELECT
            hiredate
        FROM
            emp
        WHERE
            ename = 'SCOTT'
    );

-- 9-5
SELECT
    e.empno,
    e.ename,
    e.job,
    e.sal,
    d.deptno,
    d.dname,
    d.loc
FROM
    emp  e,
    dept d
WHERE
        e.deptno = d.deptno
    AND e.deptno = 20
    AND e.sal > (
        SELECT
            AVG(sal)
        FROM
            emp
    );
    
-- 9-7
SELECT
    *
FROM
    emp
WHERE
    sal IN (
        SELECT
            MAX(sal)
        FROM
            emp
        GROUP BY
            deptno
    );

-- 9-18
SELECT
    *
FROM
    emp
WHERE
    ( deptno, sal ) IN (
        SELECT
            deptno, MAX(sal)
        FROM
            emp
        GROUP BY
            deptno
    );
    
-- 9-19
SELECT
    e10.empno,
    e10.ename,
    e10.deptno,
    d.dname,
    d.loc
FROM
    (
        SELECT
            *
        FROM
            emp
        WHERE
            deptno = 10
    ) e10,
    (
        SELECT
            *
        FROM
            dept
    ) d
WHERE
    e10.deptno = d.deptno;
    
-- 9-20
WITH e10 AS (
    SELECT
        *
    FROM
        emp
    WHERE
        deptno = 10
), d AS (
    SELECT
        *
    FROM
        dept
)
SELECT
    e10.empno,
    e10.ename,
    e10.deptno,
    d.dname,
    d.loc
FROM
    e10,
    d
WHERE
    e10.deptno = d.deptno;
    
-- connect by(계층형 조회)
SELECT
    empno,
    ename,
    mgr
FROM
    emp
START WITH
    mgr IS NULL
CONNECT BY
    PRIOR empno = mgr;
    
-- 서브쿼리
-- Q1
SELECT
    job,
    empno,
    ename,
    sal,
    emp.deptno,
    dname
FROM
         emp
    JOIN dept ON emp.deptno = dept.deptno
                 AND job = (
        SELECT
            job
        FROM
            emp
        WHERE
            ename = 'ALLEN'
    );
    
-- Q2
SELECT
    empno,
    ename,
    (
        SELECT
            dname
        FROM
            dept
        WHERE
            deptno = emp.deptno
    ) dname,
    hiredate,
    (
        SELECT
            loc
        FROM
            dept
        WHERE
            deptno = emp.deptno
    ) loc,
    sal,
    (
        SELECT
            grade
        FROM
            salgrade
        WHERE
            emp.sal BETWEEN losal AND hisal
    ) grade
FROM
    emp
WHERE
    sal > (
        SELECT
            AVG(sal)
        FROM
            emp
    )
ORDER BY
    sal DESC,
    empno ASC;
    
-- Q4
SELECT
    empno,
    ename,
    sal,
    (
        SELECT
            grade
        FROM
            salgrade
        WHERE
            emp.sal BETWEEN losal AND hisal
    ) grade
FROM
    emp
WHERE
    sal > (
        SELECT
            MAX(sal)
        FROM
            emp
        WHERE
            job = 'SALESMAN'
    );
