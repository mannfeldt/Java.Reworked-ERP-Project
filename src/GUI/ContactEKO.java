package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
/**
 * GUIClass for ContactEKO
 * @author Jimmy
 *
 */

public class ContactEKO extends JPanel {
	JPanel viewCards;
	private JTextArea MatterText;
	
	private JComboBox<String> MatterBox;
	private JButton SendButton;
	
	/**
	 * Create the panel.
	 */
	
	public ContactEKO() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel("EKO: Contact information");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(6, 6, 164, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Contact: Fredik Arvidsson\r\n");
		label_1.setBounds(6, 22, 171, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Phone: 076 47639128\r\n");
		label_2.setBounds(6, 38, 146, 16);
		add(label_2);
		
		JButton label_3 = new JButton("ArvidChef@Gmail.com");
		label_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		MatterText = new JTextArea();
		MatterText.setBounds(6, 199, 434, 130);
		add(MatterText);
		MatterText.setColumns(10);
		MatterText.setVisible(false);
		

		
		 MatterBox = new JComboBox<String>();
		MatterBox.setBounds(6, 166, 250, 22);
		add(MatterBox);
		MatterBox.setVisible(false);
		
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
		SendButton.setBounds(6, 340, 89, 23);
		add(SendButton);
		SendButton.setVisible(false);

	}
}
