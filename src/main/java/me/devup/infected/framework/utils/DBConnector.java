package me.devup.infected.framework.utils;

import java.sql.*;

public class DBConnector {
	
	private String databaseHost, databaseName, username, password;
	
	private Connection connection;
	
	public DBConnector() {}
	
	public DBConnector(String username, String password, String databaseHost, String databaseName) {
		this.username = username;
		
	    this.password = password;
	    
	    this.databaseHost = databaseHost;
	    
	    this.databaseName = databaseName;
	    
	    connection = null;
	}
	
	public synchronized Connection openConnection() {		
		String url = "jdbc:mysql://" + this.databaseHost + ":3306/" + this.databaseName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, this.username, this.password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
			System.out.println("[Infected] Couldn't connect to the Database!");
		}		
		return connection;
	}
	
	public synchronized void closeConnection() {		
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("[Infected] Couldn't close connection to the Database!");
		}		
	}
	
	public synchronized boolean contains(String database, String column, String search) {
		try {
			PreparedStatement sql = connection.prepareStatement("SELECT * FROM `" + database + "` WHERE `" + column + "`=?;");
			
			sql.setString(1, search);
			
			ResultSet resultset = sql.executeQuery();

			boolean containsPlayer = resultset.next();

			sql.close();
			
			resultset.close();

			return containsPlayer;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}

}
