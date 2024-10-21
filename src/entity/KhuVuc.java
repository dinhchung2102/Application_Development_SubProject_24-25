package entity;

public class KhuVuc {
	private int maKhuVuc;
	private String tenKhuVuc;
	private int soBan;
	private String moTa;
	public KhuVuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhuVuc(int maKhuVuc, String tenKhuVuc, int soBan, String moTa) {
		super();
		this.maKhuVuc = maKhuVuc;
		this.tenKhuVuc = tenKhuVuc;
		this.soBan = soBan;
		this.moTa = moTa;
	}
	public int getMaKhuVuc() {
		return maKhuVuc;
	}
	public void setMaKhuVuc(int maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
	}
	public String getTenKhuVuc() {
		return tenKhuVuc;
	}
	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}
	public int getSoBan() {
		return soBan;
	}
	public void setSoBan(int soBan) {
		this.soBan = soBan;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}
