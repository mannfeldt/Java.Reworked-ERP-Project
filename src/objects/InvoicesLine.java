package objects;

public class InvoicesLine {
	private String lineNumber;
	private String invoiceNumber;
	private String amount;
	private String date;
	private String description;
	
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "InvoicesLine [lineNumber=" + lineNumber + ", invoiceNumber="
				+ invoiceNumber + ", amount=" + amount + ", date=" + date
				+ ", description=" + description + "]";
	}

	
	
}
