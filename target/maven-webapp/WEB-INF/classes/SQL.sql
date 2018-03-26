1��������
 //�½����ݿ�
 create database shop;
 
  //������Ʒ����
 create table category(
id int(11) not null auto_increment primary key,
parent_id int(11) default null,
name varchar(50) default null,
status tinyint(1) default '1',
sort_order int(4) default null,
create_time datetime default null,
update_time datetime default null);
//������Ʒ���
insert into category(parent_id,name,sort_order)
values 
(0,'�·�',0),
(1,'Ůװ',1),
(1,'��װ',2),
(1,'ͯװ',3),
(0,'ʳƷ',0),
(1,'�ɹ�',1),
(1,'ˮ��',2),
(1,'��ʳ',3),
(0,'����',0),
(1,'����',1),
(1,'����',2),
(1,'ϴ�»�',3);
 
 //������Ʒ��
create table product(
id int(11) not null auto_increment primary key,
category_id int(11) not null,
name varchar(100) not null,
subtitle varchar(200) default null,
main_image varchar(500) default null,
sub_images text null,
detail text null,
price decimal(20,2) not null,
stock int(11) not null,
status int(6) default '1',
create_time datetime default null,
update_time datetime default null,
foreign key(category_id) references category(id));
//������Ʒ
insert into product(category_id,name,subtitle,detail,price,stock)
values 
(2,'����ȹ','�μ���','����ȹ',250.00,10000),
(3,'����','��ϲ��','������װ',252.00,4310),
(4,'����','����','����ͯװ',153.00,22400),
(6,'����','��ƮƮ����','��ζ��Ʈ',23.00,102000),
(7,'ƻ��','�츻ʿ','ɽ���츻ʿ',125.00,98000),
(8,'��Ƭ','������Ƭ','����ʵ��',15.00,200000),
(10,'����','��ˤ����','֧�����ֵ���',25000.00,10000),
(11,'����','һ��˶ȵ�','���ܱ���������',12250.00,5000),
(12,'С���','����ϴ�ɾ�','�Դ����',2250.00,8000);

�����û���
create table user (
id int(11) primary key auto_increment ,
username varchar(50) unique not null ,
password varchar(50) not null,
email varchar(50),
phone varchar(20),
question varchar(100),
answer varchar(100),
role int(4),
create_time datetime,
update_time datetime);
�����û�
insert into user(username,password,email,phone,question,answer,role,create_time,update_time)
values 
('zhangsan','123456','zs@163.com','18710086114','����˭','����',0,now(),now());



 //��ѯ��Ʒ�б�����
select * from category;
select * from category where id=?;
 //��ѯ��Ʒ�б�����
select * from product;
select * from product where id=?;
 
//��������
insert into category
values 
(?,?,?,?,?,?,?) ;
//��������
insert into product
values 
(?,?,?,?,?,?,?) ;
//ɾ����Ʒ����
delete from category where id=?;
//ɾ����Ʒ����
delete from product where id=?;
alter table user add token varchar(100) null;

//�޸�����
update emp set empno=?,ename=?,job=?mgr=?,hierdate=?,sal=?,comm=?,deptno=?  where empno=?;



//�����û��ջ���ַ�����
create table address(
id int(11) not null 	primary key  auto_increment,   
user_id int(11) default null ,
receiver_name varchar(20) default null  ,
receiver_phone varchar(20) default null  ,
receiver_mobile varchar(20) default null  ,
receiver_province varchar(20) default null  ,
receiver_city varchar(20) default null  ,
receiver_district varchar(20)   ,
receiver_address varchar(200)   ,
receiver_zip varchar(6)  ,
create_time datetime   ,
update_time datetime );
 //
insert into address(user_id , receiver_name  ,  receiver_phone  ,  receiver_mobile  ,  receiver_province  ,
								receiver_city  ,  receiver_district , receiver_address , receiver_zip , create_time , update_time)
values 
(1,'����',null,'125548215','���1','���2','�����','����','012000',now(),now());

update  address set  receiver_name=?  ,  receiver_phone=?  ,  receiver_mobile=?  ,  receiver_province=?,
									receiver_city=?  ,  receiver_district=? , receiver_address=? , receiver_zip=?,update_time=now()
where 


//���ﳵ
create table cart(
id int(11) not null primary key  auto_increment,  
user_id int(11) not null ,
product_id int(11) default null  ,
quantity int(11) default null  ,
checked int(11) default null  ,
create_time datetime default null  ,
update_time datetime default null  );

insert into address(user_id , receiver_name  ,  receiver_phone  ,  receiver_mobile  ,  receiver_province  ,
								receiver_city  ,  receiver_district , receiver_address , receiver_zip , create_time , update_time)
values 
(1,'����',null,'125548215','���1','���2','�����','����','012000',now(),now()),
(1,'����',null,null,null,null,null,null,null,now(),now());

���� UserOrder
create table UserOrder (
id int(11) not null primary key  auto_increment  comment '����id',
order_no bigint(20) default null comment 'ΨһԼ�� ������',
user_id int(11) default null  comment '�û�id',
shipping_id int(11) default null  comment '��ַid',
payment decimal(20,2) default null  comment 'ʵ�ʸ�����,��λԪ,������λС��',
payment_type int(4) default null  comment '֧������ 1-����֧�� 2-��������',
postage int(10) default null comment '�˷�,��λԪ',
status int(10) default null  comment '����״̬  0-��ȡ�� 10-δ���� 20-�Ѹ��� 40-�ѷ��� 50-���׳ɹ� 60-���׹ر�',
payment_time datetime default null comment '֧��ʱ��',
send_time datetime default null  comment '����ʱ��',
end_time datetime default null  comment '�������ʱ��',
close_time datetime default null  comment '���׹ر�ʱ��',
create_time datetime default null comment '����ʱ��',
update_time datetime default null comment '����ʱ��',
unique key order_no_key(order_no)��

������ϸ UserOrderItem
create table userorderitem (
id int(11) not null primary key  auto_increment   comment '�����ֱ�id',
order_no bigint(20) default null comment '���� ������� ',
user_id int(11) default null comment '���� �û�id',
product_id int(11) default null  comment '��Ʒid',
product_name varchar(100) default null  comment '��Ʒ����',
product_image varchar(500) default null  comment '��ƷͼƬ��ַ',
current_unit_price decimal(20,2) default null  comment '���ɶ���ʱ����Ʒ���,��λԪ,������λС��',
quantity int(10) default null  comment '��Ʒ����',
total_price decimal(20,2) default null  comment '��Ʒ�ܼ�,��λԪ,������λС��',
create_time datetime default null  comment '����ʱ��',
update_time datetime default null  comment '����ʱ��',
key order_no_key(order_no),key user_order_key(user_id,order_no))

