package netBanking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TransactionDAO {
	public ArrayList<TransactionBean> al=new ArrayList<TransactionBean>();
	public ArrayList<TransactionBean> retreive(RegBean rb)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from "+rb.getUname());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				TransactionBean tb=new TransactionBean();
				tb.setAcno(rs.getLong(1));
				tb.setTxnid(rs.getLong(2));
				tb.setBaldr(rs.getDouble(3));
				tb.setBalcr(rs.getDouble(4));
				tb.setAvlbal(rs.getDouble(5));
				tb.setTxndt(rs.getString(6));
				al.add(tb);
			}
		} catch (Exception e) {
		}
		return al;
	}
}
