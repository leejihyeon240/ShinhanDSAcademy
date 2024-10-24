SELECT
    id,
    CASE 
        WHEN 140000 <= distance  THEN
            'DIAMOND'
        WHEN 100000 <= distance
                   AND distance < 130000 THEN
            'GOLD'
        WHEN 50000 <= distance
                   AND distance < 100000 THEN
            'SILVER'
        ELSE
            'BRONZE'
    END AS tier
FROM game_users
ORDER BY id desc;

--CREATE TABLE "GAME_USERS" (	
--	"ID" VARCHAR2(20 BYTE), 
--	"DISTANCE" NUMBER, 
--	"TIME_SPENT" NUMBER, 
--	"BEST_DATE" DATE
-- );
--
--insert into game_users values ('gamer2', 141900, 6.131903793, to_date('2016-11-21 07:00:38', 'YYYY-MM-DD HH24:MI:SS'));
--insert into game_users values ('aymogul500', 110000, 8.111473256, to_date('2016-11-19 16:17:26', 'YYYY-MM-DD HH24:MI:SS'));
--insert into game_users values ('abcdef', 65000, 4.093933119, to_date('2016-12-04 19:45:02', 'YYYY-MM-DD HH24:MI:SS'));
--insert into game_users values ('hola201', 5321, 5.694752452, to_date('2016-12-04 04:47:58', 'YYYY-MM-DD HH24:MI:SS'));
--commit;