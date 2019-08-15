package org.medbay.modal;

public class OrderItem {

	private int itemId;
	private int med_id;
	private double qtyOrdered;
	private double qtyReceived;
	private int orderId;
	private String status;
	private double price;
	private double discount;
	private double total;
	
	public OrderItem() {
		// no-argument constructor
	}

	public OrderItem(int med_id, int orderId, double qtyOrdered, String status) {

		this.med_id = med_id;
		this.qtyOrdered = qtyOrdered;
		this.orderId = orderId;
		this.status = status;
	
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getMed_id() {
		return med_id;
	}

	public void setMed_id(int med_id) {
		this.med_id = med_id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(double qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public double getQtyReceived() {
		return qtyReceived;
	}

	public void setQtyReceived(double qtyReceived) {
		this.qtyReceived = qtyReceived;
	}

}
