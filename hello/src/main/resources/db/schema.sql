-- create table personInfo
DROP TABLE IF EXISTS `personInfo`;
create table `personInfo`(
                             `id` int(20) not null primary key,
                             `name` varchar(30) default null
);

-- create table addresses
DROP TABLE IF EXISTS `addresses`;
create table `addresses`(
                            `id` int(20) not null primary key,
                            `address_name` varchar(30) default null,
                            `pid` int(20) default null
);

-- create table club
DROP TABLE IF EXISTS `club`;
create table `club`(
                       `id` int(20) not null primary key,
                       `name` varchar(30) default null
);
-- create table personClub
DROP TABLE IF EXISTS `personClub`;
create table `personClub`(
                             `id` int(20) not null primary key,
                             `pid` int(20) default null,
                             `cid` int(20) default null
);
-- create table loginUser
DROP TABLE IF EXISTS `loginUser`;
create table `loginUser`(
                            `id` int(20) not null primary key,
                            `username` varchar(30) default null,
                            `password` varchar(30) default null,
                            `permission` varchar(30) default 'read',
                            `role` varchar(30) default 'normal',
                            `token` varchar(500) default null
);