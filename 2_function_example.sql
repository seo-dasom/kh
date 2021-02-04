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


/* NVL : NULL 데이터를 대체 할 문자 또는 숫자로 변경 */
SELECT NVL(null, 0),
       NVL(null, 'a')
FROM dual;


/* DECODE : 비교하는 값 또는 컬럼이 조건식과 같으면 결과 반환 */
SELECT DECODE('a', 'a', 'a입니다', 'b', 'b입니다.'),
       DECODE('b', 'a', 'a입니다', 'b', 'b입니다.'),
       DECODE('c', 'a', 'a입니다', 'b', 'b입니다.', 'a/b가 아닙니다.')
FROM dual;

SELECT first_name, last_name,
       DECODE(department_id,
              90, 'Executive',
              60, 'IT',
              100, 'Finance',
              30, 'Purchasing',
              50, 'Shipping',
              80, 'Sales',
              null, 'None',
              10, 'Administration',
              20, 'Marketing',
              40, 'Human Resources',
              70, 'Public Relations',
              110, 'Accounting') AS "dep_name"
FROM employees;


SELECT first_name, last_name,
       CASE WHEN salary > 10000 THEN '고액연봉자'
            WHEN salary > 5000 THEN '일반연봉자'
            ELSE '저소득자'
       END AS "연봉분류"
FROM employees;


/* 문제 */
/* 1. 사원 정보를 출력 할 때 전화번호를 xxx-xxx-xxxx 형식으로 출력 될 수 있게 한다. */
SELECT employee_id, first_name, last_name,
       email, REPLACE(phone_number, '.', '-') AS "전화번호",
       hire_date, job_id, salary, commission_pct,
       manager_id, department_id
FROM employees;


/* 2. 사원의 salary 는 급여 항목이며 commission_pct 는 연봉의 보너스 항목이다. 이를 통해
      모든 사원의 이름과 연봉을 출력하시오. */
SELECT first_name, last_name,
       ((salary * 12) + salary * 12 * NVL(commission_pct, 0)) AS "연봉"
FROM employees
ORDER BY "연봉" DESC;


/* 3. 입사일로 부터 근속년이 3년, 7년, 12년에 해당하는 사원들은 추가 급여를 다음과
      같이 지급하려 한다. 조건에 맞는 추가 급여 항목을 출력하시오.
      3년 : 1000 | 7년 : 2000 | 12년 : 5000 */
SELECT first_name, last_name, hire_date,
       TRUNC((MONTHS_BETWEEN('13/02/02', hire_date) / 12), 0) AS "근속년",
       DECODE(TRUNC((MONTHS_BETWEEN('13/02/02', hire_date) / 12), 0),
              3,  1000,
              7,  2000,
              12, 5000,
              0
       ) AS "추가급여"
FROM employees
ORDER BY "근속년" DESC;


/* 4. 급여 항목을 출력 할 때는 천 자리 구분 서식을 적용하여 출력 하시오. */
SELECT employee_id, first_name, last_name,
       email, phone_number, hire_date,
       job_id, TO_CHAR(salary, '999,999') AS "급여",
       commission_pct,
       manager_id, department_id
FROM employees
ORDER BY "급여" DESC;


/* 5. 날짜 항목을 출력 할 때는 2021-01-01 서식을 적용하여 출력 하시오. */
SELECT employee_id, first_name, last_name,
       email, phone_number, TO_CHAR(hire_date, 'YYYY-MM-DD') AS "입사일",
       job_id, salary, commission_pct,
       manager_id, department_id
FROM employees
ORDER BY "입사일" ASC;


/* 그룹 함수 */
/* SUM */
SELECT SUM(salary) AS "총급여"
FROM employees;

SELECT SUM(salary) AS "총급여"
FROM employees
WHERE department_id = 100;

/* AVG */
SELECT AVG(salary) AS "평균급여"
FROM employees;

SELECT AVG(salary) AS "평균급여"
FROM employees
WHERE department_id = 100;

/* COUNT */
SELECT COUNT(*) AS "총인원"
FROM employees;

SELECT COUNT(*) AS "부서인원"
FROM employees
WHERE department_id = 100;

SELECT COUNT(*) AS "고액연봉자수"
FROM employees
WHERE salary >= 10000;

/* MAX */
SELECT MAX(salary) AS "최고액연봉자"
FROM employees;

/* MIN */
SELECT MIN(salary) AS "최저액연봉자"
FROM employees;



/* GROUP BY */
SELECT department_id,
          ROUND(AVG(salary) ,0) AS "부서별 급여평균"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY "부서별 급여평균" DESC;

/* 부서별 직원 수를 구하시오. */
SELECT department_id,
          COUNT(*) AS "부서별 직원수"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY "부서별 직원수" DESC;

/* job_id 는 직급이며, 직급별 급여 평균을 구하시오. */
SELECT job_id,
          ROUND(AVG(salary) ,0) AS "직급별 급여평균"
FROM employees
WHERE job_id IS NOT NULL
GROUP BY job_id
ORDER BY "직급별 급여평균" DESC;


/* HAVING 그룹에 대한 조건 */
SELECT department_id,
          ROUND(AVG(salary) ,0) AS "부서별 급여평균"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING department_id NOT IN (100, 110)
    AND ROUND(AVG(salary), 0) > 5000
ORDER BY "부서별 급여평균" DESC;


/* 부서 총인원이 5명 이하인 부서를 출력 */
SELECT department_id,
          COUNT(*) AS "부서별 인원"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING COUNT(*) <= 5
ORDER BY "부서별 인원" DESC;


/* ROLLUP 집계 함수 -> 하나의 컬럼만 그룹화 하여 집계한 예제 */
SELECT department_id,
       SUM(salary) AS "부서별총급여"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY ROLLUP(department_id)
ORDER BY department_id NULLS LAST;

/* CUBE -> 하나의 컬럼만 그룹화 하여 집계한 예제 */
SELECT department_id,
       SUM(salary) AS "부서별총급여"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY CUBE(department_id)
ORDER BY department_id NULLS LAST;

/* ROLLUP 집계 함수 -> 두개 이상의 컬럼을 그룹화 하여 집계한 예제 */
SELECT department_id, job_id,
       SUM(salary) AS "부서별총급여"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY ROLLUP(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;


/* CUBE -> 두개 이상의 컬럼만 그룹화 하여 집계한 예제 */
SELECT department_id, job_id,
       SUM(salary) AS "부서별총급여"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY CUBE(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;


/* 년도별 입사자 수를 집계 하시오. */
SELECT TO_CHAR(hire_date, 'YYYY') AS "년도",
          COUNT(*) AS "입사자수"
FROM employees
GROUP BY ROLLUP(TO_CHAR(hire_date, 'YYYY'));


SELECT EXTRACT(YEAR FROM hire_date) AS "년도",
          COUNT(*) AS "입사자수"
FROM employees
GROUP BY ROLLUP(EXTRACT(YEAR FROM hire_date));

/* 년도별, 분기별 입사자 수를 집계 하시오. (ROLLUP 이용)*/


/* 날짜 분기 구하는 방법 */
SELECT TO_CHAR(TO_DATE('2021/01/01', 'YYYY/MM/DD'), 'Q') AS "1분기",
          TO_CHAR(TO_DATE('2021/05/01', 'YYYY/MM/DD'), 'Q') AS "2분기",
          TO_CHAR(TO_DATE('2021/08/01', 'YYYY/MM/DD'), 'Q') AS "3분기",
          TO_CHAR(TO_DATE('2021/11/01', 'YYYY/MM/DD'), 'Q') AS "4분기"
FROM dual;


/* GROUPING 함수로 집계 대상 구분 */
SELECT department_id, job_id,
          SUM(salary) AS "부서별총급여",
          CASE WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 1 THEN '부서별 집계'
                 WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 0 THEN '해당 부서의 직급별 집계'
                 ELSE '총 집계'
          END AS "구분"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY ROLLUP(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;

/* GROUPING 함수로 집계 대상 구분 */
SELECT department_id, job_id,
          SUM(salary) AS "부서별총급여",
          CASE WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 1 THEN '부서별 집계'
                 WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 0 THEN '해당 부서의 직급별 집계'
                 WHEN GROUPING(department_id) = 1 AND GROUPING(job_id) = 0 THEN '직급별 집계'
                 ELSE '총 집계'
          END AS "구분"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY CUBE(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;


SELECT * FROM employees ORDER BY commission_pct DESC NULLS LAST;