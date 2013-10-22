package com.stx.demo.entity;

import java.util.Date;

/**
 * 博客文章 实体类
 * 
 * @author yaofu
 * 
 * @createDate 2013-1-12
 * 
 */
public class Blogger {
	// 博文ID
	private int bid;
	// 用户ID
	private int usid;
	// 博文标题
	private String title;
	// 博文内容
	private String content;
	// 分类ID
	private int cid;

	// 公开程度A=公开，M=自已可见，H=好友可见
	private String blevel;

	// 是否可评论 Y/N
	private String readable;

	// 创建时间
	private Date createtime;

	// 是否删除标志 Y/N
	private String delflag;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getBlevel() {
		return blevel;
	}

	public void setBlevel(String blevel) {
		this.blevel = blevel;
	}

	public String getReadable() {
		return readable;
	}

	public void setReadable(String readable) {
		this.readable = readable;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}
