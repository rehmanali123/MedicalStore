package org.medbay.modal;

public class BillingItem {

	private int itemId;
	private int med_id;
	private String name;
	private String formula;
	private String type;
	private String dose;
	private String batch;
	private int quantity;
	private double mrp;
	private double totalPrice;
	private int transactionId;
	
	public BillingItem() {
		
	}
	
	
	public BillingItem(int med_id, String name, String formula, String type, String dose, String batch, int quantity, double mrp,
			double totalPrice, int transactionId) {
		
		this.setMed_id(med_id);
		this.name = name;
		this.formula = formula;
		this.type = type;
		this.dose = dose;
		this.batch = batch;
		this.quantity = quantity;
		this.mrp = mrp;
		this.totalPrice = totalPrice;
		this.transactionId = transactionId;
		
	}







	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public int getMed_id() {
		return med_id;
	}


	public void setMed_id(int med_id) {
		this.med_id = med_id;
	}
	
	
	
	
	
}
