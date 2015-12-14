import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

public class HomePage extends MainFrame {
    private static HomePage homeFrame;
	private JPanel contentPane;
  
	/**
	 * Launch the application.
	 */
	
		
			public void run() {
				try {
				    homeFrame = new HomePage();
				    homeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					homeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1352, 1352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 0, 1352, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1352, 79);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 138, 74);
		Image img = new ImageIcon(this.getClass().getResource("/images/resim1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Caner G\u00FClge\u00E7 ");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1.setBounds(1067, 22, 104, 41);
		panel_1.add(lblNewLabel_1);
		
		JLabel profileLabel = new JLabel("");
		profileLabel.setBounds(973, 0, 84, 74);
		Image img3 = new ImageIcon(this.getClass().getResource("/images/profile.png")).getImage();
		profileLabel.setIcon(new ImageIcon(img3));
		panel_1.add(profileLabel);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(289, 45, 117, 34);
		panel_1.add(homeButton);
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBorderPainted(false);
		
		JButton calendarButton = new JButton("Calendar");
		calendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homeFrame.dispose();
				Calendar calendar = new Calendar();
				calendar.main(null);
				
			}
		});
		calendarButton.setBounds(404, 45, 107, 34);
		panel_1.add(calendarButton);
		calendarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		calendarButton.setBackground(Color.WHITE);
		calendarButton.setBorderPainted(false);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(510, 45, 107, 34);
		panel_1.add(logoutButton);
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBorderPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeFrame.dispose();
				frame.setVisible(true);
				
			}
		});
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(334, 225, 548, 374);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Faculty/Institute :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(31, 92, 125, 37);
		panel_2.add(lblNewLabel_2);
		
		String[] faculties = { "FE-Engineering Faculty", "FEAS-Faculty of Management", "FLAW-Faculty of Law"};
		JComboBox comboBoxFaculty = new JComboBox(faculties);
		comboBoxFaculty.setBackground(Color.WHITE);
		comboBoxFaculty.setBounds(166, 100, 197, 20);
		panel_2.add(comboBoxFaculty);
		
		JLabel lblNewLabel_3 = new JLabel("Subject");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(31, 142, 125, 37);
		panel_2.add(lblNewLabel_3);
		
		String[] subjects = {"CS Bilgisayar Mühendisliği", "MATH Matematik", "ENG İngilizce", "BUS İşletme "};
		JComboBox comboBoxSubject = new JComboBox(subjects);
		comboBoxSubject.setBackground(Color.WHITE);
		comboBoxSubject.setBounds(166, 150, 197, 20);
		panel_2.add(comboBoxSubject);
		
		JLabel lblNewLabel_4 = new JLabel("Courses Offered");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(45, 23, 221, 37);
		panel_2.add(lblNewLabel_4);
		
		JButton searchButton = new JButton("Search");
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchButton.setBounds(354, 197, 97, 31);
		panel_2.add(searchButton);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Lesson lesson = new Lesson();
				lesson.run();
			}
		});
		
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 0, 1326, 700);
		Image img4 = new ImageIcon(this.getClass().getResource("/images/resim2.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img4));
		panel.add(lblNewLabel_5);
	}
}
