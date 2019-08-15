package org.medbay.login;

import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.medbay.dao.DAO;

public class Authentication {
	
	private String username;
	private String passowrd;
	private int admin;
	private DAO dao = new DAO();
	private Login user = new Login(); 
	
	
	public Authentication() {
		// no-args constructor
	}
	
	public Authentication(String username, String password, int admin) {
		this.username = username;
		this.passowrd = password;
		this.admin = admin;
	}
	
	
	public boolean authenticateAndSetSession(Login login) throws SQLException {
		
		boolean verified = false;
		// test
		System.out.println("Going in for authentication to database method getUser()");
		
		String password = login.getPassword();
		// test
		System.out.println("Received password is: " + password);
		
		password = dao.hashPassword(password);
		login.setPassword(password);
		
		String recUser = login.getUsername();
		String recPass = login.getPassword();
		int recAdmin = login.getAdmin();
		
		// hashing the password to md5 hash
		System.out.println("Authentication: " + recUser + ", " + recPass + ", " + recAdmin );
		Login user = dao.getUser(login);
		
		// test
		System.out.println(user);
		
		String username = user.getUsername();
		String pass = user.getPassword();
		int admin = user.getAdmin();
		
		// test
		System.out.println("Authentication: " + username + ", " + pass + ", " + admin );
		
		if((recUser.equals(username)) && (recPass.equals(password)) && (recAdmin == admin)) {
			verified = true;
			// test
			System.out.println("it is verified");
			
			
		}
		
		
		return verified;
		
	}
	
	
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	
	
	

}
