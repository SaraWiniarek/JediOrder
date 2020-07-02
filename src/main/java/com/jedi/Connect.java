package com.jedi;

import java.sql.*;

public class Connect {
	
	private static String URL = "jdbc:postgresql:JediOrder";
	private static String user = "postgres";
	private static String password = "2414SQL";
	
	public static Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
