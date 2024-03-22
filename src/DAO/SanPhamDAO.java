/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Nguyen Van Loi
 */
import Object.NhanVien;
import Object.PhieuNhap;
import Object.PhieuXuat;
import Util.JdbcHelper;
import Object.SanPham1;
import Util.DatabaseKho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SanPhamDAO {
    public void insert(SanPham1 model)
    {
        String sql = "insert San_pham values(?,?,?,?,?,?,?,?,?)";
        DatabaseKho.executeUpdate(sql, model.getMaSP(),
                model.getTenSP(),
                model.getSoLuong(),
                model.getGia(),
                model.getNgayNhapHang(),
                model.getTrangThai(),
                model.getMaLoai(),
                model.getMaKho(),
                model.getHinhAnh());
    }
    public void delete(String Masp)
    {
        String sql ="delete san_pham where masp=?";
        DatabaseKho.executeUpdate(sql, Masp);
    }
    public void update(SanPham1 model)
    {
        String sql = "update san_pham set tensp =?,soluong = ?,gia=?,NgayNhapHang =?, TrangThai =?, Maloai=?,Makho=?, HinhAnh=? where Masp =?";
        DatabaseKho.executeUpdate(sql,model.getTenSP(),
                model.getSoLuong(),
                model.getGia(),
                model.getNgayNhapHang(),
                model.getTrangThai(),
                model.getMaLoai(),
                model.getMaKho(),
                model.getHinhAnh(),
                model.getMaSP());
    }
    
    public List<SanPham1> selectAll() {
        String sql = "select * from San_Pham";
        return select(sql);
    }
    
    public SanPham1 findById(String MaSP){
        String sql="select * from San_Pham where MaSP = ?";
        List<SanPham1> list = select(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public SanPham1 timTheoTen(String TenSP){
        String sql="select * from San_Pham where TenSP like ?";
        List<SanPham1> list = select(sql, TenSP);
        return list.size() > 0 ? list.get(1) : null;
    }
    
    private List<SanPham1> select(String sql, String... args) {
        List<SanPham1> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseKho.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham1 model = readFromResultSet(rs);
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

    private SanPham1 readFromResultSet(ResultSet rs) throws Exception {
        SanPham1 model = new SanPham1();
        model.setMaSP(rs.getString("MaSP"));
        model.setTenSP(rs.getString("TenSP"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGia(rs.getDouble("Gia"));
        model.setNgayNhapHang(rs.getDate("NgayNhapHang"));
        model.setTrangThai(rs.getString("TrangThai"));
        model.setMaLoai(rs.getString("MaLoai"));
        model.setMaKho(rs.getString("MaKho"));
        model.setHinhAnh(rs.getString("HinhAnh"));
        return model;
    }
    
    public List<Object[]> getTenLoai(String tenLoai) throws SQLException {
    List<Object[]> list = new ArrayList<>();
    Connection connection = null;
    
    try {
        String jdbcUrl = "jdbc:sqlserver://localhost;databaseName=SUPERDuAn1;encrypt=false;trustservercertificate=true";
        String username = "sa";
        String password = "123";
        connection = DriverManager.getConnection(jdbcUrl, username, password);

        String sql = "SELECT San_Pham.MaSP, San_Pham.TenSP, San_Pham.SoLuong, San_Pham.Gia, San_Pham.NgayNhapHang, San_Pham.TrangThai,"
                + " San_Pham.Maloai, San_Pham.MaKho, San_Pham.HinhAnh"
                + " FROM Loai_SanPham, San_Pham"
                + " WHERE Loai_SanPham.Maloai = San_Pham.Maloai AND Loai_SanPham.TenLoai LIKE N'%' + ? + '%'";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Gán giá trị cho tham số
            statement.setString(1, tenLoai);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Object[] model = {
                        resultSet.getString("MaSP"),
                        resultSet.getString("TenSP"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getFloat("Gia"),
                        resultSet.getDate("NgayNhapHang"),
                        resultSet.getString("TrangThai"),
                        resultSet.getString("Maloai"),
                        resultSet.getString("MaKho"),
                        resultSet.getString("HinhAnh")
                    };
                    list.add(model);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Xử lý lỗi nếu cần
    } finally {
        if (connection != null) {
            connection.close();
        }
    }

    return list;
}
}
