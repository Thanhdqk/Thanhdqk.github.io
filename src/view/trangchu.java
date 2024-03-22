package view;

import Util.Auth;
import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class trangchu extends JFrame {

	private JPanel contentPane;
	JPanel panelmenu;
	JPanel panelcclt;
	Color defaultcolor, clickcolor;
	JPanel panel;
	JPanel panel_2;
	JPanel panel_2_1;
	JPanel panel_2_2;
	JPanel panel_2_3;
	JPanel panel_2_3_1;
	JPanel panel_2_3_2;
	JPanel panel_2_3_3;
	JPanel panel_2_3_3_1;
	JPanel panel_2_3_3_1_1;
	JPanel panel_2_3_3_1_2;
	JPanel panel_2_3_3_1_3;
	JLabel lblNewLabel_10_2;
	JPanel panelsetting;
	double first;
	double second;
	double sum;
	int index=0;
	/**
	 * Launch the application.
	 */
	int width = 229;
	int height = 692;
	int widthst = 416;
	int heightst = 66;
	int withcct =311;
	int heightcct = 394;
	String pheptoan = "";
	private final JLabel lblNewLabel_6 = new JLabel("New label");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trangchu frame = new trangchu();
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
	public trangchu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 692);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		defaultcolor = new Color(25, 118, 211);
		clickcolor = new Color(219, 238, 238);
		
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panelmenu = new JPanel();
		 panelmenu.setBackground(new Color(25, 118, 211));
		panelmenu.setBounds(0, 0, 1, 692);
		contentPane.add(panelmenu);
		panelmenu.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-x-25.png")));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closemenubar();
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel_3.setBounds(233, -11, 46, 49);
		panelmenu.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closemenubar();
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-x-25.png")));
		lblNewLabel_4.setBounds(195, 0, 46, 38);
		panelmenu.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 87, 229, 9);
		panelmenu.add(separator);
		
		 panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(defaultcolor);
			}
		});
		panel.setBounds(0, 119, 229, 43);
		panelmenu.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Trang Chủ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(defaultcolor);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-home-36.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-20, 0, 159, 43);
		
		panel.add(lblNewLabel);
		
		 panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 164, 229, 43);
		panelmenu.add(panel_2);
		panel_2.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				account acc = new account();
                                acc.setVisible(true);
                                setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(defaultcolor);
			}
		});
		
		JLabel lblAccount = new JLabel("     Account");
		lblAccount.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-account-36.png")));
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(defaultcolor);
			}
                        @Override
			public void mouseClicked(MouseEvent e) {
				account acc = new account();
                                acc.setVisible(true);
                                setVisible(false);
			}
		});
		
		lblAccount.setBounds(-20, 0, 159, 43);
		panel_2.add(lblAccount);
		
		 panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(0, 211, 229, 43);
		panelmenu.add(panel_2_1);
		panel_2_1.addMouseListener(new MouseAdapter() {
				@Override
			public void mouseClicked(MouseEvent e) {
				                    try {
                  if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
               else  if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null,"bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY" );
                 }
               else{
                   NhanVienFrame nvv = new NhanVienFrame();
                    nvv.setVisible(true);
                    dispose();
               }
                
            } catch (Exception e1) {
            }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1.setBackground(defaultcolor);
			}
		
		});
		
		JLabel lblNhnVin = new JLabel("    Nhân Viên");
		lblNhnVin.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-conference-36.png")));
		lblNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhnVin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                else if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                            else{
                    NhanVienFrame nvv = new NhanVienFrame();
                    nvv.setVisible(true);
                    dispose();
                   
               }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1.setBackground(defaultcolor);
			}
			
		});
		lblNhnVin.setBounds(-20, 0, 159, 43);
		panel_2_1.add(lblNhnVin);
		
		 panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(0, 259, 229, 43);
		panelmenu.add(panel_2_2);
		panel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                            
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_2.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
              else   if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
         else{
    
               }
			}
		});
		
		JLabel lblThngK = new JLabel("   Thống Kê");
		lblThngK.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-analytics-36.png")));
		lblThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngK.setBounds(-20, 0, 159, 43);
		lblThngK.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_2.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
             else    if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                                else{
                                ThongKe tk = new ThongKe();
                                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(tk);
                                if (currentFrame != null) {
                                    currentFrame.dispose();
                                }
                                tk.setVisible(true);
                                dispose();
               }
			}
		});
		
		panel_2_2.add(lblThngK);
		
		 panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBounds(0, 306, 229, 43);
		panelmenu.add(panel_2_3);
		panel_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
              else   if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                     
                 }
                                else{
                   
               }
			}
		});
		
		JLabel lblSnPhm = new JLabel("    Sản Phẩm");
		lblSnPhm.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-object-36.png")));
		lblSnPhm.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnPhm.setBounds(-20, 0, 159, 43);
		lblSnPhm.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                else if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                     QlSanPham sp = new QlSanPham();
                                    sp.setVisible(true);
                                    dispose();
                     
                 }
                                else{
                                    QlSanPham sp = new QlSanPham();
                                    sp.setVisible(true);
                                    dispose();
               }
			}
		});
		
		panel_2_3.add(lblSnPhm);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-account-45.png")));
		lblNewLabel_1.setBounds(10, 11, 81, 61);
		panelmenu.add(lblNewLabel_1);
		
		 panel_2_3_1 = new JPanel();
		panel_2_3_1.setLayout(null);
		panel_2_3_1.setBounds(0, 352, 229, 43);
		panelmenu.add(panel_2_3_1);
		panel_2_3_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_1.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_1.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
              else   if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                     
                 }
                                else{
                   
               }
			}
		});
		
		JLabel lblSnPhm_1 = new JLabel("     Kho");
		lblSnPhm_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-warehouse-36.png")));
		lblSnPhm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnPhm_1.setBounds(-34, 0, 159, 43);
		panel_2_3_1.add(lblSnPhm_1);
		lblSnPhm_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_1.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_1.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                            if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
              else   if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                     QLKho ql = new QLKho();
                            ql.setVisible(true);
                            dispose();
                 }
                            else{
                            QLKho ql = new QLKho();
                            ql.setVisible(true);
                            dispose();
               }
				
			}
		});
		
		 panel_2_3_2 = new JPanel();
		panel_2_3_2.setLayout(null);
		panel_2_3_2.setBounds(0, 398, 229, 43);
		panelmenu.add(panel_2_3_2);
		panel_2_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                 
                 }
               else  if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                                else{
                   
               }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_2.setBackground(defaultcolor);
			}
		});
		
		JLabel lblHan = new JLabel("    Hóa Đơn");
		lblHan.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-bill-36.png")));
		lblHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHan.setBounds(-25, 0, 159, 43);
		panel_2_3_2.add(lblHan);
		lblHan.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_2.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     QuanLyHoaDon hd = new QuanLyHoaDon();
                                    hd.setVisible(true);
                                    dispose();
                 }
               else  if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                                else{
                                  QuanLyHoaDon hd = new QuanLyHoaDon();
                                    hd.setVisible(true);
                                    dispose();  
               }
			}
		});
		 panel_2_3_3 = new JPanel();
		panel_2_3_3.setLayout(null);
		panel_2_3_3.setBounds(0, 445, 229, 43);
		panelmenu.add(panel_2_3_3);
		panel_2_3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                 
                 }
               else  if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                                else{
                   
               }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3.setBackground(defaultcolor);
			}
		});
		
		JLabel lblKhchHng = new JLabel("    Khách Hàng");
		lblKhchHng.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-user-3611.png")));
		lblKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhchHng.setBounds(-15, 0, 159, 43);
		panel_2_3_3.add(lblKhchHng);
		lblKhchHng.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     QuanLyKhachHang kh = new QuanLyKhachHang();
                                kh.setVisible(true);
                                dispose();
                 }
            else     if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
                                else{
                                QuanLyKhachHang kh = new QuanLyKhachHang();
                                kh.setVisible(true);
                                dispose();
               }
			}
		});
		 panel_2_3_3_1 = new JPanel();
		panel_2_3_3_1.setLayout(null);
		panel_2_3_3_1.setBounds(0, 493, 229, 43);
		panelmenu.add(panel_2_3_3_1);
		panel_2_3_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
              else   if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
         else{
                   
               }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1.setBackground(defaultcolor);
			}
		});
		
		JLabel lblLchLmVic = new JLabel("   Lịch làm việc");
		lblLchLmVic.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-schedule-36.png")));
		lblLchLmVic.setHorizontalAlignment(SwingConstants.CENTER);
		lblLchLmVic.setBounds(-15, 0, 159, 43);
		panel_2_3_3_1.add(lblLchLmVic);
		lblLchLmVic.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng"))
                 {
                     JOptionPane.showMessageDialog(null, "bạn là nhân viên BÁN HÀNG nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
              else   if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên kho"))
                 {
                      JOptionPane.showMessageDialog(null, "bạn là nhân viên KHO nên KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                 }
         else{
                                    Schedule lich = new Schedule();
                                    lich.setVisible(true);
                                    dispose();
               }
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 541, 229, 9);
		panelmenu.add(separator_1);
		
		 panel_2_3_3_1_1 = new JPanel();
		panel_2_3_3_1_1.setLayout(null);
		panel_2_3_3_1_1.setBounds(0, 595, 229, 43);
		panelmenu.add(panel_2_3_3_1_1);
		panel_2_3_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1_1.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1_1.setBackground(defaultcolor);
			}
		});
		
		JLabel lblThot = new JLabel("    Hỗ Trợ");
		lblThot.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-earth-36.png")));
		lblThot.setHorizontalAlignment(SwingConstants.CENTER);
		lblThot.setBounds(-26, 0, 159, 43);
		panel_2_3_3_1_1.add(lblThot);
		lblThot.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1_1 .setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1_1 .setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HoTro support = new HoTro();
                                support.setVisible(true);
                                dispose();
			}
		});
		
		JPanel panel_2_3_3_1_2 = new JPanel();
		panel_2_3_3_1_2.setLayout(null);
		panel_2_3_3_1_2.setBounds(0, 547, 229, 43);
		panelmenu.add(panel_2_3_3_1_2);
		panel_2_3_3_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            Auth.clear();
				loginform main = new loginform();
				main.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1_2.setBackground(defaultcolor);
			}
		});
		
		JLabel lblLchLmVic_2 = new JLabel("   Đăng Xuất");
		lblLchLmVic_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-log-out-3612.png")));
		lblLchLmVic_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLchLmVic_2.setBounds(-19, 0, 159, 43);
		panel_2_3_3_1_2.add(lblLchLmVic_2);
		lblLchLmVic_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1_2.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1_2.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                              Auth.clear();
				loginform main = new loginform();
				main.setVisible(true);
				dispose();
			}
		});
		
		JPanel panel_2_3_3_1_3 = new JPanel();
		panel_2_3_3_1_3.setLayout(null);
		panel_2_3_3_1_3.setBounds(0, 642, 229, 43);
		panelmenu.add(panel_2_3_3_1_3);
		panel_2_3_3_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1_3.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1_3.setBackground(defaultcolor);
			}
		});
		
		JLabel lblLchLmVic_1 = new JLabel("   Thoát");
		lblLchLmVic_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3_1_3.setBackground(clickcolor);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_3_1_3.setBackground(defaultcolor);
			}
		});
		
		lblLchLmVic_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-log-out-36.png")));
		lblLchLmVic_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLchLmVic_1.setBounds(-25, 0, 159, 43);
		panel_2_3_3_1_3.add(lblLchLmVic_1);
		
		panel.setBackground(new Color(25, 118, 211));
		panel_2.setBackground(new Color(25, 118, 211));
		panel_2_1.setBackground(new Color(25, 118, 211));
		panel_2_2.setBackground(new Color(25, 118, 211));
		panel_2_3.setBackground(new Color(25, 118, 211));
		panel_2_3_1.setBackground(new Color(25, 118, 211));
		panel_2_3_2.setBackground(new Color(25, 118, 211));
		panel_2_3_3.setBackground(new Color(25, 118, 211));
		panel_2_3_3_1.setBackground(new Color(25, 118, 211));
		panel_2_3_3_1_2.setBackground(new Color(25, 118, 211));
		panel_2_3_3_1_3.setBackground(new Color(25, 118, 211));
		panel_2_3_3_1_1.setBackground(defaultcolor);
		
		JLabel lblNewLabel_8 = new JLabel("NGUYỄN VĂN LỢI");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(68, 28, 128, 26);
		panelmenu.add(lblNewLabel_8);
		
		//JLabel lblNewLabel_9 = new JLabel("Trưởng Phòng");
                JLabel lblNewLabel_9 = new JLabel("Nhân viên bán hàng");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setForeground(new Color(192, 192, 192));
		lblNewLabel_9.setBounds(70, 55, 150, 26);
		panelmenu.add(lblNewLabel_9);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openmenubar();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-list-42.png")));
		lblNewLabel_2.setBounds(24, 11, 62, 50);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(205, 252, 225));
		panel_1.setBounds(0, 180, 1048, 512);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
//		panel_3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				 lblNewLabel_7_2.setForeground(Color.RED);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				lblNewLabel_7_2.setForeground(new Color(21, 181, 176));
//			}
//		});
//		panel_3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				lblNewLabel_10_1.setIcon(new ImageIcon(trangchu.class.getResource("/icon/Wavy_Bus-04_Single-04-removebg-preview.png")));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				lblNewLabel_10_1.setIcon(new ImageIcon(trangchu.class.getResource("/icon/picture1-removebg-preview.png")));
//			}
//		});
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(40, 11, 449, 477);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(getClass().getResource("/icon/banhang.png")));
		lblNewLabel_10.setBounds(0, 0, 449, 424);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_13 = new JLabel("BÁN HÀNG");
		lblNewLabel_13.setForeground(new Color(255, 0, 0));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel_13.setBounds(169, 420, 141, 70);
                lblNewLabel_13.setBounds(129, 420, 200, 70);
		panel_3.add(lblNewLabel_13);
		
		 panelcclt = new JPanel();
		panelcclt.setBackground(new Color(0, 217, 240));
		panelcclt.setBounds(1046, 118, 1, 394);
		panel_1.add(panelcclt);
		panelcclt.setLayout(null);
		
		JLabel text = new JLabel("");
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("Tahoma", Font.BOLD, 31));
		text.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		text.setBounds(10, 36, 291, 62);
		panelcclt.add(text);
		
		JButton so9 = new JButton("9");
		so9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so9.getText();
				text.setText(number);
			}
		});
		so9.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so9.setBounds(10, 124, 56, 48);
		panelcclt.add(so9);
		
		JButton cong = new JButton("+");
		cong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(text.getText());
				pheptoan="+";
				text.setText("");
			}
		});
		cong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		cong.setBounds(245, 124, 56, 48);
		panelcclt.add(cong);
		
		JButton so7 = new JButton("7");
		so7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so7.getText();
				text.setText(number);
			}
		});
		so7.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so7.setBounds(170, 124, 56, 48);
		panelcclt.add(so7);
		
		JButton so6 = new JButton("6");
		so6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so6.getText();
				text.setText(number);
			}
		});
		so6.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so6.setBounds(10, 194, 56, 48);
		panelcclt.add(so6);
		
		JButton so8 = new JButton("8");
		so8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so8.getText();
				text.setText(number);
			}
		});
		so8.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so8.setBounds(92, 124, 56, 48);
		panelcclt.add(so8);
		
		JButton tru = new JButton("-");
		tru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(text.getText());
				pheptoan="-";
				text.setText("");
			}
		});
		tru.setFont(new Font("Segoe UI", Font.BOLD, 22));
		tru.setBounds(245, 194, 56, 48);
		panelcclt.add(tru);
		
		JButton so4 = new JButton("4");
		so4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so4.getText();
				text.setText(number);
			}
		});
		so4.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so4.setBounds(170, 194, 56, 48);
		panelcclt.add(so4);
		
		JButton so3 = new JButton("3");
		so3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so3.getText();
				text.setText(number);
			}
		});
		so3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so3.setBounds(170, 263, 56, 48);
		panelcclt.add(so3);
		
		JButton so5 = new JButton("5");
		so5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so5.getText();
				text.setText(number);
			}
		});
		so5.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so5.setBounds(92, 194, 56, 48);
		panelcclt.add(so5);
		
		JButton nhan = new JButton("x");
		nhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(text.getText());
				pheptoan="x";
				text.setText("");
			}
		});
		nhan.setFont(new Font("Segoe UI", Font.BOLD, 22));
		nhan.setBounds(245, 263, 56, 48);
		panelcclt.add(nhan);
		
		JButton so1 = new JButton("1");
		so1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = text.getText()+so1.getText();
				text.setText(number);
			}
		});
		so1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so1.setBounds(10, 263, 56, 48);
		panelcclt.add(so1);
		
		JButton so0 = new JButton("0");
		so0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so0.getText();
				text.setText(number);
			}
		});
		so0.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so0.setBounds(10, 335, 56, 48);
		panelcclt.add(so0);
		
		JButton so2 = new JButton("2");
		so2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = text.getText()+so2.getText();
				text.setText(number);
			}
		});
		so2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		so2.setBounds(92, 263, 56, 48);
		panelcclt.add(so2);
		
		JButton chia = new JButton("/");
		chia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first = Double.parseDouble(text.getText());
				pheptoan="/";
				text.setText("");
			}
		});
		chia.setFont(new Font("Segoe UI", Font.BOLD, 22));
		chia.setBounds(245, 335, 56, 48);
		panelcclt.add(chia);
		
		JButton btnNewButton_3_3_1 = new JButton("AC");
		btnNewButton_3_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				first =0;
				second=0;
				pheptoan="";
			}
		});
		btnNewButton_3_3_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_3_3_1.setBounds(92, 335, 56, 48);
		panelcclt.add(btnNewButton_3_3_1);
		
		JButton btnNewButton_3_3_2 = new JButton("=");
		btnNewButton_3_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second= Double.parseDouble(text.getText());
				if(pheptoan=="+")
				{
					sum = first+second;
					text.setText(String.valueOf(sum));
				}
				if(pheptoan=="-")
				{
					sum = first-second;
					text.setText(String.valueOf(sum));
				}
				if(pheptoan=="x")
				{
					sum = first*second;
					text.setText(String.valueOf(sum));
				}
				if(pheptoan=="/")
				{
					if(first<second)
					{
						text.setText("SỐ CHIA KHÔNG HỢP LỆ");
					}
					else {
						sum = first/second;
						text.setText(String.valueOf(sum));
					}
					
				}
				
			}
		});
		btnNewButton_3_3_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnNewButton_3_3_2.setBounds(170, 335, 56, 48);
		panelcclt.add(btnNewButton_3_3_2);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closecclt();
				panelcclt.setBounds(1046, 118, 1, 394);
			}
		});
		lblNewLabel_16.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-x-25.png")));
		lblNewLabel_16.setBounds(0, 0, 29, 25);
		panelcclt.add(lblNewLabel_16);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(554, 11, 449, 477);
		panel_1.add(panel_3_2);
		
		JLabel lblNewLabel_13_1 = new JLabel("CÁCH SỬ DỤNG");
		lblNewLabel_13_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13_1.setForeground(new Color(101, 217, 15));
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_13_1.setBounds(81, 417, 325, 70);
		panel_3_2.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(getClass().getResource("/icon/EXP.png")));
		lblNewLabel_14.setBounds(48, 11, 449, 428);
		panel_3_2.add(lblNewLabel_14);
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-x-25.png")));
		lblNewLabel_2_1.setBounds(1018, 0, 62, 38);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_6.setBounds(681, -21, 98, 31);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("QUẢN LÍ SIÊU THỊ");
		lblNewLabel_7.setForeground(new Color(21, 181, 176));
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(593, 23, 278, 57);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("- Hãy hướng về ánh mặt trời, nơi mà bóng tối luôn ở sau lưng bạn");
		lblNewLabel_7_1.setBackground(new Color(21, 181, 176));
		lblNewLabel_7_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_7_1.setBounds(531, 71, 449, 68);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index++;
				int so =index;
				if(so%2!=0)
				{
					opensetting();
				}
				else {
					closesetting();
				}
				
				
			}
		});
		lblNewLabel_2_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-setting-42.png")));
		lblNewLabel_2_2.setBounds(92, 11, 62, 50);
		contentPane.add(lblNewLabel_2_2);
		
		 panelsetting = new JPanel();
		panelsetting.setBackground(new Color(25, 118, 211));
		panelsetting.setBounds(144, 0, 416, 1);
		contentPane.add(panelsetting);
		panelsetting.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closesetting();
			}
		});
		lblNewLabel_11.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-x-25.png")));
		lblNewLabel_11.setBounds(391, 44, 25, 22);
		panelsetting.add(lblNewLabel_11);
		
		JPanel panel_6 = new JPanel();
		
		panel_6.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_6.setBackground(new Color(25, 118, 221));
		panel_6.setBounds(10, 0, 69, 61);
		panelsetting.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setBackground(Color.BLACK);
				panel_1.setBackground(new Color(94, 97, 117));
				panel_3.setBackground(new Color(30,33,39));
				panel_3_2.setBackground(new Color(30,33,39));
				lblNewLabel_7.setForeground(Color.YELLOW);
				lblNewLabel_7_1.setForeground(Color.YELLOW);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground( Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(25, 118, 221));
			}
		});
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-dark-36.png")));
		lblNewLabel_12.setBounds(0, 0, 69, 61);
		panel_6.add(lblNewLabel_12);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_6_1.setLayout(null);
		panel_6_1.setBackground(new Color(25, 118, 221));
		panel_6_1.setBounds(82, 0, 79, 61);
		panelsetting.add(panel_6_1);
		
		JLabel lblNewLabel_12_1 = new JLabel("");
		lblNewLabel_12_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setBackground(Color.WHITE);
				panel_1.setBackground(new Color(205, 252, 225));
				panel_3.setBackground(Color.WHITE);
				panel_3_2.setBackground(Color.WHITE);
				lblNewLabel_7.setForeground(new Color(21, 181, 176));
				lblNewLabel_7_1.setForeground(new Color(21, 181, 176));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6_1.setBackground(new Color(25, 118, 221));
			}
		});
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-light-36.png")));
		lblNewLabel_12_1.setBounds(0, 0, 79, 61);
		panel_6_1.add(lblNewLabel_12_1);
		
		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setLayout(null);
		panel_6_1_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_6_1_1.setBackground(new Color(25, 118, 221));
		panel_6_1_1.setBounds(166, 0, 79, 61);
		panelsetting.add(panel_6_1_1);
		
		JLabel lblNewLabel_12_1_1 = new JLabel("");
		lblNewLabel_12_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				index++;
				int so =index;
				if(so%2!=0)
				{
					panelcclt.setBounds(736, 118, 311, 394);
					opencclt();
				}
				else {
					closecclt();
					panelcclt.setBounds(1046, 118, 1, 394);
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6_1_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6_1_1.setBackground(new Color(25, 118, 221));
			}
		});
		lblNewLabel_12_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-calculator-36.png")));
		lblNewLabel_12_1_1.setBounds(0, 0, 79, 61);
		panel_6_1_1.add(lblNewLabel_12_1_1);
		
		JPanel panel_6_1_1_1 = new JPanel();
		panel_6_1_1_1.setLayout(null);
		panel_6_1_1_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_6_1_1_1.setBackground(new Color(25, 118, 221));
		panel_6_1_1_1.setBounds(251, 0, 79, 61);
		panelsetting.add(panel_6_1_1_1);
		
		JLabel lblNewLabel_12_1_1_1 = new JLabel("");
		lblNewLabel_12_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6_1_1_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6_1_1_1.setBackground(new Color(25, 118, 221));
			}
		});
		lblNewLabel_12_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1_1_1.setIcon(new ImageIcon("src/icon/icons8-calendar-36.png"));
		lblNewLabel_12_1_1_1.setBounds(0, 0, 79, 61);
		panel_6_1_1_1.add(lblNewLabel_12_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/icon/logo-cua-hang-tien-loi-8-removebg-preview.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(281, 0, 272, 204);
		contentPane.add(lblNewLabel_5);
		
		 try {
             if(Auth.user.getGioiTinh()=="nam")
             {
                 lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-account-45.png")));
             }
             else{
                 lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-female-user-45.png")));
             }
             lblNewLabel_8.setText(Auth.user.getTenNV());
             lblNewLabel_9.setText(Auth.user.getVaiTro());
         } catch (Exception e) {
         }
		
lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng")){
                                BanHang1 bh = new BanHang1();
                                bh.setVisible(true);
                                dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                            }
			}
		});

lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng")){
                                BanHang1 bh = new BanHang1();
                                bh.setVisible(true);
                                dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                            }
			}
		});
panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            if(Auth.user.getVaiTro().equalsIgnoreCase("Nhân viên bán hàng")){
                                BanHang1 bh = new BanHang1();
                                bh.setVisible(true);
                                dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "KHÔNG truy cập được CHỨC NĂNG NÀY","CẢNH BÁO" , JOptionPane.ERROR_MESSAGE);
                            }
			}
		});
		
lblNewLabel_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            HuongDan hd = new HuongDan();
                            hd.setVisible(true);
                            dispose();
			}
		});
		
	 }
	public void openmenubar() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i =0;i<width;i++) {
				panelmenu.setSize(i, height);
					try {
						Thread.sleep(2);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
			}
		}).start();
	}
    public void closemenubar() {
new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i =width;i>0;i--) {
				panelmenu.setSize(i, height);
				try {
					Thread.sleep(2);
				} catch (Exception e) {
					// TODO: handle exception
				}
				}
				
			}
		}).start();
	}
    public void opensetting() {
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
			for(int i =1;i<heightst;i++)
			{
				panelsetting.setSize(widthst, i);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
				
			}
		}).start();
    }
 public void closesetting() {
	 new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i =heightst;i>0;i--)
				{
					panelsetting.setSize(widthst, i);
					try {
						Thread.sleep(5);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
			}
		}).start();
    }
 public void opencclt()
 {
	 new Thread(new Runnable() {
		
		@Override
		public void run() {
			for(int i=0;i<withcct;i++)
			{
				panelcclt.setSize(i, heightcct);
			}
			
		}
	}).start();
 }
 public void closecclt()
 {
	 new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=withcct;i>0;i--)
				{
					panelcclt.setSize(i, heightcct);
				}
				
			}
		}).start();
 }
 
}

