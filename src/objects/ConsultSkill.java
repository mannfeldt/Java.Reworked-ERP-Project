package objects;

public class ConsultSkill {
	private String SSN;
	private String skillsId;
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getSkillsId() {
		return skillsId;
	}
	public void setSkillsId(String skillsId) {
		this.skillsId = skillsId;
	}
	
	public String toString() {
		return "ConsultSkill [SSN=" + SSN + ", skillsId=" + skillsId + "]";
	}

	
}
