package com.bridgelabz.jdbc.addressbook;
import java.sql.*;
/********************************************************************************************
 * @author :Pramila0526
 * Purpose :Simple Example
 *
 *****************************************************************************************/
public class StoredProcedure {
    public static void getSkills(int candidateId) throws ClassNotFoundException {
        // 
    	Class.forName("com.mysql.jdbc.Driver");  
        String query = "{call empProc(?,?,?,?)}";
 
        try (Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeData","root","root");
                CallableStatement stmt = (CallableStatement) conn.prepareCall(query)) {
        	stmt.setInt(1,111);  
        	stmt.setString(2,"Kajal");  
        	stmt.setString(3,"IT");  
        	stmt.setInt(4,78954);  
 
        	ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
        		String name = rs.getString("name");
        		String dept = rs.getString("dept");
        		String salary = rs.getString("salary");
        		System.out.println(id + "\t" + name + "\t\t" + dept + "\t" + salary);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    public static void main(String[] args) throws ClassNotFoundException {
        getSkills(122);
    }
}