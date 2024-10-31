package dao;

import connectDB.ConnectDB;
import entity.Ban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO_Ban {
    public List<Ban> getBansByKhuVuc(String khuVuc) {
        List<Ban> bans = new ArrayList<Ban>();
        
        String sql = "SELECT b.maBan, b.loaiBan, b.soGheNgoi, b.moTa, b.trangThai, b.maKhuVuc " +
                "FROM Ban b " +
                "INNER JOIN KhuVuc k ON b.maKhuVuc = k.maKhuVuc " +
                "WHERE k.tenKhuVuc = ?";

        new ConnectDB();
		try (Connection connection = ConnectDB.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, khuVuc); 
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	while (resultSet.next()) {
            	    int maBan = resultSet.getInt("maBan");
            	    String loaiBan = resultSet.getString("loaiBan");
            	    int soGheNgoi = resultSet.getInt("soGheNgoi"); 
            	    String moTa = resultSet.getString("moTa"); 
            	    boolean trangThai = resultSet.getBoolean("trangThai"); 
            	    int maKhuVuc = resultSet.getInt("maKhuVuc");

            	    Ban ban = new Ban(maBan, loaiBan, soGheNgoi, moTa, trangThai, new DAO_KhuVuc().getKhuVucById(maKhuVuc));
            	    bans.add(ban);
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bans;
    }
    public int getSoGheByMaBan(Integer maBan) {
    	String sql= "SELECT soGheNgoi from Ban WHERE maBan = ?";
    	int soGheNgoi = -1;
    	
    	new ConnectDB();
		try (Connection connection = ConnectDB.getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    		preparedStatement.setInt(1, maBan);
    		try (ResultSet resultSet = preparedStatement.executeQuery()) {
    			while (resultSet.next()) {
    				soGheNgoi = resultSet.getInt("soGheNgoi");
				}
    			
			} 
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return soGheNgoi;
	}
    public boolean capNhatTrangThaiBanById(int maBan, boolean trangThai) {
        String sql = "UPDATE Ban SET trangThai = ? WHERE maBan = ?";
        boolean isUpdated = false;

        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setBoolean(1, trangThai);
            preparedStatement.setInt(2, maBan);
            
            int rowsAffected = preparedStatement.executeUpdate();
            isUpdated = (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdated; 
    }
    public Ban getBanById(int maBan) {
        Ban ban = null; 
        String sql = "SELECT * FROM Ban WHERE maBan = ?";

        try (Connection connection = ConnectDB.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setInt(1, maBan);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { 
                    String loaiBan = resultSet.getString("loaiBan");
                    int soGheNgoi = resultSet.getInt("soGheNgoi"); 
                    String moTa = resultSet.getString("moTa"); 
                    boolean trangThai = resultSet.getBoolean("trangThai"); 
                    int maKhuVuc = resultSet.getInt("maKhuVuc");

                    ban = new Ban(maBan, loaiBan, soGheNgoi, moTa, trangThai, new DAO_KhuVuc().getKhuVucById(maKhuVuc)); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban;
    }
    
}
