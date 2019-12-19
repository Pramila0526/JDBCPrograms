package com.bridgelabz.jdbc.addressbook;
import java.sql.*;

public class AddressBookUsingJDBC 
{
public static void print() throws ClassNotFoundException, SQLException
{
	DBConnection db=new DBConnection();
	Connection connection = db.getConnection();
	Statement st=connection.createStatement();
	for(int i=0;i< st.executeBatch().length;i++)
	{
     }
}
}