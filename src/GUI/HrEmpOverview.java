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
import objects.ProjectMember;
import objects.TimeReport;
import javax.swing.JLabel;

public class HrEmpOverview extends JPanel {

	private JPanel contentPane;
	DefaultListModel<String> allProjectMemberModel;
	private List<ProjectMember> projctMemberList;
	private JList<String> list;
	HrEmployeeOverviewController controller = new HrEmployeeOverviewController();

	public HrEmpOverview() {
		
		
		
		setBounds(100, 100, 692, 386);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 60, 634, 278);
		add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		allProjectMemberModel = new DefaultListModel<String>();
		list.setModel(allProjectMemberModel);
		list.setSelectedIndex(0);
		
		JLabel lblEmployeeOverviewProjects = new JLabel("Employee overview, projects");
		lblEmployeeOverviewProjects.setBounds(37, 35, 471, 14);
		add(lblEmployeeOverviewProjects);
		
		
		getAllProjectMembers();
	}

	private void getAllProjectMembers() {
		projctMemberList = controller.getAllUsers();
		if (projctMemberList.size() > 0) {
			for (int i = 0; i < projctMemberList.size(); i++) {
				allProjectMemberModel.add(i, projctMemberList.get(i).toStringAll());
			}
			list.setSelectedIndex(0);
		}
		
	}
}
