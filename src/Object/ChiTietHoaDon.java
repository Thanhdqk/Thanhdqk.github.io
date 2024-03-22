package Object;

public class ChiTietHoaDon {
String GhiChu;
Double ThueVAT;
String MaHD;
String MaSP;

public ChiTietHoaDon(String ghiChu, Double thueVAT, String maHD, String maSP) {
	super();
	GhiChu = ghiChu;
	ThueVAT = thueVAT;
	MaHD = maHD;
	MaSP = maSP;
}

public String getGhiChu() {
	return GhiChu;
}

public void setGhiChu(String ghiChu) {
	GhiChu = ghiChu;
}

public Double getThueVAT() {
	return ThueVAT;
}

public void setThueVAT(Double thueVAT) {
	ThueVAT = thueVAT;
}

public String getMaHD() {
	return MaHD;
}

public void setMaHD(String maHD) {
	MaHD = maHD;
}

public String getMaSP() {
	return MaSP;
}

public void setMaSP(String maSP) {
	MaSP = maSP;
}



}
