import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Parser {
	public static void main(String[] args) throws IOException {
		
		String sURL = "http://188.166.87.85/ehits.html"; 

	    // Connect to the URL using java's native library
	    URL url = new URL(sURL);
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();

		JSONObject EHITSdata = (JSONObject) JSONValue.parse(new InputStreamReader((InputStream) request.getContent()));
		
		 Course course = new Course();
		 
			course.setInstructor((String) EHITSdata.get("instructor"));
			course.setSemester((String) EHITSdata.get("semester"));
			course.setCourseName((String) EHITSdata.get("courseName"));
			course.setCourseID((String) EHITSdata.get("courseID"));
	
	}
}
