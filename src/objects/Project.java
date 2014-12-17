package objects;

public class Project {
	private String projectNumber;
	private String organisationNumber;
	private String estimatedStart;
	private String estimatedStop;
	private String actualStart;
	private String actualStop;
	private String estimatedCost;
	private String actualCost;
	
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getOrganisationNumber() {
		return organisationNumber;
	}
	public void setOrganisationNumber(String organisationNumber) {
		this.organisationNumber = organisationNumber;
	}
	public String getEstimatedStart() {
		return estimatedStart;
	}
	public void setEstimatedStart(String estimatedStart) {
		this.estimatedStart = estimatedStart;
	}
	public String getEstimatedStop() {
		return estimatedStop;
	}
	public void setEstimatedStop(String estimatedStop) {
		this.estimatedStop = estimatedStop;
	}
	public String getActualStart() {
		return actualStart;
	}
	public void setActualStart(String actualStart) {
		this.actualStart = actualStart;
	}
	public String getActualStop() {
		return actualStop;
	}
	public void setActualStop(String actualStop) {
		this.actualStop = actualStop;
	}
	public String getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	public String getActualCost() {
		return actualCost;
	}
	public void setActualCost(String actualCost) {
		this.actualCost = actualCost;
	}
	
	public String toString() {
		return projectNumber +" - "+ estimatedStart + " - " + estimatedCost;
	}
	
	
	
}
