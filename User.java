import java.util.*;


public class User {

	private List<Course> courses;
	private boolean auth;
	private String email;
	
	public User(String email) {
		this.email = email;
	}
	
	public void authenticate() {
		String[] splitted = email.split("@");
		if (splitted[1].equals("ozu.edu.tr"))
			auth = true;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public List<Course> getSelectedCourses() {
		return courses;
	}
	
	public boolean isAuth() {
		return auth;
	}
	
}