package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import controllers.AdminNewUserCardController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminNewUserCard extends JPanel {
	private JTextField txtSSN;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPassword;
	JComboBox<String> comboBox;
	private AdminNewUserCardController Controller;

	public AdminNewUserCard() {
		setLayout(null);
	Controller = new AdminNewUserCardController();		

		
		txtSSN = new JTextField();
		txtSSN.setBounds(141, 6, 134, 28);
		txtSSN.setColumns(10);
		add(txtSSN);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(141, 43, 134, 28);
		txtFirstName.setColumns(10);
		add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(141, 80, 134, 28);
		txtLastName.setColumns(10);
		add(txtLastName);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(141, 117, 134, 28);
		txtPassword.setColumns(10);
		add(txtPassword);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(141, 154, 134, 27);
		add(comboBox);
		
		comboBox.addItem("Consultant");
		comboBox.addItem("Economy user");
		comboBox.addItem("HR user");
		comboBox.addItem("Admin");
		comboBox.addItem("Management");
		
		JLabel label = new JLabel("SSN:");
		label.setBounds(101, 15, 28, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(89, 51, 40, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Surname:");
		label_2.setBounds(71, 87, 58, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setBounds(66, 123, 63, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Authorization level:");
		label_4.setBounds(6, 159, 123, 16);
		add(label_4);
		
		JButton button = new JButton("Create User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String AuthorLevel = comboBox.getSelectedItem().toString();
				String ssn = txtSSN.getText();
				String pass = txtPassword.getText();
				String name = txtFirstName.getText();
				String surname = txtLastName.getText();

				Controller.addNewPerson(ssn, pass, name, surname, AuthorLevel);
			}
		});
		button.setBounds(89, 214, 116, 29);
		add(button);
		
	}

}
