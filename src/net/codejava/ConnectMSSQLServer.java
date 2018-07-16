/*package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import org.apache.poi.hsmf.datatypes.DirectoryChunk;

import java.sql.*;

public class ConnectMSSQLServer {

	public void dbConnect(String db_connect_string) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(db_connect_string);

			Statement statement = conn.createStatement();

			statement.executeUpdate("insert into Klient values('8','bart','topij','5448')");

			String queryString = "select * from Klient";
		

			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				 System.out.println(rs.getString(1)); 

				String pFName = rs.getString("imie");
				String pLName = rs.getString("nazwisko");

				System.out.println(pFName);
				System.out.println(pLName);
			}

			conn.close();
			System.out.println("end");

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("Cos Poszlo nie tak.");
		}
	}

	public static void main(String[] args)

	{
		ConnectMSSQLServer connServer = new ConnectMSSQLServer();
		connServer.dbConnect("jdbc:sqlserver://192.168.0.126:1433;databaseName=MojaBaza;integratedsecurity=true");
	}

}
*/