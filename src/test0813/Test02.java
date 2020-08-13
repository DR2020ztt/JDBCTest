package test0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//带参数的增删改查
public class Test02 {
	
	public void doSelect(int deptno)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","root");
			PreparedStatement pst=con.prepareStatement("select * from emp where deptno=?");//?->占位符
			pst.setInt(1, deptno);//给？赋值
			ResultSet rs=pst.executeQuery();//返回的是结果集
			
			if(rs.next())//原来游标指向第一行的上部，执行此句游标指向第一句
				//->对它进行if判断,否则条件不符合时会出现空指针异常
			{
				System.out.println(rs.getInt("deptno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job"));
				
			}
			
				
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doInsert(int deptno,String ename,String job)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","root");
			PreparedStatement pst=con.prepareStatement("insert into dept values(?,?,?)");
			pst.setInt(1, deptno);
			pst.setString(2,ename);
			pst.setString(3, job);
			int result=pst.executeUpdate();//返回int->是几行被操作
			
			if(result>0)
			{
				System.out.println("ok");
			}
			else
			{
				System.out.println("error");
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doUpdate(String ename,String job,int deptno)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","root");
			PreparedStatement pst=con.prepareStatement("update emp set ename=?,job=? where deptno=?");
			pst.setString(1,ename);
			pst.setString(2, job);
			pst.setInt(3, deptno);
			
			int result=pst.executeUpdate();//增删改
			
			if(result>0)
			{
				System.out.println("ok");
			}
			else
			{
				System.out.println("error");
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDelete(int deptno)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","root");
			PreparedStatement pst=con.prepareStatement("delete from emp where deptno=?");
			
			pst.setInt(1, deptno);
			
			int result=pst.executeUpdate();//增删改
			
			if(result>0)
			{
				System.out.println("ok");
			}
			else
			{
				System.out.println("error");
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		//new Test02().doSelect(100);
		new Test02().doInsert(110, "ZTT", "BOSS");
		//new Test02().doUpdate("" , "" , 100);
		//new Test02().doDelete(1);
	}
	
}
		
