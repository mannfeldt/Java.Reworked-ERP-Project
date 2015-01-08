package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.User;
/**
 * ControllerClass for handling AdminCardGUI
 * @author Jimmy
 *
 */

public class HrEmployeeCardController {

	db_Mapper loginMapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());

	/**
	 * Return list of all users
	 * @return List of all users
	 */
	public List<User> getAllUsers() {
		List<User> users;
		users = loginMapper.getAllUsers();
		return users;
	}

/**
 * Method for updating user
 * @param user Selected personal to be updated
 */
	public void updateUser(User user) {
		loginMapper.updateUser(user);
		

	}
	
}
