/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.LichLamViecDAO;
import Object.LichLamViec1;
import Util.Auth;
import java.awt.*;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author phong
 */
public class Schedule extends javax.swing.JFrame {
    
    int index =0;
    LichLamViec1 llv = new LichLamViec1();
    LichLamViecDAO llvDAO = new LichLamViecDAO();
    
    Color defaultcolor, hovercolor;
    String header[] = {"MaLich", "TenNV", "Ngày làm việc ", "Ca làm ", "Thời gian làm việc", "MaNV"};
    DefaultTableModel modeltbl = new DefaultTableModel(header, 0);

    public Schedule() {
        initComponents();
        tblLich.getTableHeader().setDefaultRenderer(new HeaderColor());
        innit();
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-24 (1).png")));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-24 (1).png")));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24 (1).png")));
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24 (1).png"))); 
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-clear-24.png")));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-back-24.png")));
    }

    void fillToTableLich(){
        DefaultTableModel model = (DefaultTableModel) tblLich.getModel();
        model.setRowCount(0);
        try {
            List<LichLamViec1> list = llvDAO.selectAll();
            for (LichLamViec1 llv : list) {
                Object[] row = {
                    llv.getMaLichLamViec(),
                    llv.getMaNV(),
                    llv.getTenNV(),
                    llv.getNgayLamViec(),
                    llv.getCaLamViec(),
                    llv.getThoiGianLamViec(),
                    llv.getMaNV()
                };
                model.addRow(row);
            }
            
        } catch (Exception e) {
        }
    }
    
    void setModelLichLamViec(LichLamViec1 model){
        txtName.setText(model.getTenNV());
        Date ngay = model.getNgayLamViec();
        txtDate.setDate(ngay);
        
        cboCaLam.setSelectedItem(String.valueOf(model.getCaLamViec()));
        txtTime.setText(model.getThoiGianLamViec());
        txtMaNV.setText(model.getMaNV());
        txtID.setText(model.getMaLichLamViec());
    }
    
    LichLamViec1 getModelLichLamViec(){
        LichLamViec1 model = new LichLamViec1();
        model.setMaLichLamViec(txtID.getText());
        model.setTenNV(txtName.getText());
        Date ngay = txtDate.getDate();
        model.setNgayLamViec(ngay);
        
        String selectedValue = (String) cboCaLam.getSelectedItem();
        int caLamViec = Integer.parseInt(selectedValue);
        model.setCaLamViec(caLamViec);
        
        model.setThoiGianLamViec(txtTime.getText());
        model.setMaNV(txtMaNV.getText());
        return model;
    }
    
    void edit(){
        index = tblLich.getSelectedRow();
        try {
            String id = (String) tblLich.getValueAt(this.index, 0);
            LichLamViec1 model = llvDAO.findById(id);
            this.setModelLichLamViec(model);
            setStatus(false);
        } catch (Exception e) {
            
        }
    }
    
    void clear(){
        txtID.setText(generateNewProductCode());
        txtName.setText("");
        txtDate.setDate(new Date());
        cboCaLam.setSelectedIndex(0);
        txtTime.setText("8:00 - 12:00");
        setStatus(true);
    }
    
    void setStatus(boolean status){
        btnThem.setEnabled(status);
        btnCapNhat.setEnabled(!status);
        btnXoa1.setEnabled(!status);
    }
    
    void insert(){
        LichLamViec1 model = getModelLichLamViec();
        try {
            llvDAO.insertPhieuNhap(model);
            this.fillToTableLich();
            JOptionPane.showMessageDialog(this, "Thêm thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !");
            e.printStackTrace();
        }
    }
    
    void update(){
        LichLamViec1 model = getModelLichLamViec();
        try {
            llvDAO.updatePhieuNhap(model);
            this.fillToTableLich();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void delete(){
        LichLamViec1 model = getModelLichLamViec();
        try {
            int index = tblLich.getSelectedRow();
            String maLich = (String) tblLich.getValueAt(index, 0);
            llvDAO.deletePhieuNhap(maLich);
            this.fillToTableLich();
            JOptionPane.showMessageDialog(this, "Xóa thành công !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void delete1(){
        LichLamViec1 model = getModelLichLamViec();
        String maLich = txtID.getText();
        try {
            llvDAO.deletePhieuNhap(maLich);
            this.fillToTableLich();
            JOptionPane.showMessageDialog(this, "Xóa thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại !");
            e.printStackTrace();
        }
    }
    

    public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);

            setBackground(new java.awt.Color(255, 128, 0));

            return this;
        }

    }

    public String generateNewProductCode() {
        String currentProductCode = getCurrentProductCodeFromDatabase();
        String newProductCode = incrementProductCode(currentProductCode);
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
        String query = "SELECT TOP 1 MaLichLamViec FROM Lich_Lam_Viec ORDER BY MaLichLamViec DESC";
        PreparedStatement statement = connection.prepareStatement(query);

        // Thực hiện truy vấn
        ResultSet resultSet = statement.executeQuery();

        // Lấy giá trị của cột MaSP từ kết quả truy vấn
        if (resultSet.next()) {
            currentProductCode = resultSet.getString("MaLichLamViec");
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
    // Kiểm tra xem mã sản phẩm có đúng định dạng không (chẳng hạn "LLV01")
    if (currentProductCode.matches("LLV\\d{2}")) {
        // Lấy số từ mã sản phẩm hiện tại
        int currentNumber = Integer.parseInt(currentProductCode.substring(3));

        // Tăng số lên 1
        int newNumber = currentNumber + 1;

        // Tạo mã sản phẩm mới
        String newProductCode = "LLV" + String.format("%02d", newNumber);

        return newProductCode;
    } else {
        // Trả về null hoặc giá trị mặc định tùy thuộc vào yêu cầu của bạn
        return null;
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboCaLam = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLich = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1048, 725));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setText("Quản Lý Lịch Làm Việc");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 440, 30));

        tabs.setBackground(new java.awt.Color(32, 136, 203));
        tabs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setText("Tên NV");

        jLabel3.setText("Ngày làm việc");

        jLabel4.setText("Ca Làm Việc");

        jLabel5.setText("Thời Gian Làm Việc");

        jLabel6.setText("Mã NV");

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CHI TIẾT");
        jLabel1.setOpaque(true);

        cboCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        jLabel7.setText("Mã lịch:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName)
                                .addComponent(txtTime)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                .addComponent(cboCaLam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(102, 102, 102))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnXoa1)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnClear)
                    .addComponent(btnXoa1))
                .addContainerGap())
        );

        tabs.addTab("Chỉnh sửa", jPanel4);

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tblLich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã lịch làm việc", "Tên nhân viên", "Ngày làm việc", "Ca làm việc", "Thời gian làm việc", "Mã nhân viên"
            }
        ));
        tblLich.setRowHeight(25);
        tblLich.setSelectionBackground(new java.awt.Color(255, 0, 128));
        tblLich.setShowGrid(false);
        tblLich.setShowHorizontalLines(true);
        tblLich.getTableHeader().setReorderingAllowed(false);
        tblLich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblLichMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblLich);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoa)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabs.addTab("Danh Sách", jPanel5);

        jPanel1.add(tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 690, 570));

        btnBack.setText("Về trang chủ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fillToTableLich();
        
        cboCaLam.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // Kiểm tra xem một mục đã được chọn
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // Lấy giá trị được chọn từ JComboBox
                int setSelected = cboCaLam.getSelectedIndex();

                // Cập nhật giá trị của txtTime dựa trên giá trị được chọn
                if (setSelected==0) {
                    txtTime.setText("8:00 - 12:00");
                } else {
                    txtTime.setText("13:00 - 17:00");
                }
            }
        }
    });
        cboCaLam.setSelectedIndex(0);
        if(cboCaLam.getSelectedIndex()==0){
            txtTime.setText("8:00 - 12:00");
        }
        txtID.setText(generateNewProductCode());
        txtID.setEditable(false);
        txtMaNV.setText(Auth.user.getMaNV());
        txtMaNV.setEditable(false);
        txtTime.setEditable(false);

    }//GEN-LAST:event_formWindowOpened

    private void tblLichMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichMousePressed
        if(evt.getClickCount()==2){
            this.index = tblLich.rowAtPoint(evt.getPoint());
            if(this.index>=0){
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblLichMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(txtName.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Không được để trống tên nhé ^^");
            return;
        }
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dburl="jdbc:sqlserver://localhost;encrypt=true;databaseName=SUPERDuAn1;trustServerCertificate=true;";
        String username="sa";
        String password="123";
        try {
            Connection con = DriverManager.getConnection(dburl, username, password);
            PreparedStatement ps1 = con.prepareStatement("select count(*) from Nhan_Vien where TenNV = ?");
            ps1.setString(1, txtName.getText());
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                int count = rs.getInt(1);
                if(count == 0){
                    JOptionPane.showMessageDialog(this, "Tên nhân viên này không tồn tại ! ^^");
                    return;
                }
            }
        } catch (Exception e) {
        }
        insert();
        clear();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        update();
        clear();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        delete1();
        clear();
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        trangchu tt = new trangchu();
        tt.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Schedule().setVisible(true);
            }
        });
    }

    public void innit() {
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0));

        Font lblforn = new Font("Tahoma", Font.PLAIN, 19);
        lblTitle.setFont(lblforn);
        Font lblforn3 = new Font("Tahoma", Font.PLAIN, 16);
        Font lblforn2 = new Font("Tahoma", Font.PLAIN, 14);



        tblLich.setModel(modeltbl);
        JTableHeader th = tblLich.getTableHeader();
        th.setPreferredSize(new Dimension(40, 40));
        tblLich.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblLich.getTableHeader().setForeground(new Color(255, 255, 255));
        tblLich.setRowHeight(40);

        defaultcolor = new Color(32, 136, 203);
        hovercolor = new Color(219, 238, 238);

        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
        
        

    }
    int width = 355;
    int height = 725;

    public void openSideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    
                    try {
                        Thread.sleep(2);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }).start();
    }

    public void closeSideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                   
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JComboBox<String> cboCaLam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblLich;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
