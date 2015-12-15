import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Detail extends MainFrame{
	private static Detail detailPage;
	private JPanel contentPanel;
	

	public void run() {
		try {
			detailPage = new Detail();
			detailPage.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			detailPage.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Detail() {
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1352, 1352);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JPanel topBarPanel = new JPanel();
		topBarPanel.setBackground(Color.WHITE);
		topBarPanel.setBounds(0, 0, 1352, 79);
		contentPanel.add(topBarPanel);
		topBarPanel.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0,0,1352,1352);
		contentPanel.add(mainPanel);
		mainPanel.setLayout(null);
		
		
		
		
		
		
		
		
		
		JLabel labelForImage = new JLabel("");
		labelForImage.setBounds(0,0,1352,700);
		Image imageForBackground = new ImageIcon(this.getClass().getResource("/images/resim2.png")).getImage();
		labelForImage.setIcon(new ImageIcon(imageForBackground));
		mainPanel.add(labelForImage);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 138, 74);
		Image img = new ImageIcon(this.getClass().getResource("/images/resim1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		topBarPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Caner G\u00FClge\u00E7 ");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1.setBounds(1067, 22, 104, 41);
		topBarPanel.add(lblNewLabel_1);

		JLabel profileLabel = new JLabel("");
		profileLabel.setBounds(973, 0, 84, 74);
		Image img3 = new ImageIcon(this.getClass().getResource("/images/profile.png")).getImage();
		profileLabel.setIcon(new ImageIcon(img3));
		topBarPanel.add(profileLabel);

		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(510, 45, 107, 34);
		topBarPanel.add(logoutButton);
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBorderPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailPage.dispose();
				frame.setVisible(true);
			}
		});	 
	}
}
