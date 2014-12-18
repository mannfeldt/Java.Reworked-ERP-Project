package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

import controllers.ConsultTimeReportController;
import controllers.EcoCreateAllocationController;
import controllers.InputHandler;
import controllers.LoginController;
import controllers.TextFieldLimit;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import objects.ProjectMember;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConTimeReport extends JPanel {

	private JPanel contentPane;
	private JTextField stoptp;
	private JTextField starttp;
	private List<ProjectMember> projects;
	private JComboBox projectbox;
	private JDateChooser dateChooserTimeReport; //timreport
	private DateFormat df = DateFormat.getDateInstance();
	private Date datenow =new Date();
	private InputHandler inputhandler= new InputHandler();
	ConsultTimeReportController controller = new ConsultTimeReportController();
	String user = controllers.LoginController.loggedinuser;
	

	public ConTimeReport() {
		setLayout(null);
		setBounds(100, 100, 541, 333);
		setBackground(Color.LIGHT_GRAY);
		
		JButton btnConfirmTimeReport = new JButton("Confirm");
		btnConfirmTimeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProjectMember n = new ProjectMember();
				n=(ProjectMember) projectbox.getSelectedItem();
				
				String projekt = n.getProjectNumber().toString();
				String start = starttp.getText();
				String stop = stoptp.getText();
				String date = df.format(dateChooserTimeReport.getDate());
				
			if(inputhandler.checkIFTime(stop)){
				if(inputhandler.checkIFTime(start)){
					controller.addTimeReport(user,projekt,date,start,stop);
				}
			}
			}
		});
		btnConfirmTimeReport.setBounds(66, 204, 124, 23);
		add(btnConfirmTimeReport);
		
		JLabel label = new JLabel("Date:");
		label.setBounds(10, 164, 61, 16);
		add(label);
		
		dateChooserTimeReport = new JDateChooser();
		dateChooserTimeReport.setBounds(66, 160, 155, 20);
		add(dateChooserTimeReport);
		dateChooserTimeReport.setDate(datenow);
		((JTextField)dateChooserTimeReport.getDateEditor().getUiComponent()).setEditable(false); 
		
		stoptp = new JTextField();
		stoptp.setColumns(10);
		stoptp.setBounds(66, 126, 124, 20);
		add(stoptp);
		stoptp.setDocument(new TextFieldLimit(4));
		
		stoptp.addKeyListener(new KeyAdapter() {
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
		
		starttp = new JTextField();
		starttp.setColumns(10);
		starttp.setBounds(66, 87, 124, 20);
		add(starttp);
		starttp.setDocument(new TextFieldLimit(4));
		
		starttp.addKeyListener(new KeyAdapter() {
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
		
		JLabel label_1 = new JLabel("Start");
		label_1.setBounds(10, 84, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Stop");
		label_2.setBounds(10, 123, 46, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Project");
		label_3.setBounds(10, 45, 74, 14);
		add(label_3);
		
		projectbox = new JComboBox();
		projectbox.setBounds(66, 45, 432, 20);
		add(projectbox);
		
		projects=controller.getprojects(user);
		
		for(int i =0;i<projects.size();i++){
			projectbox.addItem(projects.get(i));
			
			
			
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
	}
}
