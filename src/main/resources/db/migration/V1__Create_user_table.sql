create table user(
 id int auto_increament primary key,
 name varchar(50),
 account_id varchar(100),
 token char(36),
 gmt_create bigint,
 gmt_modify bigint
);