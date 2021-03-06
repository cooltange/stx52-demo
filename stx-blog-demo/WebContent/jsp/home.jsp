﻿<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.stx.demo.entity.User"%>
<%@page import="com.stx.demo.entity.Blogger"%>
<%@page import="com.stx.demo.dao.BloggerDao"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>双体博客</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<!-- Le styles -->
	<link href="css/bootstrap.css" rel="stylesheet">
	<style>
	body {
		padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
	}
	</style>
	
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
					<span class="icon-bar"> </span> 
					<span class="icon-bar"> </span>
					<span class="icon-bar"> </span>
				</a>
				<a class="brand" href="#"> 双体博客 </a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="#"> 主页 </a></li>
						<li><a href="#"> 关于我们 </a></li>
						<li><a href="mail:to#"> 联系我们 </a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		${message}
		<div class="row-fluid">
			<div class="span3">
				<% 
					// 从会话对象中获取当前登陆用户对象
					User user = (User)session.getAttribute("currentUser");
					// 判断用户是否登陆成功
					if(user == null){// 未成功时需仍显示登陆框
				%>
					<form action="<%=request.getContextPath()%>/login" method="post">
						<div class="control-group">
							<label for="username">用户名</label> 
							<input type="text" id="username" name="username" >
						</div>
						<div class="control-group">
							<label for="password">密码</label> 
							<input type="password" name="password" >
						</div>
						<input class="btn btn-primary" type="submit" value="登陆"/> 
						<a class="btn btn-primary" href="<%=request.getContextPath()%>/jsp/register.jsp"> 注册 </a>
					</form>
				<% }else{ %>
					欢迎您! <%=user.getUname()%><br/>
					您的博客名是:<%=user.getBlogname()%>
				<%} %>
			</div>
			<div class="span9">
				<ul class="nav nav-tabs">
					<li class="active"><a>最新更新的博客</a></li>
				</ul>
				<div class="hero-unit">
					<%
					// 从request对象中获取BlogHomeServlet中传过来的博文列表对象
					ArrayList<Blogger> bloggerList = (ArrayList<Blogger>) request.getAttribute("bloggerList");
					// 判断博文列表对象是否为空
					if (bloggerList != null) {
					%>
					<%
						// 遍历博文列表以显示最新更新的博文 
						for (Blogger blogger : bloggerList) {
					%>
					<!-- 博文列表开始 -->
					<div class="row well">
						<div class="well">
							<div class="span4"><h4><%=blogger.getTitle()%></h4></div>
							<div class="span3 offset5"><%=blogger.getCreatetime().toString().substring(0,10)%></div>
						</div>
						<div class="well">
							<%=blogger.getContent() %>
						</div>
						<div class="span2"><a class="btn btn-primary" href="#"> 查看全文 » </a></div>
					</div>
					<!-- 博文列表结束 -->
					<%
						}
					}
					%>
				</div>
			</div>
		</div>
		
		<hr>
		
		<div>©company 双体系 2013</div>
	</div>
	
</body>
</html>
