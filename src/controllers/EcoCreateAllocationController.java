package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.ProjectMember;
import objects.Skill;

import objects.User;
import objects.Project;

public class EcoCreateAllocationController {

	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());
	
	public List<Project> getallprojects() {
		List<Project> projects;
		projects = db_mapper.getAllProjects();
		return projects;
	}
	public List<User> getAllPersons() {
		List<User> users;
		users = db_mapper.getAllUsers();
		return users;
	}
	public void CreateAllocation(String rate, String pnr, String role,String ssn, String workload) {
		ProjectMember member = new ProjectMember();
		member.setHourlyRate(rate);
		member.setProjectNumber(pnr);
		member.setRole(role);
		member.setWorkload(workload);
		member.setSSN(ssn);
	
		db_mapper.insertNewAllocation(member);
	
}
	public List<Skill> getSkill(String SSN) {
		List<Skill> users;
		users = db_mapper.getAllSkills(SSN);
		return users;
	}

}
