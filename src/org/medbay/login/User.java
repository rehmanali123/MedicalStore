package org.medbay.login;

public class User {

	private int userId;
	private String firstname;
	private String lastname;
	private String dob;
	private String username;
	private String password;
	private String email;
	private String gender;
	private int admin;

	public User() {
		// no-args constructor
	}

	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ ", admin=" + admin + "]";
	}


	public User(String firstname, String lastname, String dob, String username, String password, String email,
			String gender, int admin) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.admin = admin;
	}

	public User(String username, String password, int admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
