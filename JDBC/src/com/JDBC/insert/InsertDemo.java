package com.JDBC.insert;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class InsertDemo {
	
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filePath ="D:\\Adv. Java\\JDBC\\src\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		try {
			file = new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection
							(properties.getProperty("dburl"),
									properties);
			
			statement = connection.createStatement();
			query = "insert into Student "
					+ "values (3,'Amar',"
					+ "'anthony@gmail.com',8899651234)";
			result = statement.executeUpdate(query);
			
			if (result != 0) {
				System.out.println(result + 
								" row(s) affected.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
