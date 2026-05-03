/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import model.ChiTietHoaDon;
import model.HoaDon;

/**
 *
 * @author duc
 */
public class ChiTietHoaDonDAO {
    public List<ChiTietHoaDon> getDetail(String maHD) {
    List<ChiTietHoaDon> list = new ArrayList<>();
    
    String sql = "SELECT * FROM Chi_Tiet_Hoa_Don WHERE MaHD = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, maHD);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(rs.getString("MaHD"));
                ct.setMaSP(rs.getString("MaSP"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGiaBan(rs.getDouble("DonGiaBan"));
                list.add(ct);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    
    
}
