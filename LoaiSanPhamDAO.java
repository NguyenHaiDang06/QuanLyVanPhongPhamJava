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
import model.LoaiSanPham;
import util.DBConnection;

public class LoaiSanPhamDAO {

   
    
    public List<LoaiSanPham> getAll() {
    List<LoaiSanPham> list = new ArrayList<>();
    String sql = "SELECT * FROM Loai_San_Pham";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            LoaiSanPham lsp = new LoaiSanPham();
            lsp.setMaLoai(rs.getString("MaLoai"));
            lsp.setTenLoai(rs.getString("TenLoai"));
            
            
            list.add(lsp);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public boolean insert(LoaiSanPham lsp) {
    String sql = "INSERT INTO Loai_San_Pham (MaLoai, TenLoai) VALUES (?, ?)";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setString(1, lsp.getMaLoai());
        ps.setString(2, lsp.getTenLoai());
        
        
        
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean delete(String maLSP) {
    String sql = "DELETE FROM Loai_San_Pham WHERE MaLoai = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setString(1, maLSP);
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean update(LoaiSanPham lsp) {
    String sql = "UPDATE Loai_San_Pham SET TenLoai = ? WHERE MaLoai = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, lsp.getTenLoai());
        ps.setString(2, lsp.getMaLoai()); 
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    
    public List<model.LoaiSanPham> search(String keyword) {
    List<model.LoaiSanPham> list = new ArrayList<>();
    
    String sql = "SELECT * FROM Loai_San_Pham WHERE MaLoai LIKE ? OR TenLoai LIKE ? ";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        String query = "%" + keyword + "%";
        ps.setString(1, query);
        ps.setString(2, query);
        
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.LoaiSanPham lsp = new model.LoaiSanPham();
            lsp.setMaLoai(rs.getString("MaLoai"));
            lsp.setTenLoai(rs.getString("TenLoai"));
            
            
            list.add(lsp);
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return list;
}
    
}
