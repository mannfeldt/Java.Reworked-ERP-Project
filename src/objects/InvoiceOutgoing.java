package objects;

public class InvoiceOutgoing {
	private String invoiceNumber;
	private String projectNumber;
	private String totalAmount;
	private String date;
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
		return "InvoiceOutgoing [invoiceNumber=" + invoiceNumber
				+ ", projectNumber=" + projectNumber + ", totalAmount="
				+ totalAmount + ", date=" + date + "]";
	}

	
	
}
