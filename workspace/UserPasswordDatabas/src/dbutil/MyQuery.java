package dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import p1.MyDbConnection;
import pojo.Employee;

public class MyQuery {
	// query1		String sql="insert into USERPASSWORDDATABAS values(?,?,?,?,?)";
    //query2   	    String sql1="select * from USERPASSWORDDATABAS where id=? and pass=?";
    //query3        String sql2="select name from USERPASSWORDDATABAS where id=?";
	
	private static Connection Conn=MyDbConnection.getDbConnection();
	public static boolean insertEmployee(Employee e){
	
		boolean flag=false;
		String sql="insert into USERPASSWORDDATABAS values(?,?,?,?,?)";
		
			PreparedStatement ps=null;
try {
	ps = Conn.prepareStatement(sql);
	ps.setString(1,e.getId());
	ps.setString(5,e.getName());
	ps.setString(3,e.getMobile());
	ps.setString(4,e.getAddress());
	ps.setString(2,e.getPass());
		int i=ps.executeUpdate();
		flag=i>0?true:false;
} catch (SQLException ee) {
	// TODO Auto-generated catch block
	ee.printStackTrace();
	//out1.println("records not inserted");
	}
return flag;
		
		
		}
	
			public static boolean verify(String user, String pass){
				
				boolean flag=false;
				
				String sql1="select * from USERPASSWORDDATABAS where id=? and pass=?";
				try {
				PreparedStatement ps=Conn.prepareStatement(sql1);
								ps.setString(1,user);
								ps.setString(2,pass);
				ResultSet Rs;
				
					Rs = ps.executeQuery();
				
				if (Rs.next())
				{
					
				flag=true;
				
				}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//response.sendRedirect("index.html");
				}
				
					return flag;
		}
public static String getNameFromUser(String User)
{
	String sql2="select name from USERPASSWORDDATABAS where id=?";
    try{
	PreparedStatement ps=Conn.prepareStatement(sql2);
	ps.setString(1, User);
	ResultSet Rs=ps.executeQuery();
	if(Rs.next())
	{
		return (String)Rs.getString(1);
	}
	
	
	}
	catch (Exception E){
		E.printStackTrace();
	}
	
	
	
	
	return "invalid user go to login first";
}
}
