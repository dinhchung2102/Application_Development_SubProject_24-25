package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLDatBan88_v3;encrypt=false";
    private static final String USER = "sa"; // Thay bằng tên người dùng của bạn
    private static final String PASSWORD = "sapassword"; // Thay bằng mật khẩu của bạn

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
        
    }
}
