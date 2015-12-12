
public class Exam {
	
	private String examDate;
	private String examPlace;
	private int durationMin;
	
	public Exam(String date, String place, int duration) {
		examDate = date;
		examPlace = place;
		durationMin = duration;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getExamPlace() {
		return examPlace;
	}

	public void setExamPlace(String examPlace) {
		this.examPlace = examPlace;
	}

	public int getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(int durationMin) {
		this.durationMin = durationMin;
	}
	
	
	
}
