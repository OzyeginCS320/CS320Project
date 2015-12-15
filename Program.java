import java.util.*;
import java.io.IOException;

public class Program {

	private static Parser parser;
	
	private User user;
	private List<Course> offeredCourses;
	private List<Course> selectedCourses;
	
	public Program(String userMail) throws IOException {
		parser = new Parser();
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
	
	public static void main(String[] args) throws IOException {
		Program program = new Program("arjen.kilic@zu.edu.tr");
		program.getUser().authenticate();
		System.out.println(program.getUser().isAuth());
		System.out.println(program.getOfferedCourses().get(0).getFaculty());
	}

}
