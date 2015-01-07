package GUI;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import controllers.AdminNewUserCardController;
import controllers.InputHandler;
import controllers.TextFieldLimit;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminNewUserCard extends JPanel {
	private JTextField txtSSN;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPassword;
	JComboBox<String> comboBox;
	private InputHandler  inputhandler = new InputHandler();
	private AdminNewUserCardController Controller;

	public AdminNewUserCard() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
	Controller = new AdminNewUserCardController();		

		
		txtSSN = new JTextField();
		txtSSN.setBounds(155, 11, 134, 28);
		txtSSN.setColumns(10);
		add(txtSSN);
		txtSSN.setDocument(new TextFieldLimit(12));
		
		txtSSN.addKeyListener(new KeyAdapter() {
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

		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(155, 48, 134, 28);
		txtFirstName.setColumns(10);
		add(txtFirstName);
		txtFirstName.setDocument(new TextFieldLimit(30));
		
		
		txtLastName = new JTextField();
		txtLastName.setBounds(155, 85, 134, 28);
		txtLastName.setColumns(10);
		add(txtLastName);
		txtLastName.setDocument(new TextFieldLimit(20));
		
		txtPassword = new JTextField();
		txtPassword.setBounds(155, 122, 134, 28);
		txtPassword.setColumns(10);
		add(txtPassword);
		txtPassword.setDocument(new TextFieldLimit(10));
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(155, 159, 134, 27);
		add(comboBox);
		
		comboBox.addItem("Consultant");
		comboBox.addItem("Economy user");
		comboBox.addItem("HR user");
		comboBox.addItem("Admin");
		comboBox.addItem("Management");
		
		JLabel label = new JLabel("SSN:");
		label.setBounds(24, 23, 28, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(24, 54, 40, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Surname:");
		label_2.setBounds(24, 91, 58, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setBounds(24, 128, 63, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Authorization level:");
		label_4.setBounds(24, 164, 123, 16);
		add(label_4);
		
		JButton button = new JButton("Create User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String AuthorLevel = comboBox.getSelectedItem().toString();
				String ssn = txtSSN.getText();
				String pass = txtPassword.getText();
				String name = txtFirstName.getText();
				String surname = txtLastName.getText();
				
				if(inputhandler.checkIFSSN(ssn)){
					Controller.addNewPerson(ssn, pass, name, surname, AuthorLevel);
				}
			}
		});
		button.setBounds(155, 197, 134, 29);
		add(button);
		
	}

}
