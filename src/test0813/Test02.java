package test0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//����������ɾ�Ĳ�
public class Test02 {
	
	public void doSelect(int deptno)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","root");
			PreparedStatement pst=con.prepareStatement("select * from emp where deptno=?");//?->ռλ��
			pst.setInt(1, deptno);//������ֵ
			ResultSet rs=pst.executeQuery();//���ص��ǽ����
			
			if(rs.next())//ԭ���α�ָ���һ�е��ϲ���ִ�д˾��α�ָ���һ��
				//->��������if�ж�,��������������ʱ����ֿ�ָ���쳣
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
			int result=pst.executeUpdate();//����int->�Ǽ��б�����
			
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
			
			int result=pst.executeUpdate();//��ɾ��
			
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
			
			int result=pst.executeUpdate();//��ɾ��
			
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
		
