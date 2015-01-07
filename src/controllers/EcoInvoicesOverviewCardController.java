package controllers;

import java.util.List;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;
import objects.PaymentIncoming;
/**
 * ControllerClass for handling EcoInvOverviewCardGUI
 * @author Jimmy
 *
 */
public class EcoInvoicesOverviewCardController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());
	
	/**
	 * Return list of paymentsinc
	 * @return List of paymentsinc
	 */
	public List<PaymentIncoming> getAllIncomingPayments() {
		List<PaymentIncoming> pi;
		pi = db_mapper.getAllIncomingPayments();
		return pi;
	}
	

}
