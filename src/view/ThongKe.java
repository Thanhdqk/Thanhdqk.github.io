/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.HoaDonDAO;
import DAO.ThongKeDAO;
import Object.HoaDon;
import Object.HoaDonDT;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author DELL
 */
public class ThongKe extends javax.swing.JFrame {
    HoaDonDAO hdDAO = new HoaDonDAO();
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
    ThongKeDAO tkDAO = new ThongKeDAO();
    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        setLocationRelativeTo(null);

    }

    
void fillComBoBox() {
    try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboThang.getModel();
    model.removeAllElements();
    List<HoaDon> list = hdDAO.selectAll();
    for (HoaDon hd : list) {
        int thang = hd.getNgayDatHang().getMonth() + 1;
        if (model.getIndexOf(thang) < 0) {
            model.addElement(thang);
        }
    }
    if (model.getSize() > 0) {
        cboThang.setSelectedIndex(0);
    }
    cboThang.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // Khi một mục mới được chọn, cập nhật lại dữ liệu
                updateData();
                
            }
        }
    });
    } catch (Exception e) {
        System.out.println("..");
    }

}
     
//    void fillToTableDoanhThu() {
//    DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
//    model.setRowCount(0);
//
//    try {
//        Object selectedValue = cboThang.getSelectedItem();
//        if (selectedValue != null) {
//            
//            int thang = Integer.parseInt(selectedValue.toString());
//            List<Object[]> list = tkDAO.getDoanhThu(thang);
//            for (Object[] objects : list) {
//                model.addRow(objects);
//            }
//        } else {
//            System.out.println("Không có tháng được chọn.");
//        }
//    } catch (NumberFormatException e) {
//        e.printStackTrace(); // Xử lý lỗi chuyển đổi số từ JComboBox
//    }
//}

//    void updateData() {
//    fillToTableDoanhThu();
//    
//    int index = tblDoanhThu.getRowCount();
//    lblTongHoaDon.setText("Tổng số lượng: " + index);
//
//    float tongThanhTien = 0;
//
//    for (int i = 0; i < index; i++) {
//        float thanhTien = Float.parseFloat(tblDoanhThu.getValueAt(i, 2).toString());
//        tongThanhTien += thanhTien;
//    }
//
//    lblTongThanhTien.setText("Tổng thành tiền: " + tongThanhTien);
//}

void fillToTableDoanhThu() {
    DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
    model.setRowCount(0);

    try {
        Object selectedValue = cboThang.getSelectedItem();
        if (selectedValue != null) {
            int thang = Integer.parseInt(selectedValue.toString());
            List<Object[]> list = tkDAO.getDoanhThu(thang);
            for (Object[] objects : list) {
                // Sử dụng đối tượng NumberFormat để chuyển đổi Float thành chuỗi
                Float thanhTienFloat = (Float) objects[2];
                String formattedThanhTien = numberFormat.format(thanhTienFloat);

                // Loại bỏ tất cả các dấu phẩy trong chuỗi trước khi thay thế giá trị cũ
                formattedThanhTien = formattedThanhTien.replaceAll(",", "");

                // Thay thế giá trị cũ trong objects với giá trị được định dạng
                objects[2] = formattedThanhTien;
                model.addRow(objects);
            }
        } else {
            System.out.println("Không có tháng được chọn.");
        }
    } catch (NumberFormatException e) {
        e.printStackTrace(); // Xử lý lỗi chuyển đổi số từ JComboBox
    }
}



void updateData() {
    fillToTableDoanhThu();
    
    int index = tblDoanhThu.getRowCount();
    lblTongHoaDon.setText("Tổng số lượng: " + index);

    float tongThanhTien = 0;

    for (int i = 0; i < index; i++) {
        String formattedThanhTienString = tblDoanhThu.getValueAt(i, 2).toString();

        // Loại bỏ tất cả các dấu phẩy trong chuỗi trước khi chuyển đổi
        formattedThanhTienString = formattedThanhTienString.replaceAll(",", "");

        float thanhTien = Float.parseFloat(formattedThanhTienString);
        tongThanhTien += thanhTien;
    }

    // Format lại số thành tiền
    String formattedTongThanhTien = numberFormat.format(tongThanhTien);

    // Loại bỏ dấu phẩy trong chuỗi trước khi hiển thị
    formattedTongThanhTien = formattedTongThanhTien.replaceAll(",", "");

    lblTongThanhTien.setText("Tổng thành tiền: " + formattedTongThanhTien + "VND");
}






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cboThang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        lblTongHoaDon = new javax.swing.JLabel();
        lblTongThanhTien = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("THỐNG KÊ");

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tháng 5" }));
        cboThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangActionPerformed(evt);
            }
        });

        jLabel2.setText("THÁNG:");

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Tên khách hàng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblDoanhThu);

        lblTongHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongHoaDon.setText("0");

        lblTongThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongThanhTien.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongHoaDon)
                    .addComponent(lblTongThanhTien))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnBack.setText("Về trang chủ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
        fillToTableDoanhThu();
        for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
            tblDoanhThu.setRowHeight(i, 50);
        }
    }//GEN-LAST:event_cboThangActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fillComBoBox();
        fillToTableDoanhThu();
//        int index = tblDoanhThu.getRowCount();
//        lblTongHoaDon.setText("Tổng số lượng: "+index);
//        
//        float tongThanhTien = 0;
//
//        // Lặp qua từng dòng và cộng thêm vào tổng
//        for (int i = 0; i < index; i++) {
//            // Lấy giá trị của cột thứ 2 (index 1)
//            float thanhTien = Float.parseFloat(tblDoanhThu.getValueAt(i, 2).toString());
//
//            // Cộng vào tổng
//            tongThanhTien += thanhTien;
//        }
//        lblTongThanhTien.setText("Tổng thành tiền: "+tongThanhTien);
        updateData();
        for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
            tblDoanhThu.setRowHeight(i, 50);
        }
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-back-24.png")));
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTongHoaDon;
    private javax.swing.JLabel lblTongThanhTien;
    private javax.swing.JTable tblDoanhThu;
    // End of variables declaration//GEN-END:variables
}
