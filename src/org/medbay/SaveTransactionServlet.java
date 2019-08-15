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

@WebServlet("/SaveTransactionServlet")
public class SaveTransactionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArrayList<BillingItem> list = null;
	private DAO dao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Reached the servlet to save the items."); 
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		System.out.println("Data received");
		System.out.println(json);

		JSONArray object = null;
		list = new ArrayList<BillingItem>();
		boolean added = false;
		
		try {
			
			object = new JSONArray(json);
			System.out.println("Object is: " + object.length());

			for (int i = 0; i < object.length(); i++) {
				
				JSONObject rec = object.getJSONObject(i);
				
				BillingItem item = new BillingItem();
				
				int med_id = rec.getInt("id");
				String name = rec.getString("name");
				String formula = rec.getString("formula");
				String type = rec.getString("type");
				String dose = rec.getString("dose");
				String batch = rec.getString("batch");
				int quantity = rec.getInt("quantity");
				double mrp = rec.getDouble("mrp");
				double total = rec.getDouble("total");
				int trans_id = rec.getInt("trans_id");
				
				item.setMed_id(med_id);
				item.setName(name);
				item.setFormula(formula);
				item.setType(type);
				item.setDose(dose);
				item.setBatch(batch);
				item.setQuantity(quantity);
				item.setMrp(mrp);
				item.setTotalPrice(total);
				item.setTransactionId(trans_id);
				
				list.add(i, item);
				System.out.println("Added: " + i);
				
			
			}
			
			try {
				dao = new DAO();
				added = dao.insertBillingItem(list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		System.out.println("Items are added: " + true );
		out.println(added);
		
	}

}
