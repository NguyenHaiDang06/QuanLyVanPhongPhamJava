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
import model.SanPham;
import util.DBConnection;

public class SanPhamDAO {

    
    
    public List<SanPham> getAll() {
    List<SanPham> list = new ArrayList<>();
    String sql = "SELECT * FROM San_Pham";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            SanPham sp = new SanPham();
            sp.setMaSP(rs.getString("MaSP"));
            sp.setTenSP(rs.getString("TenSP"));
            sp.setDonViTinh(rs.getString("DonViTinh"));
            sp.setDonGia(rs.getDouble("DonGia"));
            sp.setSoLuongTon(rs.getInt("SoLuongTon"));
            sp.setMaLoai(rs.getString("MaLoai"));
            sp.setMaNCC(rs.getString("MaNCC"));
            
            list.add(sp);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public boolean insert(SanPham sp) {
    String sql = "INSERT INTO San_Pham (MaSP, TenSP, DonViTinh, DonGia, SoLuongTon, MaLoai, MaNCC) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setString(1, sp.getMaSP());
        ps.setString(2, sp.getTenSP());
        ps.setString(3, sp.getDonViTinh());
        ps.setDouble(4, sp.getDonGia());
        ps.setInt(5, sp.getSoLuongTon());
        ps.setString(6, sp.getMaLoai());
        ps.setString(7, sp.getMaNCC());
        
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean delete(String maSP) {
    String sql = "DELETE FROM San_Pham WHERE MaSP = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setString(1, maSP);
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean update(SanPham sp) {
    String sql = "UPDATE San_Pham SET TenSP = ?, DonViTinh = ?, DonGia = ?, SoLuongTon = ?, MaLoai = ?, MaNCC = ? WHERE MaSP = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, sp.getTenSP());
        ps.setString(2, sp.getDonViTinh());
        ps.setDouble(3, sp.getDonGia());
        ps.setInt(4, sp.getSoLuongTon());
        ps.setString(5, sp.getMaLoai());
        ps.setString(6, sp.getMaNCC());
        ps.setString(7, sp.getMaSP()); 
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    
    public List<model.SanPham> search(String keyword) {
    List<model.SanPham> list = new ArrayList<>();
    
    String sql = "SELECT * FROM San_Pham WHERE MaSP LIKE ? OR TenSP LIKE ? OR MaNCC LIKE ? OR MaLoai LIKE ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        String query = "%" + keyword + "%";
        ps.setString(1, query);
        ps.setString(2, query);
         ps.setString(3, query);
         ps.setString(4, query);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.SanPham sp = new model.SanPham();
            sp.setMaSP(rs.getString("MaSP"));
            sp.setTenSP(rs.getString("TenSP"));
            sp.setDonViTinh(rs.getString("DonViTinh"));
            sp.setDonGia(rs.getDouble("DonGia"));
            sp.setSoLuongTon(rs.getInt("SoLuongTon"));
            sp.setMaLoai(rs.getString("MaLoai"));
            sp.setMaNCC(rs.getString("MaNCC"));
             list.add(sp);
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return list;
}
    
}
