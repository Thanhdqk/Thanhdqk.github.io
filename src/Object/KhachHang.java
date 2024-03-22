package Object;

public class KhachHang {
    private String HoTen;
    private String SoDienThoai;
    private String Email;
    private String DiaChi;
    private String MaKh;

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMaKh() {
        return MaKh;
    }

    public void setMaKh(String MaKh) {
        this.MaKh = MaKh;
    }

    public KhachHang() {
    }

    public KhachHang(String HoTen, String SoDienThoai, String Email, String DiaChi, String MaKh) {
        this.HoTen = HoTen;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.MaKh = MaKh;
    }

    
}
