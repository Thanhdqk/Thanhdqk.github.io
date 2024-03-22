/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Nguyen Van Loi
 */
import Object.Kho;
        import Util.JdbcHelper;
public class KhoDAO {
    public void insert(Kho model){
        String sql = "insert into kho values(?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaKho(),model.getTenKho());
    }
    public void update(Kho model)
    {
        String sql = "update kho set tenkho = ? where makho = ?";
        JdbcHelper.executeUpdate(sql, model.getTenKho(),model.getMaKho());
    }
    public void delete(String makho)
    {
        String sql = "delete kho where makho = ?";
        JdbcHelper.executeUpdate(sql, makho);
    }
}
