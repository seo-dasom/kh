SELECT * FROM tb_department;

/*
    A Table�� ������ B Table�� ����.
    tb_department�� ������ temp_department�� ���� (��������)
    
    temp_department �� �÷��� �а���, ������ �����ϴ� ���̺�� �����.
*/
--DROP TABLE temp_department;

CREATE TABLE temp_department (
              department_name VARCHAR2(50)
            , capacity NUMBER
);

INSERT INTO temp_department(
            SELECT department_name
                        , capacity
            FROM tb_department
);


/*
    A Table�� ������ B Table�� ���縦 �� �� B Table�� �÷� ������ Ÿ����
    A Table�� ������ ������ Ÿ������ ����� ��� ������ ����� ���.
*/
--DROP TABLE temp_department;

CREATE TABLE temp_department
         AS SELECT department_name
                          , capacity
               FROM   tb_department
               WHERE 1 = 0;     -- ������ ���̺� �����͸� �������� ���� �� ���

SELECT * FROM temp_department;
DESC temp_department;
DESC tb_department;


-- DROP TABLE temp_professor_info;
-- DROP TABLE temp_professor_dept;
CREATE TABLE temp_professor_info
        AS SELECT professor_no
                        ,  professor_name
                        ,  professor_address
             FROM   tb_professor
             WHERE 1 = 0;

CREATE TABLE temp_professor_dept
        AS SELECT professor_no
                        ,  professor_name
                        ,  department_no
             FROM   tb_professor
             WHERE 1 = 0;

INSERT ALL
    INTO temp_professor_info VALUES(professor_no, professor_name, professor_address)
    INTO temp_professor_dept VALUES(professor_no, professor_name, department_no)
SELECT professor_no
            , professor_name
            , professor_address
            , department_no
    FROM tb_professor;


SELECT * FROM temp_professor_info;
SELECT * FROM temp_professor_dept;


/*
    EMPLOYEES ���̺��� ����Ͽ� ������ ������ �����ϴ�
    �����͸� �߰� ������ ���̺� ����.
    
    employees_info ���̺��� employee_id, first_name, last_name, phone_number �÷��� ������.
    employees_dept ���̺��� employee_id, first_name, last_name, department_id, job_id �÷��� ������.
    
    �� ���̺��� ���� �� �޿�(salary) �׸��� 10000 �̸��� ������ ���ؼ��� ������ �Ͻÿ�.
*/

CREATE TABLE employees_info
        AS SELECT employee_id
                         , first_name
                         , last_name
                         , phone_number
             FROM   employees
             WHERE 1 = 0;

CREATE TABLE employees_dept
        AS SELECT employee_id
                         , first_name
                         , last_name
                         , department_id
                         , job_id
             FROM   employees
             WHERE 1 = 0;

INSERT ALL
    INTO employees_info VALUES(employee_id, first_name, last_name, phone_number)
    INTO employees_dept VALUES(employee_id, first_name, last_name, department_id, job_id)
SELECT employee_id
            , first_name
            , last_name
            , phone_number
            , department_id
            , job_id
FROM   employees
WHERE salary < 10000;



INSERT ALL
    WHEN salary < 10000 THEN
            INTO employees_info VALUES(employee_id, first_name, last_name, phone_number)
    ELSE
            INTO employees_dept VALUES(employee_id, first_name, last_name, department_id, job_id)
SELECT employee_id
            , first_name
            , last_name
            , phone_number
            , department_id
            , job_id
            , salary
FROM   employees;

SELECT * FROM employees_info;
SELECT * FROM employees_dept;

UPDATE employees
       SET commission_pct = 0.1
  WHERE employee_id IN (SELECT employee_id
                                          FROM employees
                                        WHERE commission_pct IS NULL
                                             AND job_id = 'SH_CLERK');


SELECT * FROM employees;

/* Ʈ������(INSERT, UPDATE, DELETE)�� ���� DB�� �ݿ� */
COMMIT;

/* Ʈ������(INSERT, UPDATE, DELETE)�� ��� �Ѵ�.*/
ROLLBACK;



/* ������ ���̺� ���� Ȯ�� */
SELECT * FROM TAB;

/* ���̺��� �÷� ���� Ȯ�� */
SELECT * FROM USER_TAB_COLUMNS;

/* Ư�� ���̺��� �÷� ���� Ȯ�� */
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_DEPARTMENT';

/* �÷��� ����� �������� Ȯ�� */
SELECT * FROM USER_CONS_COLUMNS;

/* �������� Ȯ��(��) */
SELECT * FROM USER_CONSTRAINTS;


SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'TB_DEPARTMENT';
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'EMPLOYEES';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TB_DEPARTMENT';


/*
    ���� ���ǿ� �̸��� ���� �ϴ� ��� 
    ���� �����̸��� �ο��ϴ� ��Ģ(����)
            ���̺��_�÷���_��������
    ��������(����)
            PRIMARY KEY -> PK
            UNIQUE -> UK
            NOT NULL -> NN
            CHECK -> CK
            DEFAULT -> DF
            FOREIGN KEY -> FK
*/
DROP TABLE TEMP1;
CREATE TABLE TEMP1 (
        COL_ID          NUMBER           --CONSTRAINT TEMP1_COL_ID_PK PRIMARY KEY
      , COL_NAME   VARCHAR2(50)   CONSTRAINT TEMP1_COL_NAME_NN NOT NULL
      , COL_DATE    DATE
      , CONSTRAINT TEMP1_COL_ID_PK PRIMARY KEY(COL_ID)
);

SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'TEMP1';


DROP TABLE TEMP2;
CREATE TABLE TEMP2 (
        COL_ID          NUMBER
      , COL_NAME   VARCHAR2(50)
      , COL_DATE    DATE
);

/* ALTER : ���̺� ������ ������ �� ���(�߰�, ����, ����, �̸�����) */
/* ALTER �� �÷� �߰� */
ALTER TABLE TEMP2 ADD(
            COL_AGE NUMBER
          , COL_GENDER CHAR(1)
);

/* ALTER �� �������� �߰� */
ALTER TABLE TEMP2 ADD (
        CONSTRAINT TMP2_COL_AGE_CK CHECK(COL_AGE > 0 AND COL_AGE <= 150)
      , CONSTRAINT TMP2_COL_GENDER_CK CHECK(COL_GENDER IN ('m', 'w'))
      , CONSTRAINT TMP2_COL_ID_UK UNIQUE(COL_ID)
);

/* ALTER �� �÷� ����(���������� ���� �� ���� �߰�) */
ALTER TABLE TEMP2 MODIFY (
        COL_NAME VARCHAR2(100)
      , COL_GENDER CHAR(3)
);

/* ALTER �� �÷� �� �������� ���� */
ALTER TABLE TEMP2 DROP COLUMN COL_DATE;
ALTER TABLE TEMP2 DROP COLUMN COL_AGE;

ALTER TABLE TEMP2 DROP (
        COL_DATE
      , COL_AGE
);

ALTER TABLE TEMP2 DROP CONSTRAINT TMP2_COL_AGE_CK;
ALTER TABLE TEMP2 DROP CONSTRAINT TMP2_COL_GENDER_CK;


/* �÷��� ���� */
ALTER TABLE TEMP2 RENAME COLUMN COL_NAME TO COL_FNAME;

/* �������Ǹ� ���� */
ALTER TABLE TEMP2 RENAME CONSTRAINT TMP2_COL_ID_UK TO TMP2_COL_ID_PK;

/* ���̺�� ���� */
ALTER TABLE TEMP2 RENAME TO RE_TEMP2;

SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'RE_TEMP2';
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'TEMP2';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TEMP2';


SELECT * FROM TAB WHERE TNAME LIKE 'TB_%';

/*
    ������ ������ TB_DEPARTMENT, TB_CLASS, TB_PROFESSOR �� ��� TB ���̺�
    1. ������ ������ ���������� �̸��� ���� '���̺��_�÷���_��������' ������ �̸����� ����
    2. ��� �÷��� VARCHAR2 ������ Ÿ���� �ѱ� �����Ͱ� ����� ����� �� �ִ� ũ��� ����
        �̸��� ���õ� �÷��� �ѱ� 50�� ���� ���� ����
        �ּҿ� ���õ� �÷��� �ѱ� 100�� ���� ���� ����
        �����/�а���/�а��迭�� ���õ� �÷��� �ѱ� 25�� ���� ���� ����
        PK�� ����ϴ� ���� ��ȣ �÷��� �������� ���ڿ��� ���� (10��)
    3. TB_CLASS_TYPE �̶�� ���̺��� ������ �÷��� ����ϴ� ������ �߰� �Ѵ�.
                TYPE_ID          NUMBER               PRIMARY KEY
                TYPE_NAME   VARCHAR2(24)      NOT NULL
        TB_CLASS_TYPE�� TYPE_ID �÷��� �����ϴ� TB_CLASS ���̺��� �÷����� CLASS_TYPE�� �����Ѵ�.
        TB_CLASS�� CLASS_TYPE�� TB_CLASS_TYPE�� TYPE_ID�� �����ϱ� ������ ������ Ÿ�Ե� �׿� �����.
    4. TB_STUDENT ���̺� ����(STUDENT_GENDER) �÷��� �߰��Ѵ�. ������ Ÿ���� VARCHAR2(3)�̸�,
        �����������δ� '��', '��' �� ������ �� �ְ� �Ѵ�.
    5. TB_CLASS_REG ���̺��� ��� �л����� ���������� ����ϱ� ���� ���̺�� �����Ѵ�.
            ��Ϲ�ȣ    REG_ID           NUMBER      PRIMARY KEY
            �л���ȣ    STUDENT_NO CHAR(10)      FK
            �����ȣ    CLASS_NO     CHAR(10)      FK
*/
SELECT * FROM USER_CONS_COLUMNS;
SELECT * FROM TB_CLASS;



SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_STUDENT;