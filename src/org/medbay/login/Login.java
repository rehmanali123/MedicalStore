package org.medbay.login;

public class Login {

	private int loginId;
	private String username;
	private String password;
	private String email;
	private int admin;
	private int userId;
	
	public Login() {
		
	}
	
	public Login(String username, String password, int admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	
	public Login(String username, String password, String email, int isAdmin, int userId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.admin = isAdmin;
		this.userId = userId;
	}
	
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
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

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int isAdmin) {
		this.admin = isAdmin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", isAdmin=" + admin + ", userId=" + userId + "]";
	}
	
	
	
	
	
	
	
	
}
