import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainFrame extends JFrame {
    public static MainFrame frame;
	private JPanel contentPane;
	private JTextField txtCanergulgecozuedutr;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new MainFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setBounds(100, 100, 1352, 1352);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(544, 190, 287, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 29, 74, 31);
		panel_1.add(lblNewLabel);
		
		txtCanergulgecozuedutr = new JTextField();
		txtCanergulgecozuedutr.setText("caner.gulgec@ozu.edu.tr");
		txtCanergulgecozuedutr.setBounds(104, 29, 158, 31);
		panel_1.add(txtCanergulgecozuedutr);
		txtCanergulgecozuedutr.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 71, 74, 25);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(104, 71, 158, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton createAccountButton = new JButton("Create New Account");
		createAccountButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		createAccountButton.setBounds(140,140,140,23);
		createAccountButton.setBorderPainted(false);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		btnNewButton.setBounds(190, 140, 87, 23);
		btnNewButton.setBorderPainted(false);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomePage home = new HomePage();
				home.run();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1440, 900);
		Image img = new ImageIcon(this.getClass().getResource("/images/resim2.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel_2);
			
	}
}

