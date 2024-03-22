/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.LoaiSanPhamDAO;
import DAO.SanPhamDAO;
import Object.LoaiSanPham;
import Object.PhieuNhap;
import Object.SanPham1;
import Util.XImage;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import Util.DatabaseKho;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class QlSanPham extends javax.swing.JFrame {
    SanPhamDAO spDAO = new SanPhamDAO();
    LoaiSanPhamDAO lspDAO = new LoaiSanPhamDAO();
    
    int index = 0;
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
    //JFileChooser fileChooser = new JFileChooser("C:\\Users\\DELL\\Documents\\DuAn1\\Loi_27_11\\SIEUDUAN (1)\\src\\icon");
    String userDir = System.getProperty("user.dir");
    JFileChooser fileChooser = new JFileChooser(userDir + "\\icon");
    //JFileChooser fileChooser = new JFileChooser(getClass().getResource("/icon").getFile());
    /**
     * Creates new form QlSanPham
     */
    public QlSanPham() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
//        jButton1.setIcon(new javax.swing.ImageIcon("src/icon/output-onlinegiftools (5).gif"));
//        jLabel8.setIcon(new javax.swing.ImageIcon("src/icon/icons8-x-25.png"));
        fillTableSanPham();
        tblSanPham.getColumnModel().getColumn(8).setCellRenderer(new ImageRender());
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-24 (1).png")));
        btnXoaBenPhai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24 (1).png")));
        btnXoaBenTrai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24 (1).png")));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-back-24.png")));
    }
        private class ImageRender extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            String photoName = value.toString();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/icon/"+photoName)).getImage().
                    getScaledInstance(80,50, Image.SCALE_DEFAULT));
            return new JLabel(imageIcon);
        }
    }
    
    void fillTableSanPhamTimKiem(){
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        String keyWord = txtTimKiem.getText().trim();
        
        try {
           List<SanPham1> list;

        if (!keyWord.isEmpty()) {
            // Nếu từ khóa tìm kiếm không rỗng, thực hiện tìm kiếm theo mã sản phẩm
            SanPham1 foundProduct = spDAO.findById(keyWord);
            SanPham1 foundName = spDAO.timTheoTen(keyWord);

            list = new ArrayList<>();

            if (foundProduct != null) {
                list.add(foundProduct);
            }

            if (foundName != null) {
                list.add(foundName);
            }
        } else {
            // Nếu từ khóa tìm kiếm rỗng, lấy toàn bộ danh sách sản phẩm
            list = spDAO.selectAll();
        }

            for (SanPham1 sp : list) {
                Object[] row = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    numberFormat.format(sp.getGia()),
                    sp.getNgayNhapHang(),
                    sp.getTrangThai(),
                    sp.getMaLoai(),
                    sp.getMaKho(),
                    sp.getHinhAnh()
                };
                model.addRow(row);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tblSanPham.getRowCount(); i++) {
            tblSanPham.setRowHeight(i,50);
        }
    }
    
    private void fillTableSanPham() {
    DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();

    // Lấy tên loại sản phẩm từ combobox
    Object selectedLoaiSanPhamObj = cboLoaiSanPham.getSelectedItem();

    if (selectedLoaiSanPhamObj != null) {
        String selectedLoaiSanPham = selectedLoaiSanPhamObj.toString();

        // Lấy dữ liệu từ bảng San_Pham dựa trên tên loại sản phẩm đã chọn
        // và cập nhật dữ liệu trên table
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;encrypt=true;databaseName=SUPERDuAn1;user=sa;password=123;encrypt=false")) {
            String sql = "SELECT * FROM San_Pham WHERE Maloai = (SELECT Maloai FROM Loai_SanPham WHERE TenLoai = ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, selectedLoaiSanPham);
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Xóa dữ liệu hiện tại trong table
                    model.setRowCount(0);
                    // Thêm dữ liệu mới từ result set vào table model
                    while (resultSet.next()) {
                        Vector<Object> row = new Vector<>();
                        row.add(resultSet.getString("MaSP"));
                        row.add(resultSet.getString("TenSP"));
                        row.add(resultSet.getInt("SoLuong"));
                        //row.add(resultSet.getFloat("Gia"));
                        float gia = resultSet.getFloat("Gia");
                        row.add(numberFormat.format(gia));
                        row.add(resultSet.getDate("NgayNhapHang"));
                        row.add(resultSet.getString("TrangThai"));
                        row.add(resultSet.getString("Maloai"));
                        row.add(resultSet.getString("MaKho"));
                        row.add(resultSet.getString("HinhAnh"));
                        model.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tblSanPham.getRowCount(); i++) {
            tblSanPham.setRowHeight(i,50);
        }
    }
}


    private void fillComboBoxData() {
        cboLoaiSanPham.removeAllItems();
        // Lấy dữ liệu từ bảng Loai_SanPham và thêm vào combobox
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SUPERDuAn1;user=sa;password=123;encrypt=false")) {
            String sql = "SELECT TenLoai FROM Loai_SanPham";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cboLoaiSanPham.addItem(resultSet.getString("TenLoai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    void setModel(SanPham1 model){
        txtMaSanPham.setText(model.getMaSP());
        txtTenSanPham.setText(model.getTenSP());
        txtSoLuong.setText(String.valueOf(model.getSoLuong()));
        String formattedGia = numberFormat.format(model.getGia());
        txtGia.setText(formattedGia);
        Date ngayTao = model.getNgayNhapHang();
        txtNgay.setDate(ngayTao);
        txtTrangThai.setText(model.getTrangThai());
        txtMaLoai.setText(model.getMaLoai());
        txtMaKho.setText(model.getMaKho());
        //lblHinhAnh.setIcon(XImage.read(model.getHinhAnh()));
            lblHinhAnh.setToolTipText(model.getHinhAnh());
    if(model.getHinhAnh()!= null){
        lblHinhAnh.setIcon(XImage.read(model.getHinhAnh())); 
    }
    }
    
    SanPham1 getModel(){
        
        SanPham1 model = new SanPham1();
        model.setMaSP(txtMaSanPham.getText());
        model.setTenSP(txtTenSanPham.getText());
        model.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        try {
            double gia = numberFormat.parse(txtGia.getText()).doubleValue();
            model.setGia(gia);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date ngayTao = txtNgay.getDate();
        model.setNgayNhapHang(ngayTao);
        model.setTrangThai(txtTrangThai.getText());
        model.setMaLoai(txtMaLoai.getText());
        model.setMaKho(txtMaKho.getText());
        model.setHinhAnh(lblHinhAnh.getToolTipText());
        return model;
    }

    void edit(){
        try {
            String maSP = (String) tblSanPham.getValueAt(this.index, 0);
            SanPham1 model = spDAO.findById(maSP);
            if(model!=null){
                this.setModel(model);
                ImageIcon img = XImage.read(model.getHinhAnh());
                lblHinhAnh.setIcon(scaleImageIcon(img, lblHinhAnh.getWidth(), lblHinhAnh.getHeight()));
            }
        } catch (Exception e) {
        } 
    }
    
     
 private ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
    Image img = icon.getImage();
    Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
}
    
    void update(){
        SanPham1 model = getModel();
        try {
            spDAO.update(model);
            fillTableSanPham();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại !");
            e.printStackTrace();
        }
    }
    
    
    void selectImage() {
    if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
        File file = fileChooser.getSelectedFile();
    if(XImage.saveLogo(file)){
    // Hiển thị hình lên form
        lblHinhAnh.setIcon(XImage.read(file.getName()));
        lblHinhAnh.setToolTipText(file.getName());
    }
    }
 }

//    void fillComBoSanPham(){
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiSanPham.getModel();
//        model.removeAllElements();
//        List<LoaiSanPham> list = lspDAO.selectAll();
//        for (LoaiSanPham lsp : list) {           
//            model.addElement(lsp.getTenLoai());
//        }
//        cboLoaiSanPham.setSelectedIndex(0);
//    }
    
    void xoaBenPhai(){
                index = tblSanPham.getSelectedRow();
        String maSanPham = (String) tblSanPham.getValueAt(index, 0);
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
            return;
    }
        try {
            spDAO.delete(maSanPham);
            
            // Cập nhật lại bảng
            DefaultTableModel model1 = (DefaultTableModel) tblSanPham.getModel();
            model1.removeRow(index);
            fillTableSanPham();
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thất bại");
            e.printStackTrace();
        }
        
    }
    
    void xoaBenTrai(){
        SanPham1 model = getModel();
        String maSP = txtMaSanPham.getText();
        try {
            spDAO.delete(maSP);
            fillTableSanPham();
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thất bại !");
        }
    }
    
    void clear(){
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");
        txtSoLuong.setText("");
        txtGia.setText("");
        txtTrangThai.setText("");
        txtNgay.setDate(new Date());
        txtMaKho.setText("");
        txtMaLoai.setText("");
        lblHinhAnh.setIcon(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblHinhAnh = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        txtMaLoai = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMaKho = new javax.swing.JTextField();
        txtNgay = new com.toedter.calendar.JDateChooser();
        btnChinhSua = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnXoaBenTrai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cboLoaiSanPham = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnXoaBenPhai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Title1.setBackground(new java.awt.Color(153, 255, 102));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUẢN LÝ SẢN PHẨM");

        jLabel8.setBackground(new java.awt.Color(51, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\DuAn1\\DuAn1-master_Phat\\DuAn1-master\\src\\icon\\icons8-x-25.png")); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Title1Layout = new javax.swing.GroupLayout(Title1);
        Title1.setLayout(Title1Layout);
        Title1Layout.setHorizontalGroup(
            Title1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Title1Layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(309, 309, 309)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Title1Layout.setVerticalGroup(
            Title1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Title1Layout.createSequentialGroup()
                .addGroup(Title1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Title1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Title1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabs.setForeground(new java.awt.Color(255, 0, 255));
        tabs.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Mã sản phẩm:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Tên sản phẩm:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Số lượng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("Giá:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Ngày nhập hàng:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("Trạng thái:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("Mã loại:");

        lblHinhAnh.setForeground(new java.awt.Color(255, 0, 51));
        lblHinhAnh.setText("Hình ảnh");
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhAnhMousePressed(evt);
            }
        });

        txtMaSanPham.setBackground(new java.awt.Color(204, 255, 255));
        txtMaSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtTenSanPham.setBackground(new java.awt.Color(204, 255, 255));
        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtSoLuong.setBackground(new java.awt.Color(204, 255, 255));
        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtGia.setBackground(new java.awt.Color(204, 255, 255));
        txtGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtTrangThai.setBackground(new java.awt.Color(204, 255, 255));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtMaLoai.setBackground(new java.awt.Color(204, 255, 255));
        txtMaLoai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("Mã kho:");

        txtMaKho.setBackground(new java.awt.Color(204, 255, 255));
        txtMaKho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnChinhSua.setBackground(new java.awt.Color(0, 255, 255));
        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnBack.setText("Về trang chủ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnXoaBenTrai.setBackground(new java.awt.Color(0, 255, 255));
        btnXoaBenTrai.setText("Xóa");
        btnXoaBenTrai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBenTraiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnChinhSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaBenTrai, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtMaKho, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaLoai, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaBenTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật sản phẩm", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "GIÁ", "NGÀY NHẬP HÀNG", "TRẠNG THÁI", "MÃ LOẠI", "MÃ KHO", "HÌNH ẢNH"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanPhamMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Tìm kiếm:");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\DuAn1\\DuAn1-master_Phat\\DuAn1-master\\src\\icon\\output-onlinegiftools (5).gif")); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cboLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSanPhamActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Lọc theo loại:");

        btnXoaBenPhai.setText("Xóa");
        btnXoaBenPhai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBenPhaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaBenPhai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnXoaBenPhai)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabs.addTab("Danh sách sản phẩm", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Title1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fillComboBoxData();
        //fillTableSanPham();
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(200);
        for (int i = 0; i < tblSanPham.getRowCount(); i++) {
            tblSanPham.setRowHeight(i,50);
        }
        
        // Cách 2:
//        int[] columnsToSetWidth = {1, 3, 5}; // Các chỉ số của cột bạn muốn đặt chiều rộng
//        int width = 100; // Chiều rộng bạn muốn đặt
//
//        for (int columnIndex : columnsToSetWidth) {
//            tblSanPham.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
//        }
        tblSanPham.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tblSanPham.getTableHeader().setBackground(new Color(0,255,255));
        tblSanPham.getTableHeader().setForeground(new Color(255,0,255));
        tblSanPham.setSelectionBackground(Color.YELLOW);

    }//GEN-LAST:event_formWindowOpened

    private void tblSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMousePressed
        if(evt.getClickCount()==2){
            this.index = tblSanPham.rowAtPoint(evt.getPoint());
            if(this.index>=0){
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblSanPhamMousePressed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        if(txtMaSanPham.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để chỉnh sửa");
            return;
        }
        if(txtTenSanPham.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để chỉnh sửa");
            return;
        }
        if(txtSoLuong.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để chỉnh sửa");
            return;
        }if(txtGia.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để chỉnh sửa");
            return;
        }
        if(txtTrangThai.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để chỉnh sửa");
            return;
        }
        if(txtMaKho.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để chỉnh sửa");
            return;
        }
        if(txtMaLoai.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để chỉnh sửa");
            return;
        }else{
            update();
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void lblHinhAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMousePressed
        selectImage();
    }//GEN-LAST:event_lblHinhAnhMousePressed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        fillTableSanPhamTimKiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cboLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSanPhamActionPerformed
        fillTableSanPham();        
    }//GEN-LAST:event_cboLoaiSanPhamActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        fillTableSanPhamTimKiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        trangchu tt = new trangchu();
        tt.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnXoaBenPhaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBenPhaiActionPerformed
        xoaBenPhai();
    }//GEN-LAST:event_btnXoaBenPhaiActionPerformed

    private void btnXoaBenTraiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBenTraiActionPerformed
        if(txtMaSanPham.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để xóa");
            return;
        }
        if(txtTenSanPham.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để xóa");
            return;
        }
        if(txtSoLuong.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để xóa");
            return;
        }if(txtGia.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để xóa");
            return;
        }
        if(txtTrangThai.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để xóa");
            return;
        }
        if(txtMaKho.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để xóa");
            return;
        }
        if(txtMaLoai.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không có nội dung để xóa");
            return;
        }else{
            xoaBenTrai();
            clear();
        }
        
    }//GEN-LAST:event_btnXoaBenTraiActionPerformed

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
            java.util.logging.Logger.getLogger(QlSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Title1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaBenPhai;
    private javax.swing.JButton btnXoaBenTrai;
    private javax.swing.JComboBox<String> cboLoaiSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaKho;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtMaSanPham;
    private com.toedter.calendar.JDateChooser txtNgay;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
