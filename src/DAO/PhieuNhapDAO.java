/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Object.NhanVien;
import Object.PhieuNhap;
import Util.Database;
import Util.DatabaseKho;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Object.ChiTietNhap;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @author DELL
 */
public class PhieuNhapDAO {
     public void insertPhieuNhap(PhieuNhap model) {
        String sql = "insert Phieu_Nhap values(?,?,?,?,?,?)";
        DatabaseKho.executeUpdate(sql, 
                model.getMaSoPhieu(),
                model.getTenSP(),
                model.getNgayTao(),
                model.getSoLuong(),
                model.getMaKho(),
                model.getMaNV()
        );
    }

    public void updatePhieuNhap(PhieuNhap model) {
        String sql = "update Phieu_Nhap set TenSP=?, NgayTao=?, SoLuong=?, MaKho = ?, MaNV =? where MaSoPhieu=?";
        DatabaseKho.executeUpdate(sql,
                model.getTenSP(),
                model.getNgayTao(),
                model.getSoLuong(),
                model.getMaKho(),
                model.getMaNV(),
                model.getMaSoPhieu()
        );
    }

    public void deletePhieuNhap(String MaSoPhieu) {
        String sql = "delete from Phieu_Nhap where MaSoPhieu = ?";
        DatabaseKho.executeUpdate(sql, MaSoPhieu);
    }
    


     public PhieuNhap findById(String maSoPhieu){
        String sql="select * from Phieu_Nhap where MaSoPhieu = ?";
        List<PhieuNhap> list = select(sql, maSoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     
    public List<PhieuNhap> selectAll() {
        String sql = "select * from Phieu_Nhap";
        return select(sql);
    }



    private List<PhieuNhap> select(String sql, String... args) {
        List<PhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseKho.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuNhap model = readFromResultSet(rs);
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
 
    
    private PhieuNhap readFromResultSet(ResultSet rs) throws Exception {
        PhieuNhap model = new PhieuNhap();
        model.setMaSoPhieu(rs.getString("MaSoPhieu"));
        model.setTenSP(rs.getString("TenSP"));
        model.setNgayTao(rs.getDate("NgayTao"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setMaKho(rs.getString("MaKho"));
        model.setMaNV(rs.getString("MaNV"));
        return model;
    }
    
    public List<Object[]> getDoanhThu(Date ngay) throws SQLException {
        List<Object[]> list = new ArrayList<>();
        Connection connection;
        String jdbcUrl = "jdbc:sqlserver://localhost;databaseName=SUPERDuAn1;encrypt=false;trustservercertificate=true";
        String username = "sa";
        String password = "123";
        connection = DriverManager.getConnection(jdbcUrl, username, password);

        try {
            String sql = "SELECT MaSoPhieu, TenSP, NgayTao, SoLuong, MaKho, MaNV FROM Phieu_Nhap WHERE CAST(NgayTao AS Date) = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Chuyển ngày thành java.sql.Date để tránh vấn đề với các loại ngày khác nhau
                java.sql.Date sqlNgay = new java.sql.Date(ngay.getTime());
                statement.setDate(1, sqlNgay);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Object[] model = {
                                resultSet.getString("MaSoPhieu"),
                                resultSet.getString("TenSP"),
                                resultSet.getDate("NgayTao"),
                                resultSet.getInt("SoLuong"),
                                resultSet.getString("MaKho"),
                                resultSet.getString("MaNV")
                        };
                        list.add(model);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }

        return list;
    }

}
