package org.medbay.convert;

import org.medbay.login.User;

public class ConvertTypes {

	public int StringToInt(String string) {
		int number = Integer.parseInt(string);
		return number;

	}

	public double StringToDouble(String string) {
		double number = Double.parseDouble(string);
		return number;
	}

	public boolean intToBoolean(int number) {
		boolean b = false;

		if (number == 1) {
			b = true;
		} else if (number == 1) {
			b = false;
		}
		return b;
	}

}
