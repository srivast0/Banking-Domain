package netBanking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class getLogin extends HttpServlet {
	
	public ServletContext sct;
	public RegBean rb;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=new RegBean();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		rb.setUname(req.getParameter("uname"));
		rb.setPword(req.getParameter("pword"));
		if(new LoginDAO().login(rb, sct)>0)
		{
			String fname=(String)sct.getAttribute("fname");
			long acno=(Long)sct.getAttribute("accno");
			Cookie ck=new Cookie("fname", fname);
			res.addCookie(ck);
			sct.removeAttribute("accno");
			pw.println("Welcome: "+fname);
			pw.println("<br><br>Account No: "+acno);
			RequestDispatcher rd=req.getRequestDispatcher("Userhome.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("Invalid Credentials");
			pw.println("<a href='Login.html'>Go Back</a>");
		}
	}
	
}
