/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Nguyen Van Loi
 */
import Object.HoaDon;
import Object.LichLamViec1;
import Util.DatabaseKho;
import Util.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class HoaDonDAO {
    public void insert(HoaDon model)
    {
        String sql = "insert hoa_don values(?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaHD(),
                model.getTenHD(),
                model.getNgayDatHang(),
                model.getSoDienThoai(),
                model.getDiaChi(),
                model.getThanhTien(),
                model.getTrangThai(),
                model.getMaNV(),
                model.getMaKH());
    }
    public void delete(String mahd)
    {
        String sql = "delete hoa_don where madh =?";
        JdbcHelper.executeUpdate(sql, mahd);
    }
    public void update(HoaDon model)
    {
        String sql = "update hoa_don set tenkh=?,ngaydathang=?,sodienthoai=?,diachi=?,thanhtien=?,trangthai=?,manv=?,makh=? where madh =?";
        JdbcHelper.executeUpdate(sql, model.getTenHD(),
                model.getNgayDatHang(),
                model.getSoDienThoai(),
                model.getDiaChi(),
                model.getThanhTien(),
                model.getTrangThai(),
                model.getMaNV(),
                model.getMaKH(),
                model.getMaHD());
    }
    
    public HoaDon findById(String maSoPhieu){
        String sql="select * from Hoa_Don where maLichLamViec = ?";
        List<HoaDon> list = select(sql, maSoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }
     
    public List<HoaDon> selectAll() {
        String sql = "select * from Hoa_Don";
        return select(sql);
    }
    
    private List<HoaDon> select(String sql, String... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseKho.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    private HoaDon readFromResultSet(ResultSet rs) throws Exception {
        HoaDon model = new HoaDon();
        model.setMaHD(rs.getString("MaDH"));
        model.setTenHD(rs.getString("TenKH"));
        model.setNgayDatHang(rs.getDate("NgayDatHang"));
        model.setSoDienThoai(rs.getString("SoDienThoai"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setThanhTien(rs.getDouble("ThanhTien"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaKH(rs.getString("MaKH"));
        return model;
    }
    
    public List<HoaDon> selectByKeyword(String keyword){
        String sql="SELECT * FROM Hoa_Don WHERE SoDienThoai LIKE ?";
        return select(sql, "%"+keyword+"%");
    }
}
