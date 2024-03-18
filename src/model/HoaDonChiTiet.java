/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoanh
 */
public class HoaDonChiTiet {

    private int MaHDCT;
    private int MaCTSP;
    private int MaHD;
    private int MaTT;
    private int SoLuong;
    private double DonGia;
    private int MaKM;
    private String GhiChu;

    public HoaDonChiTiet(int MaHDCT, int MaCTSP, int MaHD, int MaTT, int SoLuong, double DonGia, int MaKM, String GhiChu) {
        this.MaHDCT = MaHDCT;
        this.MaCTSP = MaCTSP;
        this.MaHD = MaHD;
        this.MaTT = MaTT;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.MaKM = MaKM;
        this.GhiChu = GhiChu;
    }

    public HoaDonChiTiet() {
    }

    public int getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(int MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public int getMaCTSP() {
        return MaCTSP;
    }

    public void setMaCTSP(int MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaTT() {
        return MaTT;
    }

    public void setMaTT(int MaTT) {
        this.MaTT = MaTT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public int getMaKM() {
        return MaKM;
    }

    public void setMaKM(int MaKM) {
        this.MaKM = MaKM;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
