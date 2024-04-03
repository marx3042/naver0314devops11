--��������
-- ename �� 'A' �� 'S' �� �����ϴ� ����� ENAME,SAL,COMM ��ȸ
select ename,sal,comm from emp where ename like 'A%' or ename like 'S%';
--COMM �� NULL �� �ƴѻ������ ��ȸ
select * from emp where comm is not null;
--MGR �� 7698,7566,7782 �� ��� ��ȸ (IN ���)
select * from emp where mgr in (7698,7566,7782);
--SAL �� 2500���� 3000 ���� ��ȸ(AND����)
select * from emp where sal>=2500 and sal<=3000;
--SAL �� 2500���� 3000 ���� ��ȸ(BETWEEN ���)
select * from emp where sal BETWEEN 2500 and 3000;
--JOB�� �ߺ�ó���ؼ� �ѹ����� ����Ͻÿ�
select DISTINCT job from emp;
--�������� ����
--ALLEN �� ������ ���� ������ ���� ������� ��ȸ�Ͻÿ�
SELECT * FROM EMP WHERE JOB=(select job from emp where ename='ALLEN');
--SCOTT �� MGR �� �������� ���� ����� ������ ��ȸ�Ͻÿ�
SELECT * FROM EMP WHERE MGR=(SELECT MGR FROM EMP WHERE ENAME='SCOTT');

--�����Լ�,�����Լ� ����
SELECT ABS(-5),ABS(5) FROM DUAL; --ABS :���밪
SELECT CEIL(3.0),CEIL(3.1),CEIL(3.9) FROM DUAL; --CEIL:������ �ø�
SELECT FLOOR(3.0),FLOOR(3.1),FLOOR(3.9) FROM DUAL;--FLOOR:�����ǳ���
SELECT MOD(7,3),MOD(9,5) FROM DUAL;--MOD:������
SELECT POWER(2,3),POWER(3,4) FROM DUAL;--POWER:������
SELECT ROUND(23.456,2),ROUND(8927,-1),ROUND(4567890,-4) FROM DUAL;--ROUND:�ݿø�

--�����Լ�
SELECT CONCAT('HAPPY','DAY') FROM DUAL;
SELECT 'HAPPY'||'DAY' FROM DUAL; --���� ����� ����
SELECT INITCAP('HAPPY'),INITCAP('hello') from dual;--ù���ڸ� �빮�ڷ� 
select lower('heLLOdAy'),upper('heLLOdAy') from dual;
select lower(ename),initcap(ename) from emp;
select lpad(sal,10,'*') from emp;--�������� * ä���
select rpad(sal,10,'*') from emp;--���������� * ä���
select substr('happy day',2,3) from dual;--2���ε������� 3����(ù���� �ε����� 1) : app
select substr('happy day',-5,3) from dual;--�ڿ��� 5��°���� 3����(ù���� �ε����� 1) : y d
select ename,length(ename) ���ڼ� from emp;--length:����,���ڼ�
select replace('Good Day','o','*') from dual;--o �� *�� �����ؼ� ���
select instr('happy','a') from dual;--happy �� a�� ��ġ :2
select instr('happy','x') from dual;--x�� ������� 0
select instr('have a nice day','nice') from dual;--8��°�� nice�� ����
select trim('   hello   ') from dual;--�յ� ���� ������ ���

--��Ÿ�Լ�
--NVL �� ���ϰ�� ��ü������ ���
select NVL(comm,1000) from emp; --null �ϰ�� 1000 ���� ���
--decode : ���� ���� �ٸ����� ����Ҷ�
select ename �����,deptno �μ��ڵ�,
 decode(deptno,10,'ȫ����',20,'������',30,'�λ��') �μ��� from emp;
 
 --join : ppt 43������
 --inner join(��������),equi join
 
 --���1
 select
    EMP.EMPNO,EMP.ENAME,EMP.JOB,DEPT.DNAME,DEPT.LOC
 from emp,dept
 where emp.deptno=dept.deptno;
 
 --���2 , �����̺� ���������� �ִ� �÷��ϰ�쿡�� �տ� ���̺���� ���̰� �������� ��������
 select
    EMPNO,ENAME,JOB,DNAME,LOC
 from emp,dept
 where EMP.deptno=dept.deptno;
 
 --��� 3 : ���̺���� �ʹ� ���� ��Ī�� ����Ҽ� �ִ�
 select
    e.EMPNO,ENAME,JOB,DNAME,LOC
 from emp e,dept d
 where e.deptno=d.deptno;