package mapper;



import java.util.List;

import javax.swing.JOptionPane;

import objects.Login;
import objects.Person;
import objects.Employee;
import objects.PaymentIncoming;
import objects.Customer;
import objects.Project;
import objects.User;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class db_Mapper {

	private SqlSessionFactory sqlSessionFactory = null;

	public db_Mapper(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
        
        
	
	public void insertNewUser(Person person, Employee employee, Login login) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("Login.insertPerson", person);
			session.insert("Login.insertEmployee", employee);
			session.insert("Login.insertLogin", login);
			
			JOptionPane.showMessageDialog(null,
					"Successfully added new user.",
				    "New user added",
				    JOptionPane.PLAIN_MESSAGE);

		}catch(PersistenceException e){
			JOptionPane.showMessageDialog(null,
					"User already exist",
				    "User not added",
				    JOptionPane.ERROR_MESSAGE);
		
		}finally {
			session.commit();
			session.close();
			
		}

	}
	
	public List<User> getAllUsers() {
		List<User> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Login.selectAllUsers");
		} finally {
			session.close();
		}
		return list;

	}
	
	public List<PaymentIncoming> getAllIncomingPayments() {
		List<PaymentIncoming> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Login.selectAllIncomingPayments");
		} finally {
			session.close();
		}

		return list;

	}


	public void updateUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.update("Login.updatePerson", user);
			session.update("Login.updateEmployee", user);
			session.update("Login.updateLogin", user);
			JOptionPane.showMessageDialog(null,
					"User information sucessfully updated",
					"information update", JOptionPane.PLAIN_MESSAGE);

		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "User already exist",
					"User not updated", JOptionPane.ERROR_MESSAGE);

		} finally {
			session.commit();
			session.close();
		}
	}


	public void insertNewProject(Project project) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("Login.insertproject", project);
			JOptionPane.showMessageDialog(null,
					"Successfully added new project.", "New user added",
					JOptionPane.PLAIN_MESSAGE);

		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Project already exist",
					"User not updated", JOptionPane.ERROR_MESSAGE);

		} finally {
			session.commit();
			session.close();
		}

	}

	public List<Customer> getAllCustomers() {
		List <Customer> list;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("Login.selectAllCustomers");
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try{
			list = session.selectList("Login.selectAllEmployees");
		}finally{
			session.close();
		}
		return list;
	}
	
}