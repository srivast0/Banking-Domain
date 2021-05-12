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
public class AddBalanceServlet extends HttpServlet{

	public ServletContext sct;
	public RegBean rb;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("regBean");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Account No:  "+rb.getAccno());
		pw.println("IFSC Code:  "+rb.getIfsc());
		RequestDispatcher rd=req.getRequestDispatcher("AddBalance.html");
		rd.include(req, res);
	}
}
