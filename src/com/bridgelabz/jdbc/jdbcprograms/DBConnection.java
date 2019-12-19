package com.bridgelabz.jdbc.jdbcprograms;
/***********************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Class For Connection 
 *
 ************************************************************************************/
import java.sql.*;
public class DBConnection {
	Connection connection;
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); //Registreing the driver
		System.out.println("Driver loaded");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		System.out.println("Connected");
		return connection;
	}
}
