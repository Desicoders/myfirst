package mydb;
import java.sql.*;

public class MyDbConnection{

	public static Connection conn=null;
	
	public static Connection getDbConnection(){
	
			
			if(conn==null){
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String pass="121002";
			try{
			Class.forName(driver);
					conn=DriverManager.getConnection(url,user,pass);
					
					}
					catch(Exception e){e.printStackTrace();}
					return conn;
					}
					else{
					return conn;
					}
					}
			public static void main(String...ss){
			
			System.out.println(getDbConnection());
			}
			}