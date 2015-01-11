package controllers;

import GUI.EcoCreateInvoiceCard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.Customer;
import objects.Project;
import objects.TimeReport;
/**
 * ControllerClass for handling EcoCreateInvoceCardGUI
 * @author Åskar
 *
 */
public final class EcoCreateInvoiceCardController implements ActionListener{

    private final EcoCreateInvoiceCard view;
    private final ArrayList<Customer> customers;
    private ArrayList<TimeReport> timeReports;

    public EcoCreateInvoiceCardController(EcoCreateInvoiceCard view) {
        this.view = view;
        customers = new ArrayList<>();
        timeReports = new ArrayList<>();

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
     * Get all customersList names
     * @return a new model containing only customer names
     */
    public DefaultComboBoxModel getCustomers() {
        db_Mapper db_mapper = new db_Mapper
        (MyBatisConnectionFactory.getSqlSessionFactory());
        
        List<Customer> customersList;
        customersList = db_mapper.getAllCustomers();

        DefaultComboBoxModel companyNames = new DefaultComboBoxModel();

        for (Customer customer : customersList) {
            companyNames.addElement(customer.getCompanyName());
            customers.add(customer);

        }
        return companyNames;
    }
    
    /**
     * Get all projects for customer
     *
     * @param selection The selected company
     * @return a new model containing only customersList projects
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
    
    public void setCustomerAdress(int customerIndex){
        Customer selected = customers.get(customerIndex);
        String street = selected.getStreet();
        String zipCode = selected.getZipCode();
        String country = selected.getCountry();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(street);
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(zipCode);
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(country);
        String billingAdress = stringBuilder.toString();
        view.setBillingAdress(billingAdress);
    }
    
    public DefaultComboBoxModel getTimeReportProject(String projectNumber) {
        db_Mapper db_mapper = new db_Mapper
        (MyBatisConnectionFactory.getSqlSessionFactory());
        DefaultComboBoxModel timeReportList = new DefaultComboBoxModel();
        List<TimeReport> timeReportProject = db_mapper.getTimeReportProject(projectNumber);
        timeReports = new ArrayList<>();
        for (TimeReport timeReport : timeReportProject) {
            System.out.println(timeReport);
            timeReportList.addElement(timeReport);
            timeReports.add(timeReport);
           
        }
        System.out.println("ARRAY CONTAINING:" + timeReports.toString());
        return timeReportList;
    }

}
