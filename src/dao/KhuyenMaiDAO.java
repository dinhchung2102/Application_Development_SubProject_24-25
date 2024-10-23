package dao;

import connectDB.ConnectDB;
import entity.KhuyenMai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiDAO {
    public List<KhuyenMai> getAllKhuyenMai() {
        List<KhuyenMai> khuyenMaiList = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        String query = "SELECT * FROM KhuyenMai";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(
                    rs.getInt("maKM"),
                    rs.getString("tenKM"),
                    rs.getDouble("donHangToiThieu"),
                    rs.getDouble("giamGia"),
                    rs.getString("moTa")
                );
                khuyenMaiList.add(km);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khuyenMaiList;
    }

    public void addKhuyenMai(KhuyenMai km) {
        Connection conn = ConnectDB.getConnection();
        String query = "INSERT INTO KhuyenMai (tenKM, donHangToiThieu, giamGia, moTa) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, km.getTenKM());
            pstmt.setDouble(2, km.getDonHangToiThieu());
            pstmt.setDouble(3, km.getGiamGia());
            pstmt.setString(4, km.getMoTa());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKhuyenMai(KhuyenMai km) {
        Connection conn = ConnectDB.getConnection();
        String query = "UPDATE KhuyenMai SET tenKM = ?, donHangToiThieu = ?, giamGia = ?, moTa = ? WHERE maKM = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, km.getTenKM());
            pstmt.setDouble(2, km.getDonHangToiThieu());
            pstmt.setDouble(3, km.getGiamGia());
            pstmt.setString(4, km.getMoTa());
            pstmt.setInt(5, km.getMaKM());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKhuyenMai(int maKM) {
        Connection conn = ConnectDB.getConnection();
        String query = "DELETE FROM KhuyenMai WHERE maKM = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maKM);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
