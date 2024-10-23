-- 모든 공백 제거
SELECT
    replace('           a a a              ', ' ', '') AS a
FROM
    dual;

-- 6-19
SELECT
    round(1234.5678)     AS round,
    round(1234.5678, 0)  AS round_0,
    round(1234.5678, 1)  AS round_1,
    round(1234.5678, 2)  AS round_2,
    round(1234.5678, -1) AS round_minus1,
    round(1234.5678, -2) AS round_minus2
FROM
    dual;
    
-- 6-23
SELECT
    sysdate,
    sysdate - 1,
    sysdate + 1
FROM
    dual;

-- 6-24
SELECT
    sysdate,
    add_months(sysdate, 3)
FROM
    dual;

--6-27
SELECT
    empno,
    ename,
    hiredate,
    sysdate,
    months_between(hiredate, sysdate)        AS month1,
    months_between(sysdate, hiredate)        AS month2,
    trunc(months_between(sysdate, hiredate)) AS month3
FROM
    emp;

-- 6-28
SELECT
    sysdate,
    next_day(sysdate, '월요일'),
    last_day(sysdate)
FROM
    dual;

-- 6-33
SELECT
    to_char(sysdate, 'YYYY/mm/dd hh24:mi:ss') AS 현재날짜시간
FROM
    dual;

SELECT
    to_char(sysdate, 'YYYY"년" mm"월" dd"일"')
FROM
    dual;

SELECT
    to_char(sysdate, '"YYYY년 mm월 dd일"')
FROM
    dual;

-- 6-41
SELECT
    TO_NUMBER('1,300', '999,999') - TO_NUMBER('1,500', '999,999')
FROM
    dual;

-- 6-42
SELECT
    TO_DATE('2018-07-14', 'yyyy-mm-dd') AS todate1,
    TO_DATE('20180714', 'yyyy-mm-dd')   AS todate2
FROM
    dual;

-- 문자 --> 날짜
SELECT
    *
FROM
    emp
WHERE
    hiredate > '1981-06-01';

SELECT
    *
FROM
    emp
WHERE
    hiredate BETWEEN '1981-01-01' AND '1981-12-31';

-- 날짜 --> 문자
SELECT
    *
FROM
    emp
WHERE
    substr(hiredate, 1, 4) = '1981';

-- 6-45
SELECT
    sal,
    comm,
    sal + comm,
    nvl(comm, 0),
    sal + nvl(comm, 0)
FROM
    emp;

-- 6-48
SELECT
    empno,
    ename,
    job,
    sal,
    CASE job
        WHEN 'manager'  THEN
            sal * 1.1
        WHEN 'salesman' THEN
            sal * 1.05
        WHEN 'analyst'  THEN
            sal
        ELSE
            sal * 1.03
    END AS upsal
FROM
    emp;
    
-- Q1
SELECT
    empno,
    substr(empno, 1, 2)
    || '**'         AS masking_empno,
    ename,
    replace(ename,
            substr(ename, 2),
            '****') AS masking_ename,
    substr(ename, 1, 2)
    || '****'
FROM
    emp
WHERE
    length(ename) = 5;

-- Q2
SELECT
    empno,
    ename,
    sal,
    trunc(sal / 21.5, 2)     day_pay,
    round(sal / 21.5 / 8, 1) time_pay
FROM
    emp;

-- Q3
SELECT
    empno,
    ename,
    hiredate,
    next_day(
        add_months(hiredate, 3),
        '월'
    )           r_job,
    nvl2(comm,
         to_char(comm),
         'N/A') cpmm
FROM
    emp;


-- 랭킹함수(순서대로 번호 지정)
-- row_number() - 중복없이
-- rank() - 중복가능 (중복랭킹 제외)
-- dense_rank - 중복 하나로

SELECT sal,
    ROW_NUMBER()
    OVER(
        ORDER BY
            sal DESC
    ) rank1,
    RANK()
    OVER(
        ORDER BY
            sal DESC
    ) rank2,
    DENSE_RANK()
    OVER(
        ORDER BY
            sal DESC
    ) rank3
FROM
    emp;
    
-- 7-1
select avg(sal) from emp;

select count(sal), count(comm), count(*) from emp;

-- 7-17
SELECT
    AVG(sal),
    deptno
FROM
    emp
GROUP BY
    deptno;