package netBanking;

public class TransactionBean {
	private long acno;
	private long txnid;
	private double baldr;
	private double balcr;
	private double avlbal;
	private String txndt;
	public TransactionBean() {
		super();
	}
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public long getTxnid() {
		return txnid;
	}
	public void setTxnid(long txnid) {
		this.txnid = txnid;
	}
	public double getBaldr() {
		return baldr;
	}
	public void setBaldr(double baldr) {
		this.baldr = baldr;
	}
	public double getBalcr() {
		return balcr;
	}
	public void setBalcr(double balcr) {
		this.balcr = balcr;
	}
	public double getAvlbal() {
		return avlbal;
	}
	public void setAvlbal(double avlbal) {
		this.avlbal = avlbal;
	}
	public String getTxndt() {
		return txndt;
	}
	public void setTxndt(String txndt) {
		this.txndt = txndt;
	}
	

}
