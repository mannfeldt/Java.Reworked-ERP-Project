package controllers;

import java.util.List;

import objects.Employee;
import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;

public class EcoWagesCardController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());


	
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees;
		employees = db_mapper.getAllEmployees();
		return employees;
	}


}
