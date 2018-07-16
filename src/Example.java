/*import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Example {
	
	private String tabelaDBF = "" + "" + "";
    private String tabelaSQL = "";
    private String sciezkaDBF = System.getProperty("user.dir") + "\\incoming2";
    private String createTable = "";
    private int iloscKolumn = 0;
    
    public Example() {
    	
    	SqlServer connServer = new SqlServer();
		connServer.dbConnect("jdbc:sqlserver://192.168.0.126:1433;databaseName=STUDENTS;integratedsecurity=true");
    	
    }
    
	public void dbConnect(String db_connect_string) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(db_connect_string);
			Statement statement = conn.createStatement();
			
			  
			  
		} catch (Exception e) {
			System.out.println("Cos Poszlo nie tak.");
		}
	}
	
    private void polaczenieXLXS() {
    	
    }


	public static void main(String[] args) throws IOException {
		 
//		Pliki.pliki();
		List<List<String>> listaWierszyDobrych = new ArrayList<>();
		List<String> wiersz = new ArrayList<>();
		wiersz.add("ala");
		wiersz.add("ma");
		wiersz.add("kotka");
		wiersz.add(":)");
		listaWierszyDobrych.add(wiersz);
		
		for (List<String> t : listaWierszyDobrych) {
//			zapis.println(t);
			System.out.println("DOBRE: ");
			System.out.println(t);
		}
	}

}
*/