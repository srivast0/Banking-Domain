package netBanking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ViewTransaction extends HttpServlet {
	public ServletContext sct;
	RegBean rb;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("regBean");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		try {
			PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<br><a href='Userhome.html'>Go Back</a>");
		pw.println("<br>Welcome: "+rb.getFname());
		TransactionDAO td=new TransactionDAO();
		ArrayList<TransactionBean> al=td.retreive(rb);
		if(al.size()==0)
		{
			pw.println("No Transactions Yet.");
		}
		else
		{
			pw.println("<br><table border='1' align='center'>"
					+ "<tr><th>Account No</th><th>Transaction ID</th><th>Balance Dr</th><th>Balance Cr</th><th>Available Balance</th><th>Transaction Date</th></tr>");
			al.forEach((k)->
			{
				TransactionBean tb=(TransactionBean)k;
				pw.println("<tr><td>"+tb.getAcno()+"</td>");
				pw.println("<td>"+tb.getTxnid()+"</td>");
				pw.println("<td>"+tb.getBaldr()+"</td>");
				pw.println("<td>"+tb.getBalcr()+"</td>");
				pw.println("<td>"+tb.getAvlbal()+"</td>");
				pw.println("<td>"+tb.getTxndt()+"</td></tr>");
			});
			
		}
		pw.println("</table>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
