package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;

public class HuongDan extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuongDan frame = new HuongDan();
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
	public HuongDan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1048, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
                
		lblNewLabel.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/icons8-x-25.png")));
		lblNewLabel.setBounds(1020, 0, 38, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/logo-cua-hang-tien-loi-8-removebg-preview.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(180, 0, 249, 193);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HƯỚNG DẪN SỬ DỤNG");
		lblNewLabel_2.setForeground(new Color(21, 181, 176));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(439, 11, 460, 103);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7_1 = new JLabel("- Hãy hướng về ánh mặt trời, nơi mà bóng tối luôn ở sau lưng bạn");
		lblNewLabel_7_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_7_1.setBackground(new Color(21, 181, 176));
		lblNewLabel_7_1.setBounds(465, 95, 449, 68);
		contentPane.add(lblNewLabel_7_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 188, 1058, 524);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("TRANG CHỦ", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Click");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(38, 37, 52, 30);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-list-42.png")));
		lblNewLabel_4.setBounds(88, 28, 63, 50);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("để mở MENU  chức năng ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(146, 37, 252, 30);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Sau khi Click các chức năng sau sẽ hiễn thị");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(38, 87, 319, 30);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-conference-36.png")));
		lblNewLabel_5.setBounds(38, 136, 52, 50);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-analytics-36.png")));
		lblNewLabel_5_1.setBounds(38, 209, 52, 50);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-object-36.png")));
		lblNewLabel_5_2.setBounds(38, 278, 52, 50);
		panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("");
		lblNewLabel_5_2_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-bill-36.png")));
		lblNewLabel_5_2_1.setBounds(38, 357, 52, 50);
		panel.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("");
		lblNewLabel_5_2_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-user-3611.png")));
		lblNewLabel_5_2_2.setBounds(38, 435, 52, 50);
		panel.add(lblNewLabel_5_2_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-account-36.png")));
		lblNewLabel_5_3.setBounds(260, 136, 52, 50);
		panel.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("");
		lblNewLabel_5_3_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-warehouse-36.png")));
		lblNewLabel_5_3_1.setBounds(260, 209, 52, 50);
		panel.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_3_2 = new JLabel("");
		lblNewLabel_5_3_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-log-out-3612.png")));
		lblNewLabel_5_3_2.setBounds(260, 278, 52, 50);
		panel.add(lblNewLabel_5_3_2);
		
		JLabel lblNewLabel_5_3_3 = new JLabel("");
		lblNewLabel_5_3_3.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-log-out-36.png")));
		lblNewLabel_5_3_3.setBounds(260, 357, 52, 50);
		panel.add(lblNewLabel_5_3_3);
		
		JLabel lblNewLabel_5_3_4 = new JLabel("");
		lblNewLabel_5_3_4.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-earth-36.png")));
		lblNewLabel_5_3_4.setBounds(260, 435, 52, 50);
		panel.add(lblNewLabel_5_3_4);
		
		JLabel lblNewLabel_3_3 = new JLabel("Click");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(555, 37, 52, 30);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-setting-42.png")));
		lblNewLabel_4_1.setBounds(605, 28, 63, 50);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("để mở CÀI ĐẶT chức năng ");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(663, 37, 339, 30);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("KHÁCH HÀNG");
		lblNewLabel_6.setForeground(new Color(21, 181, 176));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(108, 147, 99, 30);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("THỐNG KÊ");
		lblNewLabel_6_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(108, 218, 99, 30);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("SẢN PHẨM");
		lblNewLabel_6_2.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_2.setBounds(108, 287, 99, 30);
		panel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("HÓA ĐƠN");
		lblNewLabel_6_3.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_3.setBounds(108, 366, 99, 30);
		panel.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("TÀI KHOẢN");
		lblNewLabel_6_4.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_4.setBounds(108, 441, 99, 30);
		panel.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("NHÂN VIÊN");
		lblNewLabel_6_5.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5.setBounds(322, 147, 99, 30);
		panel.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("KHO");
		lblNewLabel_6_1_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_1_1.setBounds(322, 218, 99, 30);
		panel.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("ĐĂNG XUẤT");
		lblNewLabel_6_2_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_2_1.setBounds(322, 287, 99, 30);
		panel.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("THOÁT");
		lblNewLabel_6_3_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_3_1.setBounds(322, 366, 99, 30);
		panel.add(lblNewLabel_6_3_1);
		
		JLabel lblNewLabel_6_4_1 = new JLabel("HỖ TRỢ");
		lblNewLabel_6_4_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_4_1.setBounds(322, 441, 99, 30);
		panel.add(lblNewLabel_6_4_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Sau khi Click các chức năng sau sẽ hiễn thị");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2_1.setBounds(588, 87, 319, 30);
		panel.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_5_3_5 = new JLabel("");
		lblNewLabel_5_3_5.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-light-36.png")));
		lblNewLabel_5_3_5.setBounds(598, 136, 52, 50);
		panel.add(lblNewLabel_5_3_5);
		
		JLabel lblNewLabel_6_5_1 = new JLabel("BẬT ĐÈN");
		lblNewLabel_6_5_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5_1.setBounds(660, 147, 99, 30);
		panel.add(lblNewLabel_6_5_1);
		
		JLabel lblNewLabel_5_3_5_1 = new JLabel("");
		lblNewLabel_5_3_5_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-dark-36.png")));
		lblNewLabel_5_3_5_1.setBounds(598, 197, 52, 50);
		panel.add(lblNewLabel_5_3_5_1);
		
		JLabel lblNewLabel_6_5_1_1 = new JLabel("TẮT ĐÈN");
		lblNewLabel_6_5_1_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5_1_1.setBounds(660, 208, 99, 30);
		panel.add(lblNewLabel_6_5_1_1);
		
		JLabel lblNewLabel_5_3_5_2 = new JLabel("");
		lblNewLabel_5_3_5_2.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-calculator-36.png")));
		lblNewLabel_5_3_5_2.setBounds(598, 264, 52, 50);
		panel.add(lblNewLabel_5_3_5_2);
		
		JLabel lblNewLabel_6_5_1_2 = new JLabel("MÁY TÍNH");
		lblNewLabel_6_5_1_2.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_5_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5_1_2.setBounds(660, 275, 99, 30);
		panel.add(lblNewLabel_6_5_1_2);
		
		JLabel lblNewLabel_5_3_5_2_1 = new JLabel("");
		lblNewLabel_5_3_5_2_1.setIcon(new ImageIcon(getClass().getResource("/icon/icons8-calendar-36.png")));
		lblNewLabel_5_3_5_2_1.setBounds(598, 346, 52, 50);
		panel.add(lblNewLabel_5_3_5_2_1);
		
		JLabel lblNewLabel_6_5_1_2_1 = new JLabel("XEM LỊCH");
		lblNewLabel_6_5_1_2_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_6_5_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5_1_2_1.setBounds(660, 357, 99, 30);
		panel.add(lblNewLabel_6_5_1_2_1);
		
		JLabel lblNewLabel_6_5_1_3 = new JLabel("PS :");
		lblNewLabel_6_5_1_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_6_5_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5_1_3.setBounds(605, 403, 31, 30);
		panel.add(lblNewLabel_6_5_1_3);
		
		JLabel lblNewLabel_6_5_1_3_1 = new JLabel("Tùy thuộc bạn là nhân viên nào , bạn sẽ được phép ");
		lblNewLabel_6_5_1_3_1.setForeground(Color.RED);
		lblNewLabel_6_5_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5_1_3_1.setBounds(646, 403, 330, 30);
		panel.add(lblNewLabel_6_5_1_3_1);
		
		JLabel lblNewLabel_6_5_1_3_1_1 = new JLabel("truy cập vào chức năng đó");
		lblNewLabel_6_5_1_3_1_1.setForeground(Color.RED);
		lblNewLabel_6_5_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_5_1_3_1_1.setBounds(646, 428, 330, 30);
		panel.add(lblNewLabel_6_5_1_3_1_1);
		
		JLabel lblNewLabel_6_5_1_3_1_2 = new JLabel("VỀ PHẦN SETTING THÌ NHÂN VIÊN NÀO CŨNG ĐƯỢC PHÉP SỬ DỤNG");
		lblNewLabel_6_5_1_3_1_2.setForeground(Color.RED);
		lblNewLabel_6_5_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_5_1_3_1_2.setBounds(646, 455, 397, 30);
		panel.add(lblNewLabel_6_5_1_3_1_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("BÁN HÀNG", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(getClass().getResource("/icon/banhang23.jpg")));
		lblNewLabel_8.setBounds(0, 0, 826, 496);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6_6 = new JLabel("CLICK LOẠI SẢN PHẨM");
		lblNewLabel_6_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_6.setBounds(860, 25, 183, 54);
		panel_1.add(lblNewLabel_6_6);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/icons8-arrow-360.png")));
		lblNewLabel_9.setBounds(922, 73, 58, 54);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_6_6_1 = new JLabel("CHỌN SẢN PHẨM");
		lblNewLabel_6_6_1.setForeground(Color.RED);
		lblNewLabel_6_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_6_1.setBounds(870, 125, 183, 54);
		panel_1.add(lblNewLabel_6_6_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/icons8-arrow-360.png")));
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setBounds(922, 179, 58, 54);
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_6_6_1_1 = new JLabel("CHỌN SỐ LƯỢNG");
		lblNewLabel_6_6_1_1.setForeground(Color.RED);
		lblNewLabel_6_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_6_1_1.setBounds(870, 240, 183, 54);
		panel_1.add(lblNewLabel_6_6_1_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("");
		lblNewLabel_9_1_1.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/icons8-arrow-360.png")));
		lblNewLabel_9_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1_1.setBounds(922, 293, 58, 54);
		panel_1.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_6_6_1_1_1 = new JLabel("CLICK THANH TOÁN");
		lblNewLabel_6_6_1_1_1.setForeground(Color.RED);
		lblNewLabel_6_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_6_1_1_1.setBounds(870, 358, 183, 54);
		panel_1.add(lblNewLabel_6_6_1_1_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/icons8-thank-you-55.png")));
		lblNewLabel_10.setBounds(860, 407, 157, 78);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            trangchu tt = new trangchu();
                            tt.setVisible(true);
                            dispose();
			}
		});
                
		lblNewLabel_7.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/icons8-log-out-36.png")));
		lblNewLabel_7.setBounds(10, 0, 56, 46);
		contentPane.add(lblNewLabel_7);
                
                
	}
}
