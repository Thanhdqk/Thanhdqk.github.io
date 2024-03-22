/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author DELL
 */
public class HoaDonDT {
    String maDH;
    String tenKH;
    float thanhTien;

    public HoaDonDT() {
    }

    public HoaDonDT(String maDH, String tenKH, float thanhTien) {
        this.maDH = maDH;
        this.tenKH = tenKH;
        this.thanhTien = thanhTien;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
