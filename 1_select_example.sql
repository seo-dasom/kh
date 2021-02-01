SELECT *                 /* 컬럼명 */
FROM employees;    /* 테이블명 */

/* 검색할 컬럼을 지정 */
SELECT first_name,
           last_name
FROM employees;

--SELECT first_name,
--           last_name
--FROM jobs;

/* 컬럼명에 별칭 부여 */
SELECT  first_name AS "이름",
            last_name AS "성"
FROM employees;

/*
 별칭을 부여할 때 쌍(큰) 따옴표를 사용하거나 사용하지 않을 수 있다.
 쌍(큰) 따옴표를 사용할 때에는 공백이 있거나 특수 문자 및 숫자가 있는 경우 사용.
*/


/* 다수의 컬럼 결과를 하나의 컬럼으로 조합하여 출력 */
SELECT CONCAT(last_name, first_name) AS "이름"
FROM employees;

/* 별칭이 아닌 값으로 출력 할 때에는 작은 따옴표 */
SELECT last_name || ' ' || first_name AS "이름"
FROM employees;

/* 산술 연산 */
SELECT  SALARY AS "월급",
            (SALARY + 1000) * 12 AS "연봉"
FROM employees;

/* DISTINCT 를 사용하여 중복 데이터를 제외하고 출력 */
SELECT DISTINCT SALARY AS "월급",
            (SALARY + 1000) * 12 AS "연봉"
FROM employees;

/* WHERE 절 : 조건에 따른 결과를 출력할 수 있게 한다. */
SELECT *
FROM employees
WHERE DEPARTMENT_ID = 100;

SELECT *
FROM employees
WHERE SALARY < 2500;

SELECT *
FROM employees
WHERE DEPARTMENT_ID = 90 AND SALARY > 10000;

SELECT *
FROM employees
WHERE DEPARTMENT_ID = 90 OR SALARY > 10000;

/* 연산자 종류
    비교 연산자                      논리 연산자
        =       같다                   AND        두 조건을 모두 만족하는 결과를 조회
        >       크다                   OR          두 조건 중 하나라도 만족하는 결과를 조회
        <       작다                   NOT        조건을 만족하지 않는 결과를 조회
        >=     크거나 같다
        <=     작거나 같다
        <>     같지 않다
        !=      같지 않다
*/

/* IN 연산자 : 비교할 값이 여러개 있을 때 사용 -> column_name [NOT] IN (value1, value2, ...) */
SELECT *
FROM employees
WHERE department_id IN (90, 100, 110, 120);

SELECT *
FROM employees
WHERE department_id NOT IN (90, 100, 110, 120);

/* IS [NOT] NULL : null 값이 있는 또는 없는 컬럼을 조회할 때 사용 */
SELECT *
FROM employees
WHERE commission_pct IS NULL;

SELECT *
FROM employees
WHERE commission_pct IS NOT NULL;

/* [NOT] LIKE : 문자열에 대하 범위 조회를 할 때 사용
                    %  -> 모든 문자열을 일치 시킨다.
                    _   -> 문자 1개만 일치 시킨다.
*/
SELECT first_name,
           last_name
FROM employees
WHERE first_name LIKE 'A%';  /* A로 시작하는 문자열 */

SELECT first_name,
           last_name
FROM employees
WHERE first_name LIKE '%er';  /* er로 끝나는 문자열 */

SELECT first_name,
           last_name
FROM employees
WHERE first_name LIKE '%i%';  /* i가 포함된 문자열 */

/* [NOT] BETWEEN : 일정 범위를 조회할 때 사용(숫자, 날짜에 주로 사용) */
SELECT *
FROM employees
WHERE salary BETWEEN 2500 AND 5000; /* 값을 포함해서 검색 */

SELECT *
FROM employees
WHERE hire_date BETWEEN '05/01/01' AND '05/12/31';

/* ORDER BY 절 : 조회 데이터에 대한 정렬을 위한 절 */
SELECT *
FROM employees
ORDER BY first_name;

SELECT *
FROM employees
ORDER BY first_name DESC; /*  DESC : 내림차순 정렬 */

SELECT *
FROM employees
ORDER BY first_name, employee_id DESC;

SELECT *
FROM employees
ORDER BY 2, 1 DESC; /* 컬럼 순번으로 정렬 지정 */

SELECT employee_id AS "사번",
           first_name || ' ' || last_name AS "이름"
FROM employees
ORDER BY 이름, 사번 DESC;


SELECT * FROM employees;
/* 문제 
        1. department_id가 100, 110 인 사원 정보 조회
        2. commission_pct가 0.2 이상인 사원 정보 조회
        3. manager_id가 null 인 사원 정보 조회
        4. manager_id가 null 이 아니면서 commission_pct 가 0.25 이상인 사원 정보 조회
        5. commission_pct 정보만 조회 단, 중복 데이터는 제거한다.
        6. hire_data 가 07년 이후에 해당하는 사원 정보 조회
        7. salary 가 가장 높은 사원 순으로 정렬하여 조회
        8. department_id 가 90 인 사원들의 salary 가 가장 높은 순으로 정렬하여 조회
        9. salary 에 commission_pct(커미션)를 추가 했을 때 결과가 가장 높은 사원 순으로 정렬하여 조회
        10. 사원 정보를 출력할 때 이메일 주소에는 "@employee.com"의 도메인까지 추가하여 출력한다.
*/

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
WHERE department_id IN (100, 110);

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
WHERE commission_pct >= 0.2;

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
WHERE manager_id IS NULL;

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
WHERE manager_id IS NOT NULL
    AND commission_pct > 0.25;
    
SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
WHERE commission_pct IS NOT NULL;

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
WHERE hire_date >= '07/01/01';

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
ORDER BY salary DESC;

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees
WHERE department_id = 90
ORDER BY salary DESC;

SELECT employee_id, first_name, last_name,
           email, phone_number, hire_date,
           job_id, salary, commission_pct,
           salary + (salary * commission_pct) AS commission_salary,
           manager_id, department_id
FROM employees
--WHERE commission_pct IS NOT NULL
ORDER BY commission_salary DESC;

SELECT employee_id, first_name, last_name,
           email || '@employee.com' as email,
           phone_number, hire_date,
           job_id, salary, commission_pct,
           manager_id, department_id
FROM employees;