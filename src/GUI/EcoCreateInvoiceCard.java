package GUI;

import controllers.EcoCreateInvoiceCardController;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class EcoCreateInvoiceCard extends JPanel {

    private final JTextField textFieldInvoiceDate;
    private final JTextField textFieldTotalAmount;
    private final JComboBox comboBoxCustomer;
    private final DefaultComboBoxModel customerList;

    /**
     * Create the panel.
     */
    public EcoCreateInvoiceCard() {
        EcoCreateInvoiceCardController controller;
        controller = new EcoCreateInvoiceCardController(this);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        comboBoxCustomer = new JComboBox();
        comboBoxCustomer.setBounds(20, 40, 200, 25);
        add(comboBoxCustomer);
        
        JLabel labelCustomer = new JLabel("Customer");
        labelCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelCustomer.setBounds(20, 15, 200, 25);
        add(labelCustomer);
        
        JTextArea textAreaBillingAdress = new JTextArea();
        textAreaBillingAdress.setEditable(false);
        textAreaBillingAdress.setBounds(20, 110, 200, 100);
        add(textAreaBillingAdress);
        
        JLabel lblBillingAdress = new JLabel("Billing Adress");
        lblBillingAdress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblBillingAdress.setBounds(20, 82, 200, 25);
        add(lblBillingAdress);
        
        JComboBox comboBoxProject = new JComboBox();
        comboBoxProject.setBounds(20, 250, 200, 25);
        add(comboBoxProject);
        
        JLabel lblProject = new JLabel("Project");
        lblProject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblProject.setBounds(20, 225, 200, 25);
        add(lblProject);
        
        textFieldInvoiceDate = new JTextField();
        textFieldInvoiceDate.setBounds(20, 320, 200, 25);
        add(textFieldInvoiceDate);
        textFieldInvoiceDate.setColumns(10);
        
        JLabel lblInvoiceDate = new JLabel("Invoice Date");
        lblInvoiceDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblInvoiceDate.setBounds(20, 295, 200, 25);
        add(lblInvoiceDate);
        
        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSave.setBounds(130, 400, 90, 35);
        add(btnSave);
        btnSave.addActionListener(controller);
        
        textFieldTotalAmount = new JTextField();
        textFieldTotalAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textFieldTotalAmount.setBounds(300, 320, 200, 25);
        add(textFieldTotalAmount);
        textFieldTotalAmount.setColumns(10);
        
        JLabel lblTotalAmount = new JLabel("Total Amount");
        lblTotalAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTotalAmount.setBounds(300, 295, 200, 25);
        add(lblTotalAmount);
        
        JList listInvoiceLines = new JList();
        listInvoiceLines.setBounds(300, 40, 200, 235);
        add(listInvoiceLines);
        
        JLabel lblLines = new JLabel("Select lines to add");
        lblLines.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblLines.setBounds(300, 15, 200, 25);
        add(lblLines);
        
        customerList = controller.getCustomers();
        comboBoxCustomer.setModel(customerList);
        
    }

    /**
     * @return the selected customer
     */
    public Object getSelectedCustomer() {
        return comboBoxCustomer.getModel().getSelectedItem();
    }
}
