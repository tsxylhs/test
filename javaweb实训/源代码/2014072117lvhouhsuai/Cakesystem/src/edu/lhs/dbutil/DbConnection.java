package edu.lhs.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {
	private static String url;
	private static String connString;
	private static String userName;
	private static String password;
	
	static{
		Properties prop=new Properties();
		try {
			prop.load(DbConnection.class.getResourceAsStream("/jdbc.properties"));
			url=prop.getProperty("jdbc.url");
			connString=prop.getProperty("jdbc.connString");
			userName=prop.getProperty("jdbc.userName");
			password=prop.getProperty("jdbc.password");
			Class.forName(url);
		} catch (ClassNotFoundException e) {
			System.err.println("class not found..."+e.getMessage());
		} catch (IOException e) {
			System.err.println("io exception..."+e.getMessage());
		}
	}
	
	public static Connection getConnection(){
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(connString,userName,password);
		} catch (SQLException e) {
			System.err.println("connection error..."+e.getMessage());
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection){
		if(null!=connection){
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("close error..."+e.getMessage());
			}
		}
	}
}
