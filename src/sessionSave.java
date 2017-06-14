

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionSave
 */
@WebServlet("/SaveSession")
public class sessionSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionSave = request.getSession();
		String FullName = request.getParameter("FullName");
		String Email = request.getParameter("Email");
		String University = request.getParameter("University");
		String Major = request.getParameter("Major");
		String Year = request.getParameter("Year");
		ArrayList<String> EducAL = new ArrayList<String>();
		EducAL.add(University);
		EducAL.add(Major);
		EducAL.add(Year);
		sessionSave.setAttribute("FullSession", FullName);
		sessionSave.setAttribute("EmailSession", Email);
		sessionSave.setAttribute("EducALSession", EducAL);
		System.out.println("Test sample");
		PrintWriter out = response.getWriter();
		out.println("Test Text");
		getServletContext().getRequestDispatcher("/Index.jsp").forward(request,response);
	
	}

}
