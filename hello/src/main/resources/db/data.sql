--insert data for table  personInfo
insert into personInfo(id,name) values (1,'fenglirong');
insert into personInfo(id,name) values (2,'Frank');
insert into personInfo(id,name) values (3,'zhangsan');
insert into personInfo(id,name) values (4,'lisi');
insert into personInfo(id,name) values (5,'wangwu');
insert into personInfo(id,name) values (6,'zhaoliu');

--insert data for table  addresses
insert into addresses(id,address_name,pid) values (1,'beijing',1);
insert into addresses(id,address_name,pid) values (2,'shanghai',1);
insert into addresses(id,address_name,pid) values (3,'tianjin',2);
insert into addresses(id,address_name,pid) values (4,'longmen',2);
insert into addresses(id,address_name,pid) values (5,'wuhan',3);
insert into addresses(id,address_name,pid) values (6,'deguo',3);
--insert data for table  club
insert into club(id,name) values (1,'jingdong');
insert into club(id,name) values (2,'ali');
insert into club(id,name) values (3,'meituan');
insert into club(id,name) values (4,'dadi');
insert into club(id,name) values (5,'yonghui');
--insert data for table  personClub
insert into personClub(id,pid,cid) values (1,1,1);
insert into personClub(id,pid,cid) values (2,1,2);
insert into personClub(id,pid,cid) values (3,2,2);
insert into personClub(id,pid,cid) values (4,2,3);
insert into personClub(id,pid,cid) values (5,3,3);
--insert data for table  loginUser
insert into loginUser(id,username,password,permission,role) values(1,'Frank','123456','write','ROLE_admin');
insert into loginUser(id,username,password,permission,role) values(2,'employee','123456','read','ROLE_normal');
insert into loginUser(id,username,password,permission,role) values(3,'leader','123456','write','ROLE_admin');
