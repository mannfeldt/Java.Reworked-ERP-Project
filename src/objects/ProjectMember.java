package objects;

public class ProjectMember {
	private String SSN;
	private Integer projectNumber;
	private String role;
	private String hourlyRate;
	private String workload;
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public Integer getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public String getWorkload() {
		return workload;
	}
	public void setWorkload(String workload) {
		this.workload = workload;
	}
	
	public String toString() {
		return "projectNumber: "
				+ projectNumber + ", role: " + role  + ", workload: " + workload +" %";
	}
	
	
	
}
