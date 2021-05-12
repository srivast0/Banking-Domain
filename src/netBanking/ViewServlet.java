package netBanking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ViewServlet extends HttpServlet {
	
	ServletContext sct;
	RegBean rb;
	public void init()throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("regbean");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<br>Username: "+rb.getUname());
		pw.println("<br>Password: "+rb.getPword());
		pw.println("<br>FirstName: "+rb.getFname());
		pw.println("<br>LastName: "+rb.getLname());
		pw.println("<br>Address: "+rb.getAddrs());
		pw.println("<br>Gender: "+rb.getGender());
		pw.println("<br>Mobile: "+rb.getMobile());
		pw.println("<br>Account No: "+rb.getAccno());
		pw.println("<br>IFSC Code: "+rb.getIfsc());
		pw.println("<form action='Register' method='post'><br><input type='submit' value='Confirm'></form>");
	}
}
