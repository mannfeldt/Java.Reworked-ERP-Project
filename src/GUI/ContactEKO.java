package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class ContactEKO extends JPanel {

	/**
	 * Create the panel.
	 */
	public ContactEKO() {
		setLayout(null);
		
		JLabel label = new JLabel("EKO: Contact information");
		label.setBounds(6, 6, 164, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Contact: Fredik Arvidsson\r\n");
		label_1.setBounds(6, 22, 171, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Phone: 076 47639128\r\n");
		label_2.setBounds(6, 38, 146, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("Mail: ArvidChef@Gmail.com");
		label_3.setBounds(6, 70, 174, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Please, only contact in real needs");
		label_4.setBounds(6, 54, 209, 16);
		add(label_4);

	}

}
