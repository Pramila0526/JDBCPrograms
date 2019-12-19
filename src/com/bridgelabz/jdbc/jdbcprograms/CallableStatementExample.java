package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;  
/***********************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Callable Statement Example
 *
 ************************************************************************************/
public class CallableStatementExample {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); // Registering the driver
		Connection con = DriverManager.getConnection( // Establishing Connection
				"jdbc:mysql://localhost:3306/EmployeeData", "root", "root"); // URL,Username,Password

		CallableStatement stmt = con.prepareCall("{call empProc(?,?,?,?)}");
		stmt.setInt(1, 112); // Add other id
		stmt.setString(2, "Amit");
		stmt.setString(3, "Bio");
		stmt.setInt(4, 78924);
		stmt.execute();

		System.out.println("SuccessFully added in the database");
		stmt.close();
		con.close();
	}
}

