import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class Lesson extends MainFrame {
	private static Lesson lessonPage;
	private JPanel contentPanel;
	public final DefaultListModel defaultList = new DefaultListModel();
	public static ArrayList<Course> courseList;
	public static String[] faculties;
	public static String[] subjects;
	

	public void run() {
		try {
			lessonPage = new Lesson(faculties,subjects);
			lessonPage.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			lessonPage.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Lesson() {
		
	}

	public Lesson(String[] faculties, String[] subjects) throws IOException {
		this.faculties = faculties;
		this.subjects = subjects;
		
		Parser parser = new Parser();
		List<Course> lists = parser.coursesArr;
		List<Course> courseListForShown = new ArrayList<Course>();
		
//		for(int i = 0; i<lists.size(); i++) {
//			for(int j = 0; j < faculties.length; j++) {
//				if(faculties[j].equals(lists.get(i)) && !courseListForShown.contains(lists.get(i))) {
//					courseListForShown.add(lists.get(i));
//				}
//			}
//		}
		
		
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
		
		final JList list = new JList(getCourses(lists));
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(400, 200, 150, 300);
		scrollPane.setVisible(true);
		mainPanel.add(scrollPane);

		JButton copyButton = new JButton("Copy>>>");
		copyButton.setBounds(600, 250, 100, 50);
		mainPanel.add(copyButton);
		
		copyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = list.getSelectedValues().length;
				if(defaultList.size() == 0) {
					for(int i=0; i<size;i++) {
						defaultList.addElement(list.getSelectedValues()[i]);
					}
				}
				if(defaultList.size() > 0){
					for(int i=0; i<size;i++) {	
						if(!defaultList.contains(list.getSelectedValues()[i]))
								defaultList.addElement(list.getSelectedValues()[i]);
					}
				}				
			}	
		});

		final JList selectedList = new JList(defaultList);
		selectedList.setFixedCellHeight(18);
		selectedList.setFixedCellWidth(80);
		JScrollPane scrollForSelectedList = new JScrollPane(selectedList);
		scrollForSelectedList.setBounds(750, 200, 150, 300);
		scrollForSelectedList.setVisible(true);
		mainPanel.add(scrollForSelectedList);

		JButton deleteSelected = new JButton("Delete Selected");
		deleteSelected.setBounds(580, 320, 150, 50);
		mainPanel.add(deleteSelected);
		deleteSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = selectedList.getSelectedValues().length;
				for(int i = 0; i < size; i++) {
					defaultList.removeElement(selectedList.getSelectedValues()[i]);
				}
			}
		});
		
		JButton deleteAllButton = new JButton("Delete All");
		deleteAllButton.setBounds(580,390,150,50);
		mainPanel.add(deleteAllButton);
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultList.removeAllElements();
			}
		});
		

		JButton doneButton = new JButton("Done");
		doneButton.setBounds(600,600,100,50);
		mainPanel.add(doneButton);
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					for(int i = 0; i < defaultList.size(); i++) {
						System.out.println(defaultList.getElementAt(i));
					}
					courseList = getCourseDetail(defaultList);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lessonPage.dispose();
				HomePage home = new HomePage();
				home.run();
			}
		});

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
				lessonPage.dispose();
				frame.setVisible(true);
			}
		});	 
	}
	
	private DefaultListModel<String> getCourses(List<Course> lists) {
		DefaultListModel<String> courseList = new DefaultListModel<String>();
		for(int i = 0;i<lists.size(); i++) {
			courseList.addElement(lists.get(i).courseName);
		}
		return courseList;
	}
	
	private ArrayList<Course> getCourseDetail(DefaultListModel<String> list) throws IOException {
		Parser parser = new Parser();
		ArrayList<Course> detailList = new ArrayList<Course>();
		for(int i = 0;i<list.size();i++) {
//			if(list.contains(parser.coursesArr.get(i).courseName)) {
				detailList.add(parser.coursesArr.get(i));			
//			}
		}
		return detailList;	
	}
}
