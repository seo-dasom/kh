SELECT * FROM employees;

SELECT * FROM departments;

SELECT * FROM jobs;

/* 직원들이 소속되어 있는 부서를 검색 */
SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.department_id
    , d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
ORDER BY e.employee_id;

/* 직원들의 직급을 검색 */
SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.job_id
    , j.job_title
FROM employees e, jobs j
WHERE e.job_id = j.job_id
ORDER BY e.employee_id;

SELECT * FROM TAB;

SELECT * FROM employees;
SELECT * FROM countries;
SELECT * FROM departments;
SELECT * FROM jobs;
SELECT * FROM locations;

/* 
   locations 테이블과 countries 테이블을 join 하여 지역명이 출력될 수 있도록 한다.
   locations 테이블과 STREET_ADDRESS 컬럼과 POSTAL_CODE, CITY 와 같이 지역명이 출력되도록 한다.
*/
SELECT l.street_address
    , l.postal_code
    , l.city
    , l.country_id
    , c.country_name
FROM locations l, countries c
WHERE l.country_id = c.country_id;

/*
    TB_DEPARTMENT 테이블과 TB_PROFESSOR 테이블을 JOIN 으로 묶어 출력하시오.
    출력 컬럼은 원하는 컬럼을 임의로 선정하여 출력.
*/
SELECT d.department_no
    , d.department_name
    , d.category
    , p.professor_name
FROM tb_department d, tb_professor p
WHERE d.department_no = p.department_no;



/* INNER JOIN */
SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.department_id
    , d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
ORDER BY e.employee_id;

SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.department_id
    , d.department_name
FROM employees e
JOIN departments d
ON (e.department_id = d.department_id)
ORDER BY e.employee_id;

/* LEFT OUTER JOIN */
/* 특정 부서에 소속되어 있지 않은 사원까지 출력 */
SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.department_id
    , d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON (e.department_id = d.department_id)
ORDER BY e.employee_id;

/* RIGHT OUTER JOIN */
/* 특정 부서가 운영되고 있지 않아도 출력 */
SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.department_id
    , d.department_name
FROM employees e
RIGHT OUTER JOIN departments d
ON (e.department_id = d.department_id)
ORDER BY e.employee_id;

/* FULL OUTER JOIN */
/* LEFT RIGHT 결합 */
SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.department_id
    , d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON (e.department_id = d.department_id)
ORDER BY e.employee_id;

/* SELF JOIN */
/* 직원의 담당 매니저 출력 */
SELECT e1.employee_id
    , e1.first_name
    , e1.last_name
    , e1.manager_id
    , e2.first_name
    , e2.last_name
FROM employees e1
JOIN employees e2
ON (e1.manager_id = e2.employee_id);


/* 부서별 담당 매니저 정보를 출력 (담당 매니저가 있는 부서만 출력) */
SELECT d.department_name
    , e.employee_id
    , e.first_name
    , e.last_name
FROM departments d
JOIN employees e
ON d.manager_id = e.employee_id;


SELECT d.department_name
    , e.employee_id
    , e.first_name
    , e.last_name
FROM employees e
JOIN departments d
ON d.manager_id = e.employee_id;

/* 
    1. TB_PROFESSOR 테이블에 다음의 정보를 추가한다.
    교수명 : 김제훈, 학과 : 컴퓨터공학
    교수명 : 박라연, 학과 : 컴퓨터공학
    교수명 : 이조훈, 학과 : 컴퓨터공학
*/
INSERT INTO tb_professor(professor_no, professor_name, department_no)
    VALUES(TO_CHAR(SYSDATE, 'YYMMDD') || '0001', '김제훈',
        (SELECT department_no
        FROM tb_department
        WHERE department_name = '컴퓨터')
    );
INSERT INTO tb_professor(professor_no, professor_name, department_no)
    VALUES(TO_CHAR(SYSDATE, 'YYMMDD') || '0002', '박라연',
        (SELECT department_no
        FROM tb_department
        WHERE department_name = '컴퓨터')
    );
INSERT INTO tb_professor(professor_no, professor_name, department_no)
    VALUES(TO_CHAR(SYSDATE, 'YYMMDD') || '0003', '이조훈',
        (SELECT department_no
        FROM tb_department
        WHERE department_name = '컴퓨터')
    );

SELECT * FROM TB_PROFESSOR;
--INSERT INTO TB_PROFESSOR VALUES ('2102080001', '김제훈', NULL, NULL, '2021020301');
--INSERT INTO TB_PROFESSOR VALUES ('2102080002', '박라연', NULL, NULL, '2021020301');
--INSERT INTO TB_PROFESSOR VALUES ('2102080003', '이조훈', NULL, NULL, '2021020301');

/*
    2. TB_CLASS_PROFESSOR 테이블의 다음의 정보를 추가 한다.
    담당과목 : 네트워크, 교수명 : 박라연
    담당과목 : 운영체제, 교수명 : 김제훈
    담당과목 : 프로그래밍, 교수명 : 박제현
    담당과목 : PC활용, 교수명 : 이조훈
    담당과목 : 데이터베이스, 교수명 : 김제훈
    담당과목 : 클라우드, 교수명 : 박라연
*/
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_CLASS;

INSERT INTO tb_class(class_no, department_no, class_name, class_type)
    VALUES('2102080001', '2021020301', '데이터베이스', 1);
INSERT INTO tb_class(class_no, department_no, class_name, class_type)
    VALUES('2102080002', '2021020301', '클라우드', 2);

INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '네트워크'
                  AND d.department_name = '컴퓨터'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '박라연'
                  AND d.department_name = '컴퓨터')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '운영체제'
                  AND d.department_name = '컴퓨터'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '김제훈'
                  AND d.department_name = '컴퓨터')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '프로그래밍'
                  AND d.department_name = '컴퓨터'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '박제현'
                  AND d.department_name = '컴퓨터')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = 'PC활용'
                  AND d.department_name = '컴퓨터'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '이조훈'
                  AND d.department_name = '컴퓨터')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '데이터베이스'
                  AND d.department_name = '컴퓨터'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '김제훈'
                  AND d.department_name = '컴퓨터')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '클라우드'
                  AND d.department_name = '컴퓨터'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '박라연'
                  AND d.department_name = '컴퓨터')
       );

/* 3. 학과 테이블의 정보를 조회 할 때 담당교수의 이름까지 출력 될 수 있도록 조회를 한다. */
SELECT d.department_no
    , d.department_name
    , p.professor_name
FROM tb_department d
JOIN tb_professor p
ON d.department_no = p.department_no;

/* 4. 과목 테이블의 정보를 조회 할 때 담당교수의 이름까지 출력 될 수 있도록 조회를 한다. (다중 조인) */
SELECT * FROM tb_class;
SELECT * FROM tb_class_professor;
SELECT * FROM tb_professor;

SELECT c.class_no
    , c.class_name
    , p.professor_name
FROM tb_class c
JOIN tb_class_professor cp ON c.class_no = cp.class_no
JOIN tb_professor p ON cp.professor_no = p.professor_no
WHERE 1 = 1
--  AND p.professor_name = '박라연'
ORDER BY 1;

/*
    5. 2번 조회에서 담당교수가 할당되어 있지 않은 경우도 출력 할 수 있도록 하며
   , '미배정' 이라고 출력 할 수 있게 조회 한다.
*/
SELECT * FROM tb_class;
SELECT * FROM tb_class_professor;

SELECT c.class_no
    , c.class_name
    , NVL(p.professor_name, '미배정')
FROM tb_class c
LEFT JOIN tb_class_professor cp ON c.class_no = cp.class_no
LEFT JOIN tb_professor p ON cp.professor_no = p.professor_no
WHERE 1 = 1
--  AND p.professor_name = '박라연'
ORDER BY 1;

/* 
    6. 임의의 학생을 컴퓨터공학에 등록 후 다음의 과목을 수강신청한다.(지도 교수는 담당학과의 교수)
        A 학생 : 네트워크, 운영체제, 프로그래밍, PC활용
        B 학생 : 운영체제, 프로그래밍, 데이터베이스, 클라우드
        C 학생 : 프로그래밍, 데이터베이스, 클라우드, 네트워크
    수강 신청은 TB_CLASS_REG 테이블에 등록하는 것으로 한다.
    (수정필요)
*/
INSERT INTO TB_STUDENT(student_no, department_no, student_name, entrance_date, absence_yn, coach_professor_no)
    VALUES('2102090001', '2021020301', 'aaaa', SYSDATE, 'n', '2102030003' );
INSERT INTO TB_STUDENT(student_no, department_no, student_name, entrance_date, absence_yn, coach_professor_no)
    VALUES('2102090002', '2021020301', 'bbbb', SYSDATE, 'n', '2102030003' );
INSERT INTO TB_STUDENT(student_no, department_no, student_name, entrance_date, absence_yn, coach_professor_no)
    VALUES('2102090003', '2021020301', 'cccc', SYSDATE, 'n', '2102030003' );

INSERT ALL
    INTO TB_CLASS_REG(reg_id, student_no, class_no)
    VALUES(reg_id, student_no, class_no)
SELECT ROWNUM AS reg_id
    , '2102090001' AS student_no
    , class_no AS class_no
FROM tb_class
WHERE class_name in ('네트워크', '운영체제', '프로그래밍', 'PC활용');

INSERT ALL
    INTO TB_CLASS_REG(reg_id, student_no, class_no)
    VALUES(reg_id, student_no, class_no)
SELECT ROWNUM + (SELECT COUNT(*) FROM TB_CLASS_REG) AS reg_id
    , '2102090002' AS student_no
    , class_no AS class_no
FROM tb_class
WHERE class_name in ('운영체제', '프로그래밍', '데이터베이스', '클라우드');

INSERT ALL
    INTO TB_CLASS_REG(reg_id, student_no, class_no)
    VALUES(reg_id, student_no, class_no)
SELECT ROWNUM + (SELECT COUNT(*) FROM TB_CLASS_REG) AS reg_id
    , '2102090003' AS student_no
    , class_no AS class_no
FROM tb_class
WHERE class_name in ('프로그래밍', '데이터베이스', '클라우드', '네트워크');

/*  7. 수강신청을 한 학생의 이름, 학과코드, 과목코드, 과목명을 출력 한다. */
SELECT * FROM tb_class_reg;
SELECT * FROM tb_student;
SELECT * FROM tb_class;

SELECT s.student_name
    , s.department_no
    , c.class_no
    , c.class_name
FROM tb_class_reg cr
JOIN tb_student s ON cr.student_no = s.student_no
JOIN tb_class c ON cr.class_no = c.class_no;


SELECT * FROM employees;
SELECT * FROM jobs;

SELECT e.employee_id
    , e.first_name || ' ' || e.last_name as name
    , j.JOB_TITLE
    , e.SALARY
    , j.MIN_SALARY
    , j.MAX_SALARY
FROM employees e
JOIN jobs j ON (e.salary BETWEEN j.min_salary AND j.max_salary)
ORDER BY 1;

/*
    과목 시험 점수 분류
    90 ~ 100    A
    80 ~ 89      B
    79 ~ 79      C
*/


SELECT ROWNUM
    , employee_id
    , first_name
    , last_name
    , salary
FROM employees
WHERE ROWNUM <= 5
ORDER BY salary DESC;


SELECT ROWNUM
    , employee_id
    , first_name
    , last_name
    , salary
FROM (SELECT *
            FROM employees
            ORDER BY salary DESC)
WHERE ROWNUM <= 5;


SELECT ROWNUM
    , employee_id
    , first_name
    , last_name
    , salary
    , RANK() OVER (ORDER BY salary DESC) AS 급여순위_rank
    , 급여순위_dense_rank
FROM (SELECT employee_id
            , first_name
            , last_name
            , salary
            , DENSE_RANK() OVER (ORDER BY salary DESC) AS 급여순위_dense_rank
            FROM employees)
WHERE 급여순위_dense_rank <= 5;
--WHERE ROWNUM <= 5;
