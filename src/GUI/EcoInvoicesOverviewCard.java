package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controllers.EcoInvoicesOverviewCardController;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;

import objects.PaymentIncoming;

public class EcoInvoicesOverviewCard extends JPanel {


	private static final long serialVersionUID = 1L;
	private EcoInvoicesOverviewCardController Controller;
	
	DefaultListModel<PaymentIncoming> pendingModel;
	DefaultListModel<PaymentIncoming> paiedModel;
	
	private List<PaymentIncoming> paymentsIncoming;
	private List<PaymentIncoming> payInc;
	private List<PaymentIncoming> payIncNotPaied;


	public EcoInvoicesOverviewCard() {
		setLayout(null);
		Controller = new EcoInvoicesOverviewCardController();		

		
		JList paiedInvoices = new JList();
		paiedModel = new DefaultListModel();
		paiedInvoices.setModel(paiedModel);
		paiedInvoices.setBounds(6, 35, 459, 138);
		add(paiedInvoices);
		
		JList pendingInvoices = new JList();
		pendingModel = new DefaultListModel();
		pendingInvoices.setModel(pendingModel);
		pendingInvoices.setBounds(6, 208, 459, 138);
		add(pendingInvoices);
		
		JLabel lblPaiedInvoices = new JLabel("Paied Invoices");
		lblPaiedInvoices.setBounds(6, 17, 89, 16);
		add(lblPaiedInvoices);
		
		JLabel lblPendingInvoices = new JLabel("Pending Invoices");
		lblPendingInvoices.setBounds(6, 192, 106, 16);
		add(lblPendingInvoices);
		
		updateInvoiceList();
	}
	
	private void updateInvoiceList() {
		paiedModel.removeAllElements();
		pendingModel.removeAllElements();
		
		paymentsIncoming = Controller.getAllIncomingPayments();
		
		payInc = new ArrayList();
		payIncNotPaied = new ArrayList();
		
		for (int i = 0; i < paymentsIncoming.size(); i++) {
			String a = paymentsIncoming.get(i).getStatus();
			if (a.equalsIgnoreCase("True")) {
				payInc.add(paymentsIncoming.get(i));
			}
		}
		for (int e = 0; e < paymentsIncoming.size(); e++) {
			String b = paymentsIncoming.get(e).getStatus();
			if (b.equalsIgnoreCase("False")) {
				payIncNotPaied.add(paymentsIncoming.get(e));
			}
		}
		for (int i = 0; i < payInc.size(); i++) {
			paiedModel.add(i, payInc.get(i));
		}
		for (int i = 0; i < payIncNotPaied.size(); i++) {
			pendingModel.add(i, payIncNotPaied.get(i));
		}
	}
}
