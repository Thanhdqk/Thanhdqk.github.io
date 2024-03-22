package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;

public class trangloaddingjframe extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar;
	JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trangloaddingjframe frame = new trangloaddingjframe();
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
	public trangloaddingjframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(0, 0, 1070, 762);
		
		ImageIcon img1 = new ImageIcon(getClass().getResource("/icon/beautiful-trees-lake-rubber-plantation-kerala-india.jpg"));
		Image IM = img1.getImage();
		ImageIcon icon = new ImageIcon(IM.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),IM.SCALE_SMOOTH));
		lblNewLabel.setIcon(icon);
		
		contentPane.add(lblNewLabel);
		
		 progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 673, 1022, 33);
		lblNewLabel.add(progressBar);
		
		 lblNewLabel_1 = new JLabel("Waitting..");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(128, 255, 255));
		lblNewLabel_1.setBounds(10, 624, 126, 30);
		lblNewLabel.add(lblNewLabel_1);
		
		setUndecorated(true);
	}
}
