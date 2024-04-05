-- �ڹٿ��� ������ �������� ���̺� ����
create sequence seq_test nocache;

create table person (
   pnum number(3) constraint pk_pnum primary key,
   pname varchar2(20),
   pblood varchar2(5) default 'B',
   page number(3),
   ipsaday date
);

-- 5�� ���� ����Ÿ �߰�
insert into person values (seq_test.nextval,'�̻��','a',34,'2010-12-20');
insert into person values (seq_test.nextval,'��ȣ��','o',21,'2008-03-20');
insert into person values (seq_test.nextval,'���缮','A',29,sysdate);
insert into person values (seq_test.nextval,'�չ̳�','a',39,'2015-09-13');
insert into person values (seq_test.nextval,'������','o',28,sysdate);
commit;

select * from person;

select pnum,pname,upper(pblood) pblood,page,to_char(ipsaday,'yyyy-mm-dd') ipsaday from person;