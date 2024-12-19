
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String password=request.getParameter("pass");
		String confirmpassword=request.getParameter("cpass");
		Double amount =Double.parseDouble(request.getParameter("amt"));
		String address=request.getParameter("add");
		int mobile=Integer.parseInt(request.getParameter("num"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","tanuj20021008");
			PreparedStatement ps=con.prepareStatement("insert into bank values(?,?,?,?,?,?,?)");
			ps.setInt(1, accno);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setDouble(4, amount);
			ps.setString(5, address);
			ps.setInt(6, mobile);
			ps.setInt(7, 1);
		
			int i=ps.executeUpdate();
			if(i>0) {
				out.print("data inserted");
			}
			else {
				out.print("something is fishy");
			}
			con.close();
			
			
		}
		catch(Exception ex) {
			out.print(ex);
		}
		
	}

}
