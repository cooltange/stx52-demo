package com.stx.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.stx.demo.entity.Blogger;
import com.stx.demo.util.JdbcUtil;

/**
 * 博文数据访问类
 * 
 * @author getan
 * 
 * @createDate 2013-4-12
 * 
 */
public class BloggerDao {

	public ArrayList<Blogger> queryBloggerList() throws Exception {
		// 获取connection对象
		Connection con = JdbcUtil.getConnection();
		// 创建语句对象
		Statement st = con.createStatement();

		// 查询出最新更新的十条博文信息
		String sql = "select u.usid, u.blogname, b.*\n"
				+ "  from tbl_user u, tbl_blogger b\n"
				+ " where u.usid = b.usid\n" + "   and (rownum <= 10)\n"
				+ " order by b.createtime desc";

		// 执行查询操作返回查询结果集对象
		ResultSet rs = st.executeQuery(sql);

		// 创建博客对象(用于存放从数据库查询出博客的信息)
		ArrayList<Blogger> bloggerList = new ArrayList<Blogger>();

		while (rs.next()) {
			// 创建博客对象
			Blogger bloggers = new Blogger();

			// 将数据库记录的每一个字段的值 赋值给 "博客对象"对应的属性.
			bloggers.setBlogId(rs.getInt("bid"));
			bloggers.setUserId(rs.getInt("usid"));
			// bloggers.setUs_blogname(rs.getString("blogname"));
			bloggers.setTitle(rs.getString("title"));

			// 如果博文内容大于200字节就截取
			String contents = rs.getString("content");// 博文内容
			// 处理后的文章内容
			String content = null;
			if (contents.length() > 100) {
				content = contents.substring(0, 100);// 截取文章内容的前100个字符
			} else {
				content = contents;
			}

			// 将每个字段的值赋给实体对象中对应的属性
			bloggers.setContent(content);
			bloggers.setCatId(rs.getInt("cid"));
			bloggers.setLevel(rs.getString("blevel"));
			bloggers.setReadable(rs.getString("readable"));
			bloggers.setCreateTime(rs.getTimestamp("createtime"));

			// 将该博文对象放入博文列表对象中
			bloggerList.add(bloggers);
		}

		// 释放数据库连接资源
		JdbcUtil.release(rs, st, con);

		// 返回用户信息列表对象(给servlet)
		return bloggerList;
	}

	/**
	 * 新增博客文章
	 * 
	 * @param blogger
	 * @throws SQLException
	 */
	public void addBlogger(Blogger blogger) throws SQLException {

		// 获取connection对象
		Connection con = JdbcUtil.getConnection();

		PreparedStatement ps = con.prepareStatement("insert into tbl_blogger(bid, usid, title, content, cid) values(seq_blogger.nextval, ?, ?, ?, ?);");

		ps.setInt(1, blogger.getUserId());
		ps.setString(2, blogger.getTitle());
		ps.setString(3, blogger.getContent());
		ps.setInt(4, blogger.getCatId());

		ps.executeUpdate();

		JdbcUtil.release(ps, con);
	}

}