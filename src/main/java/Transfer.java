
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		int taccno=Integer.parseInt(request.getParameter("tnum"));
		Double tamount=Double.parseDouble(request.getParameter("amt"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","tanuj20021008");
			PreparedStatement ps=con.prepareStatement("select*from bank where accno=? and name=? and password=?");
			ps.setInt(1, accno);
			ps.setString(2, name);
			ps.setString(3, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				double sender_amount=rs.getDouble("amount");
				Double newone_amount=sender_amount-tamount;
				ps.close();
				PreparedStatement sp=con.prepareStatement("select*from bank where accno=?");
				sp.setInt(1, taccno);
				ResultSet sr=sp.executeQuery();
				if(sr.next()) {
					double receiver_amount=sr.getDouble("amount");
					double newsec_amount=receiver_amount+tamount;
					PreparedStatement pstmt=con.prepareStatement("update bank set amount=? where accno=?");
					pstmt.setDouble(1, newsec_amount);
					pstmt.setInt(2, taccno);
					pstmt.executeUpdate();
					pstmt.close();
					out.print("second person balance: "+newsec_amount+"<br>");
					
					
				}
				else {
					out.print("user account not found");
				}
				PreparedStatement stmt=con.prepareStatement("update bank set amount=? where accno=?");
				stmt.setDouble(1, newone_amount);
				stmt.setInt(2, accno);
				stmt.executeUpdate();
				out.print("first person balance: "+newone_amount+"<br>");
				
				
			}
			else {
				out.print("target account not found");
			}
			
		}
		catch(Exception ex) {
			
		}
		
	}

}
