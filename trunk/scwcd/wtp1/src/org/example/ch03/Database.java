package org.example.ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	public String lookupFullname(String userid) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		String fullname = "";
		String DRIVER = "org.hsqldb.jdbcDriver";
		String URL = "jdbc:hsqldb:hsql://localhost/kyrios-teste";
		String QUERY = "select fullname from login where userid = ?";
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL);
			statement = connection.prepareStatement(QUERY);
			statement.setString(1, userid);
			resultset = statement.executeQuery();
			if (resultset.next())
				fullname = resultset.getString("FULLNAME").trim();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultset != null)
				resultset.close();
			
			if (statement != null)
				statement.close();
			
			if (connection != null)
				connection.close();
		}
		
		return fullname;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(new Database().lookupFullname("mandel"));
	}
}
