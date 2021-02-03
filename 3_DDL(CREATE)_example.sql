
CREATE TABLE mytable(
              col1 CHAR(10),
              col2 NVARCHAR2(10),
              col3 NUMBER,
              col4 NUMBER(5),
              col5 NUMBER(5, 2)
);

/* 테이블 삭제 */
DROP TABLE mytable;

/* 현재 접속 계정에서 사용할 수 있는 Table 목록 검색 */
SELECT * FROM TAB;

/* 지정한 테이블의 컬럼 정보 출력 */
DESC mytable;

COMMENT ON COLUMN mytable.col1 IS '주석테스트1';