package com.bridgelabz.jdbc.jdbcprograms;
/***********************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Class.forName  Example
 *
 ************************************************************************************/
public class SampleClass 
{
		//Static Block
		static 
		{
			System.out.println("In Static block");
		}
		//Instance Block
		{
			System.out.println("In Instance Block");
		}
	
	public static void main(String[] args) throws Exception 
	{
	
		// SampleClass s=new SampleClass();  // Before you are creating the object it will first load the class
		// While loading the class it will call static
		// While Creating a Object it will execute instance block //output-In Static  Block
																  //       In Instance Block
		
	    //Class.forName("SampleClass");  // Calling only static block
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//Instead we are directly loading the driver class
	    Class.forName("com.mysql.jdbc.Driver");   //whenever you call Class.forName it will load the driver class
												 // and whenever driver class loads it will load the static block
												// and whenever it will load the static black it will register the driver
	}				
}

