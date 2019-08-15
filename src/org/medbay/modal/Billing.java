package org.medbay.modal;

public class Billing {
	
	private int transactionId;
	private double total;
	private double discount;
	private double grandTotal;
	
	public Billing() {
		// no-argument constructor
	}
	
	
	
	
	public Billing( double total, double discount, double grandTotal) {
		
		
		this.total = total;
		this.discount = discount;
		this.grandTotal = grandTotal;
	}




	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	

}
