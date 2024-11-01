SELECT
    *
FROM
    reservation;

SELECT
    *
FROM
    order_info;

-- 02. 매출 분석
SELECT
    COUNT(order_no)   총주문건,
    SUM(sales)        총매출합계,
    round(avg(sales)) 평균매출,
    MAX(sales)        최고매출,
    MIN(sales)        최저매출
FROM
    order_info;

-- 03. 매출 비교 분석
SELECT
    *
FROM
    order_info;

SELECT
    *
FROM
    item;

SELECT
    COUNT(order_no) 총주문건,
    SUM(sales)      총매출합계,
    SUM(
        CASE
            WHEN i.product_desc = '온라인_전용상품' THEN
                1
            ELSE
                0
        END
    )               온라인전용상품주문건,
    SUM(
        CASE
            WHEN i.product_desc = '온라인_전용상품' THEN
                sales
            ELSE
                0
        END
    )               온라인전용상품매출합계,
    round(sum(
        CASE
            WHEN i.product_desc = '온라인_전용상품' THEN
                1
            ELSE 0
        END
    ) / count(order_no),
          4) * 100  주문건수비율,
    round(sum(
        CASE
            WHEN i.product_desc = '온라인_전용상품' THEN
                sales
            ELSE 0
        END
    ) / sum(sales),
          4) * 100  매출합계비율
FROM
         order_info o
    JOIN item i ON o.item_id = i.item_id
GROUP BY
    1;
    
-- 04. 상품별 매출 분석
SELECT
    o.item_id,
    i.product_name,
    SUM(sales) 매출합계
FROM
         order_info o
    JOIN item i ON o.item_id = i.item_id
GROUP BY
    o.item_id,
    i.product_name
ORDER BY
    SUM(sales) DESC;
    
-- 05. 월별 상품 매출 분석(시계열 분석)
SELECT
    *
FROM
         order_info o
    JOIN item i ON o.item_id = i.item_id;

SELECT * 
FROM (
    SELECT i.product_name, o.sales, o.reserv_no
    FROM order_info o
    JOIN item i ON o.item_id = i.item_id
)
PIVOT (
    SUM(sales) FOR product_name IN ('SPECIAL_SET' AS SPECIAL_SET, 'PASTA' AS PASTA, 'PIZZA' AS PIZZA, 'SEA_FOOD' as SEA_FOOD, 'STEAK' as STEAK, 'SALAD_BAR' as SALAD_BAR, 'SALAD' as SALAD, 'SANDWITCH' as SANDWITCH, 'WINE' as WINE, 'JUICE' as JUICE)
)
JOIN reservation r on p.reserv_no = r.reserv_no;

WITH pivoted_sales AS (
    SELECT * 
    FROM (
        SELECT o.reserv_no, i.product_name, o.sales
        FROM order_info o
        JOIN item i ON o.item_id = i.item_id
    ) 
    PIVOT (
        SUM(sales) FOR product_name IN (
            'SPECIAL_SET' AS SPECIAL_SET, 
            'PASTA' AS PASTA, 
            'PIZZA' AS PIZZA, 
            'SEA_FOOD' AS SEA_FOOD, 
            'STEAK' AS STEAK, 
            'SALAD_BAR' AS SALAD_BAR, 
            'SALAD' AS SALAD, 
            'SANDWITCH' AS SANDWITCH, 
            'WINE' AS WINE, 
            'JUICE' AS JUICE
        )
    )
)
SELECT 
    TO_CHAR(r.reserv_date, 'YYYY-MM') AS month,
    SUM(p.SPECIAL_SET) AS SPECIAL_SET,
    SUM(p.PASTA) AS PASTA,
    SUM(p.PIZZA) AS PIZZA,
    SUM(p.SEA_FOOD) AS SEA_FOOD,
    SUM(p.STEAK) AS STEAK,
    SUM(p.SALAD_BAR) AS SALAD_BAR,
    SUM(p.SALAD) AS SALAD,
    SUM(p.SANDWITCH) AS SANDWITCH,
    SUM(p.WINE) AS WINE,
    SUM(p.JUICE) AS JUICE
FROM pivoted_sales p
JOIN reservation r ON p.reserv_no = r.reserv_no
GROUP BY 
    TO_CHAR(r.reserv_date, 'YYYY-MM')
ORDER BY 
    month;
