package Object;

import java.util.Date;

public class HoaDon {
String MaHD;
String TenHD;
Date NgayDatHang;
String SoDienThoai;
String DiaChi;
Double ThanhTien;
String TrangThai;
String MaNV;
String MaKH;

    public HoaDon() {
    }


public HoaDon(String maHD, String tenHD, Date ngayDatHang, String soDienThoai, String diaChi, Double thanhTien,
		String trangThai, String maNV, String maKH) {
	super();
	MaHD = maHD;
	TenHD = tenHD;
	NgayDatHang = ngayDatHang;
	SoDienThoai = soDienThoai;
	DiaChi = diaChi;
	ThanhTien = thanhTien;
	TrangThai = trangThai;
	MaNV = maNV;
	MaKH = maKH;
}

@Override
public String toString(){
    return "Tháng: "+this.getNgayDatHang();
}

public String getMaHD() {
	return MaHD;
}
public void setMaHD(String maHD) {
	MaHD = maHD;
}
public String getTenHD() {
	return TenHD;
}
public void setTenHD(String tenHD) {
	TenHD = tenHD;
}
public Date getNgayDatHang() {
	return NgayDatHang;
}
public void setNgayDatHang(Date ngayDatHang) {
	NgayDatHang = ngayDatHang;
}
public String getSoDienThoai() {
	return SoDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	SoDienThoai = soDienThoai;
}
public String getDiaChi() {
	return DiaChi;
}
public void setDiaChi(String diaChi) {
	DiaChi = diaChi;
}
public Double getThanhTien() {
	return ThanhTien;
}
public void setThanhTien(Double thanhTien) {
	ThanhTien = thanhTien;
}
public String getTrangThai() {
	return TrangThai;
}
public void setTrangThai(String trangThai) {
	TrangThai = trangThai;
}
public String getMaNV() {
	return MaNV;
}
public void setMaNV(String maNV) {
	MaNV = maNV;
}
public String getMaKH() {
	return MaKH;
}
public void setMaKH(String maKH) {
	MaKH = maKH;
}



}
