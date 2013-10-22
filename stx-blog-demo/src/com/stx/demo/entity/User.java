package com.stx.demo.entity;

import java.util.Date;

/**
 * 博客用户 实体类
 * 
 * @author yaofu
 * 
 * @createDate 2013-1-12
 * 
 */
public class User {
	// 用户编号
	private int usid;
	// 用户名
	private String uname;
	// 博客名
	private String blogname;
	// 用户密码
	private String password;
	// 用户邮箱
	private String email;
	// 博客描述
	private String description;
	// 创建时间
	private Date createtime;
	// 最后修改时间
	private Date lastmodifytime;
	// 是否删除标记
	private String delflag;

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getBlogname() {
		return blogname;
	}

	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastmodifytime() {
		return lastmodifytime;
	}

	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}
