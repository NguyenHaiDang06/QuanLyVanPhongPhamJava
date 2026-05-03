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
import model.NhaCungCap;
import util.DBConnection;

public class NhaCungCapDAO {

   
    
    public List<NhaCungCap> getAll() {
    List<NhaCungCap> list = new ArrayList<>();
    String sql = "SELECT * FROM Nha_Cung_Cap";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(rs.getString("MaNCC"));
            ncc.setTenNCC(rs.getString("TenNCC"));
            ncc.setDiaChi(rs.getString("DiaChi"));
            ncc.setSdt(rs.getString("SDT"));
            
            list.add(ncc);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public boolean insert(NhaCungCap ncc) {
    String sql = "INSERT INTO Nha_Cung_Cap (MaNCC, TenNCC, SDT, DiaChi) VALUES (?, ?, ?, ?)";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
       
        ps.setString(1, ncc.getMaNCC());
        ps.setString(2, ncc.getTenNCC());
        ps.setString(3, ncc.getSdt());
        ps.setString(4, ncc.getDiaChi());
        
        
        
       
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean delete(String maNCC) {
    String sql = "DELETE FROM Nha_Cung_Cap WHERE MaNCC = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setString(1, maNCC);
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean update(NhaCungCap ncc) {
    String sql = "UPDATE Nha_Cung_Cap SET TenNCC = ?, SDT = ?, DiaChi = ? WHERE MaNCC = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, ncc.getTenNCC());
        ps.setString(2, ncc.getSdt());
        ps.setString(3, ncc.getDiaChi());
        ps.setString(4, ncc.getMaNCC()); 
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    
    public List<model.NhaCungCap> search(String keyword) {
    List<model.NhaCungCap> list = new ArrayList<>();
   
    String sql = "SELECT * FROM Nha_Cung_Cap WHERE MaNCC LIKE ? OR TenNCC LIKE ? OR DiaChi LIKE ? OR SDT LIKE ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        String query = "%" + keyword + "%";
        ps.setString(1, query);
        ps.setString(2, query);
        ps.setString(3, query);
        ps.setString(4, query);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.NhaCungCap ncc = new model.NhaCungCap();
            ncc.setMaNCC(rs.getString("MaNCC"));
            ncc.setTenNCC(rs.getString("TenNCC"));
            ncc.setDiaChi(rs.getString("DiaChi"));
            ncc.setSdt(rs.getString("SDT"));
            
           
            
            list.add(ncc);
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return list;
}
    
}
