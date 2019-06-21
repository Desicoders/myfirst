package a1;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.MyDbConnection;

/**
 * Servlet implementation class MyController
 */
@WebServlet("/mycontroller")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
						PrintWriter out1=response.getWriter();
							String action=request.getParameter("action");
							
							
								switch(action){
								
								
								case "signup" :
									boolean flag=new Signup().storeData(request);
									
									if(flag)
										response.sendRedirect("login.html");
									else	
									response.sendRedirect("signup.html");
											
										break;
									
								case "login" :
									
									
							String user=request.getParameter("name");
							String pass=request.getParameter("pass");
							
							boolean status=new Login().verify(user, pass);
							
							if(status){
								Cookie c=new Cookie("u",user);
								response.addCookie(c);
								response.sendRedirect("Welcome");
							}
							else{
								response.sendRedirect("error");
							}
									
									
									
									break;
																	}  
									
									
								
								}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

