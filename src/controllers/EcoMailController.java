package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.CustomerContact;
import objects.Employee;
/**
 * ControllerClass for handling EcomailCardGUI
 * @author Jimmy
 *
 */
public class EcoMailController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	public EcoMailController() {
		// TODO Auto-generated constructor stub
	}
/**
 * Return list of customer
 * @return list of customerobjects
 */
	public List<CustomerContact> getAllCustomers() {
		List<CustomerContact> employees;
		employees = db_mapper.getAllContactCustomers();
		return employees;
	}

}
