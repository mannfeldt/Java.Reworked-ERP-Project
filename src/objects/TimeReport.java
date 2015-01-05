package objects;

public class TimeReport {
	
	private String SSN;
	private String projectNumber;
	private String date;
	private String startTime;
	private String stopTime;
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	
	public String toString() {
		return "Project: "+projectNumber
				+ ", date: " + date + ", Hours: " + startTime + ", Work: "
				+ stopTime + "]";
	}

	

}
