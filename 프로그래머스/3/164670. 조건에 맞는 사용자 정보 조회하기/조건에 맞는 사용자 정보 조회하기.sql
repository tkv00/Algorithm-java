-- 코드를 입력하세요
-- 1.중고거래 게시물 3건 이상
-- 2.아이디,닉네임,전체 주소,전화번호
-- 3. 전체 주소 : 시+도로명 주소+상세주소
-- 4. 전화번호 -삽입
-- 5. 회원 아이디 내림차순

SELECT U.USER_ID,
       U.NICKNAME,
       CONCAT(U.CITY,' ',U.STREET_ADDRESS1,' ',U.STREET_ADDRESS2) AS 전체주소,
       CONCAT(SUBSTR(U.TLNO,1,3),'-',SUBSTR(U.TLNO,4,4),'-',SUBSTR(U.TLNO,8,4)) AS 전화번호
FROM USED_GOODS_USER AS U
    INNER JOIN USED_GOODS_BOARD AS B ON U.USER_ID = B.WRITER_ID
GROUP BY B.WRITER_ID
HAVING COUNT(B.WRITER_ID) >= 3
ORDER BY U.USER_ID DESC;