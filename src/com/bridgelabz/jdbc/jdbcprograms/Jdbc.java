package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
import com.mysql.jdbc.Connection;
/***********************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Normal Statement Example
 *
 ************************************************************************************/
public class Jdbc
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		String url = "jdbc:mysql://localhost:3306/EmployeeData";
		String uname = "root";
		String pass = "root";
		String query = "select * from employee";

		Class.forName("com.mysql.jdbc.Driver"); //Registering the driver

		Connection con = (Connection) DriverManager.getConnection(url, uname, pass);//Establishing Connection

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		while (rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String dept = rs.getString("dept");
			String salary = rs.getString("salary");
			System.out.println(id + "\t" + name + "\t\t" + dept + "\t" + salary);
		}

		st.close();
		con.close();
	}
}
