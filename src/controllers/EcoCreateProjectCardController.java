package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Customer;
import objects.Project;


public class EcoCreateProjectCardController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());


	public void CreateProject(String customer, String cost, String start,String stop, String pnr) {
		Project project = new Project();
		project.setOrganisationNumber(customer);
		project.setEstimatedCost(cost);
		project.setEstimatedStart(start);
		project.setEstimatedStop(stop);
		project.setProjectNumber(pnr);
		db_mapper.insertNewProject(project);
}
	
	public List<Customer> getCustomers() {
		
		List <Customer> customers;
		customers = db_mapper.getAllCustomers();
		return customers;
		
	}

}
