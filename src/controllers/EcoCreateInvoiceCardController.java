package controllers;

import GUI.EcoCreateInvoiceCard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Customer;

public final class EcoCreateInvoiceCardController implements ActionListener {

    private final EcoCreateInvoiceCard view;

    public EcoCreateInvoiceCardController(EcoCreateInvoiceCard view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Hello from EcoCreateInvoiceCardController");
        String source = event.getActionCommand();
        if (source.equalsIgnoreCase("Save")) {
            System.out.println("Save was pressed");
            Object selectedCustomer = view.getSelectedCustomer();
            System.out.println(selectedCustomer);
        }
    }

    /**
     * Get all customers
     * @return a new model containing only customer names
     */
    public DefaultComboBoxModel getCustomers() {
        db_Mapper db_mapper = new db_Mapper
        (MyBatisConnectionFactory.getSqlSessionFactory());
        
        List<Customer> customers;
        customers = db_mapper.getAllCustomers();

        DefaultComboBoxModel companyNames = new DefaultComboBoxModel();

        for (Customer customer : customers) {
            companyNames.addElement(customer.getCompanyName());

        }
        return companyNames;
    }

}
