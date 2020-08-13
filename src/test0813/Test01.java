package test0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {
	
	public static void main(String[] args) {
		/**
		 * jdbc核心接口与类
		 * 1、DriverManager：类、管理数据库驱动
		 * 2、Connection：接口、创建数据库连接
		 * 3、PreparedStatement：接口：发生sql语句、并接受返回值
		 * 4、ResultSet：接口：将查询返回的结果集放入ResultSet
		 */
		
		//jdbc模块代码
		
		try {
			//1、加载jdbc驱动（使用java反射加载驱动程序）
			Class.forName("com.mysql.jdbc.Driver");//可动态修改类名
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 *2、使用DriverManager类中getConnection来获取一个数据库连接
		 *getConnection方法三个参数：
		 *1、连接字符串 
		 *2、用户名
		 *3、密码
		 */
		
		try {
			//2、使用DriverManager类中getConnection来获取一个数据库连接
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","root");
			//3、使用PreparedStatement发生sql语句
			PreparedStatement pst=con.prepareStatement("select * from emp");
			//4、接受操作数据库结果
			ResultSet rs=pst.executeQuery();
			
			//将rs中的数据取出
			/*
			 * ResultSet中就是一张查询出来的表，这个表中有一个指针（游标）
			 * 这个指针默认指向第一行的上部。使用next方法控制指针向下移动。
			 * 同时，next方法还会返回一个boolean值，表示是否有下一行
			 */
			while(rs.next())
			{
				int deptno=rs.getInt("deptno");//字段名-》把第一个名字取出来
				String ename=rs.getString("ename");
				String job=rs.getString("job");//靠字段名取出字段
				System.out.println(deptno+"\t"+ename+"\t"+job);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
