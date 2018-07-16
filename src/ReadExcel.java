import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ReadExcel {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		Pliki.pliki();
	}

	public static void read(Workbook workbook, Sheet datatypeSheet) {

		String str = "";
		List<String> lista = new ArrayList<String>();

		for (Sheet sheet : workbook) {
			for (Row row : datatypeSheet) {
				for (Cell cell : row) {
					str = str + cell + " ";
					System.out.print(cell + " ");
				}
				lista.add(str);
				str = "";
				System.out.println();
			}
		}
		
/*		 * for (int i = 0; i <= datatypeSheet.getLastRowNum(); i++) { for (int j = 0; j
		 * < datatypeSheet.getRow(i).getLastCellNum(); j++) { try { if
		 * ((datatypeSheet.getRow(i).getCell(j) == null) ||
		 * (datatypeSheet.getRow(i).getCell(j).toString() == "")) break; else { str =
		 * str + datatypeSheet.getRow(i).getCell(j).toString() + " ";
		 * System.out.print(datatypeSheet.getRow(i).getCell(j) + " "); } } catch
		 * (NullPointerException e) { System.out.println(e.getMessage()); } }*/
		 
		// lista.add(str);
		// str = "";
		// System.out.println();
		System.out.println(lista);
	}

	// System.out.println(lista);
//	}
	public static void wali(String nazwaPliku, String nazwaKrotka) throws IOException, SQLException, ClassNotFoundException {

		FileInputStream excelFile = new FileInputStream(new File(nazwaPliku));
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);
//		int numberSheets = workbook.getNumberOfSheets();
		// for( int i = 0 ; i < numberSheets ; i++ ) {
		// Sheet datatypeSheet = workbook.getSheetAt(i);
		// }

		List<List<String>> listaWierszyDobrych = new ArrayList<>();
		List<List<String>> listaWierszyZlych = new ArrayList<>();

		String s = "";
//		for (int ii = 0; ii < numberSheets; ii++) {           // wypisuje nag³ówki
//			Sheet datatypeSheet = workbook.getSheetAt(ii);
		
/*		String pom ="\"CREATE TABLE\"" + nazwaPliku + "\"\r\n\"" + "\"(";
		String createTable = "";
		
		for (int j = 0; j < datatypeSheet.getRow(0).getLastCellNum(); j++) {
			if ((datatypeSheet.getRow(0).getCell(j) == null))
				break;
			System.out.print(datatypeSheet.getRow(0).getCell(j) + "\t ");			
			createTable = createTable + datatypeSheet.getRow(0).getCell(j).toString() + ",\"+";			
			s = s + datatypeSheet.getRow(0).getCell(j) + "\t ";
		}
		createTable = createTable.substring(0, createTable.length()-3 );
		createTable = createTable  + ");\"";
		pom = pom + createTable;
		statement.executeUpdate(pom);
		
		System.out.println();*/
//		}

//		for (int ii = 0; ii < numberSheets; ii++) {
//			Sheet datatypeSheet = workbook.getSheetAt(ii);
		for (int i = 1; i <= datatypeSheet.getLastRowNum(); i++) {
			boolean wsk = true;
			List<String> wiersz = new ArrayList<>();

			if (datatypeSheet.getRow(i) != null) {

				for (int j = 0; j < datatypeSheet.getRow(i).getLastCellNum(); j++) {

					if ((datatypeSheet.getRow(i).getCell(j) == null)
							|| (datatypeSheet.getRow(i).getCell(j).toString() == "")) {
						wiersz.add("\t");
						wsk = false;
						continue;
					}
					String schema = "";

					if (datatypeSheet.getRow(0).getCell(j) != null) {
						schema = datatypeSheet.getRow(0).getCell(j).toString();
					}
									
					String value = datatypeSheet.getRow(i).getCell(j).toString();
					wiersz.add(value);
					if (datatypeSheet.getRow(i).getLastCellNum() > datatypeSheet.getRow(0).getLastCellNum()) {
						wsk = false;
					}
		
					
					if (schema.toLowerCase().contains(" varchar") || schema.toLowerCase().contains(" char")) {
						
						try{ int size = Integer.parseInt(schema.substring(schema.indexOf("(") + 1, schema.length() - 1));
							if (Walidacja2.dlaVarchar(value, size) == false) {
								wsk = false;
							}
						} catch(Exception e) {}
						

					} else if (schema.toLowerCase().contains(" int")) {
						if (Walidacja2.dlaInt(value) == false) {
							wsk = false;
						}
					} else if (schema.toLowerCase().contains(" numeric")) {
						int size1 = Integer.parseInt(schema.substring(schema.indexOf("(") + 1, schema.indexOf(",")));
						int size2 = Integer.parseInt(schema.substring(schema.indexOf(",") + 1, schema.length() - 1));
						if (Walidacja2.dlaNumeric(value, size1, size2) == false) {
							wsk = false;
						}
					}
				}
			} else {
				break;
			}

			if (wsk == true) {
				listaWierszyDobrych.add(wiersz);
			} else {
				listaWierszyZlych.add(wiersz);
			}
		}
//		}

		try {
			String nazwaTxt = nazwaPliku.substring(nazwaPliku.indexOf("xlsx\\") + 5, nazwaPliku.length() - 5);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager
					.getConnection("jdbc:sqlserver://192.168.0.126:1433;databaseName=STUDENTS;integratedsecurity=true");
				Statement statement = conn.createStatement();
			 
				String pom ="\"CREATE TABLE " + nazwaTxt + " \\r\\n\"+" + "\"(";
				String pom2 ="\"CREATE TABLE " + nazwaTxt +"_error" + "\\r\\n\"+" + "\"(";
				String createTable = "";							
				for (int j = 0; j < datatypeSheet.getRow(0).getLastCellNum(); j++) {
					if ((datatypeSheet.getRow(0).getCell(j) == null) || (datatypeSheet.getRow(0).getCell(j).toString() == ""))
						break;
					System.out.print(datatypeSheet.getRow(0).getCell(j) + "\t");

					if (j == 0) {
					createTable = datatypeSheet.getRow(0).getCell(j).toString() + ",\\r\\n\"+";
					} else {
						createTable = createTable +"\"" + datatypeSheet.getRow(0).getCell(j).toString() + ",\\r\\n\"+";	
					}
					s = s + datatypeSheet.getRow(0).getCell(j) + "\t"; 
				}	
				createTable = createTable.substring(0, createTable.length() - 7);
				createTable = createTable  + ");\"";
				pom = pom + createTable; 
				pom2 = pom2 + createTable;
				System.out.println(pom);System.out.println(pom2);
				statement.executeUpdate(pom);
				statement.executeUpdate(pom2);	
				
			//	 String kon = "CREATE TABLE TUTAJ2\r\n"+"(ID int,\r\n"+"NAME char(5),\r\n"+"PRICE numeric(3,2));";
			//	 statement.executeUpdate(kon);
				
			for (List<String> t : listaWierszyDobrych) {
				String wiersz1 = "";
				wiersz1 = t.toString();
				String[] splitedArray = null;
				splitedArray = wiersz1.replace("[", "").replace("]", "").split(",");
				String result = "";
				for (int i = 0; i < splitedArray.length; i++) {
					result = result + "'" + splitedArray[i] + "'" + ",";
				}
				result = result.substring(0, result.length() - 1);				
				statement.executeUpdate("insert into" + nazwaTxt + "values(" + result + ")");
			//	statement.executeUpdate("insert into TUTAJ2 values(" + result + ")");
			}
			for (List<String> t : listaWierszyZlych) {
				String wiersz1 = "";
				wiersz1 = t.toString();
				String[] splitedArray = null;
				splitedArray = wiersz1.replace("[", "").replace("]", "").split(",");
				String result = "";
				for (int i = 0; i < splitedArray.length; i++) {
					result = result + "'" + splitedArray[i] + "'" + ",";
				}
				result = result.substring(0, result.length() - 1);
				statement.executeUpdate("insert into" + nazwaTxt +"_error" +" values(" + result + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cos Poszlo nie tak.");
		}

		
		String nazwaTxt = nazwaPliku.substring(nazwaPliku.indexOf("xlsx\\") + 5, nazwaPliku.length() - 5);
		PrintWriter zapis = new PrintWriter("C:\\\\Users\\\\Topij Ma³gorzata\\\\xlsx\\\\" + nazwaTxt + ".txt");
		zapis.println(s);
		for (List<String> t : listaWierszyDobrych) {
			zapis.println(t);
			System.out.println("DOBRE: ");
			System.out.println(t);
		}
		zapis.close();
		PrintWriter zapis1 = new PrintWriter("C:\\\\Users\\\\Topij Ma³gorzata\\\\xlsx\\\\" + nazwaTxt + "_error.txt");
		zapis1.println(s);
		for (List<String> t : listaWierszyZlych) {
			zapis1.println(t);
			System.out.println("Z£E: ");
			System.out.println(t);
		}
		zapis1.close();
	}

}
