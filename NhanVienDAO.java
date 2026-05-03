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
import model.NhanVien;
import util.DBConnection;

public class NhanVienDAO {

    
    public NhanVien checkLogin(String maNV, String matKhau) {
        String sql = "SELECT * FROM Nhan_Vien WHERE MaNV = ? AND MatKhau = ?";
        
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            
            ps.setString(1, maNV);
            ps.setString(2, matKhau);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setChucVu(rs.getString("ChucVu"));
                
                return nv; 
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null; 
    }
    public List<NhanVien> getAll() {
    List<NhanVien> list = new ArrayList<>();
    String sql = "SELECT * FROM Nhan_Vien";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setHoTen(rs.getString("HoTen"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setMatKhau(rs.getString("MatKhau"));
            nv.setChucVu(rs.getString("ChucVu"));
            nv.setSdt(rs.getString("SDT"));
            
            list.add(nv);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public boolean insert(NhanVien nv) {
    String sql = "INSERT INTO Nhan_Vien (MaNV, HoTen, NgaySinh, MatKhau, ChucVu, SDT) VALUES (?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        
        ps.setString(1, nv.getMaNV());
        ps.setString(2, nv.getHoTen());
        ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
        ps.setString(4, nv.getMatKhau());
        ps.setString(5, nv.getChucVu());
        ps.setString(6, nv.getSdt());
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean delete(String maNV) {
    String sql = "DELETE FROM Nhan_Vien WHERE MaNV = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
       
        ps.setString(1, maNV);
        
        
        return ps.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean update(NhanVien nv) {
    String sql = "UPDATE Nhan_Vien SET HoTen = ?, NgaySinh = ?, MatKhau = ?, ChucVu = ?, SDT = ? WHERE MaNV = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, nv.getHoTen());
        ps.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
        ps.setString(3, nv.getMatKhau());
        ps.setString(4, nv.getChucVu());
        ps.setString(5, nv.getSdt());
        ps.setString(6, nv.getMaNV()); 
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    
    public List<model.NhanVien> search(String keyword) {
    List<model.NhanVien> list = new ArrayList<>();
    
    String sql = "SELECT * FROM Nhan_Vien WHERE MaNV LIKE ? OR HoTen LIKE ? OR ChucVu LIKE ? OR SDT LIKE ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        String query = "%" + keyword + "%";
        ps.setString(1, query);
        ps.setString(2, query);
        ps.setString(3, query);
        ps.setString(4, query);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.NhanVien nv = new model.NhanVien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setHoTen(rs.getString("HoTen"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setMatKhau(rs.getString("MatKhau"));
            nv.setChucVu(rs.getString("ChucVu"));
            nv.setSdt(rs.getString("SDT"));
            list.add(nv);
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return list;
}
    
}
