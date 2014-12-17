package GUI;
 
/*
 * CardLayoutDemo.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


 
public class GUIHome  {
    JPanel viewCards; //a panel that uses CardLayout
    JPanel secondMenuCards;
    final static String BUTTONPANEL = "BUTTONPANEL";
    final static String TEXTPANEL = "TEXTPANEL";
    private static JFrame frame;
    
     
    public void addComponentToPane(Container pane) {
    	
    	
        JPanel mainMenuPane = new JPanel();
        mainMenuPane.setBounds(6, 12, 153, 793);
        mainMenuPane.setBackground(Color.LIGHT_GRAY);
        mainMenuPane.setLayout(null);
        
        JPanel EKOmenuCard = new JPanel();
        
        JPanel HRmenuCard = new JPanel();
        HRmenuCard.setBackground(Color.LIGHT_GRAY);
        EKOmenuCard.setBackground(new Color(30, 144, 255));
         
        viewCards = new JPanel(new CardLayout());
        viewCards.setBounds(323, 12, 867, 498);
        
        secondMenuCards = new JPanel(new CardLayout());
        secondMenuCards.setBounds(166, 12, 158, 865);
        secondMenuCards.setBackground(UIManager.getColor("Focus.color"));
        secondMenuCards.add(EKOmenuCard, "EKOmenuCard");
        
        JPanel consultantMenuCard = new JPanel();
        consultantMenuCard.setLayout(null);
        consultantMenuCard.setBackground(Color.LIGHT_GRAY);
        secondMenuCards.add(consultantMenuCard, "consultantMenuCard");
        
        JButton btnTimeReport = new JButton("Time report");
        btnTimeReport.setBounds(0, 12, 158, 25);
        consultantMenuCard.add(btnTimeReport);
        
        JPanel HomeMenuCard = new JPanel();
        HomeMenuCard.setLayout(null);
        HomeMenuCard.setBackground(Color.LIGHT_GRAY);
        secondMenuCards.add(HomeMenuCard, "homeMenuCard");
        
        JButton btnContactHrm = new JButton("Contact HRM");
        btnContactHrm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		ContactHRM CHRM = new ContactHRM();
        		viewCards.add(CHRM, "CHRM");
        		cardLayout.show(viewCards, "CHRM");
        	}
        });
        btnContactHrm.setBounds(0, 12, 158, 25);
        HomeMenuCard.add(btnContactHrm);
        
        JButton btnContactEconomy = new JButton("Contact Economy");
        btnContactEconomy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		ContactEKO CEKO = new ContactEKO();
        		viewCards.add(CEKO, "CEKO");
        		cardLayout.show(viewCards, "CEKO");
        	}
        });
        btnContactEconomy.setBounds(0, 38, 158, 25);
        HomeMenuCard.add(btnContactEconomy);
        secondMenuCards.add(HRmenuCard, "HRmenuCard");
        HRmenuCard.setLayout(null);
        
        JButton btnProjects = new JButton("Projects");
        btnProjects.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		HrProjectCard HPC = new HrProjectCard();
        		viewCards.add(HPC, "HPC");
        		cardLayout.show(viewCards, "HPC");
        	}
        });
        btnProjects.setBounds(0, 12, 158, 25);
        HRmenuCard.add(btnProjects);
        
        JButton btnEmployees = new JButton("Employees");
        btnEmployees.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        		
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		HrEmployeeCard HEC = new HrEmployeeCard();
        		viewCards.add(HEC, "HEC");
        		cardLayout.show(viewCards, "HEC");
        	}
        });
        frame.getContentPane().setLayout(null);
        btnEmployees.setBounds(0, 38, 158, 25);
        HRmenuCard.add(btnEmployees);
        frame.getContentPane().add(secondMenuCards);
        
        
        JButton btnHrknapp = new JButton("hrknapp1");
        btnHrknapp.setBounds(12, 12, 106, 25);
        
        JButton btnNewButton = new JButton("hrknapp2");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		cardLayout.show(viewCards, "TEXTPANEL");
        	}
        });
        btnNewButton.setBounds(12, 49, 106, 25);
        EKOmenuCard.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("Create Project");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoCreateProjectCard ECPC= new EcoCreateProjectCard();
        		viewCards.add(ECPC, "ECPC");
        		cardLayout.show(viewCards, "ECPC");
        	}
        });
        btnNewButton_1.setBounds(0, 12, 158, 25);
        EKOmenuCard.add(btnNewButton_1);
        
        JButton btnInvoiceOverview = new JButton("Invoice Overview");
        btnInvoiceOverview.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoInvoicesOverviewCard EIOC = new EcoInvoicesOverviewCard();
        		viewCards.add(EIOC, "EIOC");
        		cardLayout.show(viewCards, "EIOC");
        	}
        });
        btnInvoiceOverview.setBounds(0, 38, 158, 25);
        EKOmenuCard.add(btnInvoiceOverview);
        
        JButton btnWages = new JButton("Wages");
        btnWages.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoWagesCard EWC = new EcoWagesCard();
        		viewCards.add(EWC, "EWC");
        		cardLayout.show(viewCards, "EWC");
        	}
        });
        btnWages.setBounds(0, 64, 158, 25);
        EKOmenuCard.add(btnWages);
        
        JButton btnSendEmail = new JButton("Send email");
        btnSendEmail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoEmailCard EEC = new EcoEmailCard();
        		viewCards.add(EEC, "EEC");
        		cardLayout.show(viewCards, "EEC");
        	}
        });
        btnSendEmail.setBounds(0, 90, 158, 25);
        EKOmenuCard.add(btnSendEmail);
        
        JPanel adminMenuCard = new JPanel();
        adminMenuCard.setLayout(null);
        adminMenuCard.setBackground(Color.LIGHT_GRAY);
        secondMenuCards.add(adminMenuCard, "adminMenuCard");
        
        JButton btnNewUser = new JButton("New User");
        btnNewUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		AdminNewUserCard ANUC = new AdminNewUserCard();
        		viewCards.add(ANUC, "ANUC");
        		cardLayout.show(viewCards, "ANUC");
        	}
        });
        btnNewUser.setBounds(0, 12, 158, 25);
        adminMenuCard.add(btnNewUser);
         
        pane.add(mainMenuPane);
        
        
        Icon EkoIcon = new ImageIcon("source/images/ECO_logo.png");
        JButton btnEKOMenu = new JButton("Economy");
        btnEKOMenu.setHorizontalAlignment(SwingConstants.LEFT);
        btnEKOMenu.setIcon(EkoIcon);
        btnEKOMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "EKOmenuCard");
        	}
        });
        btnEKOMenu.setBounds(0, 38, 153, 25);
        mainMenuPane.add(btnEKOMenu);
        
        Icon HrmIcon = new ImageIcon("source/images/HRM_logo.png");
        JButton btnHRMenu = new JButton("HRM");
        btnHRMenu.setIcon(HrmIcon);
        btnHRMenu.setHorizontalAlignment(SwingConstants.LEFT);

        btnHRMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "HRmenuCard");
        	}
        });
        
        Icon HomeIcon = new ImageIcon("source/images/home_logo.png");
        JButton btnHome= new JButton("Home");
        btnHome.setIcon(HomeIcon);
        btnHome.setHorizontalAlignment(SwingConstants.LEFT);
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "homeMenuCard");
        	}
        });
        btnHome.setBounds(0, 12, 153, 25);
        mainMenuPane.add(btnHome);
        
        btnHRMenu.setBounds(0, 64, 153, 25);
        mainMenuPane.add(btnHRMenu);
        
        Icon ConsultantIcon = new ImageIcon("source/images/Consultant_logo.png");
        JButton btnConsultants= new JButton("Consultants");
        btnConsultants.setIcon(ConsultantIcon);
        btnConsultants.setHorizontalAlignment(SwingConstants.LEFT);
        btnConsultants.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "consultantMenuCard");
        	}
        });
        btnConsultants.setBounds(0, 90, 153, 25);
        mainMenuPane.add(btnConsultants);
        
        Icon AdminIcon = new ImageIcon("source/images/Admin_logo.png");
        JButton btnAdministration = new JButton("Administration");
        btnAdministration.setIcon(AdminIcon);
        btnAdministration.setHorizontalAlignment(SwingConstants.LEFT);
        
        btnAdministration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "adminMenuCard");
        	}
        });
        btnAdministration.setBounds(0, 116, 153, 25);
        mainMenuPane.add(btnAdministration);
        pane.add(viewCards);
        EKOmenuCard.setBackground(Color.LIGHT_GRAY);

        
		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
		HomeDefaultCard HDC= new HomeDefaultCard();
		viewCards.add(HDC, "HDC");
		cardLayout.show(viewCards, "HDC");
        

    }
     
   
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     * @wbp.parser.entryPoint
     */
     public static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Hyber");
        frame.setBounds(300, 100, 1200, 537);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        GUIHome demo = new GUIHome();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.setVisible(true);
    }
     
    
}