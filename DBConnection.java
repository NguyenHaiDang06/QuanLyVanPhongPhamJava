package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 1. Địa chỉ CSDL (URL)
            // localhost:1433 là địa chỉ máy bạn
            // databaseName=QuanLyVanPhongPham là tên CSDL bạn đã tạo trong SQL
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyVanPhongPham;encrypt=true;trustServerCertificate=true;";
            
            // 2. Tài khoản và mật khẩu bạn vừa đặt ở Bước 2 & 3
            String user = "sa"; 
            String password = "123"; 
            
            // 3. Thực hiện kết nối
            conn = DriverManager.getConnection(url, user, password);
            
            if (conn != null) {
                System.out.println("Kết nối CSDL thành công!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi rồi: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}