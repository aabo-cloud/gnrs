drop database if exists db_name_sys;

create database db_name_sys;

use db_name_sys;

create table t_name_entry (
	`id` int PRIMARY KEY auto_increment,
	`readable_name` varchar(200),
	`guid` varchar(32) unique not null,
	`ip` varchar(15)
);

insert into t_name_entry(`readable_name`, `guid`, `ip`) VALUES('soul', '3aec8061d2abe61b73805667c261920d', '127.0.0.1');

select * from t_name_entry;