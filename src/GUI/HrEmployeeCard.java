package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import objects.User;

import java.awt.Color;
import java.util.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import controllers.HrEmployeeCardController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HrEmployeeCard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HrEmployeeCardController Controller;

	DefaultListModel<User> allUsersModel;
	private List<User> usersList;
	private JList<User> list;

	private JComboBox<String> cmbAuthorization;
	private JTextField txtSSN;
	private JTextField txtFirstName;
	private JTextField txtDateOfEmployement;
	private JTextField txtLastname;
	private JTextField txtWage;
	private JTextField txtCountry;
	private JTextField txtPassword;
	private JTextField txtCity;
	private JTextField txtEmail;
	private JTextField txtZipCode;
	private JTextField txtStreet;
	private JTextField txtAccountnr;
	private JTextField txtPhone;

	public HrEmployeeCard() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				getAllusers();
			}
		});
		
		Controller = new HrEmployeeCardController();

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(113, 11, 28, 16);
		add(lblSsn);

		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});
		button.setBounds(299, 6, 88, 29);
		add(button);

		JLabel label_1 = new JLabel("Firstname");
		label_1.setBounds(79, 40, 62, 16);
		add(label_1);

		JLabel label_2 = new JLabel("Lastname");
		label_2.setBounds(81, 69, 60, 16);
		add(label_2);

		JLabel label_3 = new JLabel("Street");
		label_3.setBounds(105, 156, 36, 16);
		add(label_3);

		JLabel label_4 = new JLabel("Phone");
		label_4.setBounds(103, 214, 38, 16);
		add(label_4);

		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(107, 243, 34, 16);
		add(label_5);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(153, 35, 134, 28);
		txtFirstName.setColumns(10);
		add(txtFirstName);

		txtSSN = new JTextField();
		txtSSN.setEditable(false);
		txtSSN.setBounds(153, 6, 134, 28);
		txtSSN.setColumns(10);
		add(txtSSN);

		txtDateOfEmployement = new JTextField();
		txtDateOfEmployement.setBounds(153, 325, 134, 28);
		txtDateOfEmployement.setColumns(10);
		add(txtDateOfEmployement);

		txtLastname = new JTextField();
		txtLastname.setBounds(153, 64, 134, 28);
		txtLastname.setColumns(10);
		add(txtLastname);

		txtWage = new JTextField();
		txtWage.setBounds(153, 267, 134, 28);
		txtWage.setColumns(10);
		add(txtWage);

		txtCountry = new JTextField();
		txtCountry.setBounds(153, 93, 134, 28);
		txtCountry.setColumns(10);
		add(txtCountry);

		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setBounds(153, 354, 134, 28);
		txtPassword.setColumns(10);
		add(txtPassword);

		JLabel label_6 = new JLabel("City");
		label_6.setBounds(116, 127, 25, 16);
		add(label_6);

		JLabel label_7 = new JLabel("Country");
		label_7.setBounds(91, 98, 50, 16);
		add(label_7);

		txtCity = new JTextField();
		txtCity.setBounds(153, 122, 134, 28);
		txtCity.setColumns(10);
		add(txtCity);

		JLabel label_8 = new JLabel("ZipCode");
		label_8.setBounds(89, 185, 52, 16);
		add(label_8);

		txtEmail = new JTextField();
		txtEmail.setBounds(153, 238, 134, 28);
		txtEmail.setColumns(10);
		add(txtEmail);

		JLabel label_9 = new JLabel("Date of Employement");
		label_9.setBounds(6, 330, 135, 16);
		add(label_9);

		txtZipCode = new JTextField();
		txtZipCode.setBounds(153, 180, 134, 28);
		txtZipCode.setColumns(10);
		add(txtZipCode);

		JLabel label_10 = new JLabel("Wage");
		label_10.setBounds(108, 272, 33, 16);
		add(label_10);

		txtStreet = new JTextField();
		txtStreet.setBounds(153, 151, 134, 28);
		txtStreet.setColumns(10);
		add(txtStreet);

		JLabel label_11 = new JLabel("Accountnr");
		label_11.setBounds(76, 301, 65, 16);
		add(label_11);

		txtAccountnr = new JTextField();
		txtAccountnr.setBounds(153, 296, 134, 28);
		txtAccountnr.setColumns(10);
		add(txtAccountnr);

		JLabel label_12 = new JLabel("Password");
		label_12.setBounds(82, 359, 59, 16);
		add(label_12);

		txtPhone = new JTextField();
		txtPhone.setBounds(153, 209, 134, 28);
		txtPhone.setColumns(10);
		add(txtPhone);

		JLabel label_13 = new JLabel("Authorization");
		label_13.setBounds(53, 387, 86, 16);
		add(label_13);

		cmbAuthorization = new JComboBox<String>();
		cmbAuthorization.setBounds(150, 385, 138, 27);
		add(cmbAuthorization);
		cmbAuthorization.addItem("Consultant");
		cmbAuthorization.addItem("Economy user");
		cmbAuthorization.addItem("HR user");
		cmbAuthorization.addItem("Admin");
		cmbAuthorization.addItem("Management");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(409, 11, 278, 473);
		add(scrollPane);

		list = new JList<User>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			updateFields();
			}
		});
		allUsersModel = new DefaultListModel<User>();
		list.setModel(allUsersModel);
		scrollPane.setViewportView(list);
		
		list.setSelectedIndex(0);

	}
	private void updateFields() {
		int a = list.getSelectedIndex();
		if (!(a == -1)) {
			User user = list.getSelectedValue();

			txtFirstName.setText(user.getFirstName());
			txtLastname.setText(user.getLastName());
			txtCity.setText(user.getCity());
			txtCountry.setText(user.getCountry());
			txtZipCode.setText(user.getZipCode());
			txtSSN.setText(user.getSSN());
			txtWage.setText(user.getWage());
			txtDateOfEmployement.setText(user.getEmployeeDate());
			txtEmail.setText(user.getEmail());
			txtAccountnr.setText(user.getAccountNumber());
			txtPhone.setText(user.getPhoneNumber());
			txtStreet.setText(user.getStreet());
			txtPassword.setText("*******");

			String auti = user.getAuthorizationLevel();
			if (auti.equals("Consultant")) {
				cmbAuthorization.setSelectedIndex(0);
			}
			if (auti.equals("Economy user")) {
				cmbAuthorization.setSelectedIndex(1);
			}
			if (auti.equals("HR user")) {
				cmbAuthorization.setSelectedIndex(2);
			}
			if (auti.equals("Admin")) {
				cmbAuthorization.setSelectedIndex(3);
			}
			if (auti.equals("Management")) {
				cmbAuthorization.setSelectedIndex(4);
			}
		}

	}


	public void getAllusers() {

		usersList = Controller.getAllUsers();
		
		if (usersList.size() > 0) {
			for (int i = 0; i < usersList.size(); i++) {
				allUsersModel.add(i, usersList.get(i));
			}
			list.setSelectedIndex(0);
		}
	}
	
	private void updateUser() {
		User newUser = new User();
		newUser.setSSN(txtSSN.getText());
		newUser.setFirstName(txtFirstName.getText());
		newUser.setLastName(txtLastname.getText());
		newUser.setCity(txtCity.getText());
		newUser.setCountry(txtCountry.getText());
		newUser.setZipCode(txtZipCode.getText());
		newUser.setWage(txtWage.getText());
		newUser.setEmployeeDate(txtDateOfEmployement.getText());
		newUser.setEmail(txtEmail.getText());
		newUser.setAccountNumber(txtAccountnr.getText());
		newUser.setPhoneNumber(txtPhone.getText());
		newUser.setStreet(txtStreet.getText());
		newUser.setAuthorizationLevel(cmbAuthorization.getSelectedItem().toString());
		
		Controller.updateUser(newUser);
		allUsersModel.removeAllElements();
		getAllusers();
	}

}
