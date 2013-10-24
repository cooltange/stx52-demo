package com.stx.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.demo.dao.UserDao;
import com.stx.demo.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 用户Dao对象
	private UserDao dao;
	
	/*
     * 初始化方法
     * 
     * 将初始化dao对象的操作放入init()方法,可保证dao只被创建一次
     */
	@Override
	public void init() throws ServletException {
		dao = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求编码集为utf-8(避免中文乱码)
		request.setCharacterEncoding("utf-8");

		// 从页面获取登录数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			// 调用dao判断用户登录名与密码是否合法(非法时返回为null，合法时返回一个当前登录用户的用户对象)
			User user = dao.getUserByUnameAndPassword(username, password);

			// 判断登录名与密码是否正确
			if (user == null) {
				// 失败的情况
				// 将登录失败提示信息保存到request对象中(该提示信息会显示在JSP页面中的${message}处)
				request.setAttribute("message", "用户名或密码错误!");
			} else {
				// 成功的情况
				// 从request对象获得session(会话)对象
				HttpSession session = request.getSession();
				/*
				 * 将保持有当前用户信息状态的user对象存放入session(会话)对象
				 * 为未后续的各种操作如发文章,添加文章种类等提供便利(因为此类操作需要获得当前用户的id)
				 */
				session.setAttribute("currentUser", user);
				// 将登录成功提示信息保存到request对象中(该提示信息会显示在JSP页面中的${message}处)
				request.setAttribute("message", "用户登陆成功!");
			}
			// 请求转发给博客首页(/home)
			getServletContext().getRequestDispatcher("/home").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
