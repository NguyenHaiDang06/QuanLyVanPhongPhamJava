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
import model.ChiTietHoaDon;
import model.HoaDon;
import util.DBConnection;

/**
 *
 * @author duc
 */
public class HoaDonDAO {
    public boolean insert(HoaDon hd, List<ChiTietHoaDon> listCT) {
    
    java.sql.Connection conn = null;
    try {
        conn = util.DBConnection.getConnection();
        conn.setAutoCommit(false); 

        
        String sqlHD = "INSERT INTO Hoa_Don (MaHD, NgayLap, MaNV, MaKH) VALUES (?, ?, ?, ?)";
        try (java.sql.PreparedStatement psHD = conn.prepareStatement(sqlHD)) {
            psHD.setString(1, hd.getMaHD());
            psHD.setDate(2, new java.sql.Date(hd.getNgayLap().getTime()));
            psHD.setString(3, hd.getMaNV());
            psHD.setString(4, hd.getMaKH());
            psHD.executeUpdate();
        }

        
        String sqlCT = "INSERT INTO Chi_Tiet_Hoa_Don (MaHD, MaSP, SoLuong, DonGiaBan) VALUES (?, ?, ?, ?)";
        String sqlUpdateKho = "UPDATE San_Pham SET SoLuongTon = SoLuongTon - ? WHERE MaSP = ?";
        
        try (java.sql.PreparedStatement psCT = conn.prepareStatement(sqlCT);
             java.sql.PreparedStatement psUpdateKho = conn.prepareStatement(sqlUpdateKho)) {
            
            for (model.ChiTietHoaDon ct : listCT) {
                
                psCT.setString(1, ct.getMaHD());
                psCT.setString(2, ct.getMaSP());
                psCT.setInt(3, ct.getSoLuong());
                psCT.setDouble(4, ct.getDonGiaBan());
                psCT.executeUpdate();

                
                psUpdateKho.setInt(1, ct.getSoLuong()); 
                psUpdateKho.setString(2, ct.getMaSP()); 
                psUpdateKho.executeUpdate();
            }
        }

        conn.commit(); 
        return true;
        
    } catch (Exception e) {
        if (conn != null) {
            try { 
                conn.rollback(); 
            } catch (Exception ex) { 
                ex.printStackTrace(); 
            } 
        }
        e.printStackTrace();
        return false;
    } finally {
        if (conn != null) {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
    
    public List<HoaDon> getAll() {
    List<HoaDon> list = new ArrayList<>();
    
    String sql = "SELECT * FROM Hoa_Don ORDER BY NgayLap DESC"; 
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            HoaDon hd = new HoaDon();
            hd.setMaHD(rs.getString("MaHD"));
            hd.setNgayLap(rs.getDate("NgayLap"));
            hd.setMaNV(rs.getString("MaNV"));
            hd.setMaKH(rs.getString("MaKH"));
            
            list.add(hd);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public boolean delete(String maHD) {
    String sqlCT = "DELETE FROM Chi_Tiet_Hoa_Don WHERE MaHD = ?";
    String sqlHD = "DELETE FROM Hoa_Don WHERE MaHD = ?";
    
    Connection conn = null;
    try {
        conn = DBConnection.getConnection();
        conn.setAutoCommit(false); 

        
        PreparedStatement psCT = conn.prepareStatement(sqlCT);
        psCT.setString(1, maHD);
        psCT.executeUpdate();

        
        PreparedStatement psHD = conn.prepareStatement(sqlHD);
        psHD.setString(1, maHD);
        int result = psHD.executeUpdate();

        conn.commit(); 
        return result > 0; 
        
    } catch (SQLException e) {
        try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        e.printStackTrace();
        return false;
    } finally {
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}
    public List<HoaDon> search(String keyword) {
    List<HoaDon> list = new ArrayList<>();
    
    String sql = "SELECT * FROM Hoa_Don WHERE MaHD LIKE ? OR MaNV LIKE ? OR MaKH LIKE ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        String query = "%" + keyword + "%"; 
        ps.setString(1, query);
        ps.setString(2, query);
        ps.setString(3, query);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayLap(rs.getTimestamp("NgayLap"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaKH(rs.getString("MaKH"));
                
                list.add(hd);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public boolean update(HoaDon hd) {
    
    String sql = "UPDATE Hoa_Don SET NgayLap = ?, MaNV = ?, MaKH = ? WHERE MaHD = ?";
    
    try (java.sql.Connection conn = util.DBConnection.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setDate(1, new java.sql.Date(hd.getNgayLap().getTime()));
        ps.setString(2, hd.getMaNV());
        ps.setString(3, hd.getMaKH());
        ps.setString(4, hd.getMaHD());
        
        
        return ps.executeUpdate() > 0;
        
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
