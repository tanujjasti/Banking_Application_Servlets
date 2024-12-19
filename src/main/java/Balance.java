import java.sql.*;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Balance
 */
@WebServlet("/Balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Balance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int accno=Integer.parseInt(request.getParameter("anum"));
		String name=request.getParameter("cname");
		String password =request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","tanuj20021008");
			PreparedStatement ps=con.prepareStatement("select*from bank where accno=? and name=? and password=?");
			ps.setInt(1, accno);
			ps.setString(2, name);
			ps.setString(3, password);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsd=rs.getMetaData();
			int n=rsd.getColumnCount();
			out.print("<table border='1'>");
			for(int i=1;i<=n;i++) {
				out.print("<td>"+rsd.getColumnName(i));
			}
			out.print("<tr>");
			if(rs.next()) {
				int status=rs.getInt(7);
				out.print("<td>"+rs.getInt(1));
				out.print("<td>"+rs.getString(2));
				out.print("<td>"+rs.getString(3));
				out.print("<td>"+rs.getDouble(4));
				out.print("<td>"+rs.getString(5));
				out.print("<td>"+rs.getInt(6));
				if(status==1) {
					out.print("<td>"+"active");
				}
				else {
					out.print("<td>"+"deactive");
				}
			}
			con.close();
		}
		catch(Exception ex) {
			
		}
	}

}
