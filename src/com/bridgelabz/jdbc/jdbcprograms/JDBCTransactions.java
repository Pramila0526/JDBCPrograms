package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
/*******************************************************************************************
 * @author 	:Pramila0526
 * Purpose 	:Program to perform JDBC Transcations
 *
 ********************************************************************************************/
public class JDBCTransactions {
	// JDBC driver name and database URL
	  String driver = "com.mysql.jdbc.Driver";
	  static String URL = "jdbc:mysql://localhost:3306/employee";

	// Database credentials
	  static String user = "root";
	 static String password = "root";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			// Registerring JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Opening Connection
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(URL,user, password);

			// Set auto commit as false.
			connection.setAutoCommit(false);

			// Executing a query
			System.out.println("Creating statement...");
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			// inserting a row into employeetransaction table
			System.out.println("Inserting one row....");
			String SQL = "INSERT INTO employeetransaction " + "VALUES (120, 24, 'Prem', 'Yadav')";
			statement.executeUpdate(SQL);

			// inserting one more row into employeetransaction table
			SQL = "INSERT INTO employeetransaction " + "VALUES (121, 29, 'Siddhi', 'Sonawane')";
			statement.executeUpdate(SQL);

			// commiting here
			System.out.println("Commiting data here....");
			connection.commit();

			// List all records
			String sql = "SELECT * FROM employeetransaction";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("List result set for reference....");
			printTable(rs);

			//  Clean-up environment
			rs.close();
			statement.close();
			connection.close();
			
		} catch (SQLException sqlexcep) {
			// Handle errors for JDBC
			sqlexcep.printStackTrace();
			// If there is an error then rollback the changes.
			System.out.println("Rolling back data here....");
			try {
				if (connection != null)
					connection.rollback();
			} catch (SQLException sqlexcep2) {
				sqlexcep2.printStackTrace();
			} // end try

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("==Done All==");
	}// end main

	public static void printTable(ResultSet rs) throws SQLException {
		// Ensure we start with first row
		rs.beforeFirst();
		int id,age;
		while (rs.next()) {
			// Retrieve by column name
			 id = rs.getInt("empid");
			 age = rs.getInt("age");
			String first = rs.getString("fname");
			String last = rs.getString("lname");

			// Display values
			System.out.print("EmpLoyee ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First Name: " + first);
			System.out.println(", Last Name: " + last+ "\n");
		}
	}// end printRs()
}// end JDBCExample