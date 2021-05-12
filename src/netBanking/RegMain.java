package netBanking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegMain extends HttpServlet {
	public ServletContext sct;
	public RegBean rb;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("regbean");
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		if(new RegisterDAO().Register(rb)>0)
		{
			sct.removeAttribute("regbean");
			pw.println("Registration Successful");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("Some Error Occured.");
		}
	}
}
