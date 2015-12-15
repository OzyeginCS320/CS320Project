import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Parser {

	private static String URL = "http://188.166.87.85/ehits.html";
	List<Course> offeredCourses = new ArrayList<Course>();

	public Parser() throws IOException {
		parse();
	}

	public List<Course> getOfferedCourses() {
		return offeredCourses;
	}

	private void parse() throws IOException {
		URL url = new URL(URL);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		request.connect();

		JSONObject EHITSdata = (JSONObject) JSONValue.parse(new InputStreamReader((InputStream) request.getContent()));

		
		JSONArray courses = (JSONArray) EHITSdata.get("courses");

		for (int i = 0; i < courses.size(); i++) {
			JSONObject data = (JSONObject) courses.get(i);
			Course newCourse = new Course();
			newCourse.setFaculty((String) data.get("faculty"));
			newCourse.setSubject((String) data.get("subject"));
			newCourse.setInstructor((String) data.get("instructor"));
			newCourse.setSemester((String) data.get("semester"));
			newCourse.setCourseName((String) data.get("courseName"));
			newCourse.setCourseID((String) data.get("courseID"));
			JSONArray exams = (JSONArray) data.get("exams");
			JSONArray homeworks = (JSONArray) data.get("homeworks");
			for (int j = 0; j < exams.size(); j++) {
				JSONObject examJson = (JSONObject) exams.get(j);
				Exam exam = new Exam();
				exam.setExamDate((String) examJson.get("date"));
				exam.setExamPlace((String) examJson.get("place"));
				exam.setDurationMin((Long) examJson.get("duration"));
				newCourse.addExam(exam);
			}

			for (int j = 0; j < homeworks.size(); j++) {
				JSONObject homeworkJson = (JSONObject) homeworks.get(j);
				Homework homework = new Homework();
				homework.setGivenDate(((String) homeworkJson.get("givenDate")));
				homework.setDeadline(((String) homeworkJson.get("deadline")));
				newCourse.addHomework(homework);
			}
			offeredCourses.add(newCourse);
		}
	}

}
