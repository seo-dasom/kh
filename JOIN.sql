SELECT * FROM employees;

SELECT * FROM departments;

SELECT * FROM jobs;

/* �������� �ҼӵǾ� �ִ� �μ��� �˻� */
SELECT e.employee_id
    , e.first_name
    , e.last_name
    , e.department_id
    , d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
ORDER BY e.employee_id;

/* �������� ������ �˻� */
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
   locations ���̺�� countries ���̺��� join �Ͽ� �������� ��µ� �� �ֵ��� �Ѵ�.
   locations ���̺�� STREET_ADDRESS �÷��� POSTAL_CODE, CITY �� ���� �������� ��µǵ��� �Ѵ�.
*/
SELECT l.street_address
    , l.postal_code
    , l.city
    , l.country_id
    , c.country_name
FROM locations l, countries c
WHERE l.country_id = c.country_id;

/*
    TB_DEPARTMENT ���̺�� TB_PROFESSOR ���̺��� JOIN ���� ���� ����Ͻÿ�.
    ��� �÷��� ���ϴ� �÷��� ���Ƿ� �����Ͽ� ���.
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
/* Ư�� �μ��� �ҼӵǾ� ���� ���� ������� ��� */
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
/* Ư�� �μ��� ��ǰ� ���� �ʾƵ� ��� */
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
/* LEFT RIGHT ���� */
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
/* ������ ��� �Ŵ��� ��� */
SELECT e1.employee_id
    , e1.first_name
    , e1.last_name
    , e1.manager_id
    , e2.first_name
    , e2.last_name
FROM employees e1
JOIN employees e2
ON (e1.manager_id = e2.employee_id);


/* �μ��� ��� �Ŵ��� ������ ��� (��� �Ŵ����� �ִ� �μ��� ���) */
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
    1. TB_PROFESSOR ���̺� ������ ������ �߰��Ѵ�.
    ������ : ������, �а� : ��ǻ�Ͱ���
    ������ : �ڶ�, �а� : ��ǻ�Ͱ���
    ������ : ������, �а� : ��ǻ�Ͱ���
*/
INSERT INTO tb_professor(professor_no, professor_name, department_no)
    VALUES(TO_CHAR(SYSDATE, 'YYMMDD') || '0001', '������',
        (SELECT department_no
        FROM tb_department
        WHERE department_name = '��ǻ��')
    );
INSERT INTO tb_professor(professor_no, professor_name, department_no)
    VALUES(TO_CHAR(SYSDATE, 'YYMMDD') || '0002', '�ڶ�',
        (SELECT department_no
        FROM tb_department
        WHERE department_name = '��ǻ��')
    );
INSERT INTO tb_professor(professor_no, professor_name, department_no)
    VALUES(TO_CHAR(SYSDATE, 'YYMMDD') || '0003', '������',
        (SELECT department_no
        FROM tb_department
        WHERE department_name = '��ǻ��')
    );

SELECT * FROM TB_PROFESSOR;
--INSERT INTO TB_PROFESSOR VALUES ('2102080001', '������', NULL, NULL, '2021020301');
--INSERT INTO TB_PROFESSOR VALUES ('2102080002', '�ڶ�', NULL, NULL, '2021020301');
--INSERT INTO TB_PROFESSOR VALUES ('2102080003', '������', NULL, NULL, '2021020301');

/*
    2. TB_CLASS_PROFESSOR ���̺��� ������ ������ �߰� �Ѵ�.
    ������ : ��Ʈ��ũ, ������ : �ڶ�
    ������ : �ü��, ������ : ������
    ������ : ���α׷���, ������ : ������
    ������ : PCȰ��, ������ : ������
    ������ : �����ͺ��̽�, ������ : ������
    ������ : Ŭ����, ������ : �ڶ�
*/
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_CLASS;

INSERT INTO tb_class(class_no, department_no, class_name, class_type)
    VALUES('2102080001', '2021020301', '�����ͺ��̽�', 1);
INSERT INTO tb_class(class_no, department_no, class_name, class_type)
    VALUES('2102080002', '2021020301', 'Ŭ����', 2);

INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '��Ʈ��ũ'
                  AND d.department_name = '��ǻ��'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '�ڶ�'
                  AND d.department_name = '��ǻ��')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '�ü��'
                  AND d.department_name = '��ǻ��'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '������'
                  AND d.department_name = '��ǻ��')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '���α׷���'
                  AND d.department_name = '��ǻ��'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '������'
                  AND d.department_name = '��ǻ��')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = 'PCȰ��'
                  AND d.department_name = '��ǻ��'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '������'
                  AND d.department_name = '��ǻ��')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = '�����ͺ��̽�'
                  AND d.department_name = '��ǻ��'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '������'
                  AND d.department_name = '��ǻ��')
       );
INSERT INTO TB_CLASS_PROFESSOR(class_no, professor_no)
       VALUES((SELECT c.class_no
                 FROM TB_CLASS c, TB_DEPARTMENT d
                WHERE c.department_no = d.department_no
                  AND c.class_name = 'Ŭ����'
                  AND d.department_name = '��ǻ��'),
              (SELECT p.professor_no
                 FROM TB_PROFESSOR p, TB_DEPARTMENT d
                WHERE p.department_no = d.department_no
                  AND p.professor_name = '�ڶ�'
                  AND d.department_name = '��ǻ��')
       );

/* 3. �а� ���̺��� ������ ��ȸ �� �� ��米���� �̸����� ��� �� �� �ֵ��� ��ȸ�� �Ѵ�. */
SELECT d.department_no
    , d.department_name
    , p.professor_name
FROM tb_department d
JOIN tb_professor p
ON d.department_no = p.department_no;

/* 4. ���� ���̺��� ������ ��ȸ �� �� ��米���� �̸����� ��� �� �� �ֵ��� ��ȸ�� �Ѵ�. (���� ����) */
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
--  AND p.professor_name = '�ڶ�'
ORDER BY 1;

/*
    5. 2�� ��ȸ���� ��米���� �Ҵ�Ǿ� ���� ���� ��쵵 ��� �� �� �ֵ��� �ϸ�
   , '�̹���' �̶�� ��� �� �� �ְ� ��ȸ �Ѵ�.
*/
SELECT * FROM tb_class;
SELECT * FROM tb_class_professor;

SELECT c.class_no
    , c.class_name
    , NVL(p.professor_name, '�̹���')
FROM tb_class c
LEFT JOIN tb_class_professor cp ON c.class_no = cp.class_no
LEFT JOIN tb_professor p ON cp.professor_no = p.professor_no
WHERE 1 = 1
--  AND p.professor_name = '�ڶ�'
ORDER BY 1;

/* 
    6. ������ �л��� ��ǻ�Ͱ��п� ��� �� ������ ������ ������û�Ѵ�.(���� ������ ����а��� ����)
        A �л� : ��Ʈ��ũ, �ü��, ���α׷���, PCȰ��
        B �л� : �ü��, ���α׷���, �����ͺ��̽�, Ŭ����
        C �л� : ���α׷���, �����ͺ��̽�, Ŭ����, ��Ʈ��ũ
    ���� ��û�� TB_CLASS_REG ���̺� ����ϴ� ������ �Ѵ�.
    (�����ʿ�)
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
WHERE class_name in ('��Ʈ��ũ', '�ü��', '���α׷���', 'PCȰ��');

INSERT ALL
    INTO TB_CLASS_REG(reg_id, student_no, class_no)
    VALUES(reg_id, student_no, class_no)
SELECT ROWNUM + (SELECT COUNT(*) FROM TB_CLASS_REG) AS reg_id
    , '2102090002' AS student_no
    , class_no AS class_no
FROM tb_class
WHERE class_name in ('�ü��', '���α׷���', '�����ͺ��̽�', 'Ŭ����');

INSERT ALL
    INTO TB_CLASS_REG(reg_id, student_no, class_no)
    VALUES(reg_id, student_no, class_no)
SELECT ROWNUM + (SELECT COUNT(*) FROM TB_CLASS_REG) AS reg_id
    , '2102090003' AS student_no
    , class_no AS class_no
FROM tb_class
WHERE class_name in ('���α׷���', '�����ͺ��̽�', 'Ŭ����', '��Ʈ��ũ');

/*  7. ������û�� �� �л��� �̸�, �а��ڵ�, �����ڵ�, ������� ��� �Ѵ�. */
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
    ���� ���� ���� �з�
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
    , RANK() OVER (ORDER BY salary DESC) AS �޿�����_rank
    , �޿�����_dense_rank
FROM (SELECT employee_id
            , first_name
            , last_name
            , salary
            , DENSE_RANK() OVER (ORDER BY salary DESC) AS �޿�����_dense_rank
            FROM employees)
WHERE �޿�����_dense_rank <= 5;
--WHERE ROWNUM <= 5;
