<<<<<<< HEAD
import java.util.*;


public class Course {
	
	String faculty;
	String subject;
	String instructor;
	String semester;
	String courseName;
	String courseID;
	List<Exam> exams;
	List<Homework> homeworks;
	
	public Course() {
		this.exams = new ArrayList<Exam>();
		this.homeworks = new ArrayList<Homework>();
	}
	
	public Course(String faculty, String subject, String instructor, String semester, String courseName, String courseID) {
		this.faculty=faculty;
		this.subject=subject;
		this.instructor = instructor;
		this.semester = semester;
		this.courseName = courseName;
		this.courseID = courseID;
		this.exams = new ArrayList<Exam>();
		this.homeworks = new ArrayList<Homework>();
	}
	
	public void addHomework(Homework homework) {
		homeworks.add(homework);
	}
	
	public void addExam(Exam exam) {
		exams.add(exam);
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	@Override
	public String toString() {
		return "Course [faculty=" + faculty + ", subject=" + subject + ", instructor=" + instructor + ", semester="
				+ semester + ", courseName=" + courseName + ", courseID=" + courseID + ", exams=" + exams
				+ ", homeworks=" + homeworks + "]";
	}
	
	

=======
import java.util.*;


public class Course {
	
	String faculty;
	String subject;
	String instructor;
	String semester;
	String courseName;
	String courseID;
	List<Exam> exams;
	List<Homework> homeworks;
	
	public Course() {
		this.exams = new ArrayList<Exam>();
		this.homeworks = new ArrayList<Homework>();
	}
	
	public Course(String faculty, String subject, String instructor, String semester, String courseName, String courseID) {
		this.faculty=faculty;
		this.subject=subject;
		this.instructor = instructor;
		this.semester = semester;
		this.courseName = courseName;
		this.courseID = courseID;
		this.exams = new ArrayList<Exam>();
		this.homeworks = new ArrayList<Homework>();
	}
	
	public void addHomework(Homework homework) {
		homeworks.add(homework);
	}
	
	public void addExam(Exam exam) {
		exams.add(exam);
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	@Override
	public String toString() {
		return "Course [faculty=" + faculty + ", subject=" + subject + ", instructor=" + instructor + ", semester="
				+ semester + ", courseName=" + courseName + ", courseID=" + courseID + ", exams=" + exams
				+ ", homeworks=" + homeworks + "]";
	}
	
	

>>>>>>> origin/master
}