package Object;

public class LoaiSanPham {
	

	String MaLoai;
	String TenLoai;

    public LoaiSanPham() {
    }
        
        
	public LoaiSanPham(String maLoai, String tenLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}
        
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

	
}
