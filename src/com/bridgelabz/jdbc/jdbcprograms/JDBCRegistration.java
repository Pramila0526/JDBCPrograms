package com.bridgelabz.jdbc.jdbcprograms;
import java.sql.*;
import com.bridgelabz.jdbc.utility.Utility;
import com.mysql.jdbc.Connection;
/***********************************************************************************************************
 * @author :Pramila0526 
 * Purpose :JDBC Login And Registration Using Unique ID
 *
 **********************************************************************************************************/
public class JDBCRegistration
{
		public static void main(String[] args) throws ClassNotFoundException, SQLException 
		{
			Class.forName("com.mysql.jdbc.Driver");  //Registering the Driver
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");//Establishing the Connection
			
			System.out.println("====Options For Login Registration====\n");
			System.out.println("  	Press 1 For Registration");
			System.out.println("---------------------------------");
			System.out.println("  	Press 2 For Login");
			System.out.println("---------------------------------");
			System.out.println("	Press 3 For Exit");
			System.out.println("---------------------------------");
			
			int ch=Utility.integerInput();
			switch(ch)
			{
			case 1:
				System.out.println("====Registration Page====");
				String sqlQuery="insert into employeetransaction values(?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sqlQuery);
				System.out.println("Enter Employee Id");
				int id=Utility.integerInput();
				System.out.println("Enter age");
				int age=Utility.integerInput();
				System.out.println("Enter First Name");
				String fname=Utility.stringInput();
				System.out.println("Enter Last Name");
				String lname=Utility.stringInput();
				
				stmt.setInt(1, id); 	// 1 specifies the first parameter in the query
				stmt.setInt(2, age);
				stmt.setString(3, fname);
				stmt.setString(4, lname);
				stmt.executeUpdate();
				break;
				
			case 2:
				System.out.println("====Login Page====\n");
				System.out.println("Enter Your Unique Id to Display Your data");
				int checkId=Utility.integerInput();
				String sql="select * from employeetransaction";
				PreparedStatement stmt1 = con.prepareStatement(sql);
				ResultSet rs1 = stmt1.executeQuery();
				
					while(rs1.next())
					{
						//Checking whether the Entered Id Matches the Column data
						if(rs1.getInt(1)==checkId)
						{
							int empId = rs1.getInt("empid");
							int empAge = rs1.getInt("age");
							String fName = rs1.getString("fname");
							String lName = rs1.getString("lname");
							System.out.println(empId + "\t" + empAge + "\t\t" + fName + "\t" +lName+ "\t");
						}
						else
						{
						System.out.println("Please Enter Valid ID");	
						break;
						}
					}
				break;
				
			case 3:
				System.out.println("Thank You!!!");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

