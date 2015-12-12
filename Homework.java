
public class Homework {
	
	private String givenDate;
	private String deadline;
	
	public Homework(String givenDate, String deadline) {
		this.givenDate = givenDate;
		this.deadline = deadline;
	}

	public String getGivenDate() {
		return givenDate;
	}

	public void setGivenDate(String givenDate) {
		this.givenDate = givenDate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
}
