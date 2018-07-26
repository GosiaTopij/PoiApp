package com.test;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		
/*		String s = "11[5,2]";
		int size1 = Integer.parseInt(s.substring(s.indexOf("[")+1,s.indexOf(",")));
		int size2 = Integer.parseInt(s.substring(s.indexOf(",")+1,s.length()-1));
		System.out.println(size1);
		System.out.println(size2);
		int i = Integer.parseInt(s);
		System.out.println(i);*/
	//	String s = "mmm";
	//	int ss = 0 ;
	//	try {
	//		 Integer.parseInt(s);
	//	}catch (Exception e) {
	//		System.out.println(ss + 5);
	//	}
	//	s = "";
	//	System.out.println(s);
/*		String newLine = System.getProperty("line.separator");
		List<String> lista = new ArrayList<String>();
		lista.add("Ania ma kota" + newLine);
		lista.add("Ala nie ma kota");
		System.out.println(lista.get(0));*/
		
	//	String schema = "C:\\\\Users\\\\Topij Ma³gorzata\\\\xlsx\\\\test";
	//	schema.substring(schema.indexOf("\\\\xlsx\\\\") + 1, schema.length());
	//	System.out.println(schema.substring(schema.indexOf("xlsx\\") + 6, schema.length()));
		
	//	System.out.println(ss);
	//	try { Integer.parseInt(s);
	//	} catch (NumberFormatException e) { System.out.println("blad");
	//	}
//		String regex = "[0 ]+";
		String[] splitedArray = null;
		String wiersz1 = "[ma,na,gh,dd,ss]";
		splitedArray = wiersz1.split(",");
	//	System.out.println(splitedArray[0]);
		String result = "";
		for (int i = 0 ; i < splitedArray.length ; i++) {
			 result = result + splitedArray[i];

		}
		result = result.substring(0, result.length() - 1);
	//	System.out.println(result);
		
		String g = "PRICE numeric(3,2)" ;
		System.out.println(g.substring(g.indexOf(" ")+1));
	//	System.out.println(s.matches(regex));
	//	System.out.println(s);
		//String[] splitedArray = null;
		//splitedArray = s.split("\\.");		
	//	System.out.println(splitedArray.length);
	//	System.out.println(s.length());		
//		int ss = Integer.parseInt(s);		
//		s = s.replace(",", ".").replace(" ", "");		
		//System.out.println(s.substring(0, s.indexOf(".")).length());
		//System.out.println(s.substring(s.indexOf(".")+1).length());
//		System.out.println(ss);
	}

}
