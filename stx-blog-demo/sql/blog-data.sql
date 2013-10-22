--用户初始数据
insert into tbl_user values(1, '张三', '神马的空间', '123456', null, null, sysdate, sysdate, null);

--博文分类初始数据
insert into tbl_category values (1, '学习体会', 1, sysdate);

--博文初始数据
insert into tbl_blogger values(seq_blogger.nextval, 1, '第一个博文', '我的第一个博文的内容', 1, null, null, sysdate, null);
insert into tbl_blogger values(seq_blogger.nextval, 1, '第二个博文', '我的第二个博文的内容', 1, null, null, sysdate, null);

commit;