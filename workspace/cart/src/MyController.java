

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
									String id=request.getParameter("id");
											String pass=request.getParameter("pass");
											String mobile=request.getParameter("mobile");
											String address=request.getParameter("address");
											String name=request.getParameter("name");
											Connection Conn=MyDbConnection.getDbConnection();
											System.out.println(Conn+"*****");
											String sql="insert into clients values(?,?,?,?,?)";
											
									PreparedStatement ps;
									try {
										ps = Conn.prepareStatement(sql);
										ps.setString(1,id);
										ps.setString(2,name);
										ps.setString(3,mobile);
										ps.setString(4,address);
										ps.setString(5,pass);
										ps.executeUpdate();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										response.sendRedirect("index1.html");
									}
										
									response.sendRedirect("index.html");
											
				       
									
									break;
									
								case "login" :
									String userl=request.getParameter("name");
									String passl=request.getParameter("pass");
									Connection Connl=MyDbConnection.getDbConnection();
									String sql1="select * from CLIENTS where id='"+userl+"'";
									try {
									PreparedStatement rs=Connl.prepareStatement(sql1);
									ResultSet Rs;
									
										Rs = rs.executeQuery();
									
									while (Rs.next())
									{
										if(Rs.getString(5).equals(passl))
										{
											HttpSession session=request.getSession();  
									        session.setAttribute("id",Rs.getString(1));
									        session.setAttribute("name",Rs.getString(2));
									        session.setAttribute("mobile",Rs.getString(3));
									        session.setAttribute("address",Rs.getString(4));
									        session.setAttribute("pass",Rs.getString(5));
											response.sendRedirect("Index2");
										
											
										}	
									}
									}
									catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										response.sendRedirect("index.html");
									}
									
									
									break;
								case "cart":
									String pen=request.getParameter("pen1");
									String pencil=request.getParameter("pencil1");
									HttpSession session=request.getSession();
									Connection Conn1=MyDbConnection.getDbConnection();

									String cid=(String)session.getAttribute("id");
									java.lang.String sql22;
									String sql221;
									if(pen!="")
									{
										sql22="update product set qty=qty-"+pen+"where pid='pen1'";
									    sql221="insert into cart values(?,?,?,?,?)";
									    try{
											PreparedStatement ps1;
											PreparedStatement ps2;
											ps1=Conn1.prepareStatement(sql22);
											ps1.executeUpdate();

									    	
									    	
									    	
									    	ps2 = Conn1.prepareStatement(sql221);
											ps2.setString(1,"pen1");
											ps2.setString(2,"pen");
											ps2.setString(3,"10");
											ps2.setString(4,pen);
											ps2.setString(5,cid);
											ps2.executeUpdate();
											
									    	
									    	
									    }
									    catch(Exception E){
									    	E.printStackTrace();
									    }
									}  
									if(pencil!="")
									{
										String sql2222="update product set qty=qty-"+pencil+"where pid='pencil1'";
									    String sql2212="insert into cart values(?,?,?,?,?)";
									    try{
											PreparedStatement ps12;
											PreparedStatement ps22;
											ps12=Conn1.prepareStatement(sql2222);
											ps12.executeUpdate();

									    	
									    	
									    	
									    	ps22 = Conn1.prepareStatement(sql2212);
											ps22.setString(1,"pencil1");
											ps22.setString(2,"pencil");
											ps22.setString(3,"5");
											ps22.setString(4,pen);
											ps22.setString(5,cid);
											ps22.executeUpdate();
											
									    	
									    	
									    }
									    catch(Exception E){
									    	E.printStackTrace();
									    }
									} 
									response.sendRedirect("Final");
									
									
								
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
