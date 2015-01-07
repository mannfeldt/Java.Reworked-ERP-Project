package GUI;

import controllers.EcoCreateInvoiceCardController;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public final class EcoCreateInvoiceCard extends JPanel {

    private JTextField textFieldInvoiceDate;
    private JTextField textFieldTotalAmount;
    private JComboBox comboBoxCustomer;
    private JComboBox comboBoxProject;
    private DefaultComboBoxModel customerList;
    private DefaultComboBoxModel projectsList;
	private String selectedCustomer;
    private JTextArea textAreaBillingAdress;

    /**
     * Constructor
     */
    public EcoCreateInvoiceCard() {
        EcoCreateInvoiceCardController controller;
        controller = new EcoCreateInvoiceCardController(this);

        setDesign();

        createComboBoxCustomer(controller);

        createBillingAdress();

        createComboBoxProject(controller);

        createTextFieldInvoiceDate();

        createButtonSave(controller);

        createTextFieldAmount();

        createInvoiceLines();

    }

    private void setDesign() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
    }

    private void createInvoiceLines() {
        JList listInvoiceLines = new JList();
        listInvoiceLines.setBounds(300, 40, 200, 235);
        add(listInvoiceLines);

        JLabel lblLines = new JLabel("Select lines to add");
        lblLines.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblLines.setBounds(300, 15, 200, 25);
        add(lblLines);
    }

    private void createTextFieldAmount() {
        textFieldTotalAmount = new JTextField();
        textFieldTotalAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textFieldTotalAmount.setBounds(300, 320, 200, 25);
        add(textFieldTotalAmount);
        textFieldTotalAmount.setColumns(10);

        JLabel lblTotalAmount = new JLabel("Total Amount");
        lblTotalAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTotalAmount.setBounds(300, 295, 200, 25);
        add(lblTotalAmount);
    }

    private void createButtonSave(EcoCreateInvoiceCardController controller) {
        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSave.setBounds(130, 400, 90, 35);
        add(btnSave);
        btnSave.addActionListener(controller);
    }

    private void createTextFieldInvoiceDate() {
        textFieldInvoiceDate = new JTextField();
        textFieldInvoiceDate.setBounds(20, 320, 200, 25);
        add(textFieldInvoiceDate);
        textFieldInvoiceDate.setColumns(10);

        JLabel lblInvoiceDate = new JLabel("Invoice Date");
        lblInvoiceDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblInvoiceDate.setBounds(20, 295, 200, 25);
        add(lblInvoiceDate);
    }

    private void createComboBoxProject(EcoCreateInvoiceCardController controller) {
        comboBoxProject = new JComboBox();
        comboBoxProject.setBounds(20, 250, 200, 25);
        add(comboBoxProject);
        comboBoxProject.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ItemEvent) {
            }
        });
        

        JLabel lblProject = new JLabel("Project");
        lblProject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblProject.setBounds(20, 225, 200, 25);
        add(lblProject);
    }

    /**
     * Customer combobox
     *
     * @param controller that can fetch if asked
     */
    private void createComboBoxCustomer(final EcoCreateInvoiceCardController controller) {
        comboBoxCustomer = new JComboBox();
        comboBoxCustomer.setBounds(20, 40, 200, 25);
        add(comboBoxCustomer);
        
        customerList = controller.getCustomers();
        comboBoxCustomer.setModel(customerList);
        comboBoxCustomer.setSelectedIndex(-1);

        JLabel labelCustomer = new JLabel("Customer");
        labelCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelCustomer.setBounds(20, 15, 200, 25);
        add(labelCustomer);

        // This fires when selection is changed in customer combobox
//        comboBoxCustomer.addItemListener((ItemEvent e)  {
//            String selectedCustomer = getSelectedCustomer().toString();
//            DefaultComboBoxModel customerProjects = 
//            controller.getCustomerProjects(selectedCustomer);
//            setProjectsList(customerProjects);
//            });
        comboBoxCustomer.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedCustomer = getSelectedCustomer().toString();
                DefaultComboBoxModel customerProjects =
                controller.getCustomerProjects(selectedCustomer);
                setProjectsList(customerProjects);
            }
        });
    }

    /**
     * Customer billing adress
     */
    private void createBillingAdress() {
        textAreaBillingAdress = new JTextArea();
        textAreaBillingAdress.setEditable(false);
        textAreaBillingAdress.setBounds(20, 110, 200, 100);
        add(textAreaBillingAdress);

        JLabel lblBillingAdress = new JLabel("Billing Adress");
        lblBillingAdress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblBillingAdress.setBounds(20, 82, 200, 25);
        add(lblBillingAdress);
    }

    /**
     * @return the selected customer
     */
    public Object getSelectedCustomer() {
        return getComboBoxCustomer().getModel().getSelectedItem();
    }

    /**
     * @return the comboBoxCustomer
     */
    public JComboBox getComboBoxCustomer() {
        return comboBoxCustomer;
    }

    /**
     * @param projectsList the projectsList to set
     */
    public void setProjectsList(DefaultComboBoxModel projectsList) {
        this.projectsList = projectsList;
        comboBoxProject.setModel(projectsList);
    }
    
    private void setBillingAdress(String adress) {
        textAreaBillingAdress.setText(adress);
    }
}
