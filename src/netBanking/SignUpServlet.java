package netBanking;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SignUpServlet extends HttpServlet {

	public ServletContext sct;
	public RegBean rb;
	public void  init() throws ServletException
	{
		sct=this.getServletContext();
		rb=new RegBean();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		AccnoGenerator acc=new AccnoGenerator();
		long acno=acc.generateID();
		res.setContentType("text/html");
		rb.setUname(req.getParameter("uname"));
		rb.setPword(req.getParameter("pword"));
		rb.setFname(req.getParameter("fname"));
		rb.setLname(req.getParameter("lname"));
		rb.setAddrs(req.getParameter("addrs"));
		rb.setGender(req.getParameter("Gen"));
		rb.setMobile(Long.parseLong(req.getParameter("mobile")));
		rb.setAccno(acno);
		rb.setIfsc(4555L);
		sct.setAttribute("regbean", rb);
		PrintWriter pw=res.getWriter();
		pw.println("To view Details <a href='View'>Click Here!</a>");
		
	}
}
