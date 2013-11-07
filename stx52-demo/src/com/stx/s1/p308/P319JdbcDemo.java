package com.stx.s1.p308;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc示例(未捕获异常)
 * 
 * @author getan
 * 
 */
public class P319JdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		// 0.加载数据库驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 1.获取连接
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "stx52", "stx52");

		// 2.创建语句对象
		Statement stmt = con.createStatement();

		// 3.执行sql语句
		ResultSet rs = stmt.executeQuery("select * from TBL_USER");// 查询

		// 4.处理执行结果
		while (rs.next()) {
			//System.out.println(rs.getInt(1) + ";" + rs.getString(2));// 通过列号(索引)获取数据
			System.out.println(rs.getInt("userid") + ";" + rs.getString("uname"));// 通过列名获取数据
		}

		// 5.关闭资源(释放资源的顺序与创建资源的顺序相反)
		rs.close();
		stmt.close();
		con.close();

	}

}

