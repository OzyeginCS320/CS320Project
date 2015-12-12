import java.util.*;


public class Course {
	
	String instructor;
	String semester;
	String courseName;
	String courseID;
	List<Exam> exams;
	List<Homework> homeworks;
	
	public Course() {
		
	}
	
	public Course(String instructor, String semester, String courseName, String courseID) {
		this.instructor = instructor;
		this.semester = semester;
		this.courseName = courseName;
		this.courseID = courseID;
	}
	
	public void addHomework(Homework homework) {
		homeworks.add(homework);
	}
	
	public void addExam(Exam exam) {
		exams.add(exam);
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Homework> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	
	

}
