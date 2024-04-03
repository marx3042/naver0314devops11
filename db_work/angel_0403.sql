--������ ����
--�⺻ 1���� 1�� �����ϴ� �������� �����ϰ� �⺻��ɾ �ָ��
CREATE SEQUENCE seq1;
--��ü ������ ��ȸ
select * from seq;

--���� �������� �߻�:nextval
select seq1.nextval from dual; --1�� ������ ���� �߻��Ѵ�

--10���� 5�� �����ϴ� �������� �����غ���,ĳ���� �⺻ 20�ε� ���ֺ���
CREATE SEQUENCE seq2 start with 10 increment by 5 nocache;

--seq2 ���� �߻����Ѻ���
select seq2.nextval from dual;

--1���� 3�� ����,ĳ��0,�ƽ� 100
CREATE SEQUENCE seq3 start with 1 increment by 3 nocache maxvalue 100;

--seq3 �� �߻�
select seq3.nextval from dual;

--�������� ����
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--���� ���̺��� ����� ������ ����(1���� 1������(����),cache 0)
CREATE SEQUENCE seq_test nocache;

--������ ���̺� ����
create table hello (
   idx number(3) primary key,
   irum varchar2(20),
   age number(3)
);

--���̺� ���� ���� : alter table
-- irum �� ���̸� 20���� 30���� �����غ���
alter table hello modify irum varchar2(30);

-- addr �̶�� �÷��� �߰��غ���(���ڿ� ���̴� 100)
alter table hello add addr varchar2(100);

--age ��� �÷��� �����غ���
alter table hello drop column age;

-- �÷��� ����(addr -> address)
alter table hello rename column addr to address;

--�÷� �ΰ� �߰��غ���
alter table hello add blood varchar2(3);
alter table hello add age number(3);

--����Ÿ�� �߰��غ���
insert into hello (irum) values ('lee');--�����߻�,idx �� pk�̹Ƿ� �ݵ�� ���� �־���Ѵ�

insert into hello (idx,irum) values (seq_test.nextval, 'lee');
insert into hello (idx,blood,address) values (seq_test.nextval,'ab','���� ����');
--�÷��� ������ ���̺��� �÷� ������� ��簪�� ����Ѵ�
insert into hello values (seq_test.nextval,'����','���ֵ� �ֿ���','o',23);

--����
--�̸��� '����' �� ����� �������� b������ �����غ���
update hello set blood='b' where irum='����';
--idx�� 2�� ����� irum,age �� �����غ���
update hello set irum='��ȣ��',age=35 where idx=2;
--idx �� 1�� ����� address,blood,age �� ���� �����ϼ���
update hello set address='�λ� �ؿ�뱸',blood='a',age=23 where idx=1;

--����
--idx �� 1 �� ��� ����
delete from hello where idx=1;
--age �� 30�̻��� ����Ÿ�� ��� ����
delete from hello where age>=30;

-- ���̺��� ����
drop table hello;
------------------------------------------------------------------
--���ο� ���̺� ����,�̹�����  ���� ���������� �߰��ؼ� �����غ���
create table student (
    num number(3) CONSTRAINT pk_num primary key,
    stuname varchar2(20) CONSTRAINT nn_name not null,
    score number(3)CONSTRAINT ck_score check(score>=1 and score<=100),
    birthday date
);

-- insert �� ����Ÿ �߰��� �ϴµ� ���� ������ �߻����Ѻ���
insert into student (num,stuname) values (1,'��̸�');--ok

--ORA-01400: NULL�� ("ANGEL"."STUDENT"."NUM") �ȿ� ������ �� �����ϴ�
insert into student (stuname,score) values ('�̹���',45);--����

--ORA-00001: ���Ἲ ���� ����(ANGEL.PK_NUM)�� ����˴ϴ�
--num �� pk(pk�� not null+unique)
insert into student (num,stuname) values (1,'ȫ����');--����

--ORA-02290: üũ ��������(ANGEL.CK_SCORE)�� ����Ǿ����ϴ�
--score �� ������ 1~100 �̶�� �Ѵ�
insert into student (num,stuname,score) values (2,'����ȣ',110);--����

--���� ���� ������Ÿ�� �߰��غ���
insert into student values (3,'�̹���',89,sysdate);--��¥�� ���糯¥��
insert into student values (4,'�����',100,'2010-12-20');
commit; --commit �� �ϴ� �ϸ� rollback �� �ȵȴ�

insert into student values (5,'��̳�',56,'2019-05-10');--��¥�� ���糯¥��
insert into student values (6,'������',98,sysdate);
insert into student values (7,'������',67,'2015-09-12');
insert into student values (8,'��ȣ��',66,'2019-05-03');
commit;
rollback; --������ commit �� ������ DML�۾��� ���� �ѹ�

-- num �� 5���� ����Ÿ�� �̸��� '�չ̶�',score �� 80 ���� ����
update student set stuname='�չ̶�',score=80 where num=5;
-- birthday �� ���� 5�λ���� ������ �ϰ������� 85�� �����Ͻÿ�
update student set score=85 where to_char(birthday,'mm')='05';
commit;

--num �� 7�� ����Ÿ ������ ����Ÿ Ȯ��
delete from student where num=7;
--�ѹ��� ����Ÿ Ȯ���ϱ�
ROLLBACK;
--�ٽ� ������ ����
delete from student where num=7;
--Ŀ���ϱ�
commit;
--�ٽ� �ѹ��� ����Ÿ Ȯ���ϱ�
ROLLBACK;--�̹� Ŀ�Ե� ����Ÿ�� ��ҵ��� �ʴ´�

--���ʿ��� �������� ����
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

--���ο� �������� �߰�
alter table student add constraint uq_name unique(stuname);

--���� �̸��� ����Ÿ�� �߰��غ���
--����: ORA-00001: ���Ἲ ���� ����(ANGEL.UQ_NAME)�� ����˴ϴ�
insert into student (num,stuname) values (10,'��ȣ��');

--������ ������ �������� ���̺��� �������ּ���
drop SEQUENCE seq_test;
drop table student;
-------------------------------------------------------------
/*
join ������ ���̺� 2�� �����ϱ�
���̺� #1 :  
       food  -  foodnum  ����(3) pk
                foodname  ���ڿ�(20)
                foodprice ����(7)
                foodsize  ���ڿ�(20)
    
      booking - bnum  pk  ����(3)
                bname ���ڿ�(20) nn
                bhp   ���ڿ�(20) uq
                foodnum ����(3) - fk(food �� foodnum)
                bookingday date
                
    �ܺ�Ű�� ����Ȱ�� booking �� ����Ÿ�� �߰������� �߰��� foodnum �� �����Ҽ� ����
    (���� ��� �Խ����� ��۰������ �ܺ�Ű�� ����Ǿ��ִµ�
      �̶��� ����� �޸���� �ش���� �����Ҽ� ���� �Խ��ǵ��� �ִ�)
      -�׷��� ���� food�� ����Ÿ�� �����ϸ� �� �޴��� �߰��� ���� ����Ÿ�� 
        �ڵ����� ������Ű���� �Ұ�� booking �� �ܺ�Ű�� �����Ҷ� on delete cascade ��
        �ָ� �ȴ�

*/

create table food(
    foodnum number(3) CONSTRAINT pk_foodnum primary key,
    foodname varchar2(20),
    foodprice number(7),
    foodsize varchar2(20)
);

--�޴��� ����غ���
insert into food values (100,'¥���',9000,'����');
insert into food values (101,'¥���',11000,'�����');
insert into food values (200,'������',15000,'����');
insert into food values (201,'������',20000,'�����');
insert into food values (300,'ĥ������',15000,'��');
insert into food values (301,'ĥ������',30000,'��');
insert into food values (400,'�ع�«��',11000,'����');
commit;
select * from food;

--������ �߰�
create SEQUENCE seq_food nocache;

--booking ���̺� ����
create table booking(
    bnum number(3) constraint pk_bnum PRIMARY key,
    bname varchar2(20) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3),
    bookingday date,
    constraint fk_foodnum FOREIGN key(foodnum) references food(foodnum)
);

--���� ���̺� ����Ÿ�� �߰��غ���
select * from booking;

insert into booking values (seq_food.nextval,'ȫ����','010-2222-3333',101,sysdate);--ok

--ORA-00001: ���Ἲ ���� ����(ANGEL.UQ_BHP)�� ����˴ϴ�, �ڵ����� ������ �ȵ�
insert into booking values (seq_food.nextval,'��ȣ��','010-2222-3333',101,sysdate);--�����߻�

--���÷κ��� 7���� ����
insert into booking values (seq_food.nextval,'�̿���','010-3434-8899',301,sysdate+7);--ok

--���� �޴� �ֹ��� �����߻�
--ORA-02291: ���Ἲ ��������(ANGEL.FK_FOODNUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
insert into booking values (seq_food.nextval,'������','010-3434-45459',500,sysdate+3
);--�����߻�

insert into booking values (seq_food.nextval,'������','010-3434-45459',201,sysdate+3
); --ok

insert into booking values (seq_food.nextval,'�չ̳�','010-3434-1234',100,sysdate+10
); --ok

insert into booking values (seq_food.nextval,'��ȿ��','010-3434-4321',400,sysdate+1
); --ok
commit;
select * from booking;

--join ���� �����̺��� �����ؼ� ����Ͻÿ�
-- bnum,bname,bhp,foodnum,foodname,foodprice,foodsize,bookingday(yyyy-mm-dd)
select
    bnum,bname,bhp,b.foodnum,foodname,foodprice,foodsize,
    to_char(bookingday,'yyyy-mm-dd') bookingday
from food f,booking b
where f.foodnum=b.foodnum;

--�ƹ��� �������� ���� food ������ ������ ������?
select
    bnum,f.foodnum, foodname,foodprice,foodsize
from food f,booking b
where f.foodnum=b.foodnum(+) and bnum is null; --200,300 �޴��� �ƹ��� �ֹ�����

--food �� 200�� �޴��� ������ �ɱ��?
delete from food where foodnum=200;--�ƹ��� �ֹ��ѻ���� �����Ƿ� ��������
--food �� 100�� �޴��� ������ �ɱ��?

--ORA-02292: ���Ἲ ��������(ANGEL.FK_FOODNUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
delete from food where foodnum=100; --100�� �޴��� �ֹ��� ���� �����Ƿ� �����Ҽ� ����

--�θ� ���̺��� food �� �����غ���
drop table food;--�����߻�,�ڽ����̺��� ���� ������ �θ����̺��� �����ؾ߸� �Ѵ�

--������ ������ �� ���̺��� �����ϼ���
drop table booking;--�ڽ� ���̺� ���� ����
drop table food;--�ڽ� ���̺� ������ �θ����̺� ����
--�������� ����
drop SEQUENCE seq_food;
--------------------------------------------------------------------------------
-- on delete cascade ����
--�̹����� �θ����̺��� ����Ÿ ������ �������̺��� ����Ÿ�� �ڵ����� �����ǵ���
-- �ܺ�Ű�� �����غ���
--������ ����
create SEQUENCE seq_shop;
--shop,cart
create table shop(
    sang_no number(3) CONSTRAINT shop_pk_no primary key,
    sang_name varchar2(30),
    sang_price number(10)
);
--�ܺ�Ű ������ on delete cascade �� ���̸� �θ����̺� ������ �ڽ����̺� �߰���
-- ����Ÿ�� ���� ������
create table cart (
    cart_no number(3) CONSTRAINT cart_pk_no PRIMARY key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    CONSTRAINT cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--5���� ��ǰ�� ����غ���
insert into shop values (seq_shop.nextval,'���콺',12000);
insert into shop values (seq_shop.nextval,'����',19000);
insert into shop values (seq_shop.nextval,'û����',25000);
insert into shop values (seq_shop.nextval,'üũ��Ʈ',99000);
insert into shop values (seq_shop.nextval,'Ƽ����',11000);
commit;
select * from shop;

--cart �� ���ϴ� ��ǰ�� ��ƺ���
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,1,2,sysdate);
insert into cart values (seq_shop.nextval,5,1,sysdate);
commit;

--join ���� ��ȸȭ��
--cart_no,sang_no,sang_name,sang_pprice,cnt,cartday(yyyy-mm-dd) ���
select
    cart_no,s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from shop s,cart c
where s.sang_no=c.sang_no;

--�ƹ��� īƮ�� ���� ���� ��ǰ��?
select
    cart_no,s.sang_no,sang_name,sang_price
from shop s,cart c
where s.sang_no=c.sang_no(+) and cart_no is null;

--on delete cascade �� �Ѱ�� cart �� �߰��� ��ǰ�� ������ �����ϴ�
--2�� ���� ��ǰ�� �����غ���
delete from shop where sang_no=2;

--cart �� Ȯ���غ��� cart �� �ִ� 2�� ��ǰ�� ������� Ȯ���Ҽ� �ִ�
select
    cart_no,s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from shop s,cart c
where s.sang_no=c.sang_no;

--���̺� ���Ŵ� ���� ���� ���̺���� ����
drop table cart;
drop table shop;
drop sequence seq_shop;