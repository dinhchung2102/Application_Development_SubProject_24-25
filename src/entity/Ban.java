package entity;

public class Ban {
	private int maBan;
	private String loaiBan;
	private int soGheNgoi;
	private String moTa;
	private boolean trangThai;
	public Ban() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ban(int maBan, String loaiBan, int soGheNgoi, String moTa, boolean trangThai) {
		super();
		this.maBan = maBan;
		this.loaiBan = loaiBan;
		this.soGheNgoi = soGheNgoi;
		this.moTa = moTa;
		this.trangThai = trangThai;
	}
	public int getMaBan() {
		return maBan;
	}
	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}
	public String getLoaiBan() {
		return loaiBan;
	}
	public void setLoaiBan(String loaiBan) {
		this.loaiBan = loaiBan;
	}
	public int getSoGheNgoi() {
		return soGheNgoi;
	}
	public void setSoGheNgoi(int soGheNgoi) {
		this.soGheNgoi = soGheNgoi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
	
}
