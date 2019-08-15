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
import org.medbay.medicine.Medicine;

import com.google.gson.Gson;

@WebServlet("/AddMedicineRowServlet")
public class AddMedicineRowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Medicine medicine = new Medicine();
	private DAO dao = new DAO();
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		
		try {
			
			JSONObject object = new JSONObject(json);

			System.out.println("Object is: " + object);
			
			String name = (String) object.get("name");
			String dose = (String) object.get("dose");
			String formula = (String) object.get("formula");
			double mrp =  object.getDouble("mrp");
			
			medicine = dao.getMedicineRow(name, dose, formula, mrp);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String result = gson.toJson(medicine);
		System.out.println(result);
		System.out.println("Sending data back.");
		PrintWriter out = response.getWriter();
		out.println(result);
		
		
	}

}
