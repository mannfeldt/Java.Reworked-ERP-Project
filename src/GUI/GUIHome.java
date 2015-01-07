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

public class GUIHome {
	JPanel viewCards; // a panel that uses CardLayout
	JPanel secondMenuCards;
	final static String BUTTONPANEL = "BUTTONPANEL";
	final static String TEXTPANEL = "TEXTPANEL";
	private static JFrame frame;
	private JButton btnHome;
	private JButton btnConsultants;
	private JButton btnAdministration;
	private JButton btnHRMenu;
	private JButton btnEKOMenu;
	private JButton btnCreateproject;
	private JButton btnCreateInvoice;
	private JButton btnInvoiceOverview;
	private JButton btnWages;
	private JButton btnAllocate;
	private JButton btnSendEmail;
	private JButton btnProjects;
	private JButton btnEmployees;
	private JButton btnContactHrm;
	private JButton btnContactEconomy;
	private JButton btnTimeReport;
	private JButton btnNewUser;

	public void addComponentToPane(Container pane) {

		JPanel mainMenuPane = new JPanel();
		mainMenuPane.setBounds(6, 11, 153, 489);
		mainMenuPane.setBackground(Color.LIGHT_GRAY);
		mainMenuPane.setLayout(null);

		JPanel EKOmenuCard = new JPanel();

		JPanel HRmenuCard = new JPanel();
		HRmenuCard.setBackground(Color.LIGHT_GRAY);
		EKOmenuCard.setBackground(new Color(30, 144, 255));

		viewCards = new JPanel(new CardLayout());
		viewCards.setBounds(334, 27, 840, 473);

		secondMenuCards = new JPanel(new CardLayout());
		secondMenuCards.setBounds(166, 11, 153, 489);
		secondMenuCards.setBackground(UIManager.getColor("Focus.color"));

		JPanel HomeMenuCard = new JPanel();
		HomeMenuCard.setLayout(null);
		HomeMenuCard.setBackground(Color.LIGHT_GRAY);
		secondMenuCards.add(HomeMenuCard, "homeMenuCard");

		btnContactHrm = new JButton("Contact HRM");
		btnContactHrm.setHorizontalAlignment(SwingConstants.LEFT);
		btnContactHrm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				ContactHRM CHRM = new ContactHRM();
				viewCards.add(CHRM, "CHRM");
				cardLayout.show(viewCards, "CHRM");
				btnContactHrm.setBackground(SystemColor.activeCaption);
				btnContactEconomy.setBackground(new JButton().getBackground());
			}
		});
		btnContactHrm.setBounds(0, 12, 153, 25);
		HomeMenuCard.add(btnContactHrm);

		btnContactEconomy = new JButton("Contact Economy");
		btnContactEconomy.setHorizontalAlignment(SwingConstants.LEFT);
		btnContactEconomy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				ContactEKO CEKO = new ContactEKO();
				viewCards.add(CEKO, "CEKO");
				cardLayout.show(viewCards, "CEKO");
				btnContactEconomy.setBackground(SystemColor.activeCaption);
				btnContactHrm.setBackground(new JButton().getBackground());
			}
		});
		btnContactEconomy.setBounds(0, 38, 153, 25);
		HomeMenuCard.add(btnContactEconomy);
		secondMenuCards.add(EKOmenuCard, "EKOmenuCard");

		JPanel consultantMenuCard = new JPanel();
		consultantMenuCard.setLayout(null);
		consultantMenuCard.setBackground(Color.LIGHT_GRAY);
		secondMenuCards.add(consultantMenuCard, "consultantMenuCard");

		btnTimeReport = new JButton("Time report");
		btnTimeReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnTimeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				ConTimeReport TimeReport = new ConTimeReport();
				viewCards.add(TimeReport, "TMR");
				cardLayout.show(viewCards, "TMR");
				btnTimeReport.setBackground(SystemColor.activeCaption);
			}
		});

		btnTimeReport.setBounds(0, 12, 153, 25);
		consultantMenuCard.add(btnTimeReport);
		secondMenuCards.add(HRmenuCard, "HRmenuCard");
		HRmenuCard.setLayout(null);

		btnProjects = new JButton("Projects");
		btnProjects.setHorizontalAlignment(SwingConstants.LEFT);
		btnProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				HrProjectCard HPC = new HrProjectCard();
				viewCards.add(HPC, "HPC");
				cardLayout.show(viewCards, "HPC");
				btnProjects.setBackground(SystemColor.activeCaption);
				btnEmployees.setBackground(new JButton().getBackground());
			}
		});
		btnProjects.setBounds(0, 12, 153, 25);
		HRmenuCard.add(btnProjects);

		btnEmployees = new JButton("Employees");
		btnEmployees.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				HrEmployeeCard HEC = new HrEmployeeCard();
				viewCards.add(HEC, "HEC");
				cardLayout.show(viewCards, "HEC");
				btnEmployees.setBackground(SystemColor.activeCaption);
				btnProjects.setBackground(new JButton().getBackground());
			}
		});
		frame.getContentPane().setLayout(null);
		btnEmployees.setBounds(0, 38, 153, 25);
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

		btnCreateproject = new JButton("Create Project");
		btnCreateproject.setHorizontalAlignment(SwingConstants.LEFT);

		btnCreateproject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				EcoCreateProjectCard ECPC = new EcoCreateProjectCard();
				viewCards.add(ECPC, "ECPC");
				cardLayout.show(viewCards, "ECPC");
				btnCreateproject.setBackground(SystemColor.activeCaption);
				btnInvoiceOverview.setBackground(new JButton().getBackground());
				btnCreateInvoice.setBackground(new JButton().getBackground());
				btnWages.setBackground(new JButton().getBackground());
				btnSendEmail.setBackground(new JButton().getBackground());
				btnAllocate.setBackground(new JButton().getBackground());
			}
		});
		btnCreateproject.setBounds(0, 12, 153, 25);
		EKOmenuCard.add(btnCreateproject);

		btnInvoiceOverview = new JButton("Invoice Overview");
		btnInvoiceOverview.setHorizontalAlignment(SwingConstants.LEFT);
		btnInvoiceOverview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				EcoInvoicesOverviewCard EIOC = new EcoInvoicesOverviewCard();
				viewCards.add(EIOC, "EIOC");
				cardLayout.show(viewCards, "EIOC");
				btnInvoiceOverview.setBackground(SystemColor.activeCaption);
				btnCreateproject.setBackground(new JButton().getBackground());
				btnCreateInvoice.setBackground(new JButton().getBackground());
				btnWages.setBackground(new JButton().getBackground());
				btnSendEmail.setBackground(new JButton().getBackground());
				btnAllocate.setBackground(new JButton().getBackground());
			}
		});
		btnInvoiceOverview.setBounds(0, 66, 153, 25);
		EKOmenuCard.add(btnInvoiceOverview);

		btnWages = new JButton("Wages");
		btnWages.setHorizontalAlignment(SwingConstants.LEFT);
		btnWages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				EcoWagesCard EWC = new EcoWagesCard();
				viewCards.add(EWC, "EWC");
				cardLayout.show(viewCards, "EWC");
				btnWages.setBackground(SystemColor.activeCaption);
				btnCreateproject.setBackground(new JButton().getBackground());
				btnCreateInvoice.setBackground(new JButton().getBackground());
				btnInvoiceOverview.setBackground(new JButton().getBackground());
				btnSendEmail.setBackground(new JButton().getBackground());
				btnAllocate.setBackground(new JButton().getBackground());
			}
		});
		btnWages.setBounds(0, 91, 153, 25);
		EKOmenuCard.add(btnWages);

		btnSendEmail = new JButton("Send email");
		btnSendEmail.setHorizontalAlignment(SwingConstants.LEFT);
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				EcoEmailCard EEC = new EcoEmailCard();
				viewCards.add(EEC, "EEC");
				cardLayout.show(viewCards, "EEC");
				btnSendEmail.setBackground(SystemColor.activeCaption);
				btnCreateproject.setBackground(new JButton().getBackground());
				btnCreateInvoice.setBackground(new JButton().getBackground());
				btnInvoiceOverview.setBackground(new JButton().getBackground());
				btnWages.setBackground(new JButton().getBackground());
				btnAllocate.setBackground(new JButton().getBackground());

			}
		});
		btnSendEmail.setBounds(0, 141, 153, 25);
		EKOmenuCard.add(btnSendEmail);

		JPanel adminMenuCard = new JPanel();
		adminMenuCard.setLayout(null);
		adminMenuCard.setBackground(Color.LIGHT_GRAY);
		secondMenuCards.add(adminMenuCard, "adminMenuCard");

		btnNewUser = new JButton("New User");
		btnNewUser.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				AdminNewUserCard ANUC = new AdminNewUserCard();
				viewCards.add(ANUC, "ANUC");
				cardLayout.show(viewCards, "ANUC");
				btnNewUser.setBackground(SystemColor.activeCaption);
			}
		});
		btnNewUser.setBounds(0, 12, 153, 25);
		adminMenuCard.add(btnNewUser);

		pane.add(mainMenuPane);

		Icon EkoIcon = new ImageIcon("source/images/ECO_logo.png");
		btnEKOMenu = new JButton("Economy");
		btnEKOMenu.setHorizontalAlignment(SwingConstants.LEFT);
		btnEKOMenu.setIcon(EkoIcon);
		btnEKOMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) secondMenuCards
						.getLayout();
				cardLayout.show(secondMenuCards, "EKOmenuCard");
				btnHome.setBackground(new JButton().getBackground());
				btnConsultants.setBackground(new JButton().getBackground());
				btnAdministration.setBackground(new JButton().getBackground());
				btnHRMenu.setBackground(new JButton().getBackground());
				btnEKOMenu.setBackground(SystemColor.activeCaption);
				btnCreateproject.setBackground(new JButton().getBackground());
				btnCreateInvoice.setBackground(new JButton().getBackground());
				btnInvoiceOverview.setBackground(new JButton().getBackground());
				btnWages.setBackground(new JButton().getBackground());
				btnAllocate.setBackground(new JButton().getBackground());
				btnSendEmail.setBackground(new JButton().getBackground());
			}
		});
		btnEKOMenu.setBounds(0, 38, 153, 25);
		mainMenuPane.add(btnEKOMenu);

		Icon HrmIcon = new ImageIcon("source/images/HRM_logo.png");
		btnHRMenu = new JButton("HRM");
		btnHRMenu.setIcon(HrmIcon);
		btnHRMenu.setHorizontalAlignment(SwingConstants.LEFT);

		btnHRMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) secondMenuCards
						.getLayout();
				cardLayout.show(secondMenuCards, "HRmenuCard");
				btnHome.setBackground(new JButton().getBackground());
				btnConsultants.setBackground(new JButton().getBackground());
				btnAdministration.setBackground(new JButton().getBackground());
				btnHRMenu.setBackground(SystemColor.activeCaption);
				btnEKOMenu.setBackground(new JButton().getBackground());
				btnProjects.setBackground(new JButton().getBackground());
				btnEmployees.setBackground(new JButton().getBackground());
			}
		});

		Icon HomeIcon = new ImageIcon("source/images/home_logo2.png");
		btnHome = new JButton("Home");
		btnHome.setBackground(SystemColor.activeCaption);
		btnHome.setIcon(HomeIcon);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) secondMenuCards
						.getLayout();
				cardLayout.show(secondMenuCards, "homeMenuCard");
				btnHome.setBackground(SystemColor.activeCaption);
				btnConsultants.setBackground(new JButton().getBackground());
				btnAdministration.setBackground(new JButton().getBackground());
				btnHRMenu.setBackground(new JButton().getBackground());
				btnEKOMenu.setBackground(new JButton().getBackground());
				btnContactHrm.setBackground(new JButton().getBackground());
				btnContactEconomy.setBackground(new JButton().getBackground());
			}
		});
		btnHome.setBounds(0, 12, 153, 25);
		mainMenuPane.add(btnHome);

		btnHRMenu.setBounds(0, 64, 153, 25);
		mainMenuPane.add(btnHRMenu);

		Icon ConsultantIcon = new ImageIcon("source/images/Consultant_logo.png");
		btnConsultants = new JButton("Consultants");
		btnConsultants.setIcon(ConsultantIcon);
		btnConsultants.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) secondMenuCards
						.getLayout();
				cardLayout.show(secondMenuCards, "consultantMenuCard");
				btnHome.setBackground(new JButton().getBackground());
				btnConsultants.setBackground(SystemColor.activeCaption);
				btnAdministration.setBackground(new JButton().getBackground());
				btnHRMenu.setBackground(new JButton().getBackground());
				btnEKOMenu.setBackground(new JButton().getBackground());
				btnTimeReport.setBackground(new JButton().getBackground());
			}
		});
		btnConsultants.setBounds(0, 90, 153, 25);
		mainMenuPane.add(btnConsultants);

		Icon AdminIcon = new ImageIcon("source/images/Admin_logo.png");
		btnAdministration = new JButton("Administration");
		btnAdministration.setIcon(AdminIcon);
		btnAdministration.setHorizontalAlignment(SwingConstants.LEFT);

		btnAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) secondMenuCards
						.getLayout();
				cardLayout.show(secondMenuCards, "adminMenuCard");
				btnHome.setBackground(new JButton().getBackground());
				btnConsultants.setBackground(new JButton().getBackground());
				btnAdministration.setBackground(SystemColor.activeCaption);
				btnHRMenu.setBackground(new JButton().getBackground());
				btnEKOMenu.setBackground(new JButton().getBackground());
				btnNewUser.setBackground(new JButton().getBackground());
			}
		});
		btnAdministration.setBounds(0, 116, 153, 25);
		mainMenuPane.add(btnAdministration);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILogin.main(null);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				GUIHome.frame.dispose();
			}
		});
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setBounds(0, 458, 153, 25);
		mainMenuPane.add(btnLogOut);
		pane.add(viewCards);
		EKOmenuCard.setBackground(Color.LIGHT_GRAY);

		btnCreateInvoice = new JButton("Create Invoice");
		btnCreateInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				EcoCreateInvoiceCard ECIC = new EcoCreateInvoiceCard();
				viewCards.add(ECIC, "ECIC");
				cardLayout.show(viewCards, "ECIC");
				btnCreateproject.setBackground(new JButton().getBackground());
				btnInvoiceOverview.setBackground(new JButton().getBackground());
				btnCreateInvoice.setBackground(SystemColor.activeCaption);
				btnWages.setBackground(new JButton().getBackground());
				btnSendEmail.setBackground(new JButton().getBackground());
				btnAllocate.setBackground(new JButton().getBackground());
			}
		});
		btnCreateInvoice.setBounds(0, 37, 153, 29);
		EKOmenuCard.add(btnCreateInvoice);

		btnAllocate = new JButton("Allocate Resources");
		btnAllocate.setHorizontalAlignment(SwingConstants.LEFT);
		btnAllocate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CardLayout cardLayout = (CardLayout) viewCards.getLayout();
				EcoAllocateCard EAC = new EcoAllocateCard();
				viewCards.add(EAC, "EAC");
				cardLayout.show(viewCards, "EAC");
				btnCreateproject.setBackground(new JButton().getBackground());
				btnInvoiceOverview.setBackground(new JButton().getBackground());
				btnCreateInvoice.setBackground(new JButton().getBackground());
				btnWages.setBackground(new JButton().getBackground());
				btnSendEmail.setBackground(new JButton().getBackground());
				btnAllocate.setBackground(SystemColor.activeCaption);
			}
		});
		btnAllocate.setBounds(0, 116, 153, 25);
		EKOmenuCard.add(btnAllocate);

<<<<<<< HEAD
=======
 
public class GUIHome  {
    JPanel viewCards; //a panel that uses CardLayout
    JPanel secondMenuCards;
    final static String BUTTONPANEL = "BUTTONPANEL";
    final static String TEXTPANEL = "TEXTPANEL";
    private static JFrame frame;
    private JButton btnHome;
    private JButton btnConsultants;
    private JButton btnAdministration;
    private JButton btnHRMenu;   
    private JButton btnEKOMenu;
    private JButton btnCreateproject;
    private JButton btnCreateInvoice;
    private JButton btnInvoiceOverview;
    private JButton btnWages;
    private JButton btnAllocate;
    private JButton btnSendEmail;
    private JButton btnEmpOverview;
    private JButton btnEmployees;
    private JButton btnContactHrm;
    private JButton btnContactEconomy;
    private JButton btnTimeReport;
    private JButton btnNewUser;
   
    
     
    public void addComponentToPane(Container pane) {
    	
    	
        JPanel mainMenuPane = new JPanel();
        mainMenuPane.setBounds(6, 11, 153, 489);
        mainMenuPane.setBackground(Color.LIGHT_GRAY);
        mainMenuPane.setLayout(null);
        
        JPanel EKOmenuCard = new JPanel();
        
        JPanel HRmenuCard = new JPanel();
        HRmenuCard.setBackground(Color.LIGHT_GRAY);
        EKOmenuCard.setBackground(new Color(30, 144, 255));
         
        viewCards = new JPanel(new CardLayout());
        viewCards.setBounds(334, 27, 840, 473);
        
        secondMenuCards = new JPanel(new CardLayout());
        secondMenuCards.setBounds(166, 11, 153, 489);
        secondMenuCards.setBackground(UIManager.getColor("Focus.color"));
        
        JPanel HomeMenuCard = new JPanel();
        HomeMenuCard.setLayout(null);
        HomeMenuCard.setBackground(Color.LIGHT_GRAY);
        secondMenuCards.add(HomeMenuCard, "homeMenuCard");
        
       btnContactHrm = new JButton("Contact HRM");
       btnContactHrm.setHorizontalAlignment(SwingConstants.LEFT);
       btnContactHrm.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
       		ContactHRM CHRM = new ContactHRM();
       		viewCards.add(CHRM, "CHRM");
       		cardLayout.show(viewCards, "CHRM");
       		btnContactHrm.setBackground(SystemColor.activeCaption);
       		btnContactEconomy.setBackground(new JButton().getBackground());
       	}
       });
       btnContactHrm.setBounds(0, 12, 153, 25);
       HomeMenuCard.add(btnContactHrm);
       
       btnContactEconomy = new JButton("Contact Economy");
       btnContactEconomy.setHorizontalAlignment(SwingConstants.LEFT);
       btnContactEconomy.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
       		ContactEKO CEKO = new ContactEKO();
       		viewCards.add(CEKO, "CEKO");
       		cardLayout.show(viewCards, "CEKO");
       		btnContactEconomy.setBackground(SystemColor.activeCaption);
       		btnContactHrm.setBackground(new JButton().getBackground());
       	}
       });
       btnContactEconomy.setBounds(0, 38, 153, 25);
       HomeMenuCard.add(btnContactEconomy);
        secondMenuCards.add(EKOmenuCard, "EKOmenuCard");
        
        JPanel consultantMenuCard = new JPanel();
        consultantMenuCard.setLayout(null);
        consultantMenuCard.setBackground(Color.LIGHT_GRAY);
        secondMenuCards.add(consultantMenuCard, "consultantMenuCard");
        
        btnTimeReport = new JButton("Time report");
        btnTimeReport.setHorizontalAlignment(SwingConstants.LEFT);
        btnTimeReport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		ConTimeReport TimeReport = new ConTimeReport();
        		viewCards.add(TimeReport, "TMR");
        		cardLayout.show(viewCards, "TMR");
        		btnTimeReport.setBackground(SystemColor.activeCaption);
        	}
        });
        
        btnTimeReport.setBounds(0, 12, 153, 25);
        consultantMenuCard.add(btnTimeReport);
        secondMenuCards.add(HRmenuCard, "HRmenuCard");
        HRmenuCard.setLayout(null);
        
        btnEmpOverview = new JButton("Employees");
        btnEmpOverview.setHorizontalAlignment(SwingConstants.LEFT);
        btnEmpOverview.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		HrEmpOverview HPC = new HrEmpOverview();
        		viewCards.add(HPC, "HPC");
        		cardLayout.show(viewCards, "HPC");
        		btnEmpOverview.setBackground(SystemColor.activeCaption);
        		btnEmployees.setBackground(new JButton().getBackground());
        	}
        });
        btnEmpOverview.setBounds(0, 12, 153, 25);
        HRmenuCard.add(btnEmpOverview);
        
       btnEmployees = new JButton("Updt Employees");
        btnEmployees.setHorizontalAlignment(SwingConstants.LEFT);
        btnEmployees.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        		
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		HrEmployeeCard HEC = new HrEmployeeCard();
        		viewCards.add(HEC, "HEC");
        		cardLayout.show(viewCards, "HEC");
        		btnEmployees.setBackground(SystemColor.activeCaption);
        		btnEmpOverview.setBackground(new JButton().getBackground());
        	}
        });
        frame.getContentPane().setLayout(null);
        btnEmployees.setBounds(0, 38, 153, 25);
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
        
        btnCreateproject = new JButton("Create Project");
        btnCreateproject.setHorizontalAlignment(SwingConstants.LEFT);

        btnCreateproject.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoCreateProjectCard ECPC= new EcoCreateProjectCard();
        		viewCards.add(ECPC, "ECPC");
        		cardLayout.show(viewCards, "ECPC");
        		btnCreateproject.setBackground(SystemColor.activeCaption);
        		btnInvoiceOverview.setBackground(new JButton().getBackground());
        		btnCreateInvoice.setBackground(new JButton().getBackground());
        		btnWages.setBackground(new JButton().getBackground());
        		btnSendEmail.setBackground(new JButton().getBackground());
        		btnAllocate.setBackground(new JButton().getBackground());
        	}
        });
        btnCreateproject.setBounds(0, 12, 153, 25);
        EKOmenuCard.add(btnCreateproject);
        
        btnInvoiceOverview = new JButton("Invoice Overview");
        btnInvoiceOverview.setHorizontalAlignment(SwingConstants.LEFT);
        btnInvoiceOverview.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoInvoicesOverviewCard EIOC = new EcoInvoicesOverviewCard();
        		viewCards.add(EIOC, "EIOC");
        		cardLayout.show(viewCards, "EIOC");
        		btnInvoiceOverview.setBackground(SystemColor.activeCaption);
        		btnCreateproject.setBackground(new JButton().getBackground());
        		btnCreateInvoice.setBackground(new JButton().getBackground());
        		btnWages.setBackground(new JButton().getBackground());
        		btnSendEmail.setBackground(new JButton().getBackground());
        		btnAllocate.setBackground(new JButton().getBackground());
        	}
        });
        btnInvoiceOverview.setBounds(0, 66, 153, 25);
        EKOmenuCard.add(btnInvoiceOverview);
        
        btnWages = new JButton("Wages");
        btnWages.setHorizontalAlignment(SwingConstants.LEFT);
        btnWages.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoWagesCard EWC = new EcoWagesCard();
        		viewCards.add(EWC, "EWC");
        		cardLayout.show(viewCards, "EWC");
        		btnWages.setBackground(SystemColor.activeCaption);
        		btnCreateproject.setBackground(new JButton().getBackground());
        		btnCreateInvoice.setBackground(new JButton().getBackground());
        		btnInvoiceOverview.setBackground(new JButton().getBackground());
        		btnSendEmail.setBackground(new JButton().getBackground());
        		btnAllocate.setBackground(new JButton().getBackground());
        	}
        });
        btnWages.setBounds(0, 91, 153, 25);
        EKOmenuCard.add(btnWages);
        
        btnSendEmail = new JButton("Send email");
        btnSendEmail.setHorizontalAlignment(SwingConstants.LEFT);
        btnSendEmail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoEmailCard EEC = new EcoEmailCard();
        		viewCards.add(EEC, "EEC");
        		cardLayout.show(viewCards, "EEC");
        		btnSendEmail.setBackground(SystemColor.activeCaption);
        		btnCreateproject.setBackground(new JButton().getBackground());
        		btnCreateInvoice.setBackground(new JButton().getBackground());
        		btnInvoiceOverview.setBackground(new JButton().getBackground());
        		btnWages.setBackground(new JButton().getBackground());
        		btnAllocate.setBackground(new JButton().getBackground());
        		
        	}
        });
        btnSendEmail.setBounds(0, 141, 153, 25);
        EKOmenuCard.add(btnSendEmail);
        
        JPanel adminMenuCard = new JPanel();
        adminMenuCard.setLayout(null);
        adminMenuCard.setBackground(Color.LIGHT_GRAY);
        secondMenuCards.add(adminMenuCard, "adminMenuCard");
        
        btnNewUser = new JButton("New User");
        btnNewUser.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		AdminNewUserCard ANUC = new AdminNewUserCard();
        		viewCards.add(ANUC, "ANUC");
        		cardLayout.show(viewCards, "ANUC");
        		btnNewUser.setBackground(SystemColor.activeCaption);
        	}
        });
        btnNewUser.setBounds(0, 12, 153, 25);
        adminMenuCard.add(btnNewUser);
         
        pane.add(mainMenuPane);
        
        
        Icon EkoIcon = new ImageIcon("source/images/ECO_logo.png");
       btnEKOMenu = new JButton("Economy");
        btnEKOMenu.setHorizontalAlignment(SwingConstants.LEFT);
        btnEKOMenu.setIcon(EkoIcon);
        btnEKOMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "EKOmenuCard");
        		btnHome.setBackground(new JButton().getBackground());
        		btnConsultants.setBackground(new JButton().getBackground());
        		btnAdministration.setBackground(new JButton().getBackground());
        		btnHRMenu.setBackground(new JButton().getBackground());
        		btnEKOMenu.setBackground(SystemColor.activeCaption);
        	    btnCreateproject.setBackground(new JButton().getBackground());
        	   btnCreateInvoice.setBackground(new JButton().getBackground());
        	    btnInvoiceOverview.setBackground(new JButton().getBackground());
        	    btnWages.setBackground(new JButton().getBackground());
        	    btnAllocate.setBackground(new JButton().getBackground());
        	   btnSendEmail.setBackground(new JButton().getBackground());
        	}
        });
        btnEKOMenu.setBounds(0, 38, 153, 25);
        mainMenuPane.add(btnEKOMenu);
        
        Icon HrmIcon = new ImageIcon("source/images/HRM_logo.png");
        btnHRMenu = new JButton("HRM");
        btnHRMenu.setIcon(HrmIcon);
        btnHRMenu.setHorizontalAlignment(SwingConstants.LEFT);

        btnHRMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "HRmenuCard");
        		btnHome.setBackground(new JButton().getBackground());
        		btnConsultants.setBackground(new JButton().getBackground());
        		btnAdministration.setBackground(new JButton().getBackground());
        		btnHRMenu.setBackground(SystemColor.activeCaption);
        		btnEKOMenu.setBackground(new JButton().getBackground());
        		    btnEmpOverview.setBackground(new JButton().getBackground());
        		    btnEmployees.setBackground(new JButton().getBackground());
        	}
        });
        
        Icon HomeIcon = new ImageIcon("source/images/home_logo2.png");
       btnHome= new JButton("Home");
        btnHome.setBackground(SystemColor.activeCaption);
        btnHome.setIcon(HomeIcon);
        btnHome.setHorizontalAlignment(SwingConstants.LEFT);
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "homeMenuCard");
        		btnHome.setBackground(SystemColor.activeCaption);
        		btnConsultants.setBackground(new JButton().getBackground());
        		btnAdministration.setBackground(new JButton().getBackground());
        		btnHRMenu.setBackground(new JButton().getBackground());
        		btnEKOMenu.setBackground(new JButton().getBackground());
        		btnContactHrm.setBackground(new JButton().getBackground());
        		btnContactEconomy.setBackground(new JButton().getBackground());
        	}
        });
        btnHome.setBounds(0, 12, 153, 25);
        mainMenuPane.add(btnHome);
        
        btnHRMenu.setBounds(0, 64, 153, 25);
        mainMenuPane.add(btnHRMenu);
        
        Icon ConsultantIcon = new ImageIcon("source/images/Consultant_logo.png");
       btnConsultants= new JButton("Consultants");
        btnConsultants.setIcon(ConsultantIcon);
        btnConsultants.setHorizontalAlignment(SwingConstants.LEFT);
        btnConsultants.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "consultantMenuCard");
        		btnHome.setBackground(new JButton().getBackground());
        		btnConsultants.setBackground(SystemColor.activeCaption);
        		btnAdministration.setBackground(new JButton().getBackground());
        		btnHRMenu.setBackground(new JButton().getBackground());
        		btnEKOMenu.setBackground(new JButton().getBackground());
        		btnTimeReport.setBackground(new JButton().getBackground());
        	}
        });
        btnConsultants.setBounds(0, 90, 153, 25);
        mainMenuPane.add(btnConsultants);
        
        Icon AdminIcon = new ImageIcon("source/images/Admin_logo.png");
        btnAdministration = new JButton("Administration");
        btnAdministration.setIcon(AdminIcon);
        btnAdministration.setHorizontalAlignment(SwingConstants.LEFT);
        
        btnAdministration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) secondMenuCards.getLayout();
        		cardLayout.show(secondMenuCards, "adminMenuCard");
        		btnHome.setBackground(new JButton().getBackground());
        		btnConsultants.setBackground(new JButton().getBackground());
        		btnAdministration.setBackground(SystemColor.activeCaption);
        		btnHRMenu.setBackground(new JButton().getBackground());
        		btnEKOMenu.setBackground(new JButton().getBackground());
        		btnNewUser.setBackground(new JButton().getBackground());
        	}
        });
        btnAdministration.setBounds(0, 116, 153, 25);
        mainMenuPane.add(btnAdministration);
        pane.add(viewCards);
        EKOmenuCard.setBackground(Color.LIGHT_GRAY);
        

  

        btnCreateInvoice = new JButton("Create Invoice");
        btnCreateInvoice.setHorizontalAlignment(SwingConstants.LEFT);
        btnCreateInvoice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoCreateInvoiceCard ECIC = new EcoCreateInvoiceCard();
        		viewCards.add(ECIC, "ECIC");
        		cardLayout.show(viewCards, "ECIC");
        		btnCreateproject.setBackground(new JButton().getBackground());
        		btnInvoiceOverview.setBackground(new JButton().getBackground());
        		btnCreateInvoice.setBackground(SystemColor.activeCaption);
        		btnWages.setBackground(new JButton().getBackground());
        		btnSendEmail.setBackground(new JButton().getBackground());
        		btnAllocate.setBackground(new JButton().getBackground());
        	}
        });
        btnCreateInvoice.setBounds(0, 37, 153, 29);
        EKOmenuCard.add(btnCreateInvoice);

        btnAllocate  = new JButton("Allocate Resources");
        btnAllocate.setHorizontalAlignment(SwingConstants.LEFT);
        btnAllocate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
        		EcoAllocateCard EAC= new EcoAllocateCard();
        		viewCards.add(EAC, "EAC");
        		cardLayout.show(viewCards, "EAC");
        		btnCreateproject.setBackground(new JButton().getBackground());
        		btnInvoiceOverview.setBackground(new JButton().getBackground());
        		btnCreateInvoice.setBackground(new JButton().getBackground());
        		btnWages.setBackground(new JButton().getBackground());
        		btnSendEmail.setBackground(new JButton().getBackground());
        		btnAllocate.setBackground(SystemColor.activeCaption);
        	}
        });
        btnAllocate.setBounds(0, 116, 153, 25);
        EKOmenuCard.add(btnAllocate);
        
>>>>>>> dfc56ea6b483d0eca5a3076348dfd8a35e677578
		CardLayout cardLayout = (CardLayout) viewCards.getLayout();
		HomeDefaultCard HDC = new HomeDefaultCard();
		viewCards.add(HDC, "HDC");
		cardLayout.show(viewCards, "HDC");

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public static void createAndShowGUI() {
		// Create and set up the window.

		frame = new JFrame("Hyber");
		frame.setResizable(false);
		frame.setBounds(300, 100, 1200, 537);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent we)
		{ 
		 String ObjButtons[] = {"Yes","No"};
		 int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Hyber",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		  if(PromptResult==JOptionPane.YES_OPTION)
		  {
		    System.exit(0);
		  }
		}
		});

		// Create and set up the content pane.
		GUIHome demo = new GUIHome();
		demo.addComponentToPane(frame.getContentPane());

		JLabel txloggedin = new JLabel("New label");
		txloggedin.setFont(new Font("Tahoma", Font.BOLD, 14));
		txloggedin.setBounds(334, 2, 747, 24);
		txloggedin.setText("Logged in as: "
				+ controllers.LoginController.loggedinuserAu + ", "
				+ controllers.LoginController.loggedinuser);
		frame.getContentPane().add(txloggedin);

		// Display the window.
		frame.setVisible(true);
	}
	



	
}