/* 더미 데이터가 있는 테이블 테스트 용도로 사용 */
SELECT LENGTH('글자길이')
FROM dual;

/* LENGTH : 문자열 길이를 구하는 함수 */
SELECT first_name,
        LENGTH(first_name)  /* 행 함수 */
FROM employees;


/* INSTR */
SELECT phone_number,
    INSTR(phone_number, '.'),
    INSTR(phone_number, '.', 5),
    INSTR(phone_number, '.', 1, 2),     /* 2번째에 발생 한 위치값 */
    INSTR(phone_number, '.', 1, 3)     /* 3번째에 발생 한 위치값 */
FROM employees;


/* LPAD, RPAD */
SELECT email,
    RPAD(email || '@', 30,  '*')
FROM employees;


/* RTRIM, LTRIM, TRIM */
SELECT email,
    TRIM(RPAD(email || '@', 30)),
    RTRIM(RPAD(email || '@', 30,  '*'), '*'),
    /* BOTH, LEADING, TRAILING */
    TRIM(BOTH '*' FROM RPAD(email || '@', 30, '*'))
FROM employees;


/* SUBSTR */
SELECT phone_number,
    SUBSTR(phone_number, 1, 3),
    SUBSTR(phone_number, 5, 3),
    SUBSTR(phone_number, 9)
FROM employees;


/* LOWER, UPPER, INITCAP */
SELECT email,
    LOWER(email),
    UPPER(email),
    INITCAP(email)
FROM employees;


/* CONCAT */
SELECT email,
    CONCAT(email, '@employee.com')
FROM employees;


/* REPLACE */
SELECT phone_number,
    REPLACE(phone_number, '.', '-')
FROM employees;


/* ABS */
SELECT ABS(-10)
FROM dual;

/* MOD */
SELECT MOD(10, 3)
FROM dual;

/* ROUND */
SELECT ROUND(12.34, 1),
    ROUND(12.35, 1),
    ROUND(12.45, 1)
FROM dual;

/* FLOOR */
SELECT FLOOR(-12.3),
    FLOOR(12.3)
FROM dual;

/* TRUNC */
SELECT TRUNC(-12.3),
    TRUNC(12.3),
    TRUNC(12.34, 1)
FROM dual;

/* CEIL */
SELECT CEIL(12.3),
    CEIL(-12.3)
FROM dual;


/* SYSDATE */
SELECT SYSDATE
FROM dual;

/* ADD_MONTHS */
SELECT SYSDATE,
    ADD_MONTHS(SYSDATE, 4)
FROM dual;

/* MONTHS_BETWEEN */
SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 4)),
    MONTHS_BETWEEN(ADD_MONTHS(SYSDATE, 4), SYSDATE)
FROM dual;

/* NEXT_DAY */
SELECT NEXT_DAY(SYSDATE, '금요일'),
    NEXT_DAY(SYSDATE, '금'),
    NEXT_DAY(SYSDATE, 6)
FROM dual;

/* LAST_DAY */
SELECT LAST_DAY(SYSDATE)
FROM dual;

/* EXTRACT */
SELECT EXTRACT(YEAR FROM SYSDATE),
    EXTRACT(MONTH FROM SYSDATE),
    EXTRACT(DAY FROM SYSDATE)
FROM dual;

/* 일자 더하기/빼기 */
SELECT SYSDATE -1,
    SYSDATE + 1
FROM dual;


/* TO_CHAR :  숫자 또는 날짜를 문자열로 변환 */
SELECT TO_CHAR(10),
    TO_CHAR(10000, '999,999,999'),
    TO_CHAR(10000, 'L999,999,999'),
    TO_CHAR(SYSDATE, 'YYYY-MM-DD')
FROM dual;

/* TO_NUMBER : 문자열을 숫자로 변환 */
SELECT TO_NUMBER('10000'),
    TO_NUMBER('10,000', '999,999,999')
FROM dual;

/* TO_DATE : 문자열을 날짜로 변환 */
SELECT TO_DATE('20210201', 'YYYYMMDD')
FROM dual;