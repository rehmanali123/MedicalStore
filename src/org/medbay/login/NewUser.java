package org.medbay.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.medbay.dao.DAO;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.DatabaseObject;

@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao = new DAO();
	private User user = new User();
	private boolean added = false;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		System.out.println("Got Json" + json);
		
		Gson gson = new Gson();
		user = gson.fromJson(json, User.class);
		
		System.out.println("User Object: " + user);
		
		try {
			added = dao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Added to database: " + added);

		// 4. Set response type to JSON
		response.setContentType("application/json");

		

	}

}
