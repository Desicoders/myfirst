

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
									String user=request.getParameter("name");
											String pass=request.getParameter("pass");
											Connection Conn=MyDbConnection.getDbConnection();
											System.out.println(Conn+"*****");
											String sql="insert into mysign values(?,?)";
											
									PreparedStatement ps;
									try {
										ps = Conn.prepareStatement(sql);
										ps.setString(1,user);
										ps.setString(2,pass);
										ps.executeUpdate();
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										out1.print("record not inserted");
									}
											   
											
				       
									
									break;
									
								case "login" :
									
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
