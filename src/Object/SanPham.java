package Object;

import java.util.Date;

public class SanPham {
String MaSP;
String TenSP;
int SoLuong;
Double Gia;
Date NgayNhapHang;
String TrangThai;
String MaLoai;
String MaKho;
public SanPham(String maSP, String tenSP, int soLuong, Double gia, Date ngayNhapHang, String trangThai, String maLoai,
		String maKho) {
	super();
	MaSP = maSP;
	TenSP = tenSP;
	SoLuong = soLuong;
	Gia = gia;
	NgayNhapHang = ngayNhapHang;
	TrangThai = trangThai;
	MaLoai = maLoai;
	MaKho = maKho;
}
public String getMaSP() {
	return MaSP;
}
public void setMaSP(String maSP) {
	MaSP = maSP;
}
public String getTenSP() {
	return TenSP;
}
public void setTenSP(String tenSP) {
	TenSP = tenSP;
}
public int getSoLuong() {
	return SoLuong;
}
public void setSoLuong(int soLuong) {
	SoLuong = soLuong;
}
public Double getGia() {
	return Gia;
}
public void setGia(Double gia) {
	Gia = gia;
}
public Date getNgayNhapHang() {
	return NgayNhapHang;
}
public void setNgayNhapHang(Date ngayNhapHang) {
	NgayNhapHang = ngayNhapHang;
}
public String getTrangThai() {
	return TrangThai;
}
public void setTrangThai(String trangThai) {
	TrangThai = trangThai;
}
public String getMaLoai() {
	return MaLoai;
}
public void setMaLoai(String maLoai) {
	MaLoai = maLoai;
}
public String getMaKho() {
	return MaKho;
}
public void setMaKho(String maKho) {
	MaKho = maKho;
}



}
