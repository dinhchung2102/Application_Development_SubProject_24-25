package dao;

import connectDB.ConnectDB;
import entity.MonAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonAnDAO {
    private Connection connection;

    public MonAnDAO() {
        connection = ConnectDB.getConnection();
    }

    public List<MonAn> getAllMonAn() {
        List<MonAn> monAnList = new ArrayList<>();
        String query = "SELECT * FROM MonAn";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int maMon = rs.getInt("maMon");
                String tenMon = rs.getString("tenMon");
                float giaTien = rs.getFloat("giaTien");
                String moTa = rs.getString("moTa");

                MonAn monAn = new MonAn(maMon, tenMon, giaTien, moTa);
                monAnList.add(monAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return monAnList;
    }
    

    public void addMonAn(MonAn monAn) {
        String query = "INSERT INTO MonAn (tenMon, giaTien, moTa) VALUES (?, ?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, monAn.getTenMon());
            pstmt.setFloat(2, monAn.getGiaTien());
            //pstmt.setInt(3, monAn.getSoLuong());
            pstmt.setString(3, monAn.getMoTa());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMonAn(int maMon) {
        String query = "DELETE FROM MonAn WHERE maMon = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, maMon);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMonAn(MonAn monAn) {
        String query = "UPDATE MonAn SET tenMon = ?, giaTien = ?, moTa = ? WHERE maMon = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, monAn.getTenMon());
            pstmt.setFloat(2, monAn.getGiaTien());
            //pstmt.setInt(3, monAn.getSoLuong());
            pstmt.setString(3, monAn.getMoTa());
            pstmt.setInt(4, monAn.getMaMon());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public MonAn getMonAnTheoMa(int maMonAn) {
		MonAn monAn = null;

		Connection con = ConnectDB.getConnection();
		String query = "select * from MonAn where maMon = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, maMonAn);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int maMon = rs.getInt("maMon");
				String tenMon = rs.getString("tenMon");
				float giaTien = rs.getFloat("giaTien");
				String moTa = rs.getString("moTa");

				monAn = new MonAn(maMon, tenMon, giaTien, moTa);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monAn;

	}


}
