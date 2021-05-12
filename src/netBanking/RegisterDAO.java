package netBanking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class RegisterDAO {

	Date d=new Date();
	String dt=d.toString();
	public int k;
	public int Register(RegBean rb)
	{
		try {
			
		Connection con=DBConnection.getCon();
		
		PreparedStatement ps=con.prepareStatement("insert into netbankingdetails values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, rb.getUname());
		ps.setString(2, rb.getPword());
		ps.setString(3, rb.getFname());
		ps.setString(4, rb.getLname());
		ps.setString(5, rb.getGender());
		ps.setString(6, rb.getAddrs());
		ps.setLong(7, rb.getMobile());
		ps.setString(8, dt);
		ps.setLong(9, rb.getAccno());
		ps.setLong(10, rb.getIfsc());
		k=ps.executeUpdate();
		PreparedStatement ps1=con.prepareStatement("create table "+rb.getUname()+"(AccountNo number(15,0),TransactionID Number(15,0),BalanceDr number(22,2),BalanceCr number(22,2),AvailableBalance number(22,2),TransactionDate varchar2(30))");
		ps1.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return k;
	}
}
