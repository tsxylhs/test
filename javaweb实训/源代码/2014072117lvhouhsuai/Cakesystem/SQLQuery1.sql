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
--��������
create table Ctype
(
Caketype int primary key ,
typeN varchar(50) not null
)
--����Ա
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
--�����
create table cake(
CakeName char(12) not null,
CakeId varchar(12) primary key ,
CakeSize varchar(10) not null,
Cakeprice varchar(12) not null,
CakeType int foreign key (Caketype) references Ctype(Caketype)
)
--�����¼

create table Vshopnote
(
Vnumber int not null  foreign key (Vnumber) references vip(Vnumber),
CakeId varchar(12) not null  constraint id_fk foreign key (CakeId) references cake(cakeId),
Caketime date  not null

)
--����
create table orders
(
Dnumber varchar(12) primary key,
Vnumber int constraint id2_fk foreign key (Vnumber) references vip(Vnumber),
Dtime   date 
)
--�������Ͳ���
insert into Ctype values(1,'���ҵ���')
insert into Ctype values(2,'�����̵���')
insert into Ctype values(3,'���ǵ���')
insert into Ctype values(4,'�����ǵ���')
--����
insert into Cake  values('������','5210','12','35',4)
insert into Cake  values('�ɿ�������','5211','15','65',1)
--��Ա
insert into vip  values('0001' ,'9527','123321','С��',0,'2016-6-19','̩����')
--����Ա
insert into Adm values('�ϰ�','111111','222222')
--�����¼
insert into Vshopnote values ('0001','5210','2016-6-19')
--����
insert into orders values('0000001','0001','2016-6-19')
--������ϸ��ѯ
select * from cake, Ctype where Cake.CakeType=Ctype.CakeType and cake.CakeId='5210'