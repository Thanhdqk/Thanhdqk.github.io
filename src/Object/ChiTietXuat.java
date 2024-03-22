package Object;

public class ChiTietXuat {
Double ThanhTien;
String TrangThai;
String MaSoPhieu;
String MaSP;


public ChiTietXuat(Double thanhTien, String trangThai, String maSoPhieu, String maSP) {
	super();
	ThanhTien = thanhTien;
	TrangThai = trangThai;
	MaSoPhieu = maSoPhieu;
	MaSP = maSP;
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


public String getMaSoPhieu() {
	return MaSoPhieu;
}


public void setMaSoPhieu(String maSoPhieu) {
	MaSoPhieu = maSoPhieu;
}


public String getMaSP() {
	return MaSP;
}


public void setMaSP(String maSP) {
	MaSP = maSP;
}



}
