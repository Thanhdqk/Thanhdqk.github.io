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
import Util.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienDAO {
    public void insert(NhanVien model)
    {
        String sql ="insert Nhan_Vien values(?,?,?,?,?,?,?,?)";
       JdbcHelper.executeUpdate(sql, model.getMaNV(),
               model.getTenNV(),
               model.getGioiTinh(),
               model.getNgaySinh(),
               model.getVaiTro(),
               model.getEmail(),
               model.getHinh(),
               model.getMatKhau());
    }
    public void update(NhanVien model)
    {
        String sql ="update Nhan_Vien set TenNV=?, GioiTinh=?, NgaySinh=?,Vaitro=?,Email = ?,Hinh =?,MatKhau=? where MaNV=?";
        JdbcHelper.executeUpdate(sql, 
               model.getTenNV(),
               model.getGioiTinh(),
               model.getNgaySinh(),
               model.getVaiTro(),
               model.getEmail(),
               model.getHinh(),
               model.getMatKhau(),
               model.getMaNV());
    }
    
    public void delete(String Manv)
    {
        String sql = "delete from Nhan_Vien where Manv = ?";
        JdbcHelper.executeUpdate(sql, Manv);
    }
    
    public List<NhanVien> select()
    {
        String sql = "select * from Nhan_Vien";
        return select(sql);
    }
    public NhanVien findBYid(String MaNV)
    {
         String sql = "select * from Nhan_Vien where MaNV = ?";
         List<NhanVien> list = select(sql,MaNV);
         return list.size() > 0 ? list.get(0) : null;
    }
    private List<NhanVien> select(String sql, String...args){
        List<NhanVien> list=new ArrayList<>();
        try {
        ResultSet rs = null;
        try {
        rs = JdbcHelper.executeQuery(sql, args);
        while(rs.next()){
        NhanVien model=readFromResultSet(rs);
        list.add(model);
        }
        }
        finally{
        rs.getStatement().getConnection().close();
        }
        }
        catch (Exception ex) {
        throw new RuntimeException(ex);
        }
        return list;
}
 private NhanVien readFromResultSet(ResultSet rs) throws Exception{
NhanVien model=new NhanVien();
model.setMaNV(rs.getString("MaNV"));
model.setTenNV(rs.getString("TenNV"));
model.setGioiTinh(rs.getString("GioiTinh"));
model.setNgaySinh(rs.getDate("NgaySinh"));
model.setVaiTro(rs.getString("VaiTro"));
model.setEmail(rs.getString("Email"));
model.setHinh(rs.getString("Hinh"));
model.setMatKhau(rs.getString("MatKhau"));

return model;
}
}
