public class Exam {
	
	private String examDate;
	private String examPlace;
	private Long durationMin;
	
	public Exam(String date, String place, Long duration) {
		examDate = date;
		examPlace = place;
		durationMin = duration;
	}

	public Exam() {
		// TODO Auto-generated constructor stub
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

	public Long getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(Long durationMin) {
		this.durationMin = durationMin;
	}

	@Override
	public String toString() {
		return "Exam [examDate=" + examDate + ", examPlace=" + examPlace + ", durationMin=" + durationMin + "]";
	}
	
	
	
}