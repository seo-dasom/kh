SELECT * FROM tb_department;

/*
    A Table의 정보를 B Table로 복사.
    tb_department의 정보를 temp_department로 복사 (서브쿼리)
    
    temp_department 의 컬럼은 학과명, 정원만 저장하는 테이블로 만든다.
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
    A Table의 정보를 B Table로 복사를 할 때 B Table의 컬럼 데이터 타입을
    A Table과 동일한 데이터 타입으로 사용할 경우 다음의 방식을 사용.
*/
--DROP TABLE temp_department;

CREATE TABLE temp_department
         AS SELECT department_name
                          , capacity
               FROM   tb_department
               WHERE 1 = 0;     -- 생성된 테이블에 데이터를 삽입하지 않을 때 사용

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
    EMPLOYEES 테이블을 사용하여 다음의 조건을 만족하는
    데이터를 추가 생성한 테이블에 저장.
    
    employees_info 테이블은 employee_id, first_name, last_name, phone_number 컬러을 가진다.
    employees_dept 테이블은 employee_id, first_name, last_name, department_id, job_id 컬럼을 가진다.
    
    위 테이블을 생성 후 급여(salary) 항목이 10000 미만인 정보에 대해서만 삽입을 하시오.
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

/* 트랜젝션(INSERT, UPDATE, DELETE)을 실제 DB에 반영 */
COMMIT;

/* 트랜젝션(INSERT, UPDATE, DELETE)을 취소 한다.*/
ROLLBACK;



/* 생성된 테이블 정보 확인 */
SELECT * FROM TAB;

/* 테이블의 컬럼 정보 확인 */
SELECT * FROM USER_TAB_COLUMNS;

/* 특정 테이블의 컬럼 정보 확인 */
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_DEPARTMENT';

/* 컬럼에 적용된 제약조건 확인 */
SELECT * FROM USER_CONS_COLUMNS;

/* 제약조건 확인(상세) */
SELECT * FROM USER_CONSTRAINTS;


SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'TB_DEPARTMENT';
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'EMPLOYEES';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TB_DEPARTMENT';


/*
    제약 조건에 이름을 설정 하는 방법 
    제약 조건이름을 부여하는 규칙(권장)
            테이블명_컬럼명_제약조건
    제약조건(축약어)
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

/* ALTER : 테이블 정보를 수정할 때 사용(추가, 수정, 삭제, 이름변경) */
/* ALTER 로 컬럼 추가 */
ALTER TABLE TEMP2 ADD(
            COL_AGE NUMBER
          , COL_GENDER CHAR(1)
);

/* ALTER 로 제약조건 추가 */
ALTER TABLE TEMP2 ADD (
        CONSTRAINT TMP2_COL_AGE_CK CHECK(COL_AGE > 0 AND COL_AGE <= 150)
      , CONSTRAINT TMP2_COL_GENDER_CK CHECK(COL_GENDER IN ('m', 'w'))
      , CONSTRAINT TMP2_COL_ID_UK UNIQUE(COL_ID)
);

/* ALTER 로 컬럼 수정(제약조건은 삭제 후 새로 추가) */
ALTER TABLE TEMP2 MODIFY (
        COL_NAME VARCHAR2(100)
      , COL_GENDER CHAR(3)
);

/* ALTER 로 컬럼 및 제약조건 삭제 */
ALTER TABLE TEMP2 DROP (
        COL_DATE
      --, COL_AGE
);

ALTER TABLE TEMP2 DROP CONSTRAINT TMP2_COL_AGE_CK;
ALTER TABLE TEMP2 DROP CONSTRAINT TMP2_COL_GENDER_CK;


/* 컬럼명 변경 */
ALTER TABLE TEMP2 RENAME COLUMN COL_NAME TO COL_FNAME;

/* 제약조건명 변경 */
ALTER TABLE TEMP2 RENAME CONSTRAINT TMP2_COL_ID_UK TO TMP2_COL_ID_PK;

/* 테이블명 변경 */
ALTER TABLE TEMP2 RENAME TO RE_TEMP2;

SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'RE_TEMP2';
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'TEMP2';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TEMP2';


SELECT * FROM TAB WHERE TNAME LIKE 'TB_%';

/*
    기존에 생성한 TB_DEPARTMENT, TB_CLASS, TB_PROFESSOR 외 모든 TB 테이블 정보 수정
    
    1. 기존에 설정한 제약조건의 이름을 전부 '테이블명_컬럼명_제약조건' 형식의 이름으로 변경
    2. 모든 컬럼에 VARCHAR2 데이터 타입을 한글 데이터가 충분히 저장될 수 있는 크기로 변경
        이름과 관련된 컬럼은 한글 50자 까지 저장 가능
        주소와 관련된 컬럼은 한글 100자 까지 저장 가능
        과목명/학과명/학과계열과 관련된 컬럼은 한글 25자 까지 저장 가능
        PK로 사용하는 각종 번호 컬럼은 고정길이 문자열로 변경 (10자)
*/

/* TB_DEPARTMENT */
SELECT * FROM TAB;
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_DEPARTMENT';

ALTER TABLE TB_DEPARTMENT RENAME CONSTRAINT SYS_C007102 TO TB_DEPT_NAME_NN;
ALTER TABLE TB_DEPARTMENT RENAME CONSTRAINT SYS_C007103 TO TB_DEPT_OPEN_YN_CK;
ALTER TABLE TB_DEPARTMENT RENAME CONSTRAINT SYS_C007104 TO TB_DEPT_DEPT_NO_PK;

ALTER TABLE TB_DEPARTMENT MODIFY DEPARTMENT_NAME VARCHAR2(75);
ALTER TABLE TB_DEPARTMENT MODIFY CATEGORY VARCHAR2(75);

/* TB_PROFESSOR */
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_PROFESSOR';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TB_PROFESSOR';

ALTER TABLE TB_PROFESSOR RENAME CONSTRAINT SYS_C007105 TO TB_PROF_PROF_NAME_NN;
ALTER TABLE TB_PROFESSOR RENAME CONSTRAINT SYS_C007106 TO TB_PROF_PROF_NO_PK;
ALTER TABLE TB_PROFESSOR RENAME CONSTRAINT SYS_C007107 TO TB_PROF_DEPT_NO_FK;

ALTER TABLE TB_PROFESSOR MODIFY PROFESSOR_NAME VARCHAR2(150);
ALTER TABLE TB_PROFESSOR MODIFY PROFESSOR_ADDRESS VARCHAR2(30);

/* TB_STUDENT */
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_STUDENT';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TB_STUDENT';
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'TB_STUDENT';

ALTER TABLE TB_STUDENT RENAME CONSTRAINT SYS_C007108 TO TB_STUD_DEPT_NO_NN;
ALTER TABLE TB_STUDENT RENAME CONSTRAINT SYS_C007109 TO TB_STUD_STUD_NAME_NN;
ALTER TABLE TB_STUDENT RENAME CONSTRAINT SYS_C007110 TO TB_STUD_ABSE_YN_CK;
ALTER TABLE TB_STUDENT RENAME CONSTRAINT SYS_C007111 TO TB_STUD_STUD_NO_PK;
ALTER TABLE TB_STUDENT RENAME CONSTRAINT SYS_C007112 TO TB_STUD_DEPT_NO_FK;
ALTER TABLE TB_STUDENT RENAME CONSTRAINT SYS_C007113 TO TB_STUD_COCH_NO_FK;

ALTER TABLE TB_STUDENT MODIFY STUDENT_NAME VARCHAR2(150);
ALTER TABLE TB_STUDENT MODIFY STUDENT_ADDRESS VARCHAR2(300);

/* TB_CLASS */
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_CLASS';

ALTER TABLE TB_CLASS RENAME CONSTRAINT SYS_C007114 TO TB_CLS_DEPT_NO_NN;
ALTER TABLE TB_CLASS RENAME CONSTRAINT SYS_C007115 TO TB_CLS_CLS_NAME_NN;
ALTER TABLE TB_CLASS RENAME CONSTRAINT SYS_C007116 TO TB_CLS_CLS_NO_PK;
ALTER TABLE TB_CLASS RENAME CONSTRAINT SYS_C007117 TO TB_CLS_DEPT_NO_FK;
ALTER TABLE TB_CLASS RENAME CONSTRAINT SYS_C007118 TO TB_CLS_PRE_CLS_NO_FK;

ALTER TABLE TB_CLASS MODIFY CLASS_NAME VARCHAR2(75);

/* TB_CLASS_PROFESSOR */
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_CLASS_PROFESSOR';

 ALTER TABLE TB_CLASS_PROFESSOR RENAME CONSTRAINT SYS_C007119 TO TB_CLS_PROF_PROF_NO_PK;
 ALTER TABLE TB_CLASS_PROFESSOR RENAME CONSTRAINT SYS_C007120 TO TB_CLS_PROF_CLS_NO_FK;
 ALTER TABLE TB_CLASS_PROFESSOR RENAME CONSTRAINT SYS_C007121 TO TB_CLS_PROF_PROF_NO_FK;

/* TB_GRADE */
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TB_GRADE';

 ALTER TABLE TB_GRADE RENAME CONSTRAINT SYS_C007122 TO TB_GRD_TERM_CLS_STUD_NO_PK;
 ALTER TABLE TB_GRADE RENAME CONSTRAINT SYS_C007123 TO TB_GRD_CLS_NO_FK;
 ALTER TABLE TB_GRADE RENAME CONSTRAINT SYS_C007124 TO TB_GRD_STUD_NO_FK;

/* 제약조건 이름을 바꾸기 위해 기존 정보를 활용 */
--SELECT ' ALTER TABLE ' || TABLE_NAME || ' RENAME CONSTRAINT ' || CONSTRAINT_NAME || ' TO ' ||
--            TABLE_NAME || '_' || COLUMN_NAME || ';'
--FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'TB_STUDENT';

/*
    3. TB_CLASS_TYPE 이라는 테이블을 다음의 컬럼을 사용하는 것으로 추가 한다.
                TYPE_ID          NUMBER               PRIMARY KEY
                TYPE_NAME   VARCHAR2(24)      NOT NULL
        TB_CLASS_TYPE의 TYPE_ID 컬럼을 참조하는 TB_CLASS 테이블의 컬럼으로 CLASS_TYPE을 지정한다.
        TB_CLASS의 CLASS_TYPE은 TB_CLASS_TYPE의 TYPE_ID를 참조하기 때문에 데이터 타입도 그에 맞춘다.
*/
CREATE TABLE TB_CLASS_TYPE (
                TYPE_ID NUMBER CONSTRAINT TB_CLS_TYPE_ID PRIMARY KEY
            ,   TYPE_NAME VARCHAR2(24) CONSTRAINT TB_CLS_TYPE_TYPE_NAME NOT NULL
);
INSERT INTO TB_CLASS_TYPE VALUES(1, '전공필수');
INSERT INTO TB_CLASS_TYPE VALUES(2, '전공선택');
INSERT INTO TB_CLASS_TYPE VALUES(3, '교양필수');
INSERT INTO TB_CLASS_TYPE VALUES(4, '교양선택');

/* 임시로 사용할 컬럼을 생성 후 기존 데이터를 복사 기존 컬럼 삭제 후 재생성 하고 임시 컬럼의 데이터를 다시 복사 */
ALTER TABLE TB_CLASS ADD TEMP_COL NUMBER;
UPDATE TB_CLASS
    SET CLASS_TYPE = DECODE(CLASS_TYPE,
                                                   '전필', 1,
                                                   '전선', 2,
                                                   '교필', 3,
                                                   '교일', 4
                                                   );
ALTER TABLE TB_CLASS DROP COLUMN CLASS_TYPE;
ALTER TABLE TB_CLASS ADD CLASS_TYPE NUMBER;
UPDATE TB_CLASS SET CLASS_TYPE = TEMP_COL;
ALTER TABLE TB_CLASS DROP COLUMN TEMP_COL;
ALTER TABLE TB_CLASS ADD CONSTRAINT TB_CLS_CLS_TYPE_FK FOREIGN KEY(CLASS_TYPE) REFERENCES TB_CLASS_TYPE(TYPE_ID);

ALTER TABLE TB_CLASS MODIFY CLASS_TYPE NUMBER;

SELECT * FROM TB_CLASS;
/*
    4. TB_STUDENT 테이블에 성별(STUDENT_GENDER) 컬럼을 추가한다. 데이터 타입은 VARCHAR2(3)이며,
        제약조건으로는 '남', '여' 만 저장할 수 있게 한다.
        
*/
ALTER TABLE TB_STUDENT ADD STUDENT_GENDER VARCHAR2(3)
    CONSTRAINT TB_STUD_STUD_GEN_CK CHECK(STUDENT_GENDER IN ('남', '여'));

/*
    5. TB_CLASS_REG 테이블은 모든 학생들의 수강과목을 등록하기 위한 테이블로 생성한다.
            등록번호    REG_ID            NUMBER              PRIMARY KEY
            학생번호    STUDENT_NO  VARCHAR2(10)      FK
            과목번호    CLASS_NO      VARCHAR2(10)      FK
*/
CREATE TABLE TB_CLASS_REG (
     REG_ID NUMBER CONSTRAINT TB_CLS_REG_REG_ID PRIMARY KEY
    ,STUDENT_NO VARCHAR2(10)
    ,CLASS_NO VARCHAR2(10)
    ,CONSTRAINT TB_CLS_REG_STUD_NO FOREIGN KEY(STUDENT_NO) REFERENCES TB_STUDENT(STUDENT_NO)
    ,CONSTRAINT TB_CLS_REG_CLS_NO FOREIGN KEY(CLASS_NO) REFERENCES TB_CLASS(CLASS_NO)
);