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
import java.text.DateFormat;
import java.util.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import controllers.HrEmployeeCardController;
import controllers.TextFieldLimit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.toedter.calendar.JDateChooser;

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
	private JTextField emptext;
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
    private JDateChooser dateChooserEmp;//updated //U*
	private DateFormat df = DateFormat.getDateInstance();



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
		lblSsn.setBounds(20, 11, 28, 16);
		add(lblSsn);

		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});
		button.setBounds(341, 267, 200, 29);
		add(button);

		JLabel label_1 = new JLabel("Firstname");
		label_1.setBounds(20, 38, 62, 16);
		add(label_1);

		JLabel label_2 = new JLabel("Lastname");
		label_2.setBounds(20, 65, 60, 16);
		add(label_2);

		JLabel label_3 = new JLabel("Street");
		label_3.setBounds(20, 152, 36, 16);
		add(label_3);

		JLabel label_4 = new JLabel("Phone");
		label_4.setBounds(20, 212, 38, 16);
		add(label_4);

		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(20, 239, 34, 16);
		add(label_5);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(137, 35, 151, 28);
		txtFirstName.setColumns(10);
		add(txtFirstName);
		txtFirstName.setDocument(new TextFieldLimit(20));

		txtSSN = new JTextField();
		txtSSN.setEditable(false);
		txtSSN.setBounds(137, 6, 151, 28);
		txtSSN.setColumns(10);
		add(txtSSN);

		emptext = new JTextField();
		emptext.setEditable(false);
		emptext.setBounds(137, 325, 151, 28);
		emptext.setColumns(10);
		add(emptext);

		txtLastname = new JTextField();
		txtLastname.setBounds(137, 64, 151, 28);
		txtLastname.setColumns(10);
		add(txtLastname);
		txtLastname.setDocument(new TextFieldLimit(20));

		txtWage = new JTextField();
		txtWage.setBounds(137, 267, 151, 28);
		txtWage.setColumns(10);
		add(txtWage);
		txtWage.setDocument(new TextFieldLimit(6));
		
		txtWage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char i = arg0.getKeyChar();
				if(!(Character.isDigit(i)||(i==KeyEvent.VK_BACK_SPACE)|| i==KeyEvent.VK_DELETE ))
				{
					getToolkit().beep();
					arg0.consume();
				}
			}
		});

		txtCountry = new JTextField();
		txtCountry.setBounds(137, 93, 151, 28);
		txtCountry.setColumns(10);
		add(txtCountry);
		txtCountry.setDocument(new TextFieldLimit(20));

		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setBounds(137, 354, 151, 28);
		txtPassword.setColumns(10);
		add(txtPassword);

		JLabel label_6 = new JLabel("City");
		label_6.setBounds(20, 123, 25, 16);
		add(label_6);

		JLabel label_7 = new JLabel("Country");
		label_7.setBounds(20, 94, 50, 16);
		add(label_7);

		txtCity = new JTextField();
		txtCity.setBounds(137, 122, 151, 28);
		txtCity.setColumns(10);
		add(txtCity);
		txtCity.setDocument(new TextFieldLimit(10));

		JLabel label_8 = new JLabel("ZipCode");
		label_8.setBounds(20, 181, 52, 16);
		add(label_8);

		txtEmail = new JTextField();
		txtEmail.setBounds(137, 238, 151, 28);
		txtEmail.setColumns(10);
		add(txtEmail);
		txtEmail.setDocument(new TextFieldLimit(20));

		JLabel label_9 = new JLabel("Date of Employement");
		label_9.setBounds(20, 326, 135, 16);
		add(label_9);

		txtZipCode = new JTextField();
		txtZipCode.setBounds(137, 180, 151, 28);
		txtZipCode.setColumns(10);
		add(txtZipCode);
		txtZipCode.setDocument(new TextFieldLimit(10));
		
		txtZipCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char i = arg0.getKeyChar();
				if(!(Character.isDigit(i)||(i==KeyEvent.VK_BACK_SPACE)|| i==KeyEvent.VK_DELETE ))
				{
					getToolkit().beep();
					arg0.consume();
				}
			}
		});

		JLabel label_10 = new JLabel("Wage");
		label_10.setBounds(20, 268, 33, 16);
		add(label_10);

		txtStreet = new JTextField();
		txtStreet.setBounds(137, 151, 151, 28);
		txtStreet.setColumns(10);
		add(txtStreet);
		txtStreet.setDocument(new TextFieldLimit(20));

		JLabel label_11 = new JLabel("Accountnr");
		label_11.setBounds(20, 294, 65, 16);
		add(label_11);

		txtAccountnr = new JTextField();
		txtAccountnr.setBounds(137, 296, 151, 28);
		txtAccountnr.setColumns(10);
		add(txtAccountnr);
		txtAccountnr.setDocument(new TextFieldLimit(10));
		
		txtAccountnr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char i = arg0.getKeyChar();
				if(!(Character.isDigit(i)||(i==KeyEvent.VK_BACK_SPACE)|| i==KeyEvent.VK_DELETE ))
				{
					getToolkit().beep();
					arg0.consume();
				}
			}
		});

		JLabel label_12 = new JLabel("Password");
		label_12.setBounds(20, 355, 59, 16);
		add(label_12);

		txtPhone = new JTextField();
		txtPhone.setBounds(137, 209, 151, 28);
		txtPhone.setColumns(10);
		add(txtPhone);
		txtPhone.setDocument(new TextFieldLimit(20));
		
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char i = arg0.getKeyChar();
				if(!(Character.isDigit(i)||(i==KeyEvent.VK_BACK_SPACE)|| i==KeyEvent.VK_DELETE ))
				{
					getToolkit().beep();
					arg0.consume();
				}
			}
		});

		JLabel label_13 = new JLabel("Authorization");
		label_13.setBounds(20, 382, 86, 16);
		add(label_13);

		cmbAuthorization = new JComboBox<String>();
		cmbAuthorization.setBounds(134, 385, 154, 27);
		add(cmbAuthorization);
		cmbAuthorization.addItem("Consultant");
		cmbAuthorization.addItem("Economy user");
		cmbAuthorization.addItem("HR user");
		cmbAuthorization.addItem("Admin");
		cmbAuthorization.addItem("Management");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(341, 6, 278, 473);
		add(scrollPane);
		scrollPane.setSize(200, 250);

		list = new JList<User>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			updateFields();
			}
		});
		allUsersModel = new DefaultListModel<User>();
		list.setModel(allUsersModel);
		scrollPane.setViewportView(list);
		list.setSize(200,250);
		list.setSelectedIndex(0);
		
		dateChooserEmp = new JDateChooser();
		dateChooserEmp.setBounds(291, 325, 25, 20);
		add(dateChooserEmp);
		((JTextField)dateChooserEmp.getDateEditor().getUiComponent()).setEditable(false);
		
		dateChooserEmp.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			            if ("date".equals(e.getPropertyName())) {
			            	String date = emptext.getText();
			        		
			        		if(dateChooserEmp.getDate()==null){
			        			date=emptext.getText();
			        		}else{
			        			date= df.format(dateChooserEmp.getDate());	
			        		}
			        		emptext.setText(date);
			            }
			        }
			    });

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
			emptext.setText(user.getEmployeeDate());
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
		
		String date=emptext.getText();
		
		if(dateChooserEmp.getDate()==null){
			date=emptext.getText();
		}else{
			date= df.format(dateChooserEmp.getDate());	
		}
		newUser.setEmployeeDate(date);
		
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
