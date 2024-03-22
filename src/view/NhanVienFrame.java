package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import Object.*;
import Util.*;
import DAO.*;
import java.sql.Connection;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.TabbedPaneUI;

public class NhanVienFrame extends JFrame {
        //JFileChooser fileChooser = new JFileChooser("C:\\Users\\DELL\\Documents\\DuAn1\\Loi_27_11\\SIEUDUAN\\src\\icon");
	private JPanel contentPane;
	private JTextField maso;
	private JTextField name;
	private JTextField email;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField pass;
	private JTextField img;
	private JTable table;
	private JTextField textField;
        DefaultTableModel model;
        JRadioButton rdbtnNewRadioButton, rdbtnN ;
        JComboBox comboBox ;
        NhanVien nv =new NhanVien();
        NhanVienDAO dao = new NhanVienDAO();
        List<NhanVien> list = new  ArrayList();
        JDateChooser date;
        JLabel hinh;
        Connection conn = null;
        PreparedStatement psttm = null;
        Statement sttm=null;
        ResultSet rs =null;
        int index;
        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienFrame frame = new NhanVienFrame();
                                         
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVienFrame() {
            addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				maso.requestFocus(true);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 712);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		          setUndecorated(true);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 67, 1047, 641);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("THÔNG TIN", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MÃ NHÂN VIÊN");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(21, 181, 176));
		lblNewLabel_2.setBounds(333, 21, 164, 32);
		
		panel_1.add(lblNewLabel_2);
		
		maso = new JTextField();
		maso.setBounds(333, 56, 400, 32);
		panel_1.add(maso);
		maso.setColumns(10);
                
                
		
		JLabel lblNewLabel_2_1 = new JLabel("TÊN NHÂN VIÊN");
		lblNewLabel_2_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(333, 99, 164, 32);
		panel_1.add(lblNewLabel_2_1);
		
		
		
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(333, 134, 400, 32);
		panel_1.add(name);
		
		JLabel lblNewLabel_2_2 = new JLabel("GIỚI TÍNH");
		lblNewLabel_2_2.setForeground(new Color(21, 181, 176));
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(333, 177, 164, 32);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("VAI TRÒ");
		lblNewLabel_2_3.setForeground(new Color(21, 181, 176));
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2_3.setBounds(333, 264, 164, 32);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("EMAIL");
		lblNewLabel_2_4.setForeground(new Color(21, 181, 176));
		lblNewLabel_2_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2_4.setBounds(333, 354, 164, 32);
		panel_1.add(lblNewLabel_2_4);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(333, 389, 400, 32);
		panel_1.add(email);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2_5 = new JLabel("NGÀY SINH");
		lblNewLabel_2_5.setForeground(new Color(21, 181, 176));
		lblNewLabel_2_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2_5.setBounds(333, 441, 164, 32);
		panel_1.add(lblNewLabel_2_5);
		
		 rdbtnNewRadioButton = new JRadioButton("NAM");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setForeground(new Color(21, 181, 176));
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		rdbtnNewRadioButton.setForeground(new Color(21, 181, 176));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(333, 227, 86, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		 rdbtnN = new JRadioButton("NỮ");
		rdbtnN.setFont(new Font("Segoe UI", Font.BOLD, 13));
		rdbtnN.setForeground(new Color(21, 181, 176));
		buttonGroup.add(rdbtnN);
		rdbtnN.setBounds(421, 227, 80, 23);
		panel_1.add(rdbtnN);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("MẬT KHẨU");
		lblNewLabel_2_5_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_2_5_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2_5_1.setBounds(333, 527, 164, 32);
		panel_1.add(lblNewLabel_2_5_1);
		
		 date = new JDateChooser();
		date.setBounds(333, 484, 416, 32);
		panel_1.add(date);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NHÂN VIÊN BÁN HÀNG", "NHÂN VIÊN KHO ", "QUẢN LÍ"}));
		comboBox.setBounds(333, 302, 391, 41);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, new Color(255, 0, 0), null));
		panel_2.setBounds(21, 56, 276, 330);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		 hinh = new JLabel("CLICK HERE TO CHOICE IMAGE");
		hinh.setForeground(new Color(0, 0, 255));
		hinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		hinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            String userDir = System.getProperty("user.dir");
                            JFileChooser cc = new JFileChooser(userDir + "\\icon");
				//JFileChooser cc = new JFileChooser("/icon");
				int kq = cc.showOpenDialog(null);
				if(kq ==cc.APPROVE_OPTION)
				{
					img.setText(""+cc.getSelectedFile().getName());
                                        updateaimg(img.getText());
                                        
                                }
    }
				
			
		});
		hinh.setHorizontalAlignment(SwingConstants.CENTER);
		hinh.setBounds(0, 0, 276, 330);
		panel_2.add(hinh);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setBounds(558, 167, 175, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setBounds(558, 87, 175, 14);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setForeground(Color.RED);
		lblNewLabel_4_2.setBounds(558, 422, 175, 14);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("");
		lblNewLabel_4_3.setForeground(Color.RED);
		lblNewLabel_4_3.setBounds(558, 518, 175, 14);
		panel_1.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("");
		lblNewLabel_4_4.setForeground(Color.RED);
		lblNewLabel_4_4.setBounds(558, 594, 175, 14);
		panel_1.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("");
		lblNewLabel_4_2_1.setForeground(Color.RED);
		lblNewLabel_4_2_1.setBounds(64, 398, 175, 14);
		panel_1.add(lblNewLabel_4_2_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-add-36.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(maso.getText().equals(""))
				{
					lblNewLabel_4_1.setText("Chưa nhập mã số");
				}
				else
				{
					lblNewLabel_4_1.setText("");
				}
				if(name.getText().equals(""))
				{
					lblNewLabel_4.setText("Chưa nhập tên");
				}
				else
				{
					lblNewLabel_4.setText("");
				}
				if(email.getText().equals(""))
				{
					lblNewLabel_4_2.setText("Chưa nhập Email");
				}
				else
				{
					lblNewLabel_4_2.setText("");
				}
				if(String.valueOf(date.getDate()).equals(""))
				{
					lblNewLabel_4_3.setText("Chưa nhập Ngày sinh");
				}
				else
				{
					lblNewLabel_4_3.setText("");
				}
				if(String.valueOf(pass.getPassword()).equals(""))
				{
					lblNewLabel_4_4.setText("Chưa nhập Password");
				}
				else
				{
					lblNewLabel_4_3.setText("");
				}
				if(img.getText().equals(""))
				{
					lblNewLabel_4_2_1.setText("Chưa chọn ảnh");
				}
				else
				{
					lblNewLabel_4_2_1.setText("");
				}
				if(!maso.getText().equals("")&&!name.getText().equals("")&&!email.getText().equals("")&&!String.valueOf(date.getDate()).equals("")&&!String.valueOf(pass.getPassword()).equals("")&&!img.getText().equals(""))
				{
					nhanvienmodel();
                                        try {
                                        dao.insert(nv);
                                         JOptionPane.showMessageDialog(null, "INSERT THÀNH CÔNG","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                                         loaddata();
                                    } catch (Exception e1) {
                                          JOptionPane.showMessageDialog(null, "INSERT THẤT BẠI","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                                    }
				}
			}
		});
		btnNewButton.setBounds(855, 56, 89, 58);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-delete-36.png")));
		btnNewButton_1.setBounds(855, 151, 89, 58);
		panel_1.add(btnNewButton_1);
                btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            String ms = maso.getText();
				if(maso.getText().equals(""))
                                {
                                  lblNewLabel_4_1.setText("Chưa nhập mã số");
                                }
                                else{
                                    lblNewLabel_4_1.setText("");
                                    try {
                                        dao.delete(ms);
                                         JOptionPane.showMessageDialog(null, "DELETE THÀNH CÔNG","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                                         loaddata();
                                    } catch (Exception e1) {
                                         JOptionPane.showMessageDialog(null, "DELETE KHÔNG THÀNH CÔNG","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                                    }
                                }
				
			}
		});
               
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-update-36.png")));
		btnNewButton_2.setBounds(855, 238, 89, 58);
		panel_1.add(btnNewButton_2);
                btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(maso.getText().equals(""))
				{
					lblNewLabel_4_1.setText("Chưa nhập mã số");
				}
				else
				{
					lblNewLabel_4_1.setText("");
				}
				if(name.getText().equals(""))
				{
					lblNewLabel_4.setText("Chưa nhập tên");
				}
				else
				{
					lblNewLabel_4.setText("");
				}
				if(email.getText().equals(""))
				{
					lblNewLabel_4_2.setText("Chưa nhập Email");
				}
				else
				{
					lblNewLabel_4_2.setText("");
				}
				if(String.valueOf(date.getDate()).equals(""))
				{
					lblNewLabel_4_3.setText("Chưa nhập Ngày sinh");
				}
				else
				{
					lblNewLabel_4_3.setText("");
				}
				if(String.valueOf(pass.getPassword()).equals(""))
				{
					lblNewLabel_4_4.setText("Chưa nhập Password");
				}
				else
				{
					lblNewLabel_4_3.setText("");
				}
				if(img.getText().equals(""))
				{
					lblNewLabel_4_2_1.setText("Chưa chọn ảnh");
				}
				else
				{
					lblNewLabel_4_2_1.setText("");
				}
				if(!maso.getText().equals("")&&!name.getText().equals("")&&!email.getText().equals("")&&!String.valueOf(date.getDate()).equals("")&&!String.valueOf(pass.getPassword()).equals("")&&!img.getText().equals(""))
				{
					nhanvienmodel();
                                        try {
                                        dao.update(nv);
                                         JOptionPane.showMessageDialog(null, "UPDATE THÀNH CÔNG","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                                         loaddata();
                                    } catch (Exception e1) {
                                          JOptionPane.showMessageDialog(null, "UPDATE THẤT BẠI","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                                          e1.printStackTrace();
                                    }
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-new-36.png")));
		btnNewButton_3.setBounds(855, 333, 89, 58);
		panel_1.add(btnNewButton_3);
                btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maso.setText("");
                                name.setText("");
                                email.setText("");
                                pass.setText("");
                                rdbtnNewRadioButton.setSelected(true);
                                comboBox.setSelectedIndex(0);
                                //date.setCalendar(null);
                                date.setDate(new Date());
                                updateaimg("");
                                
                                
			}
		});
		
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/icon/logo-cua-hang-tien-loi-8-removebg-preview.png")));
		lblNewLabel_5.setBounds(-90, 426, 362, 182);
		panel_1.add(lblNewLabel_5);
		
		pass = new JPasswordField();
		pass.setBounds(333, 562, 400, 32);
		panel_1.add(pass);
		
		img = new JTextField();
		img.setBounds(560, 229, 153, 20);
		panel_1.add(img);
		img.setColumns(10);
		
		
		img.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 255));
		tabbedPane.addTab("DANH SÁCH", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 1031, 461);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00C3 S\u1ED0", "H\u1ECC T\u00CAN ", "GI\u1EDAI T\u00CDNH", " NG\u00C0Y SINH", "VAI TR\u00D2", "EMAIL", "H\u00CCNH \u1EA2NH", "M\u1EACT KH\u1EA8U"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            int index = table.getSelectedRow();
                            maso.setText(String.valueOf(table.getValueAt(index, 0)));
                            name.setText(String.valueOf(table.getValueAt(index, 1)));
                            String gtt = String.valueOf(table.getValueAt(index, 2));
                            if(gtt.equalsIgnoreCase("NAM"))
                            {
                                rdbtnNewRadioButton.setSelected(true);
                            }
                            else
                            {
                                rdbtnN.setSelected(true);
                            }
                           
                             String value = String.valueOf(table.getValueAt(index, 4));
                             if(value.equalsIgnoreCase("Nhân viên bán hàng"))
                             {
                                 comboBox.setSelectedIndex(0);
                             }
                             else if(value.equalsIgnoreCase("Nhân viên kho"))
                             {
                                  comboBox.setSelectedIndex(1);
                             }
                             else{
                                  comboBox.setSelectedIndex(2);
                             }
                            email.setText(String.valueOf(table.getValueAt(index, 5)));
//                            date.setDate((Date) table.getValueAt(index, 4));
                            pass.setText(String.valueOf(table.getValueAt(index, 7)));
                            String imgg = String.valueOf(table.getValueAt(index, 6));
                            updateaimg(imgg);
                            img.setText(imgg);
                             date.setDate((Date)table.getValueAt(index, 3));
                            tabbedPane.setSelectedIndex(0);
			}
		});
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(222, 11, 523, 57);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 406, 35);
		panel_3.add(textField);
		textField.setColumns(10);
                textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				if(textField.getText().equals(""))
				{
					loaddata();
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				conn =Database.connection();
				try
				{
				String sql = "select * from Nhan_vien where MaNV like CONCAT( '%',?,'%') or "
						+ "Tennv like CONCAT( '%',?,'%')  ";
				PreparedStatement ps = conn.prepareStatement(sql);
				for (int i = 0; i < 2; i++) {
					ps.setObject(i + 1, textField.getText());
				}

				ResultSet rs = ps.executeQuery();
				list.clear();

				while (rs.next()) {
					NhanVien entity = new NhanVien();
					entity.setMaNV(rs.getString("MaNV"));
					entity.setTenNV(rs.getString("TenNV"));
					entity.setGioiTinh(rs.getString("Gioitinh"));
					entity.setNgaySinh(rs.getDate("Ngaysinh"));
					entity.setVaiTro(rs.getString("Vaitro"));
					entity.setEmail(rs.getString("Email"));
                                        entity.setHinh(rs.getString("Hinh"));
                                        entity.setMatKhau(rs.getString("Matkhau"));
					
					list.add(entity);
				}
				model.setRowCount(0);
				for (NhanVien nguoiHoc : list) {
					model.addRow(new Object[] { nguoiHoc.getMaNV(), nguoiHoc.getTenNV(), nguoiHoc.getGioiTinh(),
							nguoiHoc.getNgaySinh() , nguoiHoc.getVaiTro(), nguoiHoc.getEmail(),
							nguoiHoc.getHinh(), nguoiHoc.getMatKhau() });
				}}
				catch  (Exception e2) {
					e2.printStackTrace();
				
				}
				

			} 
			 			
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnNewButton_4 = new JButton("SEARCH");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.setBounds(426, 11, 89, 35);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(getClass().getResource("/icon/first.png")));
		btnNewButton_5.setBounds(798, 465, 89, 51);
		panel_1.add(btnNewButton_5);
                 btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=0;
                                display(index);
                                
                                
			}
		});
		
		JButton btnNewButton_5_1 = new JButton("");
		btnNewButton_5_1.setIcon(new ImageIcon(getClass().getResource("/icon/back.png")));
		btnNewButton_5_1.setBounds(798, 543, 89, 51);
		panel_1.add(btnNewButton_5_1);
                btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
                                if(index<0)
                                {
                                    index = list.size()-1;
                                }
                                display(index);
                                
                                
			}
		});
		
		JButton btnNewButton_5_2 = new JButton("");
		btnNewButton_5_2.setIcon(new ImageIcon(getClass().getResource("/icon/next.png")));
		btnNewButton_5_2.setBounds(911, 543, 89, 51);
		panel_1.add(btnNewButton_5_2);
                btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
                                if(index>list.size()-1)
                                {
                                    index=0;
                                }
                                display(index);
                                
                                
			}
		});
		
		JButton btnNewButton_5_3 = new JButton("");
		btnNewButton_5_3.setIcon(new ImageIcon(getClass().getResource("/icon/last.png")));
		btnNewButton_5_3.setBounds(911, 465, 89, 51);
		panel_1.add(btnNewButton_5_3);
                btnNewButton_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=list.size()-1;
                                display(index);
                                
                                
			}
		});
                
                model = (DefaultTableModel)table.getModel();
		
		JLabel lblNewLabel = new JLabel("QUẢN LÍ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(21, 181, 176));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(289, 0, 532, 69);
		contentPane.add(lblNewLabel);
                
               
                
                
		
		table.setAutoResizeMode(   table.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	    table.getColumnModel().getColumn(0).setPreferredWidth(50);
	    table.getColumnModel().getColumn(1).setPreferredWidth(200);
	    table.getColumnModel().getColumn(2).setPreferredWidth(50);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(128, 0, 255), null, null, null));
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 System.exit(0);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-x-25.png")));
		lblNewLabel_1.setBounds(1019, 0, 46, 45);
		contentPane.add(lblNewLabel_1);
                JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            trangchu tt = new trangchu();
                            tt.setVisible(true);
                            dispose();
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-log-out-36.png")));
		lblNewLabel_7.setBounds(10, 0, 56, 46);
		contentPane.add(lblNewLabel_7);
                
                loaddata();
	}
        public void nhanvienmodel()
        {
           String maso1 = maso.getText();
           String name1 = name.getText();  
           String gt;
           if(rdbtnN.isSelected() )
           {
              gt="NỮ"; 
           }
           else{
                 gt="NAM";     
                   }
            String value;
            value =  comboBox.getSelectedItem().toString();
            if(value.equalsIgnoreCase("Nhân viên bán hàng"))
            {
               value = "Nhân viên bán hàng"; 
            }
            else if(value.equalsIgnoreCase("Nhân viên kho"))
            {
                value = "Nhân viên kho"; 
            }
            else{
                value = "Quản lí"; 
            }
            String email1 = email.getText();
            Date gay = date.getDate();
            String pass1 = String.valueOf(pass.getPassword());
            String hinhanh = img.getText();
            
                nv.setMaNV(maso1);
                nv.setTenNV(name1);
                nv.setGioiTinh(gt);
                nv.setVaiTro(value);
                nv.setEmail(email1);
                nv.setNgaySinh(gay);
                nv.setMatKhau(pass1);
                nv.setHinh(hinhanh);
        }
        public void updateaimg(String img)
        {
            ImageIcon ii = new ImageIcon(getClass().getResource("/icon/"+img));
            Image IM = ii.getImage();
            ImageIcon icon = new ImageIcon(IM.getScaledInstance(hinh.getWidth(), hinh.getHeight(), IM.SCALE_SMOOTH));
            hinh.setIcon(icon);
            
        }
        public void loaddata()
        { 
           
           String sql = "select * from Nhan_vien";
            conn = Database.connection();
            model.setRowCount(0);
            try {
                
                sttm = conn.createStatement();
                list.clear();
                rs = sttm.executeQuery(sql);
                
                while(rs.next())
                {
                    NhanVien nvv = new NhanVien();
                     
                    
                    nvv.setMaNV(rs.getString(1));
                    nvv.setTenNV(rs.getString(2));
                    nvv.setGioiTinh(rs.getString(3));
                    nvv.setNgaySinh(rs.getDate(4));
                    nvv.setVaiTro(rs.getString(5));
                    nvv.setEmail(rs.getString(6));
                    nvv.setHinh(rs.getString(7));
                    nvv.setMatKhau(rs.getString(8));
                   
                    list.add(nvv);
                }
                for (NhanVien nhanVien1 : list) {
                    model.addRow(new Object[]{nhanVien1.getMaNV(),nhanVien1.getTenNV(),nhanVien1.getGioiTinh(),nhanVien1.getNgaySinh(),nhanVien1.getVaiTro(),nhanVien1.getEmail(),nhanVien1.getHinh(),nhanVien1.getMatKhau()});
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        public void display(int i)
        {
            NhanVien nvdisplay = list.get(i);
            maso.setText(nvdisplay.getMaNV());
            name.setText(nvdisplay.getTenNV());
            String gtoitinh = nvdisplay.getGioiTinh();
            if(gtoitinh.equalsIgnoreCase("NAM"))
                            {
                                rdbtnNewRadioButton.setSelected(true);
                            }
                            else
                            {
                                rdbtnN.setSelected(true);
                            }
            String value = nvdisplay.getVaiTro();
            if(value.equalsIgnoreCase("Nhân viên bán hàng"))
                             {
                                 comboBox.setSelectedIndex(0);
                             }
                             else if(value.equalsIgnoreCase("Nhân viên kho"))
                             {
                                  comboBox.setSelectedIndex(1);
                             }
                             else{
                                  comboBox.setSelectedIndex(2);
                             }
            email.setText(nvdisplay.getEmail());
            pass.setText(nvdisplay.getMatKhau());
            updateaimg(nvdisplay.getHinh());
            date.setDate((Date)nvdisplay.getNgaySinh());
            
        }
}
