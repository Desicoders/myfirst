package a1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dbutil.MyQuery;
import p1.MyDbConnection;
import pojo.Employee;

public class Signup {
	
	
	public boolean storeData(HttpServletRequest request){
		
		Employee e=new Employee();
		e.setId(request.getParameter("id"));
		e.setPass(request.getParameter("pass"));
		e.setMobile(request.getParameter("mobile"));
		e.setAddress(request.getParameter("address"));
		e.setName(request.getParameter("name"));
		
				return  MyQuery.insertEmployee(e);
		
}
}