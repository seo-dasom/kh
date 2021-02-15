/*
    직원ID, 성, 이름, 이메일, 전화번호, 부서명, 직급명 을 출력하는 VIEW 생성
    VIEW 이름은 v_emp_info
*/

-- 1. SELECT 구문을 사용하여 조회 결과 확인
-- 2. 확인된 내용이 맞으면 VIEW 생성

CREATE OR REPLACE VIEW V_EMP_INFO(ID, FNAME, LNAME, EMAIL, PHONE, DEPT, JOB)
    AS SELECT e.employee_id
        , e.first_name
        , e.last_name
        , e.email
        , e.phone_number
        , d.department_name
        , j.job_title
    FROM employees e
    JOIN departments d ON (e.department_id = d.department_id)
    JOIN jobs j ON (e.job_id = j.job_id)
    ORDER BY e.employee_id;

SELECT * FROM V_EMP_INFO;

SELECT * FROM USER_VIEWS;

/*
    부서별 인원을 파악할 수 있는 VIEW 생성
    VIEW 이름은 V_NUM_OF_DEPTS 으로 한다.
*/
CREATE OR REPLACE VIEW V_NUM_OF_DEPTS
    AS SELECT d.department_name AS "부서명"
        , COUNT(*) AS "인원"
    FROM employees e
    JOIN departments d ON (e.department_id = d.department_id)
    GROUP BY department_name
    WITH READ ONLY;

SELECT * FROM V_NUM_OF_DEPTS ORDER BY 인원 DESC;

/*
    각 부서의 담당 매니저 정보와 부서 위치를 출력하는 VIEW 생성
    (매니저가 존재하는 정보만 출력)
        employees : 사원정보 테이블
        departments : 부서정보 테이블(매니저 정보 포함)
        locations : 부서위치정보 테이블
        countries : 국가정보 테이블
        regions : 대륙정보 테이블
    모든 출력 정보는 매니저의 employee_id 를 제외하고는 id 값이 출력되지 않게 한다.
    VIEW 이름은 V_DEPT_DETAIL 으로 한다.
*/
CREATE OR REPLACE VIEW V_DEPT_DETAIL
    AS SELECT e.employee_id AS "사번"
        , e.first_name || ' ' || e.last_name AS "사원명"
        , d.department_name AS "부서명"
        , (SELECT region_name FROM regions WHERE c.region_id = region_id) AS "대륙"
        , c.country_name AS "국가"
        , NVL(l.state_province, ' ') AS "주"
        , l.street_address AS "도로주소"
        , NVL(l.postal_code, ' ') AS "우편번호"
    FROM departments d
    JOIN employees e ON (d.manager_id = e.employee_id)
    JOIN locations l ON (d.location_id = l.location_id)
    JOIN countries c ON (l.country_id = c.country_id)
    WITH READ ONLY;

SELECT * FROM V_DEPT_DETAIL;



CREATE SEQUENCE EMP_SEQ_ID
    START WITH 1 INCREMENT BY 1
    MAXVALUE 127 NOCYCLE NOCACHE;

SELECT EMP_SEQ_ID.NEXTVAL FROM DUAL;
SELECT EMP_SEQ_ID.CURRVAL FROM DUAL;

CREATE TABLE TMP_TABLE (
      SEQ_ID NUMBER PRIMARY KEY
    , CONTEXT VARCHAR2(100)
);

CREATE SEQUENCE TMP_TABLE_SEQ_ID
    START WITH 1 INCREMENT BY 1
    MAXVALUE 127 NOCYCLE NOCACHE;

INSERT INTO TMP_TABLE VALUES(TMP_TABLE_SEQ_ID.NEXTVAL, 'a');
INSERT INTO TMP_TABLE VALUES(TMP_TABLE_SEQ_ID.NEXTVAL, 'a');
INSERT INTO TMP_TABLE VALUES(TMP_TABLE_SEQ_ID.NEXTVAL, 'a');
INSERT INTO TMP_TABLE VALUES(TMP_TABLE_SEQ_ID.NEXTVAL, 'a');
INSERT INTO TMP_TABLE VALUES(TMP_TABLE_SEQ_ID.NEXTVAL, 'a');
INSERT INTO TMP_TABLE VALUES(TMP_TABLE_SEQ_ID.NEXTVAL, 'a');
INSERT INTO TMP_TABLE VALUES(TMP_TABLE_SEQ_ID.NEXTVAL, 'a');

SELECT * FROM TMP_TABLE;
DROP TABLE TMP_TABLE;

SELECT TMP_TABLE_SEQ_ID.CURRVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;

/* 시퀸스 오브젝트 활용 예제 */
CREATE SEQUENCE TB_CLASS_REG_SEQ
INCREMENT BY 1 NOCYCLE NOCACHE;

INSERT ALL
    INTO TB_CLASS_REG(REG_ID, STUDENT_NO, CLASS_NO)
    VALUES(TB_CLASS_REG_SEQ.NEXTVAL, STUDENT_NO, CLASS_NO)
    SELECT '2102090001' AS STUDENT_NO
        , class_no AS CLASS_NO
    FROM tb_class
    WHERE class_name in ('네트워크', '운영체제', '프로그래밍', 'PC활용');
 
INSERT ALL
    INTO TB_CLASS_REG(REG_ID, STUDENT_NO, CLASS_NO)
    VALUES(TB_CLASS_REG_SEQ.NEXTVAL, STUDENT_NO, CLASS_NO)
    SELECT '2102090002' AS STUDENT_NO
        , class_no AS CLASS_NO
    FROM tb_class
    WHERE class_name in ('운영체제', '프로그래밍', '데이터베이스', '클라우드');
 
INSERT ALL
    INTO TB_CLASS_REG(REG_ID, STUDENT_NO, CLASS_NO)
    VALUES(TB_CLASS_REG_SEQ.NEXTVAL, STUDENT_NO, CLASS_NO)
    SELECT '2102090003' AS STUDENT_NO
        , class_no AS CLASS_NO
    FROM tb_class
    WHERE class_name in ('프로그래밍', '데이터베이스', '클라우드', '네트워크');
 
SELECT * FROM TB_CLASS_REG;

SELECT TB_CLASS_REG_SEQ.CURRVAL + 1 FROM DUAL;