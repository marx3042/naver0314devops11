create table myshop (
   shopidx smallint auto_increment primary key,
   sname varchar(30),
   sprice int,
   scount int,
   scolor varchar(20),
   sphoto varchar(100),
   writeday datetime);