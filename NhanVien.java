/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author duc
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private Date ngaySinh;
    private String matKhau;
    private String chucVu;
    private String sdt;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, Date ngaySinh, String matKhau, String chucVu, String sdt) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.sdt = sdt;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.maNV);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.maNV, other.maNV);
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", matKhau=" + matKhau + ", chucVu=" + chucVu + ", sdt=" + sdt + '}';
    }

    

   
    
    
}
