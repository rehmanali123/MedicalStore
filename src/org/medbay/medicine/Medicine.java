package org.medbay.medicine;

public class Medicine {


	private int id;
	private String name;
	private String dose;
	private String type;
	private String formula;
	private int rack;
	private String distributor;
	private String dealer;
	private String batch;
	private double packs;
	private String mfg;
	private String exp;
	private int strength;
	private int critical;
	private double cost;
	private double mrp;
	private String stock;
	
	

	public Medicine() {
		// no-argument constructor
	}
	
	public Medicine( String name, String dose ) {
		this.name = name;
		this.dose = dose;
	}
	
	public Medicine( String formula, double mrp, String stock ) {
		this.formula = formula;
		this.mrp = mrp;
		this.stock = stock;
	}
	
	public Medicine(String name, String type, String dose, String formula) {
		this.name= name;
		this.type= type;
		this.dose = dose;
		this.formula = formula;
	}
	
	public Medicine(int id, String name, String formula, String type, String dose, double mrp) {
		this.id = id;
		this.name= name;
		this.type= type;
		this.dose = dose;
		this.formula = formula;
		this.mrp = mrp;
	}
	
	public Medicine(String name, String dose, String type, String formula,int rack, String distributor, String dealer,
			String batch, int packs, int strength, String mfg, String exp, int critical, double cost, double mrp, String stock ) {
		this.name = name;
		this.dose = dose;
		this.type = type;
		this.formula = formula;
		this.rack = rack;
		this.distributor = distributor;
		this.dealer = dealer;
		this.batch = batch;
		this.packs = packs;
		this.strength = strength;
		this.mfg = mfg;
		this.exp = exp; 
		this.critical = critical;
		this.cost = cost;
		this.mrp = mrp;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public double getPacks() {
		return packs;
	}

	public void setPacks(double quantity) {
		this.packs = quantity;
	}

	public String getMfg() {
		return mfg;
	}

	public void setMfg(String mfg) {
		this.mfg = mfg;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int criticalAmount) {
		this.critical = criticalAmount;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	public int getRack() {
		return rack;
	}

	public void setRack(int rack) {
		this.rack = rack;
	}

	public String getStock() {
		return stock;
	}

	public void setStatus(String stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", dose=" + dose + ", type=" + type + ", formula=" + formula
				+ ", rack=" + rack + ", distributor=" + distributor + ", dealer=" + dealer + ", batch=" + batch
				+ ", packs=" + packs + ", mfg=" + mfg + ", exp=" + exp + ", strength=" + strength + ", critical="
				+ critical + ", cost=" + cost + ", mrp=" + mrp + ", stock=" + stock + "]";
	}

		
	
	
	
	
	
	
	
	
	
	
	
}
