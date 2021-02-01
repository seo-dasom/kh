SELECT *                 /* �÷��� */
FROM employees;    /* ���̺�� */

/* �˻��� �÷��� ���� */
SELECT first_name,
           last_name
FROM employees;

--SELECT first_name,
--           last_name
--FROM jobs;

/* �÷��� ��Ī �ο� */
SELECT  first_name AS "�̸�",
            last_name AS "��"
FROM employees;

/*
 ��Ī�� �ο��� �� ��(ū) ����ǥ�� ����ϰų� ������� ���� �� �ִ�.
 ��(ū) ����ǥ�� ����� ������ ������ �ְų� Ư�� ���� �� ���ڰ� �ִ� ��� ���.
*/


/* �ټ��� �÷� ����� �ϳ��� �÷����� �����Ͽ� ��� */
SELECT CONCAT(last_name, first_name) AS "�̸�"
FROM employees;

/* ��Ī�� �ƴ� ������ ��� �� ������ ���� ����ǥ */
SELECT last_name || ' ' || first_name AS "�̸�"
FROM employees;

/* ��� ���� */
SELECT  SALARY AS "����",
            (SALARY + 1000) * 12 AS "����"
FROM employees;

/* DISTINCT �� ����Ͽ� �ߺ� �����͸� �����ϰ� ��� */
SELECT DISTINCT SALARY AS "����",
            (SALARY + 1000) * 12 AS "����"
FROM employees;

/* WHERE �� : ���ǿ� ���� ����� ����� �� �ְ� �Ѵ�. */
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

/* ������ ����
    �� ������                      �� ������
        =       ����                   AND        �� ������ ��� �����ϴ� ����� ��ȸ
        >       ũ��                   OR          �� ���� �� �ϳ��� �����ϴ� ����� ��ȸ
        <       �۴�                   NOT        ������ �������� �ʴ� ����� ��ȸ
        >=     ũ�ų� ����
        <=     �۰ų� ����
        <>     ���� �ʴ�
        !=      ���� �ʴ�
*/

/* IN ������ : ���� ���� ������ ���� �� ��� -> column_name [NOT] IN (value1, value2, ...) */
SELECT *
FROM employees
WHERE department_id IN (90, 100, 110, 120);

SELECT *
FROM employees
WHERE department_id NOT IN (90, 100, 110, 120);

/* IS [NOT] NULL : null ���� �ִ� �Ǵ� ���� �÷��� ��ȸ�� �� ��� */
SELECT *
FROM employees
WHERE commission_pct IS NULL;

SELECT *
FROM employees
WHERE commission_pct IS NOT NULL;

/* [NOT] LIKE : ���ڿ��� ���� ���� ��ȸ�� �� �� ���
                    %  -> ��� ���ڿ��� ��ġ ��Ų��.
                    _   -> ���� 1���� ��ġ ��Ų��.
*/
SELECT first_name,
           last_name
FROM employees
WHERE first_name LIKE 'A%';  /* A�� �����ϴ� ���ڿ� */

SELECT first_name,
           last_name
FROM employees
WHERE first_name LIKE '%er';  /* er�� ������ ���ڿ� */

SELECT first_name,
           last_name
FROM employees
WHERE first_name LIKE '%i%';  /* i�� ���Ե� ���ڿ� */

/* [NOT] BETWEEN : ���� ������ ��ȸ�� �� ���(����, ��¥�� �ַ� ���) */
SELECT *
FROM employees
WHERE salary BETWEEN 2500 AND 5000; /* ���� �����ؼ� �˻� */

SELECT *
FROM employees
WHERE hire_date BETWEEN '05/01/01' AND '05/12/31';

/* ORDER BY �� : ��ȸ �����Ϳ� ���� ������ ���� �� */
SELECT *
FROM employees
ORDER BY first_name;

SELECT *
FROM employees
ORDER BY first_name DESC; /*  DESC : �������� ���� */

SELECT *
FROM employees
ORDER BY first_name, employee_id DESC;

SELECT *
FROM employees
ORDER BY 2, 1 DESC; /* �÷� �������� ���� ���� */

SELECT employee_id AS "���",
           first_name || ' ' || last_name AS "�̸�"
FROM employees
ORDER BY �̸�, ��� DESC;


SELECT * FROM employees;
/* ���� 
        1. department_id�� 100, 110 �� ��� ���� ��ȸ
        2. commission_pct�� 0.2 �̻��� ��� ���� ��ȸ
        3. manager_id�� null �� ��� ���� ��ȸ
        4. manager_id�� null �� �ƴϸ鼭 commission_pct �� 0.25 �̻��� ��� ���� ��ȸ
        5. commission_pct ������ ��ȸ ��, �ߺ� �����ʹ� �����Ѵ�.
        6. hire_data �� 07�� ���Ŀ� �ش��ϴ� ��� ���� ��ȸ
        7. salary �� ���� ���� ��� ������ �����Ͽ� ��ȸ
        8. department_id �� 90 �� ������� salary �� ���� ���� ������ �����Ͽ� ��ȸ
        9. salary �� commission_pct(Ŀ�̼�)�� �߰� ���� �� ����� ���� ���� ��� ������ �����Ͽ� ��ȸ
        10. ��� ������ ����� �� �̸��� �ּҿ��� "@employee.com"�� �����α��� �߰��Ͽ� ����Ѵ�.
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