package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDTH {
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet rs = null;
	
	public static ResultSet executeDTHQueries(String query) throws SQLException {
		String driverInfo = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uname = "system";
		String pwd = "tcs12345"; 
		
		try {
			Class.forName(driverInfo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		con = DriverManager.getConnection(url,uname,pwd);
		System.out.println("Connection created successfully");
		st = con.createStatement();
		String[] arrQuery = query.split(" ");
		if(arrQuery[0].equalsIgnoreCase("Select")) {
			rs = st.executeQuery(query);
			return rs;
		} else if(arrQuery[0].equalsIgnoreCase("Insert") || arrQuery[0].equalsIgnoreCase("Update") || arrQuery[0].equalsIgnoreCase("Delete")) {
			int i = st.executeUpdate(query);
			System.out.println(i + " rows are affected");
			return rs;
		}
		return rs;
	}
}