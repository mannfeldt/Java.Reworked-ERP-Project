package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controllers.EcoCreateProjectCardController;
import objects.Customer;
import objects.ProjectMember;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class EcoCreateProjectCard extends JPanel {

	private EcoCreateProjectCardController Controller;

	protected static final JComboBox CustomerList = null;
	private JTextField txtEstCost;
	private JTextField txtProjNumber;
	private JTextField txtStopDate;
	private JTextField txtStartDate;
	private JComboBox comboBox;

	private List<Customer> customerList;

	public EcoCreateProjectCard() {
		setLayout(null);
		Controller = new EcoCreateProjectCardController();		


		txtEstCost = new JTextField();
		txtEstCost.setBounds(124, 57, 134, 28);
		txtEstCost.setColumns(10);
		add(txtEstCost);

		txtProjNumber = new JTextField();
		txtProjNumber.setBounds(124, 97, 134, 28);
		txtProjNumber.setColumns(10);
		add(txtProjNumber);

		JLabel label = new JLabel("Estimated cost");
		label.setBounds(19, 67, 93, 16);
		add(label);

		JLabel label_1 = new JLabel("Start date");
		label_1.setBounds(19, 147, 60, 16);
		add(label_1);

		txtStopDate = new JTextField();
		txtStopDate.setBounds(124, 177, 134, 28);
		txtStopDate.setColumns(10);
		add(txtStopDate);

		JLabel label_2 = new JLabel("Stop date");
		label_2.setBounds(19, 187, 59, 16);
		add(label_2);

		txtStartDate = new JTextField();
		txtStartDate.setBounds(124, 137, 134, 28);
		txtStartDate.setColumns(10);
		add(txtStartDate);

		JLabel label_3 = new JLabel("Project number");
		label_3.setBounds(19, 107, 95, 16);
		add(label_3);

		comboBox = new JComboBox();
		comboBox.setBounds(124, 18, 134, 27);
		add(comboBox);

		customerList = Controller.getCustomers();
		
		for(int i =0;i<customerList.size();i++){
			comboBox.addItem(customerList.get(i));
		}
	
		JButton btnCreateProject = new JButton("Create project");
		btnCreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer n = new Customer();
				n = (Customer) comboBox.getSelectedItem();
				String customerNumber = n.getOrganisationNumber();
				String estimatedCost = txtEstCost.getText();
				String estimatedStart = txtStartDate.getText();
				String estimatedStop = txtStopDate.getText();
				String projectNumber = txtProjNumber.getText();

				Controller.CreateProject(customerNumber, estimatedCost,
						estimatedStart, estimatedStop, projectNumber);
			}
		});
		btnCreateProject.setBounds(61, 227, 132, 29);
		add(btnCreateProject);

		JLabel label_4 = new JLabel("Costumer");
		label_4.setBounds(19, 27, 61, 16);
		add(label_4);

	}

}
