package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
/********************************************************************************************
 * @author :Pramila0526 
 * Purpose :Batch Processing Using Prepared Statement
 *
 *****************************************************************************************/
public class BatchProceessingUsingPrepared 
{
	static Connection connection = null;
	static PreparedStatement pstmt = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		String sqlQuery = "insert into employeetransaction(empid,age,fname,lname) values(?,?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);

			connection.setAutoCommit(false);

			pstmt.setInt(1, 137);
			pstmt.setInt(2, 26);
			pstmt.setString(3, "Neha");
			pstmt.setString(4, "Singh");
			pstmt.addBatch();

			pstmt.setInt(1, 138);
			pstmt.setInt(2, 25);
			pstmt.setString(3, "Supriya");
			pstmt.setString(4, "Pawar");
			pstmt.addBatch();

			pstmt.executeBatch();
			connection.commit();
			// select all the records and display them.
			printTableUsingResultSet(pstmt);

			// Clean-up environment
			pstmt.close();
			connection.close();
		} 
		catch (SQLException sqlexception) 
		{
			// Handle errors for JDBC
			sqlexception.printStackTrace();
		} 
		catch (Exception exception)
		{
			// Handle errors for Class.forName
			exception.printStackTrace();
		} 
		finally 
		{
			// finally block used to close resources
			try 
			{
				if (pstmt != null)
					pstmt.close();
			} 
			catch (SQLException sqlexception) 
			{
				System.out.println(sqlexception);
			} 
			try 
			{
				if (connection != null)
					connection.close();
			}
			catch (SQLException sqlexception) 
			{
				sqlexception.printStackTrace();
			} 
		} 
		System.out.println("Goodbye!");
	}

	public static void printTableUsingResultSet(Statement stmt) throws SQLException {
		int id = 0;
		int age = 0;
		String firstName = " ";
		String lastName = " ";
		System.out.println("Displaying available rows...");
		// Let us select all the records and display them.
		String sql = "select * from employeetransaction";
		ResultSet resultSet = stmt.executeQuery(sql);

		while (resultSet.next()) 
		{
			// Retrieve by column name
			id = resultSet.getInt("empid");
			age = resultSet.getInt("age");
			firstName = resultSet.getString("fname");
			lastName = resultSet.getString("lname");

			// Displaying or printing values
			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + firstName);
			System.out.println(", Last: " + lastName);
		}
		System.out.println();
		resultSet.close();
	}// end of printTableUsingResultSet()
}
