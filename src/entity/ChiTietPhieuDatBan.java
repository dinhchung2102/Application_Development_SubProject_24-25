package entity;

public class ChiTietPhieuDatBan {
	private int maChiTietPhieuDatBan;
	private int soLuong;
	private float thanhTien;
	private MonAn monAn;
	private PhieuDatBan phieuDatBan;

	public int getMaChiTietPhieuDatBan() {
		return maChiTietPhieuDatBan;
	}

	public void setMaChiTietPhieuDatBan(int maChiTietPhieuDatBan) {
		this.maChiTietPhieuDatBan = maChiTietPhieuDatBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}

	public PhieuDatBan getPhieuDatBan() {
		return phieuDatBan;
	}

	public void setPhieuDatBan(PhieuDatBan phieuDatBan) {
		this.phieuDatBan = phieuDatBan;
	}

	public ChiTietPhieuDatBan(int maChiTietPhieuDatBan, int soLuong, float thanhTien, MonAn monAn,
			PhieuDatBan phieuDatBan) {
		super();
		this.maChiTietPhieuDatBan = maChiTietPhieuDatBan;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.monAn = monAn;
		this.phieuDatBan = phieuDatBan;
	}

	public ChiTietPhieuDatBan(int soLuong, float thanhTien, MonAn monAn, PhieuDatBan phieuDatBan) {
		super();
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.monAn = monAn;
		this.phieuDatBan = phieuDatBan;
	}

	public ChiTietPhieuDatBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float tinhThanhTien() {
		this.thanhTien = this.monAn.getGiaTien() * this.soLuong;
		return thanhTien;
	}
}
