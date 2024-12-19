

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Close
 */
@WebServlet("/Close")
public class Close extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Close() {
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
			PreparedStatement ps=con.prepareStatement("update bank set status=0 where accno=? and name=? and password=?");
			ps.setInt(1, accno);
			ps.setString(2, name);
			ps.setString(3, password);
			int i = ps.executeUpdate();
            if (i > 0) {
                out.print("Account deactivated  successfully.");
            } else {
                out.print("account deactivation failed.");
            }
			
			
		}
		catch(Exception ex) {
			out.print(ex);
		}
	}

}
