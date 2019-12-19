package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
/***********************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Prepared Statement Example
 *
 ************************************************************************************/
class PreparedStatementExample {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  //Registering the Driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeData", "root", "root");//Establishing the Connection
			PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?,?)");
			stmt.setInt(1, 107); // 1 specifies the first parameter in the query
			stmt.setString(2, "Raj");
			stmt.setString(3, "Med");
			stmt.setInt(4, 89632);
			int i = stmt.executeUpdate();  //Execute Query
			System.out.println(i + " Records are inserted");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}