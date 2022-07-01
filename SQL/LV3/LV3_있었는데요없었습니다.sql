-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

SELECT a.animal_id, a.name
FROM animal_ins as a
JOIN animal_outs as b
ON a.animal_id = b.animal_id
WHERE b.datetime <= a.datetime
ORDER BY a.datetime