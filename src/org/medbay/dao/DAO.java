package org.medbay.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.medbay.Employee;
import org.medbay.login.Login;
import org.medbay.login.User;
import org.medbay.medicine.Medicine;
import org.medbay.modal.Batch;
import org.medbay.modal.Billing;
import org.medbay.modal.BillingItem;
import org.medbay.modal.OrderItem;
import org.medbay.modal.Stock;

public class DAO {

	private static Connection con = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/medicalstore";

	private static Statement statement = null;

	public static Connection getDatabaseConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	// Adding new Medicine
	public boolean addMedicine(Medicine medicine) throws SQLException {

		boolean added = false;
		boolean batchAdd = false;
		boolean medicineAdd = false;
		ArrayList<Batch> batchList = new ArrayList<Batch>();
		getDatabaseConnection();
		System.out.println("Got Connection");
		statement = con.createStatement();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String mfg = medicine.getMfg();
		String exp = medicine.getExp();

		LocalDate mfgconv = LocalDate.parse(mfg, formatter);
		LocalDate expconv = LocalDate.parse(exp, formatter);

		// Get LocalDate from SQL date
		java.sql.Date mfgdate = java.sql.Date.valueOf(mfgconv);
		java.sql.Date expdate = java.sql.Date.valueOf(expconv);

		System.out.println("\nExecuting query for medicine table");
		String sql = "INSERT INTO medicalstore.tbl_medicine( name, formula, type, dose, rack, critical, cost, mrp ) VALUES('"
				+ medicine.getName() + "','" + medicine.getFormula() + "','" + medicine.getType() + "','"
				+ medicine.getDose() + "'," + medicine.getRack() + "," + medicine.getCritical() + ","
				+ medicine.getCost() + "," + medicine.getMrp() + ");";

		int rs = statement.executeUpdate(sql);
		System.out.println("rows updated in medicine table: " + rs);

		if (rs > 0) {
			added = true;

			if (added) {

				String sql2 = "SELECT med_id FROM medicalstore.tbl_medicine ORDER BY med_id DESC LIMIT 1;";
				ResultSet result = statement.executeQuery(sql2);

				if (result.next()) {

					int medId = result.getInt("med_id");
					System.out.println("Getting the id form medicine talbe for batch: " + medId);

					int critical = medicine.getCritical();

					String status = "active";

					double pack = medicine.getPacks();
					int strength = medicine.getStrength();
					double number = pack * strength;

					LocalDate local = LocalDate.now();
					Date currentDate = Date.valueOf(local);

					if ((number == 0.00) && ((currentDate.compareTo(expdate) < 0))) {
						status = "sold";
					} else if ((currentDate.compareTo(expdate) > 0)
							|| (currentDate.compareTo(expdate) == 0) && number > 0.00) {
						status = "expired";
					}

					String sql3 = "INSERT INTO medicalstore.tbl_batch( batchno, mfg, exp, packqty, strength, distributor, supplier, med_id, `status` ) VALUES('"
							+ medicine.getBatch() + "','" + mfgdate + "','" + expdate + "'," + medicine.getPacks() + ","
							+ medicine.getStrength() + ",'" + medicine.getDistributor() + "','" + medicine.getDealer()
							+ "'," + medId + ",'" + status + "');";

					int rs2 = statement.executeUpdate(sql3);

					if (rs2 > 0) {

						batchAdd = true;

						System.out.println("Batch Stored in database, Rows Updated: " + rs2);
						// and not expired;
						String sql4 = "select * from medicalstore.tbl_batch where `med_id` = " + medId + ";";

						ResultSet result2 = statement.executeQuery(sql4);

						number = 0.0;
						String expired = "expired";

						if (result2.next()) {

							Batch batch = new Batch();

							double packtemp = result2.getDouble(5);
							int strengthtemp = result2.getInt(6);
							String exptemp = result2.getString(10);

							if (!(exptemp.equals(expired))) {
								expired = "not";
							}

							number += packtemp * strengthtemp;

						}

						status = "normal";
						if (number == 0.0) {
							status = "out";
						} else if (number < critical) {
							status = "low";
						} else if (expired.equals("expired")) {
							status = "expired";
						}

						System.out.println("Status set to: " + status + " for med_id: " + medId);

						String sql5 = "UPDATE medicalstore.tbl_medicine SET `stock` = '" + status
								+ "' WHERE `med_id` = " + medId + ";";

						int res = statement.executeUpdate(sql5);

						System.out.println("udpate query ran for stock.");

						if (res > 0) {
							System.out.println("stock updated to :" + status);
						}

						medicineAdd = true;
					}

				}

			}

		}

		System.out.println("Medicine Stored in database, Rows Updated: " + rs);

		con.close();

		return medicineAdd;
	}

	// Getting Medicine for Options on KeyUp
	public ArrayList<Medicine> getMedicineOption(String search) throws SQLException {

		con = getDatabaseConnection();

		ArrayList<Medicine> list = new ArrayList<Medicine>();

		statement = con.createStatement();

		String sql = "select * from medicalstore.tbl_medicine where `name` LIKE '%" + search + "%';";
		ResultSet rs = statement.executeQuery(sql);

		System.out.println("Gettting the result");

		while (rs.next()) {

			Medicine medicine;

			// validation required;
			String name = rs.getString("name");
			String dose = rs.getString("dose");

			medicine = new Medicine(name, dose);
			list.add(medicine);

		}
		System.out.println("Returning the list of medicines: " + list);

		return list;

	}

	// Getting Medicine Options for price and formula
	public Medicine getMedicineOptionRecord(String namestr, String dosestr) throws SQLException {

		con = getDatabaseConnection();

		Medicine medicine = null;

		statement = con.createStatement();

		String sql = "select * from medicalstore.tbl_medicine where `name`='" + namestr + "' AND `dose`=  '" + dosestr
				+ "';";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			// validation required;
			String formula = rs.getString("formula");
			double mrp = rs.getDouble("mrp");
			String stock = rs.getString("stock");

			medicine = new Medicine(formula, mrp, stock);

		}
		return medicine;
	}

	// Get medicine record for the adding the row to the table
	public Medicine getMedicineRow(String namestr, String dosestr, String formulastr, double price)
			throws SQLException {

		con = getDatabaseConnection();

		Medicine medicine = new Medicine();

		statement = con.createStatement();

		String sql = "select * from medicalstore.tbl_medicine where `name`='" + namestr + "'AND `mrp`=" + price
				+ "  AND `dose`=  '" + dosestr + "' AND `formula`='" + formulastr + "';";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			// validation required;
			int id = rs.getInt("med_id");
			String name = rs.getString("name");
			String formula = rs.getString("formula");
			String type = rs.getString("type");
			String dose = rs.getString("dose");
			double mrp = rs.getDouble("mrp");

			medicine = new Medicine(id, name, formula, type, dose, mrp);

		}

		return medicine;

	}

	// Get order record for the adding the row to the order table
	public Medicine getOrderRow(String namestr, String dosestr, String formulastr, String stockstr)
			throws SQLException {

		con = getDatabaseConnection();

		Medicine medicine = new Medicine();

		statement = con.createStatement();

		String sql = "select * from medicalstore.tbl_medicine where `name`='" + namestr + "' AND `dose`=  '" + dosestr
				+ "' AND `formula`='" + formulastr + "' AND `stock`= '" + stockstr + "';";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			// validation required;
			int id = rs.getInt("med_id");
			String name = rs.getString("name");
			String formula = rs.getString("formula");
			String type = rs.getString("type");
			String dose = rs.getString("dose");
			double mrp = rs.getDouble("mrp");

			medicine = new Medicine(id, name, formula, type, dose, mrp);

		}

		return medicine;

	}

	///// Add the billng information
	public int insertBill(Billing billing) throws SQLException {

		int id = 0;

		double total = billing.getTotal();
		double discount = billing.getDiscount();
		double grandtotal = billing.getGrandTotal();

		con = getDatabaseConnection();

		statement = con.createStatement();

		String sql = "insert into medicalstore.tbl_billing(`total`, `discount`, `grandtotal`) " + "values(" + total
				+ ", " + discount + ", " + grandtotal + ");";

		int row = statement.executeUpdate(sql);

		if (row > 0) {

			sql = "SELECT transaction_id FROM medicalstore.tbl_billing ORDER BY transaction_id DESC LIMIT 1;";
			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {

				id = result.getInt("transaction_id");
				System.out.println("Got the trans_id" + id);
			}

		}

		return id;
	}

	/// insert the billing item information
	public boolean insertBillingItem(ArrayList<BillingItem> itemList) throws SQLException {

		boolean added = false;
		con = getDatabaseConnection();
		statement = con.createStatement();

		for (BillingItem item : itemList) {

			int med_id = item.getMed_id();
			String name = item.getName();
			String formula = item.getFormula();
			String type = item.getType();
			String dose = item.getDose();
			String batch = item.getBatch();
			int quantity = item.getQuantity();
			double mrp = item.getMrp();
			double total = item.getTotalPrice();
			int tran_id = item.getTransactionId();

			String sql = "insert into medicalstore.tbl_billingitem(`med_id`,`name`,`formula`,"
					+ "`type`,`dose`,`batch`,`quantity`,`mrp`,`totalprice`,`transaction_id`) values(" + med_id + ","
					+ "'" + name + "','" + formula + "','" + type + "','" + dose + "','" + batch + "'," + quantity + ","
					+ "" + mrp + "," + total + "," + tran_id + ");";

			int rs = statement.executeUpdate(sql);
			if (rs > 0) {

				System.out.println("Rows Updated: " + rs);

			}

		}

		added = true;

		return added;

	}

	public int insertOrder() throws SQLException {

		int order_id = 0;

		getDatabaseConnection();
		statement = con.createStatement();

		LocalDate locald = LocalDate.now();

		Date date = Date.valueOf(locald); // Magic happens here!
		String status = "pending";
		String sql = "insert into medicalstore.tbl_order(`orderdate`,`status`) values('" + date + "','" + status
				+ "');";

		int rs = statement.executeUpdate(sql);

		if (rs > 0) {

			sql = "SELECT order_id FROM medicalstore.tbl_order ORDER BY order_id DESC LIMIT 1";
			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				order_id = result.getInt(1);
			}
		}

		System.out.println("Order id is: " + order_id);

		return order_id;
	}

	public boolean insertOrderItem(ArrayList<OrderItem> itemList) throws SQLException {

		boolean added = false;
		con = getDatabaseConnection();
		statement = con.createStatement();

		for (OrderItem item : itemList) {

			int med_id = item.getMed_id();
			double quantity = item.getQtyReceived();
			int order_id = item.getOrderId();
			String status = item.getStatus();

			String sql = "insert into medicalstore.tbl_orderitem(`med_id`,`qtyordered`,`order_id`,`status`) values(" + med_id
					+ "," + quantity + "," + order_id + ", '"+ status +"');";

			int rs = statement.executeUpdate(sql);
			if (rs > 0) {

				System.out.println("Rows Updated: " + rs);

			}

		}

		added = true;

		return added;

	}

	// Get the stock info
	public Stock getStockInformation() throws SQLException {

		Stock temp = new Stock();

		con = getDatabaseConnection();
		statement = con.createStatement();

		CallableStatement stmt = con.prepareCall("{ call medicalstore.GetStockInfo(?,?,?,?) }");

		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.registerOutParameter(2, Types.INTEGER);
		stmt.registerOutParameter(3, Types.INTEGER);
		stmt.registerOutParameter(4, Types.INTEGER);
		stmt.execute();

		int value = stmt.getInt(1);
		int low = stmt.getInt(2);
		int out = stmt.getInt(3);
		int expired = stmt.getInt(4);

		System.out.println("the number of medicines are: " + value);
		System.out.println("the number of medicines are: " + low);
		System.out.println("the number of medicines are: " + out);
		System.out.println("the number of medicines are: " + expired);

		temp = new Stock(value, low, out, expired);

		return temp;
	}

	// Search for Medicine
	public JSONArray getAllMedicine(String name) throws SQLException, JSONException {

		getDatabaseConnection();

		statement = con.createStatement();

		String sql = "SELECT * FROM medicalstore.medicine;";
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("results returned");

		JSONArray array = new JSONArray();

		if (!rs.next()) {
			System.out.println("no results found");
		} else {

			////////////////// remove null and check
			while (rs.next()) {
				int id = rs.getInt("id");
				String name1 = rs.getString("name");
				String type = rs.getString("type");
				String dose = rs.getString("dose");
				if (dose == null) {
					dose = "";
				}
				String formula = rs.getString("formula");
				if (formula == null) {
					formula = "";
				}

				JSONObject json = new JSONObject();
				json.put("id", id);
				json.put("name", name1);
				json.put("type", type);
				json.put("dose", dose);
				json.put("formula", formula);

				array.put(json.toString());
			}
		}
		statement.close();
		con.close();

		return array;
	}

	public Login getUser(Login login) throws SQLException {

		Login user = new Login();

		String username = login.getUsername();
		String password = login.getPassword();
		int admin = login.getAdmin();

		getDatabaseConnection();

		statement = con.createStatement();
		System.out.println("Querying");
		String sql = "SELECT * FROM medicalstore.login where username='" + username + "' AND `password`='" + password
				+ "' AND isadmin =" + admin + " ;";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			System.out.println("Got the User: " + rs.getRow());

			String user1 = rs.getString("username");
			String pass = rs.getString("password");
			int isadmin = rs.getInt("isadmin");

			System.out
					.println("Database username is: " + username + " password: " + password + " and admin is " + admin);

			user = new Login(user1, pass, isadmin);
			System.out.println(user1);
		}
		System.out.println("Got the user");

		return user;

	}

	public List<Medicine> getMedicine(String name, String key) throws SQLException {

		List<Medicine> list = new ArrayList<Medicine>();

		con = getDatabaseConnection();
		statement = con.createStatement();
		String sql = "";
		name.toLowerCase();

		System.out.println("Value going in database: " + name + " :" + key);
		sql = "select * from medicalstore.medicine where " + name + "='" + key + "';";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name1 = rs.getString("name");
			String type = rs.getString("type");
			String dose = rs.getString("dose");
			if (dose == null) {
				dose = "";
			}
			String formula = rs.getString("formula");
			if (formula == null) {
				formula = "";
			}

			// Medicine medicine = new Medicine(id, name1, type, dose, formula);
			// list.add(medicine);

		}

		return list;
	}

	public boolean addEmployee(Employee employee) throws SQLException {

		boolean added = false;
		getDatabaseConnection();
		statement = con.createStatement();

		String fname = employee.getFirstname();
		String lname = employee.getLastname();
		String email = employee.getEmail();
		String username = employee.getUsername();
		String password = employee.getPassword();
		String dob = employee.getDob();
		String post = employee.getDesignation();
		String address = employee.getAddress();
		String gender = employee.getGender();
		String cnic = employee.getCnic();
		String cell = employee.getCellPhone();
		String line = employee.getLandLine();

		String sql = "INSERT INTO medicalstore.employees(firstname,lastname,email,username,password,dob,address,cnic,gender,cellphone,landline,designation) "
				+ "VALUES('" + fname + "','" + lname + "','" + email + "','" + username + "','" + password + "','" + dob
				+ "','" + address + "','" + cnic + "','" + gender + "','" + cell + "','" + line + "','" + post + "');";

		System.out.println("executing the query");

		try {
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				added = true;
				System.out.println("Rows Added: " + result);
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();

		}

		return added;

	}

	public boolean addUser(User user) throws SQLException {

		boolean result = false;
		getDatabaseConnection();

		String fname = user.getFirstname();
		String lname = user.getLastname();
		String dob = user.getDob();
		String username = user.getUsername();
		String password = user.getPassword();
		password = hashPassword(password);
		String email = user.getEmail();
		String gender = user.getGender();
		int admin = user.getAdmin();

		statement = con.createStatement();

		String sql = "{CALL insert_into_user_login(?,?,?,?,?,?,?,?)}";

		try {
			CallableStatement stmt = con.prepareCall(sql);

			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, dob);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setString(6, email);
			stmt.setString(7, gender);
			stmt.setInt(8, admin);

			stmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		System.out.println("executing the query");

		return result;
	}

	public String hashPassword(String password) {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		// test
		System.out.println("Password(in hex format):: " + sb.toString());

		password = sb.toString();

		return password;
	}

}// end of class
