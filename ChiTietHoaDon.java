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
public class ChiTietHoaDon {
    private String maSP;
    private String maHD;
    private int soLuong;
    private double donGiaBan;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maSP, String maHD, int soLuong, double donGiaBan) {
        this.maSP = maSP;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.donGiaBan = donGiaBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.maSP);
        hash = 17 * hash + Objects.hashCode(this.maHD);
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
        final ChiTietHoaDon other = (ChiTietHoaDon) obj;
        if (!Objects.equals(this.maSP, other.maSP)) {
            return false;
        }
        return Objects.equals(this.maHD, other.maHD);
    }

    @Override
    public String toString() {
        return "Chi_Tiet_Hoa_Don{" + "maSP=" + maSP + ", maHD=" + maHD + ", soLuong=" + soLuong + ", donGiaBan=" + donGiaBan + '}';
    }
    
}
