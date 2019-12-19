package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
/************************************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Callable and Stored Procedure Using OUT
 *
 *************************************************************************************************************/
public class ExampleOfOUT {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); // Registering the driver
		Connection con = DriverManager.getConnection( // Establishing Connection
				"jdbc:mysql://localhost:3306/StockItems", "root", "root"); // URL,Username,Password

		CallableStatement stmt = con.prepareCall("{call stockproc(?,?)}");
		stmt.setString(1, "yes");
		stmt.registerOutParameter(2, Types.INTEGER);
		stmt.executeQuery();
		int count = stmt.getInt(2);
		System.out.println("Status of Stocks\n" + count);

		stmt.close();
		con.close();
	}
}
/**
 * procedure using OUT====
 * 
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `stockproc`
 * ( IN priceStatus
 * VARCHAR(25), OUT total INT )
 *  BEGIN 
 *  SELECT COUNT(price) INTO total FROM Stocks
 * WHERE soldstatus = priceStatus; 
 * END
 * 
 * //Query to call
 * 
 * CALL stockproc('no',@total);
 * SELECT @total;
 *
 */
