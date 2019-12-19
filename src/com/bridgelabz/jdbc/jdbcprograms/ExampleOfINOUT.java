package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
/************************************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Callable and Stored Procedure Using IN
 *
 ***********************************************************************************************************/
public class ExampleOfINOUT
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver"); // Registering the driver
		Connection con = DriverManager.getConnection( // Establishing Connection
				"jdbc:mysql://localhost:3306/StockItems", "root", "root"); // URL,Username,Password

		CallableStatement stmt = con.prepareCall("{call stockprocedureinout(?)}");
		String sname="book";
		stmt.setString(1,sname);
		stmt.execute();
		
		stmt.close();
		con.close();
	}
}

