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
public class LogoutServlet extends HttpServlet {
	public ServletContext sct;
	public RegBean rb;
	public TransactionBean tb;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		c[0].setValue(" ");
		c[0].setMaxAge(0);
		sct.removeAttribute("regBean");
		sct.removeAttribute("regbean");
		pw.println("Logout Successful");
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.include(req, res);
		
	}
}
