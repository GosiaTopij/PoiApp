package com.read;

public class Walidacja {

	public static boolean dlaVarchar(String c1, int x) {
		if ((c1.length() > x) || (c1.length() < 1)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean dlaInt(String c1) {

		try {
			Integer.parseInt(c1);
			return true;
		} catch (NumberFormatException e) {
			c1 = c1.replace(",", ".").replace(" ", "");
			String[] splitedArray = null;
			splitedArray = c1.split("\\.");

			if (splitedArray.length != 2) {
				return false;

			} else {
				String regex = "[0]+";
				String regex2 = "[0-9]+";
				if ((splitedArray[1].matches(regex) == false) || (splitedArray[0].matches(regex2) == false)) {
					return false;
				}
			}			
		}
		return true;
	}

	public static boolean dlaNumeric(String c1, int x, int y) { // dla numeric [x,y]

		c1 = c1.replace(",", ".").replace(" ", "");
		String[] splitedArray = null;
		splitedArray = c1.split("\\.");

		if (splitedArray.length != 2) {
			return false;
		} else {
			try {
				Integer.parseInt(splitedArray[0]);
			} catch (Exception e) {
				return false;
			}

			try {
				Integer.parseInt(splitedArray[1]);
			} catch (Exception e) {
				return false;
			}

			if (splitedArray[0].length() != x) {
				return false;
			}
			if (splitedArray[1].length() != y) {
				return false;
			}
		}
		return true;
	}
}
