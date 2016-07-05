create database CakeSystem
on primary
(

name='Cake_data',
filename='F:\cake\cake.mdf',
size=10Mb,
maxsize=20Mb,
filegrowth=15%


)
log on
(
name='Cake_log',
filename='F:\cake\Cake.ldf',
size=10mb,
maxsize=20mb,
filegrowth=15%
)
use CakeSystem
--蛋糕类型
create table Ctype
(
Caketype int primary key ,
typeN varchar(50) not null
)
--管理员
create table Adm
(
Aname varchar(12) not null ,
Azh   varchar(10) not null primary key,
Apasw varchar(10) not null
)

--vip
create table vip(
Vnumber int not null  primary key ,
Vzh  varchar(10) not null unique,
Vpasw varchar(10) not null,
Vname varchar(15) not null,
Vjf   int ,
Vbirth date ,
Vadd varchar(50) not null
)
--蛋糕表
create table cake(
CakeName char(12) not null,
CakeId varchar(12) primary key ,
CakeSize varchar(10) not null,
Cakeprice varchar(12) not null,
CakeType int foreign key (Caketype) references Ctype(Caketype)
)
--购买记录

create table Vshopnote
(
Vnumber int not null  foreign key (Vnumber) references vip(Vnumber),
CakeId varchar(12) not null  constraint id_fk foreign key (CakeId) references cake(cakeId),
Caketime date  not null

)
--订单
create table orders
(
Dnumber varchar(12) primary key,
Vnumber int constraint id2_fk foreign key (Vnumber) references vip(Vnumber),
Dtime   date 
)
--蛋糕类型插入
insert into Ctype values(1,'奶酪蛋糕')
insert into Ctype values(2,'西米捞蛋糕')
insert into Ctype values(3,'纯糖蛋糕')
insert into Ctype values(4,'不含糖蛋糕')
--蛋糕
insert into Cake  values('春卷蛋糕','5210','12','35',4)
insert into Cake  values('巧克力蛋糕','5211','15','65',1)
--会员
insert into vip  values('0001' ,'9527','123321','小红',0,'2016-6-19','泰安市')
--管理员
insert into Adm values('老板','111111','222222')
--购买记录
insert into Vshopnote values ('0001','5210','2016-6-19')
--订单
insert into orders values('0000001','0001','2016-6-19')
--蛋糕详细查询
select * from cake, Ctype where Cake.CakeType=Ctype.CakeType and cake.CakeId='5210'