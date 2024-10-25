package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietPhieuDatBan;
import entity.MonAn;
import entity.NhanVien;
import entity.PhieuDatBan;

public class ChiTietPhieuDatBan_DAO {
	MonAnDAO monAn_DAO = new MonAnDAO();
	PhieuDatBan_DAO phieuDatBan_DAO = new PhieuDatBan_DAO();
	
	public ArrayList<ChiTietPhieuDatBan> getAllChiTietPhieuDatBan() {
		ArrayList<ChiTietPhieuDatBan> dsChiTietPhieuDatBan = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String query = "select * from ChiTietPhieuDatBan";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				int maChiTietPhieuDatBan = rs.getInt("maChiTietPhieuDatBan");
				int soLuong = rs.getInt("soLuong");
				float thanhTien = rs.getFloat("thanhTien");
				MonAn monAn = monAn_DAO.getMonAnTheoMa(rs.getInt("maMon"));
				PhieuDatBan phieuDatBan = phieuDatBan_DAO.getPhieuDatBanTheoMa(rs.getInt("maPhieuDatBan"));
				
				ChiTietPhieuDatBan chiTietPhieuDatBan = new ChiTietPhieuDatBan(maChiTietPhieuDatBan, soLuong, thanhTien, monAn, phieuDatBan);
				dsChiTietPhieuDatBan.add(chiTietPhieuDatBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsChiTietPhieuDatBan;
	}

	public ArrayList<ChiTietPhieuDatBan> getAllChiTietPhieuDatBanBangMaPhieuDatBan(int maPhieuDatBanInput) {
		ArrayList<ChiTietPhieuDatBan> dsChiTietPhieuDatBan = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String query = "select * from ChiTietPhieuDatBan where maPhieuDatBan = ?";

		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, maPhieuDatBanInput);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int maChiTietPhieuDatBan = rs.getInt("maChiTietPhieuDatBan");
				int soLuong = rs.getInt("soLuong");
				float thanhTien = rs.getFloat("thanhTien");
				MonAn monAn = monAn_DAO.getMonAnTheoMa(rs.getInt("maMon"));
				PhieuDatBan phieuDatBan = phieuDatBan_DAO.getPhieuDatBanTheoMa(rs.getInt("maPhieuDatBan"));
				
				ChiTietPhieuDatBan chiTietPhieuDatBan = new ChiTietPhieuDatBan(maChiTietPhieuDatBan, soLuong, thanhTien, monAn, phieuDatBan);
				dsChiTietPhieuDatBan.add(chiTietPhieuDatBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsChiTietPhieuDatBan;
	}
	public boolean themChiTietPhieuDatBan(ChiTietPhieuDatBan chiTietPhieuDatBan) {
		Connection con = ConnectDB.getConnection();
		String query = "insert into ChiTietPhieuDatBan values(?,?,?,?)";
		int n = 0;
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, chiTietPhieuDatBan.getSoLuong());
			pstm.setFloat(2, chiTietPhieuDatBan.getThanhTien());
			pstm.setInt(3, chiTietPhieuDatBan.getMonAn().getMaMon());
			pstm.setInt(4, chiTietPhieuDatBan.getPhieuDatBan().getMaPhieuDatBan());
			n = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}