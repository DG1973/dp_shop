1，创建表
 //新建数据库
 create database shop;
 
  //创建商品类别表
 create table category(
id int(11) not null auto_increment primary key,
parent_id int(11) default null,
name varchar(50) default null,
status tinyint(1) default '1',
sort_order int(4) default null,
create_time datetime default null,
update_time datetime default null);
//插入商品类别
insert into category(parent_id,name,sort_order)
values 
(0,'衣服',0),
(1,'女装',1),
(1,'男装',2),
(1,'童装',3),
(0,'食品',0),
(1,'干果',1),
(1,'水果',2),
(1,'零食',3),
(0,'电器',0),
(1,'电视',1),
(1,'冰箱',2),
(1,'洗衣机',3);
 
 //创建商品表
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
//插入商品
insert into product(category_id,name,subtitle,detail,price,stock)
values 
(2,'连衣裙','俏佳丽','连衣裙',250.00,10000),
(3,'西服','报喜鸟','西服套装',252.00,4310),
(4,'酷娃','卡酷','酷娃童装',153.00,22400),
(6,'瓜子','香飘飘瓜子','美味香飘',23.00,102000),
(7,'苹果','红富士','山东红富士',125.00,98000),
(8,'薯片','自制薯片','经济实惠',15.00,200000),
(10,'长虹','抗摔电视','支持数字电视',25000.00,10000),
(11,'美的','一晚八度电','节能冰箱美的造',12250.00,5000),
(12,'小天鹅','比手洗干净','自带烘干',2250.00,8000);

创建用户表
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
插入用户
insert into user(username,password,email,phone,question,answer,role,create_time,update_time)
values 
('zhangsan','123456','zs@163.com','18710086114','你是谁','张三',0,now(),now());



 //查询商品列表数据
select * from category;
select * from category where id=?;
 //查询商品列表数据
select * from product;
select * from product where id=?;
 
//插入数据
insert into category
values 
(?,?,?,?,?,?,?) ;
//插入数据
insert into product
values 
(?,?,?,?,?,?,?) ;
//删除商品数据
delete from category where id=?;
//删除商品数据
delete from product where id=?;
alter table user add token varchar(100) null;

//修改数据
update emp set empno=?,ename=?,job=?mgr=?,hierdate=?,sal=?,comm=?,deptno=?  where empno=?;



//创建用户收货地址管理表
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
(1,'张三',null,'125548215','天津1','天津2','天津区','东软','012000',now(),now());

update  address set  receiver_name=?  ,  receiver_phone=?  ,  receiver_mobile=?  ,  receiver_province=?,
									receiver_city=?  ,  receiver_district=? , receiver_address=? , receiver_zip=?,update_time=now()
where 


//购物车
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
(1,'张三',null,'125548215','天津1','天津2','天津区','东软','012000',now(),now()),
(1,'张三',null,null,null,null,null,null,null,now(),now());

订单 UserOrder
create table UserOrder (
id int(11) not null primary key  auto_increment  comment '订单id',
order_no bigint(20) default null comment '唯一约束 订单号',
user_id int(11) default null  comment '用户id',
shipping_id int(11) default null  comment '地址id',
payment decimal(20,2) default null  comment '实际付款金额,单位元,保留两位小数',
payment_type int(4) default null  comment '支付类型 1-在线支付 2-货到付款',
postage int(10) default null comment '运费,单位元',
status int(10) default null  comment '订单状态  0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭',
payment_time datetime default null comment '支付时间',
send_time datetime default null  comment '发货时间',
end_time datetime default null  comment '交易完成时间',
close_time datetime default null  comment '交易关闭时间',
create_time datetime default null comment '创建时间',
update_time datetime default null comment '更新时间',
unique key order_no_key(order_no)）

订单明细 UserOrderItem
create table userorderitem (
id int(11) not null primary key  auto_increment   comment '订单字表id',
order_no bigint(20) default null comment '索引 订单编号 ',
user_id int(11) default null comment '索引 用户id',
product_id int(11) default null  comment '商品id',
product_name varchar(100) default null  comment '商品名称',
product_image varchar(500) default null  comment '商品图片地址',
current_unit_price decimal(20,2) default null  comment '生成订单时的商品金额,单位元,保留两位小数',
quantity int(10) default null  comment '商品数量',
total_price decimal(20,2) default null  comment '商品总价,单位元,保留两位小数',
create_time datetime default null  comment '创建时间',
update_time datetime default null  comment '更新时间',
key order_no_key(order_no),key user_order_key(user_id,order_no))

