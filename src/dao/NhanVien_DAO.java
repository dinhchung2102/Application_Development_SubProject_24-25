package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien(){
		ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String query = "select * from NhanVien";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				int maNV = rs.getInt("maNV");
				String tenNV = rs.getString("tenNV");
				String gioiTinh = rs.getString("gioiTinh");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDT = rs.getString("soDT");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");
				
				NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, soDT, email, diaChi);
				dsNhanVien.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	public NhanVien getNhanVienTheoMa(int maNhanVien) {
		NhanVien nv = null;
		
		Connection con = ConnectDB.getConnection();
		String query = "select * from NhanVien where maNV = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, maNhanVien);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int maNV = rs.getInt("maNV");
				String tenNV = rs.getString("tenNV");
				String gioiTinh = rs.getString("gioiTinh");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDT = rs.getString("soDT");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");
				
				nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, soDT, email, diaChi);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
		
	}
}
