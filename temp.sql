SET SERVEROUTPUT ON;

DECLARE
    VAL1   EMPLOYEES.EMPLOYEE_ID%TYPE;
    VAL2   EMPLOYEES.FIRST_NAME%TYPE;
    VAL3   EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT EMPLOYEE_ID
         , FIRST_NAME
         , SALARY
      INTO VAL1, VAL2, VAL3
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = &EMPID;
    IF (VAL3 >= 5000) THEN
        DBMS_OUTPUT.PUT_LINE('사번 ' || VAL1 || '은' || VAL2 || '사원이고 급여는 ' || VAL3 || '으로 5000 이상입니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('사번 ' || VAL1 || '은' || VAL2 || '사원이고 급여는 ' || VAL3 || '으로 5000 미만입니다.');
    END IF;
END;
/

GRANT CONNECT, RESOURCE TO USER1;

SELECT * FROM EMPLOYEES ORDER BY HIRE_DATE DESC;
SELECT *
  FROM (SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
             , RANK() OVER (ORDER BY HIRE_DATE DESC) RNK
          FROM EMPLOYEES)
WHERE RNK <= 5;

SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM (SELECT *
          FROM EMPLOYEES
      ORDER BY HIRE_DATE DESC)
 WHERE ROWNUM <= 5;

SELECT * FROM ALL_USERS WHERE USERNAME = 'DB_USER1';
SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'DB_USER1';
SELECT * FROM DBA_USERS WHERE USERNAME = 'DB_USER1';