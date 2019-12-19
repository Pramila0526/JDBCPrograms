package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/************************************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Callable and Stored Procedure Using IN
 *
 ***********************************************************************************************************/
public class ExampleOfIN 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver"); // Registering the driver
		Connection con = DriverManager.getConnection( // Establishing Connection
				"jdbc:mysql://localhost:3306/StockItems", "root", "root"); // URL,Username,Password

		CallableStatement stmt = con.prepareCall("{call myproc(?)}");
		stmt.setString(1,"Pen");
		ResultSet rs = stmt.executeQuery();

		while (rs.next())
		{
			int sid = rs.getInt("stockid");
			String sname = rs.getString("stockname");
			String sprice = rs.getString("price");
			System.out.println(sid + "\t" + sname + "\t\t" + sprice + "\t");
		}
		stmt.close();
		con.close();
	}
}

/**
 * ===Create Procedure Query for above Program======== 
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `myproc`(IN sname VARCHAR(50))
 *  BEGIN
 * SELECT * FROM Stocks WHERE stockname=sname; 
 * END
 *
 *Query to Call=====
 *call myproc('Pen');
 */
