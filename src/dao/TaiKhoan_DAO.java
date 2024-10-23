package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	public TaiKhoan getTaiKhoanBangTenDangNhap(String tendangnhap) {
		TaiKhoan taiKhoan = null;
		
		Connection con = ConnectDB.getConnection();
		String query = "select * from TaiKhoan where tenDangNhap = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, tendangnhap);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String loaiTaiKhoan = rs.getString("loaiTaiKhoan");
				NhanVien nhanVien = nhanVien_dao.getNhanVienTheoMa(rs.getInt("maNV"));
				
				taiKhoan = new TaiKhoan(tenDangNhap, matKhau, loaiTaiKhoan, nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taiKhoan;
		
	}
	public TaiKhoan dangNhap(String tendangnhap, String matkhau) {
		Connection con = ConnectDB.getConnection();
		String query = "select * from TaiKhoan where tenDangNhap = ? and matKhau = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, tendangnhap);
			pstm.setString(2, matkhau);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String loaiTaiKhoan = rs.getString("loaiTaiKhoan");
				NhanVien nhanVien = nhanVien_dao.getNhanVienTheoMa(rs.getInt("maNV"));
				
				return new TaiKhoan(tenDangNhap, matKhau, loaiTaiKhoan, nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	public int getMaNhanVienByTaiKhoan( String tendangnhap, String matkhau) {
		Connection con = ConnectDB.getConnection();
		String query = "select * from TaiKhoan where tenDangNhap = ? and matKhau = ?";
		int maNV = 0;
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, tendangnhap);
			pstm.setString(2, matkhau);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String loaiTaiKhoan = rs.getString("loaiTaiKhoan");
				maNV = rs.getInt("maNV");
				
				
				return maNV;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maNV;	
	}
		
}
