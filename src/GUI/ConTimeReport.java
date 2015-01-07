package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import objects.TimeReport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JList;

import objects.User;
/**
 * GUIClass for ConTimeReport
 * @author Jimmy
 *
 */
public class ConTimeReport extends JPanel {

	private JPanel contentPane;
	private JTextField worktxtf;
	
	DefaultListModel<TimeReport> allTimeReportModel;
	private List<TimeReport> timeReportList;
	private JList<TimeReport> list;
	

	
	private JTextField hourtextf;
	private List<ProjectMember> projects;
	private JComboBox projectbox;
	private JDateChooser dateChooserTimeReport; //timreport
	private DateFormat df = DateFormat.getDateInstance();
	private Date datenow =new Date();
	private InputHandler inputhandler= new InputHandler();
	ConsultTimeReportController controller = new ConsultTimeReportController();
	String user = controllers.LoginController.loggedinuser;
	

	public ConTimeReport() {
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				getTimeReports();
			}
		});
		setLayout(null);
		setBounds(100, 100, 834, 333);
		setBackground(Color.LIGHT_GRAY);
		
		
		JButton btnConfirmTimeReport = new JButton("Confirm");
		btnConfirmTimeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProjectMember n = new ProjectMember();
				n=(ProjectMember) projectbox.getSelectedItem();
				
				String projekt = n.getProjectNumber().toString();
				String start = hourtextf.getText();
				String stop = worktxtf.getText();
				String date = df.format(dateChooserTimeReport.getDate());
				
			if(inputhandler.checkIFTime(start)){
					controller.addTimeReport(user,projekt,date,start,stop);	
					allTimeReportModel.removeAllElements();
					getTimeReports();
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
		
		worktxtf = new JTextField();
		worktxtf.setColumns(10);
		worktxtf.setBounds(66, 126, 260, 20);
		add(worktxtf);
		worktxtf.setDocument(new TextFieldLimit(25));
		
	
		
		hourtextf = new JTextField();
		hourtextf.setColumns(10);
		hourtextf.setBounds(66, 87, 61, 20);
		add(hourtextf);
		hourtextf.setDocument(new TextFieldLimit(2));
		
		hourtextf.addKeyListener(new KeyAdapter() {
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
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(10, 84, 46, 14);
		add(lblHours);
		
		JLabel lblWork = new JLabel("Work");
		lblWork.setBounds(10, 123, 46, 14);
		add(lblWork);
		
		JLabel label_3 = new JLabel("Project");
		label_3.setBounds(10, 45, 74, 14);
		add(label_3);
		
		projectbox = new JComboBox();
		projectbox.setBounds(66, 45, 260, 20);
		add(projectbox);
		
		list = new JList<TimeReport>();
		allTimeReportModel = new DefaultListModel<TimeReport>();
		list.setModel(allTimeReportModel);
		list.setSelectedIndex(0);
		list.setBounds(356, 71, 425, 156);
		add(list);
		
		JLabel lblRecent = new JLabel("Recent Timereports");
		lblRecent.setBounds(356, 45, 400, 14);
		add(lblRecent);
		
		projects=controller.getprojects(user);
		
		for(int i =0;i<projects.size();i++){
			projectbox.addItem(projects.get(i));
			
			
			
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
	}

/**
 * Method to get Timereports
 */
	private void getTimeReports() {
	
		timeReportList = controller.getTimeReport(user);
		if (timeReportList.size() > 0) {
			for (int i = 0; i < timeReportList.size(); i++) {
				allTimeReportModel.add(i, timeReportList.get(i));
			}
			list.setSelectedIndex(0);
	}
		
	}
}
