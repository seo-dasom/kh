/*
    ����ID, ��, �̸�, �̸���, ��ȭ��ȣ, �μ���, ���޸� �� ����ϴ� VIEW ����
    VIEW �̸��� v_emp_info
*/

-- 1. SELECT ������ ����Ͽ� ��ȸ ��� Ȯ��
-- 2. Ȯ�ε� ������ ������ VIEW ����

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
    �μ��� �ο��� �ľ��� �� �ִ� VIEW ����
    VIEW �̸��� V_NUM_OF_DEPTS ���� �Ѵ�.
*/
CREATE OR REPLACE VIEW V_NUM_OF_DEPTS
    AS SELECT d.department_name AS "�μ���"
        , COUNT(*) AS "�ο�"
    FROM employees e
    JOIN departments d ON (e.department_id = d.department_id)
    GROUP BY department_name
    WITH READ ONLY;

SELECT * FROM V_NUM_OF_DEPTS ORDER BY �ο� DESC;

/*
    �� �μ��� ��� �Ŵ��� ������ �μ� ��ġ�� ����ϴ� VIEW ����
    (�Ŵ����� �����ϴ� ������ ���)
        employees : ������� ���̺�
        departments : �μ����� ���̺�(�Ŵ��� ���� ����)
        locations : �μ���ġ���� ���̺�
        countries : �������� ���̺�
        regions : ������� ���̺�
    ��� ��� ������ �Ŵ����� employee_id �� �����ϰ�� id ���� ��µ��� �ʰ� �Ѵ�.
    VIEW �̸��� V_DEPT_DETAIL ���� �Ѵ�.
*/
CREATE OR REPLACE VIEW V_DEPT_DETAIL
    AS SELECT e.employee_id AS "���"
        , e.first_name || ' ' || e.last_name AS "�����"
        , d.department_name AS "�μ���"
        , (SELECT region_name FROM regions WHERE c.region_id = region_id) AS "���"
        , c.country_name AS "����"
        , NVL(l.state_province, ' ') AS "��"
        , l.street_address AS "�����ּ�"
        , NVL(l.postal_code, ' ') AS "�����ȣ"
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

/* ������ ������Ʈ Ȱ�� ���� */
CREATE SEQUENCE TB_CLASS_REG_SEQ
INCREMENT BY 1 NOCYCLE NOCACHE;

INSERT ALL
    INTO TB_CLASS_REG(REG_ID, STUDENT_NO, CLASS_NO)
    VALUES(TB_CLASS_REG_SEQ.NEXTVAL, STUDENT_NO, CLASS_NO)
    SELECT '2102090001' AS STUDENT_NO
        , class_no AS CLASS_NO
    FROM tb_class
    WHERE class_name in ('��Ʈ��ũ', '�ü��', '���α׷���', 'PCȰ��');
 
INSERT ALL
    INTO TB_CLASS_REG(REG_ID, STUDENT_NO, CLASS_NO)
    VALUES(TB_CLASS_REG_SEQ.NEXTVAL, STUDENT_NO, CLASS_NO)
    SELECT '2102090002' AS STUDENT_NO
        , class_no AS CLASS_NO
    FROM tb_class
    WHERE class_name in ('�ü��', '���α׷���', '�����ͺ��̽�', 'Ŭ����');
 
INSERT ALL
    INTO TB_CLASS_REG(REG_ID, STUDENT_NO, CLASS_NO)
    VALUES(TB_CLASS_REG_SEQ.NEXTVAL, STUDENT_NO, CLASS_NO)
    SELECT '2102090003' AS STUDENT_NO
        , class_no AS CLASS_NO
    FROM tb_class
    WHERE class_name in ('���α׷���', '�����ͺ��̽�', 'Ŭ����', '��Ʈ��ũ');
 
SELECT * FROM TB_CLASS_REG;

SELECT TB_CLASS_REG_SEQ.CURRVAL + 1 FROM DUAL;