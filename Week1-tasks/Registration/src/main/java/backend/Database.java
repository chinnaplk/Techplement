package backend;

import java.sql.*;
import java.io.*;

public class Database {

		private static final String url = "jdbc:mysql://localhost:3306/users";
		
		private static final String username = "root";
		
		private static final String pwd = "6868";
		
		public static Connection getconnection() throws SQLException
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
//				System.out.println("Connection Succesfull");
			}
			catch(ClassNotFoundException e){
		            throw new SQLException("MySQL JDBC Driver not found.", e);
		    }
			
			return DriverManager.getConnection(url,username,pwd);
			
		}
}
