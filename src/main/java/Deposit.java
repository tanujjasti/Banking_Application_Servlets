

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
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
		double damount=Double.parseDouble(request.getParameter("damt"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","tanuj20021008");
			PreparedStatement ps=con.prepareStatement("select*from bank where accno=? and name=? and password=?");
			ps.setInt(1, accno);
			ps.setString(2, name);
			ps.setString(3, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				double old_amount=rs.getDouble("amount");
			    double new_amount=old_amount+damount;
			    PreparedStatement sp=con.prepareStatement("update bank set amount=? where accno=? and name=? and password=?");
			    sp.setDouble(1,new_amount);
			    sp.setInt(2, accno);
			    sp.setString(3,name);
			    sp.setString(4, password);
			    int i=sp.executeUpdate();
			    if(i>0) {
			    	out.print("amount before deposit: "+old_amount+"<br>");
			    	out.print("amount after deposit: "+new_amount);
			    	}
			    else {
			    	out.print("something is fishy");
			    }
			    con.close();
			}
			
		}
		catch(Exception ex) {
			out.print(ex);
			
		}
	}

}
