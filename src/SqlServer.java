import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlServer {

	public void dbConnect(String db_connect_string) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(db_connect_string);

			Statement statement = conn.createStatement();
			
			//  statement.executeUpdate("CREATE TABLE cos_tam\r\n"+"(ID int,\r\n"+"NAME char(5),\r\n"+"PRICE numeric(3,2));" );
			 String kon = "CREATE TABLE cos_innego\r\n"+"(ID int,\r\n"+"NAME char(5),\r\n"+"PRICE numeric(3,2));";
			 statement.executeUpdate(kon);
			
			List<List<String>> listaWierszyDobrych = new ArrayList<>();
			List<String> wiersz = new ArrayList<>();
			List<String> wiersz2 = new ArrayList<>();
			wiersz.add("3");
			wiersz.add("ali");
			wiersz.add("ul");
			
			listaWierszyDobrych.add(wiersz);
			
			wiersz2.add("4");
			wiersz2.add("mic");
			wiersz2.add("we");
			
			listaWierszyDobrych.add(wiersz2);
			
			System.out.println(listaWierszyDobrych.get(0));
			System.out.println(listaWierszyDobrych.get(1));
			//System.out.println(listaWierszyDobrych.get(2));
			
			//  String sql = "CREATE DATABASE STUDENTS";
	//	  statement.executeUpdate(sql);-
	
		//	String aa = "cfkf";

			System.out.println("TOOOOOOOOOOOOOOOO");
			  System.out.println(listaWierszyDobrych.get(0));
			for (List<String> t : listaWierszyDobrych) {	
				String wiersz1 = "";
				wiersz1 = t.toString();
				String[] splitedArray = null;
				splitedArray = wiersz1.replace("[", "").replace("]", "").split(",");
				String result = "";
				for (int i = 0 ; i < splitedArray.length ; i++) {
					 result = result + "'"+ splitedArray[i] + "'"+ ",";					
				}
				result = result.substring(0, result.length() - 1);
			//	statement.executeUpdate("insert into Klient values(" + result+ ")");
			}			  
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cos Poszlo nie tak.");
		}
	
	}
	public static void main(String[] args)

	{
		SqlServer connServer = new SqlServer();
		connServer.dbConnect("jdbc:sqlserver://192.168.0.126:1433;databaseName=STUDENTS;integratedsecurity=true");
	}

}
