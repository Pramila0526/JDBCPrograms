package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
/********************************************************************************************
 * @author :Pramila0526 
 * Purpose :Batch Processing Using insert update delete
 *
 *****************************************************************************************/
public class BatchProcessing 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		BatchProcessing b= new BatchProcessing();
		int[] result = b.executeAllQuery();
		for (int i = 0; i < result.length; i++)
		{
			System.out.println(result[i]);
		}
	}
	public int[] executeAllQuery() throws SQLException, ClassNotFoundException
	{
		Statement st;
		DBConnection con = new DBConnection();
		String query = "insert into employeetransaction values(212,26,'Shweta','Mone')";
		
		String queryDelete = "delete from employeetransaction where empid=200";
		
		String queryUpdate = "update employeetransaction set fname='mansi' where empid=108";
			
		Connection	connection = con.getConnection();
		//connection.setAutoCommit(false);
		
		st = connection.createStatement();
		st.addBatch(query);
		st.addBatch(queryDelete);
		st.addBatch(queryUpdate);
		//connection.commit();
		return st.executeBatch();
	}


}