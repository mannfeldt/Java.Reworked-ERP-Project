package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.User;


public class HrEmployeeCardController {

	db_Mapper loginMapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	
	public List<User> getAllUsers() {
		List<User> users;
		users = loginMapper.getAllUsers();
		return users;
	}


	public void updateUser(User user) {
		loginMapper.updateUser(user);
		

	}
	
}
