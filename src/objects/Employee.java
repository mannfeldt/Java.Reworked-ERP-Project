package objects;

public class Employee {
	
	private String SSN;
	private String employeeNumber;
	private String employeeDate;
	private String wage;
	private String accountNumber;
	
	public Employee(){
		
	}

	public Employee(String SSN, String employeeNumber, String employeeDate,
			String wage, String accountNumber) {
		this.SSN = SSN;
		this.employeeNumber = employeeNumber;
		this.employeeDate = employeeDate;
		this.wage = wage;
		this.accountNumber = accountNumber;
	}

	public Employee(String ssn){
		this.SSN = ssn;
	}
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeDate() {
		return employeeDate;
	}
	public void setEmployeeDate(String employeeDate) {
		this.employeeDate = employeeDate;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String toString() {
		return  SSN 
				+ " wage: " + wage+" SEK";
	}


}
