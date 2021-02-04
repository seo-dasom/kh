DESC TB_DEPARTMENT;

--DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY
INSERT INTO tb_department VALUES('10000000', '컴퓨터공학', '공학부', 'y', 300);
INSERT INTO tb_department VALUES('10000001', '소프트웨어', '공학부', 'y', 150);
INSERT INTO tb_department VALUES('10000002', '건축', '공학부', 'y', 350);
INSERT INTO tb_department VALUES('10000003', '통계', '수학부', null, 100);
INSERT INTO tb_department VALUES('10000004', '인공지능', '공학부', null, 100);

/* null 데이터를 'y'로 수정 */
UPDATE tb_department
    SET open_yn = 'y'
WHERE open_yn IS NULL;

/* capacity를 10% 증가 */
UPDATE tb_department
    SET capacity = TRUNC(capacity + (capacity * 0.1), 0);


DELETE
    FROM tb_department
WHERE category = '수학부';

DELETE
    FROM tb_department
WHERE capacity <=200;

SELECT * FROM tb_department;

/*
    1. 학과 3개를 개설한다. ( 컴퓨터공학, 수학과, 신소재공학)
        학과 번호는 개설 순서에 따라 4자리 년도 월 일 순번의 조합을 사용 -> 2021020301
        정원은 순서대로 150명, 100명, 200명 으로 생성
        
    2. 교수 3명을 등록. (홍길동, 김병수, 박제현)
        컴퓨터공학 담당 교수(홍길동), 수학과 담당 교수(김병수), 신소재공학 담당 교수(박제현)
        교수 번호는 2자리 년도 월 일 순번의 조합을 사용 -> 2102030001
    
    3. 과목 등록을 한다.
        각 학과에 적합한 과목을 등록한다.
        과목 번호는 등록 순서에 따라  2자리 년도 월 일 순번의 조합을 사용 -> 2102030001
        초기에 모든 과목은 선수 과목이 없는 것으로 한다.
        과목구분은 전필, 전일, 교필, 교일 으로 구분한다.
        학과당 5개의 과목을 등록, 전필 2개, 전일 1개, 교필 1개, 교일 1개로 등록
*/

INSERT INTO tb_department VALUES('2021020301', '컴퓨터', '공학', 'y', 150);
INSERT INTO tb_department VALUES('2021020302', '수학', '이학', 'y', 100);
INSERT INTO tb_department VALUES('2021020303', '신소재', '공학', 'y', 200);

INSERT INTO tb_professor VALUES('2102030001', '홍길동', null, null, '2021020301');
INSERT INTO tb_professor VALUES('2102030002', '김병수', null, null, '2021020302');
INSERT INTO tb_professor VALUES('2102030003', '박제현', null, null, '2021020303');

INSERT INTO tb_class VALUES('2102030001', '2021020301', null, '네트워크', '전필');
INSERT INTO tb_class VALUES('2102030002', '2021020301', null, '운영체제', '전필');
INSERT INTO tb_class VALUES('2102030003', '2021020301', null, '프로그래밍', '전일');
INSERT INTO tb_class VALUES('2102030004', '2021020301', null, 'PC활용', '교필');
INSERT INTO tb_class VALUES('2102030005', '2021020301', null, '영어회화', '교일');
INSERT INTO tb_class VALUES('2102030006', '2021020302', null, '이산수학', '전필');
INSERT INTO tb_class VALUES('2102030007', '2021020302', null, '확률통계', '전필');
INSERT INTO tb_class VALUES('2102030008', '2021020302', null, '응용수학', '전일');
INSERT INTO tb_class VALUES('2102030009', '2021020302', null, '문학과철학', '교필');
INSERT INTO tb_class VALUES('2102030010', '2021020302', null, '경영학개론', '교일');
INSERT INTO tb_class VALUES('2102030011', '2021020303', null, '금속열역학', '전필');
INSERT INTO tb_class VALUES('2102030012', '2021020303', null, '소재과학', '전필');
INSERT INTO tb_class VALUES('2102030013', '2021020303', null, '나노소재', '전일');
INSERT INTO tb_class VALUES('2102030014', '2021020303', null, '산업경제', '교필');
INSERT INTO tb_class VALUES('2102030015', '2021020303', null, '영작문', '교일');

/*
    데이터 입력 과정에서 다음의 문제가 발생하였다 이를 수정하기 위한 DML을 작성하시오.
    
    1. 김병수 교수님의 성함은 김병주이다.
    2. 박제현 교수님의 담당 과목은 신소재가 아닌 컴퓨터이며, 홍길동 교수님의 담당과목은 신소재이다.
    3. 모든 학과의 정원을 20% 늘려라.
    4. 컴퓨터 공학의 전공일반인 프로그래밍 과목은 전공필수로 수정하시오.
    5. 전일로 저장한 데이터를 전선(전공선택) 으로 변경하시오.
*/

UPDATE tb_professor
    SET professor_name = '김병주'
WHERE professor_name = '김병수';

UPDATE tb_professor
    SET department_no = '2021020301'
WHERE professor_name = '박제현';

UPDATE tb_professor
    SET department_no = '2021020303'
WHERE professor_name = '홍길동';

UPDATE tb_department
    SET capacity = (capacity * 1.2);
    
UPDATE tb_class
    SET class_type = '전필'
WHERE department_no = '2021020301'
    AND class_name = '프로그래밍'
    AND class_type = '전일';

UPDATE tb_class
    SET class_type = '전선'
WHERE class_type = '전일';

SELECT * FROM tb_department;
SELECT * FROM tb_professor;
SELECT * FROM tb_class;