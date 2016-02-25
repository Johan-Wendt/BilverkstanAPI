package bilverkstanAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;

public class Main {
	private static final String USERNAME = "johan";
	private static final String PASSWORD = "Jag1337";
	private static final String CONN_STRING = 
			"jdbc:mysql://localhost:3306/bilverkstaden";
	

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSetImpl rs = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			
			stmt = (Statement) conn.createStatement();
			
			rs = (ResultSetImpl) stmt.executeQuery("Select * from Costumer");
			rs.last();
			System.out.println("nr " + rs.getRow());
		//	System.out.println("connected");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		

	}

}
