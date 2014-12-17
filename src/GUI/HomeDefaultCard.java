package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class HomeDefaultCard extends JPanel {


	public HomeDefaultCard() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("source/images/hyberlogga.png"));
        lblNewLabel.setBounds(6, 34, 912, 483);
        add(lblNewLabel);
        
        JLabel lblWelcomeToHyber = new JLabel("Welcome to hyber!");
        lblWelcomeToHyber.setFont(new Font("Heiti TC", Font.BOLD, 20));
        lblWelcomeToHyber.setBounds(194, 0, 244, 47);
        add(lblWelcomeToHyber);
	}

}
