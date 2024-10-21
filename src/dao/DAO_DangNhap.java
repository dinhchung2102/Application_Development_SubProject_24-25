package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectDB.ConnectDB;
import entity.NhanVien;


public class DAO_DangNhap {
	public boolean validate(String username, String password) {
        boolean status = false;
        String query = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";

        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
	public NhanVien getStaff(String username, String password) {
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        String query = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";

        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
				NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
				String tenDangNhap = resultSet.getString("tenDangNhap");
				String matKhau = resultSet.getString("matKhau");
				String loaiTaiKhoan = resultSet.getString("loaiTaiKhoan");
				NhanVien nhanVien = nhanVien_DAO.getNhanVienTheoMa(resultSet.getInt("maNV"));
				
				return nhanVien;
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
