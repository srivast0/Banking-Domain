package netBanking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddBalanceMain extends HttpServlet {

	public ServletContext sct;
	public RegBean rb;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("regBean");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try {
			double avlbal=0.0;
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			Date dt=new Date();
			TransactionIDGenerator tg=new TransactionIDGenerator();
			long txno=tg.generateID();
		Connection con=DBConnection.getCon();
		PreparedStatement ps1=con.prepareStatement("select AVAILABLEBALANCE from "+rb.getUname()+" where ACCOUNTNO=?");
		ps1.setLong(1, rb.getAccno());
		ResultSet rs=ps1.executeQuery();
		if(rs.next())
		{
			avlbal=rs.getLong(1);
		}
		PreparedStatement ps=con.prepareStatement("insert into "+rb.getUname()+" values(?,?,?,?,?,?)");
		double amt=Double.parseDouble(req.getParameter("amt"));
		ps.setLong(1,rb.getAccno());
		ps.setLong(2, txno);
		ps.setDouble(3, 0);
		ps.setDouble(4, amt);
		avlbal+=amt;
		ps.setDouble(5, avlbal );
		ps.setString(6, dt.toString());
		int k=ps.executeUpdate();
		if(k>0)
		{
			pw.println("Balance Added Successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Userhome.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("Some Error Occured");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
