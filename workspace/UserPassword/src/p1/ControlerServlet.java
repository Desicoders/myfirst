package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlerServlet
 */
@WebServlet("/went")
public class ControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ControlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated met	hod stub
								response.setContentType("text/html");
					String u=request.getParameter("user");
					String p=request.getParameter("pass");
						PrintWriter o=response.getWriter();
					
					
						if(u.equalsIgnoreCase("admin") && p.equals("admin")){
							
						Cookie c=new Cookie("u",u);
								
							response.addCookie(c);
						response.sendRedirect("Sucess");
						}
						else{
							o.println("<html><body bgcolor='green'> <h1 align='center'>");
						o.print("wrong user or password");
						o.println("</h1></body></html>");
						}
		
	}

}
