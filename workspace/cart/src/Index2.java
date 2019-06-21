

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index2
 */
@WebServlet("/Index2")
public class Index2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out1=response.getWriter();
        HttpSession session=request.getSession(false);
        String id=(String)session.getAttribute("id");
        String name=(String)session.getAttribute("name");
		out1.println("<!DOCTYPE html>");
		out1.println("<html>");
				out1.println("<head>");
  out1.println("</head>");
out1.println("<body bgcolor='pink'>");

out1.println("<h1 align='center' >welcome"+name+" to stattionary shop <hr></h1></div></br></br>");
out1.println("<form  action='mycontroller'  name='form1'method='get'>");
out1.println("<input type='hidden' name='action' value='cart'>");
out1.println("<img alt='pen' src='pen.jpg'>");
out1.println("<input type='number' id='numbrfield' name='pen1'/>");
out1.println("<img alt='pencil' src='pencil.jpg'>");
out1.println("<input type='number' id='numbrfield' name='pencil1'/>");
out1.println("<input type='submit' value='submit' > ");
out1.println("</form>");
out1.println("</body>");
out1.println("</html>");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
