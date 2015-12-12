import java.util.*;


public class Program {

	private static Parser parser = new Parser();
	
	private User user;
	private List<Course> offeredCourses;
	private List<Course> selectedCourses;
	
	public Program(String userMail) {
		user = new User(userMail);
		offeredCourses = parser.getOfferedCourses();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Course> getOfferedCourses() {
		return offeredCourses;
	}

	public List<Course> getSelectedCourses() {
		return selectedCourses;
	}

}
