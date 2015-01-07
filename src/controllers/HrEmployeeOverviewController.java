package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Project;
import objects.ProjectMember;
import objects.TimeReport;
/**
 * ControllerClass for handling AdminCardGUI
 * @author Jimmy
 *
 */
public class HrEmployeeOverviewController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	public HrEmployeeOverviewController() {
		// TODO Auto-generated constructor stub
	}
/**
 * Return list of Projectmembers of certain project pnr
 * @param pnr ProjectNumber/name
 * @return List of Projectmembers of certain project pnr
 */
	public List<ProjectMember> getAllUsers(String pnr) {
		List<ProjectMember> ProjectMember;
		ProjectMember = db_mapper.getAllProjectMembers(pnr);
		return ProjectMember;
	}
/**
 * Return list of all projects
 * @return List of all projects
 */
	public List<Project> getprojects() {
		List<Project> projects;
		projects = db_mapper.getAllProjects();
		return projects;
	}
}
