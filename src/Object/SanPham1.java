package Object;

import java.util.Date;

public class SanPham1 {
String MaSP;
String TenSP;
int SoLuong;
Double Gia;
Date NgayNhapHang;
String TrangThai;
String MaLoai;
String MaKho;
String hinhAnh;

    public SanPham1() {
    }

    public SanPham1(String MaSP, String TenSP, int SoLuong, Double Gia, Date NgayNhapHang, String TrangThai, String MaLoai, String MaKho, String hinhAnh) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.NgayNhapHang = NgayNhapHang;
        this.TrangThai = TrangThai;
        this.MaLoai = MaLoai;
        this.MaKho = MaKho;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Double getGia() {
        return Gia;
    }

    public void setGia(Double Gia) {
        this.Gia = Gia;
    }

    public Date getNgayNhapHang() {
        return NgayNhapHang;
    }

    public void setNgayNhapHang(Date NgayNhapHang) {
        this.NgayNhapHang = NgayNhapHang;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }


}