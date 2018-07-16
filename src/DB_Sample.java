import java.sql.*;

public class DB_Sample {
	
	public static final String url = "jdbc:sqlserver://192.168.0.126:1433;databaseName=MojaBaza;integratedsecurity=true";
	public static Connection connection;
	
	public static boolean Connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public static ResultSet ExecuteQuery(PreparedStatement sql) {
		try {
			return sql.executeQuery();
		} catch(SQLException e) {
			return null;
		}
	}

	public static void main(String[] args) throws SQLException {
		DB_Sample.Connect();
		String sql = "select * from Klient";
		PreparedStatement s = DB_Sample.connection.prepareStatement(sql);
		ResultSet r = DB_Sample.ExecuteQuery(s);
		while (r.next()) {
			System.out.println(r.getInt(1)+ " " + r.getString(2) + " "+ r.getString(3) + " " + r.getString(4));
		}
	}}

/*	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		try {			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:login_DSN");
			Statement st = con.createStatement();
			st.executeUpdate("insert into Klient values('9','gosia','top','555888')");
			con.commit();
			
			ResultSet rs = st.executeQuery("select * from Zamówienia");
			int i1 = 0; String i3="";String i4="";
			String i2="";
			
			while (rs.next()) {
				i1 = rs.getInt(1);
				i2=rs.getString(2);
				i3=rs.getString(3);
				i4=rs.getString(4);
				System.out.println("ID :" + i1+ "imie: " + i2 + "nazw: " + i3 + "tel: " + i4);
			}
		} catch(SQLException e) {
			System.out.println("blad");
		}
	}*/

		


