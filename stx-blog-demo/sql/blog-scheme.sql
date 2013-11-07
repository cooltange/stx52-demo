--创建用户表
CREATE TABLE tbl_user
(
usid NUMBER,
uname VARCHAR2(255),
blogname VARCHAR2(255),
password VARCHAR2(255),
email VARCHAR2(255),
description varchar2(255),
createtime DATE,
lastmodifytime DATE,
delflag NUMBER
);
-- 设置主键
ALTER TABLE tbl_user
ADD PRIMARY KEY (usid);



--创建关系表
CREATE TABLE tbl_relation
(
rid NUMBER,
usid NUMBER,
friendid NUMBER,
creatatime DATE,
delflag NUMBER
);
--设置主键
ALTER TABLE tbl_relation
ADD PRIMARY KEY (rid);
--设置外键
ALTER TABLE tbl_relation
ADD FOREIGN KEY (usid)
REFERENCES tbl_user(usid);
--设置外键
ALTER TABLE tbl_relation
ADD FOREIGN KEY (friendid)
REFERENCES tbl_user(usid);





--创建博客类别表
CREATE TABLE  tbl_category
(
cid NUMBER,
cname VARCHAR2(255),
usid NUMBER,
createtime DATE
);
--设置外键
ALTER TABLE tbl_category
ADD PRIMARY KEY (cid);
--设置外键
ALTER TABLE tbl_category
ADD FOREIGN KEY (usid)
REFERENCES tbl_user(usid);





--创建博文表
CREATE TABLE tbl_blogger
(
bid NUMBER,
usid NUMBER,
title VARCHAR2(255) NOT NULL,
content VARCHAR2(255) NOT NULL,
cid NUMBER,
blevel NUMBER,
readable NUMBER,
createtime DATE,
delflag NUMBER
);
-- 设置主键
ALTER TABLE tbl_blogger
ADD PRIMARY KEY (bid);

-- 设置外键
ALTER TABLE tbl_blogger
ADD FOREIGN KEY (usid)
REFERENCES tbl_user(usid);
-- 设置外键
ALTER TABLE tbl_blogger
ADD FOREIGN KEY (cid)
REFERENCES tbl_category(cid);



-- 创建喜爱的博文列表
CREATE TABLE tbl_blogfavorite
(
bfid NUMBER,
bid NUMBER,
usid NUMBER,
createtime DATE,
delflag NUMBER
);
--设置主键
ALTER TABLE tbl_blogfavorite
ADD PRIMARY KEY (bfid);
--设置外键
ALTER TABLE tbl_blogfavorite
ADD FOREIGN KEY (usid)
REFERENCES tbl_user(usid);
--设置外键
ALTER TABLE tbl_blogfavorite
ADD FOREIGN KEY (bid)
REFERENCES tbl_blogger(bid);




--创建博文信息表
CREATE TABLE tbl_message
(
mid NUMBER,
title VARCHAR2(255),
sender NUMBER,
receiver NUMBER,
message VARCHAR2(255),
createtime DATE,
readflag NUMBER,
delflag NUMBER,
parentid NUMBER
);
--设置主键
ALTER TABLE tbl_message
ADD PRIMARY KEY (mid);
--设置外键
ALTER TABLE tbl_message
ADD FOREIGN KEY (sender)
REFERENCES tbl_user(usid);
--设置外键
ALTER TABLE tbl_message
ADD FOREIGN KEY (receiver)
REFERENCES tbl_user(usid);

--创建博客评论信息表
CREATE TABLE tbl_comment
(
cmid NUMBER,
bid NUMBER,
content VARCHAR2(255) NOT NULL,
usid NUMBER,
createtime DATE,
delflag NUMBER,
readflag NUMBER
);
--设置主键
ALTER TABLE tbl_comment
ADD PRIMARY KEY (cmid);
--设置外键
ALTER TABLE tbl_comment
ADD FOREIGN KEY (usid)
REFERENCES tbl_user(usid);
--设置外键
ALTER TABLE tbl_comment
ADD FOREIGN KEY (bid)
REFERENCES tbl_blogger(bid);

--用户序列
create sequence seq_user start with 1 increment by 1;
--博文序列
create sequence seq_blogger start with 1 increment by 1;

