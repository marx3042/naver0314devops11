-- ī�信�� scott_table �� �ٿ�޾� naver0314 �� ������
-- cmd â���� naver0314 ������ �̵���(cd naver0314) 
-- sqlplus �� scott �������� ������
-- @scott_table ����
-- �ڵ����� �ȿ� �ִ� sql ��ɾ ����˴ϴ�
select * from tab; --������ ���̺� Ȯ��
select * from emp; -- emp ���̺��� ������ ����Ÿ Ȯ��
commit; -- �߰��� ����Ÿ Ŀ�� , Ŀ�� ���ҽ� �߰��� ����Ÿ�� ��ҵ�

-- emp ���̺��� ���� Ȯ��
desc emp;

--��ü �÷����� emp ���̺� ��ȸ
select * from emp;
--ename,job �÷��� ��ȸ
select ename,job from emp;

--ename,job �÷��� ��ȸ, ename �� ��������(asc) �Ǵ� ������������ ��ȸ(desc)
select ename,job from emp order by ename asc;--asc �ΰ�� ���� ����,�������� ���
select ename,job from emp order by ename desc; --ename �� ������������ ����

-- job�� ��ȸ
select job from emp;

--job �� ��ȸ�ϴµ� ���� ������ �ѹ��� ������, ������������ ���
select DISTINCT job from emp order by job asc;
select DISTINCT job from emp order by 1;--�÷���ȣ�� 1������, ���� ����

-- ename �� SMITH �� ��� ��ȸ
SELECT * FROM EMP WHERE ENAME='SMITH';
SELECT * FROM EMP WHERE ENAME='ward';--sql��ɾ�� ��ҹ��� ��������� ����Ÿ�� ��Ȯ�� ����Ѵ�

--ENAME �� SMITH �̰ų� WARD �λ�� ��ȸ(OR)
SELECT * FROM EMP WHERE ENAME='SMITH' OR ename='WARD';

-- ENAME,SAL �� ��ȸ
SELECT ENAME , SAL FROM EMP;

--�÷������� ����
SELECT ENAME "�� �� ��",SAL "�� ��" FROM EMP; --���񺯰�� ������ ���ԵǾ�������� �ݵ�� "" �� �����ش�
SELECT ENAME �����,SAL �޿� FROM EMP;

--�����÷��� ���ؼ� �ϳ��� �÷����� ����Ұ��,�÷����� ���غ�����
SELECT '���̸��� '||ENAME||'�̰� ������ '||JOB||'�Դϴ�' FROM EMP;
SELECT '���̸��� '||ENAME||'�̰� ������ '||JOB||'�Դϴ�' "���" FROM EMP;

--��)SMITH ���� ������ 800�����Դϴ� : ������ "����" 
SELECT ENAME||'���� ������ '||SAL||'�����Դϴ�' ���� FROM EMP;

--SAL ������ 2000~3000 ���� ��ȸ(�÷��� ENAME,SAL)
SELECT ENAME,SAL FROM EMP WHERE SAL>=2000 AND SAL<=3000;
--BETWEEN �� �̿��ؼ� ��ȸ�Ҽ��� �ִ�
SELECT ENAME,SAL FROM EMP WHERE SAL BETWEEN 1000 AND 2000;

-- ������ SALESMAN ,MANAGER,CLERK ��ȸ
SELECT ENAME,JOB FROM EMP WHERE JOB='SALESMAN' OR JOB='MANAGER' OR JOB='CLERK';
--IN �� �̿��ؼ� ������������ ����غ���
SELECT ENAME,JOB FROM EMP WHERE JOB IN ('SALESMAN','MANAGER','CLERK');

-- MGR �� 7902,7839,7788 ��ȸ(�÷��� ENAME,JOB,MGR)-IN ����ؼ�
SELECT ENAME,JOB,MGR FROM EMP WHERE MGR IN (7902,7839,7788);

--MGR �� NULL �ΰ�츸 ���
SELECT * FROM EMP WHERE MGR IS NULL;

--COMM �� NULL �ΰ��
SELECT * FROM EMP WHERE COMM IS NULL;

--COMM �� NULL �� �ƴѰ��
SELECT * FROM EMP WHERE COMM IS NOT NULL;

--������ȸ�� %, _ �� �̿��ؼ� ��ȸ
-- ENAME �� A�� �����ϴ� ��� ��ȸ
SELECT ENAME,SAL FROM EMP WHERE ENAME LIKE 'A%';

--ENAME �� N ���� ������ ���
SELECT ENAME,SAL FROM EMP WHERE ENAME LIKE '%N';

--�̸��� �ι�° ���ڰ� A �λ�� ��ȸ
SELECT ENAME,SAL FROM EMP WHERE ENAME LIKE '_A%';
--�̸��� ����° ���ڰ� A �λ�� ��ȸ
SELECT ENAME,SAL FROM EMP WHERE ENAME LIKE '__A%';

-- �̸��� S��M���� �����ϴ� ���
SELECT ENAME,SAL FROM EMP WHERE ENAME LIKE 'S%' OR ENAME LIKE 'M%';
--�̸��� S�� �����ϴ� ����߿� ������ 2000 �̻��� ��� ��ȸ
SELECT ENAME,SAL FROM EMP WHERE ENAME LIKE 'S%' AND SAL>=2000;
-- MGR �� 7902,7788,7566 �� �ƴ�(NOT)����� ��ȸ(IN)
SELECT ENAME,JOB,MGR FROM EMP WHERE MGR NOT IN (7902,7566,7788);

--COMM, COMM+1000 �� ��� ���
SELECT COMM,COMM+1000 FROM EMP; -- NULL �� ���� ���ص� ����� NULL

-- �Լ��� NVL(�÷���,���ϰ���ʱⰪ),MYSQL �� ifnull �̴�
SELECT NVL(COMM,0),NVL(COMM,0)+1000 FROM EMP; --NULL �ϰ�� 0���� ��� �Ǵ� ���

--���� SQL���� �÷������� �߰��Ͽ� �ϼ��Ͻÿ� "COMM" ,"COMM2"
SELECT NVL(COMM,0) COMM,NVL(COMM,0)+1000 COMM2 FROM EMP; --NULL �ϰ�� 0���� ��� �Ǵ� ���

--SAL �� 2000~3000 �� �ƴѰ�� ��ȸ, �ΰ��� ������� �غ���
SELECT ENAME,SAL FROM EMP WHERE SAL<2000 OR SAL>3000;
SELECT ENAME,SAL FROM EMP WHERE  SAL NOT BETWEEN 2000 AND 3000;

-- GROUP �Լ�(COUNT,MAX,MIN,AVG,SUM)
SELECT COUNT(*) FROM EMP; --��ü �ο���
SELECT MAX(SAL) FROM EMP; --�ְ���
SELECT MIN(SAL) FROM EMP; --�ּҿ���
SELECT SUM(SAL) FROM EMP; --SAL�� �հ�
SELECT AVG(SAL) FROM EMP; --SAL�� ���  2073.2142...

--AVG�� �Ҽ������ϰ� ���� �����°�찡 ���Ƽ� ROUND,CEIL,FLOOR ��� ���� ���� ���
--����� �Ҽ������� 2�ڸ������� ������ �ϱ�
SELECT ROUND(AVG(SAL),2) FROM EMP; --2073.21,ROUND �� �ݿø�
SELECT CEIL(AVG(SAL)) FROM EMP; --������ �ø� 2074
SELECT FLOOR(AVG(SAL)) FROM EMP; --�����ǳ��� 2073

-- PPT 57 ������ GROUP BY ��
--JOB �� �׷����� ������ �� �ο����� ���غ���
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB;

--���� ����� ������ ������������ ���
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY ����;--�÷������� �������ϱ�
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY 1;--�÷���ȣ�� �������ϱ�

--���� ����� �ο����� ������������ ���
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY �ο���;--�÷������� �������ϱ�
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY 2;--�÷���ȣ�� �������ϱ�

--������ �ο����� �ְ���,��������,��տ���(�����ǿø�) �� ���غ��ÿ�
SELECT JOB,COUNT(*),MAX(SAL),MIN(SAL),CEIL(AVG(SAL)) FROM EMP GROUP BY JOB;
SELECT JOB ����,COUNT(*) �ο���,MAX(SAL) �ְ���,MIN(SAL) ��������,CEIL(AVG(SAL)) ��տ��� FROM EMP GROUP BY JOB;


--HAVING �� GROUP ������ �׷��Լ��� �̿��ؼ� ������ ��Ÿ�����
--������ �ο����� �ְ����� ���ϴµ� ������ �ο����� 3�� �̻��ΰ�츸 ��ȸ�� �Ͻÿ�
SELECT JOB,COUNT(*),MAX(SAL) FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3;

--����Ŭ������ ���糯¥�� ���Ҷ� SYSDATE,MYSQL �� NOW()
SELECT SYSDATE FROM DUAL;--���� �ֿܼ� ���� ��¥ ���
--3�ϵ�
SELECT SYSDATE+3 FROM DUAL;
--30�ϵ�
SELECT SYSDATE+30 FROM DUAL;

--��¥Ÿ���� ���ڿ��� ��ȯ TO_CHAR : ��ȣ Y,M,D,HH,HH24,MI,SS,AM/PM��
SELECT TO_CHAR(SYSDATE,'YYYY') FROM DUAL; --2024
SELECT TO_CHAR(SYSDATE,'YEAR') FROM DUAL;--�����ڷ� ����,�߾Ⱦ�

SELECT TO_CHAR(SYSDATE,'MM') FROM DUAL; --04
SELECT TO_CHAR(SYSDATE,'MONTH') FROM DUAL; --����/�ѱ۷� ���� ����

--��ȣ�� ���� ���µ� �پ��� ��ȣ�� ��¥�� ����غ���
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD AM HH:MI') FROM DUAL; --AM �Ǵ� PM�ð�������� ���
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI') FROM DUAL;

--EMP ���� HIREDATE(��¥Ÿ��)���̿��ؼ� ����غ���
SELECT ENAME,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP;

--���⵵�� 1987 �� ��� ���
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')='1987';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')=1987;

--������ 5���� ��� ���
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='05';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')=5;

--SUBQUERY(SEELCT �� �ȿ� �� SELECT ���� �ִ°��)
-- SCOTT �� ������ ���� ������ ���� ����� ���Ͻÿ�
SELECT * FROM EMP WHERE SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');
--��տ������� ���� �޴� ����� ������ ����Ͻÿ�
SELECT * FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP);