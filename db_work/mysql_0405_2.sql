use bit701;

create table student (
	num smallint auto_increment primary key,
    name varchar(20),
    java smallint,
    html smallint,
    spring smallint,
    testday datetime
    );
    
select * from student;