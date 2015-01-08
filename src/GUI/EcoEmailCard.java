package GUI;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controllers.ConsultTimeReportController;
import controllers.EcoMailController;
import objects.CustomerContact;
import objects.ProjectMember;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * GUIClass for EcoCreateProjectCard
 * @author Jimmy
 *
 */
public class EcoEmailCard extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private List<CustomerContact> contactlist;
	private JComboBox contactbox;
	String all ="";
	EcoMailController controller = new EcoMailController();

	
	public EcoEmailCard() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(21, 54, 279, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(21, 38, 46, 14);
		add(lblTo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(21, 130, 279, 20);
		add(textField_1);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setBounds(21, 116, 103, 14);
		add(lblSubject);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(21, 176, 279, 107);
		add(textField_2);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(21, 161, 103, 14);
		add(lblMessage);
		
		JButton btnS = new JButton("Send");
		btnS.setBounds(217, 294, 83, 23);
		add(btnS);
		
		contactbox = new JComboBox();
		contactbox.setBounds(21, 82, 223, 20);
		add(contactbox);
		
		contactlist = controller.getAllCustomers();
		
		for(int i=0;i<contactlist.size();i++){
			contactbox.addItem(contactlist.get(i));
		}
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int vald=contactbox.getSelectedIndex();
				String mottagare = contactlist.get(vald).getEmail();
				all =all.concat(mottagare +" ,");
				textField.setText(all);
				
			}
		});
		btnAdd.setBounds(254, 81, 46, 23);
		add(btnAdd);

	}
}
