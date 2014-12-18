package GUI;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import controllers.EcoWagesCardController;

import javax.swing.JList;

import objects.Employee;
import objects.User;
import java.awt.Color;

public class EcoWagesCard extends JPanel {

	private EcoWagesCardController Controller;
	
	private List<Employee> employees;
	JList<Employee> employeesWageList;
	DefaultListModel<Employee> employeesWageModel;

	public EcoWagesCard() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		Controller = new EcoWagesCardController();		

		employeesWageModel = new DefaultListModel<Employee>();
		employeesWageList = new JList<Employee>();
		employeesWageList.setBounds(6, 6, 420, 441);
		add(employeesWageList);
		employeesWageList.setModel(employeesWageModel);
		
		getAllEmployees();
	}
	
	private void getAllEmployees(){
		employees = Controller.getAllEmployees();
		for (int i = 0; i < employees.size(); i++) {
			employeesWageModel.add(i, employees.get(i));
		}
		employeesWageList.setSelectedIndex(0);
	}

}
