package controllers;

import java.util.List;

import objects.Employee;
import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
/**
 * ControllerClass for handling EcoWagesCardGUI
 * @author Jimmy
 *
 */
public class EcoWagesCardController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());


	
	/**
	 * List of all Employess
	 * @return List of Employess
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> employees;
		employees = db_mapper.getAllEmployees();
		return employees;
	}


}
