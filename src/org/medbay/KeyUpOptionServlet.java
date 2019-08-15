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
import org.json.JSONObject;
import org.medbay.dao.DAO;
import org.medbay.medicine.Medicine;

import com.google.gson.Gson;

@WebServlet("/KeyUpOptionServlet")
public class KeyUpOptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<Medicine> list = new ArrayList<Medicine>();
	private DAO dao = new DAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		try {
			
			JSONObject object = new JSONObject(json);

			System.out.println(object);
			String name = (String) object.get("search");
			
			
			list = dao.getMedicineOption(name);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String array = gson.toJson(list);
		System.out.println(array);
		System.out.println("Sending data back.");
		PrintWriter out = response.getWriter();
		out.println(array);

	}

}
