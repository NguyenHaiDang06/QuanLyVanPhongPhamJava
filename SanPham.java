/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author duc
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private String donViTinh;
    private double donGia;
    private int soLuongTon;
    private String maLoai;
    private String maNCC;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String donViTinh, double donGia, int soLuongTon, String maLoai, String maNCC) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.maLoai = maLoai;
        this.maNCC = maNCC;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", donViTinh=" + donViTinh + ", donGia=" + donGia + ", soLuongTon=" + soLuongTon + ", maLoai=" + maLoai + ", maNCC=" + maNCC + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.maSP);
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
        final SanPham other = (SanPham) obj;
        return Objects.equals(this.maSP, other.maSP);
    }
    
}
