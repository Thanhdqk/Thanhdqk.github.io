package view;

import Util.Auth;
import java.awt.Color;
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
import java.awt.Image;
import javax.swing.JTable;

public class account extends JFrame {

	private JPanel contentPane;
        JLabel lblNewLabel_6 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account frame = new account();
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
	public account() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 153, 194));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		setLocationRelativeTo(null);
		lblNewLabel.setIcon(new ImageIcon("src/icon/icons8-x-25.png"));
		lblNewLabel.setBounds(804, 0, 36, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("THÔNG TIN TÀI KHOẢN");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(42, 77, 318, 43);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 177, 255, 330);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 255, 330);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Nhân Viên");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(77, 77, 255));
		lblNewLabel_2.setBounds(303, 177, 110, 36);
		
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ và Tên");
		lblNewLabel_2_1.setForeground(new Color(77, 77, 255));
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(305, 233, 91, 36);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Vai Trò");
		lblNewLabel_2_2.setForeground(new Color(77, 77, 255));
		lblNewLabel_2_2.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(303, 374, 91, 36);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Giới Tính");
		lblNewLabel_2_2_1.setForeground(new Color(77, 77, 255));
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2_2_1.setBounds(305, 280, 91, 36);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Ngày Sinh");
		lblNewLabel_2_2_2.setForeground(new Color(77, 77, 255));
		lblNewLabel_2_2_2.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2_2_2.setBounds(305, 327, 91, 36);
		contentPane.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Gmail");
		lblNewLabel_2_2_3.setForeground(new Color(77, 77, 255));
		lblNewLabel_2_2_3.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2_2_3.setBounds(303, 425, 91, 36);
		contentPane.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Mật Khẩu");
		lblNewLabel_2_2_4.setForeground(new Color(77, 77, 255));
		lblNewLabel_2_2_4.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2_2_4.setBounds(303, 482, 91, 36);
		contentPane.add(lblNewLabel_2_2_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/icon/logo-cua-hang-tien-loi-8-removebg-preview.png")));
		lblNewLabel_3.setBounds(383, 0, 426, 164);
		contentPane.add(lblNewLabel_3);
		
		JLabel maso = new JLabel("0001");
		maso.setForeground(new Color(255, 0, 0));
		maso.setFont(new Font("Segoe UI", Font.BOLD, 13));
		maso.setBounds(461, 177, 125, 36);
		contentPane.add(maso);
		
		JLabel name = new JLabel("NGUYÊN VĂN GAY");
		name.setForeground(Color.RED);
		name.setFont(new Font("Segoe UI", Font.BOLD, 13));
		name.setBounds(461, 233, 145, 36);
		contentPane.add(name);
		
		JLabel gt = new JLabel("NAM");
		gt.setForeground(Color.RED);
		gt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		gt.setBounds(461, 280, 145, 36);
		contentPane.add(gt);
		
		JLabel date = new JLabel("NGUYÊN VĂN GAY");
		date.setForeground(Color.RED);
		date.setFont(new Font("Segoe UI", Font.BOLD, 13));
		date.setBounds(461, 327, 145, 36);
		contentPane.add(date);
		
		JLabel role = new JLabel("NGUYÊN VĂN GAY");
		role.setForeground(Color.RED);
		role.setFont(new Font("Segoe UI", Font.BOLD, 13));
		role.setBounds(461, 374, 145, 36);
		contentPane.add(role);
		
		JLabel gmail = new JLabel("NGUYÊN VĂN GAY");
		gmail.setForeground(Color.RED);
		gmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
		gmail.setBounds(461, 425, 155, 36);
		contentPane.add(gmail);
		
		JLabel pass = new JLabel("NGUYÊN VĂN GAY");
		pass.setForeground(Color.RED);
		pass.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pass.setBounds(461, 482, 145, 36);
		contentPane.add(pass);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/icon/image-removebg-previewacc.png")));
		lblNewLabel_5.setBounds(643, 161, 227, 412);
		contentPane.add(lblNewLabel_5);
		
		try {
			maso.setText(Auth.user.getMaNV());
                        name.setText(Auth.user.getTenNV());
                        gt.setText(Auth.user.getGioiTinh());
                        date.setText(String.valueOf(Auth.user.getNgaySinh()));
                        role.setText(Auth.user.getVaiTro());
                        gmail.setText(Auth.user.getEmail());
                        pass.setText(Auth.user.getMatKhau());
                        updatehinh(Auth.user.getHinh());
		} catch (Exception e) {
		e.printStackTrace();
		}
		
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
	}
        public void updatehinh(String image)
{
	ImageIcon img1 = new ImageIcon(getClass().getResource("/icon/"+image));
	Image IM = img1.getImage();
	ImageIcon icon = new ImageIcon(IM.getScaledInstance(lblNewLabel_6.getWidth(),lblNewLabel_6.getHeight(),IM.SCALE_SMOOTH));
	lblNewLabel_6.setIcon(icon);
	JLabel lblNewLabel_4 = new JLabel("NẾU BẠN MUỐN ĐỖI MẬT KHẨU HÃY CLICK VÀO ĐÂY  !!");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            doimatkhauform dmk = new doimatkhauform();
                            dmk.setVisible(true);
                            dispose();
			}
		});
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(288, 537, 360, 36);
		contentPane.add(lblNewLabel_4);
}
}
