package mapper;



import java.util.List;

import javax.swing.JOptionPane;

import objects.CustomerContact;
import objects.Skill;
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
/**
 * Class to handle db
 * @author Jimmy
 *
 */
public class db_Mapper {

	private SqlSessionFactory sqlSessionFactory = null;

	public db_Mapper(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
        
        
	/**
	 * Method to add new user to db
	 * @param person Person
	 * @param employee Employee
	 * @param login Employess login
	 */
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
	/**
	 * Return list of all users from db
	 * @return List of all users from db
	 */
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
	/**
	 * Return list of all Paymentsinc from db
	 * @return List of all Paymentsinc from db
	 */
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

/**
 * Updates user in db
 * @param user User/employee to update
 */
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

/**
 * Inserts project into db
 * @param project Project to insert in db
 */
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
	/**
	 * Return list of all customer from db
	 * @return List of all customer from db
	 */

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
	/**
	 * Return list of all employees from db
	 * @return List of all employees from db
	 */
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
	/**
	 * Return list of all Projects from db
	 * @return List of all Projects from db
	 */
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
/**
 * Insert alloaction of employee into db
 * @param member employee 
 */
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
	/**
	 * Return list of projects of certain Projectmebers from db
	 * @param SSN Social Securiy Number
	 * @return List of projects of certain projectmember from db
	 */
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
	/**
	 * Insert new timereport into db
	 * @param n Timereport
	 */
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
        /**
         * 
         * @param organisationNumber Organisationnumber of cutomer
         * @return Customers projects
         */
        public List<Project> getCustomerProjects(String organisationNumber) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            return session.selectList("Login.selectCustomerProjects", organisationNumber);

        } finally {
            session.close();

        }

    }

/**
 * Return list of all timereports for a employee from db
 * @param SSN Social Security Number
 * @return List of all Ttmereports for a employee from db
 */

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
                
    public List<TimeReport> getTimeReportProject(String projectNumber) {
        List<TimeReport> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Login.selectTimeReportProject", projectNumber);
        } finally {
            session.close();
        }
        return list;

    }

/**
 * Return list of all projectmembers under a certain project from db
 * @param projectNumber projectNumber
 * @return List of all projectMembers under a certain project from db
 */

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



	

/**
 * Return list of all skills for certain employee from db
 * @param SSN Social Security Number
 * @return List of all skills for certain employee from db
 */

		public List<Skill> getAllSkills(String SSN) {
			List<Skill> list = null;
			SqlSession session = sqlSessionFactory.openSession();

			try {
				list = session.selectList("Login.selectAllSkills",SSN);
			} finally {
				session.close();
			}
			return list;
		}
/**
 * Return list of all Cutomercontacts from db
 * @return List of all Cutomercontacts from db
 */

public List<CustomerContact> getAllContactCustomers() {
	List<CustomerContact> list = null;
	SqlSession session = sqlSessionFactory.openSession();

	try {
		list = session.selectList("Login.selectAllContactCustomer");
	} finally {
		session.close();
	}
	return list;
}



	

}
