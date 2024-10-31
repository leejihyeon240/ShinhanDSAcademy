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