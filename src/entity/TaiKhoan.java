package entity;

public class TaiKhoan {
	private String tenDangNhap;
	private String matKhau;
	private String loaiTaiKhoan;
	private NhanVien nhanVien;
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public TaiKhoan(String tenDangNhap, String matKhau, String loaiTaiKhoan, NhanVien nhanVien) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.nhanVien = nhanVien;
	}
	public TaiKhoan() {
	}
	
}
