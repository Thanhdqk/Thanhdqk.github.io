/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Object.HoaDon1;
import Util.DatabaseKho;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;


public class HoaDonDAO1 {
    public void insert (HoaDon1 model){
        String sql = "INSERT INTO Hoa_Don(MaDH, TenKH, NgayDatHang, SoDienThoai, DiaChi, ThanhTien, MaNV, MaKH) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        DatabaseKho.executeUpdate(sql, model.getMaHD(),
                model.getTenKH(),
                model.getNgayDatHang(),
                model.getSoDienThoai(),
                model.getDiaChi(),
                model.getThanhTien(), 
                model.getMaNV(),
                model.getMaKH());
    }
    public void update (HoaDon1 model){
        String sql = "UPDATE Hoa_Don SET TenKH=?, NgayDatHang=?, SoDienThoai=?, DiaChi=?, ThanhTien=?, MaNV=?, MaKH=? WHERE MaDH=?";
        DatabaseKho.executeUpdate(sql,model.getTenKH(),
                model.getNgayDatHang(),
                model.getSoDienThoai(),
                model.getDiaChi(),
                model.getThanhTien(), 
                model.getMaNV(),
                model.getMaKH(),
                model.getMaHD());
    }
    public void delete(String MaHD){
        String sql="DELETE FROM Hoa_Don WHERE MaDH=?";
        DatabaseKho.executeUpdate(sql, MaHD);
    }
    
    public void delete1(String maHD){
        String sql = "delete from ChiTietHD where MaDH = ?";
        DatabaseKho.executeUpdate(sql, maHD);
    }
    
    public List<HoaDon1> selectAll(){
        String sql="SELECT * FROM Hoa_Don";
        return select(sql);
    }
    
    public HoaDon1 findById(String mahd){
        String sql="SELECT * FROM Hoa_Don WHERE MaDH=?";
        List<HoaDon1> list = select(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<HoaDon1> select(String sql, Object...args){
        List<HoaDon1> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseKho.executeQuery(sql, args);
                while(rs.next()){
                    HoaDon1 model=readFromResultSet(rs);
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    private HoaDon1 readFromResultSet(ResultSet rs) throws SQLException{
        HoaDon1 model=new HoaDon1();
        model.setMaHD(rs.getString("MaDH"));
        model.setTenKH(rs.getString("TenKH"));
        model.setNgayDatHang(rs.getDate("NgayDatHang"));
        model.setSoDienThoai(rs.getString("SoDienThoai"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setThanhTien(rs.getDouble("ThanhTien"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaKH(rs.getString("MaKH"));
        return model;
    }
    public List<HoaDon1> selectByKeyword(String keyword){
        String sql="SELECT * FROM Hoa_Don WHERE SoDienThoai LIKE ?";
        return select(sql, "%"+keyword+"%");
    }
}
