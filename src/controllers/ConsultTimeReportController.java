package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.TimeReport;
import objects.ProjectMember;
import objects.User;
/**
 * ControllerClass for handling ConsultTimeReportCardGUI
 * @author Jimmy
 */
public class ConsultTimeReportController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	/**
	 * Method for returning certain projects
	 * @param sSN Social Security Number
	 * @return List of projects for certain SSN
	 */
public List<ProjectMember> getprojects(String sSN) {
		
		List<ProjectMember> projects;
		projects = db_mapper.getAllProjects(sSN);
		
		return projects;
		
		
	}
/**
 * Method for adding a timereport
 * @param sSN Social Security Number
 * @param projekt Projectname
 * @param date Date timereport
 * @param start Amount of time worked, in hours
 * @param stop Comment of work done
 */
public void addTimeReport(String sSN, String projekt, String date, String start, String stop) {
	TimeReport n = new TimeReport();
	n.setSSN(sSN);
	n.setProjectNumber(projekt);
	n.setDate(date);
	n.setStartTime(start);
	n.setStopTime(stop);
	
	db_mapper.insertNewTime(n);

}
/**
 * Return timereports for a certain user
 * @param sSN Social Security Number
 * @return List of all timereports of a user
 */
public List<TimeReport> getTimeReport(String sSN) {
	List<TimeReport> timereports;
	timereports = db_mapper.getTimeReports(sSN);
	return timereports;
}
}
