package org.medbay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.medbay.dao.DAO;
import org.medbay.modal.Stock;

import com.google.gson.Gson;

@WebServlet("/StockServlet")
public class StockServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO dao = null;
	private Stock stock = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dao = new DAO();

		stock = new Stock();

		try {
			stock = dao.getStockInformation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Gson gson = new Gson();
		String result = gson.toJson(stock);
		System.out.println("Sending data back.");
		PrintWriter out = response.getWriter();
		out.println(result);
		
		
	}

}
