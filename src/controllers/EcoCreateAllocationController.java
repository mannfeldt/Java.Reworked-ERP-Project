package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.ProjectMember;
import objects.Skill;

import objects.User;
import objects.Project;
/**
 * ControllerClass for handling EcoCreateAllocationCardGUI
 * @author Jimmy
 *
 */
public class EcoCreateAllocationController {

	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());
	
	/**
	 * Return list of projects
	 * @return List of projects
	 */
	public List<Project> getallprojects() {
		List<Project> projects;
		projects = db_mapper.getAllProjects();
		return projects;
	}
	/**
	 * Return list of users
	 * @return List of users
	 */
	public List<User> getAllPersons() {
		List<User> users;
		users = db_mapper.getAllUsers();
		return users;
	}
	
	/**
	 * 
	 * @param rate Rate of hourly work
	 * @param pnr Projectnumber
	 * @param role Role in current project
	 * @param ssn Social Security Number
	 * @param workload Workload in current project(%)
	 */
	
	public void CreateAllocation(String rate, String pnr, String role,String ssn, String workload) {
		ProjectMember member = new ProjectMember();
		member.setHourlyRate(rate);
		member.setProjectNumber(pnr);
		member.setRole(role);
		member.setWorkload(workload);
		member.setSSN(ssn);
	
		db_mapper.insertNewAllocation(member);
	
}
	/**
	 * Return list of employeeskills
	 * @param SSN Social Security Number
	 * @return List of skills of a user
	 */
	
	public List<Skill> getSkill(String SSN) {
		List<Skill> users;
		users = db_mapper.getAllSkills(SSN);
		return users;
	}

}
