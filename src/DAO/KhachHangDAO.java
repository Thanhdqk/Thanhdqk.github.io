/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Object.KhachHang;
import Util.DatabaseKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class KhachHangDAO {
    public void insert(KhachHang model){
        String sql="INSERT INTO Khach_Hang(MaKH, HoTen, SoDienThoai, Email, DiaChi) VALUES(?, ?, ?, ?, ?)";
        DatabaseKho.executeUpdate(sql, 
                model.getHoTen(),
                model.getSoDienThoai(),
                model.getEmail(),
                model.getDiaChi(),
                model.getMaKh());
    }
    public void update(KhachHang model){
        String sql="UPDATE Khach_Hang SET HoTen=?, SoDienThoai=?, Email=?, DiaChi=? WHERE MaKH=?";
        DatabaseKho.executeUpdate(sql, 
                model.getHoTen(),
                model.getSoDienThoai(),
                model.getEmail(),
                model.getDiaChi(),
                model.getMaKh());
    }
    public void delete(String MaKh){
        String sql="DELETE FROM Khach_Hang WHERE MaKH=?";
        DatabaseKho.executeUpdate(sql, MaKh);
    }
    public List<KhachHang> selectAll(){
        String sql="SELECT * FROM Khach_Hang";
        return select(sql);
    }
    public KhachHang findById(String makh){
        String sql="SELECT * FROM Khach_Hang WHERE MaKH=?";
        List<KhachHang> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<KhachHang> select(String sql, Object...args){
        List<KhachHang> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseKho.executeQuery(sql, args);
                while(rs.next()){
                    KhachHang model=readFromResultSet(rs);
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
    private KhachHang readFromResultSet(ResultSet rs) throws SQLException{
        KhachHang model=new KhachHang();
        model.setHoTen(rs.getString("HoTen"));
        model.setSoDienThoai(rs.getString("SoDienThoai"));
        model.setEmail(rs.getString("Email"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setMaKh(rs.getString("MaKH"));
        return model;
    }
    public List<KhachHang> selectByKeyword(String keyword){
        String sql="SELECT * FROM Khach_Hang WHERE SoDienThoai LIKE ?";
        return select(sql, "%"+keyword+"%");
    }
}
