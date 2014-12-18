package GUI;

import controllers.LoginController;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUILogin extends JFrame {

    private final JPanel contentPane;
    private final JTextField UserIdField;
    private final JPasswordField passwordField;
    private final JLabel lblHyber;
  

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUILogin frame = new GUILogin();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public GUILogin() {

        // Add this instance to controller
        LoginController loginListener = new LoginController(this);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(loginListener);
        btnLogin.setBounds(95, 136, 139, 23);
        contentPane.add(btnLogin);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        UserIdField = new JTextField();
        UserIdField.setBounds(95, 74, 139, 20);
        contentPane.add(UserIdField);
        UserIdField.setColumns(10);

        JLabel lblUserid = new JLabel("UserID:");
        lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUserid.setBounds(12, 77, 73, 14);
        contentPane.add(lblUserid);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(12, 108, 73, 14);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(95, 105, 139, 20);
        contentPane.add(passwordField);

        lblHyber = new JLabel("Hyber\u2122");
        lblHyber.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
        lblHyber.setBounds(10, 11, 125, 31);
        contentPane.add(lblHyber);

        UserIdField.setText("197507211131");

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("source/images/hyberlogga_small.png"));
        lblNewLabel.setBounds(242, 25, 180, 119);
        contentPane.add(lblNewLabel);
    }

    /**
     * @return the username input
     */
    public String getNameField() {
        return UserIdField.getText();
    }

    /**
     * @return the password input
     */
    public String getPasswordField() {
        String password = new String(passwordField.getPassword());
        return password;
    }

    public void showWrongPasswordDialog() {
        JOptionPane.showMessageDialog(null,
                "Wrong username or password, try again.",
                "Login Error",
                JOptionPane.ERROR_MESSAGE);
    }

}
