package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
/********************************************************************************************
 * @author :Pramila0526 
 * Purpose :Batch Processing Using Callable Statement
 *
 *****************************************************************************************/
public class BatchProcessingUsingCallable
{
	static Connection connection = null;
	static PreparedStatement pstmt = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		String storedProcedureQuery = "CALL batchProc(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			CallableStatement pstmt = connection.prepareCall(storedProcedureQuery);
			// to prevent from automatically commit
			connection.setAutoCommit(false);

			pstmt.setInt(1, 149);
			pstmt.setInt(2, 26);
			pstmt.setString(3, "Kriti");
			pstmt.setString(4, "Gupta");
			pstmt.addBatch();         

			pstmt.setInt(1, 146);
			pstmt.setInt(2, 25);
			pstmt.setString(3, "Kirti");
			pstmt.setString(4, "Pawar");
			pstmt.addBatch();

			pstmt.executeBatch();
			connection.commit();
			// select all the records and display them.
			printTableUsingResultSet(pstmt);

			// Clean-up environment
			pstmt.close();
			connection.close();
		} catch (SQLException sqlException) 
		{
			// Handle errors for JDBC
			sqlException.printStackTrace();
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (pstmt != null)
					pstmt.close();
			} 
			catch (SQLException sqlException2) 
			{
				System.out.println(sqlException2);
			}
			try 
			{
				if (connection != null)
					connection.close();
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			} 
		} 
		System.out.println("All Done!!!!");
	}

	public static void printTableUsingResultSet(Statement stmt) throws SQLException
	{
		int id=0;
		int age=0;
		String firstName=" ";
		String lastName=" ";
		System.out.println("=====Data Form employeetransaction Table=====");
		// Selecting all the records and display them.
		String sql = "select * from employeetransaction";
		ResultSet resultset = stmt.executeQuery(sql);

		while (resultset.next()) 
		{
			// Retrieve by column name
			id = resultset.getInt("empid");
			age = resultset.getInt("age");
			firstName = resultset.getString("fname");
			lastName = resultset.getString("lname");

			// Displaying or printing values
			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + firstName);
			System.out.println(", Last: " + lastName);
		}
		System.out.println();
		resultset.close();
	}// end of printTableUsingResultSet()
}
