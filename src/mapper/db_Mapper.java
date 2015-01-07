package mapper;



import java.util.List;

import javax.swing.JOptionPane;

import objects.TimeReport;
import objects.ProjectMember;
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
	public List<Project> getAllProjects() {
		List<Project> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try{
			//continue with this in login.xml. create method selectallprojects
			list = session.selectList("Login.selectEveryProject");
		}finally{
			session.close();
		}
		return list;
	}

	public void insertNewAllocation(objects.ProjectMember member) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("Login.insertallocation", member);
			JOptionPane.showMessageDialog(null,
					"Successfully added allocation to project: "+member.getProjectNumber(), "New allocation",
					JOptionPane.PLAIN_MESSAGE);

		} catch (PersistenceException e) {
		
			JOptionPane.showMessageDialog(null, "Employee is already allocated to this project.",
					"Employee not allocated", JOptionPane.ERROR_MESSAGE);

		} finally {
			session.commit();
			session.close();
		}
		
	}
	public List<ProjectMember> getAllProjects(String SSN) {

		List<ProjectMember> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Login.selectAllProjects", SSN);
		} finally {
			session.close();
		}
		return list;
	}
	
	public void insertNewTime(TimeReport n) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("Login.insertTime", n);
			JOptionPane.showMessageDialog(null,
					"Successfully added TimeReport.", "TimeReport added",
					JOptionPane.PLAIN_MESSAGE);

		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null,
					"Timereport already exist on current date",
					"Timereport not added", JOptionPane.ERROR_MESSAGE);

		} finally {
			session.commit();
			session.close();
		}

	}

    public String getOrganisationNumber(String companyName) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            return session.selectOne("Login.selectOrganisationNumber", companyName);

        } finally {
            session.close();

        }
    }
        
        public List<Project> getCustomerProjects(String organisationNumber) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            return session.selectList("Login.selectCustomerProjects", organisationNumber);

        } finally {
            session.close();

        }

    }



		public List<TimeReport> getTimeReports(String SSN) {
			List<TimeReport> list = null;
			SqlSession session = sqlSessionFactory.openSession();

			try {
				list = session.selectList("Login.selectAllReports",SSN);
			} finally {
				session.close();
			}
			return list;

		}



		public List<objects.ProjectMember> getAllProjectMembers(String projectNumber) {
			List<ProjectMember> list = null;
			SqlSession session = sqlSessionFactory.openSession();

			try {
				list = session.selectList("Login.selectAllProjectMemebers",projectNumber);
			} finally {
				session.close();
			}
			return list;
		}



	

}
