import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
		
		Lesson lesson = new Lesson();
		List<Course> courseList = lesson.courseList;
		
		
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
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(289, 45, 117, 34);
		topBarPanel.add(homeButton);
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBorderPainted(false);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailPage.dispose();
				HomePage homePage = new HomePage();
				homePage.run();
				
			}
		});
		
		JButton calendarButton = new JButton("Calendar");
		calendarButton.setBounds(404, 45, 107, 34);
		topBarPanel.add(calendarButton);
		calendarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		calendarButton.setBackground(Color.WHITE);
		calendarButton.setBorderPainted(false);
		calendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				detailPage.dispose();
				Calendar calendar = new Calendar();
				calendar.main(null);
				
			}
		});

		JButton detailButton = new JButton("Detail");
		detailButton.setBounds(510,45, 107, 34);
		topBarPanel.add(detailButton);
		detailButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		detailButton.setBackground(Color.WHITE);
		detailButton.setBorderPainted(false);
		detailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailPage.dispose();
				Detail detail = new Detail();
				detail.run();
				
			}
		});
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(616, 45, 107, 34);
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
		
		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(Color.GRAY);
		detailPanel.setBounds(180, 130, 1000, 500);
		contentPanel.add(detailPanel);
		detailPanel.setLayout(null);
		
		JLabel course = new JLabel("<html><font color='red'>COURSE</font></html>");
		course.setBounds(10, 10, 200, 10);
		detailPanel.add(course);
		
		JLabel instructor = new JLabel("<html><font color='red'>INSTRUCTOR</font></html>");
		instructor.setBounds(220, 10, 100, 10);
		detailPanel.add(instructor);
		
		JLabel exams = new JLabel("<html><font color='red'>EXAM DATES</font></html>");
		exams.setBounds(430, 10, 200, 10);
		detailPanel.add(exams);
		
		JLabel homework = new JLabel("<html><font color='red'>HOMEWORK DATES</font></html>");
		homework.setBounds(750,10,250,10);
		detailPanel.add(homework);
		JLabel info = new JLabel();
		if(courseList == null || courseList.size() == 0) {
			info.setBounds(350, 250, 300, 10);
			info.setText("<html><font color='white'>There is no course. Please select from Home.</font></html>");
			detailPanel.add(info);
		}else {
			detailPanel.remove(info);
		for (int i = 0; i < courseList.size(); i++) {
			JLabel courseDetails = new JLabel();
			JLabel instructorDetails = new JLabel();
			JLabel examsDetails = new JLabel();
			JLabel homeworkDetails = new JLabel();
			if(i==0) {
			courseDetails.setBounds(20, 20, 200, 20);
			instructorDetails.setBounds(220, 20, 200, 20);
			examsDetails.setBounds(430, 20, 350, 20);
			homeworkDetails.setBounds(750, 20, 200, 20);
			}if(i==1) {
				courseDetails.setBounds(10, i*40, 200, 20);
				instructorDetails.setBounds(220, i*40, 200, 20);
				examsDetails.setBounds(430, i*40, 350, 20);
				homeworkDetails.setBounds(750, i*40, 200, 20);
			} else {
				courseDetails.setBounds(10, i*20+20, 200, 20);
				instructorDetails.setBounds(220, i*20+20, 200, 20);
				examsDetails.setBounds(430, i*20+20, 350, 20);
				homeworkDetails.setBounds(750, i*20+20, 300, 20);
			}
			courseDetails.setText("<html><font color='white'>"+courseList.get(i).courseName + "</font></html>");
			instructorDetails.setText("<html><font color='white'>"+courseList.get(i).instructor + "</font></html>");
			String examDates = "";
			for(int j = 0; j<courseList.get(i).exams.size(); j++) {
				if(j==0) {
				examDates = courseList.get(i).exams.get(j).getExamDate();
				} else {
					examDates += "-" + courseList.get(i).exams.get(j).getExamDate();
				}
			}
			examsDetails.setText("<html><font color='white'>"+examDates + "</font></html>");
			String homeworkDates = "";
			for(int j = 0; j<courseList.get(i).homeworks.size(); j++) {
				if(j==0) {
					homeworkDates = courseList.get(i).homeworks.get(j).getDeadline();
					} else {
						examDates += "-" + courseList.get(i).homeworks.get(j).getDeadline();
					}	
			}
			homeworkDetails.setText("<html><font color='white'>" + homeworkDates + "</font></html>");
			detailPanel.add(courseDetails);
			detailPanel.add(instructorDetails);
			detailPanel.add(examsDetails);
			detailPanel.add(homeworkDetails);
		}
		}
		
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

	}
}
