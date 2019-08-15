package org.medbay;

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

import org.json.JSONException;
import org.json.JSONObject;
import org.medbay.dao.DAO;
import org.medbay.modal.Billing;

import com.google.gson.Gson;

@WebServlet("/BillingServlet")
public class BillingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DAO dao = null;
	private DTOResponse dto;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Reached the servlet to save the transaction");
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		System.out.println("Data received");
		System.out.println(json);
		
		int id = 0;
		
		try {
			
			JSONObject object = new JSONObject(json);
			
			double total = object.getDouble("total");
			double discount = object.getDouble("discount");
			double grandtotal = object.getDouble("grandtotal");
			
			Billing billing = new Billing(total, discount, grandtotal);
			dao = new DAO();
			id = dao.insertBill(billing);
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dto = new DTOResponse();
		
		System.out.println("Sending id back: " + id);
		
		if(id != 0) {
			dto.setId(id);
		}
		
		
		Gson gson = new Gson();
		String result = gson.toJson(dto);
		
		PrintWriter out = response.getWriter();
		out.println(result);
		
		
	}
	

}
