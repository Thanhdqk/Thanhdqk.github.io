/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Object.LichLamViec1;
import Object.LichLamViec1;
import Object.NhanVien;
import Object.PhieuNhap;
import Util.DatabaseKho;
import Util.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LichLamViecDAO {

     public void insertPhieuNhap(LichLamViec1 model) {
        String sql = "insert Lich_Lam_Viec values(?,?,?,?,?,?)";
        DatabaseKho.executeUpdate(sql, 
                    model.getMaLichLamViec(),
                    model.getTenNV(),
                    model.getNgayLamViec(),
                    model.getCaLamViec(),
                    model.getThoiGianLamViec(),
                    model.getMaNV()
        );
    }

    public void updatePhieuNhap(LichLamViec1 model) {
        String sql = "update Lich_Lam_Viec set TenNV=?, NgayLamViec=?, CaLamViec=?, ThoiGianLamViec = ?, MaNV =? where maLichLamViec=?";
        DatabaseKho.executeUpdate(sql,
                model.getTenNV(),
                model.getNgayLamViec(),
                model.getCaLamViec(),
                model.getThoiGianLamViec(),
                model.getMaNV(),
                model.getMaLichLamViec()
        );
    }

    public void deletePhieuNhap(String id) {
        String sql = "delete from Lich_Lam_Viec where maLichLamViec = ?";
        DatabaseKho.executeUpdate(sql, id);
    }
    


     public LichLamViec1 findById(String maSoPhieu){
        String sql="select * from Lich_Lam_Viec where maLichLamViec = ?";
        List<LichLamViec1> list = select(sql, maSoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }
     
    public List<LichLamViec1> selectAll() {
        String sql = "select * from Lich_Lam_Viec";
        return select(sql);
    }
    
    private List<LichLamViec1> select(String sql, String... args) {
        List<LichLamViec1> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseKho.executeQuery(sql, args);
                while (rs.next()) {
                    LichLamViec1 model = readFromResultSet(rs);
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
    
    private LichLamViec1 readFromResultSet(ResultSet rs) throws Exception {
        LichLamViec1 model = new LichLamViec1();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNV(rs.getString("TenNV"));
        model.setMaLichLamViec(rs.getString("MaLichLamViec"));
        model.setCaLamViec(rs.getInt("CaLamViec"));
        model.setNgayLamViec(rs.getDate("NgayLamViec"));
        model.setThoiGianLamViec(rs.getString("ThoiGianLamViec"));
        return model;
    }
}
