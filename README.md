create user traczlu1 with password 'traczlu1';
create database traczlu1 with owner traczlu1 ENCODING 'UTF8';
grant ALL on database traczlu1 to traczlu1;


insert into users (login, password) values ('traczlu1', 'traczlu1');
insert into users (login, password) values ('admin', 'admin');