package org.medbay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.medbay.dao.DAO;
import org.medbay.modal.BillingItem;
import org.medbay.modal.OrderItem;


@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<OrderItem> list = null;
	private DAO dao;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Reached the servlet to save the order items."); 
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		
		System.out.println("Data received");
		System.out.println(json);
		
		
		JSONArray object = null;
		list = new ArrayList<OrderItem>();
		boolean added = false;
		
		try {
			
			object = new JSONArray(json);
			System.out.println("Object is: " + object.length());

			for (int i = 0; i < object.length(); i++) {
				
				JSONObject rec = object.getJSONObject(i);
				
				OrderItem item = new OrderItem();
				
				int med_id = rec.getInt("id");
				double quantity = rec.getInt("quantity");
				int order_id = rec.getInt("order_id");
				
				String status = "pending";
				
				item.setMed_id(med_id);
				item.setQtyReceived(quantity);
				item.setOrderId(order_id);
				item.setStatus(status);
				
				list.add(i, item);
				System.out.println("Added: " + i);
				
			
			}
			
			try {
				dao = new DAO();
				added = dao.insertOrderItem(list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		System.out.println("Items are added: " + added );
		out.println(added);
		
		
		
	}

}
