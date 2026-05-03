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
import model.KhachHang;
import util.DBConnection;

public class KhachHangDAO {

   
    public List<KhachHang> getAll() {
    List<KhachHang> list = new ArrayList<>();
    String sql = "SELECT * FROM Khach_Hang";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("MaKH"));
            kh.setHoTen(rs.getString("HoTen"));
            kh.setDiaChi(rs.getString("DiaChi"));
            kh.setSdt(rs.getString("SDT"));
            
            list.add(kh);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public boolean insert(KhachHang kh) {
    String sql = "INSERT INTO Khach_Hang (MaKH, HoTen, SDT, DiaChi) VALUES (?, ?, ?, ?)";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setString(1, kh.getMaKH());
        ps.setString(2, kh.getHoTen());
        ps.setString(3, kh.getSdt());
        ps.setString(4, kh.getDiaChi());
        
        
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean delete(String maKH) {
    String sql = "DELETE FROM Khach_Hang WHERE MaKH = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
       
        ps.setString(1, maKH);
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean update(KhachHang kh) {
    String sql = "UPDATE Khach_Hang SET HoTen = ?, SDT = ?, DiaChi = ? WHERE MaKH = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, kh.getHoTen());
        ps.setString(2, kh.getSdt());
        ps.setString(3, kh.getDiaChi());
        ps.setString(4, kh.getMaKH()); 
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    
    public List<model.KhachHang> search(String keyword) {
    List<model.KhachHang> list = new ArrayList<>();
   
    String sql = "SELECT * FROM Khach_Hang WHERE MaKH LIKE ? OR HoTen LIKE ? OR SDT LIKE ? OR DiaChi LIKE ? ";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        String query = "%" + keyword + "%";
        ps.setString(1, query);
        ps.setString(2, query);
        ps.setString(3, query);
        ps.setString(4, query);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.KhachHang kh = new model.KhachHang();
            kh.setMaKH(rs.getString("MaKH"));
            kh.setHoTen(rs.getString("HoTen"));
            kh.setSdt(rs.getString("SDT"));
            kh.setDiaChi(rs.getString("DiaChi"));
            
            list.add(kh);
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return list;
}
    
}
