
CREATE TABLE mytable(
              col1 CHAR(10),
              col2 NVARCHAR2(10),
              col3 NUMBER,
              col4 NUMBER(5),
              col5 NUMBER(5, 2)
);

/* ���̺� ���� */
DROP TABLE mytable;

/* ���� ���� �������� ����� �� �ִ� Table ��� �˻� */
SELECT * FROM TAB;

/* ������ ���̺��� �÷� ���� ��� */
DESC mytable;

COMMENT ON COLUMN mytable.col1 IS '�ּ��׽�Ʈ1';