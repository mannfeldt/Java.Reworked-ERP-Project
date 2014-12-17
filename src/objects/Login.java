package objects;

public class Login {

	private String SSN;
	private String password;
	private int isThere;
	private String AuthorizationLevel;
	
	public Login(String ssn, String Password, String Authorizationlevel){
		this.SSN = ssn;
		this.password = Password;
		this.AuthorizationLevel = Authorizationlevel;
	}
	
	public Login(){
		
	}
	
	public String getAuthorizationLevel() {
		return AuthorizationLevel;
	}
	public void setAuthorizationLevel(String authorizationLevel) {
		AuthorizationLevel = authorizationLevel;
	}
	public int getIsThere(){
		return isThere;
	}
	public void setIsThere(int isthere){
		isThere = isthere;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "Login [SSN=" + SSN + ", password=" + password
				+ ", isThere: " + isThere + "]";
	}

	
	
}
