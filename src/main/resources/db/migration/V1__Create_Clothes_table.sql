create table clothes (
id int unsigned primary key auto_increment,
name varchar(100) not null,
category varchar(10) not null,
waterproof int,
temperature int,
wind int
);