-- �� �� ���� �Ŀ��� ��� ������. ��, ���� �����ϰ� �ִ� ���� ���ȿ��� ������
SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
END;
/

DECLARE
    -- ���� �� ��� �����
    -- ��� ������ ������Ÿ�� �տ� CONSTANT Ű���带 ���δ�.
    -- ������ ������Ÿ��;   ������ ������Ÿ�� := �ʱⰪ;
    -- ������ CONSTANT ������Ÿ�� := �ʱⰪ;
    n NUMBER := 10;
    s VARCHAR2(100) := '���ڿ�';
BEGIN
    -- �����
    n := n + 1;
    s := '�� ����';
    DBMS_OUTPUT.PUT_LINE(n);
    DBMS_OUTPUT.PUT_LINE(s);
END;
/


DECLARE
    -- ������ ������ Ÿ���� ���� ���̺��� �÷��� ������ Ÿ���� �����Ͽ� ���.
    -- ���̺��. �÷���%TYPE �� ���������� ���
    salary employees.salary%TYPE;
    name employees.first_name%TYPE;
BEGIN
    -- �����
    salary := 1000;
    name := '���ټ�';
    DBMS_OUTPUT.PUT_LINE(salary);
    DBMS_OUTPUT.PUT_LINE(name);
END;
/


DECLARE
    -- ������ ������ Ÿ���� ���� ���̺��� �÷��� ������ Ÿ���� �����Ͽ� ���.
    -- ���̺��. �÷���%TYPE �� ���������� ���
    salary employees.salary%TYPE;
    name employees.first_name%TYPE;
    input VARCHAR(10);
BEGIN
    input := '107';
    -- �����
    SELECT emp.SALARY
        , emp.first_name || ' ' || emp.last_name
        INTO salary, name
    FROM employees emp
    WHERE emp.employee_id = input;  -- &������ �������� ����ϸ� ����� �Է��� ���� �� �ִ�.
    DBMS_OUTPUT.PUT_LINE(name || '���� �޿� : ' || salary || ' �޷�');
END;
/


DECLARE
    /*
        ����� ������ ���� ������ ������.
            IF ���ǽ� THEN
                �����ڵ�
            ELSIF ���ǽ� THEN      // ELSIF ���� ����, �ݺ���� ����
                �����ڵ�
            ELSE                           // ELSE ���� ����
                �����ڵ�
            END IF;
    */
    salary employees.salary%TYPE;
    name employees.first_name%TYPE;
    level VARCHAR(12);
    input VARCHAR(10);
BEGIN
     input := '108';
     level := '���ҵ�';

    SELECT emp.SALARY
        , emp.first_name || ' ' || emp.last_name
        INTO salary, name
    FROM employees emp
    WHERE emp.employee_id = input;
    
    IF salary BETWEEN 0 AND 2500 THEN
        level := '���ҵ�';
    ELSIF salary BETWEEN 2500 AND 5000 THEN
        level := '�߰��ҵ�';
    ELSIF salary BETWEEN 5000 AND 7500 THEN
        level := '��ҵ�';
    ELSE
        level := '�ְ�ҵ�';
    END IF;
    DBMS_OUTPUT.PUT_LINE(name || '���� �޿� : ' || salary || ' �޷��� ' || level || ' �Դϴ�.');
END;
/


    /*
        �ݺ����� LOOP, WHILE LOOP, FOR LOOP �� ������ ��� ������ ������ ����.
        -- LOOP : ���� ������ ������ ���� �ݺ�(EXIT Ű����� ���� ����)
            LOOP
                �ݺ� ���� �ڵ�
            END LOOP;
        
        -- WHILE LOOP : ���� ������ ������ ���� �ݺ�(EXIT Ű����� ���� ����)
            WHILE ���ǽ� LOOP
                �ݺ� ���� �ڵ�
            END LOOP;
        
        -- FOR LOOP : ������ ����(����, SELECT ���) �ȿ����� �ݺ�
            FOR ������ IN ���� LOOP
                �ݺ� ���� �ڵ�
            END LOOP;
        
        FOR LOOP ���� ���� ������ ������ ������ ����Ѵ�.
        ���۰�..���ᰪ
        1 ���� 10 ���� �ݺ� -> FOR n IN 1..10 LOOP
        
    */
DECLARE
    cnt NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('�ݺ� Ƚ�� : ' || cnt);
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
        DBMS_OUTPUT.PUT_LINE('WHILE �ݺ� Ƚ�� : ' || cnt);
        cnt := cnt + 1;
    END LOOP;
END;
/


BEGIN
    FOR n IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE('FOR �ݺ� Ƚ�� : ' || n);
    END LOOP;
END;
/


BEGIN
    FOR row_data IN (SELECT emp.employee_id, emp.salary FROM employees emp)  LOOP
        DBMS_OUTPUT.PUT_LINE(row_data.employee_id || ' ����� �޿��� ' || row_data.salary || ' �޷� �Դϴ�.');
    END LOOP;
END;
/



/*
    %ROWTYPE ���� : ������ �����ϴ� ������ Ÿ���� Ư�� ���̺��� ����ϴ� �÷���
    ������ Ÿ���� �״�� ����� �� �ְ� ����� Ÿ��
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
    �迭 : ORACLE������ ���̺� Ÿ���� �迭ó�� ���
*/
DECLARE
    TYPE ARR_TYPE IS VARRAY(10) OF NUMBER;  -- �迭�� ũ�� ����
    n ARR_TYPE := ARR_TYPE(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  -- �ʱ�ȭ �ʼ�
    
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
        DBMS_OUTPUT.PUT_LINE(i || '�ε����� ����� �� : ' || n(i));
    END LOOP;
    
    FOR i IN 1..5 LOOP
        m(i) := 1000 + (200 * i);
        DBMS_OUTPUT.PUT_LINE(i || '�ε����� ����� �� : ' || m(i));
    END LOOP;
    
    j('a') := 65;
    j('b') := 66;
    j('c') := 67;
    
    DBMS_OUTPUT.PUT_LINE('a �ε����� ����� �� : ' || j('a'));
    DBMS_OUTPUT.PUT_LINE('b �ε����� ����� �� : ' || j('b'));
    DBMS_OUTPUT.PUT_LINE('c �ε����� ����� �� : ' || j('c'));
    
    rec.rec_id := '123456789';
    rec.rec_name := '���ټ�';
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
    ��� ���̺��� commission_pct �÷��� ���� �ִ� �׸�鸸 �߷�����
    ���� ���ʽ� ���� ���� ���̺� �����͸� �߰��� PL/SQL ������ �ۼ�
    
    ���� ���ʽ� ���� ���� ���̺��� ������ ������ ����.
        TABLE NAME : YEAR_BONUS
        COLUMN
            ID                        NUMBER            // �⺻Ű, �ڵ�������� Ȱ��
            YEAR                  CHAR(4)             // 4�ڸ� �⵵�� ����ȴ�.
            EMPLOYEE_ID    VARCHAR2(10)   // ���ʽ��� ������ ��� ID
            BONUS                NUMBER           // ������ ���ʽ� �ݾ� (SALARY * COMMISSION_PCT)
*/

/* ������ ������Ʈ ���� */
CREATE SEQUENCE SEQ_YEAR_BONUS_ID NOCYCLE NOCACHE;

/* ���� ���ʽ� ���� ���� ���̺� ���� */
CREATE TABLE YEAR_BONUS (
      ID                     NUMBER            CONSTRAINT YEAR_BONUS_ID_PK PRIMARY KEY
    , YEAR               CHAR(4)
    , EMPLOYEE_ID VARCHAR2(10)
    , BONUS             NUMBER
);

DECLARE
    saved CHAR(1) := 'N';
BEGIN
    -- �̹� ����� �����Ͱ� �ִ� ��� �߰��� ���� �ʵ��� �Ѵ�.
    -- �̹� ����� �����͸� Ȯ���ϴ� ����� YEAR, EMPLOYEE_ID�� ��ȸ�Ͽ�
    -- �˻��� ����� �ִ� ���� üũ �Ѵ�.
    FOR rec IN  (SELECT EXTRACT(YEAR FROM SYSDATE) AS "�⵵"
                        , emp.employee_id AS "���"
                        , emp.salary * emp.commission_pct AS "���ʽ��ݾ�"
                        FROM employees emp
                        WHERE emp.commission_pct IS NOT NULL) LOOP
        SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.�⵵ AND EMPLOYEE_ID = rec.���) THEN
                'Y'
                ELSE 'N' END
            INTO saved
            FROM DUAL;
        
        IF saved = 'N' THEN
            INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.�⵵, rec.���, rec.���ʽ��ݾ�);
            --DBMS_OUTPUT.PUT_LINE('�߰���!!!');
        --ELSE
            --DBMS_OUTPUT.PUT_LINE('�߰� ����!!!');
        END IF;
    END LOOP;
END;
/


/* ���ν��� ���� */
CREATE OR REPLACE PROCEDURE PROC_TEMP1
IS
    -- DECLARE ���� ���� ������ �κ��� ���⿡ �ۼ�
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
        FOR rec IN  (SELECT EXTRACT(YEAR FROM SYSDATE) AS "�⵵"
                            , emp.employee_id AS "���"
                            , emp.salary * emp.commission_pct AS "���ʽ��ݾ�"
                            FROM employees emp
                            WHERE emp.commission_pct IS NOT NULL) LOOP
            SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.�⵵ AND EMPLOYEE_ID = rec.���) THEN
                    'Y'
                    ELSE 'N' END
                INTO saved
                FROM DUAL;
            
            IF saved = 'N' THEN
                INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                    VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.�⵵, rec.���, rec.���ʽ��ݾ�);
            END IF;
        END LOOP;
    END;
END;
/

SELECT * FROM USER_SOURCE WHERE NAME = 'PROC_YEAR_BONUS';
SELECT * FROM YEAR_BONUS;
DELETE FROM YEAR_BONUS;

EXECUTE PROC_YEAR_BONUS;



/* �Ű������� �ִ� ���ν��� ���� */
CREATE OR REPLACE PROCEDURE PROC_TEMP2(
          x IN NUMBER       -- IN : �ܺο��� ���� �Ű�����
        , y IN VARCHAR2
        , res OUT NUMBER -- OUT : �ܺο��� ���� �� �� �ְ� ���� �Ű�����
)
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('�ܺο��� ������ x �� : ' || x);
    DBMS_OUTPUT.PUT_LINE('�ܺο��� ������ y �� : ' || y);
    res := 1;
END;
/

DECLARE
    res NUMBER;
BEGIN
    -- BEGIN �ȿ��� ���ν��� ���� �� ���� EXECUTE �ʿ� ����.
    proc_temp2(10, '���ڿ�', res);
    DBMS_OUTPUT.PUT_LINE('���ν������� ������ res �� : ' || res);
END;
/

/* PL/SQL ���� �ۿ� ���� ���� �� ��� */
VARIABLE var1 NUMBER;
VARIABLE var2 VARCHAR2(10);
VARIABLE res NUMBER;

EXECUTE :var1 := 10;
EXECUTE :var2 := '���ڿ�';

EXECUTE proc_temp2(:var1, :var2, :res);
PRINT res;



CREATE OR REPLACE PROCEDURE PROC_YEAR_BONUS2(
           RES OUT NUMBER        -- �ݿ� ��� ��
        ,  YEAR IN VARCHAR2 := EXTRACT(YEAR FROM SYSDATE) -- �⺻�� ����
)
IS
BEGIN
    DECLARE
        saved CHAR(1) := 'N';
    BEGIN
        RES := 0;
        FOR rec IN  (SELECT YEAR AS "�⵵"
                            , emp.employee_id AS "���"
                            , emp.salary * emp.commission_pct AS "���ʽ��ݾ�"
                            FROM employees emp
                            WHERE emp.commission_pct IS NOT NULL) LOOP
            SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.�⵵ AND EMPLOYEE_ID = rec.���) THEN
                    'Y'
                    ELSE 'N' END
                INTO saved
                FROM DUAL;
            
            IF saved = 'N' THEN
                INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                    VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.�⵵, rec.���, rec.���ʽ��ݾ�);
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
    DBMS_OUTPUT.PUT_LINE('���� ��� �ݿ� �� : ' || RES);
    
    PROC_YEAR_BONUS2(RES, '2020');
    DBMS_OUTPUT.PUT_LINE('���� ��� �ݿ� �� : ' || RES);
END;
/



CREATE OR REPLACE FUNCTION FUNC_YEAR_BONUS(
        YEAR VARCHAR2       -- �Ű�����
) RETURN NUMBER         -- ��ȯ�� ���� Ÿ���� ����
IS
    RES NUMBER;
BEGIN
    DECLARE
        saved CHAR(1) := 'N';
    BEGIN
        RES := 0;
        FOR rec IN  (SELECT YEAR AS "�⵵"
                            , emp.employee_id AS "���"
                            , emp.salary * emp.commission_pct AS "���ʽ��ݾ�"
                            FROM employees emp
                            WHERE emp.commission_pct IS NOT NULL) LOOP
            SELECT CASE WHEN EXISTS(SELECT 'Y' FROM YEAR_BONUS WHERE YEAR = rec.�⵵ AND EMPLOYEE_ID = rec.���) THEN
                    'Y'
                    ELSE 'N' END
                INTO saved
                FROM DUAL;
            
            IF saved = 'N' THEN
                INSERT INTO YEAR_BONUS(id, year, employee_id, bonus)
                    VALUES(SEQ_YEAR_BONUS_ID.NEXTVAL, rec.�⵵, rec.���, rec.���ʽ��ݾ�);
                RES := RES + 1;
            END IF;
        END LOOP;
        RETURN RES;
    END;
END;
/
SELECT FUNC_YEAR_BONUS('2021') FROM DUAL;   -- �Լ� ����

VARIABLE RES NUMBER;
EXEC :RES := FUNC_YEAR_BONUS('2021');
PRINT RES;

/* ������ �Լ� Ȯ�� */
SELECT * FROM USER_SOURCE WHERE NAME = 'FUNC_YEAR_BONUS';



/*
    YEAR2T04() FUNCTION �����غ���
        - �� �Լ��� 2�ڸ� �⵵ ������ ��¥ ���ڿ��� 4�ڸ� ������ ��¥ ���ڿ��� ��ȯ�ϴ� �Լ���.
        - �⺻������ 70 ~ 99 ������ 1970 ~ 1999 �� ��ȯ�ϰ� 00 ~ 69 ������ 2000 ~ 2069�� ��ȯ ��Ű�� �Ѵ�.
        - ��ȯ���ؿ� ���� 20����� 1970 ~ 2069 ������ ��ȯ�ϰ� �ϰ� 21����� 2070 ~ 2169�� ��ȯ ��Ű�� �Ѵ�.(�⺻���� 20�����.)
*/

/*
    JUMNtoDATE() FUNCTION �����غ���
        - �� �Լ��� �ֹε�Ϲ�ȣ ���ڸ� 7�ڸ��� �̿��Ͽ� ��¥�� ��ȯ�ϴ� �Լ���.
        - �ֹε�Ϲ�ȣ �� 6�ڸ��� ��������� ǥ���ϸ�, �⵵�� 2�ڸ� �⵵�̴�. �̸� ��¥�� ��ȯ�� �Ѵ�.
        - �ֹε�Ϲ�ȣ�� 7��° �ڸ��� ��/�� ������ ������ 1800�⵵ 1900�⵵ 2000�⵵ ���� ������ �� �� �ִ�.
          1, 2�� 1900 ~ 1999�� 3, 4�� 2000 ~ 2099�� 9, 0�� 1800 ~ 1899�� �����̴�. (5 ~ 8 �ܱ���)
        - �������� �ִ� �ֹι�ȣ ���� �Ǵ� �������� ���� �ֹι�ȣ ���Ŀ� ���� �����ϵ��� �Ѵ�.
*/