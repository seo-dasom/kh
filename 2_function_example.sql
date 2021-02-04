/* ���� �����Ͱ� �ִ� ���̺� �׽�Ʈ �뵵�� ��� */
SELECT LENGTH('���ڱ���')
FROM dual;

/* LENGTH : ���ڿ� ���̸� ���ϴ� �Լ� */
SELECT first_name,
        LENGTH(first_name)  /* �� �Լ� */
FROM employees;


/* INSTR */
SELECT phone_number,
    INSTR(phone_number, '.'),
    INSTR(phone_number, '.', 5),
    INSTR(phone_number, '.', 1, 2),     /* 2��°�� �߻� �� ��ġ�� */
    INSTR(phone_number, '.', 1, 3)     /* 3��°�� �߻� �� ��ġ�� */
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
SELECT NEXT_DAY(SYSDATE, '�ݿ���'),
    NEXT_DAY(SYSDATE, '��'),
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

/* ���� ���ϱ�/���� */
SELECT SYSDATE -1,
    SYSDATE + 1
FROM dual;


/* TO_CHAR :  ���� �Ǵ� ��¥�� ���ڿ��� ��ȯ */
SELECT TO_CHAR(10),
    TO_CHAR(10000, '999,999,999'),
    TO_CHAR(10000, 'L999,999,999'),
    TO_CHAR(SYSDATE, 'YYYY-MM-DD')
FROM dual;

/* TO_NUMBER : ���ڿ��� ���ڷ� ��ȯ */
SELECT TO_NUMBER('10000'),
    TO_NUMBER('10,000', '999,999,999')
FROM dual;

/* TO_DATE : ���ڿ��� ��¥�� ��ȯ */
SELECT TO_DATE('20210201', 'YYYYMMDD')
FROM dual;


/* NVL : NULL �����͸� ��ü �� ���� �Ǵ� ���ڷ� ���� */
SELECT NVL(null, 0),
       NVL(null, 'a')
FROM dual;


/* DECODE : ���ϴ� �� �Ǵ� �÷��� ���ǽİ� ������ ��� ��ȯ */
SELECT DECODE('a', 'a', 'a�Դϴ�', 'b', 'b�Դϴ�.'),
       DECODE('b', 'a', 'a�Դϴ�', 'b', 'b�Դϴ�.'),
       DECODE('c', 'a', 'a�Դϴ�', 'b', 'b�Դϴ�.', 'a/b�� �ƴմϴ�.')
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
       CASE WHEN salary > 10000 THEN '��׿�����'
            WHEN salary > 5000 THEN '�Ϲݿ�����'
            ELSE '���ҵ���'
       END AS "�����з�"
FROM employees;


/* ���� */
/* 1. ��� ������ ��� �� �� ��ȭ��ȣ�� xxx-xxx-xxxx �������� ��� �� �� �ְ� �Ѵ�. */
SELECT employee_id, first_name, last_name,
       email, REPLACE(phone_number, '.', '-') AS "��ȭ��ȣ",
       hire_date, job_id, salary, commission_pct,
       manager_id, department_id
FROM employees;


/* 2. ����� salary �� �޿� �׸��̸� commission_pct �� ������ ���ʽ� �׸��̴�. �̸� ����
      ��� ����� �̸��� ������ ����Ͻÿ�. */
SELECT first_name, last_name,
       ((salary * 12) + salary * 12 * NVL(commission_pct, 0)) AS "����"
FROM employees
ORDER BY "����" DESC;


/* 3. �Ի��Ϸ� ���� �ټӳ��� 3��, 7��, 12�⿡ �ش��ϴ� ������� �߰� �޿��� ������
      ���� �����Ϸ� �Ѵ�. ���ǿ� �´� �߰� �޿� �׸��� ����Ͻÿ�.
      3�� : 1000 | 7�� : 2000 | 12�� : 5000 */
SELECT first_name, last_name, hire_date,
       TRUNC((MONTHS_BETWEEN('13/02/02', hire_date) / 12), 0) AS "�ټӳ�",
       DECODE(TRUNC((MONTHS_BETWEEN('13/02/02', hire_date) / 12), 0),
              3,  1000,
              7,  2000,
              12, 5000,
              0
       ) AS "�߰��޿�"
FROM employees
ORDER BY "�ټӳ�" DESC;


/* 4. �޿� �׸��� ��� �� ���� õ �ڸ� ���� ������ �����Ͽ� ��� �Ͻÿ�. */
SELECT employee_id, first_name, last_name,
       email, phone_number, hire_date,
       job_id, TO_CHAR(salary, '999,999') AS "�޿�",
       commission_pct,
       manager_id, department_id
FROM employees
ORDER BY "�޿�" DESC;


/* 5. ��¥ �׸��� ��� �� ���� 2021-01-01 ������ �����Ͽ� ��� �Ͻÿ�. */
SELECT employee_id, first_name, last_name,
       email, phone_number, TO_CHAR(hire_date, 'YYYY-MM-DD') AS "�Ի���",
       job_id, salary, commission_pct,
       manager_id, department_id
FROM employees
ORDER BY "�Ի���" ASC;


/* �׷� �Լ� */
/* SUM */
SELECT SUM(salary) AS "�ѱ޿�"
FROM employees;

SELECT SUM(salary) AS "�ѱ޿�"
FROM employees
WHERE department_id = 100;

/* AVG */
SELECT AVG(salary) AS "��ձ޿�"
FROM employees;

SELECT AVG(salary) AS "��ձ޿�"
FROM employees
WHERE department_id = 100;

/* COUNT */
SELECT COUNT(*) AS "���ο�"
FROM employees;

SELECT COUNT(*) AS "�μ��ο�"
FROM employees
WHERE department_id = 100;

SELECT COUNT(*) AS "��׿����ڼ�"
FROM employees
WHERE salary >= 10000;

/* MAX */
SELECT MAX(salary) AS "�ְ�׿�����"
FROM employees;

/* MIN */
SELECT MIN(salary) AS "�����׿�����"
FROM employees;



/* GROUP BY */
SELECT department_id,
          ROUND(AVG(salary) ,0) AS "�μ��� �޿����"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY "�μ��� �޿����" DESC;

/* �μ��� ���� ���� ���Ͻÿ�. */
SELECT department_id,
          COUNT(*) AS "�μ��� ������"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY "�μ��� ������" DESC;

/* job_id �� �����̸�, ���޺� �޿� ����� ���Ͻÿ�. */
SELECT job_id,
          ROUND(AVG(salary) ,0) AS "���޺� �޿����"
FROM employees
WHERE job_id IS NOT NULL
GROUP BY job_id
ORDER BY "���޺� �޿����" DESC;


/* HAVING �׷쿡 ���� ���� */
SELECT department_id,
          ROUND(AVG(salary) ,0) AS "�μ��� �޿����"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING department_id NOT IN (100, 110)
    AND ROUND(AVG(salary), 0) > 5000
ORDER BY "�μ��� �޿����" DESC;


/* �μ� ���ο��� 5�� ������ �μ��� ��� */
SELECT department_id,
          COUNT(*) AS "�μ��� �ο�"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING COUNT(*) <= 5
ORDER BY "�μ��� �ο�" DESC;


/* ROLLUP ���� �Լ� -> �ϳ��� �÷��� �׷�ȭ �Ͽ� ������ ���� */
SELECT department_id,
       SUM(salary) AS "�μ����ѱ޿�"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY ROLLUP(department_id)
ORDER BY department_id NULLS LAST;

/* CUBE -> �ϳ��� �÷��� �׷�ȭ �Ͽ� ������ ���� */
SELECT department_id,
       SUM(salary) AS "�μ����ѱ޿�"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY CUBE(department_id)
ORDER BY department_id NULLS LAST;

/* ROLLUP ���� �Լ� -> �ΰ� �̻��� �÷��� �׷�ȭ �Ͽ� ������ ���� */
SELECT department_id, job_id,
       SUM(salary) AS "�μ����ѱ޿�"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY ROLLUP(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;


/* CUBE -> �ΰ� �̻��� �÷��� �׷�ȭ �Ͽ� ������ ���� */
SELECT department_id, job_id,
       SUM(salary) AS "�μ����ѱ޿�"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY CUBE(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;


/* �⵵�� �Ի��� ���� ���� �Ͻÿ�. */
SELECT TO_CHAR(hire_date, 'YYYY') AS "�⵵",
          COUNT(*) AS "�Ի��ڼ�"
FROM employees
GROUP BY ROLLUP(TO_CHAR(hire_date, 'YYYY'));


SELECT EXTRACT(YEAR FROM hire_date) AS "�⵵",
          COUNT(*) AS "�Ի��ڼ�"
FROM employees
GROUP BY ROLLUP(EXTRACT(YEAR FROM hire_date));

/* �⵵��, �б⺰ �Ի��� ���� ���� �Ͻÿ�. (ROLLUP �̿�)*/


/* ��¥ �б� ���ϴ� ��� */
SELECT TO_CHAR(TO_DATE('2021/01/01', 'YYYY/MM/DD'), 'Q') AS "1�б�",
          TO_CHAR(TO_DATE('2021/05/01', 'YYYY/MM/DD'), 'Q') AS "2�б�",
          TO_CHAR(TO_DATE('2021/08/01', 'YYYY/MM/DD'), 'Q') AS "3�б�",
          TO_CHAR(TO_DATE('2021/11/01', 'YYYY/MM/DD'), 'Q') AS "4�б�"
FROM dual;


/* GROUPING �Լ��� ���� ��� ���� */
SELECT department_id, job_id,
          SUM(salary) AS "�μ����ѱ޿�",
          CASE WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 1 THEN '�μ��� ����'
                 WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 0 THEN '�ش� �μ��� ���޺� ����'
                 ELSE '�� ����'
          END AS "����"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY ROLLUP(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;

/* GROUPING �Լ��� ���� ��� ���� */
SELECT department_id, job_id,
          SUM(salary) AS "�μ����ѱ޿�",
          CASE WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 1 THEN '�μ��� ����'
                 WHEN GROUPING(department_id) = 0 AND GROUPING(job_id) = 0 THEN '�ش� �μ��� ���޺� ����'
                 WHEN GROUPING(department_id) = 1 AND GROUPING(job_id) = 0 THEN '���޺� ����'
                 ELSE '�� ����'
          END AS "����"
FROM employees
WHERE department_id IS NOT NULL
GROUP BY CUBE(department_id, job_id)
ORDER BY department_id NULLS LAST, job_id NULLS LAST;


SELECT * FROM employees ORDER BY commission_pct DESC NULLS LAST;