DROP DATABASE IF EXISTS gpss;
create database gpss;
USE gpss;

drop table if exists employee_type;
CREATE TABLE employee_type(
   etypeid              int not null auto_increment, 
   name                 varchar(30)not null,
   CONSTRAINT pk_eid PRIMARY KEY (etypeid)
) engine='innodb' default charset=utf8;
insert into employee_type( name) values("普通员工");


drop table if exists employee;
CREATE TABLE employee(
   eid                  int not null auto_increment, 
   name                 varchar(30)not null,
   mobile               varchar(15)not null,
   birthday             datetime not null,
   etypeid              int not null,
   updatedtime          datetime not null,
   updater              varchar(30)not null,
   CONSTRAINT pk_eid PRIMARY KEY (eid),
   CONSTRAINT fk_etypeid FOREIGN KEY(etypeid) REFERENCES employee_type(etypeid)
) engine='innodb'  default charset=utf8;
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("xx","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("xxx","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("xxxx","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("aa","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("cc","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("dd","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("xx","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("oo","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("apple","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("havana","13565554878","2010-11-5",1,"2011-5-11","admin001");
insert into employee(name,mobile,birthday,etypeid,updatedtime,updater)values("yy","13565554878","2010-11-5",1,"2011-5-11","admin001");


drop table if exists user;
CREATE TABLE user(
   uid                  varchar(50) not null,
   eid                  int not null,
   name                 varchar(30)not null,
   password             varchar(32)not null,
   locked            	int,
   CONSTRAINT pk_uid PRIMARY KEY (uid),
   CONSTRAINT fk_eid FOREIGN KEY(eid) REFERENCES employee(eid) on delete NO ACTION
) engine='innodb'  default charset=utf8;
insert into user(uid,eid,name,password,locked) values("admin001",1,"测试小酱油1","111111",0);
insert into user(uid,eid,name,password,locked) values("admin005",5,"测试小酱油5","111111",0);
insert into user(uid,eid,name,password,locked) values("admin006",6,"测试小酱油77","111111",0);
insert into user(uid,eid,name,password,locked) values("storer001",2,"测试小酱油2","111111",0);
insert into user(uid,eid,name,password,locked) values("saler002",3,"测试小酱油3","111111",0);
insert into user(uid,eid,name,password,locked) values("saler001",4,"测试小酱油4","111111",0);
insert into user(uid,eid,name,password,locked) values("purchaser001",5,"测试小酱油5","111111",0);
insert into user(uid,eid,name,password,locked) values("purchaser004",6,"测试小酱油6","111111",0);
insert into user(uid,eid,name,password,locked) values("tester6379",7,"测试小酱油7","111111",0);
insert into user(uid,eid,name,password,locked) values("admin002",8,"测试小酱油8","111111",0);
insert into user(uid,eid,name,password,locked) values("admin003",9,"测试小酱油9","111111",0);
insert into user(uid,eid,name,password,locked) values("storer005",10,"测试小酱油00","111111",0);
insert into user(uid,eid,name,password,locked) values("purchaser008",11,"测试小酱油11","111111",0);

drop table if exists role;
CREATE TABLE role(
   rid                  int not null auto_increment,  
   name                 varchar(30)not null,
   CONSTRAINT pk_mid PRIMARY KEY (rid)
) engine='innodb'  default charset=utf8;

insert into role(name) values("admin");
insert into role(name) values("saler");
insert into role(name) values("storer");
insert into role(name) values("purchaser");

drop table if exists user_role;
CREATE TABLE user_role(
   uid                 varchar(50) not null,
   rid                 varchar(30)not null,
   CONSTRAINT fk_uid FOREIGN KEY(uid) REFERENCES user(uid)
) engine='innodb'  default charset=utf8;
insert into user_role(uid,rid) values("admin001","1");

drop table if exists permission;
CREATE TABLE permission(
   pid                  varchar(50) not null,
   name                 varchar(30)not null,
   CONSTRAINT pk_mid PRIMARY KEY (pid)
) engine='innodb'  default charset=utf8;

drop table if exists supplier;
CREATE TABLE supplier(
   sid                  int not null auto_increment, 
   name                 varchar(15)not null,
   mobile               varchar(15)not null,
   contacts_name        varchar(15)not null,
   address             	varchar(60)not null,
   description        	varchar(300)not null,
   updatetime           datetime not null,
   CONSTRAINT pk_sid PRIMARY KEY (sid)
) engine='innodb'  default charset=utf8;

insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('统一','16554788956' , '李刚' , '广东省广州市' ,'食品供应商', '2016-12-20');
insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('康师傅','16554788956' , '陈大希' , '广东省广州市' ,'食品供应商', '2016-12-20-07:30');
insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('徐福记','13546558795' , '刘华' , '广东省广州市' ,'食品供应商', '2016-12-20-07:30');
insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('李锦记','16554788956' , '胡斐' , '广东省广州市' ,'食品供应商', '2016-12-20-07:30');
insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('旺旺','16554788956' , '武正好' , '广东省广州市' ,'食品供应商', '2016-12-20-07:30');
insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('百事','16554788956' , '曾玲玲' , '广东省广州市' ,'食品供应商', '2016-12-20-07:30');
insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('伊利','16554788956' , '马小如' , '广东省广州市' ,'食品供应商', '2016-12-20-07:30');
insert into supplier(name,mobile , contacts_name, address, description, updatetime) values('阿尔卑斯','16554788956' , '陈梦兰' , '广东省广州市' ,'食品供应商', '2016-12-20-07:30');

drop table if exists storage;
CREATE TABLE storage(
   sid                 int not null auto_increment, 
   eid                  int not null,
   name                 varchar(30)not null,
   address             varchar(32)not null,
   description          varchar(32)not null,
   CONSTRAINT pk_sid PRIMARY KEY (sid),
   CONSTRAINT fk_eid_storage FOREIGN KEY(eid) REFERENCES employee(eid)
) engine='innodb' default charset=utf8;

insert into storage(eid, name, address, description) values(2,"北京仓库","北京市海淀区","一号仓库");
insert into storage(eid, name, address, description) values(2,"成都仓库","成都市","二号仓库");
insert into storage(eid, name, address, description) values(2,"上海仓库","上海市","三号仓库");
insert into storage(eid, name, address, description) values(2,"广州仓库","北京市海淀区","四号仓库");

drop table if exists goods_type;
CREATE TABLE goods_type(
   gtype_id                 int not null auto_increment, 
   name                 varchar(30)not null,
   CONSTRAINT pk_gtype_id PRIMARY KEY (gtype_id)
) engine='innodb' default charset=utf8;
insert into goods_type( name) values("方便食品");
insert into goods_type( name) values("膨化食品");
insert into goods_type( name) values("儿童食品");
insert into goods_type( name) values("能量饮料");
insert into goods_type( name) values("调味品");

drop table if exists goods_specification;
CREATE TABLE goods_specification(
   gspecification_id                 int not null auto_increment, 
   name                 	  varchar(30)not null,
   description                 varchar(30)not null,
   gspecification_type           varchar(30)not null,
   CONSTRAINT pk_gspecification_id PRIMARY KEY (gspecification_id)
) engine='innodb' default charset=utf8;
insert into goods_specification( name, description, gspecification_type) values("mini型", "200g", "袋");
insert into goods_specification( name, description, gspecification_type) values("加大装", "800g", "袋");
insert into goods_specification( name, description, gspecification_type) values("标准瓶", "500ml", "瓶");
insert into goods_specification( name, description, gspecification_type) values("加大瓶", "1L", "瓶");

drop table if exists goods;
CREATE TABLE goods(
   gid                 int not null auto_increment, 
   name                 varchar(30)not null,
   gtype_id              int not null,
   producer             varchar(32)not null,
   description             varchar(300)not null,
   gspecification_id           int not null,
   price          float not null,
   photo          varchar(500)not null,
   CONSTRAINT pk_gid PRIMARY KEY (gid),
   CONSTRAINT fk_gtype_id FOREIGN KEY(gtype_id) REFERENCES goods_type(gtype_id),
   CONSTRAINT fk_gspecification_id FOREIGN KEY(gspecification_id) REFERENCES goods_specification(gspecification_id)
) engine='innodb' default charset=utf8;
INSERT INTO `goods`( `name`, `gtype_id`, `producer`, `description`, `gspecification_id`, `price`, `photo`) VALUES ( '红烧牛肉面', 2, '康师傅', '方便面', 1, 2, 'https://gd1.alicdn.com/imgextra/i1/2930413916/TB2Fy3Qb4Rzc1FjSZFPXXcGAFXa_!!2930413916.jpg_400x400.jpg');
INSERT INTO `goods`( `name`, `gtype_id`, `producer`, `description`, `gspecification_id`, `price`, `photo`) VALUES ( '旺旺仙贝', 2, '旺旺食品', '休闲食品', 2, 4, 'https://img.alicdn.com/bao/uploaded/i1/TB2jMoTIMmTBuNjy1XbXXaMrVXa_!!0-rate.jpg_400x400.jpg');
INSERT INTO `goods`( `name`, `gtype_id`, `producer`, `description`, `gspecification_id`, `price`, `photo`) VALUES ( '可口可乐', 4, '可口可乐公司', '碳酸饮料', 4, 5, 'https://img.alicdn.com/imgextra/i4/725677994/TB2sLUffeGSBuNjSspbXXciipXa_!!725677994.jpg_430x430q90.jpg');
INSERT INTO `goods`( `name`, `gtype_id`, `producer`, `description`, `gspecification_id`, `price`, `photo`) VALUES ( '鲜橙多', 4, '鲜橙多食品', '果汁', 4, 6, 'https://img.alicdn.com/imgextra/i2/725677994/TB2y5P_m3vD8KJjSsplXXaIEFXa_!!725677994.jpg_430x430q90.jpg');



drop table if exists menu;
CREATE TABLE menu(
   mid                 int not null auto_increment, 
   name                 varchar(30)not null,
   url                 varchar(150),
   parent_mid              int ,
   CONSTRAINT pk_gid PRIMARY KEY (mid),
   CONSTRAINT fk_parent_mid FOREIGN KEY(parent_mid) REFERENCES menu(mid)
) engine='innodb' default charset=utf8;
INSERT INTO `menu`( `name`, `url`) VALUES ( '菜单', '/gpss-web');
INSERT INTO `menu`( `name`,`parent_mid`) VALUES ( '基础设置', 1);
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '商品管理', 2, '/goods/goods_manage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '仓库管理', 2, '/storage/storage_manage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '员工管理', 2, '/user/employee_manage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '基础参数', 2, '/goods/goods_param_manage');
INSERT INTO `menu`( `name`,`parent_mid` ) VALUES ( '采购管理', 1);
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '供应商管理', 7, '/procurement/supplier_manage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '采购订单', 7, '/procurement/procurement_order');
INSERT INTO `menu`( `name`,`parent_mid`) VALUES ( '销售管理', 1);
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '客户管理', 10, '/market/customer_manage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '销售订单', 10, '/market/marketing_order');
INSERT INTO `menu`( `name`,`parent_mid`) VALUES ( '库存管理', 1);
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '库存查看', 13, '/storage/view_storage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '采购审核', 13, '/storage/procurement_check');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '销售审核', 13, '/storage/marketing_check');
INSERT INTO `menu`( `name`,`parent_mid`) VALUES ( '统计分析', 1);
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '采购统计', 17, '/statistics_analization/procurement_statistics');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '销售统计', 17, '/statistics_analization/marketing_statistics');
INSERT INTO `menu`( `name`,`parent_mid`) VALUES ( '系统管理', 1);
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '菜单管理', 20, '/system_manage/menu_manage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '角色管理', 20, '/system_manage/role_manage');
INSERT INTO `menu`( `name`,`parent_mid`, url) VALUES ( '用户管理', 20, '/system_manage/user_manage');



drop table if exists client;
CREATE TABLE client(
   cid                 int not null auto_increment, 
   name                 varchar(30)not null,
   contacts                 varchar(30)not null,
   phone_num                 varchar(18)not null,
   address                 varchar(100)not null,
   description                 varchar(100)not null,
   updatedtime              datetime not null ,
   CONSTRAINT pk_gid PRIMARY KEY (cid)
) engine='innodb' default charset=utf8;

INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');

drop table if exists purchase_order;
CREATE TABLE purchase_order(
   poid                 int not null auto_increment, 
   purchase_order_gid                  int not null,
   purchase_order_gspecification_id    int not null,
   purchase_order_store_id             int not null,
   purchase_order_supplier_id          int not null,
   num                  int not null,
   price 				float not null,
   name                 varchar(30)not null,
   audit_status			varchar(10)not null,
   createdtime          datetime not null,
   creater_id 			int not null,
   audited_id			int not null,
   audited_time          datetime not null,
   CONSTRAINT pk_poid PRIMARY KEY (poid),
    CONSTRAINT fk_purchase_order_gid FOREIGN KEY(purchase_order_gid) REFERENCES goods(gid),
    CONSTRAINT fk_purchase_order_gspecification_id FOREIGN KEY(purchase_order_gspecification_id) REFERENCES goods_specification(gspecification_id)
) engine='innodb' default charset=utf8;

INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');
INSERT INTO `gpss`.`client`( `name`, `contacts`, `phone_num`, `address`, `description`, `updatedtime`) VALUES ( 'f4fr', '3r34r4', '3654144', '33', '323', '2018-09-04 16:18:46');


