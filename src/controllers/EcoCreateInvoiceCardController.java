package controllers;

import GUI.EcoCreateInvoiceCard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Customer;
import objects.Project;

public final class EcoCreateInvoiceCardController implements ActionListener{

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
            
            // TODO: get all values from view, validate and save
            Object selectedCustomer = view.getSelectedCustomer();
            System.out.println(selectedCustomer);
        }
    }
   
    /**
     * Get all customers names
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
    
    /**
     * Get all projects for customer
     *
     * @param selection The selected company
     * @return a new model containing only customers projects
     */
    public DefaultComboBoxModel getCustomerProjects(String selection) {
        db_Mapper db_mapper = new db_Mapper
        (MyBatisConnectionFactory.getSqlSessionFactory());

        String organisationNumber = db_mapper.getOrganisationNumber(selection);
        DefaultComboBoxModel projectNames = new DefaultComboBoxModel();
        List<Project> projects = db_mapper.getCustomerProjects(organisationNumber);

        for (Project project : projects) {
            String name = project.getProjectNumber();
            projectNames.addElement(name);
        }

        return projectNames;
    }

}
