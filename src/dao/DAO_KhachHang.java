package dao;

import connectDB.ConnectDB;
import entity.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_KhachHang {
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> khachHangList = new ArrayList<>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM KhachHang";

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getInt("maKH"), rs.getString("tenKH"), rs.getString("soDT"),
						rs.getString("email"), rs.getString("diaChi"));
				khachHangList.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return khachHangList;
	}

	public boolean addKhachHang(KhachHang kh) {
	    Connection conn = ConnectDB.getConnection();
	    
	    // Truy vấn để kiểm tra sự tồn tại của khách hàng
	    String checkQuery = "SELECT COUNT(*) FROM KhachHang WHERE soDT = ?";
	    
	    // Truy vấn để thêm khách hàng
	    String insertQuery = "INSERT INTO KhachHang (tenKH, soDT, email, diaChi) VALUES (?, ?, ?, ?)";

	    try {
	        // Kiểm tra sự tồn tại của khách hàng
	        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
	            checkStmt.setString(1, kh.getSoDT());
	            ResultSet rs = checkStmt.executeQuery();

	            if (rs.next() && rs.getInt(1) > 0) {
	                // Khách hàng đã tồn tại
	                return false; // Trả về false nếu khách hàng đã tồn tại
	            }
	        }

	        // Nếu chưa tồn tại, thêm mới khách hàng
	        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
	            pstmt.setString(1, kh.getTenKH());
	            pstmt.setString(2, kh.getSoDT());
	            pstmt.setString(3, kh.getEmail());
	            pstmt.setString(4, kh.getDiaChi());
	            pstmt.executeUpdate();
	            return true; // Trả về true nếu thêm thành công
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Trả về false nếu có lỗi xảy ra
	    }
	}


	public void updateKhachHang(KhachHang kh) {
		Connection conn = ConnectDB.getConnection();
		String query = "UPDATE KhachHang SET tenKH = ?, soDT = ?, email = ?, diaChi = ? WHERE maKH = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, kh.getTenKH());
			pstmt.setString(2, kh.getSoDT());
			pstmt.setString(3, kh.getEmail());
			pstmt.setString(4, kh.getDiaChi());
			pstmt.setInt(5, kh.getMaKH());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteKhachHang(int maKH) {
		Connection conn = ConnectDB.getConnection();
		String query = "DELETE FROM KhachHang WHERE maKH = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, maKH);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public KhachHang getKhachHangBySDT(String soDienThoai) {

		KhachHang khachHang = null;
		String sql = "SELECT * FROM KhachHang WHERE soDT = ?";
		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, soDienThoai);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					int maKH = resultSet.getInt("maKH");
					String tenKH = resultSet.getString("tenKH");
					String soDT = resultSet.getString("soDT");
					String email = resultSet.getString("email");
					String diaChi = resultSet.getString("diaChi");

					khachHang = new KhachHang(maKH, tenKH, soDT, email, diaChi);
				}
			}		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return khachHang;
	}
	public KhachHang getKhachHangTheoMa(int maKhachHang) {
		KhachHang khachHang = null;

		Connection con = ConnectDB.getConnection();
		String query = "select * from KhachHang where maKH = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, maKhachHang);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int maKH = rs.getInt("maKH");
				String tenKH = rs.getString("tenKH");
				String soDT = rs.getString("soDT");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");

				khachHang = new KhachHang(maKH, tenKH, soDT, email, diaChi);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHang;

	}
	
}
