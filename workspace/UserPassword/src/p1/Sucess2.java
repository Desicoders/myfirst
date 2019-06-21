package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mydb.MyDbQuery;

/**
 * Servlet implementation class Sucess2
 */
@WebServlet("/sucess2")
public class Sucess2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sucess2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
								response.setContentType("text/html");
						PrintWriter out=response.getWriter();
										HttpSession session=request.getSession();
											ArrayList  al=new ArrayList();
									ResultSet rs=MyDbQuery.showData();
									try {
									out.println("<table border='2'>");
										while(rs.next()){
											MyUser u=new MyUser();
											int id=rs.getInt(1);
											String name=rs.getString(2);
											u.setId(id);
											u.setName(name);
											al.add(u);
								out.println("<tr>");
								out.println("<th>"+id+ "</th> <th>"+name +"</th>");
								out.print("</tr>");
										}
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									out.println("</table>");
									session.setAttribute("user",al);
						out.println("<a href='show'><button>Show</button>");
			//	out.print("<script> alert(' name : '+name+' \n add : '+add+' \n email : '+email )</script>");
		//out.println(name+"  :  "+add+ " : "+email);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
