

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import p1.MyDbConnection;

/**
 * Servlet implementation class Final
 */
@WebServlet("/Final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Final() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int total=0;
		response.setContentType("Text/html");
		String Sql="Select * from cart";
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("name");
		pw.println("<h1>hi"+user +" your cart is ready");
		Connection Connl=p1.MyDbConnection.getDbConnection();
		try {
			PreparedStatement rs=Connl.prepareStatement(Sql);
			ResultSet Rs;
			
				Rs = rs.executeQuery();
			
			while (Rs.next())
			{
				String Pid=Rs.getString(1);
				String PNAME=Rs.getString(2);
				String Price=Rs.getString(3);
				String qty=Rs.getString(4);
				String cid=Rs.getString(5);
				total+=Integer.parseInt(Price)*Integer.parseInt(qty);
				pw.println("<br> <h1>"+"Pid"+Pid+": Pname " +PNAME+": Price"+Price+"qty:"+qty+"Cid:"+cid);
			}
			pw.print("</h1>total money "+total);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("index.html");
			}
		
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
