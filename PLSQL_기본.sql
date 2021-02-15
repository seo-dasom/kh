-- 한 번 실행 후에는 계속 유지됨. 단, 지금 접속하고 있는 세션 동안에만 유지됨
SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
END;
/

DECLARE
    -- 변수 및 상수 선언부
    -- 상수 선언은 데이터타입 앞에 CONSTANT 키워드를 붙인다.
    -- 변수명 데이터타입;   변수명 데이터타입 := 초기값;
    -- 변수명 CONSTANT 데이터타입 := 초기값;
    n NUMBER := 10;
    s VARCHAR2(100) := '문자열';
BEGIN
    -- 실행부
    n := n + 1;
    s := '값 수정';
    DBMS_OUTPUT.PUT_LINE(n);
    DBMS_OUTPUT.PUT_LINE(s);
END;
/


DECLARE
    -- 변수의 데이터 타입을 기존 테이블의 컬럼이 가지는 타입을 참조하여 사용.
    -- 테이블명. 컬럼명%TYPE 의 구문형식을 사용
    salary employees.salary%TYPE;
    name employees.first_name%TYPE;
BEGIN
    -- 실행부
    salary := 1000;
    name := '서다솜';
    DBMS_OUTPUT.PUT_LINE(salary);
    DBMS_OUTPUT.PUT_LINE(name);
END;
/


DECLARE
    -- 변수의 데이터 타입을 기존 테이블의 컬럼이 가지는 타입을 참조하여 사용.
    -- 테이블명. 컬럼명%TYPE 의 구문형식을 사용
    salary employees.salary%TYPE;
    name employees.first_name%TYPE;
    input VARCHAR(10);
BEGIN
    input := '107';
    -- 실행부
    SELECT emp.SALARY
        , emp.first_name || ' ' || emp.last_name
        INTO salary, name
    FROM employees emp
    WHERE emp.employee_id = input;  -- &변수명 형식으로 사용하면 사용자 입력을 받을 수 있다.
    DBMS_OUTPUT.PUT_LINE(name || '님의 급여 : ' || salary || ' 달러');
END;
/


DECLARE
    /*
        제어문은 다음의 구문 형식을 가진다.
            IF 조건식 THEN
                실행코드
            ELSIF 조건식 THEN      // ELSIF 생략 가능, 반복사용 가능
                실행코드
            ELSE                           // ELSE 생략 가능
                실행코드
            END IF;
    */
    salary employees.salary%TYPE;
    name employees.first_name%TYPE;
    level VARCHAR(12);
    input VARCHAR(10);
BEGIN
     input := '108';
     level := '저소득';

    SELECT emp.SALARY
        , emp.first_name || ' ' || emp.last_name
        INTO salary, name
    FROM employees emp
    WHERE emp.employee_id = input;
    
    IF salary BETWEEN 0 AND 2500 THEN
        level := '저소득';
    ELSIF salary BETWEEN 2500 AND 5000 THEN
        level := '중간소득';
    ELSIF salary BETWEEN 5000 AND 7500 THEN
        level := '고소득';
    ELSE
        level := '최고소득';
    END IF;
    DBMS_OUTPUT.PUT_LINE(name || '님의 급여 : ' || salary || ' 달러로 ' || level || ' 입니다.');
END;
/


    /*
        반복문은 LOOP, WHILE LOOP, FOR LOOP 가 있으면 사용 형식은 다음과 같다.
        -- LOOP : 종료 조건이 없으면 무한 반복(EXIT 키워드로 종료 가능)
            LOOP
                반복 실행 코드
            END LOOP;
        
        -- WHILE LOOP : 종료 조건이 없으면 무한 반복(EXIT 키워드로 종료 가능)
            WHILE 조건식 LOOP
                반복 실행 코드
            END LOOP;
        
        -- FOR LOOP : 지정한 범위(숫자, SELECT 결과) 안에서의 반복
            FOR 변수명 IN 범위 LOOP
                반복 실행 코드
            END LOOP;
        
        FOR LOOP 에서 숫자 범위는 다음의 형식을 사용한다.
        시작값..종료값
        1 부터 10 까지 반복 -> FOR n IN 1..10 LOOP
        
    */
DECLARE
    cnt NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('반복 횟수 : ' || cnt);
        cnt := cnt + 1;
        --IF cnt > 10 THEN
        --    EXIT;
        --END IF;
        EXIT WHEN cnt > 10;
    END LOOP;
END;
/


DECLARE
    cnt NUMBER := 1;
BEGIN
    WHILE cnt < 10 LOOP
        DBMS_OUTPUT.PUT_LINE('WHILE 반복 횟수 : ' || cnt);
        cnt := cnt + 1;
    END LOOP;
END;
/


BEGIN
    FOR n IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE('FOR 반복 횟수 : ' || n);
    END LOOP;
END;
/


BEGIN
    FOR row_data IN (SELECT emp.employee_id, emp.salary FROM employees emp)  LOOP
        DBMS_OUTPUT.PUT_LINE(row_data.employee_id || ' 사번의 급여는 ' || row_data.salary || ' 달러 입니다.');
    END LOOP;
END;
/



/*
    %ROWTYPE 변수 : 변수에 저장하는 데이터 타입을 특정 테이블이 사용하는 컬럼의
    데이터 타입을 그대로 사용할 수 있게 만드는 타입
*/
DECLARE
    row_data employees%ROWTYPE;
BEGIN
    SELECT employee_id, first_name, last_name, salary
    INTO row_data.employee_id, row_data.first_name, row_data.last_name, row_data.salary
    FROM employees
    WHERE employee_id = '100';
    
    DBMS_OUTPUT.PUT_LINE(row_data.employee_id);
    DBMS_OUTPUT.PUT_LINE(row_data.first_name);
    DBMS_OUTPUT.PUT_LINE(row_data.last_name);
    DBMS_OUTPUT.PUT_LINE(row_data.salary);
END;
/


/*
    배열 : ORACLE에서는 테이블 타입을 배열처럼 사용
*/
DECLARE
    TYPE ARR_TYPE IS VARRAY(10) OF NUMBER;  -- 배열의 크기 고정
    n ARR_TYPE := ARR_TYPE(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  -- 초기화 필수
    
    TYPE VARR_TYPE IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;
    m VARR_TYPE;
    
    TYPE TARR_TYPE IS TABLE OF NUMBER INDEX BY VARCHAR2(5);
    j TARR_TYPE;
    
    TYPE REC_TYPE IS RECORD (
        rec_id VARCHAR2(10),
        rec_name VARCHAR2(50),
        rec_num NUMBER
    );
    rec REC_TYPE;
BEGIN
    FOR i IN 1..9 LOOP
        n(i) := 1000 + (100 * i);
        DBMS_OUTPUT.PUT_LINE(i || '인덱스에 저장된 값 : ' || n(i));
    END LOOP;
    
    FOR i IN 1..5 LOOP
        m(i) := 1000 + (200 * i);
        DBMS_OUTPUT.PUT_LINE(i || '인덱스에 저장된 값 : ' || m(i));
    END LOOP;
    
    j('a') := 65;
    j('b') := 66;
    j('c') := 67;
    
    DBMS_OUTPUT.PUT_LINE('a 인덱스에 저장된 값 : ' || j('a'));
    DBMS_OUTPUT.PUT_LINE('b 인덱스에 저장된 값 : ' || j('b'));
    DBMS_OUTPUT.PUT_LINE('c 인덱스에 저장된 값 : ' || j('c'));
    
    rec.rec_id := '123456789';
    rec.rec_name := '서다솜';
    rec.rec_num := 3000000;
    DBMS_OUTPUT.PUT_LINE(rec.rec_id);
    DBMS_OUTPUT.PUT_LINE(rec.rec_name);
    DBMS_OUTPUT.PUT_LINE(rec.rec_num);
    
    SELECT employee_id, first_name, salary
    INTO rec
    FROM employees
    WHERE employee_id = '100';
    DBMS_OUTPUT.PUT_LINE(rec.rec_id);
    DBMS_OUTPUT.PUT_LINE(rec.rec_name);
    DBMS_OUTPUT.PUT_LINE(rec.rec_num);
END;
/


/*
    사원 테이블의 commission_pct 컬럼의 값이 있는 항목들만 추려내어
    연말 보너스 지급 내역 테이블에 데이터를 추가할 PL/SQL 구문을 작성
    
    연말 보너스 지급 내역 테이블의 구조는 다음과 같다.
        TABLE NAME : YEAR_BONUS
        COLUMN
            ID                        NUMBER            // 기본키, 자동증가기능 활용
            YEAR                  CHAR(4)             // 4자리 년도만 저장된다.
            EMPLOYEE_ID    VARCHAR2(10)   // 보너스를 지급한 사원 ID
            BONUS                NUMBER           // 지급한 보너스 금액 (SALARY * COMMISSION_PCT)
*/

/* 시퀸스 오브젝트 생성 */
CREATE SEQUENCE SEQ_YEAR_BONUS_ID NOCYCLE NOCACHE;

/* 연말 보너스 지급 내역 테이블 생성 */
CREATE TABLE YEAR_BONUS (
      ID                     NUMBER            CONSTRAINT YEAR_BONUS_ID_PK PRIMARY KEY
    , YEAR               CHAR(4)
    , EMPLOYEE_ID VARCHAR2(10)
    , BONUS             NUMBER
);

DECLARE
    saved CHAR(1) := 'N';
BEGIN
    -- 이미 저장된 데이터가 있는 경우 추가가 되지 않도록 한다.
    -- 이미 저장된 데이터를 확인하는 방법은 YEAR, EMPLOYEE_ID를 조회하여
    -- 검색된 결과가 있는 것을 체크 한다.
    FOR rec IN  (SELECT EXTRACT(YEAR FROM SYSDATE) AS "년도"
                        , emp.employee_id AS "사번"
                        , emp.salary * emp.commission_pct AS "보너스금액"
                        FROM employees emp
                        WHERE emp.commission_pct IS NOT NULL) LOOP
        SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.년도 AND EMPLOYEE_ID = rec.사번) THEN
                'Y'
                ELSE 'N' END
            INTO saved
            FROM DUAL;
        
        IF saved = 'N' THEN
            INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.년도, rec.사번, rec.보너스금액);
            --DBMS_OUTPUT.PUT_LINE('추가됨!!!');
        --ELSE
            --DBMS_OUTPUT.PUT_LINE('추가 안함!!!');
        END IF;
    END LOOP;
END;
/


/* 프로시저 생성 */
CREATE OR REPLACE PROCEDURE PROC_TEMP1
IS
    -- DECLARE 에서 변수 선언한 부분을 여기에 작성
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello Procedure');
END;
/

EXECUTE proc_temp1;

SELECT * FROM USER_SOURCE WHERE NAME = 'PROC_TEMP1';

CREATE OR REPLACE PROCEDURE PROC_YEAR_BONUS
IS
BEGIN
    DECLARE
        saved CHAR(1) := 'N';
    BEGIN
        FOR rec IN  (SELECT EXTRACT(YEAR FROM SYSDATE) AS "년도"
                            , emp.employee_id AS "사번"
                            , emp.salary * emp.commission_pct AS "보너스금액"
                            FROM employees emp
                            WHERE emp.commission_pct IS NOT NULL) LOOP
            SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.년도 AND EMPLOYEE_ID = rec.사번) THEN
                    'Y'
                    ELSE 'N' END
                INTO saved
                FROM DUAL;
            
            IF saved = 'N' THEN
                INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                    VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.년도, rec.사번, rec.보너스금액);
            END IF;
        END LOOP;
    END;
END;
/

SELECT * FROM USER_SOURCE WHERE NAME = 'PROC_YEAR_BONUS';
SELECT * FROM YEAR_BONUS;
DELETE FROM YEAR_BONUS;

EXECUTE PROC_YEAR_BONUS;



/* 매개변수가 있는 프로시저 생성 */
CREATE OR REPLACE PROCEDURE PROC_TEMP2(
          x IN NUMBER       -- IN : 외부에서 받을 매개변수
        , y IN VARCHAR2
        , res OUT NUMBER -- OUT : 외부에서 참조 할 수 있게 만들 매개변수
)
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('외부에서 전달한 x 값 : ' || x);
    DBMS_OUTPUT.PUT_LINE('외부에서 전달한 y 값 : ' || y);
    res := 1;
END;
/

DECLARE
    res NUMBER;
BEGIN
    -- BEGIN 안에서 프로시저 실행 할 때는 EXECUTE 필요 없다.
    proc_temp2(10, '문자열', res);
    DBMS_OUTPUT.PUT_LINE('프로시저에서 설정한 res 값 : ' || res);
END;
/

/* PL/SQL 구문 밖에 변수 선언 및 사용 */
VARIABLE var1 NUMBER;
VARIABLE var2 VARCHAR2(10);
VARIABLE res NUMBER;

EXECUTE :var1 := 10;
EXECUTE :var2 := '문자열';

EXECUTE proc_temp2(:var1, :var2, :res);
PRINT res;



CREATE OR REPLACE PROCEDURE PROC_YEAR_BONUS2(
           RES OUT NUMBER        -- 반영 결과 수
        ,  YEAR IN VARCHAR2 := EXTRACT(YEAR FROM SYSDATE) -- 기본값 설정
)
IS
BEGIN
    DECLARE
        saved CHAR(1) := 'N';
    BEGIN
        RES := 0;
        FOR rec IN  (SELECT YEAR AS "년도"
                            , emp.employee_id AS "사번"
                            , emp.salary * emp.commission_pct AS "보너스금액"
                            FROM employees emp
                            WHERE emp.commission_pct IS NOT NULL) LOOP
            SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.년도 AND EMPLOYEE_ID = rec.사번) THEN
                    'Y'
                    ELSE 'N' END
                INTO saved
                FROM DUAL;
            
            IF saved = 'N' THEN
                INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                    VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.년도, rec.사번, rec.보너스금액);
                RES := RES + 1;
            END IF;
        END LOOP;
    END;
END;
/

DECLARE
    RES NUMBER;
BEGIN
    PROC_YEAR_BONUS2(RES);
    DBMS_OUTPUT.PUT_LINE('실행 결과 반영 수 : ' || RES);
    
    PROC_YEAR_BONUS2(RES, '2020');
    DBMS_OUTPUT.PUT_LINE('실행 결과 반영 수 : ' || RES);
END;
/



CREATE OR REPLACE FUNCTION FUNC_YEAR_BONUS(
        YEAR VARCHAR2       -- 매개변수
) RETURN NUMBER         -- 반환할 값의 타입을 정의
IS
    RES NUMBER;
BEGIN
    DECLARE
        saved CHAR(1) := 'N';
    BEGIN
        RES := 0;
        FOR rec IN  (SELECT YEAR AS "년도"
                            , emp.employee_id AS "사번"
                            , emp.salary * emp.commission_pct AS "보너스금액"
                            FROM employees emp
                            WHERE emp.commission_pct IS NOT NULL) LOOP
            SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.년도 AND EMPLOYEE_ID = rec.사번) THEN
                    'Y'
                    ELSE 'N' END
                INTO saved
                FROM DUAL;
            
            IF saved = 'N' THEN
                INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                    VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.년도, rec.사번, rec.보너스금액);
                RES := RES + 1;
            END IF;
        END LOOP;
        RETURN RES;
    END;
END;
/
SELECT FUNC_YEAR_BONUS('2021') FROM DUAL;   -- 함수 실행

VARIABLE RES NUMBER;
EXEC :RES := FUNC_YEAR_BONUS('2021');
PRINT RES;

/* 생성된 함수 확인 */
SELECT * FROM USER_SOURCE WHERE NAME = 'FUNC_YEAR_BONUS';



/*
    YEAR2T04() FUNCTION 구현해보기
        - 이 함수는 2자리 년도 형식의 날짜 문자열을 4자리 형식의 날짜 문자열로 변환하는 함수다.
        - 기본적으로 70 ~ 99 까지는 1970 ~ 1999 로 변환하고 00 ~ 69 까지는 2000 ~ 2069로 변환 시키게 한다.
        - 변환기준에 따라 20세기는 1970 ~ 2069 년으로 반환하게 하고 21세기는 2070 ~ 2169로 변환 시키게 한다.(기본값은 20세기다.)
*/

/*
    JUMNtoDATE() FUNCTION 구현해보기
        - 이 함수는 주민등록번호 앞자리 7자리를 이용하여 날짜로 변환하는 함수다.
        - 주민등록번호 앞 6자리는 생년월일을 표시하며, 년도는 2자리 년도이다. 이를 날짜로 변환을 한다.
        - 주민등록번호의 7번째 자리는 남/여 구분을 하지만 1800년도 1900년도 2000년도 세기 구분을 할 수 있다.
          1, 2는 1900 ~ 1999년 3, 4는 2000 ~ 2099년 9, 0은 1800 ~ 1899년 형식이다. (5 ~ 8 외국인)
        - 하이픈이 있는 주민번호 형식 또는 하이픈이 없는 주민번호 형식에 대해 동작하도록 한다.
*/