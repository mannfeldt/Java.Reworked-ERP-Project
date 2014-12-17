package GUI;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controllers.EcoCreateAllocationController;
import objects.Project;
import objects.User;
import controllers.TextFieldLimit;

public class EcoAllocateCard extends JPanel {
	private JTextField OtherRoleText;
	private DefaultListModel<Project> ListModelProject;
	DefaultListModel<User> ListModelUser;
	EcoCreateAllocationController controller = new EcoCreateAllocationController();
	private JTextField HourlyRateText;
	/**
	 * Create the panel.
	 */
	public EcoAllocateCard() {
		setLayout(null);
		
	
		
		JLabel lblChooseConsultant = new JLabel("1. Choose consultant");
		lblChooseConsultant.setBounds(10, 33, 147, 14);
		add(lblChooseConsultant);
		
		JLabel lblChoose = new JLabel("2. Choose project");
		lblChoose.setBounds(519, 33, 160, 14);
		add(lblChoose);
		
		JLabel lblSetOptions = new JLabel("3. Set Options");
		lblSetOptions.setBounds(344, 291, 108, 14);
		add(lblSetOptions);
		
		OtherRoleText = new JTextField();
		OtherRoleText.setBounds(376, 424, 133, 20);
		add(OtherRoleText);
		OtherRoleText.setColumns(10);
		OtherRoleText.show(false);
		
		JLabel OtherLabel = new JLabel("Other Role");
		OtherLabel.setBounds(282, 427, 84, 14);
		add(OtherLabel);
		OtherLabel.show(false);
		
		JComboBox RoleBox = new JComboBox();
		RoleBox.setBounds(376, 393, 133, 20);
		RoleBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//om other är valt så stängs boxen av och en text ruta öppnas istället
                String selected = RoleBox.getSelectedItem().toString();
                if(selected.equals("Other")){
                	OtherRoleText.show(true);
                	OtherLabel.show(true);
                	RoleBox.enable(false);          	
                }
			}
		});
		this.add(RoleBox);
		RoleBox.addItem("Business analyst");
		RoleBox.addItem("Projekt ledare");
		RoleBox.addItem("Scrum master");
		RoleBox.addItem("Process manager");
		RoleBox.addItem("Development manager");
		RoleBox.addItem("Quality coordinator");
		RoleBox.addItem("Other");
		
		
		JLabel lblProjectRole = new JLabel("Project Role");
		lblProjectRole.setBounds(282, 396, 84, 14);
		this.add(lblProjectRole);
		
		JLabel lblWorkLoad = new JLabel("Work Load");
		lblWorkLoad.setBounds(283, 365, 83, 14);
		this.add(lblWorkLoad);
		
		JComboBox WorkLoadBox = new JComboBox();
		WorkLoadBox.setBounds(376, 362, 43, 20);
		this.add(WorkLoadBox);
		WorkLoadBox.addItem("25");
		WorkLoadBox.addItem("50");
		WorkLoadBox.addItem("75");
		WorkLoadBox.addItem("100");
		
		//Fetch all projects from database
		List<Project> allprojects;
		allprojects=controller.getallprojects();	
		
		//create adds projects to a listmodel
		ListModelProject = new DefaultListModel<Project>();
		
		for(int i =0;i<allprojects.size();i++){
			
			
			ListModelProject.add(i, allprojects.get(i));
			
			
			
			
		}
		
		List<User> allconsultants;
		allconsultants=controller.getAllPersons();
		
		//create adds users to a listmodel
		ListModelUser = new DefaultListModel<User>();
		
		for(int i =0;i<allconsultants.size();i++){
			
			
			ListModelUser.add(i, allconsultants.get(i));
	
			
		}

		
		JLabel label_1 = new JLabel("Hourly Rate");
		label_1.setBounds(282, 334, 89, 14);
		this.add(label_1);
		
		HourlyRateText = new JTextField();
		HourlyRateText.setBounds(376, 331, 86, 20);
		HourlyRateText.setText("323, 12, 867, 498");
		HourlyRateText.setColumns(10);
		this.add(HourlyRateText);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 49, 256, 438);
		add(scrollPane_1);
		
		JList ConsultantList = new JList();
		scrollPane_1.setViewportView(ConsultantList);
		ConsultantList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ConsultantList.setModel(ListModelUser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(519, 49, 272, 438);
		add(scrollPane);
		
		JList ProjectList = new JList();
		scrollPane.setViewportView(ProjectList);
		ProjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ProjectList.setModel(ListModelProject); 
		
		JButton AllocateButton = new JButton("Allocate Resource");
		AllocateButton.setBounds(376, 455, 133, 23);
		HourlyRateText.addKeyListener(new KeyAdapter() {
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
		HourlyRateText.setDocument(new TextFieldLimit(4));
		OtherRoleText.setDocument(new TextFieldLimit(15));
		
		AllocateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String role = "No role assigned";
				String projectnr=ListModelProject.getElementAt(ProjectList.getSelectedIndex()).getProjectNumber();
				String user=ListModelUser.getElementAt(ConsultantList.getSelectedIndex()).getSSN();
				
				String workload=WorkLoadBox.getSelectedItem().toString();
				String hourlyrate=HourlyRateText.getText();
				if(!RoleBox.isEnabled()){
					role=OtherRoleText.getText();
					RoleBox.enable(true);
					RoleBox.setSelectedIndex(0);
				}
				else{
					role=RoleBox.getSelectedItem().toString();
				}
				//insert this into projectmember table
				controller.CreateAllocation(hourlyrate,projectnr,role,user,workload);
				OtherLabel.show(false);
				OtherRoleText.show(false);
				
			
			}
		});
		this.add(AllocateButton);
		
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.setBounds(282, 176, 227, 41);
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		add(ResetButton);

	}
}
