-- 계정 생성(system에서만 가능)
create user angel IDENTIFIED by a1234;  --오류발생
--최신버전에서는 앞에 공통문자 c##을 붙여서 계정생성을 해야만 한다
create user c##angel IDENTIFIED by a1234;
--system 계정에 생성된 계정 확인하기
select username from dba_users;
--c###angel계정 삭제하기
drop user c##angel;
--c##공통문자를 안붙이고 계정생성을 하려면 세선변경을 해야만한다
alter SESSION set "_ORACLE_SCRIPT"=true;
-- angel 계정을 생성해보자(비번은 a1234)
create user angel identified by a1234;
--scott/tiger 계정에 비번으로 user을 생성후 기본권한을 추가
create user scott IDENTIFIED by tiger;
grant connect,resource to scott;

--생성한 각 계정에 tablespace 지정하기
alter user angel default tablespace users quota unlimited on users;
alter user scott default tablespace users quota unlimited on users;
commit; --추가된 데이터 커밋, 커밋 안할시 추가된 데이터가 취소됨


