package org.medbay.modal;

public class Stock {

	private int total;
	private int low;
	private int out;
	private int expired;

	public Stock() {
		// no-argument constructor
	}

	public Stock(int total, int low, int out, int expired) {
		
		this.total = total;
		this.low = low;
		this.out = out;
		this.expired = expired;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public int getExpired() {
		return expired;
	}

	public void setExpired(int expired) {
		this.expired = expired;
	}

}
