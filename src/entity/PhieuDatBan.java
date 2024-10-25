package entity;

import java.util.Date;
import java.time.LocalDateTime;

public class PhieuDatBan {
	private int maPhieuDatBan;
	private Date ngayTaoPhieu;
	private LocalDateTime thoiGianDatBan;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Ban ban;
	public int getMaPhieuDatBan() {
		return maPhieuDatBan;
	}
	public void setMaPhieuDatBan(int maPhieuDatBan) {
		this.maPhieuDatBan = maPhieuDatBan;
	}
	public Date getNgayTaoPhieu() {
		return ngayTaoPhieu;
	}
	public void setNgayTaoPhieu(Date ngayTaoPhieu) {
		this.ngayTaoPhieu = ngayTaoPhieu;
	}
	public LocalDateTime getThoiGianDatBan() {
		return thoiGianDatBan;
	}
	public void setThoiGianDatBan(LocalDateTime thoiGianDatBan) {
		this.thoiGianDatBan = thoiGianDatBan;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Ban getBan() {
		return ban;
	}
	public void setBan(Ban ban) {
		this.ban = ban;
	}
	public PhieuDatBan(int maPhieuDatBan, Date ngayTaoPhieu, LocalDateTime thoiGianDatBan, KhachHang khachHang,
			NhanVien nhanVien, Ban ban) {
		super();
		this.maPhieuDatBan = maPhieuDatBan;
		this.ngayTaoPhieu = ngayTaoPhieu;
		this.thoiGianDatBan = thoiGianDatBan;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ban = ban;
	}
	public PhieuDatBan(Date ngayTaoPhieu, LocalDateTime thoiGianDatBan, KhachHang khachHang, NhanVien nhanVien,
			Ban ban) {
		super();
		this.ngayTaoPhieu = ngayTaoPhieu;
		this.thoiGianDatBan = thoiGianDatBan;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ban = ban;
	}
	public PhieuDatBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
