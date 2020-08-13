package test0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {
	
	public static void main(String[] args) {
		/**
		 * jdbc���Ľӿ�����
		 * 1��DriverManager���ࡢ�������ݿ�����
		 * 2��Connection���ӿڡ��������ݿ�����
		 * 3��PreparedStatement���ӿڣ�����sql��䡢�����ܷ���ֵ
		 * 4��ResultSet���ӿڣ�����ѯ���صĽ��������ResultSet
		 */
		
		//jdbcģ�����
		
		try {
			//1������jdbc������ʹ��java���������������
			Class.forName("com.mysql.jdbc.Driver");//�ɶ�̬�޸�����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 *2��ʹ��DriverManager����getConnection����ȡһ�����ݿ�����
		 *getConnection��������������
		 *1�������ַ��� 
		 *2���û���
		 *3������
		 */
		
		try {
			//2��ʹ��DriverManager����getConnection����ȡһ�����ݿ�����
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","root");
			//3��ʹ��PreparedStatement����sql���
			PreparedStatement pst=con.prepareStatement("select * from emp");
			//4�����ܲ������ݿ���
			ResultSet rs=pst.executeQuery();
			
			//��rs�е�����ȡ��
			/*
			 * ResultSet�о���һ�Ų�ѯ�����ı����������һ��ָ�루�α꣩
			 * ���ָ��Ĭ��ָ���һ�е��ϲ���ʹ��next��������ָ�������ƶ���
			 * ͬʱ��next�������᷵��һ��booleanֵ����ʾ�Ƿ�����һ��
			 */
			while(rs.next())
			{
				int deptno=rs.getInt("deptno");//�ֶ���-���ѵ�һ������ȡ����
				String ename=rs.getString("ename");
				String job=rs.getString("job");//���ֶ���ȡ���ֶ�
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
