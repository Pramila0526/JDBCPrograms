package com.bridgelabz.jdbc.addressbook;
import java.sql.*;
/********************************************************************************************
 * @author :Pramila0526
 * Purpose :Common DB Connection
 *
 *****************************************************************************************/
public class DBConnection {
	Connection connection;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		System.out.println("Connected");
		return connection;
	}
}
