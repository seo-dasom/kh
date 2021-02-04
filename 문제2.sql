DESC TB_DEPARTMENT;

--DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY
INSERT INTO tb_department VALUES('10000000', '��ǻ�Ͱ���', '���к�', 'y', 300);
INSERT INTO tb_department VALUES('10000001', '����Ʈ����', '���к�', 'y', 150);
INSERT INTO tb_department VALUES('10000002', '����', '���к�', 'y', 350);
INSERT INTO tb_department VALUES('10000003', '���', '���к�', null, 100);
INSERT INTO tb_department VALUES('10000004', '�ΰ�����', '���к�', null, 100);

/* null �����͸� 'y'�� ���� */
UPDATE tb_department
    SET open_yn = 'y'
WHERE open_yn IS NULL;

/* capacity�� 10% ���� */
UPDATE tb_department
    SET capacity = TRUNC(capacity + (capacity * 0.1), 0);


DELETE
    FROM tb_department
WHERE category = '���к�';

DELETE
    FROM tb_department
WHERE capacity <=200;

SELECT * FROM tb_department;

/*
    1. �а� 3���� �����Ѵ�. ( ��ǻ�Ͱ���, ���а�, �ż������)
        �а� ��ȣ�� ���� ������ ���� 4�ڸ� �⵵ �� �� ������ ������ ��� -> 2021020301
        ������ ������� 150��, 100��, 200�� ���� ����
        
    2. ���� 3���� ���. (ȫ�浿, �躴��, ������)
        ��ǻ�Ͱ��� ��� ����(ȫ�浿), ���а� ��� ����(�躴��), �ż������ ��� ����(������)
        ���� ��ȣ�� 2�ڸ� �⵵ �� �� ������ ������ ��� -> 2102030001
    
    3. ���� ����� �Ѵ�.
        �� �а��� ������ ������ ����Ѵ�.
        ���� ��ȣ�� ��� ������ ����  2�ڸ� �⵵ �� �� ������ ������ ��� -> 2102030001
        �ʱ⿡ ��� ������ ���� ������ ���� ������ �Ѵ�.
        ���񱸺��� ����, ����, ����, ���� ���� �����Ѵ�.
        �а��� 5���� ������ ���, ���� 2��, ���� 1��, ���� 1��, ���� 1���� ���
*/

INSERT INTO tb_department VALUES('2021020301', '��ǻ��', '����', 'y', 150);
INSERT INTO tb_department VALUES('2021020302', '����', '����', 'y', 100);
INSERT INTO tb_department VALUES('2021020303', '�ż���', '����', 'y', 200);

INSERT INTO tb_professor VALUES('2102030001', 'ȫ�浿', null, null, '2021020301');
INSERT INTO tb_professor VALUES('2102030002', '�躴��', null, null, '2021020302');
INSERT INTO tb_professor VALUES('2102030003', '������', null, null, '2021020303');

INSERT INTO tb_class VALUES('2102030001', '2021020301', null, '��Ʈ��ũ', '����');
INSERT INTO tb_class VALUES('2102030002', '2021020301', null, '�ü��', '����');
INSERT INTO tb_class VALUES('2102030003', '2021020301', null, '���α׷���', '����');
INSERT INTO tb_class VALUES('2102030004', '2021020301', null, 'PCȰ��', '����');
INSERT INTO tb_class VALUES('2102030005', '2021020301', null, '����ȸȭ', '����');
INSERT INTO tb_class VALUES('2102030006', '2021020302', null, '�̻����', '����');
INSERT INTO tb_class VALUES('2102030007', '2021020302', null, 'Ȯ�����', '����');
INSERT INTO tb_class VALUES('2102030008', '2021020302', null, '�������', '����');
INSERT INTO tb_class VALUES('2102030009', '2021020302', null, '���а�ö��', '����');
INSERT INTO tb_class VALUES('2102030010', '2021020302', null, '�濵�а���', '����');
INSERT INTO tb_class VALUES('2102030011', '2021020303', null, '�ݼӿ�����', '����');
INSERT INTO tb_class VALUES('2102030012', '2021020303', null, '�������', '����');
INSERT INTO tb_class VALUES('2102030013', '2021020303', null, '�������', '����');
INSERT INTO tb_class VALUES('2102030014', '2021020303', null, '�������', '����');
INSERT INTO tb_class VALUES('2102030015', '2021020303', null, '���۹�', '����');

/*
    ������ �Է� �������� ������ ������ �߻��Ͽ��� �̸� �����ϱ� ���� DML�� �ۼ��Ͻÿ�.
    
    1. �躴�� �������� ������ �躴���̴�.
    2. ������ �������� ��� ������ �ż��簡 �ƴ� ��ǻ���̸�, ȫ�浿 �������� �������� �ż����̴�.
    3. ��� �а��� ������ 20% �÷���.
    4. ��ǻ�� ������ �����Ϲ��� ���α׷��� ������ �����ʼ��� �����Ͻÿ�.
    5. ���Ϸ� ������ �����͸� ����(��������) ���� �����Ͻÿ�.
*/

UPDATE tb_professor
    SET professor_name = '�躴��'
WHERE professor_name = '�躴��';

UPDATE tb_professor
    SET department_no = '2021020301'
WHERE professor_name = '������';

UPDATE tb_professor
    SET department_no = '2021020303'
WHERE professor_name = 'ȫ�浿';

UPDATE tb_department
    SET capacity = (capacity * 1.2);
    
UPDATE tb_class
    SET class_type = '����'
WHERE department_no = '2021020301'
    AND class_name = '���α׷���'
    AND class_type = '����';

UPDATE tb_class
    SET class_type = '����'
WHERE class_type = '����';

SELECT * FROM tb_department;
SELECT * FROM tb_professor;
SELECT * FROM tb_class;