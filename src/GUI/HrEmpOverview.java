package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controllers.ConsultTimeReportController;
import controllers.HrEmployeeOverviewController;
import objects.Project;
import objects.ProjectMember;
import objects.TimeReport;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HrEmpOverview extends JPanel {

	private JPanel contentPane;
	DefaultListModel<String> allProjectMemberModel;
	private List<ProjectMember> projctMemberList;
	private JList<String> list;
	private List<Project> projects;
	private JComboBox projectbox;
	HrEmployeeOverviewController controller = new HrEmployeeOverviewController();

	public HrEmpOverview() {
		
		
		
		setBounds(100, 100, 692, 386);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 122, 634, 216);
		add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		allProjectMemberModel = new DefaultListModel<String>();
		list.setModel(allProjectMemberModel);
		list.setSelectedIndex(0);
		
		JLabel lblEmployeeOverviewProjects = new JLabel("Employee overview, projects");
		lblEmployeeOverviewProjects.setBounds(37, 24, 353, 14);
		add(lblEmployeeOverviewProjects);
		
		
		
		projectbox = new JComboBox();
		projectbox.setBounds(37, 85, 289, 23);
		add(projectbox);
		
		projects=controller.getprojects();
		
		for(int i =0;i<projects.size();i++){
			projectbox.addItem(projects.get(i));
		}
		projectbox.setSelectedIndex(0);
		
		JButton btnShow = new JButton("Show");
		btnShow.setBounds(328, 85, 90, 23);
		add(btnShow);
		
		JLabel lblSelectProject = new JLabel("Select project");
		lblSelectProject.setBounds(37, 60, 353, 14);
		add(lblSelectProject);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				allProjectMemberModel.removeAllElements();
				
				Project n = new Project();
				n=(Project) projectbox.getSelectedItem();
				getAllProjectMembers(n.getProjectNumber());
			}
		});
		
		
	}

	private void getAllProjectMembers(String pnr) {
		projctMemberList = controller.getAllUsers(pnr);
		if (projctMemberList.size() > 0) {
			for (int i = 0; i < projctMemberList.size(); i++) {
				allProjectMemberModel.add(i, projctMemberList.get(i).toStringAll());
			}
			list.setSelectedIndex(0);
		}
		
	}
}
