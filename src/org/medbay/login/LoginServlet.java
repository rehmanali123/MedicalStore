package org.medbay.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Authentication authentic = new Authentication();
	private Login login = new Login();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		
		HttpSession session = request.getSession();

		Gson gson = new Gson();
		login = gson.fromJson(json, Login.class);
		
		try {
			JSONObject object = new JSONObject(login);
			int user = object.getInt("admin");
			System.out.println("Admin: " + user);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Login newLogin = new Login();
		
		String username = login.getUsername();
		String password = login.getPassword();
		int admin = login.getAdmin();
		System.out.println("Admin is: "+admin);
		
		newLogin = new Login(username, password, admin);

		System.out.println("Got the username: " + newLogin);

		boolean authentication = false;

		try {
			authentication = authentic.authenticateAndSetSession(newLogin);
			System.out.println("Authentication returns " + authentication);
			
			if(authentication) {
				
				session.setAttribute("user", username);
				
				
				if(admin == 1) {
					session.setAttribute("status", "Welcome Admin");
				}
				
				session.setAttribute("status", "Welcome " + username );
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Username is: " +  session.getAttribute("user"));
		System.out.println("Status is: " +  session.getAttribute("status"));
		
		response.setContentType("text");
		PrintWriter writer = response.getWriter();
		writer.print(authentication);
		
	}

}
