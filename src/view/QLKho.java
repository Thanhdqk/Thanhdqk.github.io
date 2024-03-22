/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.PhieuNhapDAO;
import DAO.PhieuXuatDAO;
import Object.PhieuNhap;
import Object.PhieuXuat;
import Util.Auth;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class QLKho extends javax.swing.JFrame {
    int index =0;
    PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    PhieuXuatDAO pxDao = new PhieuXuatDAO();
    /**
     * Creates new form QLKho
     */
    public QLKho() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        btnPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-24 (1).png")));
        btnPhieuXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-24 (1).png")));
        
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-x-25.png")));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-24 (1).png")));
        btnCapNhat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-24 (1).png")));
        
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24 (1).png")));
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24 (1).png")));
        
        btnXemNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/output-onlinegiftools (3).gif")));
        btnXemXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/output-onlinegiftools (3).gif")));
        
        btnXoaNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/output-onlinegiftools (2).gif")));
        btnXoaXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/output-onlinegiftools (2).gif"))); 
        
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-clear-24.png")));
        btnClear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-clear-24.png")));
        
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-back-24.png")));
        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-back-24.png")));
        
        txtMaNV.setText(Auth.user.getMaNV());
        txtMaNV.setEditable(false);
        txtMaNV1.setText(Auth.user.getMaNV());
        txtMaNV1.setEditable(false);
        
        tblPhieuNhap.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tblPhieuNhap.getTableHeader().setBackground(new Color(0,255,255));
        tblPhieuNhap.getTableHeader().setForeground(new Color(255,0,255));
        tblPhieuNhap.setSelectionBackground(Color.YELLOW);
        
        tblPhieuXuat.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tblPhieuXuat.getTableHeader().setBackground(new Color(0,255,255));
        tblPhieuXuat.getTableHeader().setForeground(new Color(255,0,255));
        tblPhieuXuat.setSelectionBackground(Color.YELLOW);
        cboMaKhoPhieuNhap.setSelectedIndex(0);
    }

//    void fillToTablePhieuNhap(){
//        DefaultTableModel model = (DefaultTableModel) tblPhieuNhap.getModel();
//        model.setRowCount(0);
//        try {
//            List<PhieuNhap> list = pnDAO.selectAll();
//            for (PhieuNhap pn : list) {
//                Object [] row = {
//                    pn.getMaSoPhieu(),
//                    pn.getTenSP(),
//                    pn.getNgayTao(),
//                    pn.getSoLuong(),
//                    pn.getMaKho(),
//                    pn.getMaNV()
//                };
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
void fillToTablePhieuNhap() throws SQLException {
    DefaultTableModel model = (DefaultTableModel) tblPhieuNhap.getModel();
    model.setRowCount(0);

    Object selectedItem = cboPhieuNhap.getSelectedItem();

    if (selectedItem instanceof java.sql.Date) {
        java.sql.Date selectedDate = (java.sql.Date) selectedItem;


        PhieuNhap pn = convertDateToPhieuNhap(selectedDate);


        List<Object[]> list = pnDAO.getDoanhThu(pn.getNgayTao());


        for (Object[] row : list) {
            model.addRow(row);
        }
        
    }
    for (int i = 0; i < tblPhieuNhap.getRowCount(); i++) {
        tblPhieuNhap.setRowHeight(i,50);
    }
}


private PhieuNhap convertDateToPhieuNhap(java.sql.Date date) {
    return new PhieuNhap(date.toString(), "Tên SP", date, 0, "Mã Kho", "Mã NV");
}
    
    
//    void fillToTablePhieuXuat(){
//        DefaultTableModel model = (DefaultTableModel) tblPhieuXuat.getModel();
//        model.setRowCount(0);
//        try {
//            List<PhieuXuat> list = pxDao.selectAll();
//            for (PhieuXuat px : list) {
//                Object [] row = {
//                    px.getMaSoPhieu(),
//                    px.getTenSP(),
//                    px.getNgayTao(),
//                    px.getSoLuong(),
//                    px.getMaKho(),
//                    px.getMaNV()
//                };
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//        }
//    }
    
void fillToTablePhieuXuat() throws SQLException {
    DefaultTableModel model = (DefaultTableModel) tblPhieuXuat.getModel();
    model.setRowCount(0);

    Object selectedItem = cboPhieuXuat.getSelectedItem();

    if (selectedItem instanceof java.sql.Date) {
        java.sql.Date selectedDate = (java.sql.Date) selectedItem;


        PhieuXuat px = convertDateToPhieuXuat(selectedDate);

        List<Object[]> list = pxDao.getDoanhThu(px.getNgayTao());

        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    for (int i = 0; i < tblPhieuXuat.getRowCount(); i++) {
        tblPhieuXuat.setRowHeight(i,50);
    }
}


private PhieuXuat convertDateToPhieuXuat(java.sql.Date date) {

    return new PhieuXuat(date.toString(), "Tên SP", date, 0, "Mã Kho", "Mã NV");
}

    void setModelPhieuNhap(PhieuNhap model){
        txtMaSoPhieu.setText(model.getMaSoPhieu());
        txtTenSanPham.setText(model.getTenSP());
        Date ngayTao = model.getNgayTao();
        txtNgayTao.setDate(ngayTao);
        txtSoLuong.setText(String.valueOf(model.getSoLuong()));
        //txtMaKho.setText(model.getMaKho());
        cboMaKhoPhieuNhap.setSelectedItem(model.getMaKho());
        txtMaNV.setText(model.getMaNV());
    }
    
    PhieuNhap getModelPhieuNhap(){
        PhieuNhap model = new PhieuNhap();
        model.setMaSoPhieu(txtMaSoPhieu.getText());
        model.setTenSP(txtTenSanPham.getText());
        Date ngayTao = txtNgayTao.getDate();
        model.setNgayTao(ngayTao);
        model.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        //model.setMaKho(txtMaKho.getText());
        model.setMaKho(cboMaKhoPhieuNhap.getSelectedItem().toString());
        model.setMaNV(txtMaNV.getText());
        return model;
    }
        
    void editPhieuNhap(){
        try {
            String maSoPhieu = (String) tblPhieuNhap.getValueAt(this.index, 0);
            PhieuNhap model = pnDAO.findById(maSoPhieu);
            if(model!=null){
                this.setModelPhieuNhap(model);
                setStatus(false);
            }
        } catch (Exception e) {
        } 
    }
    
    void setModelPhieuXuat(PhieuXuat model){
        txtMaSoPhieu1.setText(model.getMaSoPhieu());
        txtTenSanPham1.setText(model.getTenSP());
        Date ngayTao = model.getNgayTao();
        txtNgayTao1.setDate(ngayTao);
        txtSoLuong1.setText(String.valueOf(model.getSoLuong()));
        //txtMaKho1.setText(model.getMaKho());
        cboMaKhoPhieuXuat.setSelectedItem(model.getMaKho());
        txtMaNV1.setText(model.getMaNV());
    }
    
    PhieuXuat getModelPhieuXuat(){
        PhieuXuat model = new PhieuXuat();
        model.setMaSoPhieu(txtMaSoPhieu1.getText());
        model.setTenSP(txtTenSanPham1.getText());
        Date ngayTao = txtNgayTao1.getDate();
        model.setNgayTao(ngayTao);
        model.setSoLuong(Integer.parseInt(txtSoLuong1.getText()));
       //model.setMaKho(txtMaKho1.getText());
        model.setMaKho(cboMaKhoPhieuXuat.getSelectedItem().toString());
        model.setMaNV(txtMaNV1.getText());
        return model;
    }
    
    void editPhieuXuat(){
        try {
            String maSoPhieu = (String) tblPhieuXuat.getValueAt(this.index, 0);
            PhieuXuat model = pxDao.findById(maSoPhieu);
            if(model!=null){
                this.setModelPhieuXuat(model);
                setStatus1(false);
            }
        } catch (Exception e) {
        }
    }
    
    void xemChiTietNhap(){
        index = tblPhieuNhap.getSelectedRow();
        try {
            String maSoPhieu = (String) tblPhieuNhap.getValueAt(index, 0);
            String maSanPham = (String) tblPhieuNhap.getValueAt(index, 1);
            String tenSP = (String) tblPhieuNhap.getValueAt(index, 1);
            Date ngayTao = (Date) tblPhieuNhap.getValueAt(index, 2);
            
            int soLuong = (int) tblPhieuNhap.getValueAt(index, 3);
            String maKho = (String) tblPhieuNhap.getValueAt(index, 4);
            String maNV = (String) tblPhieuNhap.getValueAt(index, 5);
            
            String thanhTien = (String) tblPhieuNhap.getValueAt(index, 1);
            String trangThai = (String) tblPhieuNhap.getValueAt(index, 4);
            ChiTietNhap ct = new ChiTietNhap();
            ct.setMaSoPhieu(maSoPhieu, maSanPham, tenSP, ngayTao, soLuong, maKho, maNV, trangThai, thanhTien);
            ct.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void xemChiTietXuat(){
        index = tblPhieuXuat.getSelectedRow();
        try {
            String maSoPhieu = (String) tblPhieuXuat.getValueAt(index, 0);
            String maSanPham = (String) tblPhieuXuat.getValueAt(index, 1);
            String tenSP = (String) tblPhieuXuat.getValueAt(index, 1);
            Date ngayTao = (Date) tblPhieuXuat.getValueAt(index, 2);
            
            int soLuong = (int) tblPhieuXuat.getValueAt(index, 3);
            String maKho = (String) tblPhieuXuat.getValueAt(index, 4);
            String maNV = (String) tblPhieuXuat.getValueAt(index, 5);
            
            String thanhTien = (String) tblPhieuXuat.getValueAt(index, 1);
            String trangThai = (String) tblPhieuXuat.getValueAt(index, 4);
            ChiTietXuat ct = new ChiTietXuat();
            ct.setChiTietXuat(maSoPhieu, maSanPham, tenSP, ngayTao, soLuong, maKho, maNV, trangThai, thanhTien);
            ct.setVisible(true);
        } catch (Exception e) {
        }
    }
    
    void clear(){
        txtMaSoPhieu.setText(generateNewProductCode());
        txtTenSanPham.setText("");
        txtNgayTao.setDate(new Date());
        txtSoLuong.setText("");
        //txtMaKho.setText("");
        cboMaKhoPhieuNhap.setSelectedIndex(0);
        setStatus(true);
    }
    
    void clear1(){
        txtMaSoPhieu1.setText(generateNewProductCode1());
        txtTenSanPham1.setText("");
        txtNgayTao1.setDate(new Date());
        txtSoLuong1.setText("");
        //txtMaKho1.setText("");
        cboMaKhoPhieuXuat.setSelectedIndex(0);
        setStatus1(true);
    }
    
    void setStatus(boolean status){
        btnPhieuNhap.setEnabled(status);
        btnCapNhat.setEnabled(!status);
        btnXoa.setEnabled(!status);
    }
    
    void setStatus1(boolean status){
        btnPhieuXuat1.setEnabled(status);
        btnCapNhat1.setEnabled(!status);
        btnXoa1.setEnabled(!status);
    }
    
//    void insertChung(){        
//        
//            insertPhieuNhap();
//            
//            String tenSP = txtTenSanPham.getText();
//            String soLuong = txtSoLuong.getText();
//            Date ngayTao = txtNgayTao.getDate();
//            String trangThai = (String) cboTrangThai.getSelectedItem();
//            trangThai = "Hàng vừa mới nhập";
//            NewJFrame fr = new NewJFrame();
//            fr.setNewJFrame(tenSP, soLuong, ngayTao, trangThai);
//            fr.setVisible(true);
//            clear();
//        
//        
//            insertPhieuXuat();
//            
//            String tenSP = txtTenSanPham.getText();
//            String soLuong = txtSoLuong.getText();
//            Date ngayTao = txtNgayTao.getDate();
//            String trangThai = (String) cboTrangThai.getSelectedItem();
//            trangThai = "Hàng vừa mới xuất";
//            NewJFrame fr = new NewJFrame();
//            fr.setNewJFrame(tenSP, soLuong, ngayTao, trangThai);
//            fr.setVisible(true);
//            clear();
//        }
//    }
    

    
    void updateChung(){    
        String maPhieu = txtMaSoPhieu.getText();
        if(maPhieu.startsWith("PN")){
            updatePhieuNhap();
            clear();
        }
        else{
            updatePhieuXuat();
            clear();
        }
    }
    
    void deleteChung(){
        if(tblPhieuNhap.getSelectedRow()==0){
            deletePhieuNhap();
            clear();
        }else{
            deletePhieuXuat();
            clear();
        }
    }
    
//    void insertPhieuNhap(){
//        PhieuNhap model = getModelPhieuNhap();
//        try {
//            pnDAO.insertPhieuNhap(model);
//            this.fillToTablePhieuNhap();
//            String tenSP = txtTenSanPham.getText();
//            String soLuong = txtSoLuong.getText();
//            Date ngayTao = txtNgayTao.getDate();
//            String maKho = txtMaKho.getText();
//            String trangThai;
//            trangThai = "Hàng vừa mới nhập";
//            AddSP fr = new AddSP();
//            fr.setNewJFrame(tenSP, soLuong, ngayTao, trangThai, maKho);
//
//            fr.setVisible(true);
//            clear();
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(this, "Thêm mới thất bại !");
//            e.printStackTrace();
//        }
//    }
    
    void insertPhieuNhap() {
    PhieuNhap model = getModelPhieuNhap();
    try {
        String tenSP = txtTenSanPham.getText();
        String soLuong = txtSoLuong.getText();
        Date ngayTao = txtNgayTao.getDate();
        //String maKho = txtMaKho.getText();
        String maKho = cboMaKhoPhieuNhap.getSelectedItem().toString();
        String trangThai = "Hàng vừa mới nhập";
        AddSP fr = new AddSP();
        fr.setNewJFrame(tenSP, soLuong, ngayTao, trangThai, maKho);
        fr.setVisible(true);
        pnDAO.insertPhieuNhap(model);
        fillComBoPhieuNhap();
        clear();
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(this, "Thêm mới thất bại !");
        e.printStackTrace();
    }
}

    void updatePhieuNhap(){
        PhieuNhap model = getModelPhieuNhap();
        try {
            pnDAO.updatePhieuNhap(model);
            this.fillToTablePhieuNhap();
            
            JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại !");
            e.printStackTrace();
        }
    }
    
    void deletePhieuNhap(){
        PhieuNhap model = getModelPhieuNhap();
        String maSoPhieu = txtMaSoPhieu.getText();
        try {
            pnDAO.deletePhieuNhap(maSoPhieu);
            this.fillToTablePhieuNhap();

            JOptionPane.showMessageDialog(this, "Xóa thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại !");
            e.printStackTrace();
        }
    }
    
    void deletePhieuNhapTable(){
        index = tblPhieuNhap.getSelectedRow();
        String maSoPhieu = (String) tblPhieuNhap.getValueAt(index, 0);
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
            return;
    }
        try {
            pnDAO.deletePhieuNhap(maSoPhieu);
            
            // Cập nhật lại bảng
            DefaultTableModel model1 = (DefaultTableModel) tblPhieuNhap.getModel();
            model1.removeRow(index);
            fillToTablePhieuNhap();
            JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thất bại");
            e.printStackTrace();
        }
    }
    
    void deleteSelectedRow() {
    int selectedRow = tblPhieuNhap.getSelectedRow();

    String maSoPhieu = (String) tblPhieuNhap.getValueAt(selectedRow, 0);

    try {
        // Xóa dữ liệu từ DAO
        pnDAO.deletePhieuNhap(maSoPhieu);

        // Cập nhật lại model của bảng
        

        // Hiển thị thông báo thành công
        JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thành công !");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thất bại");
        e.printStackTrace();
    }
}
    
    void insertPhieuXuat(){
        PhieuXuat model = getModelPhieuXuat();
        try {
            pxDao.insertPhieuXuat(model);
            this.fillToTablePhieuXuat();
            clear1();
            JOptionPane.showMessageDialog(this, "Thêm thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !");
            e.printStackTrace();
        }
    }
    
    boolean isValidSoLuong(String soLuong) {
    try {
        int value = Integer.parseInt(soLuong);
        return value > 0;
    } catch (NumberFormatException e) {
        return false; // Không phải số
    }
}
    
    void updatePhieuXuat(){
        PhieuXuat model = getModelPhieuXuat();
        try {
            pxDao.updatePhieuXuat(model);
            this.fillToTablePhieuXuat();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại !");
            e.printStackTrace();
        }
    }
    
    void deletePhieuXuat(){
        PhieuXuat model = getModelPhieuXuat();
        String maSoPhieu = txtMaSoPhieu1.getText();
        try {
            pxDao.deletePhieuXuat(maSoPhieu);
            this.fillToTablePhieuXuat();
            JOptionPane.showMessageDialog(this, "Xóa thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại !");
            e.printStackTrace();
        }
    }
    
     void deletePhieuXuatTable(){
        index = tblPhieuXuat.getSelectedRow();
        String maSoPhieu = (String) tblPhieuXuat.getValueAt(index, 0);
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
            return;
    }
        try {
            pxDao.deletePhieuXuat(maSoPhieu);
            
            // Cập nhật lại bảng
            DefaultTableModel model1 = (DefaultTableModel) tblPhieuXuat.getModel();
            model1.removeRow(index);
            fillToTablePhieuXuat();
            JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thất bại");
            e.printStackTrace();
        }
    }
     
//    void fillComBoPhieuNhap(){
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhieuNhap.getModel();
//        model.removeAllElements();
//        List<PhieuNhap> list = pnDAO.selectAll();
//        for (PhieuNhap pn : list) {
//            Date ngay = pn.getNgayTao();
//            model.addElement(ngay);
//        }
//        cboPhieuNhap.setSelectedIndex(0);
//    }
    
    void fillComBoPhieuNhap() {
    DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhieuNhap.getModel();
    model.removeAllElements();

    Set<Date> uniqueDates = new HashSet<>(); // Tạo một Set để theo dõi các ngày duy nhất

    List<PhieuNhap> list = pnDAO.selectAll();
    for (PhieuNhap pn : list) {
        Date ngay = pn.getNgayTao();
        // Chỉ thêm ngày vào ComboBox nếu nó chưa tồn tại trong tập hợp
        if (uniqueDates.add(ngay)) {
            model.addElement(ngay);
        }
    }
    cboPhieuNhap.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // Khi một mục mới được chọn, cập nhật lại dữ liệu
                updateDataPhieuNhap();
                
            }
        }
    });
    cboPhieuNhap.setSelectedIndex(0);
}
    
//    void fillComBoPhieuXuat(){
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhieuXuat.getModel();
//        model.removeAllElements();
//        List<PhieuXuat> list = pxDao.selectAll();
//        for (PhieuXuat px : list) {
//            Date ngay = px.getNgayTao();
//            model.addElement(ngay);
//        }
//        cboPhieuNhap.setSelectedIndex(0);
//    }

    void fillComBoPhieuXuat() {
    DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhieuXuat.getModel();
    model.removeAllElements();

    Set<Date> uniqueDates = new HashSet<>(); // Tạo một Set để theo dõi các ngày duy nhất

    List<PhieuXuat> list = pxDao.selectAll();
    for (PhieuXuat pn : list) {
        Date ngay = pn.getNgayTao();
        // Chỉ thêm ngày vào ComboBox nếu nó chưa tồn tại trong tập hợp
        if (uniqueDates.add(ngay)) {
            model.addElement(ngay);
        }
    }
    cboPhieuXuat.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // Khi một mục mới được chọn, cập nhật lại dữ liệu
                updateDataPhieuXuat();
                
            }
        }
    });
    cboPhieuXuat.setSelectedIndex(0);
}
    
    public String generateNewProductCode() {
        String currentProductCode = getCurrentProductCodeFromDatabase();
        String newProductCode = incrementProductCode(currentProductCode);
        return newProductCode;
    }
    
    public String generateNewProductCode1() {
        String currentProductCode = getCurrentProductCodeFromDatabase1();
        String newProductCode = incrementProductCode1(currentProductCode);
        return newProductCode;
    }
    
    private String getCurrentProductCodeFromDatabase() {
    String currentProductCode = null;
    Connection connection;
    try {
        // Kết nối đến cơ sở dữ liệu
        String jdbcUrl = "jdbc:sqlserver://localhost;databaseName=SUPERDuAn1;encrypt=false;trustservercertificate=true";
        String username = "sa";
        String password = "123";

        connection = DriverManager.getConnection(jdbcUrl, username, password);
        // Tạo truy vấn SQL để lấy mã sản phẩm cuối cùng
        String query = "SELECT TOP 1 MaSoPhieu FROM Phieu_Nhap ORDER BY MaSoPhieu DESC";
        PreparedStatement statement = connection.prepareStatement(query);

        // Thực hiện truy vấn
        ResultSet resultSet = statement.executeQuery();

        // Lấy giá trị của cột MaSP từ kết quả truy vấn
        if (resultSet.next()) {
            currentProductCode = resultSet.getString("MaSoPhieu");
        }

        // Đóng tất cả các tài nguyên
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return currentProductCode;
}
    
    private String getCurrentProductCodeFromDatabase1() {
    String currentProductCode = null;
    Connection connection;
    try {
        // Kết nối đến cơ sở dữ liệu
        String jdbcUrl = "jdbc:sqlserver://localhost;databaseName=SUPERDuAn1;encrypt=false;trustservercertificate=true";
        String username = "sa";
        String password = "123";

        connection = DriverManager.getConnection(jdbcUrl, username, password);
        // Tạo truy vấn SQL để lấy mã sản phẩm cuối cùng
        String query = "SELECT TOP 1 MaSoPhieu FROM Phieu_Xuat ORDER BY MaSoPhieu DESC";
        PreparedStatement statement = connection.prepareStatement(query);

        // Thực hiện truy vấn
        ResultSet resultSet = statement.executeQuery();

        // Lấy giá trị của cột MaSP từ kết quả truy vấn
        if (resultSet.next()) {
            currentProductCode = resultSet.getString("MaSoPhieu");
        }

        // Đóng tất cả các tài nguyên
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return currentProductCode;
}
    
    private String incrementProductCode(String currentProductCode) {
        // Tăng mã sản phẩm hiện tại lên 1
        int currentNumber = Integer.parseInt(currentProductCode.substring(2));
        int newNumber = currentNumber + 1;

        // Tạo mã sản phẩm mới
        String newProductCode = "PN" + String.format("%03d", newNumber);

        return newProductCode;
    }

    private String incrementProductCode1(String currentProductCode) {
        // Tăng mã sản phẩm hiện tại lên 1
        int currentNumber = Integer.parseInt(currentProductCode.substring(2));
        int newNumber = currentNumber + 1;

        // Tạo mã sản phẩm mới
        String newProductCode = "PX" + String.format("%03d", newNumber);

        return newProductCode;
    }
    
    void updateDataPhieuNhap(){
       int soLuongPhieuNhap = tblPhieuNhap.getRowCount();
       lblSoLuongPhieuNhap.setText("Tổng số lượng: "+soLuongPhieuNhap);
    }
    
    void updateDataPhieuXuat(){
        int soLuongPhieuXuat = tblPhieuXuat.getRowCount();
        lblSoLuongPhieuXuat.setText("Tổng số lượng: "+soLuongPhieuXuat);
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        Title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSoPhieu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        btnPhieuNhap = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        cboMaKhoPhieuNhap = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnPhieuXuat1 = new javax.swing.JButton();
        btnCapNhat1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnClear1 = new javax.swing.JButton();
        txtMaNV1 = new javax.swing.JTextField();
        txtSoLuong1 = new javax.swing.JTextField();
        txtNgayTao1 = new com.toedter.calendar.JDateChooser();
        txtTenSanPham1 = new javax.swing.JTextField();
        txtMaSoPhieu1 = new javax.swing.JTextField();
        btnBack1 = new javax.swing.JButton();
        cboMaKhoPhieuXuat = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        btnXemNhap = new javax.swing.JButton();
        btnXoaNhap = new javax.swing.JButton();
        lblSoLuongPhieuNhap = new javax.swing.JLabel();
        cboPhieuNhap = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhieuXuat = new javax.swing.JTable();
        btnXoaXuat = new javax.swing.JButton();
        btnXemXuat = new javax.swing.JButton();
        lblSoLuongPhieuXuat = new javax.swing.JLabel();
        cboPhieuXuat = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Title.setBackground(new java.awt.Color(153, 255, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ KHO");

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TitleLayout = new javax.swing.GroupLayout(Title);
        Title.setLayout(TitleLayout);
        TitleLayout.setHorizontalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleLayout.createSequentialGroup()
                .addContainerGap(352, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(301, 301, 301)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TitleLayout.setVerticalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleLayout.createSequentialGroup()
                .addGroup(TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TitleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TitleLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabs.setForeground(new java.awt.Color(255, 0, 255));
        tabs.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("MÃ SỐ PHIẾU:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("TÊN SẢN PHẨM:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("NGÀY TẠO:");

        txtMaSoPhieu.setBackground(new java.awt.Color(204, 255, 255));
        txtMaSoPhieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("MÃ KHO:");

        btnCapNhat.setBackground(new java.awt.Color(0, 255, 255));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 255, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("SỐ LƯỢNG:");

        txtSoLuong.setBackground(new java.awt.Color(204, 255, 255));
        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtNgayTao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("NGƯỜI TẠO:");

        txtMaNV.setBackground(new java.awt.Color(204, 255, 255));
        txtMaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        txtTenSanPham.setBackground(new java.awt.Color(204, 255, 255));
        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnPhieuNhap.setBackground(new java.awt.Color(0, 255, 255));
        btnPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPhieuNhap.setText("THÊM PHIẾU NHẬP");
        btnPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuNhapActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 255, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("LÀM MỚI");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 255, 255));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("Về trang chủ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cboMaKhoPhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K001", "K002" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(btnPhieuNhap)
                        .addGap(36, 36, 36)
                        .addComponent(btnCapNhat)
                        .addGap(27, 27, 27)
                        .addComponent(btnXoa)
                        .addGap(28, 28, 28)
                        .addComponent(btnClear)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(cboMaKhoPhieuNhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(2, 2, 2))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cboMaKhoPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPhieuNhap)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        tabs.addTab("NHẬP PHIẾU NHẬP", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("MÃ SỐ PHIẾU:");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("TÊN SẢN PHẨM:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("NGÀY TẠO:");

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("SỐ LƯỢNG:");

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("MÃ KHO:");

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("NGƯỜI TẠO:");

        btnPhieuXuat1.setBackground(new java.awt.Color(0, 255, 255));
        btnPhieuXuat1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPhieuXuat1.setText("THÊM PHIẾU XUẤT");
        btnPhieuXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuXuat1ActionPerformed(evt);
            }
        });

        btnCapNhat1.setBackground(new java.awt.Color(0, 255, 255));
        btnCapNhat1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhat1.setText("CẬP NHẬT");
        btnCapNhat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhat1ActionPerformed(evt);
            }
        });

        btnXoa1.setBackground(new java.awt.Color(0, 255, 255));
        btnXoa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa1.setText("XÓA");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnClear1.setBackground(new java.awt.Color(0, 255, 255));
        btnClear1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear1.setText("LÀM MỚI");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        txtMaNV1.setBackground(new java.awt.Color(204, 255, 255));
        txtMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaNV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNV1ActionPerformed(evt);
            }
        });

        txtSoLuong1.setBackground(new java.awt.Color(204, 255, 255));
        txtSoLuong1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtNgayTao1.setBackground(new java.awt.Color(255, 255, 255));

        txtTenSanPham1.setBackground(new java.awt.Color(204, 255, 255));
        txtTenSanPham1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtMaSoPhieu1.setBackground(new java.awt.Color(204, 255, 255));
        txtMaSoPhieu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnBack1.setBackground(new java.awt.Color(0, 255, 255));
        btnBack1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack1.setText("Về trang chủ");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        cboMaKhoPhieuXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K001", "K002" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnPhieuXuat1)
                        .addGap(37, 37, 37)
                        .addComponent(btnCapNhat1)
                        .addGap(27, 27, 27)
                        .addComponent(btnXoa1)
                        .addGap(26, 26, 26)
                        .addComponent(btnClear1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(2, 2, 2))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSoPhieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoLuong1)
                                    .addComponent(txtNgayTao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaNV1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addComponent(cboMaKhoPhieuXuat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(btnBack1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaSoPhieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack1))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTenSanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtNgayTao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cboMaKhoPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPhieuXuat1)
                    .addComponent(btnCapNhat1)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        tabs.addTab("NHẬP PHIẾU XUẤT", jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SỐ PHIẾU", "TÊN SẢN PHẨM", "NGÀY TẠO", "SỐ LƯỢNG", "MÃ KHO", "MÃ NHÂN VIÊN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        btnXemNhap.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXemNhap.setText("XEM CHI TIẾT");
        btnXemNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemNhapActionPerformed(evt);
            }
        });

        btnXoaNhap.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXoaNhap.setText("XÓA");
        btnXoaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhapActionPerformed(evt);
            }
        });

        lblSoLuongPhieuNhap.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblSoLuongPhieuNhap.setText("0");

        cboPhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhieuNhapActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Lọc theo ngày:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSoLuongPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaNhap))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoLuongPhieuNhap)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXemNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH PHIẾU NHẬP", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblPhieuXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SỐ PHIẾU", "TÊN SẢN PHẨM", "NGÀY TẠO", "SỐ LƯỢNG", "MÃ KHO", "MÃ NHÂN VIÊN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPhieuXuat.getTableHeader().setReorderingAllowed(false);
        tblPhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPhieuXuatMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhieuXuat);

        btnXoaXuat.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXoaXuat.setText("XÓA");
        btnXoaXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXuatActionPerformed(evt);
            }
        });

        btnXemXuat.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXemXuat.setText("XEM CHI TIẾT");
        btnXemXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemXuatActionPerformed(evt);
            }
        });

        lblSoLuongPhieuXuat.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblSoLuongPhieuXuat.setText("0");

        cboPhieuXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhieuXuatActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Lọc theo ngày:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblSoLuongPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemXuat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaXuat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXemXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblSoLuongPhieuXuat)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnXoaXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabs.addTab("DANH SÁCH PHIẾU XUẤT", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        deletePhieuNhap();
        clear();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXemNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemNhapActionPerformed
          this.xemChiTietNhap(); 
    }//GEN-LAST:event_btnXemNhapActionPerformed

    private void btnXoaXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXuatActionPerformed
        deletePhieuXuatTable();
    }//GEN-LAST:event_btnXoaXuatActionPerformed

    private void btnXoaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhapActionPerformed
        deletePhieuNhapTable();
    }//GEN-LAST:event_btnXoaNhapActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);       
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            fillToTablePhieuNhap();
            fillToTablePhieuXuat();
        } catch (SQLException ex) {
            Logger.getLogger(QLKho.class.getName()).log(Level.SEVERE, null, ex);
        }
       fillComBoPhieuXuat();
       fillComBoPhieuNhap();
       tblPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(150);
       tblPhieuXuat.getColumnModel().getColumn(1).setPreferredWidth(150);
       for (int i = 0; i < tblPhieuNhap.getRowCount(); i++) {
            tblPhieuNhap.setRowHeight(i,50);
       }
        for (int i = 0; i < tblPhieuXuat.getRowCount(); i++) {
            tblPhieuXuat.setRowHeight(i,50);
        }
        txtMaSoPhieu.setText(generateNewProductCode());
        txtMaSoPhieu.setEditable(false);
        txtMaSoPhieu1.setText(generateNewProductCode1());
        txtMaSoPhieu1.setEditable(false);
        txtNgayTao.setDate(new Date());
        txtNgayTao1.setDate(new Date());
    }//GEN-LAST:event_formWindowOpened

    private void tblPhieuNhapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMousePressed
        if(evt.getClickCount()==2){
            this.index = tblPhieuNhap.rowAtPoint(evt.getPoint());
            if(this.index>=0){
                this.editPhieuNhap();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblPhieuNhapMousePressed

    private void tblPhieuXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuXuatMousePressed
        if(evt.getClickCount()==2){
            this.index = tblPhieuXuat.rowAtPoint(evt.getPoint());
            if(this.index>=0){
                this.editPhieuXuat();
                tabs.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_tblPhieuXuatMousePressed

    private void btnXemXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemXuatActionPerformed
        xemChiTietXuat();
    }//GEN-LAST:event_btnXemXuatActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        updatePhieuNhap();
        clear();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapActionPerformed
        if(txtTenSanPham.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Không được để trống tên sản phẩm bạn nhé ^^");
                return;
            } 
        if(txtSoLuong.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Không được để trống số lượng bạn nhé ^^");
                return;
            }
        if (!isValidSoLuong(txtSoLuong.getText())){
                JOptionPane.showMessageDialog(this, "Nhập số bạn nhé ^^");
                return;
            }
        
        else{
            insertPhieuNhap();
        }
        
    }//GEN-LAST:event_btnPhieuNhapActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cboPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhieuNhapActionPerformed
        
        try {
            fillToTablePhieuNhap();
            updateDataPhieuNhap();
        } catch (SQLException ex) {
            Logger.getLogger(QLKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < tblPhieuNhap.getRowCount(); i++) {
            tblPhieuNhap.setRowHeight(i,50);
       }
    }//GEN-LAST:event_cboPhieuNhapActionPerformed

    private void cboPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhieuXuatActionPerformed
        try {
            fillToTablePhieuXuat();
            updateDataPhieuXuat();
        } catch (SQLException ex) {
            Logger.getLogger(QLKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < tblPhieuXuat.getRowCount(); i++) {
            tblPhieuXuat.setRowHeight(i,50);
        }     
    }//GEN-LAST:event_cboPhieuXuatActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        trangchu tt = new trangchu();
        tt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        trangchu tt = new trangchu();
        tt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        clear1();
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void btnCapNhat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhat1ActionPerformed
        updatePhieuXuat();
        clear1();
    }//GEN-LAST:event_btnCapNhat1ActionPerformed

    private void txtMaNV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNV1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNV1ActionPerformed

    private void btnPhieuXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuXuat1ActionPerformed
        if(txtTenSanPham1.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Không được để trống tên sản phẩm bạn nhé ^^");
                return;
            } 
        if(txtSoLuong1.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Không được để trống số lượng bạn nhé ^^");
                return;
            }
        if (!isValidSoLuong(txtSoLuong1.getText())){
                JOptionPane.showMessageDialog(this, "Nhập số bạn nhé ^^");
                return;
            }
        
        else{
            insertPhieuXuat();
        }

    }//GEN-LAST:event_btnPhieuXuat1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        deletePhieuXuat();
        clear1();
    }//GEN-LAST:event_btnXoa1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Title;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCapNhat1;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnPhieuNhap;
    private javax.swing.JButton btnPhieuXuat1;
    private javax.swing.JButton btnXemNhap;
    private javax.swing.JButton btnXemXuat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXoaNhap;
    private javax.swing.JButton btnXoaXuat;
    private javax.swing.JComboBox<String> cboMaKhoPhieuNhap;
    private javax.swing.JComboBox<String> cboMaKhoPhieuXuat;
    private javax.swing.JComboBox<String> cboPhieuNhap;
    private javax.swing.JComboBox<String> cboPhieuXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSoLuongPhieuNhap;
    private javax.swing.JLabel lblSoLuongPhieuXuat;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTable tblPhieuXuat;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNV1;
    private javax.swing.JTextField txtMaSoPhieu;
    private javax.swing.JTextField txtMaSoPhieu1;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private com.toedter.calendar.JDateChooser txtNgayTao1;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenSanPham1;
    // End of variables declaration//GEN-END:variables
}
