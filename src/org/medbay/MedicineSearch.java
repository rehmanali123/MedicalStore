package org.medbay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.medbay.dao.DAO;
import org.medbay.medicine.Medicine;

import com.google.gson.Gson;

@WebServlet("/MedicineSearch")
public class MedicineSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO dao = new DAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Reached the method. ");

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		Object object = JSONValue.parse(json);
		JSONObject jsonObject = (JSONObject) object;

		System.out.println(object);
		String name = (String) jsonObject.get("name");
		String key = (String) jsonObject.get("keyword");

		System.out.println("Name: " + name + " Keyword: " + key);

		List<Medicine> medList = new ArrayList<Medicine>();
		try {
			System.out.println("Going to DAO.");
			medList = dao.getMedicine(name, key);
			System.out.println("return from dao. ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String array = gson.toJson(medList);
		System.out.println("Sending data back.");
		PrintWriter out = response.getWriter();
		out.println(array);

	}

}
