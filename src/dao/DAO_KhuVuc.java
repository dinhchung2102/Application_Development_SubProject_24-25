package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connectDB.ConnectDB;
import entity.KhuVuc;

public class DAO_KhuVuc {
	public List<KhuVuc> getKhuVuc() {
		List<KhuVuc> listKhuVuc = new ArrayList<>();
		String sql = "SELECT maKhuVuc, tenKhuVuc, soBan, moTa FROM KhuVuc";

		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				int maKhuVuc = resultSet.getInt("maKhuVuc");
				String tenKhuVuc = resultSet.getString("tenKhuVuc");
				int soBan = resultSet.getInt("soBan");
				String moTa = resultSet.getString("moTa");

				KhuVuc kVuc = new KhuVuc(maKhuVuc, tenKhuVuc, soBan, moTa);
				listKhuVuc.add(kVuc);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listKhuVuc;
	}

	public KhuVuc getKhuVucById(int maKV) {
		KhuVuc khuVuc = new KhuVuc();
		khuVuc = null;

		String sql = "SELECT * FROM KhuVuc where maKhuVuc = ?";

		new ConnectDB();
		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, maKV);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					int maKhuVuc = resultSet.getInt("maKhuVuc");
					String tenKhuVuc = resultSet.getString("tenKhuVuc");
					int soBan = resultSet.getInt("soBan");
					String moTa = resultSet.getString("moTa");
					khuVuc = new KhuVuc(maKhuVuc, tenKhuVuc, soBan, moTa);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return khuVuc;
	}
}
