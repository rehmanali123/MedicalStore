package org.medbay.modal;

import java.time.LocalDate;

public class Order {

	private int orderId;
	private LocalDate orderDate;
	private LocalDate receivingDate;
	private String status;
	private double total;
	private double discount;
	private double grandtotal;

	public Order() {
		// no-argument constructor
	}

	public Order(LocalDate orderDate, LocalDate receivingDate, String status) {

		this.orderDate = orderDate;
		this.receivingDate = receivingDate;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(LocalDate receivingDate) {
		this.receivingDate = receivingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public double getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}

}
