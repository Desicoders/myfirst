package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
						PrintWriter out=response.getWriter();
							String action=request.getParameter("action");
							
				System.out.println(" action :"+ action+" user "+request.getParameter("name"));
							
							
								switch(action){
								
								
								case "login" :
									String user=request.getParameter("name");
											String pass=request.getParameter("pass");
									if(user.equalsIgnoreCase("ducat") && pass.equals("ducat")){
										
											out.println("<script> alert(' login sucessfull ')</script>");
											response.sendRedirect("sucess2");
									}
									else{
										
										out.println("<script> alert(' login failed ') </script>");
											
											request.getRequestDispatcher("login.html").include(request, response);;
											
									}
									
									break;
									
								case "signup" :
									
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
