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
import org.medbay.modal.Order;

import com.google.gson.Gson;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO dao = null;
	private Order order = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("This Order servlet is getting the data");
		int id = 0;
		dao = new DAO();
		try {
			id = dao.insertOrder();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		order = new Order();
		order.setOrderId(id);
		
		Gson gson = new Gson();
		String result = gson.toJson(order);
		System.out.println("Sending data back.");
		PrintWriter out = response.getWriter();
		out.println(result);
		
		
	}

}
