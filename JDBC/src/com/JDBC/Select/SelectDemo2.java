package com.JDBC.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo2 {
	
	    public static Connection connection;
		public static Statement statement;
		public static ResultSet resultSet;
		public static String driverPath= "com.mysql.cj.jdbc.Driver";
		public static String dburl="jdbc:mysql://localhost:3306/jdbc_db?user=root&password=root";
		private static String query;
		
		
		
		public static void main(String[] args) {
			
			try {
				
				//1. Load Driver class
				Class.forName(driverPath);
				
				//2. Open Connection
				connection = DriverManager.getConnection(dburl);
				
				//3. Create Statement
				statement = connection.createStatement();
				query = "select * from emp1";
				resultSet = statement.executeQuery(query);
				
				//4. Process the result
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1) + " || "
									+ resultSet.getString(2));
				}
				
			} catch (ClassNotFoundException | SQLException e) {
			
				e.printStackTrace();
			}
			
			 finally {
					//5. Close connection
					try {
						if (connection != null) {
							connection.close();
						}
						if (statement != null) {
							statement.close();
						}
						if (resultSet != null) {
							resultSet.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}


