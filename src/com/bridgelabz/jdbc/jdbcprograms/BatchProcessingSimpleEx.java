package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
/********************************************************************************************
 * @author :Pramila0526
 * Purpose :Batch Processing Simple Example
 *
 *****************************************************************************************/
class BatchProcessingSimpleEx
{
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		con.setAutoCommit(false);  //It will not commit automatically

		Statement stmt = con.createStatement();
		stmt.addBatch("insert into employeetransaction values(190,23,'Abhi','Nemade')");
		stmt.addBatch("insert into employeetransaction values(191,26,'Sarika','Vaidya')");
		//2 Queries are added in the batch
		stmt.executeBatch();// executing the queries from batch
		System.out.println("Executed Successfully");
		con.commit();
		con.close();
	}
}