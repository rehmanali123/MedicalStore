package org.medbay;

public class Employee {

	private int empid;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String dob;
	private String designation;
	private String address; // creat a new class address for normalization
	private String cnic;
	private String gender;
	private String cellPhone;
	private String landLine;

	public Employee() {
		// no argument constructor
	}

	public Employee(String firstname, String lastname, String email, String username, String password, String dob,
			String designation, String address, String cnic, String gender, String cellPhone, String landLine) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.designation = designation;
		this.address = address;
		this.cnic = cnic;
		this.gender = gender;
		this.cellPhone = cellPhone;
		this.landLine = landLine;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString(),
	 */
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", dob=" + dob + ", designation=" + designation
				+ ", address=" + address + ", cnic=" + cnic + ", gender=" + gender + ", cellPhone=" + cellPhone
				+ ", landLine=" + landLine + "]";
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getLandLine() {
		return landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
