package mydb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyDbQuery {
	
	static Connection conn=MyDbConnection.getDbConnection();
	public static ResultSet showData(){
		ResultSet rs=null;
	String sql2="select * from Student ";
	try{
	PreparedStatement ps=conn.prepareStatement(sql2);
	rs=ps.executeQuery();
	if (rs!=null)
	{
		return rs;
	}

	}
	catch(Exception e){}
	return rs;
}
}
