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

import org.medbay.dao.DAO;
import org.medbay.medicine.Medicine;
import org.medbay.modal.Batch;

import com.google.gson.Gson;

@WebServlet("/NewMedicineServlet")
public class NewMedicineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Medicine medicine = new Medicine();
	private Batch batchObj = new Batch();
	private DAO dao = new DAO();
	boolean check = false;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		
		System.out.println("This servlet is getting the data");
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		
		System.out.println("Got the modell");
		
		Gson gson = new Gson();
		Medicine medicine = gson.fromJson(json, Medicine.class);

		System.out.println("Got Json" + json);
		System.out.println("Object: " + medicine);

		
		try {
			
			System.out.println("Entering into process mode");

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// fields for medicine object
			String name = medicine.getName();
			String dose = medicine.getDose();
			String type = medicine.getType();
			String formula = medicine.getFormula();
			int rack = medicine.getRack();
			int critical = medicine.getCritical();
			double cost = medicine.getCost();
			double mrp = medicine.getMrp();
			
			
			// fields for batch object
			String batch = medicine.getBatch();
			String mfg = medicine.getMfg();
			String exp = medicine.getExp();
			double packQty = medicine.getPacks();
			int strength = medicine.getStrength();
			String distributor = medicine.getDistributor();
			String supplier = medicine.getDealer();
			
			

			try {
				
				System.out.println("Adding into databse.......");

				check = dao.addMedicine(medicine);

				if (check) {
					System.out.println("Addition: " + check);
				} else {
					System.out.println("Addition: " + check);
				}

			} catch (SQLException e) {
				System.out.println("Addition: " + check);

			}
		} catch (NumberFormatException e) {
			System.out.println("Addition: " + check);

		}
		
		PrintWriter out = response.getWriter();
		out.println(check);
		
		
	}
}
