-- ���� ����(system������ ����)
create user angel IDENTIFIED by a1234;  --�����߻�
--�ֽŹ��������� �տ� ���빮�� c##�� �ٿ��� ���������� �ؾ߸� �Ѵ�
create user c##angel IDENTIFIED by a1234;
--system ������ ������ ���� Ȯ���ϱ�
select username from dba_users;
--c###angel���� �����ϱ�
drop user c##angel;
--c##���빮�ڸ� �Ⱥ��̰� ���������� �Ϸ��� ���������� �ؾ߸��Ѵ�
alter SESSION set "_ORACLE_SCRIPT"=true;
-- angel ������ �����غ���(����� a1234)
create user angel identified by a1234;
--scott/tiger ������ ������� user�� ������ �⺻������ �߰�
create user scott IDENTIFIED by tiger;
grant connect,resource to scott;

--������ �� ������ tablespace �����ϱ�
alter user angel default tablespace users quota unlimited on users;
alter user scott default tablespace users quota unlimited on users;
commit; --�߰��� ������ Ŀ��, Ŀ�� ���ҽ� �߰��� �����Ͱ� ��ҵ�


