import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Wrapper;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class parser2 {
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {
		
		String sURL = "http://188.166.87.85/ehits.html"; 

	    // Connect to the URL using java's native library
	    URL url = new URL(sURL);
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); 
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
	    String zipcode = rootobj.get("semester").getAsString(); 
	    System.out.println(zipcode);
	    
	    Course course = new Course();
	    course.setSemester(rootobj.get("semester").getAsString());
	    System.out.println(course.semester);
	    
	    
	}    
}