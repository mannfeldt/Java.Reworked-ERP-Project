package objects;

public class User {
	private String SSN;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String street;
	private String city;
	private String country;
	private String zipCode;
	private String employeeDate;
	private String wage;
	private String accountNumber;
	private String password;
	private String authorizationLevel;
	
	
	public User(){
		
	}
	
	public User(String sSN, String firstName, String lastName, String email,
			String phoneNumber, String street, String city, String country,
			String zipCode, String employeeDate, String wage,
			String accountNumber, String password, String authorizationLevel) {
		
		this.SSN = sSN;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.employeeDate = employeeDate;
		this.wage = wage;
		this.accountNumber = accountNumber;
		this.password = password;
		this.authorizationLevel = authorizationLevel;
	}
	
	
	
	


	@Override
	public String toString() {
		return SSN + ", " + firstName + ", " + lastName;
	}

	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthorizationLevel() {
		return authorizationLevel;
	}
	public void setAuthorizationLevel(String authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}

	
	
	
}
