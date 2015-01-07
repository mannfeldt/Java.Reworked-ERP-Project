package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controllers.EcoCreateProjectCardController;
import controllers.InputHandler;
import controllers.TextFieldLimit;
import objects.Customer;
import objects.ProjectMember;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;
/**
 * GUIClass for EcoCreateProjectCard
 * @author Jimmy
 *
 */
public class EcoCreateProjectCard extends JPanel {

	private EcoCreateProjectCardController Controller;
	private JDateChooser dateChooserprojectstart;
	private JDateChooser dateChooserprojectstop;
	private InputHandler  inputhandler = new InputHandler();
	private DateFormat df = DateFormat.getDateInstance();
	private Date datenow =new Date();
	protected static final JComboBox CustomerList = null;
	private JTextField txtEstCost;
	private JTextField txtProjNumber;
	private JComboBox comboBox;

	private List<Customer> customerList;

	public EcoCreateProjectCard() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		Controller = new EcoCreateProjectCardController();		


		txtEstCost = new JTextField();
		txtEstCost.setBounds(124, 57, 278, 28);
		txtEstCost.setColumns(10);
		add(txtEstCost);
		txtEstCost.setDocument(new TextFieldLimit(10));

		txtEstCost.addKeyListener(new KeyAdapter() {
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


		txtProjNumber = new JTextField();
		txtProjNumber.setBounds(124, 97, 278, 28);
		txtProjNumber.setColumns(10);
		add(txtProjNumber);
		txtProjNumber.setDocument(new TextFieldLimit(6));

		JLabel lblProjectBudget = new JLabel("Project budget");
		lblProjectBudget.setBounds(19, 67, 93, 16);
		add(lblProjectBudget);

		JLabel label_1 = new JLabel("Start date");
		label_1.setBounds(19, 147, 60, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Stop date");
		label_2.setBounds(19, 187, 59, 16);
		add(label_2);

		JLabel lblProjectname = new JLabel("Project name");
		lblProjectname.setBounds(19, 107, 95, 16);
		add(lblProjectname);

		comboBox = new JComboBox();
		comboBox.setBounds(124, 18, 278, 27);
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
				String estimatedStart = df.format(dateChooserprojectstart.getDate());
				String estimatedStop = df.format(dateChooserprojectstop.getDate());
				String projectNumber = txtProjNumber.getText();
				
				if(inputhandler.checkIFProjectNumber(projectNumber)){
				Controller.CreateProject(customerNumber, estimatedCost,
						estimatedStart, estimatedStop, projectNumber);
				}
			}
		});
		btnCreateProject.setBounds(124, 213, 169, 28);
		add(btnCreateProject);

		JLabel label_4 = new JLabel("Costumer");
		label_4.setBounds(19, 27, 61, 16);
		add(label_4);
		
		dateChooserprojectstart = new JDateChooser();
		dateChooserprojectstart.setBounds(124, 147, 169, 20);
		add(dateChooserprojectstart);
		dateChooserprojectstart.setDate(datenow);
		((JTextField)dateChooserprojectstart.getDateEditor().getUiComponent()).setEditable(false); 
		
		dateChooserprojectstop = new JDateChooser();
		dateChooserprojectstop.setBounds(124, 183, 169, 20);
		add(dateChooserprojectstop);
		dateChooserprojectstop.setDate(datenow);
		((JTextField)dateChooserprojectstop.getDateEditor().getUiComponent()).setEditable(false); 

	}
}
