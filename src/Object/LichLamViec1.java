package Object;

import java.util.Date;

public class LichLamViec1 {
    String maLichLamViec;
    String TenNV;
    Date NgayLamViec;
    int CaLamViec;
    String ThoiGianLamViec;
    String MaNV;

    public LichLamViec1() {
    }

    public LichLamViec1(String maLichLamViec, String TenNV, Date NgayLamViec, int CaLamViec, String ThoiGianLamViec, String MaNV) {
        this.maLichLamViec = maLichLamViec;
        this.TenNV = TenNV;
        this.NgayLamViec = NgayLamViec;
        this.CaLamViec = CaLamViec;
        this.ThoiGianLamViec = ThoiGianLamViec;
        this.MaNV = MaNV;
    }

    public String getMaLichLamViec() {
        return maLichLamViec;
    }

    public void setMaLichLamViec(String maLichLamViec) {
        this.maLichLamViec = maLichLamViec;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public void setNgayLamViec(Date NgayLamViec) {
        this.NgayLamViec = NgayLamViec;
    }

    public int getCaLamViec() {
        return CaLamViec;
    }

    public void setCaLamViec(int CaLamViec) {
        this.CaLamViec = CaLamViec;
    }

    public String getThoiGianLamViec() {
        return ThoiGianLamViec;
    }

    public void setThoiGianLamViec(String ThoiGianLamViec) {
        this.ThoiGianLamViec = ThoiGianLamViec;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    

}
