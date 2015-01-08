package GUI;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
/**
 * GUIClass for ContactHRM
 * @author Jimmy
 *
 */
public class ContactHRM extends JPanel {

	/**
	 * Create the panel.
	 */
	private JComboBox<String> MatterBox;
	private JTextArea MatterText;
	private JButton SendButton;
	
	public ContactHRM() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel("HRM: Contact information");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(6, 6, 164, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Contact: Fredik Arvidsson\r\n");
		label_1.setBounds(6, 22, 171, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Phone: 076 47639128\r\n");
		label_2.setBounds(6, 38, 146, 16);
		add(label_2);
		
		JButton label_3 = new JButton("ArvidChef@Hyber.com");
		label_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatterBox.removeAllItems();
				MatterText.setVisible(true);
				
				MatterBox.setVisible(true);
				SendButton.setVisible(true);
				MatterBox.addItem("Choose subject matter...");
				MatterBox.addItem("Report bug");
				MatterBox.addItem("Mistake in time report");
				MatterBox.addItem("Feedback about hyber");		
				MatterBox.addItem("Other");
			
			}
		});
		label_3.setBounds(6, 70, 174, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Please, only contact in real needs");
		label_4.setBounds(6, 54, 209, 16);
		add(label_4);
		
		MatterBox = new JComboBox<String>();
		MatterBox.setBounds(6, 170, 250, 20);
		add(MatterBox);
		
		 MatterText = new JTextArea();
		MatterText.setBounds(6, 201, 434, 127);
		add(MatterText);

		
		SendButton = new JButton("Send");
		SendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MatterText.getText().length()<10){
					JOptionPane.showMessageDialog(null,
							"Your message must be atleast 10 characters long",
						    "Error",
						    JOptionPane.PLAIN_MESSAGE);
				}
				else if (MatterBox.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null,
							"You must choose a subject matter",
						    "Error",
						    JOptionPane.PLAIN_MESSAGE);
				}
				else if(MatterText.getText().length()>=10){
					JOptionPane.showMessageDialog(null,
							"Thank you for time, respons will be sent to your hyber email within 24h",
						    "Successfully sent message",
						    JOptionPane.PLAIN_MESSAGE);
					MatterText.setText("");
			 		MatterBox.setSelectedIndex(0);
				}
	
			}
		});
		SendButton.setBounds(6, 339, 89, 23);
		add(SendButton);
		MatterText.setVisible(false);
		MatterBox.setVisible(false);
		SendButton.setVisible(false);

	}
}
