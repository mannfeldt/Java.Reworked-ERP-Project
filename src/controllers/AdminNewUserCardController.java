package controllers;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Employee;
import objects.Login;
import objects.Person;

public class AdminNewUserCardController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	public void addNewPerson(String SSN, String password, String name, String surname, String AuthorizationLevel){
		Person person = new Person(SSN, name, surname);
		Employee employee = new Employee(SSN);
		Login login = new Login(SSN, password, AuthorizationLevel);
		
		db_mapper.insertNewUser(person, employee, login);

		
	}

}
