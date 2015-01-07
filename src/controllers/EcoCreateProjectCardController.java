package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Customer;
import objects.Project;
/**
 * ControllerClass for handling EcoCreateProjectCardGUI
 * @author Jimmy
 *
 */

public class EcoCreateProjectCardController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	/**
	 * Method for creating projects
	 * @param customer Customer of project
	 * @param cost Estimated cost of project
	 * @param start Estiamted start of project
	 * @param stop Estimanted stop of project
	 * @param pnr Name of project
	 */
	public void CreateProject(String customer, String cost, String start,String stop, String pnr) {
		Project project = new Project();
		project.setOrganisationNumber(customer);
		project.setEstimatedCost(cost);
		project.setEstimatedStart(start);
		project.setEstimatedStop(stop);
		project.setProjectNumber(pnr);
		db_mapper.insertNewProject(project);
}
	/**
	 * Return list of customers
	 * @return List of customers
	 */
	public List<Customer> getCustomers() {
		
		List <Customer> customers;
		customers = db_mapper.getAllCustomers();
		return customers;
		
	}

}
