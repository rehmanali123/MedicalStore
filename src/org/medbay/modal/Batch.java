package org.medbay.modal;

import java.util.Date;

public class Batch {

	private int batchId;
	private int batchNo;
	private Date mfgDate;
	private Date expDate;
	private int packQty;
	private int strength;
	private String distributor;
	private String supplier;
	private int medId;
	
	public Batch() {
		// no-argument constructor
	}

	public Batch(int batchNo, Date mfgDate, Date expDate,int packQty, int strength, String distributor, String supplier) {

		this.batchNo = batchNo;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.packQty = packQty;
		this.strength = strength;
		this.distributor = distributor;
		this.supplier = supplier;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		distributor = distributor;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public int getPackQty() {
		return packQty;
	}

	public void setPackQty(int packs) {
		this.packQty = packs;
	}

}
