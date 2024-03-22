package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class HoTro extends JFrame {

	private JPanel contentPane;
        JTextArea textArea;
        JLabel lblNewLabel_4_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoTro frame = new HoTro();
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
	public HoTro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 712);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		setUndecorated(true);
		lblNewLabel.setIcon(new ImageIcon(HoTro.class.getResource("/icon/icons8-x-25.png")));
		lblNewLabel.setBounds(1007, 0, 36, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(HoTro.class.getResource("/icon/logo-cua-hang-tien-loi-8-removebg-preview.png")));
		lblNewLabel_1.setBounds(-18, -17, 450, 189);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HỖ TRỢ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(21, 181, 176));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel_2.setBounds(416, 0, 460, 103);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7_1 = new JLabel("- Hãy hướng về ánh mặt trời, nơi mà bóng tối luôn ở sau lưng bạn");
		lblNewLabel_7_1.setForeground(new Color(21, 181, 176));
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_7_1.setBackground(new Color(21, 181, 176));
		lblNewLabel_7_1.setBounds(442, 84, 497, 68);
		contentPane.add(lblNewLabel_7_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(21, 181, 176));
		panel.setBounds(647, 183, 412, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("CONTACT US");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(63, 25, 292, 81);
		panel.add(lblNewLabel_4);
		
		 textArea = new JTextArea();
		textArea.setBounds(46, 254, 321, 191);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				                        try {
                                  lblNewLabel_4_1.setText("HỆ THỐNG ĐANG XỬ LÍ");
                                sendOTP();
                                 lblNewLabel_4_1.setText("GỬI  THÀNH CÔNG");
                                
                            } catch (Exception e1) {
                                 lblNewLabel_4_1.setText("GỬI KHÔNG THÀNH CÔNG");
                                 lblNewLabel_4_1.setForeground(Color.RED);
                                e1.printStackTrace();
                            }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 128, 0));
		btnNewButton.setBounds(152, 466, 124, 52);
		panel.add(btnNewButton);
                
              lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(63, -18, 292, 81);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("CONTENT");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_1_1.setForeground(Color.RED);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_4_1_1.setBounds(46, 211, 124, 32);
		panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(HoTro.class.getResource("/icon/icons8-thank-you-55.png")));
		lblNewLabel_5.setBounds(173, 117, 257, 81);
		panel.add(lblNewLabel_5);
                
                JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			trangchu tc = new trangchu();
                        tc.setVisible(true);
                        dispose();
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon(HuongDan.class.getResource("/icon/icons8-log-out-36.png")));
		lblNewLabel_7.setBounds(10, 0, 56, 46);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(HoTro.class.getResource("/icon/sp3.jpg")));
		lblNewLabel_3.setBounds(-18, 183, 655, 529);
		contentPane.add(lblNewLabel_3);
		
	}
	private void sendOTP() {
    try {
          
        
     
        
        String host = "smtp.gmail.com";
        String user = "loikogay2003@gmail.com";
//        String user = "phuloc13620@gmail.";
        String pass = "qdlo ebhy knah pmrg";
        String to = "loinvps30466@fpt.edu.vn";
        //String pass = new String(txtPass.getPassword());
       String noidung = textArea.getText();
        String subject="Reseting Code";
        String message ="Your content Email is "+noidung;
        boolean sessionDebug = false;
        Properties pros = System.getProperties();
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.host", host);
        pros.put("mail.smtp.port","587");
        pros.put("mail.smtp.auth","true");
        pros.put("mail.smtp.starttls.required", "true");
        //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(pros, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(user));
        InternetAddress [] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setText(message);
        Transport transport = mailSession.getTransport("smtps");
        transport.connect(host,user,pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
      
//JOptionPane.showMessageDialog(this, "CODE HAS BEEN SEND TO THE EMAIL");
       
        } catch (Exception e) {
//            e.printStackTrace();
              JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ");
        }

}
}
