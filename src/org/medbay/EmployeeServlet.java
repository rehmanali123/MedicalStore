package org.medbay;

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


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private Employee employee = new Employee();
    private boolean added = false;
    private DAO dao = new DAO();
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		System.out.println("Got Json" + json);
		
		Gson gson = new Gson();
		employee = gson.fromJson(json, Employee.class);
		
		System.out.println("Employee Object: " + employee);
		

		try {
			added = dao.addEmployee(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Added to database: " + added);

		// 4. Set response type to JSON
		response.setContentType("application/json");
		
		
		
	}

}
