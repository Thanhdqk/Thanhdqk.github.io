
package DAO;

import Object.LoaiSanPham;
import Object.PhieuNhap;
import Util.DatabaseKho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LoaiSanPhamDAO {
    public List<LoaiSanPham> selectAll() {
        String sql = "select * from Loai_SanPham";
        return select(sql);
    }
    
    private List<LoaiSanPham> select(String sql, String... args) {
        List<LoaiSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseKho.executeQuery(sql, args);
                while (rs.next()) {
                    LoaiSanPham model = readFromResultSet(rs);
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
 
    
    private LoaiSanPham readFromResultSet(ResultSet rs) throws Exception {
        LoaiSanPham model = new LoaiSanPham();
        model.setMaLoai(rs.getString("MaLoai"));
        model.setTenLoai(rs.getString("TenLoai"));
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
