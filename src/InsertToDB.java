

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

import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 * Servlet implementation class InsertToDB
 */
@WebServlet("/InsertToDB")
public class InsertToDB extends HttpServlet {
	PreparedStatement preparedStmt = null;
	PreparedStatement full = null;

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EducationServlet","root","password");

			String FullName = request.getParameter("FullName");
			String Email = request.getParameter("Email");
			String University = request.getParameter("University");
			String Major = request.getParameter("Major");
			String Year = request.getParameter("Year");

			
			String query = ("INSERT into `EducationServlet`.`EducFull`"
					+ "(`FullName`, `Email`,`University`, `Major`, `Year`) "
					+ "VALUES (?,?,?,?,?)");
			String queryMain = ("INSERT into `EducationServlet`.`EducMain`"
					+ "(`University`, `Major`, `Year`) "
					+ "VALUES (?,?,?)");
			
			full= con.prepareStatement(query);
			preparedStmt = con.prepareStatement(queryMain);

			full.setString(1, FullName);
			full.setString(2, Email);
			full.setString(3, University);
			full.setString(4, Major);
			full.setString(5, Year);
			
			
			preparedStmt.setString(1, University);
			preparedStmt.setString(2, Major);
			preparedStmt.setString(3, Year);
		
		
			preparedStmt.executeUpdate();
			full.executeUpdate();

			PrintWriter out = response.getWriter();
			out.println("The Data has Saved");
		}catch (Exception e) {
			// TODO: handle exception
		}
	} 
}	