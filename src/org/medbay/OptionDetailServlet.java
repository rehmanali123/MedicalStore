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

@WebServlet("/OptionDetailServlet")
public class OptionDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Medicine medicine;
	private DAO dao = new DAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Reached the servlet of OptionDetail ");
		
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		
		medicine = new Medicine();
		
		JSONObject object;
		
		try {
			object = new JSONObject(json);

			String name = (String) object.get("name");
			String dose = (String) object.get("dose");

			medicine = dao.getMedicineOptionRecord(name, dose);
			System.out.println("Received data: " + medicine);
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String result = gson.toJson(medicine);
		System.out.println("Sending data back.");
		PrintWriter out = response.getWriter();
		out.println(result);

	}

}
