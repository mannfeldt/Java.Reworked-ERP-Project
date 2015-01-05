package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.TimeReport;
import objects.ProjectMember;
import objects.User;

public class ConsultTimeReportController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());


public List<ProjectMember> getprojects(String sSN) {
		
		List<ProjectMember> projects;
		projects = db_mapper.getAllProjects(sSN);
		
		return projects;
		
		
	}

public void addTimeReport(String sSN, String projekt, String date, String start, String stop) {
	TimeReport n = new TimeReport();
	n.setSSN(sSN);
	n.setProjectNumber(projekt);
	n.setDate(date);
	n.setStartTime(start);
	n.setStopTime(stop);
	
	db_mapper.insertNewTime(n);

}

public List<TimeReport> getTimeReport(String sSN) {
	List<TimeReport> timereports;
	timereports = db_mapper.getTimeReports(sSN);
	return timereports;
}
}
