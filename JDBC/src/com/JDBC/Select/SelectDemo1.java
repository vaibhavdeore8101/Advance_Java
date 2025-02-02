package com.JDBC.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo1 {
	
	public static void main(String[] args) {
		
	try {
		
		// 1. Load the Driver class
		    Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Open Connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
			
		// 3. Create/Prepare statement
			Statement statement= connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp1");
			
		// 4. Process the result
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1) + " || "
								+ resultSet.getString(2) + " || "
								+ resultSet.getInt(3));
			}
			
		// 5. Close Connection
			connection.close();
			statement.close();
			resultSet.close();
						
			
			
		}
	catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	
	catch (ClassNotFoundException e) {

		e.printStackTrace();
	}
	}

}
