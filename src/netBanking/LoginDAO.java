package netBanking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;

public class LoginDAO{

	
	public int k;
	public int login(RegBean rb,ServletContext sct)
	{
		
		try {
			
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from netbankingdetails where username=? and password=?");
			ps.setString(1, rb.getUname());
			ps.setString(2, rb.getPword());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				sct.setAttribute("fname", rs.getString(3));
				sct.setAttribute("accno", rs.getLong(9));
				rb.setUname(rs.getString(1));
				rb.setPword(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setGender(rs.getString(5));
				rb.setAddrs(rs.getString(6));
				rb.setMobile(rs.getLong(7));
				rb.setAccno(rs.getLong(9));
				rb.setIfsc(rs.getInt(10));
				sct.setAttribute("regBean", rb);
				k=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
}
