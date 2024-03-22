package Object;

import java.util.Date;

public class PhieuXuat {
String MaSoPhieu;
String TenSP;
Date NgayTao;
int soLuong;

String MaKho;
String MaNV;

    public PhieuXuat() {
    }

    public PhieuXuat(String MaSoPhieu, String TenSP, Date NgayTao, int soLuong, String MaKho, String MaNV) {
        this.MaSoPhieu = MaSoPhieu;
        this.TenSP = TenSP;
        this.NgayTao = NgayTao;
        this.soLuong = soLuong;
        this.MaKho = MaKho;
        this.MaNV = MaNV;
    }

    public String getMaSoPhieu() {
        return MaSoPhieu;
    }

    public void setMaSoPhieu(String MaSoPhieu) {
        this.MaSoPhieu = MaSoPhieu;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    


}
