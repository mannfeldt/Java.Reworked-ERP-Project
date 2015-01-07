package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.ProjectMember;
import objects.TimeReport;

public class HrEmployeeOverviewController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	public HrEmployeeOverviewController() {
		// TODO Auto-generated constructor stub
	}

	public List<ProjectMember> getAllUsers() {
		List<ProjectMember> ProjectMember;
		ProjectMember = db_mapper.getAllProjectMembers();
		return ProjectMember;
	}

}
