/*
 *      WORKBOOK 실습의 Table 기술서를 참고
 */

DROP TABLE TB_GRADE;
DROP TABLE TB_CLASS_PROFESSOR;
DROP TABLE TB_CLASS;
DROP TABLE TB_STUDENT;
DROP TABLE TB_PROFESSOR;
DROP TABLE TB_DEPARTMENT;

CREATE TABLE TB_DEPARTMENT(
                         department_no VARCHAR2(10) PRIMARY KEY,
                         department_name VARCHAR2(20) NOT NULL,
                         category VARCHAR2(20),
                         open_yn CHAR(1) CHECK(open_yn IN ('y', 'n')),
                         capacity NUMBER
);

CREATE TABLE TB_PROFESSOR (
                         professor_no VARCHAR2(10) PRIMARY KEY,
                         professor_name VARCHAR2(30) NOT NULL,
                         professor_ssn VARCHAR2(14),
                         professor_address VARCHAR2(100),
                         department_no VARCHAR2(10) REFERENCES TB_DEPARTMENT(department_no)
);

CREATE TABLE TB_STUDENT(
                         student_no VARCHAR2(10) PRIMARY KEY,
                         department_no VARCHAR2(10) NOT NULL REFERENCES TB_DEPARTMENT(department_no),
                         student_name VARCHAR2(30) NOT NULL,
                         student_ssn VARCHAR2(14),
                         student_address VARCHAR2(100),
                         entrance_date DATE,
                         absence_yn CHAR(1) CHECK(absence_yn IN ('y', 'n')),
                         coach_professor_no VARCHAR2(10),
                         FOREIGN KEY(coach_professor_no) REFERENCES TB_PROFESSOR(professor_no)
);

CREATE TABLE TB_CLASS(
                         class_no VARCHAR2(10) PRIMARY KEY,
                         department_no VARCHAR2(10) NOT NULL REFERENCES TB_DEPARTMENT(department_no),
                         preattending_class_no VARCHAR2(10) REFERENCES TB_CLASS(class_no) ON DELETE SET NULL,
                         class_name VARCHAR2(30) NOT NULL,
                         class_type VARCHAR2(10)
);

CREATE TABLE TB_CLASS_PROFESSOR(
                         class_no VARCHAR2(10),
                         professor_no VARCHAR2(10),
                         PRIMARY KEY(class_no, professor_no),
                         FOREIGN KEY(class_no) REFERENCES TB_CLASS(class_no),
                         FOREIGN KEY(professor_no) REFERENCES TB_PROFESSOR(professor_no)
);

CREATE TABLE TB_GRADE(
                         term_no VARCHAR2(10),
                         class_no VARCHAR2(10),
                         student_no VARCHAR2(10),
                         point NUMBER(3, 2),
                         PRIMARY KEY (term_no, class_no, student_no),
                         FOREIGN KEY(class_no)   REFERENCES TB_CLASS(class_no),
                         FOREIGN KEY(student_no) REFERENCES TB_STUDENT(student_no)
);
