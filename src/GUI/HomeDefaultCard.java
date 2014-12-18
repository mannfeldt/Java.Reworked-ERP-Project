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
        lblNewLabel.setBounds(0, 0, 912, 483);
        add(lblNewLabel);
	}

}
